package edu.kh.colletcion.pack2.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.pack2.model.vo.Person;

public class SetService {

	/* Set (집합, 주머니)
	 * - 기본적으로 순서를 유지하지 않는다.
	 *   (index 없음 ! -> get() 메서드가 없음)
	 *	 
	 * - 중복 데이터를 저장하지 않는다. (정확히는 같은 객체가 들어오면 덮어쓴다)
	 * 
	 *  Set interface의 자식 클래스
	 *
	 *	1 . HashSet (대표) : 처리속도가 빠른 Set
	 *
	 *	2 . LinkedHashSet : 순서를 유지하는 Set (들어온 순서 기억하는 애)
	 *
	 *  3 . TreeSet : 자동 정렬이 되는 Set
	 *
	 * */
	
	/**
	 * HashSet 사용법!
	 * - 사용조건 1 : 객체에 equals() 라는 메서드가 오버라이딩 되어있어야 함
	 * - 사용조건 2 : 객체에 hashCode() 라는 메서드가 오버라이딩 되어있어야 함
	 * -> String, Integer 등 자바에서 제공하는 객체는
	 *  모두 equals(), hashCode() Object에 오버라이딩이 되어있는 상태
	 */
	public void method1() {
	
		// HashSet객체 생성
		Set<String> set = new HashSet<String>(); // 다형성 중  up - casting
		//Set<String> set = new LinkedHashSet<String>();
		
		// 1. boolean add(E e) : 추가하는 메서드다~
		
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		// HashSet : 순서유지 X 확인
		System.out.println(set);
		
		// 중복 저장 확인 -> (여러개 넣어도) 중복 저장 X 확인
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		
		System.out.println(set);
		
		// null : 참조하는 객체가 없음
		// null도 중복 X 확인
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set); //null 1회만 출력됨

		// 2. int size() : Set에 저장된 객체(참조변수)의 수 반환 
		System.out.println("set.size() : " + set.size());
		
		// 3. boolean remove(E e) :  
		// 전달받은 매개변수 e를 Set에서 제거하는 역할을 함
		// 제거 성공하면 true, 없으면 false
		System.out.println( set.remove("배달의민족") );
		System.out.println( set.remove("유플러스") );
		// 배달의 민족이 제거되었는지, 유플러스는 어떻게 되었는지 확인
		System.out.println(set);
		
		// 4. boolean Contains(E e) : 
		// 전달받은 e가 Set에 포함되어 있으면 true, 없으면 false
		System.out.println( "쿠팡 있는지 확인 : " + set.contains("쿠팡") );
		System.out.println( "삼성 있는지 확인 : " + set.contains("삼성") );
		
		
		// 5. void clear() : 수행만 하는 애. Set에 저장된 내용을 모두 삭제
		set.clear();
		// clear() 로 set안에 남았는지 확인
		
		// 6. boolean siEmpty() : 비어있으면 true, 아니면 false
		
