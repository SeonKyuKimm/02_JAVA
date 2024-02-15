package com.hw1.model.service.EmployeeService;

import java.util.Scanner;

import com.hw1.model.vo.Employee.Employee;

public class EmployeeService {

	
	
	private Employee[] empArr= new Employee[3];
	private Scanner sc = new Scanner(System.in);
	public void disPlayMenu() {
		
		int menuNum = 0;
		
		do {
			
			System.out.println("====직원 관리 프로그램 ====");
			System.out.println();
			System.out.println("1 . 직원 정보 입력(3명)");
			System.out.println("2 . 모든 직원 정보 출력");
			System.out.println("3 . 특정 직원 정보 출력");
			System.out.println("4 . 특정 직원 급여/연봉 출력(사번으로 검색)");
			System.out.println("5 . 모든 직원 급여 합/연봉 합 출력");
			System.out.println("6 . 모든 직원중 급여가 가장 높은 직원의 이름 부서 급여 출력");
			System.out.println("0 . 종료");
			System.out.println();
			System.out.print("메뉴 선택 >> ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
				switch(menuNum) {
				
				case 1 : System.out.print( addEmp() ); break;
				case 2 : System.out.println( /* 모든 직원 정보 출력*/ ); break;
				case 3 : System.out.println( /* 특정 사원 정보 출력*/ ); break;
				case 4 : System.out.println( /* 특정 직원 급여 연봉 */); break;
				case 5 : System.out.println(); break;
				case 6 : System.out.println(); break;
				case 0 : System.out.println("프로그램 종료."); break;
				default : System.out.println(" 잘못 입력하셨습니다.");
				
				}
			
		}while(menuNum != 0);
	}


	
	private int emptyIndex() {
		
		for(int i = 1; i < empArr.length; i ++){
			
			if(empArr[i] == null) {
				return i;
			}
		}
		return -1;
		
	}
	
	public String addEmp() {
		
		int index = 0;
		
		for(int i =0; i < empArr.length; i++ ) {
			
			
			
		}
		
		System.out.println("===" + empArr/*[i]*/ + "번째 사원 정보 입력 ===");
		System.out.println();
		
		System.out.print(" · 사번 :");
		String pNo = sc.next(); 
		System.out.println();
		
		System.out.print(" · 이름 : ");
		String pName = sc.next();
		System.out.println();
		
		System.out.print(" · 부서 :");
		String dept = sc.next();
		System.out.println();
		
		System.out.print(" · 직급 : ");
		String job = sc.next();
		System.out.println();
		
		System.out.print(" · 급여 : ");
		int salary = sc.nextInt();
		
		return null;
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
