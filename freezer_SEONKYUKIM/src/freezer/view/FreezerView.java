package freezer.view;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import freezer.model.dto.Freezer;

import freezer.service.FreezerService;
import freezer.service.FreezerServiceImpl;

public class FreezerView {

	
	private BufferedReader br = null;
	private FreezerService service = null;
		

	public FreezerView() {
		
		try {
			
			service = new FreezerServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in) );
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void startView() {
				
		// 메뉴 번호 저장
		
		int input = 0;
		
		do {
			
			try {
				
				input = selectMenu();
			
				switch(input) {
			
				case 1 : freezerFullView(); break;
				case 2 : freezerDetailView(); break;
				case 3 : freezerAdd(); break;
				case 4 : freezerComplete(); break;
				case 5 : freezerUpdate(); break;
				case 6 : freezerDelete(); break;
				
				case 0 : System.out.println("<< ??? : 별거 없네.. >>"); break;
				default : System.out.println("1번부터 6번 사이에만 있답니다");
				
				}
				
				System.out.println("=================================================================");
			
			
			
				
			} catch( NumberFormatException e) {
					System.out.println(" ## 숫자만 입력해 주세요 ##");
					input = -1;
				
			} catch (IOException e) {
				
				System.out.println(" ## 입/출력 관련 예외발생##");
				
				e.printStackTrace();
					
			} catch (Exception e) {
					
					e.printStackTrace();
			}
			
		}while (input != 0);
		
		
	}
	
	public int selectMenu() throws NumberFormatException, IOException{
		
		System.out.println("  <<< 냉장고에는...>>>");
		
		System.out.println("1 . 냉장고 전체 메뉴 보기");
		System.out.println("2 . 냉장고 내용물 확인");
		System.out.println("3 . 냉장고 채우기");
		System.out.println("4 . 채운 음식 확인");
		System.out.println("5 . 냉장고에 음식 입 / 출");
		System.out.println("6 . 음식 꺼내기");
		System.out.println("0 . 문을 닫습니다");
		
		System.out.print(" 무엇을 하시겠습니까 ? >>> ");
		
		int input = Integer.parseInt( br.readLine() );
		
		return input;
		
	}
	
	
	public void freezerFullView() {
		
		System.out.println("\n                   ===== [ 냉장고  보기 ] =====");
		
		Map<String, Object> map = service.freezerFullView();
		
		List<Freezer> freezerList  = (List<Freezer>)map.get("freezerList");
		int completeCount = (int)map.get("completeCount");
		
		
		// ** print
		
		System.out.printf("[ 입고된 음식  / 전체 보관 수 : %d / %d ] \n",
				   		  completeCount, freezerList.size() );
		
		System.out.println("-----------------------------------------------------------------");
	
		for( int i = 0, len = freezerList.size(); i < len; i++) {
			String keep = freezerList.get(i).getKeep();
			
			String food = freezerList.get(i).isInAndOut() ? "O" : "X";
			
			String regDate = service.dateFormat(freezerList.get(i). getRegDate() );
			System.out.printf("[ %d ] %20s		(%s)		%s\n", i, regDate, food, keep);
		}
		
		
	}
	
	// ------------------------------------------------------------------
	
	public void freezerDetailView() throws IOException{
		
		System.out.println("\n===== [ 냉장고 내용물 확인 ] =====");
		
		System.out.println();
		
		System.out.print("인덱스 번호로 입력 : ");
		int index = Integer.parseInt( br.readLine() );
		
		String freezerDetail = service.freezerDetailView(index);
		
		if(freezerDetail == null) {
			System.out.println("입력한 음식은 없어용");
			return;
			
		}
		System.out.println(freezerDetail);
	}
	
	
	
	
	public void freezerAdd() throws IOException, Exception {
		
		System.out.println("\n ===== [ 냉장고 목록추가 ] =====");
		
		System.out.println();
		System.out.print("넣을것은? : ");
		String keep = br.readLine();
		
		System.out.println("언제 먹을 음식인가요 (입력 종료 시 !wq 입력 후 엔터. ?");
		System.out.println("--------------------------------------");
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			String content = br.readLine();
			
			if(content.equals("!wq") ) break;
			
			sb.append(content);
			sb.append("\n");
			
			
			
		}
		
		System.out.println("-------------------------------------------");
		
		int index = service.freezerAdd(keep, sb.toString() );
		
		if(index == -1) {
			System.out.println("*** 추가 실패 ***");
			return;
		}
		
		System.out.printf("[ %d ] 번째 음식에 추가되었습니다!\n", index);
		
	}
	
	
	
	public void freezerComplete() throws IOException, Exception{
		
		System.out.println("\n ======== [ 4 . 음식 입 / 출] ========\n");
	
		System.out.println("음식이 냉장고에 있을까요?"); 
		System.out.print("인덱스 번호 입력 , ( O , X로 표기됨) ");
		int index = Integer.parseInt( br.readLine() );
		
		boolean result = service.freezerComplete(index);
		
		if(result) {
			
			System.out.println(" 체크했습니다 ");
			
		}else {
			System.out.println("인덱스가 존재하지 않아용");
		}
		
	
	}
	
	
	
	public void freezerUpdate() throws Exception {
		System.out.println("\n ======== [ 5 . 냉장고 업데이트 ] ========\n");
		
		System.out.print("수정할 인덱스 번호 입력 : ");
		int index = Integer.parseInt( br.readLine() );
		
		String freezerDetail = service.freezerDetailView(index);
		
		if(freezerDetail == null) {
			System.out.println("### 인덱스 존재하지 않음 ###");
			return;
		}
		
		System.out.println("@@ [ 수정 전 ] @@");
		System.out.println(freezerDetail);
		System.out.println("@@@@@@@@@@@@@@@");
		
		System.out.println("수정할 제목 입력 : ");
		String keep = br.readLine();
		
		System.out.println("수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		System.out.println("-----");
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			String content = br.readLine();
			
			if(content.equals("!wq") ) break;
			sb.append(content);
			sb.append("\n");
		}
		
		System.out.println("----");
	
		boolean result = service.freezerUpdate(index, keep, sb.toString() );
	
		if(result) System.out.print(" [ 수정되었습니다. ] ");
		else System.out.println("### 수정 실패 ###");
	
	}
	
	
	
	public void freezerDelete()throws Exception {
		
		System.out.println("\n========== [ 6 . Todo Delete ] ============\n");
		
		System.out.print(" 꺼낼 음식은 몇 번 ? :");
		int index = Integer.parseInt( br.readLine() );
		
		String result = service.freezerDelete(index);
		
		if(result == null ) System.out.print(" 번호에 존재하지 않아요");
		else System.out.printf(" [ %s ] 을/를 꺼냈어요 \n", result);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
