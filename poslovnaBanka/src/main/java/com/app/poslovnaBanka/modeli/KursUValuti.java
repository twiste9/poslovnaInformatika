package com.app.poslovnaBanka.modeli;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KursUValuti implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(nullable = false)
	protected double kupovni;

	@Column(nullable = false)
	protected double prodajni;

	@Column(nullable = false)
	protected double srednji;

	@ManyToOne(optional = true)
	protected Valuta osnovnaValuta;

	@ManyToOne(optional = true)
	protected Valuta premaValuti;

	@ManyToOne(optional = true)
	protected KursnaLista kursnaLista;

	public KursUValuti() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	public Valuta getOsnovnaValuta() {
		return osnovnaValuta;
	}

	public void setOsnovnaValuta(Valuta osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}

	public Valuta getPremaValuti() {
		return premaValuti;
	}

	public void setPremaValuti(Valuta premaValuti) {
		this.premaValuti = premaValuti;
	}

	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
