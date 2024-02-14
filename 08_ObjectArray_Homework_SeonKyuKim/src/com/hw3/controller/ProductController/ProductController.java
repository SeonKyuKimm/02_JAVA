package com.hw3.controller.ProductController;

import java.util.Scanner;

import com.hw3.model.vo.Product.Product;

public class ProductController {

	private Product[] pro = null;
	public static int count = 0;
	Scanner sc = new Scanner(System.in);
	// 위의 클래스 다이어그램을 보고 필드 작성
	// 초기화 블럭을 이용해서 10개의 Product 배열 크기 할당
	
	{
		pro = new Product[10];
	}
	
	public void MainMenu() {
		
		// 메뉴 출력 --> do ~ while 문으로 반복 실행 처리
		// 반복적으로 메뉴화면 출력
		// 각 버튼 선택 시 각각의 메소드 호출
		int menuNum = 0;
		
		do {
			
				System.out.println("===== 제품 관리 메뉴 =====");
				System.out.println("1 · 제품 정보 추가"); // productInput() 메소드 실행
				System.out.println("2 · 제품 전체 조회"); // pruductPrint() 메소드 실행
				System.out.println("0 · 프로그램 종료");
				System.out.print("메뉴 선택 : ");
				menuNum = sc.nextInt();
				
				
				switch(menuNum) {
					
				case 1 : productInput(); break;
				case 2 : productPrint(); break;
				case 0 : System.out.println("프로그램 종료.."); break;
				default : System.out.println("다시 입력해주세요.");
			
				}
				
			}while(menuNum != 0);
			
		
		
	}
	
	public void productInput() {
		
		// 키보드로 도서 정보를 입력 받아 객체 생성
		System.out.print("제품 번호 : ");
		int pId = sc.nextInt();
		
		sc.nextLine(); // 입력버퍼 개행문자 제거
		
		System.out.print("제품 이름 : ");
		String pName = sc.nextLine();
		
		System.out.print("제품 가격 : ");
		int price = sc.nextInt();
		
		System.out.print("제품 세금 : ");
		double tax = sc.nextDouble();
		
		// 현재 카운트 인덱스에 생성한 주소 저장
		// -> product 생성자 내부에서 ProductController의
		// count 클래스 변수 값이 1씩 증가
		pro[count] = new Product(pId, pName, price, tax);
		
		
		
		
		// 새로운 제품 정보 기록을 위해 키보드로 정보들을 입력 받아
		// 객체를 생성하고 현재 카운트 인덱스에 주소 저장
	
	
	}
	
	public void productPrint() {
		
		// 현재까지 기록된 도서 정보 모두 출력
		for ( int i = 0; i < count; i++) {
			
			System.out.println(pro[i].information() );
		}
				
	}
	
	// 추가적으로 제품 삭제, 수정, 검색 
	// 등등의 메소드를 응용해서 추가해보세요~
}
