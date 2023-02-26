package com.example.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bike")
public class Bike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Bikename")
	private String BikeName;

	@Column(name = "model")
	private String Model;
	
	@Column(name = "founder")
	private String Founder;
	
	public Bike() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBikeName() {
		return BikeName;
	}

	public void setBikeName(String bikeName) {
		BikeName = bikeName;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getFounder() {
		return Founder;
	}

	public void setFounder(String founder) {
		Founder = founder;
	}

	public Bike(long id, String bikeName, String model, String founder) {
		super();
		this.id = id;
		BikeName = bikeName;
		Model = model;
		Founder = founder;
	}
	
	
}