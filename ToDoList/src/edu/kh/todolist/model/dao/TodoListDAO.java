package edu.kh.todolist.model.dao;

import java.util.List;

import edu.kh.todolist.model.dto.Todo;



// service에게 전달
// DAO ( DATA ACCES OBJECT ) :
// 데이터가 저장된 파일 . DB . 외부 장치에 접근하는 역할
public interface TodoListDAO {

	
	
	/**할 일 목록 반환 DAO
	 * @return
	 */
	List<Todo> todoListFullView();
}
