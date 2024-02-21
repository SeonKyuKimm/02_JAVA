package edu.kh.collection.dto.toy;



public class Toy {

	
	// dto class
		
	
	private String name; // 제품명
	private int price; // 가격
	private String color; // 색상
	private int useAge; //사용연령
	private int madeFrom; // 제조년월일
	private String material1; // 재료

	
	public Toy(String name, int price, 
			   String color, int useAge, 
			   int madeFrom, String material1){
	    super();
	    this.name = name;
	    this.price = price;
	    this.color = color;
	    this.useAge = useAge;
	    this.madeFrom = madeFrom;
	    this.material1 = material1;
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

	public int getMadeFrom() {
		return madeFrom;
	}

	public void setMadeFrom(int madeFrom) {
		this.madeFrom = madeFrom;
	}

	public String getMaterial1() {
		return material1;
	}

	public void setMaterial1(String material1) {
		this.material1 = material1;
	}
	
	
	@Override
	public String toString() {
		return "이름 : " + name + " / 가격 : " + price + " / 색상 : " + color + 
				" / 사용가능 연령 : " + useAge + " / 제조년월일 : " + madeFrom + " / 재료 : "
				+ material1 ;
	}

	
	
	
}
