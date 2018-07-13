package com.app.poslovnaBanka.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.poslovnaBanka.modeli.Banka;
import com.app.poslovnaBanka.modeli.DnevnoStanjeRacuna;
import com.app.poslovnaBanka.modeli.MT102;
import com.app.poslovnaBanka.modeli.NalogZaPrenos;
import com.app.poslovnaBanka.modeli.Poruka;
import com.app.poslovnaBanka.modeli.TekuciRacun;
import com.app.poslovnaBanka.repository.BankaRepository;
import com.app.poslovnaBanka.repository.DnevnoStanjeRacunaRepository;
import com.app.poslovnaBanka.repository.MT102Repository;
import com.app.poslovnaBanka.repository.NalogZaPrenosRepository;
import com.app.poslovnaBanka.repository.PorukaRepository;
import com.app.poslovnaBanka.repository.TekuciRacunRepository;

@Component
public class ScheduledTasks {
	

	@Autowired
	TekuciRacunRepository trRepository;
	
	@Autowired
	DnevnoStanjeRacunaRepository dsrRepository;
	
	@Autowired
	BankaRepository bankaRepository;
	
	@Autowired
	MT102Repository mt102Repo;
	
	@Autowired
	PorukaRepository porukaRepo;
	
	@Autowired
	NalogZaPrenosRepository nzpRepo;
	
//  prvi je na svaki minut drugi je svaki dan u 00:01
	@Scheduled(cron = "*/45 * * * * *")
	public void createmt102() {
		ArrayList<NalogZaPrenos> noviNalozi = nzpRepo.findByHitnoIsFalseAndMt102IDIsNullAndIznosLessThan(250000.0);
		if(noviNalozi.isEmpty()) {
			return;
		}
		
		HashMap<Banka,ArrayList<NalogZaPrenos>> mapa = new HashMap<Banka,ArrayList<NalogZaPrenos>>(); 
		for(NalogZaPrenos na : noviNalozi) {
			TekuciRacun t =  trRepository.findByBrojRacuna(na.getRacunPrimaoca());
			if(!mapa.containsKey(t.getBanka())) {
				mapa.put(t.getBanka(), new ArrayList<NalogZaPrenos>());
			}
			mapa.get(t.getBanka()).add(na);
		}
		
		for(Banka b : mapa.keySet()) {
			NalogZaPrenos n = mapa.get(b).get(0);
			
			TekuciRacun trNalogodavca =  trRepository.findByBrojRacuna(n.getRacunNalogodavca());
			TekuciRacun trPrimaoca =  trRepository.findByBrojRacuna(n.getRacunPrimaoca());
			TekuciRacun trBankePrimaoca =  trRepository.findByBankaAndKlijentIsNull(trPrimaoca.getBanka());
			TekuciRacun trBankeNalogodavca =  trRepository.findByBankaAndKlijentIsNull(trNalogodavca.getBanka());
			
			MT102 mt102 = new MT102(trNalogodavca.getBanka().getSwiftCode(),trPrimaoca.getBanka().getSwiftCode(),
									trBankePrimaoca.getBrojRacuna(),trBankeNalogodavca.getBrojRacuna(),
									0.0,n.getValuta().getSifra(),new Date(),new Date());
			
			for(NalogZaPrenos na : mapa.get(b)) {
				mt102.setUkupanIznos(mt102.getUkupanIznos()+na.getIznos());
			}
			mt102 = mt102Repo.save(mt102);
			
			Banka bankaNal = trNalogodavca.getBanka();
			Banka bankaPri = trPrimaoca.getBanka();
			//skinuti pare sa banke..
			ArrayList<DnevnoStanjeRacuna> dsbankaNal = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trBankeNalogodavca);
			DnevnoStanjeRacuna poslednjestanjeBankeNal =dsbankaNal.get(0);
			
			ArrayList<DnevnoStanjeRacuna> dsbankaPri = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trBankePrimaoca);
			DnevnoStanjeRacuna poslednjestanjeBankePri =dsbankaPri.get(0);
			
			//prebacivanje sa jedne banke na drugu
			DnevnoStanjeRacuna novoNal = new DnevnoStanjeRacuna(new Date(), poslednjestanjeBankeNal.getNovoStanje(),0.0,mt102.getUkupanIznos(),poslednjestanjeBankeNal.getNovoStanje()-mt102.getUkupanIznos(),trBankeNalogodavca);
			DnevnoStanjeRacuna novoPri = new DnevnoStanjeRacuna(new Date(), poslednjestanjeBankePri.getNovoStanje(),mt102.getUkupanIznos(),0.0,poslednjestanjeBankePri.getNovoStanje()+mt102.getUkupanIznos(),trBankePrimaoca);
			
			dsrRepository.save(novoNal);
			dsrRepository.save(novoPri);
			
			Poruka poruka = new Poruka("MT900",bankaNal.getSwiftCode(),trBankeNalogodavca.getBrojRacuna(),mt102.getId(),new Date(),mt102.getUkupanIznos(),mt102.getSifraValute());
			porukaRepo.save(poruka);
			Poruka poruka2 = new Poruka("MT910",bankaPri.getSwiftCode(),trBankePrimaoca.getBrojRacuna(),mt102.getId(),new Date(),mt102.getUkupanIznos(),mt102.getSifraValute());
			porukaRepo.save(poruka2);
			for(NalogZaPrenos na : mapa.get(b)) {
				
				na.setMt102ID(mt102.getId());
				nzpRepo.save(na);
				
				trNalogodavca =  trRepository.findByBrojRacuna(na.getRacunNalogodavca());
				trPrimaoca =  trRepository.findByBrojRacuna(na.getRacunPrimaoca());
				ArrayList<DnevnoStanjeRacuna> dsNala = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trNalogodavca);
				DnevnoStanjeRacuna dsNal =dsNala.get(0);
				DnevnoStanjeRacuna dsP = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trPrimaoca).get(0);
				
				//skidanje para sa racuna nalogodavca i prebacivanje na racun banke
				
				DnevnoStanjeRacuna novoNal1 = new DnevnoStanjeRacuna(new Date(), dsNal.getNovoStanje(),0.0,na.getIznos(),dsNal.getNovoStanje()-na.getIznos(),trNalogodavca);
				DnevnoStanjeRacuna novoBankeNal = new DnevnoStanjeRacuna(new Date(), novoNal.getNovoStanje(),na.getIznos(),0.0,novoNal.getNovoStanje()+na.getIznos(),trBankeNalogodavca);
				dsrRepository.save(novoNal1);
				dsrRepository.save(novoBankeNal);
				
				//prebacivanje sa banke primaoca na racun primaoca
				
				
				DnevnoStanjeRacuna novoPrim = new DnevnoStanjeRacuna(new Date(), dsP.getNovoStanje(),na.getIznos(),0.0,dsP.getNovoStanje()+na.getIznos(),trPrimaoca);
				DnevnoStanjeRacuna novoBankePrim = new DnevnoStanjeRacuna(new Date(), novoPri.getNovoStanje(),0.0,na.getIznos(),novoPri.getNovoStanje()-na.getIznos(),trBankePrimaoca);
				dsrRepository.save(novoPrim);
				dsrRepository.save(novoBankePrim);
			}
			
		}
		
		
	}
}
