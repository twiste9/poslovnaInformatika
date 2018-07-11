package com.app.poslovnaBanka.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.AnalitikaIzvoda;

@Repository
public interface IzvodRepository extends JpaRepository<AnalitikaIzvoda, Long> {

	List<AnalitikaIzvoda> findByDatumNalogaAndRacunPoveriocaOrDatumNalogaAndRacunDuznika(Date datumNaloga1, String racunPoverioca, Date datumNaloga2, String racunDuznika);
}
