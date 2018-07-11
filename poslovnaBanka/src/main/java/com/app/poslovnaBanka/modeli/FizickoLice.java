package com.app.poslovnaBanka.modeli;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FizickoLice extends Klijent {

	@Column(nullable = false)
	protected String ime;

	@Column(nullable = false)
	protected String prezime;

	@Column(nullable = false)
	protected String jmbg;
	
	@Column(unique = true, nullable = false)
	private String brojLicneKarte;

	public FizickoLice() {
		super();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}
	
}
