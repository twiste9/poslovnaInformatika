package com.app.poslovnaBanka.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.poslovnaBanka.DTO.ImportNaloga;
import com.app.poslovnaBanka.DTO.NalogZaPrenos;
import com.app.poslovnaBanka.service.impl.NalogServiceImpl;

@RestController
@RequestMapping(value = "/nalog")
public class NalogKontroler {

	@Autowired
	NalogServiceImpl nalogService;
	
	@RequestMapping(value="/exportuj", method = RequestMethod.POST)
	public ResponseEntity<?> exportNaloga(@RequestBody NalogZaPrenos nalog){
		nalogService.export(nalog);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value="/importuj", method = RequestMethod.POST)
	public ResponseEntity<?> importNaloga(@ModelAttribute ImportNaloga importNaloga){
		return new ResponseEntity<>(nalogService.importuj(importNaloga.getFajl()), HttpStatus.OK);
	}

}