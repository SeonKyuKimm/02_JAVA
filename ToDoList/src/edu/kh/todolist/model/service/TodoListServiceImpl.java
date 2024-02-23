package edu.kh.todolist.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.model.dao.TodoListDAO;
import edu.kh.todolist.model.dao.TodoListDAOImpl;
import edu.kh.todolist.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService{

	// 필드
	private TodoListDAO dao =null;
	
	// 기본 생성자 
	public TodoListServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		
		dao = new TodoListDAOImpl();
	}
	
	//메서드
	
	// -------------------------------------------------------
	
	/* todoListFullView*/
	@Override
	public Map<String, Object> todoListFullView(){
		
		//1 . 할 일 목록 DAO에서 얻어오기
		List<Todo> todoList = dao.todoListFullView();
				
		//2 . 할 일 목록에서 완료(complete 필드값이 true)인 요소가 몇 개인지 카운트
		int completeCount = 0;
		
		for( Todo todo : todoList ) { // TodoList 순차 접근
			
			// isComplete() == getComplete()
			if( todo.isComplete() ) { // true인 경우
				completeCount++;
			}
		}
				
		// 3. todoList, completeCount를 저장할 Map 생성
		// -> 메서드는 반환을 하나밖에 못해서
		//    여러개를 반환해야 하는 경우 Map같은 컬렉션에 묶어서 반환
		
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
					
		// 4. map 반환		
		return map;		
	}
	
	
	@Override
	public String dateFormat(LocalDateTime regDate) {
		// yyyy-MM-dd MM:mm:ss 형태 날짜 ㅏㄴ환
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd MM:mm:ss");
		
		// regData에 저장되어있는 날짜 데이터를
		// formatter에 지정된 형식으로 변경할것이다.
		String formattedDateTime = regDate.format(formatter);
				
		return formattedDateTime;
	}
	
}



