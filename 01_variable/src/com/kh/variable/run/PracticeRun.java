package com.kh.variable.run;

import com.kh.vairable.practice2.Practice1;
import com.kh.vairable.practice2.Practice2;
import com.kh.vairable.practice2.Practice3;

// import 는 스캐너를 만들어 둔 곳에서 불러와 얼마든 다시 생성이 가능
public class PracticeRun {
	
	
	//실행 클래스
	public static void main(String[] args) {
		
		Practice1 pr = new Practice1();
			//pr.ex1();
			//pr.ex2();
			
		Practice2 pr2 = new Practice2();
			//pr2.ex1();
		
		Practice3 pr3 = new Practice3();
			//pr3.ex2();
			//pr3.ex3();
			pr3.ex4();

		
	}
	
}
