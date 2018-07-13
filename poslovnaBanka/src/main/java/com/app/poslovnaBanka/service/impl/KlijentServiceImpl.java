package com.app.poslovnaBanka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poslovnaBanka.modeli.Klijent;
import com.app.poslovnaBanka.repository.KlijentRepository;
import com.app.poslovnaBanka.service.KlijentService;

@Service
public class KlijentServiceImpl implements KlijentService{

	@Autowired
	KlijentRepository klijentRepository;
	
	@Override
	public Klijent findByEmail(String email) {
		return klijentRepository.findByEmail(email);
	}

}
