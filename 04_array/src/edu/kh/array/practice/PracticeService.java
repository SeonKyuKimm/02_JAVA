package edu.kh.array.practice;

import java.util.Arrays;

public class PracticeService {

	public void practice1() {
		
		
		
		
		
		int[] arr = new int[9];
		
		int sum = 0;		//0 2 4 6 8 , 1 3 5 7 9
 					
		// 0 1 2 3 4 5 6 7 8 : 인덱스 // 1 2 3 4 5 6 7 8 9: 인덱스 내 요소 	
		for(int i = 0; i < arr.length; i++ ) {
			
			arr[i] = i + 1;
			
			//i 번째 (짝수)요소 // arr[i]로 조건식을 넣었을 때는, 
								// arr[i] 내부에서의 짝수요소를 찾은것이라, 의미가 다르다 
			if(i % 2 == 0) {
				
				sum += arr[i] ; 
			}
		}		
		System.out.println(Arrays.toString(arr));
		System.out.printf("짝수 번째 인덱스 합 : %d ", sum);
	}
	
	public void practice2() {
		
		int[] arr = new int[9];
		
		for (int a = arr.length -1 ; 0 <= a  ; --a ) {
			
			
			
		}
		System.out.println(Arrays.toString(arr));
	}

	
}
