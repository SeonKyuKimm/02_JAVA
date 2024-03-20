package model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CVSStore implements Serializable{

	private String sale;// 물건
	private String explain; // 물건 설명
	private boolean inAndOut; // 입고 여부
	private LocalDateTime regDate; // 등록 날짜
	
	public void CVSStore() {}

	public CVSStore(String sale, String explain, boolean inAndOut, LocalDateTime regDate) {
		super();
		this.sale = sale;
		this.explain = explain;
		this.inAndOut = inAndOut;
		this.regDate = regDate;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
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
		return "CVSStore [sale=" + sale + ", explain=" + explain + ", inAndOut=" + inAndOut + ", regDate=" + regDate
				+ "]";
	}

	
		
}
