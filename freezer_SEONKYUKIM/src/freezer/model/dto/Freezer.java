package freezer.model.dto;

import java.io.Serializable;

import java.time.LocalDateTime;

public class Freezer implements Serializable{

	private String keep; // 보관
	private String food; // 음식
	private boolean inAndOut; // 입출고 (O ,X)
	private LocalDateTime regDate; // 구매날짜
	
	
	public void freezer() {}

	
	public Freezer(String keep, String food, boolean inAndOut, LocalDateTime regDate) {
		super();
		this.keep = keep;
		this.food = food;
		this.inAndOut = inAndOut;
		this.regDate = regDate;
	}

	
	public String getKeep() {
		return keep;
	}

	public void setKeep(String keep) {
		this.keep = keep;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public boolean isInAndOut() {
		return inAndOut;
	}

	public void setInAndOut(boolean inAndOut) {
		this.inAndOut = inAndOut;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Freezer [keep=" + keep + ", food=" + food + ", inAndOut=" + inAndOut + ", regDate=" + regDate + "]";
	}

	
	
	
}
