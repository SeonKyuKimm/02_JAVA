package edu.kh.basic;

// 한 줄 주석 : 컴파일러(번역기)가 해석하지 않는 부분

/* 범위주석
 * 안에서 엔터도 얼마든 가능~
 * 
 * 
 * 
 * */

// class : 자바 코드가 작성되는 영역
public class JavaTest {
	
	public static void main(String[] args) {
		// main method(메서드) : 자바 어플리케이션(프로그램)을 실행하기 위해 반드시 필요한 메서드
		
		// ctrl + alt + arrow : 작성한 방향으로 해당 줄 복사
		System.out.println("Hello, World!!!");
		System.out.println("배고파!!!");
		System.out.println("야호!");
		
		System.out.println("-------------------------------");
		
		// 숫자연산
		System.out.println("1+2");
		System.out.println(1+2);
	
		// "" 안에 작성된 코드는 단순 문자열로 인식
		// "" 안에 작성되지 않은 코드는 숫자 혹은 변수로 인식
		
		System.out.println(50-23);
		System.out.println(12*13);
		System.out.println(327/3);
		System.out.println(12%2); // 산술연산자 자바스크립트와 동일 -
		
		// ""(문자열) + 숫자 함께 작성할 때
		
		System.out.println("14*19 =" + 266); // 14 * 19 = 266
		System.out.println("14*19 =" + 14 * 19); // 14 * 19 = 266
		
		System.out.println("90 + 70 + 65 =" + (90 + 70 + 65) ); // "문자열" + (수식)의 표현
		
		// 자바는 사칙연산의 우선순의를 그대로 따른다!
		// -> 우선 계산을 원하면 ()괄호 사용하면 됩니다.
		
		// + 기호의 역할
		// -> 숫자 + 숫자 = 덧셈 연산 결과
		// -> 문자열 + 숫자 or
		//    문자열 + 문자열 --> 이어쓰기
		
	}

	
}
