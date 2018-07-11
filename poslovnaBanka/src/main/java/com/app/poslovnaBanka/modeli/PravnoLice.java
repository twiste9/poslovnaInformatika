package com.app.poslovnaBanka.modeli;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PravnoLice extends Klijent {

	@Column(nullable = false)
	protected String naziv;

	@Column(nullable = false, length = 9)
	protected String pib;

	@Column(nullable = false, length = 8)
	protected String maticniBroj;

	public PravnoLice() {
		super();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}
}
