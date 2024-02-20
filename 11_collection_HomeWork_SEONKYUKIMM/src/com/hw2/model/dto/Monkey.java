package com.hw2.model.dto;

public class Monkey extends Animal {

	// 기본생성자
	public Monkey() {}
	
	// 매개변수 생성자
	public Monkey(String name) {
		
		super(name);
	}
	
	
	@Override
	public void sound() {

		System.out.println( name + "가 우끼끼 소리를 냅니다.");
		
	}
}
