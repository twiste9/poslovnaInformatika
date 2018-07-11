package com.app.poslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.poslovnaBanka.modeli.AnalitikaIzvoda;

public interface IzvodRepository extends JpaRepository<AnalitikaIzvoda, Long> {

}
