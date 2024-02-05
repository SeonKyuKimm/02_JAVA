package edu.kh.control.loof;

import java.util.Scanner;

public class forExample {

	/* for 문
	 *  - 끝이 정해져 있는 ( 횟수가 지정되어 있는 ) 반복문
	 * 
	 * [작성법]
	 * 
	 * for (초기식; 조건식; 증감식) {
	 * 		조건식이 true 라면 반복행될 코드;
	 * }
	 * 
	 * - 초기식 : for문을 제어하는 용도의 변수 선언
	 * 
	 * - 조건식 : for문의 반복 여부를 지정하는 식.
	 * 			 보통 초기식에 사용된 변수를 이용하여 조건식을 작성.
	 * 
	 * - 증감식 : 초기식에 사용된 변수를 
	 * 			  for문이 끝날 때 마다 증가 또는 감소시켜서
	 * 			  조건식의 결과를 변하게 하는 식 
	 * 
	 * */
	
	public void ex1() {
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
	public void ex2() {
		// 1 부터 "입력받은 수"까지 1씩 증가하며 출력

		Scanner sc = new Scanner(System.in);
		// 이 밑 프린트가 입력받은 수;
		System.out.println("입력번호 : ");
		int input = sc.nextInt();
		 
		
		for (int i = 1; i <= input ; i++) {
			System.out.println(i);
		}
	}
	
	public void ex3() {
		
		
		// char 자료형은 문자형이지만 실제로 정수를 저장한다
		//이 밑에는 입력받을 필요 없이 콘솔에만 나오게 하는거.	
		for(int i  = 'A'; i <= 'Z'; i++ ) {
			System.out.print((char)i);
		}
		
		System.out.println("\n======================================");
		
		for ( char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}
	
	public void ex4() {
		// 정수 5개를 입력 받아서 합계 구하기
		
		//ex ) 
		//입력 1 : 10
		//입력 2 : 20
		//입력 3 : 30
		//입력 4 : 40
		//입력 5 : 50
		//합계 :150
		
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
				
		for(int i = 1; i <= 5; i++) {
					
			System.out.print("입력" + i + " : ");
			int num = sc.nextInt();
			
			// 합계 저장용 result 에 num값 누적
			
			result += num;
		}
		
		System.out.print("합계 : " + result);
	}
	
	public void ex5() {
		// 1부터 20까지 1씩 증가하면서 출력
		// 단, 입력받은 수의 배수는 양쪽이 () 표시
		
		// ex)
		// 괄호를 표시할 배수 : 3
		// 1 2 (3) 4 5 (6) 7 8 (9)......20
		Scanner sc = new Scanner(System.in);
		
		System.out.print("괄호를 표시할 배수 : ");
		int num = sc.nextInt();
				
		for(int i = 1; i <= 20; i++) {
			
			if ( i % num == 0) {
			
				System.out.print("(" + i + ") ");
			} else {
				System.out.print(i + " ");
			}
		}
	}
	
	public void ex6() {
		// [구구단 출력]
		// 2~9 사이 수를 하나 입력받아
		// 해당 단을 출력
		// 단, 입력받은 수가 2-9 사이가 아니면
		// "잘못 입력 하셨습니다" 출력
		
		/*
		 * 단 입력 : 5
		 * 
		 * 5 x 1 = 5
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 5 x 9 = 45
		 * 
		 * ===
		 * 
		 * 단 입력 : -5
		 * 잘못 입력하셨습니다
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" 단 입력 : ");
		int num = sc.nextInt();
		
		if( num >= 2 && num <= 9) {
		
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d ", num, i, num * i);
			}
		
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}

	}
	
	public void ex7() {
		// 구구단 모두 출력하기
	
		// 2~9단 모두 출력하기
	
		for (int i = 2; i <= 9; i++) {
			
			for (int x = 1; x <= 9; x++) {
			System.out.printf("%d X %d = %2d ", i, x, i*x ); //%2d 라고 해두면 두 자리 출력이 예쁘게 줄맞춤 됨
		}
			System.out.println(); // 줄바꿈 용도
		}
		System.out.println("역순출력 ============================ ");
	
		// 구구단 역순 출력
		// 9단 -> 2단까지 역방향
		// 곱해지는 수는 1-> 9 정방향
		
		// 바깥쪽 포문의 '증감식' 을 감소식으로 하는 방법이 있었다.
		//위쪽 증가하는 구구단과는 다르게 9단부터 2단으로 내려가야 하기에 j 를 --로 해줌
		
		for (int j =9 ; j >= 2; j--) {
			
			for(int k = 1; k <= 9; k++) {
				System.out.printf("%d X %d = %2d ", j, k, j * k); // %2d 끝나는 자리에 스페이스 꼭 해주셈ㅇㅇ
			}
			System.out.println();// 줄바꿈 용도
		}
	}
	
	public void ex8() {
		
		// 숫자 세기 count
		
		// 1부터 20까지 1씩 증가하면서
		// 입력받은 수의 배수의 총 개수 출력
		// 입력받은 수의 배수의 합계 출력
		
		// 배수 입력 : 3
		// 3 6 9 12 15 18 : 6개
		// 3의 배수 합계 : 63
		
		// 변수를 적절히 만들어 두는것이 관건
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0; // n의 배수의 개수를 세기 위한 변수
		int sum = 0; // n의 배수의 합계를 구하기 위한 변수
		String result = "";
		
		System.out.print("배수 입력 : ");
		int input = sc.nextInt();
				
		for (int i = 1; i <= 20; i++) {
			
			if ( i % input == 0) {
				result += i + " ";
				count++;
				sum += i;
			}
		}
		System.out.printf("%s : %d개\n", result, count );
		System.out.printf("%d의 배수 합계 : %d" , input, sum);
		
	}
	
}
