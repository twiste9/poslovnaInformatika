package com.app.poslovnaBanka.modeli;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Poruka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(nullable = false)
	protected String tipPoruke; // MT900 ili MT910

	@Column(nullable = false)
	protected String idPoruke;

	@Column(nullable = false)
	protected String swiftKodBanke;

	@Column(nullable = false)
	protected String racunBanke;

	@Column(nullable = false)
	protected String idPorukeNaloga; // MT102 ili MT103

	@Column(nullable = false)
	protected Date datumValute;

	@Column(nullable = false)
	protected double iznos;

	@Column(nullable = false)
	protected String sifraValute;

	public Poruka() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipPoruke() {
		return tipPoruke;
	}

	public void setTipPoruke(String tipPoruke) {
		this.tipPoruke = tipPoruke;
	}

	public String getIdPoruke() {
		return idPoruke;
	}

	public void setIdPoruke(String idPoruke) {
		this.idPoruke = idPoruke;
	}

	public String getSwiftKodBanke() {
		return swiftKodBanke;
	}

	public void setSwiftKodBanke(String swiftKodBanke) {
		this.swiftKodBanke = swiftKodBanke;
	}

	public String getRacunBanke() {
		return racunBanke;
	}

	public void setRacunBanke(String racunBanke) {
		this.racunBanke = racunBanke;
	}

	public String getIdPorukeNaloga() {
		return idPorukeNaloga;
	}

	public void setIdPorukeNaloga(String idPorukeNaloga) {
		this.idPorukeNaloga = idPorukeNaloga;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
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
