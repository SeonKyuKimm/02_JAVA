package com.hw1.model.vo;

public class Person {

	protected String name; // 이름
	private int age; // 나이
	private double height; // 키
	private double weight; // 몸무게
	
	// 기본 생성자 
	public Person() {}
	
	// 매개변수 생성자
	public Person(int age, double height, double weight){
		super();
		this.age = age;
		this.height = height;
		this.weight = weight;
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String information() { //이름 나이 신장 몸무게 
	
		return String.format("이름 : %s / 나이 : %d / 신장 : %.1f / 몸무게 : %.1f",
								name, age, height, weight);
	}
	
}
