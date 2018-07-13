package com.app.poslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poslovnaBanka.modeli.Banka;

@Repository
public interface BankaRepository  extends JpaRepository<Banka, Long>{

	Banka findByCentralna(boolean b);
	
}
