package freezer.run;

import freezer.view.FreezerView;

public class FreezerRun {

	public static void main(String[] args) {
		
		System.out.println("----- FREEZER -----");
		
		// 프로젝트 흐름
		//  Run <=> View <=> Service <=> DAO < => File
		
		FreezerView view = new FreezerView();
		
		view.startView();
	
	}
}
