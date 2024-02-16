package com.hw1.model.dto;

public class Poetry extends Book {

	private int numberOfPoems; // 시 수
	
	
	// 기본 생성자
	public Poetry() {}

	// 매개변수 생성자
	public Poetry(String title, String author, int numberOfPoems) {
		super(title, author);
		this.numberOfPoems = numberOfPoems;
	}

	
	//메서드
	public int getNumberOfPoems() {
		return numberOfPoems;
	}

	public void setNumberOfPoems(int numberOfPoems) {
		this.numberOfPoems = numberOfPoems;
	}
	
	
	@Override
	public void displayInfo() {
				
		System.out.println("[시집] 제목 : " + getTitle() 
							  + " / 저자 : " + getAuthor() 
							  + " / 시 수 : " + getNumberOfPoems() );
		
	}
	
	

}
