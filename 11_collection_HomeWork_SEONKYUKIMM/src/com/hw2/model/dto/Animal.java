package com.hw2.model.dto;

public abstract class Animal {

	protected String name;
	
	// 기본생성자
	public Animal() {}
	
	
	// 매개변수 생성자
	public Animal(String name) {
		super();
		this.name = name;
	}

	
	// 메서드
	// g / s
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	// 상속받은 애들이 직접 사운드를 구현할 수 있도록 만든 sound();
	public abstract void sound();	
}
