package newbook.libray;

import newbook.Book;

public class Library {

	public static void main(String[] args) {
		// Book bk1; // 선언
		// 객체는 반드시 클래스(설계도)에 따라서
		// new 생성자함수() 호출로만 메모리에 생성됨
		// (생성자함수 == 클래스와 동일이름함수)

		Book bk1 = new Book();
		// new를 통해 Book 타입 객체가 만들어진 공간
		// JVM 메모리가 확보되고 그 공간에
		// 생성자 Book() 함수를 통해 필드 변수등이 초기화됨.
		// 마지막에 이 책객체의 주소(위치)를 bk1에 알려줌
		// (책 객체 어디 있는지 저장함)
//		System.out.println(bk1);
		// newbook.Book@15db9742
		bk1.printBook();	
		//
		Book bk2 = new Book("이상한나라엘리스", "루이스 캐럴", 1);
		bk2.printBook();
		
		Book bk3 = new Book(127, "황금알을 낳는 거위", "김진영", 2);
		bk3.imgPath = "jinyoung/goose.png";
		bk3.ISBN = "00000000000123";
		bk3.comment = Book.NO_COMMENT; // 클래스 상수 초기화.
		bk3.printBook();
		
		
		
		
	}

}
