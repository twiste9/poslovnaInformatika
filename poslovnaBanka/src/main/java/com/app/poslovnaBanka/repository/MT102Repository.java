package com.app.poslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.MT102;

@Repository
public interface MT102Repository  extends JpaRepository<MT102, Long>{

}
