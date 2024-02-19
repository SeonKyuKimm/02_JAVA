package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem   {

	private Employee[] employees; // 전체 직원 저장용 배열
	private int employeeCount;// 직원 수
	
	
	// 매개변수 생성자
	
	public Company(int size) {
		this.employees = new Employee[size];
		this.employeeCount = 0;
	}
	
	
	@Override
	public void addPerson(Person person) {
		if (person instanceof Employee && employeeCount < employees.length) {
			employees[employeeCount++] = (Employee) person;
			System.out.println("직원이 추가되었습니다 -" + person.getInfo() );
		}else {
			System.out.println("인원이 모두 충원되어 더 이상 추가 할 수 없습니다.");
		}
		
	}
	
	
	@Override
	public void removePerson(String id) {
		for (int i = 0; i < employeeCount; i++) {
			if ( employees[i].getId().equals(id) ){
				System.out.println("직원이 삭제되었습니다 - " + employees[i].getInfo() );
				employees[i] = null;
				for(int j = i; j < employeeCount - 1;j++) {
					employees[j] = employees[j + 1];
				}
				employees[--employeeCount] = null;
				return;
			}
		}
		System.out.println("ID : " + id +"인 직원을 찾을 수 없습니다.");
	}
	
	@Override
	public void displayAllPersons() {
		System.out.println("전체 직원 명단 : ");
		for (int i = 0; i < employeeCount; i++) {
			System.out.println( employees[i].getInfo() );
		}
	}
}
