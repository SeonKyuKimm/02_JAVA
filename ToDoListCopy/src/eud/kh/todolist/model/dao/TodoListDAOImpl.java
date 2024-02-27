package eud.kh.todolist.model.dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import eud.kh.todolist.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO{

	// 필드 
	private final String FILE_PATH = "/io_test/TOdoList.dat";
	
	
	// 객체 입 . 출력 보조 스트림
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;

	// 파일에 입출력되는 List를 참조할 변수
	private List<Todo> todoList = null;
	
	// 기본생성자
	public TodoListDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// 객체 생성 시, TodoList.dat 파일 내용을 읽어오기
		// -> 읽어오기 전에 있는지 확인부터(검사)하기
		
		File file = new File(FILE_PATH); //위쪾 파일 경로 관리
		
		if(file.exists()) { // 파일이 존재한다면 ?
			
			try {
				
				// 객체 입력 스트림을 이용해서 입력받기
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				// 읽어온 객체를 ArrayList<Todo>로 강제 형변환(다운캐스팅하라는 말)
				//외부에서 읽어온 객체는 모두 Object 라서 다운해야함
				todoList = (ArrayList<Todo>)ois.readObject(); // todoList.dat 파일에서 ;
				
				
			} finally {
				
				if(ois != null) ois.close();
				
			}
			
		}else { // 파일이 존재하지 않으면 ?
			
			// 폴더 파일 만들기.
			File directory = new File("/io_test");
			if( !directory.exists() ) directory.mkdir(); // 폴더가 없으면 생성해라.
			// file.createNewFile(); 을 써도 되지만 파일 출력 스트림 사용하면 됨.
			
			// 객체 출력 스트림 이용해서 파일 생성 + 샘플데이터 추가
			todoList = new ArrayList<Todo>();
			
			todoList.add(new Todo("JAVA 공부", "수업 내용 복습하기", false, LocalDateTime.now() ) );
			todoList.add(new Todo("CSS 공부", "수업 내용 복습하기", false, LocalDateTime.now() ) );
			todoList.add(new Todo("HTML 공부", "수업 내용 복습하기", false, LocalDateTime.now() ) );
			
			try {
				
				// 객체 출력 스트림 생성 -> 파일이 없다면 자동 생성하는 기능도 있음
				// 기반스트림 -> 보조스트림 생성
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH) );
				oos.writeObject(todoList); // todoList를 파일로 출력
				
			} finally {
				
				if( oos != null) oos.close(); //flush() 메서드가 내장되어 있어 다 밀어내고 메모리 반환까지하고 스트림 닫음
			}
			
			System.out.println("*** TodoList.dat 파일 생성 완료 ***");
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
