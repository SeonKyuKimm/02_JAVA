package edu.kh.exception.test;

public class ExceptionTest {

public static void main(String[] args) {
		
		/* 컴파일 에러 => 개발자가 코드를 잘못 쓴 경우 */
		// 자료형이 맞지 않아 연산 불가하여 " 컴파일 에러 " 가 발생( 코드가 틀림);
		//int a = 99.9; // Type mismatch: cannot convert from double to int
		int a = (int)99.9;
		
		/* 런타임 에러 => 프로그램 수행 중 발생하는 에러
		 * 				  주로 if문으로 처리 가능하다. */
		
		int[] arr = new int[3]; // 길이 3 : 인덱스는 0, 1, 2 까지 

		
		// java api 17 검색하면 뭔 정보가 많음 ㅎ
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		//arr[3] = 40;
		// java.lang.ArrayIndexOutOfBoundsException : 배열 범위 초과 예외. 런타임쪽 에러. 프로그램 실행 시 발생 확인 가능
	
		if( 3 >= arr.length ) { // 이 if문 안에 들어온다는것은 배열 인덱스 범위 초과 시
			System.out.println("배열 범위를 초과했습니다!");
		} else {
			
			arr[3] = 40;
			arr[4] = 50;

		}
	}
}
