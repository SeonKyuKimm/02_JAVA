package freezer.run;

import freezer.view.freezerView;

public class freezerRun {

	public static void main(String[] args) {
		
		System.out.println("----- 냉장고를 열어보니... -----");
		
		// 프로젝트 흐름
		//  Run <=> View <=> Service <=> DAO <FILE>
		freezerView view = new freezerView();
		
		view.startView();
	
	}
}
