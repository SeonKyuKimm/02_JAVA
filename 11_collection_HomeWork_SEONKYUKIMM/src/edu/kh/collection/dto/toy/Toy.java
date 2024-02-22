package edu.kh.collection.dto.toy;

import java.util.Objects;
import java.util.Set;

public class Toy {

	
	// dto class
		
	
	private String name; // 제품명
	private int price; // 가격
	private String color; // 색상
	private int useAge; //사용연령
	private String madeFrom; // 제조년월일
	private Set<String> materials; // 재료

	public Toy() {}
	
	
	public Toy(String name, int price, 
			   String color, int useAge, 
			   String madeFrom, Set<String> material){
	    super();
	    this.name = name;
	    this.price = price;
	    this.color = color;
	    this.useAge = useAge;
	    this.madeFrom = madeFrom;
	    this.materials = materials;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getUseAge() {
		return useAge;
	}

	public void setUseAge(int useAge) {
		this.useAge = useAge;
	}

	public String getMadeFrom() {
		return madeFrom;
	}

	public void setMadeFrom(String madeFrom) {
		this.madeFrom = madeFrom;
	}

	public Set<String> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<String> materials) {
		this.materials = materials;
	}
	
	/*
	
	
		return "이름 : " + name + " / 가격 : " + price + " / 색상 : " + color + 
				" / 사용가능 연령 : " + useAge + " / 제조년월일 : " + madeFrom + " / 재료 : "
				+ material1 ;
	} */

	// material1 안에 있는 모든 재료를 문자열 형태로 만들어 반환하는 메서드
	
	public String getMaterial1AsString() {
		StringBuilder sb = new StringBuilder();
		
		for( String materials: materials ){
			
			sb.append(materials).append(", ");
		}
		
		// 마지막 쉼표와 공백 제거하기
		if(sb.length() > 0 ){
			sb.setLength(sb.length() -2);
		}
		return sb.toString();
	}
	@Override
	public String toString() {
	return String.format("이름 : %s / 가격 : %d /  색상 : %s /사용가능연령 : %d / 제조년월일 : %s / 재료 : %s", 
			name, price, color, useAge, madeFrom, getMaterials() );
	}


	@Override
	public int hashCode() {
		return Objects.hash(color, madeFrom, materials, name, price, useAge);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return Objects.equals(color, other.color) && madeFrom == other.madeFrom
				&& Objects.equals(materials, other.materials) && Objects.equals(name, other.name) && price == other.price
				&& useAge == other.useAge;
	}
	
	
	

	
	
	
}
