package com.hw2.model.dto;

public class Employee extends Person {

	private String posotion;
	
	
	public Employee() {}
	
	public Employee(String id, String name, String posotion) {
		super(id, name);
		this.posotion = posotion;
	}

	//method	
	public String getPosotion() {
		return posotion;
	}

	public void setPosotion(String posotion) {
		this.posotion = posotion;
	}

	
	@Override
	public String getInfo() {
		
		return null;
	}
	
	
}
