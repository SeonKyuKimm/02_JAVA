package com.hw1.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.hw1.model.dto.Friend;

public class Run {

	public static void main(String[] args) {
		
		// Friend 객체만 넣을 수 있는 ArrayList 객체 생성
		List<Friend> friend = new ArrayList<Friend>();
		
	
		// 짱구, 철수 유리 훈이 맹구 객체 생성하여 ArrayList에 추가
		
		friend.add(new Friend("짱구"));
		friend.add(new Friend("철수"));
		friend.add(new Friend("유리"));
		friend.add(new Friend("훈이"));
		friend.add(new Friend("맹구"));
		
		
		// Collections.addAll();
		/*
		Collections.addAll(friend, new Friend("짱구"),
								   new Friend("철수"),
								   new Friend("훈이"),
								   new Friend("유리"),
								   new Friend("맹구"));*/
		
		// List.of() : java 9 이상의 버전에서 사용 가능
		
		/*
		 * List<Friend> friends = List.of(new Friend("짱구"),
		  								  new Friend("철수"),
				   						  new Friend("훈이"),
			   							  new Friend("유리"),
	   									  new Friend("맹구") );
		 */
		
		
		//List에서 다섯 객체 중 랜덤으로 하나를 뽑아
		
		// note ! Random = random = new Random();
		
		int randomIndex = (int)( Math.random() * friend.size() );
		
		Friend leader = friend.get(randomIndex);
		leader.pickLeader();
		
		
		/*
		Random random = new Random();
        int idx = random.nextInt(friend.size()); // 0부터 리스트 크기 미만의 난수 생성
        Friend leader = friend.get(idx);
        */
		
		
		/*
		Random random = new Random();
		int idx = random.nextInt( friend.size() ); // 0부터 리스트 크기 미만의 난수 생성

		for ( int i = 0; i < friend.size(); i++ ) {
		    if ( i == idx ) {
		        Friend leader = friend.get(i);
		        System.out.println( leader.getName() + " 가 떡잎방범대 대장이다 !" );
		        break; 
		    }
		}*/
		
		/* 
		 		 
        int idx = (int) (Math.random() * friend.size());

        // 리스트의 랜덤한 인덱스에 해당하는 Freind 선택
        Friend leader = friend.get(idx);
        System.out.println(leader.getName() + " 가 떡잎방범대 대장이다 !");
		 */
		
		// 골목대장이 누군지 출력

		// System.out.println( friend.get(idx).getName() + "가 떡잎방범대 대장이다 !");
	}
}
