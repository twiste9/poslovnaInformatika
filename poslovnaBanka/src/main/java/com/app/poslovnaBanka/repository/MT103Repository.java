package com.app.poslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.MT103;

@Repository
public interface MT103Repository extends JpaRepository<MT103, Long>{

}
