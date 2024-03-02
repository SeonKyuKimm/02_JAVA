package edu.kh.todolist.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import edu.kh.todolist.model.service.TodoListService;
import edu.kh.todolist.model.service.TodoListServiceImpl;

// View : 보여지는 부분(내용출력 / 키보드 입력) 역할
// 사용자 인터페이스 등 UI 넣어둠ㅇㅇ
public class TodoListView { // run 쪽에서 객체화됨
	
	//필드 : 해당 클래스에서 사용할 객체들의 참조변수들을 미리 만들어 둠.
	private BufferedReader br = null; // 키보드 입력 스트림 참조 변수
	private TodoListService service = null; // 서비스 참조 변수
  
	// 기본 생성자 : new 연산자 통해 해당 클래스가 객체화 될때 실행되는 클래스를 정의해 두는 곳
	public TodoListView() {
		
		// 객체 생성 시 발생되는 예외를 여기 모아서 처리할 예정임
		
		
		try {
			// 부모타입 참조변수 = 자식객체
			service = new TodoListServiceImpl(); // 다형성 업캐스팅
			br = new BufferedReader(new InputStreamReader(System.in) );
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
