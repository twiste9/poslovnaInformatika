package com.app.poslovnaBanka.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poslovnaBanka.modeli.Banka;
import com.app.poslovnaBanka.modeli.DnevnoStanjeRacuna;
import com.app.poslovnaBanka.modeli.Klijent;
import com.app.poslovnaBanka.modeli.MT103;
import com.app.poslovnaBanka.modeli.NalogZaPrenos;
import com.app.poslovnaBanka.modeli.Poruka;
import com.app.poslovnaBanka.modeli.TekuciRacun;
import com.app.poslovnaBanka.repository.BankaRepository;
import com.app.poslovnaBanka.repository.DnevnoStanjeRacunaRepository;
import com.app.poslovnaBanka.repository.MT103Repository;
import com.app.poslovnaBanka.repository.PorukaRepository;
import com.app.poslovnaBanka.repository.TekuciRacunRepository;
import com.app.poslovnaBanka.service.TekuciRacunService;

@Service
public class TekuciRacunServiceImpl implements TekuciRacunService{

	@Autowired
	TekuciRacunRepository trRepository;
	
	@Autowired
	DnevnoStanjeRacunaRepository dsrRepository;
	
	@Autowired
	BankaRepository bankaRepository;
	
	@Autowired
	MT103Repository mt103Repo;
	
	@Autowired
	PorukaRepository porukaRepo;
	
	@Autowired
	NalogZaPrenosServiceImpl nzpService;
	
	@Override
	public TekuciRacun save(TekuciRacun tekuciRacun) {
		// TODO Auto-generated method stub
		return trRepository.save(tekuciRacun);
	}

	@Override
	public TekuciRacun findByBrojRacuna(String tekuciRacun) {
		// TODO Auto-generated method stub
		return trRepository.findByBrojRacuna(tekuciRacun);
	}
	@Override
	public TekuciRacun findByKlijent(Klijent klijent) {
		return trRepository.findByKlijent(klijent);
	}

