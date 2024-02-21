package edu.kh.collection.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import edu.kh.collection.dto.toy.Toy;

public class ToyFactory {

	
	private Scanner sc = new Scanner(System.in);
	
	private List<Toy> toyList = new ArrayList<Toy>();
	private Map<Integer, String> meterial = new HashMap<Integer, String>();
	
	public ToyFactory() {
			
		meterial.put(1, "면직물");
		meterial.put(2, "플라스틱");
		meterial.put(3, "유리");
		meterial.put(4, "고무");
		
		
		toyList.add(new Toy("키시미시", 15000, "분홍색", 5, 19940505,"면직물, 플라스틱") );
		toyList.add(new Toy("캣냅", 27000, "보라색", 8, 19960128,"면직물, 플라스틱") );
		toyList.add(new Toy("파피", 57000, "빨간색", 12, 19931225,"고무, 면직물") );
		toyList.add(new Toy("허기위기", 12000, "파란색", 5, 19940312,"면직물, 플라스틱") );
		toyList.add(new Toy("마마롱레그", 36000, "분홍색", 8, 19950805,"면직물, 플라스틱") );
		
	}
	
	public void displayMenu() {
		int menuNum = 0;
		
		do {
			
			System.out.println("<<플레이타임 공장>>");
			System.out.println("1 . 전체 장난감 조회하기");
			System.out.println("2 . 새로운 장난감 만들기");
			System.out.println("3 . 장난감 삭제하기");
			System.out.println("4 . 장난감 제조일 순으로 조회하기");
			System.out.println("5 . 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6 . 재료 추가");
			System.out.println("7 . 재료 제거");
			
			System.out.print("선택 : ");
			
			try {
				
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				
				case 1 : showToyAll(); break;
				case 2 : addNewToy(); break;
				case 3 : deleteToy(); break;
				case 4 : ; break;
				case 5 : ; break;
				case 6 : ; break;
				case 7 : ; break;
				
				
				}
				
			} catch(InputMismatchException e) {
				
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해 주세요");
				sc.nextLine(); 
				
				menuNum = -1;
			}
		}while(menuNum != 0);
	
	}
	// 1. 전체 장난감 조회하기
	public void showToyAll() {
		
		System.out.println("<<전체 장난감 목록>>\n");
		
		for (Toy toy : toyList ) {
			
			System.out.println( toy );
		}
	}
	
	// 2. 새로운 장난감 만들기
	public void addNewToy() {
		
		System.out.println("<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String name = sc.next();
		
		System.out.print("사용 가능 연령 : ");
		int useAge = sc.nextInt();
				
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("색상 : ");
		String color = sc.next();
		
		System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
		int madeFrom = sc.nextInt();
		sc.nextLine();
				
		
		
		 StringBuilder materialBuilder = new StringBuilder();
		   
		 while (true) {
		 
			 System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
		     
			 String materialInput = sc.next();


			 if (materialInput.equals("q")) {
		     
				 break;
		        }

		        
			 if (materialBuilder.length() > 0) {
		            materialBuilder.append(", ");
		        }
		        materialBuilder.append(materialInput);
	 	}
		
		 String selectedMaterial = materialBuilder.toString();

		 
		 Toy newToy = new Toy(name, price, color, useAge, madeFrom, selectedMaterial);
		 
		 toyList.add(newToy);

		 
		 System.out.println("새로운 장난감이 추가되었습니다.");
	}

	public void deleteToy() {
		
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String name = sc.next();
		
		boolean remove = false;
		
		for( Iterator<Toy> iterator = toyList.iterator(); iterator.hasNext(); ) {
			Toy toy = iterator.next();
			if(toy.getName().equals(name) ) {
				iterator.remove();
				remove = true;
			}
			
		}
		
		if(remove) {
			System.out.println("장난감이 삭제되었습니다.");
		}else {
			System.out.println();
		}
		
	}
	
}
