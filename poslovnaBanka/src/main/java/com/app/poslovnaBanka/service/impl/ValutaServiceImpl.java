package com.app.poslovnaBanka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poslovnaBanka.modeli.Valuta;
import com.app.poslovnaBanka.repository.ValutaRepository;
import com.app.poslovnaBanka.service.ValutaService;

@Service
public class ValutaServiceImpl implements ValutaService{

	@Autowired
	ValutaRepository valutaRepository;
	
	@Override
	public Valuta findBySifra(String sifra) {
		return valutaRepository.findBySifra(sifra);
	}

}
