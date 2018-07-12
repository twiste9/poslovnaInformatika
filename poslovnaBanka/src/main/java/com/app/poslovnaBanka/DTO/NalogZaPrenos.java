package com.app.poslovnaBanka.DTO;

import java.sql.Date;

public class NalogZaPrenos {

	private String nalogodavac;
	
	private String svrhaPlacanja;
	
	private String primalac;
	
	private String mestoPrijema;
	
	private Date datumPrijema;
	
	private String sifraPlacanja;
	
	private String valuta;
	
	private double iznos;
	
	private String racunDuznika;
	
	private String modelZaduzenja;
	
	private String pozivNaBrojZaduzenja;
	
	private String racunPrimaoca;
	
	private String modelOdobrenja;
	
	private String pozivNaBrojOdobrenja;
	
	private Date datumValute;
	
	private boolean hitno;
	
	public NalogZaPrenos() {
		
	}

	public String getNalogodavac() {
		return nalogodavac;
	}

	public void setNalogodavac(String nalogodavac) {
		this.nalogodavac = nalogodavac;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public String getPrimalac() {
		return primalac;
	}

	public void setPrimalac(String primalac) {
		this.primalac = primalac;
	}

	public String getMestoPrijema() {
		return mestoPrijema;
	}

	public void setMestoPrijema(String mestoPrijema) {
		this.mestoPrijema = mestoPrijema;
	}

	public Date getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public String getSifraPlacanja() {
		return sifraPlacanja;
	}

	public void setSifraPlacanja(String sifraPlacanja) {
		this.sifraPlacanja = sifraPlacanja;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public String getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(String modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public String getRacunPrimaoca() {
		return racunPrimaoca;
	}

	public void setRacunPrimaoca(String racunPrimaoca) {
		this.racunPrimaoca = racunPrimaoca;
	}

	public String getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(String modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}
	
	
}
