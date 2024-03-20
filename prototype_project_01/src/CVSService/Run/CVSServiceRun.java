package CVSService.Run;

import CVSService.view.CVSServiceView;
import model.dto.CVSStore;

public class CVSServiceRun {

	public static void main(String[] args) {
		
		System.out.println("====== 프로그램 실행 ! ======");
	
	
		CVSServiceView view = new CVSServiceView();
		
		view.startView();
		
	
	}
	
}
