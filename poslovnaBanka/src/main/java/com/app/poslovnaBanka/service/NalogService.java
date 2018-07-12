package com.app.poslovnaBanka.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.poslovnaBanka.DTO.NalogZaPrenos;

public interface NalogService {

	void export(NalogZaPrenos nalog);
	
	NalogZaPrenos importuj(MultipartFile file);
	
}
