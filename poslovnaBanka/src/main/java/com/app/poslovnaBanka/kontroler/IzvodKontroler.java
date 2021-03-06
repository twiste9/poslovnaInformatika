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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.poslovnaBanka.service.impl.IzvodServiceImpl;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping(value = "/izvod")
public class IzvodKontroler {
	
	@Autowired
	IzvodServiceImpl izvodService;
	
	@RequestMapping(value="/preuzmi", method = RequestMethod.GET)
	public ResponseEntity<?> preuzmiIzvod(@RequestParam String brojRacuna, @RequestParam Date datum){
		return new ResponseEntity<>(izvodService.pretraziPoDatumuIRacunu(datum, brojRacuna), HttpStatus.OK);
	}
	
	@RequestMapping(value="/preuzmiPDF", method = RequestMethod.GET)
	public ResponseEntity<?> preuzmiIzvodPDF(@RequestParam String brojRacuna, @RequestParam Date datum){
		
		try {
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:1313/mem:testdb","sa","");

			HashMap<String, Object> mapa = new HashMap<String, Object>();
			mapa.put("broj_racuna", brojRacuna);
			mapa.put("datum_izvoda", datum);
			
			JasperPrint jp = JasperFillManager.fillReport(
			getClass().getResource("report2.jasper").openStream(),
			mapa, conn);
			//eksport
			File pdf = File.createTempFile("output.", ".pdf");
			JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
		}catch (Exception ex) {
				ex.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
