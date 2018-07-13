package com.app.poslovnaBanka.modeli;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class NalogZaPrenos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Column(nullable = false)
	private String nalogodavac;
	
	@Column(nullable = false)
	private String svrhaPlacanja;
	
	@Column(nullable = false)
	private String primalac;
	
	@Column(nullable = false)
	private int sifraPlacanja;
	
	@ManyToOne(optional = false)
	private Valuta valuta;
	
	@Transient
	private String valutaSifra;
	
	@Column(nullable = false)
	private double iznos;
	
	@Column(nullable = false)
	private String racunNalogodavca;
	
	@Column(nullable = true)
	private int modelNalogodavca;
	
	@Column(nullable = true)
	private String pozivNaBrojNalogodavca;
	
	@Column(nullable = false)
	private String racunPrimaoca;
	
	@Column(nullable = true)
	private int modelPrimaoca;
	
	@Column(nullable = true)
	private String pozivNaBrojPrimaoca;
	
	private boolean hitno;
	
	@Column(nullable = true)
	private Long mt102ID;
	
	public NalogZaPrenos() {}
	
	public NalogZaPrenos(NalogZaPrenos n) {
		super();
		this.nalogodavac = n.nalogodavac;
		this.svrhaPlacanja = n.svrhaPlacanja;
		this.primalac = n.primalac;
		this.sifraPlacanja = n.sifraPlacanja;
		this.valuta = n.valuta;
		this.valutaSifra = n.valutaSifra;
		this.iznos = n.iznos;
		this.racunNalogodavca = n.racunNalogodavca;
		this.modelNalogodavca = n.modelNalogodavca;
		this.pozivNaBrojNalogodavca = n.pozivNaBrojNalogodavca;
		this.racunPrimaoca = n.racunPrimaoca;
		this.modelPrimaoca = n.modelPrimaoca;
		this.pozivNaBrojPrimaoca = n.pozivNaBrojPrimaoca;
		this.hitno = n.hitno;
		this.mt102ID = n.mt102ID;
	}
	

	public NalogZaPrenos(String nalogodavac, String svrhaPlacanja, String primalac, int sifraPlacanja, Valuta valuta,
			String valutaSifra, double iznos, String racunNalogodavca, int modelNalogodavca,
			String pozivNaBrojNalogodavca, String racunPrimaoca, int modelPrimaoca, String pozivNaBrojPrimaoca,
			boolean hitno,Long mt102ID) {
		super();
		this.nalogodavac = nalogodavac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.primalac = primalac;
		this.sifraPlacanja = sifraPlacanja;
		this.valuta = valuta;
		this.valutaSifra = valutaSifra;
		this.iznos = iznos;
		this.racunNalogodavca = racunNalogodavca;
		this.modelNalogodavca = modelNalogodavca;
		this.pozivNaBrojNalogodavca = pozivNaBrojNalogodavca;
		this.racunPrimaoca = racunPrimaoca;
		this.modelPrimaoca = modelPrimaoca;
		this.pozivNaBrojPrimaoca = pozivNaBrojPrimaoca;
		this.hitno = hitno;
		this.mt102ID = mt102ID;

	}

	public Long getMt102ID() {
		return mt102ID;
	}

	public void setMt102ID(Long mt102id) {
		mt102ID = mt102id;
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

	public int getSifraPlacanja() {
		return sifraPlacanja;
	}

	public void setSifraPlacanja(int sifraPlacanja) {
		this.sifraPlacanja = sifraPlacanja;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public String getValutaSifra() {
		return valutaSifra;
	}

	public void setValutaSifra(String valutaSifra) {
		this.valutaSifra = valutaSifra;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getRacunNalogodavca() {
		return racunNalogodavca;
	}

	public void setRacunNalogodavca(String racunNalogodavca) {
		this.racunNalogodavca = racunNalogodavca;
	}

	public int getModelNalogodavca() {
		return modelNalogodavca;
	}

	public void setModelNalogodavca(int modelNalogodavca) {
		this.modelNalogodavca = modelNalogodavca;
	}

	public String getPozivNaBrojNalogodavca() {
		return pozivNaBrojNalogodavca;
	}

	public void setPozivNaBrojNalogodavca(String pozivNaBrojNalogodavca) {
		this.pozivNaBrojNalogodavca = pozivNaBrojNalogodavca;
	}

	public String getRacunPrimaoca() {
		return racunPrimaoca;
	}

	public void setRacunPrimaoca(String racunPrimaoca) {
		this.racunPrimaoca = racunPrimaoca;
	}

	public int getModelPrimaoca() {
		return modelPrimaoca;
	}

	public void setModelPrimaoca(int modelPrimaoca) {
		this.modelPrimaoca = modelPrimaoca;
	}

	public String getPozivNaBrojPrimaoca() {
		return pozivNaBrojPrimaoca;
	}

	public void setPozivNaBrojPrimaoca(String pozivNaBrojPrimaoca) {
		this.pozivNaBrojPrimaoca = pozivNaBrojPrimaoca;
	}

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}
	
	}
