package edu.kh.oop.practice.model.vo;

public class Book {

	private String title; // 도서명
	private int price; //가격
	private double discountRate; //할인율
	private String author; // 저자명
	
	
	// 기능, 속성 
	// getter / setter
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public double getDiscountRate() {
		return discountRate;
	}


	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	// 기본생성자
	public Book() {
		System.out.print("numm");
		
		title = "자바의 정석";
		price = 30000;
		discountRate = 0.2;
		author = "남궁성";
	}
	
	public Book(String title, int price,
			double discountRate, String author) {
		
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", discountRate=" + discountRate + ", author="
				+ author + "]";
	}
	
	


}
