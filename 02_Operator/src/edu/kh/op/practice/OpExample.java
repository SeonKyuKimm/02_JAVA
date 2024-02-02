package edu.kh.op.practice;

import java.util.Scanner;

public class OpExample {// 예제코드 "작성용 클래스." 기능작성용

	// ex1() method : 객체 지향 프로그래밍에서 OpExample 객채와 관련된 함수
	// -> opExample 이 가지고 있는 기능 중 ex1() 이라는 ㅣ기능
	public void ex1() {
	//System.out.prinn
		
		int iNum1 = 10;
		int iNum2 = 10;
		//증감 *증가,감소 연산자. 
		//연산자
		iNum1++;  // iNUm1 = 1증가
		iNum2--; // iNum2 = 2 증가
	
		System.out.println( "iNum1 : " + iNum1);
		System.out.println( "iNum2 : " + iNum2);
	
		//전위연산
		int temp1 = 5;
		
		System.out.println( ++ temp1 + 5);
				//                  ++5
				//                    6     + 5 ==11
		
		//후위연산
		int temp2 = 3;
		System.out.println( temp2-- + 2); //5
		
		System.out.println("temp2 : " + temp2);
		
		
		
		int a = 3;
		int b = 5;
		int c = a++ + --b;
		
		//		3++ + --5
		//		3++ +   4
		//	c = 7
		//		3++ ==> 4
		
		//최종적으로 a,b,c 는 각각 얼마?
		System.out.printf("%d / %d / %d\n", a, b, c ); //a /b /c
						  //4 / 4 /  7
	}

	public void ex2() {
		// 비교 연산자 : > , < , >= , <= , == , !=
		// 비교 연산자의 결과는 항상 논리값이다.
		
		int a = 10;
		int b = 20;
		
		System.out.println( a > b); //false
		
		System.out.println( (a == b) == false ); // true
							// () 괄호 안에 있는것 먼저 연산
							// false == false -> true
		
		int c = 4;
		int d = 5;
		
		System.out.println( (++c != d) == (--c != d) ); // false
							// 5 != 5 -> false
							//				--4 != 5 -> true
							// 4 == 5 -> false 
	}
	
	public void ex3() {
		// 논리 연산자 : && (and) , || (or)
		
		// &&(and) : 앞 뒤 둘다 true 면 true, 나머지는 false
		// ~와, 그리고, ~면서 ,~이면서, ~부터, ~까지, ~사이
		
		int a = 101;
		
		// a는 100이상이면서 짝수인가 ?
		System.out.println( (a >= 100) && (a % 2 == 0) ); // false. 짝수는 아니다.
		
		int b= 5;
		
		// b는 1부터 10까지 숫자 범위에 포함되어 있는가?
		// b는 1보다 크거나 같으면서, 10 보다 작거나 같아야
		System.out.println( (b <= 10) && (b >= 1) ); //true
		
		// || ( OR ) : 둘 다 false 면 false, 나머지는 true (and의 반대)
		// 또는, ~거나, ~이거나, 
		
		int c = 10;
		
		// c는 10을 초과하거나 짝수인가
		System.out.println( (c > 10) || (c %2 == 0) ); // true
	}
	public void ex4() {
		// 삼항 연산자 : 조건식? true일 때 수행될값  : false일때 수행될 값
		
		// * 조건식 : 연산결과가 true / false 인 식

		int num = 30;
		
		// num이 30보다 크면 (초과) "num은 30보다 큰 수이다"
		// 아니면 "num은 30 이하의 수이다" 출력
		
		String result = num > 30 ? "num은 30보다 큰 수이다" : "num은 30 이하의 수이다";
		
		System.out.println(result);
		
		// System.out.println( (num > 30) ? ("num은 30보다 큰 수이다") : ("num은 30 이하의 수이다") );
	
		System.out.println("--------------------------------");
	
		// 입력 받은 정수가 음수인지 양수인지 구분.
		//단, 0은 양수로 처리
		
		//ex ) 
		//정수 입력 : 4		
		//양수 입니다.

		//정수 입력 : -5
		//음수 입니다.	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int input1 = sc.nextInt();
		
		String result2 = input1 >= 0 ? " 양수입니다" : "음수입니다 ";
		
		System.out.println(result2);
	
				
	}
}
