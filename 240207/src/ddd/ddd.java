package ddd;

import java.util.Arrays;

public class ddd {

	public String getInfo(String str1, String str2) {
		
		String[] str = new String[2];
				
		str[0] = "김나나";
		str[1] = "홍길동";	
			
			// Arrays.toString(str) => [김나나, 홍길동]
			
		return Arrays.toString(str);
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println( getInfo(str) );

	
		
		
	}
	
	
	
}
