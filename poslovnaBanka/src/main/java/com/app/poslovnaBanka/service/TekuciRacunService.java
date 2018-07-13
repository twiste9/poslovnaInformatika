package com.app.poslovnaBanka.service;

import com.app.poslovnaBanka.modeli.TekuciRacun;

public interface TekuciRacunService {

	public TekuciRacun save(TekuciRacun tekuciRacun);

	public TekuciRacun findByBrojRacuna(String tekuciRacun);
}
