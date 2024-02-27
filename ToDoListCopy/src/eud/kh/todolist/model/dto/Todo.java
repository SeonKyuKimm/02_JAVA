package eud.kh.todolist.model.dto;


import java.io.Serializable;
// Data Transfer Objecet : 관련된 값의 묶음 . 값 전달 역할
//Value Object . 필드 + 메서드 
import java.time.LocalDateTime;

// 스트림 입, 출력을 위한 Serializable ( 직렬화 . 마커 인터페이스 )
public class Todo implements Serializable {
	
	
	private String title; // 할 일 제목
	private String detail; // 상세 내용
	private boolean complete; // 완료 여부
	private LocalDateTime regDate; // 자료형. java의 time패키지. 등록 날짜
	
	// java.time 자바의 시간관련 기능을 하는 time패키지
	// LocanDateTime : 날짜 시간을 나타내는 클래스
	// LocalDateTime.now() : 현재 시간 반환해줌
	
	// 기본생성자
	public Todo() {}
	
	// 매개변수 생성자
	public Todo(String title, String detail, boolean complete, LocalDateTime regDate) {
		super();
		this.title = title;
		this.detail = detail;
		this.complete = complete;
		this.regDate = regDate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public boolean isComplete() {
		return complete;
	}


	public void setComplete(boolean complete) {
		this.complete = complete;
	}


	public LocalDateTime getRegDate() {
		return regDate;
	}


	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "Todo [ title = " + title + ", detail = " + detail + ", complete = " + complete + ", regDate = " + regDate + "]";
	}
	
	
}
