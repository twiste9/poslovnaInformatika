package com.app.poslovnaBanka.kontroler;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.poslovnaBanka.DTO.UkidanjeDTO;
import com.app.poslovnaBanka.modeli.TekuciRacun;
import com.app.poslovnaBanka.modeli.Ukidanje;
import com.app.poslovnaBanka.repository.UkidanjeRepository;
import com.app.poslovnaBanka.service.TekuciRacunService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping(value = "/racuni")
public class RacunKontroler {

	@Autowired
	TekuciRacunService tekuciRacunService;
	
	@Autowired
	UkidanjeRepository ukidanjeRepository;
	
	@RequestMapping(value="/preuzmiPDF", method = RequestMethod.GET)
	public ResponseEntity<?> preuzmiIRacuneZaBankuPDF(@RequestParam String nazivBanke){
		
		try {
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:1313/mem:testdb","sa","");

			HashMap<String, Object> mapa = new HashMap<String, Object>();
			mapa.put("naziv_banke", nazivBanke);
			
			JasperPrint jp = JasperFillManager.fillReport(
			getClass().getResource("report1.jasper").openStream(),
			mapa, conn);
			//eksport
			File pdf = File.createTempFile("output.", ".pdf");
			JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
		}catch (Exception ex) {
				ex.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/exportuj", method = RequestMethod.POST)
	public ResponseEntity<?> exportNaloga(@RequestBody UkidanjeDTO dto){
		
		TekuciRacun zaUkinuti = tekuciRacunService.findByBrojRacuna(dto.getUkini());
		TekuciRacun zaPrebaciti = tekuciRacunService.findByBrojRacuna(dto.getPrenesi());
		if(zaUkinuti == null || zaPrebaciti == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Ukidanje ukidanje = new Ukidanje();
		ukidanje.setDatumUkidanja();
		ukidanje.setPrenosNaRacun(dto.getPrenesi());
		ukidanje.setTekuciRacun(zaUkinuti);
		
		ukidanjeRepository.save(ukidanje);
		
		zaUkinuti.setVazeci(false);
		tekuciRacunService.save(zaUkinuti);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
