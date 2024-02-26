package edu.kh.todolist.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.model.dto.Todo;
import edu.kh.todolist.model.service.TodoListService;
import edu.kh.todolist.model.service.TodoListServiceImpl;

// View : 보여지는 부분 / 키보드 입력 )역할.

public class TodoListView {
	
	// 필드
	private	BufferedReader br = null; // 키보드 입력 스트림 참조 변수
    private TodoListService service = null; // service 참조 변수
    
    // 기본 생성자
    public TodoListView() {
    	
    	// 객체 생성 시 발생되는 예외를 여기서 모아서 차리할 예정
    
    	try {
    		// 부모타입 참조변수
    		service = new TodoListServiceImpl(); // 다형성 업캐스팅
    		
    		br = new BufferedReader(new InputStreamReader(System.in));
    	
    	}catch(Exception e){
    	
    		e.printStackTrace();
    	}
        
    }
    
    // ------------------------------------------------------------
    /**
     * TodoList 프로그램 시작 화면 
     *
     *
     */
    public void startView() {
    	
    	// 선택한 메뉴 번호 저장
    	
    	int input = 0;
    	
    	do {
    		
    		
    		try {
    			
    			
    			// 선택한 번호가 반환되어 input에 저장됨
    			input = selectMenu();

    			switch(input) {
    			case 1 : todoListFullView(); break;
    			case 2 : todoDetailView(); break;
    			case 3 : todoAdd(); break;
    			case 4 : todoComplete(); break;
    			case 5 : todoUpdate(); break;
    			case 6 : todoDelete(); break;
    			
    			case 0 : System.out.println("프로그램 종료 @@"); break;
    			default : System.out.println("### 메뉴에 작성된 번호만 입력해 주세요 ###");
    			
    			}
    			   			
    			System.out.println("=============================================================");  			
    			
    			
    			
    		}catch ( NumberFormatException e) {
    			
    			System.out.println("### 숫자만 입력해 주세요 ###");
    			input = -1; // 첫 반복에 종료되는 걸 방지하기 위해서 써뒀다.
    			
    		}catch( IOException e){
    			
    			System.out.println("### 입 / 출력 관련 예외 발생 ###");
    			e.printStackTrace();
    		}catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		
    		
    		
    		
    		
    		
    	}while(input != 0);
    		
    	
    	
    	
    }
    
    
    /**
     * 메뉴 출력 및 선택
     * @return 선택한 메뉴의 번호 반환하도록 할것임
     */
    public int selectMenu() throws NumberFormatException, IOException {
    	
    	System.out.println("-------- Todo List --------");
    	
    	System.out.println("1 . Todo List Full view");
    	System.out.println("2 . Todo Detail View");
    	System.out.println("3 . Todo Add");
    	System.out.println("4 . Todo complete");
    	System.out.println("5 . Todo Update");
    	System.out.println("6 . Todo Delete");
    	System.out.println("0 . EXIT");
    
    	System.out.print(" Select Menu Number >>>>>>>>>>>> ");
    	
    	int input = Integer.parseInt( br.readLine() ); // br에서 불러오면( String으로) readLine이 한 줄 씩 읽어줌
    	
    	return input;
    	
    	
    }
    
    
    //---------------------------------------
    
    /**
     * 할 일 목록 모두 보기
     */
    public void todoListFullView() {
    	
    	System.out.println("\n=============[ 1 . Todo List Full View ]===============");
    	
    	// 할 일 목록 + 완료된 개수 카운트 한 값 얻어오기
    	// (List)	     	 (int) 
    	Map<String, Object> map = service.todoListFullView();
    	
    	//******* 반환 받은 map 요소 해체하기
    	List<Todo> todoList = (List<Todo>)map.get("todoList");
    	int completeCount = (int)map.get("completeCount");
    	
    	//******* 출력
    	System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n"
				, completeCount, todoList.size());
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-3s %10s   %10s     %s\n", "인덱스", "등록일", "완료여부", "할 일 제목");
		System.out.println("--------------------------------------------------------------------");
		
