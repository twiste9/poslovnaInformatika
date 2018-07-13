package com.app.poslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.Valuta;

@Repository
public interface ValutaRepository extends JpaRepository<Valuta, Long>{
	Valuta findBySifra(String sifra);
}