		System.out.println( "다 비운거 실화 ? " + set.isEmpty());
		
		
		
		
		
	}

	
	/**
	 * Set에 저장된 요소(객체)를 꺼내는 방법
	 *  1 . Iterator(반복자) 이용
	 *  2 . List로 변환해서 // 아 진짜싫다 ㅎ
	 *  3 . 향상된 for문 이용 for( : )
	 */
	public void method2() {
		
		Set<String> set = new HashSet<String>();
		
		set.add("몽쉘");
		set.add("꼬북칩");
		set.add("쿠크다스");
		set.add("빈츠");
		set.add("포카칩");
		
				
		// 1 . Iterator ( 반복자 )
		// - 컬렉션 객체에 저장된 요소를
		//	 하나씩 순차 접근하는 객체
		
		// Iterator Set.iterator() : Set 인터페이스 안에 iterator 라는 메서드가 있
		// - 현재 Set을 순차 접근할 수 있는 Iterator 객체 반환
		Iterator<String> it = set.iterator();
		
		// boolean Iterator.hasNext() : 
		// 다음 순차 접근할 요소가 있으면 True, 없으면 False
		System.out.println("[ I t e r a t o r ]");
		
		while( it.hasNext() ) {
			// 다음 요소가 있으면 반복, 없으면 멈춤
			// 위 set에는 5개의 인덱스(0, 1, 2, 3, 4) 5을 반복하게 될것.
			
			//E(객체) Iterator.next() : 다음 요소를 꺼내와 반환한다
			String temp = it.next();
			System.out.println(temp);
		}
		
		System.out.println(" -------------------------------------------------- ");
		
		System.out.println("[ L i s t 로 변 환 ]");
		
		// Set에 저장된 객체를 이용해서 List를 생성
		List<String> list = new ArrayList<String>(set);
		
		// 일반 for문
		for(int i = 0; i < list.size(); i++) {
			System.out.println( list.get(i) );
		}
		
		System.out.println("[ 향 상 된 f o r 문 ]");
		
		for( String snack : set ) {
			System.out.println(snack);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	/**
	 * 직접 만든 클래스인 (Person)을 이용해 만든 객체를
	 *	Set에 저장 ( 중복 제거 확인 )
	 *
	 */
	public void method3() {
		
		Person p1 = new Person("홍길동", 25,'남');
		Person p2 = new Person("홍길동", 25,'남');
		Person p3 = new Person("홍길동", 30,'남');
		Person p4 = new Person("홍길순", 20,'여');
		
		// Set 객체 생성 후 p1 ~ p4
		
		Set<Person> personSet = new HashSet<Person>();
		
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);
		
		System.out.println("---------------------------------------");
		for(Person p : personSet ) {
			
			System.out.println( p );
		}
		
		System.out.println("---------------------------------------");
		
		// hashCode() : 객체 식별 번호(정수)
		// 같은 필드 값을 가진 객체는 번호가 같다 !!!
		System.out.println( "p1 : " + p1.hashCode() );
		System.out.println( "p2 : " + p2.hashCode() );
		System.out.println( "p3 : " + p3.hashCode() );
		System.out.println( "p4 : " + p4.hashCode() );
		
		// A.equals(B) : A와 B가 가지고 있는 필드값이 같다면 true
		System.out.println( "홍길동과 홍길동 필드값이 같니?" +  p1.equals(p2));
		System.out.println( p1.equals(p3));
		
		// *****************************************************************//
		//																	//
		// Hash 라는 단어가 포함된 컬렉션 이용시에는						//
		// 무조건 hashCode(), equals() 오버라이딩 필수적으로 진행해야 한다. //
		//																	//
		//******************************************************************//
		
		
	}
	
	
	/**
	  	TreeSet : 이진 트리 구조를 이용해 객체를 저장하는 Set
	   -> 기본 오름차순 정렬
	     전제조건 : 저장되는 객체는 Comparable 인터페이스 상속 필수 !
	 	
	   -> Integer는 Comparable 상속이 되어있다.
	 */
	public void method4() {
		
		// 난수 생성
		// 1 ) Math.random()
		// 2 ) Random.nextInt()
		
		Random random = new Random();
		
		// Integer(객체 ,Wrapper class) <==> int(기본 자료형)
		// 객체 ?                        객체만 드갈수 있다.
		Set<Integer> lotto = new TreeSet<Integer>();
		
		// lotto에 저장된 값이 6개 미만이면 반복
		// ==6 ; break;
		
		while(lotto.size() < 6) {
			
			// random.nextInt(45) : 0 <= x < 45
			lotto.add( random.nextInt(45) + 1 ); // 1 ~ 45 난수 
		
		}
		System.out.println(lotto);
			
	}
	
	
	/** 로또 번호 생성기
	 * 금액을 입력받아 (천원단위)
	 * 1000원당 1회씩 번호를 생성해서 List에 저장 후,
	 * 생성 종료 시 한 번에 출력
	 * 
	 * <pre>
	 * 금액 입력 : 3000
	 * 
	 * 1회 : [11, 21, 29, 31, 40, 43 ]
	 * 2회 : [11, 21, 31, 33, 34, 43 ]
	 * 3회 : [8, 11, 23, 41, 44, 45] 
	 * </pre>
	 */
	public void lottoNumberGenerator() {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print(" 금액입력 : ");
		int input = sc.nextInt();
		
		Random random = new Random();

		List<Set<Integer>> lottoList = new ArrayList<Set<Integer>>();
		
		for(int i = 0; i < input/1000; i++) {
			
			// for 문 반복될 때 마다 새로운 Set객체를 생성
			Set<Integer> lottoNum = new TreeSet<Integer>();
		
			while(lottoNum.size() < 6) {
				// 1~ 45 사이 난수 추가
				lottoNum.add( random.nextInt(45) + 1);
			}
		
			lottoList.add(lottoNum); // List에 Set 추가(담기)
			// 반복시마다
			// List 각 인덱스에 서로 다른 ,Set 참조 주소가 저장된다
			
		}
	 
		for(int i = 0; i <lottoList.size(); i++) {
			
			System.out.println((i + 1) + "회 :" + lottoList.get(i) );
			
		}
	
	}
	
	
	
	/**
	 * gpt와 함께한 로또번호 생성기
	 */
	public void lottoNumberGenerator2() {
       
		Scanner sc = new Scanner(System.in);
        
		Random random = new Random();
        
		Set<Integer> lottoNum = new TreeSet<>();
        
        System.out.print("금액 입력: ");
        int money = sc.nextInt();
        
        int count = money / 1000; // 1000원당 1회
        
        for (int i = 1; i <= count; i++) {
           
        	System.out.print(i + "회: ");
        	
        	lottoNum.clear();
            
            while (lottoNum.size() < 6) {
                lottoNum.add(random.nextInt(45) + 1); // 1부터 45까지의 난수 생성하여 Set에 추가
            }
            
            System.out.println(lottoNum);
        }
        
         sc.close();   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