	@Override
	public boolean transfer(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp) {
		ArrayList<DnevnoStanjeRacuna> dsNala = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trNalogodavca);
		if(dsNala.isEmpty()) {
			return false;
		}
		DnevnoStanjeRacuna dsNal =dsNala.get(0);
		if(dsNal.getNovoStanje()<nzp.getIznos()) {
			return false;
		}
		ArrayList<DnevnoStanjeRacuna> dsNalaa =dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trPrimaoca);
				if(dsNalaa.isEmpty()) {
					return false;
				}
		DnevnoStanjeRacuna dsPri =dsNalaa.get(0);
		
		DnevnoStanjeRacuna novoNal = new DnevnoStanjeRacuna(new Date(), dsNal.getNovoStanje(),0.0,nzp.getIznos(),dsNal.getNovoStanje()-nzp.getIznos(),trNalogodavca);
		DnevnoStanjeRacuna novoPri = new DnevnoStanjeRacuna(new Date(), dsPri.getNovoStanje(),nzp.getIznos(),0.0,dsPri.getNovoStanje()+nzp.getIznos(),trPrimaoca);
		
		dsrRepository.save(novoNal);
		dsrRepository.save(novoPri);
		return true;
		
	}
	
	@Override
	public boolean transferRTGS(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp) {
		ArrayList<DnevnoStanjeRacuna> dsNala = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trNalogodavca);
		if(dsNala.isEmpty()) {
			return false;
		}
		DnevnoStanjeRacuna dsNal =dsNala.get(0);
		if(dsNal.getNovoStanje()<nzp.getIznos()) {
			return false;
		}
		
		TekuciRacun trBankeNal = trRepository.findByBankaAndKlijentIsNull(trNalogodavca.getBanka());
		TekuciRacun trBankePrim = trRepository.findByBankaAndKlijentIsNull(trPrimaoca.getBanka());
		MT103 mt103 = new MT103(trPrimaoca,trNalogodavca,nzp,trBankePrim.getBrojRacuna(),trBankeNal.getBrojRacuna());
		mt103Repo.save(mt103);
		Banka bankaNal = trNalogodavca.getBanka();
		Banka bankaPri = trPrimaoca.getBanka();
		//skinuti pare sa banke..
		ArrayList<DnevnoStanjeRacuna> dsbankaNal = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trBankeNal);
		DnevnoStanjeRacuna poslednjestanjeBankeNal =dsbankaNal.get(0);
		
		ArrayList<DnevnoStanjeRacuna> dsbankaPri = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trBankePrim);
		DnevnoStanjeRacuna poslednjestanjeBankePri =dsbankaPri.get(0);
		
		//prebacivanje sa jedne banke na drugu
		DnevnoStanjeRacuna novoNal = new DnevnoStanjeRacuna(new Date(), poslednjestanjeBankeNal.getNovoStanje(),0.0,nzp.getIznos(),poslednjestanjeBankeNal.getNovoStanje()-nzp.getIznos(),trBankeNal);
		DnevnoStanjeRacuna novoPri = new DnevnoStanjeRacuna(new Date(), poslednjestanjeBankePri.getNovoStanje(),nzp.getIznos(),0.0,poslednjestanjeBankePri.getNovoStanje()+nzp.getIznos(),trBankePrim);
		
		dsrRepository.save(novoNal);
		dsrRepository.save(novoPri);
		
		Poruka poruka = new Poruka("MT900",bankaNal.getSwiftCode(),trBankeNal.getBrojRacuna(),mt103.getId(),new Date(),nzp.getIznos(),nzp.getValutaSifra());
		porukaRepo.save(poruka);
		Poruka poruka2 = new Poruka("MT910",bankaPri.getSwiftCode(),trBankePrim.getBrojRacuna(),mt103.getId(),new Date(),nzp.getIznos(),nzp.getValutaSifra());
		porukaRepo.save(poruka2);
		
		//skidanje para sa racuna nalogodavca i prebacivanje na racun banke
		
		DnevnoStanjeRacuna novoNal1 = new DnevnoStanjeRacuna(new Date(), dsNal.getNovoStanje(),0.0,nzp.getIznos(),dsNal.getNovoStanje()-nzp.getIznos(),trNalogodavca);
		DnevnoStanjeRacuna novoBankeNal = new DnevnoStanjeRacuna(new Date(), novoNal.getNovoStanje(),nzp.getIznos(),0.0,novoNal.getNovoStanje()+nzp.getIznos(),trBankeNal);
		dsrRepository.save(novoNal1);
		dsrRepository.save(novoBankeNal);
		
		//prebacivanje sa banke primaoca na racun primaoca
		
		DnevnoStanjeRacuna dsP = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trNalogodavca).get(0);
		
		DnevnoStanjeRacuna novoPrim = new DnevnoStanjeRacuna(new Date(), dsP.getNovoStanje(),nzp.getIznos(),0.0,dsP.getNovoStanje()+nzp.getIznos(),trPrimaoca);
		DnevnoStanjeRacuna novoBankePrim = new DnevnoStanjeRacuna(new Date(), novoPri.getNovoStanje(),0.0,nzp.getIznos(),novoPri.getNovoStanje()-nzp.getIznos(),trBankePrim);
		dsrRepository.save(novoPrim);
		dsrRepository.save(novoBankePrim);
		
		return true;
		
		
	}

	@Override
	public boolean transferCS(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp) {
		ArrayList<DnevnoStanjeRacuna> dsNala = dsrRepository.findByTekuciRacunOrderByDatumPrometaDesc(trNalogodavca);
		if(dsNala.isEmpty()) {
			return false;
		}
		DnevnoStanjeRacuna dsNal =dsNala.get(0);
		if(dsNal.getNovoStanje()<nzp.getIznos()) {
			return false;
		}
		nzp.setMt102ID(null);
		nzpService.save(nzp);
		return true;
	}

}