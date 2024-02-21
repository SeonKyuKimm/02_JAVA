package edu.kh.collection.pack3.model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import edu.kh.collection.pack2.model.vo.Person;

public class MapService {

	
	/* Map : 특정 키워드(key)를 입력하면
	 * 		 해당되는 상세한 값(value)을 얻을 수 있는 컬렉션 객체
	 * 
	 * - K : V 형식으로 구성
	 * 
	 * - K : V 한 쌍을 Entry 라고 부름
	 * 
	 * - Key : 키워드 역할( == 변수명)
	 * 1) 중복 X
	 * -> 중복되는 Key 입력 시, Value를 덮어씌우게 됨
	 * -> Key 역할의 객체는 hashCode(), equals()오버라이딩이 필수 !
	 * 
	 * 2) 순서 유지가 되지 않음 ( 단, LinkedHashMap() 은 제외 )
	 * 
	 * * Key만 묶어서 보면 Set과 같은 특징을 지니고 있음
	 * -> 그래서 Map.KeySet() / Map.entrySet() 제공
	 * 
	 * - Value :  키워드에 해당하는 상세한 값
	 * 	 Key로 인해서 모든 Value가 구분된다
	 * -> Map.get(Key) / Map.remove(Key) 형태로사용 
	 * 
	 * */

	public void method1() {
		
		// HashMap 생성
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// 1. V put(K k, V v) : Map 에 추가하는 용도
		// - Map에 put을 이용해 추가시 
		// 중복되는 key 가 없으면 null
		// 중복되는 key 가 있으면 이전 value를 반환
		
		System.out.println( map.put(1, "에그마요") );
		System.out.println( map.put(2, "로티세리바베큐") );
		System.out.println( map.put(3, "스테이크앤치즈") );
		System.out.println( map.put(3, "스파이시쉬림프") ); // 3 중복
		
		System.out.println( map );
		
		System.out.println("------------------------------------------------");
		
		// 2. V get(K k) : Key에 해당하는 Value 반환
		//				   일치하는 Key가 없다면 null을 반환
		
		System.out.println( map.get(1) ); // 에그마요
		System.out.println( map.get(0)); // null
		
		String temp = map.get(2); // "로티세리바베큐"
		System.out.println(temp);
		
		// 3. size() : Map에 저장된 Entry(K:V)의 갯수
		System.out.println( "size : " + map.size() ); // 3
		
	
		System.out.println("======================================");
		// 4. remove(K k) : 
		// - Key 가 일치하는 Entry를 제거
		// - 일치하는 Key가 있다면 Value를 반환, 없으면 null을 반환
	
		System.out.println( "remove(2) : " + map.remove(2) );
		System.out.println( "remove(2) : " + map.remove(5) ); // 없는 Key값 null
		System.out.println(map);
		
		// 5. void clear() : 모든 Entry 삭제
		// 6. boolean isEmpty() : 비어있는지 확인
	
		System.out.println( "clear() 전 isEmpty() : " + map.isEmpty() );
		
		map.clear(); // 모든 Entry 삭제
		System.out.println( "clear() 후 isEmpty() : " + map.isEmpty() );
	}

	

	/**
	 * Map 요소(Entry) 순차 접근 하기 1
	 * - Map.keySet() 이용하기
	 */
	public void method2() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("학원", "서울시 중구");
		map.put("집", "서울시 종로구");
		map.put("롯데타워", "서울시 송파구");
		map.put("63빌딩", "서울시 영등포구");
		
		// Set<K> Map.keyset() :
		// - Map에 있는 Key만 뽑아내서 Set 형태로 만들어서 반환함
		map.keySet();
		System.out.println(map);
		
		Set<String> set = map.keySet();
		
		System.out.println( " keySet : " + set );
		
		// 향상된 for문 + set
		for(String key : set ) {
			
			System.out.println( key + " : " + map.get(key) );
			// .get( key ) // 주어진 키의 값을 리턴.
		}
		
		
		
		
		
	}
	
	/**
	 * Map 요소(Entry) 순차 접근하기2
	 *  - Map.entrySet() 이용하기
	 */
	public void method3() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("학원", "서울시 중구");
		map.put("집", "서울시 종로구");
		map.put("롯데타워", "서울시 송파구");
		map.put("63빌딩", "서울시 영등포구");
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		
		//  향상된 for문 + EntrySet
		// Entry.getKey() : Key만 얻어오는 것
		// Entry.getValue() : Value만 얻어오는 것
		
		for( Entry<String, String> entry : entrySet ) {
			System.out.printf("key : %s , value : %s \n", 
							entry.getKey(), entry.getValue() );
		}
		
	}

	/**
	 * Map 활용하기 - D T O 대체하기
	 *  - 서로 다른 데이터를 한 번에 묶어서 관리해야 하는 경우에
	 */
	public void method4() {
		
		// DTO / VO 이용하는 방법
		
		Person p1 = new Person();
		
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setGender('남');
		
		System.out.printf("이름 : %s , 나이 : %d , 성별 : %c\n",
					p1.getName(), p1.getAge(), p1.getGender() );
		
		System.out.println("-------------------------------------------------");
		
		// DTO 대신 Map 활용하기
		// - Key는 무조건 String을 활용하는 게 Best
		// - Value의 타입은 모두 다름
		// -> Object를 부모 타입 참조변수로 활용 (다형성 적용)
		
		Map<String, Object> p2 = new HashMap<String, Object>();
		
		// 데이터 추가
		p2.put("name", "김길순");
		p2.put("Age", 22); // int - > Integer로 변환되는중. Wrapper Class
		p2.put("gender", '여'); // char - > Character 변환 . " 		"
		
		// 데이터 얻어오기
	
		System.out.printf("이름 : %s , 나이 : %d , 성별 : %c \n",
				p2.get("name"), p2.get("Age"), p2.get("gender") );
		
		
		
	}









}
