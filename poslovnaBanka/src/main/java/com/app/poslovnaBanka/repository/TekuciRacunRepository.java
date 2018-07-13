package com.app.poslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.AnalitikaIzvoda;
import com.app.poslovnaBanka.modeli.TekuciRacun;

@Repository
public interface TekuciRacunRepository extends JpaRepository<TekuciRacun, Long> {

	public TekuciRacun findByBrojRacuna(String brojRacuna);
}
