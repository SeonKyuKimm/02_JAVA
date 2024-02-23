package edu.kh.todolist.model.dao;

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

import edu.kh.todolist.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO {

	// 필드
	private final String FILE_PATH = "/io_test/TodoList.dat";
	
	// 객체 입 /출력 보조 스트림
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;

	// 파일에 입/ 출력되는 리스트를 참조할 변수
	private List<Todo> todoList = null;
	
	// 기본생성자
	public TodoListDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// 객체 생성시, TodoList.dat 파일 내용 읽어오기
		// -> 읽어오기 전에 있는지 검사부터
		
		File file = new File(FILE_PATH);
		
		if( file.exists() ) { //파일이 존재하면
			
			try {
				// 객체 입력 스트림을 이용해서 입력받기
				ois = new ObjectInputStream( new FileInputStream(FILE_PATH));
				
				// 읽어온 객체를 ArrayList<Todo>로 강제 형변환(다운 캐스팅)
				todoList = ( ArrayList<Todo> )ois.readObject();				
				
			}finally {
				if(ois != null)ois.close();
				
			}
			
			
			
			
			
			
		}else { // 파일이 존재하지 않으면
			
			// 폴더, 파일 만들기
			File directory = new File("/io_test");
			if(!directory.exists() ) directory.mkdir(); // 폴더 없으면 생성 
			// file.createNewFile();
			
			
			// 객체 출력 스트림을 이용해서 파일을 생성 + 샘플 데이터 추가
			todoList = new ArrayList<Todo>(); // 세트로 생성됨 private List<Todo> todoList = null; 얘랑
			
			todoList.add(new Todo("자바 공부" , "수업 내용 복습하기", false, LocalDateTime.now() ) );
			todoList.add(new Todo("CSS 공부" , "수업 내용 복습하기", false, LocalDateTime.now() ) );
			todoList.add(new Todo("J.Script 공부" , "수업 내용 복습하기", false, LocalDateTime.now() ) );
			
			
			try {
				// 객체 출력 스트림 생성 -> 파일이 없다면 자동 생성
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH) );
				// todoList를 파일로 출력
				oos.writeObject( todoList );
				
			} finally {
				
				if(oos != null)oos.close(); //flush() 메서드가 내장되어 있어 스트림에 있는것 다 밀어내고 메모리 반환까지.
				
			}
				
			System.out.println("*** TodoList.dat 파일 생성 완료 ***");
			
						
			
		}
			
		
	} // 기본생성자 끝

	@Override
	public List<Todo> todoListFullView() {
		
		return todoList;
	}


}
