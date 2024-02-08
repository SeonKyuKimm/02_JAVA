package edu.kh.oop.basic;

public class AccountRun {

	public static void main(String[] args) {
		
				
		Account acc = new Account();
		
		acc.setName("김선규"); // 흐름 ? 호출
		acc.setAccountNumber("050-24-0224-997");
		acc.setBalance(100000);
		acc.setPassword("7890");
		
		System.out.println(acc.getName());
		System.out.println(acc.getAccountNumber());
		System.out.println(acc.getBalance());
		System.out.println(acc.getPassword());
		//
		acc.deposit(50000);

		//acc.withdraw("1234", 2000); // 비밀번호 불일치가 뜸
		//acc.withdraw("7890", 20000000); // 잔액부족
		acc.withdraw("7890", 1000); // 비밀번호 일치, 
		
		System.out.println("=====================");
		Account a2 = new Account();
		
		a2.setName("다른애");
		a2.setAccountNumber("123-123");
		a2.setBalance(100000);
		acc.setPassword("4321");
		
		
		
	}
	
}
