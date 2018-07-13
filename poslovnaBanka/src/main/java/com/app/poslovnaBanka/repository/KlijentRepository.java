package com.app.poslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.Klijent;

@Repository
public interface KlijentRepository extends JpaRepository<Klijent, Long> {
	Klijent findByEmail(String email);
}
