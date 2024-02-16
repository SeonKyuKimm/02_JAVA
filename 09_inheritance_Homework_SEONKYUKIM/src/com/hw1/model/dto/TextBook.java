package com.hw1.model.dto;

public class TextBook extends Book {

	private String subject; // 과목
	
	
	// 기본 생성자
	public TextBook() {}

	// 매개변수 생성자
	public TextBook(String title, String author, String subject) {
		super(title, author);
		this.subject = subject;
	}
	

	//메서드
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	@Override
	public void displayInfo() {
		
		System.out.println("[전문 서적] 제목 : " + getTitle() 
								  + " / 저자 : " + getAuthor() 
								  + " / 과목 : " + getSubject() );
	}

}
