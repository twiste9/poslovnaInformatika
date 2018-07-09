package com.app.poslovnaBanka.modeli;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class NaseljenoMesto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Version
	protected Long version;
	
	@Column(nullable = false)
	protected String naziv;
	
	@Column(nullable = false)
	protected String pttOznaka;
	
	@ManyToOne(optional = true)
	private Drzava drzava;
	
	public NaseljenoMesto(){
		
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

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPttOznaka() {
		return pttOznaka;
	}

	public void setPttOznaka(String pttOznaka) {
		this.pttOznaka = pttOznaka;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
}
