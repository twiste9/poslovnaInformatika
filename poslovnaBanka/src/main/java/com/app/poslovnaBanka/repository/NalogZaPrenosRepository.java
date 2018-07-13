package com.app.poslovnaBanka.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.NalogZaPrenos;

@Repository
public interface NalogZaPrenosRepository  extends JpaRepository<NalogZaPrenos, Long> {
	ArrayList<NalogZaPrenos> findByHitnoIsFalseAndMt102IDIsNullAndIznosLessThan(double iznos);
}
