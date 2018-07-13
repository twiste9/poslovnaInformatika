package com.app.poslovnaBanka.service;

import com.app.poslovnaBanka.modeli.Klijent;

public interface KlijentService {
	Klijent findByEmail(String email);
}
