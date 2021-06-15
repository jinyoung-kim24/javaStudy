package newbook.libray;

import newbook.Book;

public class Library2 {

	public static void main(String[] args) {
		

		Book bk1 = new Book();
		bk1.printBook();	
		//
		Book bk2 = new Book("이상한나라엘리스", "루이스 캐럴", 1);
		bk2.printBook();
		
		Book bk3 = new Book(127, "황금알을 낳는 거위", "김진영", 2);
		bk3.imgPath = "jinyoung/goose.png";
		bk3.ISBN = "00000000000123";
		bk3.comment = Book.NO_COMMENT; // 클래스 상수 초기화.
		bk3.printBook();
		
		Book bk4 = new Book("꽁쥐팥쥐전", "진영");
		bk4.printBook();
		
		
	}

}
