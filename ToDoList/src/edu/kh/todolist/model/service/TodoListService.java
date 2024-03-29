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
	public abstract String dateFormat(LocalDateTime regDate);

	
	/**전달 받은 inex번째 todo를 반환할것임
	 * @param index
	 * @return index번째 todo 상세정보, 없으면 null을 반환
	 */
	public abstract String todoDetailView(int index);


	/** 할 일 추가 서비스
	 * @param title
	 * @param string
	 * @return 
	 * @return 추가된 index 번호 or -1
	 */
	public abstract int todoAdd(String title, String string) throws Exception;

	
	/** 할 일 완료 여부 변경
	 * @param index
	 * @return 해당 index 요소의 완료 여부가 변경되면 true
	 * 			index 요소가 없으면 false 반환
	 */
	public abstract boolean todoComplete(int index) throws Exception;



	/** 할 일 수정 서비스
	 * @param index
	 * @param title
	 * @param content
	 * @return 수정 성공 시 true, 실패 시 false
	 */
	public abstract boolean todoUpdate(int index, String title, String content) throws Exception;



	/** 할 일 삭제 서비스
	 * @param index
	 * @return 삭제 성공 시 삭제된 할 일의 제목 반환
	 * 			실패시 null 반환
	 */
	public abstract String todoDelete(int index) throws Exception;
	
}
