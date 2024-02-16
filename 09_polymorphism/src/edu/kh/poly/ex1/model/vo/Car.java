package edu.kh.poly.ex1.model.vo;

public class Car { // 부모 클래스
	
	
	// 속성
	private String engine; // 엔진
	private String fuel; // 연료
	private int wheel; // 바퀴 갯수
	
	// 기본생성자
	public Car() {}

	// 매개변수 생성자 (alt + shift + o = enter)
	public Car(String engine, String fuel, int wheel) {
		
		super();
		this.engine = engine;
		this.fuel = fuel;
		this.wheel = wheel;
	}

	
	// method
	// getter /setter
	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	// Object.toString() 오버라이딩
	// 부모가 가진 메서드를 자식이 재정의하는것. 덮어쓰는것
	// 오버라이딩 된 메서드라는걸 컴파일러에게 알려주는 Override 어노테이션이다
	@Override 
	public String toString() {
		return engine + " / " + fuel + " / " + wheel; 
	}

	
}
