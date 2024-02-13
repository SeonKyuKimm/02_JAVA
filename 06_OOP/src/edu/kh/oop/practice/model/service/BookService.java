package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {

	public void practice() {
		
		// 객체 생성
		Book book = new Book();
		Book book1 = new Book("자바의 정석", 30000,  0.2, "남궁성");
		
		System.out.println("=============================");
		
		
		book.setTitle("C 언어");
		book.setPrice(30000);
		book.setDiscountRate(0.1);
		book.setAuthor("홍길동");
		System.out.println("수정된 결과 확인");
		System.out.println( book.toString() );
				
		System.out.println("=============================");
		
		System.out.println("도서명 = " + book.getTitle() );
		System.out.println("할인된 가격 = " + (int)(book.getPrice() - (book.getPrice() * book.getDiscountRate())));
		System.out.println("도서명 = " + book1.getTitle() );
		System.out.println("할인된 가격 = " + + (int)(book.getPrice() - (book1.getPrice() * book1.getDiscountRate())));
		
	}

}
