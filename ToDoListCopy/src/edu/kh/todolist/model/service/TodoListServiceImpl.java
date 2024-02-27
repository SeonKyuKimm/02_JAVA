package edu.kh.todolist.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import eud.kh.todolist.model.dao.TodoListDAO;
import eud.kh.todolist.model.dao.TodoListDAOImpl;

public class TodoListServiceImpl implements TodoListService {

	// 필드 . DAO 에서 주는 것을 객체화 하여 이용할것
	private TodoListDAO dao = null;
	
	// 기본생성자에서 DAO 객체화
	public TodoListServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TodoListServiceImpl 객체가 생성될 떄
		// TodoLIstDAO Impl 객체 생성
		dao = new TodoListDAOImpl();
		// 부모타입 참조변수 = 자식객체 (다형성 업캐스팅)
	}

}
