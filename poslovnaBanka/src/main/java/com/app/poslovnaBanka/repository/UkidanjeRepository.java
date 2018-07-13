package com.app.poslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.TekuciRacun;
import com.app.poslovnaBanka.modeli.Ukidanje;

@Repository
public interface UkidanjeRepository extends JpaRepository<Ukidanje, Long>{

}
