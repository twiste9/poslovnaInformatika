package com.app.poslovnaBanka.service;

import com.app.poslovnaBanka.modeli.Klijent;
import com.app.poslovnaBanka.modeli.NalogZaPrenos;
import com.app.poslovnaBanka.modeli.TekuciRacun;

public interface TekuciRacunService {

	public TekuciRacun save(TekuciRacun tekuciRacun);

	public TekuciRacun findByBrojRacuna(String tekuciRacun);
	TekuciRacun findByKlijent(Klijent klijent);
	boolean transfer(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp);
	boolean transferRTGS(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp);
	boolean transferCS(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp);
}
