package home.run;

import home.service.BookService;

public class Run {

	public static void main(String[] args) {
		
		BookService bs = new BookService();
	
		bs.displayMenu();
	}
		
}
