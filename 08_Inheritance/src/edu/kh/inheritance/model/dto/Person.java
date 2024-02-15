package edu.kh.inheritance.model.dto;

// DTO(Data Transfer Object) : 데이터 값 교환 객체. 비지니스 계층과 데이터 교환을 위해 사용하는 객체
public class Person /* extends Object*/{
	
	/*		Object 클래스
	 * - 모든 클래스의 최상위 부모
	 * - 클래스 선언부에 상속 구문이 하나도 작성되어있지 않다면
	 * 	 컴파일러가 extends Object 구문을 추가해준다.
	 */
	
	// 필드 (사람이라면 가지고 있는 공통점)
	private String name; //이름
	private int age; // 나이
	private String nationality; // 국적
	
	
	// 생성자
	public Person() {} // 기본생성자

	
	// 매개변수 생성자
	public Person(String name, int age, String nationality) {
		super(); // 본인 부모의 생성자. super생성자라고 함
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}

	
	// 메서드 
	// getter / setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
	public void breath() {
		System.out.println("사람은 코나 입으로 숨을 쉰다");
	}
	
	public void move() {
		System.out.println("사람은 움직일 수 있다.");
	}

	
	@Override // 필드에 있는 애를 문자열 형태로 리턴해주는애
	public String toString() {
		// Object의 toString()재정의
		
		return name + " / " + age + " / " + nationality;
	}
	
	
	
	
	
	
	
	
	
	
}
