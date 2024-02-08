package edu.kh.oop.practice.model.vo;

public class Hero {

	// 데이터 직접 접근 제한
	// 속성 // 필드
	//필드에 작성되는것이 멤버변수
	
	private String nickName; //닉네임
	private	String job; //직업
	private int hp; // 체력
	private int mp; //마력
	private int level; // 레벨
	private int exp; // 경험치
			
	// 기능 - 행동 메서드
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getExp() {
		return exp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
	 // 기능
	public void attack(int exp) {
		System.out.println(nickName + "은/는 공격을 했다!");
		
		// 전달받은 경험치를 현재 경험치에 누적
		this.exp += exp;
		
		if(this.exp > 500) {
			level += 1;
			System.out.println("레벨이 올랐습니다 !! 현재 레벨 : " + level);
			
			
		}
	}
	public void magicJump() {
		
		if(mp <= 0) {
			System.out.println("더 이상 매직점프 할 수 없어요");
		} else {
			mp -= 10;
			System.out.println(nickName +"의 점프!");
		}
	}
}

// private -> getter/setter -> 기능 작성 순
	
