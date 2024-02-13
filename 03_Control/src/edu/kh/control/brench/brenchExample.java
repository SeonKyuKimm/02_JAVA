package edu.kh.control.brench;

import java.util.Scanner;

public class brenchExample {

	public void ex1() {
		
		//1 부터 10까지 1씩 증가하며 출력하는 반복문 작성
		// 단, 5를 출력하면 반복문 종료
		// 1 2 3 4 5
		
		for( int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		
			if (i == 5) {
				break;
			}
		}
	}
	
	public void ex2() {
		
		// 입력받은 모든 문자열을 누적
		// 단, "exit@" 입력시 문자열 누적을 종료하고 결과 출력
		
		Scanner sc = new Scanner(System.in);
		
		String str = ""; // 빈 문자열

		while(true) {
			
			System.out.print("문자열 입력(exit@ 입력 시 종료) : ");
			String input = sc.nextLine();
			
			// next() : 다음의 한 단어 (띄어쓰기 포함 X )
			// nextLine() : 다음 한 줄 (띄어쓰기 포함 O )
			
			if(input.equals("exit@") ) {
				// String 자료형은 비교연산자(==)로 같은 문자열인지 판별할 수 없다.
				// 비교연산자(==)는 보통 기본자료형끼리의 연산에서만 사용 가능함.
				// -> String 은 기본자료형이 아닌 참조형
				
				// ** 해결방법 : 문자열1.equals(비교할 문자열 2) 로 비교 가능 **
				break;
				
			}
			
			str += input + "\n";
			
		}
		
		System.out.println("=========================");
		System.out.print(str);
	}
	
	public void ex3() {
		// continue : 다음 반복으로 넘어감
		
		// 1 ~ 10까지 1씩 증가하며 출력
		// 단, 3의 배수는 제외한다
		
				
		for(int i = 1; i <= 10; i++) {
				
			if ( i % 3 == 0) {
				continue;
			}
			
			System.out.print(i+ " "); // 따옴표는 출력되는 문자끼리 한칸 띄어주는 역할을 위해서 ㅎ
		}
	}
	
	public void ex4() {
		
		// 1 ~100 1씩 증가하며 출력하는 반복문
		// 단, 5의 배수는 건너뛰고
		// 증가하는 값이 40이 되었을 때 반복을 멈춤
		
		
		// 1
		// 2
		// 3
		// ....
		// 39
		
		for(int i = 1; i <= 100; i++) {
			
			
			if( i == 40) {
				break;
			}
			
			if (i % 5 == 0) {
				continue;
			}
			
			
			System.out.print(i + " ");
		}
	}
	
	public void RSPGame() {
		
		
		Scanner sc = new Scanner(System.in);
		
				
		System.out.println("[가위 바위 보 게임 ~!!]");
		System.out.print(" 몇 판? : ");
		int round = sc.nextInt();
		
		// 승,패 기록용 변수
		int win = 0; // 승
		int draw = 0; // 무
		int lose = 0; // 패
		
		for (int i = 1; i <= round; i++) { // 입력받은 판 수 만큼 반복
			
			System.out.println("\n" + i + "번째 게임");
			System.out.print("가위/ 바위 /보  중 하나를 입력 해주세요 : ");
			String input = sc.next();
			
			int random = (int)(Math.random() * 3 + 1); //1 2 3
			
			String com = null;
			// null : 아무것도 참조하고 있지 않음.
			
			switch(random) {
			case 1 : com = "가위"; break;
			case 2 : com = "바위"; break;
			case 3 : com = " 보 "; break;
			}
			
			// 컴퓨터는 [case : com]를 선택했습니다.
			System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n",com);
			
			// 컴퓨터와 플레이어 가위바위보 판별
			if( input.equals(com) ) {
				
				System.out.println("비겼습니다");
				draw++;
			} else {
				
				boolean win1 = input.equals("가위") && com.equals(" 보 ");
				boolean win2 = input.equals("바위") && com.equals("가위");
				boolean win3 = input.equals(" 보 ") && com.equals("바위");
				
				if(win1 || win2 || win3) {
					System.out.println("플레이어 승!");
					win++;
					
					
				}else {
					System.out.println("졌습니다ㅠㅠ");
					lose++;
					
				}
				
				
			}
			
			System.out.printf("현재 기록 : %d승 %d무 %d패\n", win, draw, lose );
			
		}
		
	
	}
}
