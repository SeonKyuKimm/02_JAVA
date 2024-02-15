package com.kh.inheritance.model.dto.Phone;

public class BasicPhone extends Phone {

	private boolean hasPhysicalKeyboard; // 물리적 키보드 유무
	
	// 기본생성자
	public BasicPhone() {}
	
	// 매개 변수 생성자 ,( 부모에게 넘겨줘야되는 값도 포함됨)
	public BasicPhone(String brand, String model, 
					  int year, int price,
					  boolean hasPhysicalKeyboard) {
		
		super(brand, model, year, price);
		this.hasPhysicalKeyboard = hasPhysicalKeyboard;
	}
		
	// 메서드
	// getter / setter

	public boolean isHasPhysicalKeyboard() {
		return hasPhysicalKeyboard;
	}

	public void setHasPhysicalKeyboard(boolean hasPhysicalKeyboard) {
		this.hasPhysicalKeyboard = hasPhysicalKeyboard;
	}
	
	public void checkKeyboard() {
		
		if(hasPhysicalKeyboard) {
			System.out.println("이 휴대폰은 물리적 키보드가 있습니다.");
		} else {
			System.out.println("이 휴대폰은 물리적 키보드가 없습니다.");
		}
		
	}
	
}

