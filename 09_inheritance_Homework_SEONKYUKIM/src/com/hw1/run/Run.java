package com.hw1.run;

import com.hw1.model.dto.Book;
import com.hw1.model.dto.Novel;
import com.hw1.model.dto.Poetry;
import com.hw1.model.dto.TextBook;

public class Run {

	public static void main(String[] args) {

		Book[] books = new Book[3];

		// 다형성 중 업캐스팅 적용상태
		books[0] = new Novel("해리 포터", "J.K. 롤링", "판타지");

		books[1] = new TextBook("자바 프로그래밍", "James Gosling", "컴퓨터 과학");

		books[2] = new Poetry("우리들의 사랑시", "김소월", 30);

		for (int i = 0; i < books.length; i++) {

			books[i].displayInfo();
		}

		/*
		 * for(Book book : books){
		 * 
		 * book.displayInfo();// 정적바인딩 System.out.println(); 
		 * // 만약 다른 클래스 프린트 구문이 printf라면 개행을 위한 줄임 
		 */

	}
}
