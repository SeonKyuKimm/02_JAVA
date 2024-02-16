package com.hw1.model.dto;

public abstract class Book {

	private String title; // 제목
	private String author; // 저자
	
	
	// 기본 생성자
	public Book() {}

	
	//매개변수 생성자
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	
	// 메서드
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	// 책 정보를 출력하는 메서드
	
	public abstract void displayInfo();
	// 추상(abstract) 메서드를 가질 수 있는 클래스는 추상 클래스뿐(abstract)
	
	
}
