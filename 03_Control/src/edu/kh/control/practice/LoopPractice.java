package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {

	public void practice1(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" 1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if ( input >= 1){
			
			for(int i = 1; i <= input; i++) {
				System.out.print( i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력하세요.");
		}
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" 1 이상의 숫자를 입력하세요 : ");
		int input2 = sc.nextInt();
		
		if (input2 >= 1) {
			for(int i = input2; i >= 1; i--) {
				System.out.print(i + " ");
			}
		}else {
			System.out.println(" 1 이상의 숫자를 입력하세요.");
		}
	}
	////////////////////////////////////////////////////////
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int input3 = sc.nextInt();
		
		int sum = 0;
		
		for(int i = 1; i <= input3 -1 ; i++) {
			
			sum += i;
			System.out.print( i + " + " );
		}
		sum += input3;
		System.out.print(input3 + " = " + sum);
	}


	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int input1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();
		
		
	 
		
	}



}
