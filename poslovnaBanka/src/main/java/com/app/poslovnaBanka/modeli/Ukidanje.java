package com.app.poslovnaBanka.modeli;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Ukidanje implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Version
	protected Long version;
	
	@Column(nullable = false)
	protected Date datumUkidanja;
	
	@Column(nullable = false)
	protected String prenosNaRacun;
	
	@OneToOne(optional = true)
	private TekuciRacun tekuciRacun;
	
	public Ukidanje(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getDatumUkidanja() {
		return datumUkidanja;
	}

	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}

	public String getPrenosNaRacun() {
		return prenosNaRacun;
	}

	public void setPrenosNaRacun(String prenosNaRacun) {
		this.prenosNaRacun = prenosNaRacun;
	}

	public TekuciRacun getTekuciRacun() {
		return tekuciRacun;
	}

	public void setTekuciRacun(TekuciRacun tekuciRacun) {
		this.tekuciRacun = tekuciRacun;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
