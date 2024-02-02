package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	public void practice1() {
		
		
		Scanner sc = new Scanner(System.in);
				
		System.out.print("인원 수: ");
		int input1 = sc.nextInt(); 
				
		System.out.print("사탕 갯수 : ");
		int input2 = sc.nextInt();
		
		//input2 , input1 = result?
		int result1 = input2 / input1 ;
		int result2 = input2 % input1 ;
		
		System.out.println("1인당 사탕 개수 : " + result1);
		
		System.out.print("남은 사탕 개수 : " + result2);
		
		
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int classroom = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		System.out.print("성별 : ");
		String gender = sc.next();
		
		System.out.print("성적 : ");
		double score = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.\n", grade, classroom, number, name, gender, score);
		
				
	}
	
	public void practice3() {
		
		
		// + 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격
		//아니면 불합격을 출력해라
		Scanner sc = new Scanner(System.in);
	
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		
		System.out.println("합계 : " + sum);
		System.out.printf("평균 : %.1f\n", avg);
		
		boolean result = (kor >=40) && (eng >= 40) && (math >= 40) && (avg >= 60);
		
		System.out.println( result ? "합격" : "불합격");
	}

	
		
	}

