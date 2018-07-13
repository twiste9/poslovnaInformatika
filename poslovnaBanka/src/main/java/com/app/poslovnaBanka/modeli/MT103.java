package com.app.poslovnaBanka.modeli;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MT103 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(nullable = false)
	protected String swiftDuznik;

	@Column(nullable = false)
	protected String swiftPoverioc;

	@Column(nullable = false)
	protected String obracunskiPoverioca;

	@Column(nullable = false)
	protected String obracunskiDuznika;

	@Column(nullable = false)
	protected String duznikNalogodavac;

	@Column(nullable = false)
	protected String svrhaPlacanja;

	@Column(nullable = false)
	protected String primalacPoverilac;

	@Column(nullable = false)
	protected Date datumNaloga;

	@Column(nullable = false)
	protected Date datumValute;

	@Column(nullable = false)
	protected String racunDuznika;

	@Column(nullable = false)
	protected int modelZaduzenja;

	@Column(nullable = false)
	protected String pozivNaBrojZaduzenja;

	@Column(nullable = false)
	protected String racunPoverioca;

	@Column(nullable = false)
	protected int modelOdobrenja;

	@Column(nullable = false)
	protected String pozivNaBrojOdobrenja;

	@Column(nullable = false)
	protected double iznos;

	@Column(nullable = false)
	protected String sifraValute;

	public MT103() {

	}
	
	public MT103(TekuciRacun trPrimaoca, TekuciRacun trNalogodavca, NalogZaPrenos nzp, String bankaPrim,String bakaNal) {
		super();
		this.swiftDuznik = trNalogodavca.getBanka().getSwiftCode();
		this.swiftPoverioc = trPrimaoca.getBanka().getSwiftCode();
		this.obracunskiPoverioca = bankaPrim;
		this.obracunskiDuznika = bakaNal;
		this.duznikNalogodavac = nzp.getNalogodavac();
		this.svrhaPlacanja = nzp.getSvrhaPlacanja();
		this.primalacPoverilac = nzp.getPrimalac();
		this.datumNaloga = new Date();
		this.datumValute = new Date();
		this.racunDuznika = trNalogodavca.getBrojRacuna();
		this.modelZaduzenja = nzp.getModelNalogodavca();
		this.pozivNaBrojZaduzenja = nzp.getPozivNaBrojNalogodavca();
		this.racunPoverioca = trPrimaoca.getBrojRacuna();
		this.modelOdobrenja = nzp.getModelPrimaoca();
		this.pozivNaBrojOdobrenja = nzp.getPozivNaBrojPrimaoca();
		this.iznos = nzp.getIznos();
		this.sifraValute = nzp.getValutaSifra();
	}

	public MT103(String swiftDuznik, String swiftPoverioc, String obracunskiPoverioca, String obracunskiDuznika,
			String duznikNalogodavac, String svrhaPlacanja, String primalacPoverilac, Date datumNaloga,
			Date datumValute, String racunDuznika, int modelZaduzenja, String pozivNaBrojZaduzenja,
			String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja, double iznos, String sifraValute) {
		super();
		this.swiftDuznik = swiftDuznik;
		this.swiftPoverioc = swiftPoverioc;
		this.obracunskiPoverioca = obracunskiPoverioca;
		this.obracunskiDuznika = obracunskiDuznika;
		this.duznikNalogodavac = duznikNalogodavac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.primalacPoverilac = primalacPoverilac;
		this.datumNaloga = datumNaloga;
		this.datumValute = datumValute;
		this.racunDuznika = racunDuznika;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
		this.racunPoverioca = racunPoverioca;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.iznos = iznos;
		this.sifraValute = sifraValute;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getSwiftDuznik() {
		return swiftDuznik;
	}

	public void setSwiftDuznik(String swiftDuznik) {
		this.swiftDuznik = swiftDuznik;
	}

	public String getSwiftPoverioc() {
		return swiftPoverioc;
	}

	public void setSwiftPoverioc(String swiftPoverioc) {
		this.swiftPoverioc = swiftPoverioc;
	}

	public String getObracunskiPoverioca() {
		return obracunskiPoverioca;
	}

	public void setObracunskiPoverioca(String obracunskiPoverioca) {
		this.obracunskiPoverioca = obracunskiPoverioca;
	}

	public String getObracunskiDuznika() {
		return obracunskiDuznika;
	}

	public void setObracunskiDuznika(String obracunskiDuznika) {
		this.obracunskiDuznika = obracunskiDuznika;
	}

	public String getDuznikNalogodavac() {
		return duznikNalogodavac;
	}

	public void setDuznikNalogodavac(String duznikNalogodavac) {
		this.duznikNalogodavac = duznikNalogodavac;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public String getPrimalacPoverilac() {
		return primalacPoverilac;
	}

	public void setPrimalacPoverilac(String primalacPoverilac) {
		this.primalacPoverilac = primalacPoverilac;
	}

	public Date getDatumNaloga() {
		return datumNaloga;
	}

	public void setDatumNaloga(Date datumNaloga) {
		this.datumNaloga = datumNaloga;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public int getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(int modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public int getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(int modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
