package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {

	public void practice() {
		
		// 객체 생성
		Book book = new Book();
		Book book1 = new Book("C언어", 30000,  0.1, "홍길동");
		
		book.setTitle("자바의 정석");
		book.setPrice(30000);
		book.setDiscountRate(0.2);
		book.setAuthor("남궁성");
		
		System.out.println("=============================");
		
		System.out.println("수정된 결과 확인");
		System.out.println();
		System.out.printf(" %s / %d / %f / %s \n",
				book1.getTitle(), book1.getPrice(),
				book1.getDiscountRate(), book1.getAuthor() );
		
		
	}

}
