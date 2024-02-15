package edu.kh.run.MemberRun;

import edh.kh.oarr.model.service.MemberService.MemberService;

public class MemberRun {

	public static void main(String[] args) {
		
		MemberService mService = new MemberService();
	
		mService.displayMenu();
	}
}
