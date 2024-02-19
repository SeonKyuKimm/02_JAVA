package com.hw2.run;


import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Prisoner;
import com.hw2.model.service.Company;
import com.hw2.model.service.ManagementSystem;
import com.hw2.model.service.Prison;

public class Run {

	public static void main(String[] args) {
		
		Company comp = new Company(10);
		Prison prison= new Prison(10);
		
		// 직원 새로 등록하기
		
		 comp.addPerson(new Employee("EMP001", "유재석", "기획팀")); // 다형성 업캐스팅 사용
		 comp.addPerson(new Employee("EMP002", "정형돈", "개발팀")); // 다형성 업캐스팅 사용
		
		 // 등록 직원 모두 조회
		 comp.displayAllPersons();
		 
		 System.out.println("=========================================================");
	
		 // 수감자 새로 등록하기
		 
		 prison.addPerson(new Prisoner("1205", "정준하", "밥도둑"));
		 prison.addPerson(new Prisoner("0705", "박명수", "웃음연쇄살인"));
	
		 //등록된 수감자 모두 조회
		 
		 prison.displayAllPersons();
		 
		 System.out.println("========================================================");
	
		 // EMP 001 직원 삭제
		 comp.removePerson("EMP001");
		 
		 // 1205 id를 가진 수감자 삭제
		 prison.removePerson("1205");
		 System.out.println("========================================================");
	
		 //현재 남은 직원 모두 조회
		 comp.displayAllPersons();
		 
		 //현재 남은 수감자 모두 조회
		 prison.displayAllPersons();
	
	}
}
