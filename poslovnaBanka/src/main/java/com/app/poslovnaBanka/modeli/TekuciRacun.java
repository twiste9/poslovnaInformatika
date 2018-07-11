package com.app.poslovnaBanka.modeli;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TekuciRacun implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(nullable = false, length = 18)
	protected String brojRacuna;

	@Column(nullable = false)
	protected boolean vazeci;

	@Column(nullable = false)
	protected Date datumOtvaranja;

	@ManyToOne(optional = false)
	protected Klijent klijent;
	
	@ManyToOne(optional = false)
	protected Banka banka;
	
	@ManyToOne(optional = false)
	protected Valuta valuta;

	public TekuciRacun() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public boolean isVazeci() {
		return vazeci;
	}

	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}
		
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
