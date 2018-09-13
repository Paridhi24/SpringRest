package com.cg.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="PASSPORTNUMBER")
	private String passportNumber;

	
	public Student() {
		super();
	}

	public Student(int id, String name, String passportNumber) {
		super();
	}
	
	public Student( String name, String passportNumber) {
		super();
		this.name= name;
		this.passportNumber =passportNumber; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

}
