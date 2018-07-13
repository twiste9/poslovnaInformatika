package com.app.poslovnaBanka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poslovnaBanka.modeli.TekuciRacun;
import com.app.poslovnaBanka.repository.TekuciRacunRepository;
import com.app.poslovnaBanka.service.TekuciRacunService;

@Service
public class TekuciRacunServiceImpl implements TekuciRacunService{

	@Autowired
	private TekuciRacunRepository tekuciRacunRepository;
	
	@Override
	public TekuciRacun save(TekuciRacun tekuciRacun) {
		// TODO Auto-generated method stub
		return tekuciRacunRepository.save(tekuciRacun);
	}

	@Override
	public TekuciRacun findByBrojRacuna(String tekuciRacun) {
		// TODO Auto-generated method stub
		return tekuciRacunRepository.findByBrojRacuna(tekuciRacun);
	}

}
