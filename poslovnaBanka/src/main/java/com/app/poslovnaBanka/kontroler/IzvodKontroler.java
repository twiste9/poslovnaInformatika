package com.app.poslovnaBanka.kontroler;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.poslovnaBanka.service.impl.IzvodServiceImpl;

@RestController
@RequestMapping(value = "/izvod")
public class IzvodKontroler {
	
	@Autowired
	IzvodServiceImpl izvodService;
	
	@RequestMapping(value="/preuzmi", method = RequestMethod.GET)
	public ResponseEntity<?> preuzmiIzvod(@RequestParam String brojRacuna, @RequestParam Date datum){
		return new ResponseEntity<>(izvodService.pretraziPoDatumuIRacunu(datum, brojRacuna), HttpStatus.OK);
	}

}
