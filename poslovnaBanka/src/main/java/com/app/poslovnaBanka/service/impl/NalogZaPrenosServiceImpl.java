package com.app.poslovnaBanka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poslovnaBanka.modeli.NalogZaPrenos;
import com.app.poslovnaBanka.repository.NalogZaPrenosRepository;
import com.app.poslovnaBanka.service.NalogZaPrenosService;

@Service
public class NalogZaPrenosServiceImpl implements NalogZaPrenosService{

	@Autowired
	NalogZaPrenosRepository nzpRepos;
	
	@Override
	public NalogZaPrenos save(NalogZaPrenos nzp) {
		return nzpRepos.save(nzp);
	}

}
