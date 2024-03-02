package CVSService.view;

import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import CVSStoreService.CVSStoreService;
import CVSStoreService.CVSStoreServiceImpl;
import model.dto.CVSStore;

public class CVSServiceView {

	private BufferedReader br = null;
	
	private CVSStoreService cvsService = null;
	
	
	public CVSServiceView() {

		
			
			try {
				
				cvsService = new CVSStoreServiceImpl();	
				
				br = new BufferedReader(new InputStreamReader(System.in) );
				
				
			}catch(Exception e){
				
				 e.printStackTrace();
			
			}
	}
	
	/** 편의점 담배주류 관리
	 * 
	 */
	public void startView() {
		
		int input = 0;
		
			do {
				
				try {
				
					input = selectMenu();
					
					switch(input) {
					
					case 1 : cvsServiceFullView() ; break;
					case 2 : /*cvsServiceDetailView()*/; break;
					case 3 : /*cvsServiceAdd()*/; break;
					case 4 : /*cvsServiceCheck()*/; break;
					case 5 : /*cvsServiceUpdate()*/; break;
					case 6 : /*cvsServiceDelete()*/; break;

					case 0 : System.out.println("프로그램 종료!"); ; break;
					default : System.out.println("메뉴에 작성된 번호만 써라.");
					}
					System.out.println("==========================================");
					
					
				}catch(NumberFormatException e) {
						
					System.out.println(" ### Only input a Number in Menu ###");
					input =-1;
				}catch(IOException e) {
						
					System.out.println(" ### 입, 출력 관련 예외 발생 ###");
					e.printStackTrace();
				}catch( Exception e) {
					
					e.printStackTrace();
				}
			
		
				}while(input !=0);
	}
	
	public int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("-------CVS Service -------");
		
		System.out.println(" 1 . CVS Service Full View");
		System.out.println(" 2. CVS Service Detail View");
		System.out.println(" 3 . CVS Service Add Sale");
		System.out.println(" 4 . CVS Service Check");
		System.out.println(" 5 . CVS Service Update");
		System.out.println(" 6 . Cvs Service Delete");
		System.out.println();
		System.out.println(" 0 . EXIT PROGRAM");
		System.out.println();
		
		System.out.print("Select Menu Number >>>>> ");
		
		int input = Integer.parseInt( br.readLine() );
				
		return input;
		
	}
	
	public void cvsServiceFullView() {
		
		System.out.println("\n .......... 1 CVS Service Full View.........\n");
		
		Map<String, Object> map = cvsService.cvsServiceFullView();
		
		// *** DAO에서 받아온 map 요소 해체
		List<CVSStore> cvsStore = (List<CVSStore>)map.get("cvsStore");
		int inAndOut = (int)map.get("inAndOut");
		
		// *** 목록 출력
		System.out.printf(" [ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n",
						   inAndOut, cvsStore.size() );
		System.out.println("------------------------------------------------------------------");
		System.out.printf("-3s %10   %10s    %s\n,", "인덱스","등록일", "완료여부"," 할 일 제목");
		System.out.println("------------------------------------------------------------------");
		
		for (int i = 0 , len = cvsStore.size(); i < len; i++ ) {
			
			String sale = cvsStore.get(i).getSale();
			String inOX = cvsStore.get(i).isInAndOut() ? "O" : "X";
			String regDate = cvsService.dateFormat(cvsStore.get(i).getRegDate() );
		
			System.out.printf("[ %d]  %20s   (%s)     %s\n", i ,regDate, inOX, sale);
		}
	}
	
	
	
}

