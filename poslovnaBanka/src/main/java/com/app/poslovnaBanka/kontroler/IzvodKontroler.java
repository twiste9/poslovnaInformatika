package com.app.poslovnaBanka.kontroler;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/izvod")
public class IzvodKontroler {
	
	
	@RequestMapping(value="/preuzmi", method = RequestMethod.GET)
	public ResponseEntity<?> preuzmiIzvod(@RequestParam String brojRacuna, @RequestParam Date datum, @RequestParam int redniBrojPreseka){
		return new ResponseEntity<>("SSSS", HttpStatus.OK);
	}
	

}
