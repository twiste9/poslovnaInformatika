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
public class DnevnoStanjeRacuna implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(nullable = false)
	protected Date datumPrometa;

	@Column(nullable = false)
	protected double prethodnoStanje;

	@Column(nullable = false)
	protected double prometUKorist;

	@Column(nullable = false)
	protected double prometNaTeret;

	@Column(nullable = false)
	protected double novoStanje;

	@ManyToOne(optional = true)
	private TekuciRacun tekuciRacun;

	public DnevnoStanjeRacuna() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumPrometa() {
		return datumPrometa;
	}

	public void setDatumPrometa(Date datumPrometa) {
		this.datumPrometa = datumPrometa;
	}

	public double getPrethodnoStanje() {
		return prethodnoStanje;
	}

	public void setPrethodnoStanje(double prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}

	public double getPrometUKorist() {
		return prometUKorist;
	}

	public void setPrometUKorist(double prometUKorist) {
		this.prometUKorist = prometUKorist;
	}

	public double getPrometNaTeret() {
		return prometNaTeret;
	}

	public void setPrometNaTeret(double prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}

	public double getNovoStanje() {
		return novoStanje;
	}

	public void setNovoStanje(double novoStanje) {
		this.novoStanje = novoStanje;
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
