package com.hw2.model.dto;

public abstract class Person {

	protected String id;
	protected String name;
	
	public Person(){}

	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// method
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String getInfo();
		// 추상메서드
		// 객체 정보를 문자열로 반환한다
	

}
