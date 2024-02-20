package home.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import home.book.Book;

public class BookService {

	
	private Scanner sc = new Scanner(System.in);
	
	private List<Book> bookList = new ArrayList<Book>();
	
		public BookService() {
	
		
		bookList.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		bookList.add(new Book(2222, "문과 남자의 과학공부", "유시민", 15750, "돌베개"));
		bookList.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		bookList.add(new Book(4444, "꿀벌의 예언", "베르나르베르베르", 15120, "열린책들"));
		bookList.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
	
	}
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			
			System.out.println("===도서 목록 프로그램===");
			System.out.println("1 . 도서 등록\n");
			System.out.println("2 . 도서 조회\n");
			System.out.println("3 . 도서 수정\n");
			System.out.println("4 . 도서 삭제\n");
			System.out.println("5 . 즐겨찾기 추가\n");
			System.out.println("6 . 즐겨찾기 삭제\n");
			System.out.println("7 . 즐겨찾기 조회\n");
			System.out.println("8 . 추천도서 뽑기\n");
			System.out.println("0 . 프로그램 종료\n");
			
			System.out.print("메뉴를 입력하세요 : ");
			
		try {
			
			menuNum = sc.nextInt();
			System.out.println();
			
			switch(menuNum) {
				
				case 1 : System.out.println( addBook() ); ; break;
				case 2 : showAll(); break;
				case 3 : System.out.println( updateBook() ); break;
				case 4 : ; break;
				case 5 : ; break;
				case 6 : ; break;
				case 7 : ; break;
				case 8 : System.out.println("프로그램 종료"); ; break;
				case 0 : ; break;
	
				default :
				
			}
			
		} catch(InputMismatchException e) {
			System.out.println("\nerror : 입력형식 무효");
			sc.nextLine();
			menuNum = -1;
		}
			
		}while(menuNum != 0); 
			
		
	}
	// 도서 등록
	public String addBook(){
		
		System.out.println("=====도서 등록=====");
		
		System.out.print("도서 번호 : ");
		int bookNum = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		System.out.print("도서 제목 : " );
		String name = sc.next();
		System.out.println();
		
		System.out.print("도서 저자 : ");
		String author = sc.next();
		System.out.println();
		
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		
		System.out.print("도서 출판사 : ");
		String company = sc.next();
		System.out.println();
		
		
		
		if( bookList.add (new Book(bookNum, name, author, price, company) ) ) {
			
			return "등록 완료";
		} else {
			
			return "실패 !";
		}
		
	}
	// 도서 정보 조회(전체)
	public void showAll() {
		
		if( bookList.isEmpty() ) {
			System.out.println("도서 정보가 없습니다.");
			return;
		}
		
		int index = 0;
		 
		for (Book bk : bookList) {
			
			System.out.println( bk );
			System.out.println();
		}
		
	}
	
	public String updateBook() {
		
		System.out.println("=====도서 수정 =====");
	
		System.out.print("수정할 도서 번호를 입력하세요 : ");
		
		int bookNum = sc.nextInt();
		sc.nextLine();
		
		boolean found = false;
		for(Book book : bookList) {
			if( book.getBookNum() == bookNum ) {
				//
				System.out.println("어떤 정보를 수정하시겠습니까?");
				System.out.println();
                System.out.println("1. 도서 제목");
                System.out.println();
                System.out.println("2. 도서 저자");
                System.out.println();
                System.out.println("3. 도서 가격");
                System.out.println();
                System.out.println("4. 도서 출판사");
                System.out.println();
                System.out.println("0. 수정 종료");
				
                System.out.print("어떤 정보를 수정하시겠습니까? ");
                int choice = sc.nextInt();
                sc.nextLine(); // 개행 문자 처리

                switch (choice) {
                    case 1 : System.out.print("새로운 도서 제목을 입력하세요: ");
                        	
                   			 String newName = sc.nextLine();
                        	
                   			 book.setName(newName);
                        	
                   			 return "도서 제목을 수정했습니다.";
                        
                    case 2 : System.out.print("새로운 저자를 입력하세요: ");
                        	 
                    		 String newAuthor = sc.nextLine();
                        	
                    		 book.setAuthor(newAuthor);
                        	 
                    		 return "저자를 수정했습니다.";
                        
                    case 3 : System.out.print("새로운 가격을 입력하세요: ");
                        	 
                			 int newPrice = sc.nextInt();                        
                        	
                    		 book.setPrice(newPrice);
                        	 
                    		 return "도서 가격을 수정했습니다.";
                        
                    case 4: System.out.print("새로운 출판사를 입력하세요: ");
                        	
                    		String newCompany = sc.nextLine();
                        	
                    		book.setCompany(newCompany);
                        	
                    		return "출판사를 수정했습니다.";
                    
                    case 0:
                       
                    	return "수정을 종료합니다.";
                    default:
                        
                    	return "잘못된 메뉴 번호입니다.";
                }
            }
        }

        // 도서를 찾지 못한 경우
        return "해당 도서가 없습니다.";
		
	}
	
	
}		
			
		
	
