package edu.kh.oop.basic;


// 계좌 클래스
public class Account {
	
	// 속성 (값)
	
	private String name; // 이름
	private String accountNumber; // 계좌번호
	private long balance; // 잔액
	private String password; // 비밀번호
	
	
	//기능
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 속성
	// ->deposit(amount) : 전달받은 금액을 잔액에 누적한 후, 현재 잔액을 콘솔에 출력
	

	public void deposit(long amount) {
		// 전달받은 금액을 잔액에 누적한 후
		balance += amount; 
		//현재 잔액을 콘솔에 출력
		System.out.println("name + 의 현재 잔액 : " + balance);
	}
	
	// ->withdraw(pw, amount) : 출금. 비밀번호와 출금할 액을 전달받아와, 조건에 맞으면 잔액에서 차감 후 현재 잔액 출력
	//	1) 비밀번호와 일치하지 않으면 " 비밀번호 불일치 "
	//	2) 출금할 금액이 잔액보다 크면 " 잔액 부족 " 출력
	
	public void withdraw( String pw, long amount ) {
		
		if(!password.equals(pw)) { // 다를 경우
			System.out.println("비밀번호 불일치");
			return; // 해당 함수(메서드) 종료
		}
		
		// 출금할 금액이 잔액보다 큰 경우
		if(amount > balance) {
			System.out.println("잔액 부족");
			return;
		}
		
		
		// 잔액을 출금할 금액 만큼 차감
		balance -= amount;
		// balance =  balance - amount;
		
		System.out.printf("%s 계좌에서 %d 원 출금\n", accountNumber,amount);
		System.out.println(name + "의 현재 잔액 : " + balance);
		
	}







}
	
	

