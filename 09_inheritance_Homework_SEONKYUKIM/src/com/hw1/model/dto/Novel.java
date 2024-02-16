package com.hw1.model.dto;

public class Novel extends Book{

	private String genre; // 장르
	
	
	// 기본 생성자
	public Novel() {}

	
	// 매개변수 생성자
	public Novel(String title, String author,
				 String genre) {
		super(title, author);
		this.genre = genre;
	}

	
	// 메서드
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public void displayInfo() {
		System.out.println("[소설] 제목 : " + getTitle() + 
						   " / 저자 : " + getAuthor() + 
						   " / 장르 : " + getGenre() );
		
		
	}
	
	
}
