package freezer.view;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import freezer.model.dto.freezer;
import freezer.service.freezerService;
import freezer.service.freezerServiceImpl;

public class freezerView {

	
	private BufferedReader br = null;
	private freezerService service = null;
		

	public void freezerView() {
		
		try {
			
			service = new freezerServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in) );
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public void startView() {
				
		
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
				
				case 0 : System.out.println("프로그램 종료@@"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해 주세요 ###");
				
				}
				
				System.out.println("==================================================");
			
			
			
				
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
		System.out.println("5 . 냉장고 업데이트");
		System.out.println("6 . 냉장고 음식 꺼내기");
		System.out.println("0 . 문을 닫습니다");
		
		System.out.println(" 무엇을 하시겠습니까 ? >>> ");
		
		int input = Integer.parseInt( br.readLine() );
		
		return input;
		
	}
	
	
	public void freezerFullView() {
		
		System.out.println("\n===== [ 냉장고 전체 메뉴 보기 ] =====");
		
		Map<String, Object> map = service.freezerFullView();
		
		List<freezer> freezerList  = (List<freezer>)map.get("freezerList");
		int completeCount = (int)map.get("completeCount");
		
		
		// ** print
		
		System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d %d ] \n",
				   		  completeCount, freezerList.size() );
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%-3s %10  %10	%s\n","인덱스", "등록일", "완료여부", "할 일 제목");
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
		
		System.out.println("\n ===== [ 냉장고 내용물 확인 ] =====");
		
		System.out.println();
		
		System.out.print("인덱스 번호로 입력 : ");
		int index = Integer.parseInt( br.readLine() );
		
		String freezerDetail = service.freezerDetailView(index);
		
		if(freezerDetail != null) {
			System.out.println("### 입력한 인덱스 번호가 존재하지 않습니다 ###");
			return;
			
		}
		System.out.println(freezerDetail);
	}
	
	
	
	
	public void freezerAdd() throws IOException, Exception {
		
		System.out.println("\n ===== [ 냉장고 채우기 ] =====");
		
		System.out.println();
		System.out.println("할 일 제목 입력 : ");
		String keep = br.readLine();
		
		System.out.println("언제 먹을 음식인가요 (입력 종료 시 !wp 입력 후 엔터. ?");
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
		
		System.out.printf("[ %d ] 인덱스에 추가되었습니다!\n", index);
		
	}
	
	
	
	public void freezerComplete() throws IOException, Exception{
		
		System.out.println("\n ======== [ 4 . 채운 음식 확인 ] ========\n");
	
		System.out.println("음식을 넣을 인덱스 번호 입력");
		int index = Integer.parseInt( br.readLine() );
		
		boolean result = service.freezerComplete(index);
		
		if(result) {
			
			System.out.println(" 변경되었습니다 ");
			
		}else {
			System.out.println("### 인덱스가 존재하지 않아용 ###");
		}
		
	
	}
	
	
	
	public void freezerUpdate() throws Exception {
		System.out.println("\n ======== [ 5 . 냉장고 업데이트 ] ========\n");
		
		System.out.println("수정할 인덱스 번호 입력 : ");
		int index = Integer.parseInt( br.readLine() );
		
		String freezerDetail = service.freezerDetailView(index);
		
		if(freezerDetail == null) {
			System.out.println("### 인덱스 존재하지 않음 ###");
			return;
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ [ 수정 전 ] @@@@@@@@@@@@@@@@");
		System.out.println(freezerDetail);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		System.out.println("수정할 제목 입력 : ");
		String keep = br.readLine();
		
		System.out.println("수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		System.out.println("--------------------------------------------------------");
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			String content = br.readLine();
			
			if(content.equals("!wq") ) break;
			sb.append(content);
			sb.append("\n");
		}
		
		System.out.println("--------------------------------------------------------");
	
		boolean result = service.freezerUpdate(index, keep, sb.toString() );
	
		if(result) System.out.print(" [ 수정되었습니다. ] ");
		else System.out.println("### 수정 실패 ###");
	
	}
	
	
	
	public void freezerDelete()throws Exception {
		
		System.out.println("\n========== [ 6 . Todo Delete ] ============\n");
		
		System.out.println(" 삭제할 음식 인덱스 입력 :");
		int index = Integer.parseInt( br.readLine() );
		
		String result = service.freezerDelete(index);
		
		if(result == null ) System.out.print(" 인덱스가 존재하지 않습니다");
		else System.out.printf(" [ %s ] 가 삭제되었습니다 \n", result);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
