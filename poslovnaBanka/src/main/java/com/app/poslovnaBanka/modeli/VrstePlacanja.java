package com.app.poslovnaBanka.modeli;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VrstePlacanja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "NUMERIC(3)")
	protected Long id;

	@Column(nullable = false, length = 120)
	private String naziv;

	public VrstePlacanja() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
