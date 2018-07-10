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

	@Column(nullable = false)
	protected String brojRacuna;

	@Column(nullable = false)
	protected boolean vazeci;

	@Column(nullable = false)
	protected Date datumOtvaranja;

	@ManyToOne(optional = true)
	protected PravnoLice pravnoLice;

	@ManyToOne(optional = true)
	protected FizickoLice fizickoLice;

	@Column(nullable = false)
	protected String tipLica;

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

	public PravnoLice getPravnoLice() {
		return pravnoLice;
	}

	public void setPravnoLice(PravnoLice pravnoLice) {
		this.pravnoLice = pravnoLice;
	}

	public FizickoLice getFizickoLice() {
		return fizickoLice;
	}

	public void setFizickoLice(FizickoLice fizickoLice) {
		this.fizickoLice = fizickoLice;
	}

	public String getTipLica() {
		return tipLica;
	}

	public void setTipLica(String tipLica) {
		this.tipLica = tipLica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
