package com.app.poslovnaBanka.service;

import java.sql.Date;
import java.util.List;

import com.app.poslovnaBanka.modeli.AnalitikaIzvoda;

public interface IzvodService {

	List<AnalitikaIzvoda> pretraziPoDatumuIRacunu(Date datum, String racun);
}
