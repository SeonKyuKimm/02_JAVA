package freezer.run;

import freezer.view.FreezerView;

public class FreezerRun {

	public static void main(String[] args) {
		
		System.out.println("----- 냉장고를 열어보니... -----");
		
		// 프로젝트 흐름
		//  Run <=> View <=> Service <=> DAO < => File
		
		FreezerView view = new FreezerView();
		
		view.startView();
	
	}
}
