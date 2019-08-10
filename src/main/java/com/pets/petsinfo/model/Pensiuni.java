package com.pets.petsinfo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Pensiuni.findOrase", query = "SELECT DISTINCT oras FROM Pensiuni")
public class Pensiuni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String oras;
	private String judet;
	private String nume_pensiune;
	private String url;
	private String contact;
	
	public Pensiuni() {
		
	}
	
	public Pensiuni(String nume_pensiune) {
		this.nume_pensiune = nume_pensiune;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOras() {
		return oras;
	}
	public void setOras(String oras) {
		this.oras = oras;
	}
	public String getJudet() {
		return judet;
	}
	public void setJudet(String judet) {
		this.judet = judet;
	}
	public String getNume_pensiune() {
		return nume_pensiune;
	}
	public void setNume_pensiune(String nume_pensiune) {
		this.nume_pensiune = nume_pensiune;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
