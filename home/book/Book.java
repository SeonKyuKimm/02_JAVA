package home.book;

public class Book implements Comparable<Book>{

	// 도서 정보를 담는 클래스 
	private int bookNum; // 도서 번호
	private String name; // 책 제목
	private String author; // 저자
	private int price; // 가격
	private String company; // 출판
	
	public void Book() {}

	public Book(int boonNum, String name, String author, int price, String company) {
		super();
		this.bookNum = boonNum;
		this.name = name;
		this.author = author;
		this.price = price;
		this.company = company;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	@Override
	public String toString() {
		return bookNum + "번 도서 : [도서제목 : " + name + " / 도서저자 : " + author + " / 도서가격 : " + price + " / 출판사 : " + company+"]";
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
