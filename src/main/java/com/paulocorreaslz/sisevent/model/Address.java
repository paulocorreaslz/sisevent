package com.paulocorreaslz.sisevent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "street")
	private String street;

	@Column(name = "placenumber")
	private int placenumber;

	@Column(name = "postalcode")
	private int postalcode;

	public Address() {	
	}
	
	public Address(String street,int placenumber, int postalcode) {
		this.street = street;
		this.placenumber = placenumber;
		this.postalcode = postalcode;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPlacenumber() {
		return placenumber;
	}

	public void setPlacenumber(int placenumber) {
		this.placenumber = placenumber;
	}

	public int getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

}
