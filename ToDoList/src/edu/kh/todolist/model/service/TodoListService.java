package edu.kh.todolist.model.service;

import java.time.LocalDateTime;
import java.util.Map;

// Service : 
// 데이터 가공, 비즈니스 로직 처리 등의 기능을 제공하는 역할
//할일목록 추가 반환 수정 등

public interface TodoListService {

	

	/** 할 일 목록 반환 서비스
	 * 
	 *
	 */
	Map<String, Object> todoListFullView();
	
	
	
	/** 날짜 포맷을 변환해서 만듬
	 * 
	 * @param regDate
	 * @return yyyy MM dd MM mm ss 형태 날짜 변환
	 */
	String dateFormat(LocalDateTime regDate);
	
}
