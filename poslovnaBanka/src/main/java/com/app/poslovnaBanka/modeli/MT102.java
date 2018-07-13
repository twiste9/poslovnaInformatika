package com.app.poslovnaBanka.modeli;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MT102 implements Serializable {
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
	protected double ukupanIznos;

	@Column(nullable = false)
	protected String sifraValute;

	@Column(nullable = false)
	protected Date datumValute;

	@Column(nullable = false)
	protected Date datum;

	// @OneToMany
	// protected List<PojedinacnoPlacanje> pojedinacnaPlacanja;

	public MT102() {

	}

	public MT102(String swiftDuznik, String swiftPoverioc, String obracunskiPoverioca, String obracunskiDuznika,
			double ukupanIznos, String sifraValute, Date datumValute, Date datum) {
		super();
		this.swiftDuznik = swiftDuznik;
		this.swiftPoverioc = swiftPoverioc;
		this.obracunskiPoverioca = obracunskiPoverioca;
		this.obracunskiDuznika = obracunskiDuznika;
		this.ukupanIznos = ukupanIznos;
		this.sifraValute = sifraValute;
		this.datumValute = datumValute;
		this.datum = datum;
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

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	// public List<PojedinacnoPlacanje> getPojedinacnaPlacanja() {
	// return pojedinacnaPlacanja;
	// }
	//
	// public void setPojedinacnaPlacanja(List<PojedinacnoPlacanje>
	// pojedinacnaPlacanja) {
	// this.pojedinacnaPlacanja = pojedinacnaPlacanja;
	// }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
