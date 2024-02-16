package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem   {

	private Employee[] employees; // 전체 직원 저장용 배열
	private int employeeCount;// 직원 수
	
	
	// 매개변수 생성자
	
	public Company(int size) {
		
	}
	
	
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void displayAllPersons() {
		// TODO Auto-generated method stub
		
	}
}
