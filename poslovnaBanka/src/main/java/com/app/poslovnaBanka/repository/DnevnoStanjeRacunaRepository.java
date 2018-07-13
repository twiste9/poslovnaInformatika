package com.app.poslovnaBanka.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.DnevnoStanjeRacuna;
import com.app.poslovnaBanka.modeli.TekuciRacun;

@Repository
public interface DnevnoStanjeRacunaRepository extends JpaRepository<DnevnoStanjeRacuna, Long>{
	
	//@Query("SELECT 1 FROM DnevnoStanjeRacuna r where r.tekuciRacun = :tekuciRacun ORDER BY r.datumPrometa DESC")
	ArrayList<DnevnoStanjeRacuna> findByTekuciRacunOrderByDatumPrometaDesc(TekuciRacun tekuciRacun);
}
