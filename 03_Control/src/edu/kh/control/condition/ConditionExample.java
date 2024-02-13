package edu.kh.control.condition;

import java.util.Scanner; //다른 패키지에 연결?

public class ConditionExample { // 기능 제공용 클래스
	//메서드가 모여있다!. 자바에서는 필드라고 부름.
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		// if문
		// 조건식이 true일때만 내부의 코드를 수행
		
		/*
		 * [작성법]
		 * if(조건식) {
		 * 		조건식이 'true' 일 때 수행할 코드
		 * }
		 * 
		 */
		
		// 입력받은 정수가 양수인지 검사
		// 양수라면 "양수입니다"
		System.out.print(" 정수 입력 : ");
		
		int input = sc.nextInt();
		
		if( input > 0) {
			System.out.print("양수입니다.");
		}
		
		if (input <= 0) {
			System.out.print("양수가 아니다");
		}
	}

	public void ex2() {
		
		// if - else문
		// 조건식 결과가 true 면 if 문,
		// false 면 else 구문이 수행됨
		
		/*
		 * [작성법]
		 * if (조건식) {
		 * 		조건식이 true일 때 수행되는 코드
		 ** } else {
		 *		조건식이 false일 때 수행되는 코드
		 * }
		 * */
		
		
		// 홀짝 검사
		// 입력받은 정수값이 홀수이면 " 홀수입니다"
		// 0이면 0입니다
		// 짝수이면 짝수입니다

		System.out.print(" 정수 입력  : ");
		int input1 = sc.nextInt();
		
		if (input1 % 2 != 0 ) {	
		
			System.out.print( " 홀수입니다 " );
		}	else { // 짝수 또는 0 입력시 수행
			
			// 중첩 if
			if( input1 == 0) {
				System.out.println( " 0 입니다." );
			} else {
				System.out.println( " 짝수입니다." );
			}
		}
	}	
	public void ex3() {
		// 양수, 음수, 0 판별
		// if - else if - if
		
		System.out.print( " 정수 입력 : ");
		int input2 = sc.nextInt();
		
		if ( input2 == 0) {
			System.out.print( " 0 입니다. ");
		} else if (input2 > 0) {
			System.out.print( " 양수입니다! " );
		} else {
			System.out.print( " 음수입니다! " );
		}
		
	}
	
	public void ex4() {
		
		// 달(month)을 입력받아 해당 달에 맞는 계절 출력
		// 단, 겨울일 때  온도가 -15도 이하 "한파경보" -12이하 "한파 주의보"
		// 여름일 때 온도가 35도 이상 " 폭염 경보", 33도 이상 "폭염 주의보
		// 1~12월 사이가 아닐 땐, "해당하는 계절이 없습니다" 출력
		// 1, 2, 12 겨울
		// 3~5 봄
		// 6~8 여름
		// 9~12 가을
	
		
		System.out.print(" 달 입력 : ");
			int month = sc.nextInt();
			
		String season; // 아래 조건문 수행결과를 저장할 변수 선언
		
		if ( month == 1 || month == 2 || month ==12) {
			
			season = "겨울";
			
			System.out.print("온도입력 : ");
			int temperature = sc.nextInt();
			
			if(temperature <= -15 ) {
				
				season += " 한파경보";
						// "겨울"
				// season = season + "한파경보";
				// "겨울 한파경보
			} else if(temperature <= -12) {
				
				season += " 한파주의보";
			}
			
		} else if( month >= 3 && month <= 5) {
			
			season = "봄";
		} else if ( month >= 6 && month <= 8) {
			
			season = "여름";
			
			System.out.print("온도입력 : ");
			int temperature = sc.nextInt();
			
			if(temperature <= 35 ) {
				
				season += " 폭염경보";
						// "겨울"
				// season = season + "한파경보";
				// "겨울 한파경보
			} else if(temperature >= 33) {
				
				season += " 폭염주의보";
			}
			
		} else if ( month >= 9 && month <= 11) {
			
			season = "가을";
		} else {
			
			season = "해당하는 계절이 없습니다";
		}
		
		System.out.print(season);
	}
	
	
	public void ex5() {
	
		// 나이를 입력 받아
		// 13세 이하면 "어린이 입니다."
		// 13세 초과 19세 이하면 : "청소년 입니다."
		// 19세 초과 시 : "성인 입니다". 출력
		
		System.out.print( "나이를 입력하세요 : " );
		int age = sc.nextInt();
		
				
		if ( age <= 0 || age <= 13) {
			
			System.out.print("어린이입니다.");
			
		} else if ( 13 < age && age < 19) {
			
			System.out.print("청소년입니다.");
			
		} else{
			
			System.out.print( "성인입니다.");
		} 
		
	}
	
	public void ex6() {
		
		// 점수(100점 만점)를 입력 받아
		// 90점 이상 : A
		// 80점 이상 90점 미만 : B
		// 70점 이상 80점 미만 : C
		// 60점 이상 70점 미만 : D
		// 60점 미만 : F
		// 0점 미만, 100 초과 : "잘못 입력하셨습니다"
		
		System.out.print( "점수를 입력하세요 : ");
		int score = sc.nextInt();
		
		if ( score < 0 || score > 101) {
			
			System.out.print( "잘못 입력하셨습니다");
			
		} else if (100 >= score && score > 90 ) {
			
			System.out.print(" A ");
			
		} else if ( 90 > score && score > 80) {
			
			System.out.print(" B ");
			
		} else if ( 80 > score &&70 < score ) {
			
			System.out.print(" C ");
			
		} else if ( 70 > score && 60 < score ) {
			
			System.out.print(" D ");
			
		} else {
			
			System.out.print(" F ");
		}
	}// ex6번은 풀이 한번 보고 비교해보기.
	 // String 을 이용해서 System.out.print 를 한 번만 활용.
	
	
	/////////////////////////////////////////////
	public void ex7() {
		// 놀이기구 탑승 제한 검사
		// 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
		// 나이가 12미만인 경우 : "적정 연령이 아닙니다."
		// 키가 140.0cm 미만 : "적정 키가 아닙니다."
		// 나이를 0세 미만, 100세 초과 시 : "잘못 입력 하셨습니다."
		
		System.out.print(" 나이 : ");
		int age = sc.nextInt();
		
		
		
		if ( age < 0 || 100 < age ) {
			
			System.out.print(" 잘못 입력하셨습니다.");
		} else if ( age >= 12) {
			
			System.out.print(" 키 : ");
			double tall = sc.nextDouble();
			
			System.out.print(" 탑승가능!");
			
			if (tall < 140.0 ) {
				System.out.print(" 적정 키가 아닙니다.");
			}
		} else if ( age < 12) {
			System.out.print(" 적정 연령이 아닙니다.");
		}
	} // 다시 풀어 String 이용.
	
	
	public void ex8() {
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		if( age < 0 || age > 100) {
			result = "나이를 잘못 입력했어요.";
		}else {
			
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			
			if ( height < 0 || height > 250) {
				
				result = "키를 잘못 입력했어요.";
			} else {
				
				if( age < 12 && height >= 140.0) {// 키 o , 나이 x
					result = "키는 적절하나, 나이가 적절치 않음";
					
				}else if( age >= 12 && height < 140.0)  {// 나이 o, 키 x
					result = "나이는 적절하나, 키가 적절치 않음";
					
				}else if (age < 12 && height < 140.0) { //나이 x, 키 x
					result = "나이와 키 모두 적절치 않음.";
					
				}else {
					result = "탑승 가능!";
				}
			}
		}
		System.out.print(result);
	}
		
	// 실습문제 2 꼭 풀이하기.
	
	
}