package book2;

public class MyLibrary3 {

	public static void main(String[] args) {
		//MyBook book = null; // 새로운 타입 MyBook 클래스형 변수 book 선언
//		System.out.println(book.toString());
		MyBook book = new MyBook(); // 클래스와 동일한 이름의 함수(생성자함수 constructor)를 
		// 반드시 new와 함께 한번만 실행해서 객체를 만들어야함.
		// 만들어진 객체가 book 변수에 기억됨,
		
		// 객체는 클래스의 형태로 만들어져서 하나의 범위가 됨
		// 즉 객체 안의 함수들 변수들 상수들은 객체명.ooo로 선택접근가능
//		book.bookTitle = "자바가 제일 쉬워요!";
//		book.bookAuthor = "제임스 고즐링";
//		book.bookGenre = "IT 개발";
//		book.bookPages = 500;
//		book.bookPrice = 30000;
//		
//		
//		MyBook book2 = new MyBook(); // 객체를 태어나게 하기위해
//		// JVM에 메모리를 확보하고 이후 데이터를 초기화하여
//		// book2 변수를 객체를 기억시킴
//		book2.bookAuthor = "루시 모드 몽고베리";
//		book2.bookTitle = "빨강 머리 앤";
//		book2.bookGenre = "소설/고전";
//		book2.bookPrice = 16800;
//		book2.bookPages = 532;
//		
//		
//		book.printBook();
//		book2.printBook();
		
		MyBook book3 = new MyBook(); // 객체생성
		book3.init(); // 객체 초기화  
		book3.printBook(); // 객체 출력
		
		MyBook book4 = new MyBook();
		book4.init("안녕 앤 - 앤이 어렸을 적에..", "버지 월슨", "소설/고전",
				300, 20000, 2, 0,
				4.89f, "987654321222", "어린 적의 추억이 새록새록하네요!!");
		book4.printBook();

		

		MyBook book5 = new MyBook();
		book5.init("날씨이야기", "날씨소년", "환경/기상",
				100, 14900, 3, 1,
				1.32f, "987654321333", "날씨가 전혀 맞지 않아요");
		book5.printBook();
		
		
	}
}