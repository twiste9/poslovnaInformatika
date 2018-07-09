package com.app.poslovnaBanka.modeli;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class MT102 implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Version
	protected Long version;
	
	@Column(nullable = false)
	protected String idPoruke;
	
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
	
	@OneToMany
	protected List<PojedinacnoPlacanje> pojedinacnaPlacanja;
	
	public MT102(){
		
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

	public String getIdPoruke() {
		return idPoruke;
	}

	public void setIdPoruke(String idPoruke) {
		this.idPoruke = idPoruke;
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

	public List<PojedinacnoPlacanje> getPojedinacnaPlacanja() {
		return pojedinacnaPlacanja;
	}

	public void setPojedinacnaPlacanja(List<PojedinacnoPlacanje> pojedinacnaPlacanja) {
		this.pojedinacnaPlacanja = pojedinacnaPlacanja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
