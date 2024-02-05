package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {

	Scanner sc = new Scanner(System.in);
	
	
	public void practice1(){
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input1 = sc.nextInt();
		
		String result;
		
		if( input1 < 0 ) {
			result = "양수만 입력해주세요.";
		}else {
			if( input1 % 2 == 1) {
				result = "짝수입니다.";
			}else {
				result = "홀수입니다.";
			}
		}
		System.out.print(result);
	}
	///////////////////////////////////////////////////////
	public void parctice2() {
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		
		
	}














}

