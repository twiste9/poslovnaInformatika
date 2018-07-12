package com.app.poslovnaBanka.DTO;

import org.springframework.web.multipart.MultipartFile;

public class ImportNaloga {
	
	private MultipartFile fajl;

	public ImportNaloga() {
		
	}
	
	public MultipartFile getFajl() {
		return fajl;
	}

	public void setFajl(MultipartFile fajl) {
		this.fajl = fajl;
	}
	
	
}
