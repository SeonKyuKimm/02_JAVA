package ddd;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<IPInfo> ipInfoList = new ArrayList<IPInfo>();
		
		
		ipInfoList.add(new IPInfo("123.123.123.123", "홍길동") );
		ipInfoList.add(new IPInfo("212.133.7.8", "김선규" ) );
		ipInfoList.add(new IPInfo("177.233.111.222", "고길순") );
		
		System.out.print("ip 입력 : ");
		String ip = sc.next();
		
		boolean flag = false;
		
		for( IPInfo info : ipInfoList ) {
			if( info.getIp().equals(ip) ) {
				
				System.out.println("사용자" +info.getUser() );
				
				 flag = true;
				 break;
			}
		}
		
		if( flag != true) System.out.println("일치하는 ip 사용자가 없습니다.");
	}
}