		for(int i=0, len = todoList.size(); i < len; i++) {
		
			String title = todoList.get(i).getTitle();
			
			String completeYN = todoList.get(i).isComplete() ? "O" : "X";
			
			String regDate = service.dateFormat(todoList.get(i).getRegDate());
			
			System.out.printf("[ %d ]  %20s    (%s)       %s\n", i, regDate, completeYN, title);
		}
    	
    	
    	
    }
    
    // ---------------------------------------------------------------------------------
    /**할 일 상세 조회 ( 인덱스 번호 입력받기)
     *  
     * @throws IOException
     */
    public void todoDetailView() throws IOException {
    	
    	System.out.println("\n=============[ 2 . Todo Detail View ]===============\n");
    	System.out.println();
    	
    	System.out.print("인덱스 번호 입력 : ");
    	int index = Integer.parseInt( br.readLine() );
    	
    	// 할 일 상세 조회 서비스 호출 후 결과 반환받기
    	String todoDetail = service.todoDetailView(index);
    	
    	if(todoDetail == null) {
    		System.out.println("### 입력한 인덱스 번호가 존재하지 않습니다.###");
    		return;
    	}
    	System.out.println(todoDetail); // 상세 내용 출력하기
    	
    }
    
    /** 할 일 추가하기(제목, 상새내용만 입력받자)
     *@throws IOException
     **/
    public void todoAdd() throws IOException, Exception{
    	System.out.println("\n=============[ 2 . Todo Add ]===============\n");
    	
    	System.out.println();
    	System.out.print("할 일 제목 입력 : ");
    	String title = br.readLine();
    	
    	System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
    	System.out.println("---------------------------------------------------");
    	StringBuilder sb = new StringBuilder();
    	
    	while(true) {
    		// 문자열 입력 받기
    		String content = br.readLine();
    		
    		if(content.equals("!wq") ) break;
    	
    		sb.append(content);
    		sb.append("\n");
    		
    		
    		
    		
    	}
    	
    	
    	System.out.println("----------------------------------------------------=");
   
    	// 할 일 추가. 서비스 호출, 호출 후 결과 반환 받기;
    	// 성공 : 추가된 index, 실패 1
    	int index = service.todoAdd(title, sb.toString() );
    	
    	if(index == -1) { // 추가 실패
    		System.out.println("*** 추가 실패 ***");
    		return;
    	}
    	
    	// 성공
    	System.out.printf("[ %d ] 인덱스에 추가되었습니다. \n", index);
    }
    
    
    /** 
     * 할 일 완료여부 변경 메서드	(이거↓)
     * 인덱스        등록일         완료여부     할 일 제목
     * [ 0 ]   2024-02-23 02:40:18    (X)       자바 공부
     * 
     * -index 번호 입력받기
     */
    public void todoComplete() throws IOException, Exception {
    	
    	System.out.println("\n=============[ 4 . Todo Complete ]===============\n");
    	    	
    	System.out.print("변경할 인덱스 번호 입력 : ");
    	int index = Integer.parseInt( br.readLine() );
    	
    	// 서비스 호출하고 결과 반환받기 (T / F)
    	boolean result = service.todoComplete(index);
    	
    	if(result) {// 변경 성공
   
    		System.out.println("[변경되었습니다!]");
    		
    	}else {// index 요소가 범위 초과한 경우
    		
    		System.out.println("[### 인덱스가 존재하지 않습니다. ###]");
    		
    	}
    	
    }
    
    
    /** 
     * 할 일 수정
     * - index 번호 입력받아 정상 범위 내의 index 값인지 확인
     * - 정상 범위 index 인 경우, 제목, 상세내용 수정
     */
    public void todoUpdate() throws Exception{
    	
    	System.out.println("\n=============[ 5 . Todo Update ]===============\n");
    	
    	System.out.print("수정할 인덱스 번호 입력 : ");
    	int index = Integer.parseInt( br.readLine() );
    	
    	// (상세 조회) 서비스 재활용 하기 . index 범위 초과 시 null 반환
    	String todoDetail = service.todoDetailView(index);
    	
    	if(todoDetail == null) {
    		System.out.println("### 인덱스 존재하지 않음 ###");
    		return;
    	}
    	
    	// 수정 코드 작성...
    	// 수정 전 상세 내용 출력
    	System.out.println("@@@@@@@@@@@@@@@[ 수정 전 ]@@@@@@@@@@@@@@@@");
    	System.out.println(todoDetail);
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    
    	// 수정할 제목, 내용을 입력받기
    	System.out.print("수정할 제목 입력 : ");
    	String title = br.readLine();
    	
    	System.out.println("수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
    	System.out.println("---------------------------------------------------");
    	
    	StringBuilder sb = new StringBuilder();
    	
    	while(true) {
    		// 문자열 입력 받기
    		String content = br.readLine();
    		
    		if(content.equals("!wq") ) break;
    	
    		sb.append(content);
    		sb.append("\n");
    		
    		
    		
    		
    	}
    	
    	
    	System.out.println("----------------------------------------------------=");
    	
    	
    	// 수정 서비스 호출 후 결과 반환 받기
    	boolean result = service.todoUpdate(index, title, sb.toString() );
    	
    	if(result) System.out.println("[수정 되었습니다]");
    	else System.out.println("### 수정 실패 ###");
    	
    	
    	
    }
    
    
    /**
     * 할 일 삭제
     * - 인덱스 번호 입력받아서 일치하는 요소 삭제
     * 
     */
    public void todoDelete() throws Exception {
    	
    	System.out.println("\n=============[ 6 . Todo Delete ]===============\n");
    	
    	System.out.println("삭제할 인덱스 번호 입력 : ");
    	int index = Integer.parseInt( br.readLine() );
    	
    	// 삭제 서비스 호출 후 결과 반환받기
    	// -> 제목 또는 null 반환
    	String result = service.todoDelete(index);
    	
    	if(result == null) System.out.print("### 인덱스가 존재하지 않습니다###");
    	else System.out.printf("[%s] 가 삭제되었습니다\n", result);
    	
    
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
