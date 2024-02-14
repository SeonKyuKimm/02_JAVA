package com.hw3.model.vo.Product;

import com.hw3.controller.ProductController.ProductController;

public class Product {

	// Product의 기본 생성자 및 매개변수 생성자
	// Product 객체 생성시마다  
	// ProductController의 객체 수 카운트를 1 증가
	
	// field
	private int pId;
	private String pName;
	private int price;
	private double tax;
	
	// 기본 생성자
	public Product() {
		ProductController.count++;
	}
	// 오버로딩 적용
	public Product(int pld, String pName,
				   int price, double tax) {
		this.pId = pld;
		this.pName = pName;
		this.price = price;
		this.tax = tax;
		
		ProductController.count++;
	}

	
	public int getPld() {
		return pId;
	}

	public void setPld(int pld) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	
	
	public String information() {
		// 필드에 저장된 값 관련. 제품 정보 리턴
		return "제품번호 : " + pId + ", 제품명 : " + pName +
				", 가격 : " + price + ", 세금" + tax;
	}
	
}
