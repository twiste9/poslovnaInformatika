package com.app.poslovnaBanka.kontroler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.poslovnaBanka.modeli.Klijent;
import com.app.poslovnaBanka.modeli.NalogZaPrenos;
import com.app.poslovnaBanka.modeli.TekuciRacun;
import com.app.poslovnaBanka.modeli.Valuta;
import com.app.poslovnaBanka.service.impl.BankaServiceImpl;
import com.app.poslovnaBanka.service.impl.KlijentServiceImpl;
import com.app.poslovnaBanka.service.impl.NalogServiceImpl;
import com.app.poslovnaBanka.service.impl.NalogZaPrenosServiceImpl;
import com.app.poslovnaBanka.service.impl.TekuciRacunServiceImpl;
import com.app.poslovnaBanka.service.impl.ValutaServiceImpl;

@RestController
@RequestMapping(value = "/MBT")
public class MBTransferKontroler {

	@Autowired
	KlijentServiceImpl klijentService;
	
	@Autowired
	BankaServiceImpl bankaService;
	
	@Autowired
	NalogZaPrenosServiceImpl nzpService;
	
	@Autowired
	ValutaServiceImpl valutaService;
	
	@Autowired
	TekuciRacunServiceImpl tekuciRacunService;
	
	@Autowired
	NalogServiceImpl nalogService;
	
	@PostMapping("/transfer")
	public ResponseEntity<?> transfer( HttpServletRequest request, @RequestBody NalogZaPrenos nzp){
		if(!isValid(nzp)) {
			return new ResponseEntity<>("Polja nisu validna", HttpStatus.BAD_REQUEST);
		}
		TekuciRacun trPrimaoca = tekuciRacunService.findByBrojRacuna(nzp.getRacunPrimaoca());
		if(trPrimaoca == null) {
			return new ResponseEntity<>("Racun primaoca je nepostojeci", HttpStatus.BAD_REQUEST);
		}
		Klijent logged = (Klijent) request.getSession().getAttribute("user");
		TekuciRacun trNalogodavca = tekuciRacunService.findByKlijent(logged);
		nzp.setRacunNalogodavca(trNalogodavca.getBrojRacuna());
		
		if(trPrimaoca.getBanka().getId().equals(trNalogodavca.getBanka().getId())) {
			//ista banka
			if(istaBankaTransfer(trPrimaoca,trNalogodavca,nzp)) {
				nzpService.save(nzp);
				nalogService.exportNalog(nzp);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>("Transver nije uspeo, error na serverskoj strani.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			//nije ista banka
			if(nzp.getIznos()>250000.0 || nzp.isHitno()) {
				if(rtgsTransfer(trPrimaoca,trNalogodavca,nzp)) {
					nzpService.save(nzp);
					nalogService.exportNalog(nzp);
					return new ResponseEntity<>(HttpStatus.OK);
				}
				return new ResponseEntity<>("Transver nije uspeo, error na serverskoj strani.", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			else {
				if(csTransfer(trPrimaoca,trNalogodavca,nzp)) {
					nalogService.exportNalog(nzp);
					return new ResponseEntity<>(HttpStatus.OK);
				}
				return new ResponseEntity<>("Transver nije uspeo, error na serverskoj strani.", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
	}
	
	private boolean istaBankaTransfer(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp) {
		//prenos u istoj banci, true-> ako je uspesno preneto
		return tekuciRacunService.transfer(trPrimaoca, trNalogodavca, nzp);
	}
	
	private boolean rtgsTransfer(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp) {
		// prenos u razlicitoj banci(vise od 250,000.00 ili je hitno), true-> ako je uspesno preneto
		return tekuciRacunService.transferRTGS(trPrimaoca, trNalogodavca, nzp);
	}
	
	private boolean csTransfer(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp) {
		//TODO: prenos u razlicitoj banci, true-> ako je uspesno preneto
		return tekuciRacunService.transferCS(trPrimaoca, trNalogodavca, nzp);
	}
	
	private boolean isValid(NalogZaPrenos nzp) {
		//TODO: validacija
		Valuta v = valutaService.findBySifra(nzp.getValutaSifra());
		if(v==null) {
			return false;
		}
		nzp.setValuta(v);
		return true;
	}
}
