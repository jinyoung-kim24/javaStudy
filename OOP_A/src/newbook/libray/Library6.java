package newbook.libray;

import newbook.Book;

public class Library6 {

	public static void main(String[] args) {
		

//		Book bk1 = new Book();
//		bk1.no = 101;
//		bk1.printBook();	
		//
		Book bk2 = new Book("이상한나라엘리스", "루이스 캐럴", 0);
		bk2.no = 102;
		bk2.changeRate(2.44f);
		bk2.printBook();
		
		Book bk3 = new Book(103, "황금알을 낳는 거위", "김진영", 1);
		bk3.imgPath = "jinyoung/goose.png";
		bk3.ISBN = "00000000000123";
		bk3.comment = Book.NO_COMMENT; // 클래스 상수 초기화.
		bk3.changeRate(1.26f);
		bk3.printBook();
		bk3.changeRate(3.99f);
		bk3.printBook();
		Book bk4 = new Book("꽁쥐팥쥐전", "진영", 2);
		bk4.no = 104;
		bk4.rate = 3.21f;
		bk4.increaseRate();
		bk4.increaseRate();
		bk4.printBook();
		
		Book bk5 = new Book("부자 아빠 가난한 아빠 20주년 특별 기념판", "기요사키", 3, "giyo/richdad.jpg",
				"8908098200123", 105, 3.45f, "부자되고 싶은데");
//		bk5.rate = bk5.rate - 5.0f; // -1.55f
//		bk5.changeRate(-1.55f);
//		boolean b = bk5.changeRate(-1.55f);
		if(bk5.changeRate(-1.55f) == true) {
		bk5.printBook();
		}else {
			System.out.println("평점처리에 문제 발생 (사서 호출): " + bk5.no + "번 책" + bk5.title);
		}
//		bk5.decreaseRate();
//		bk5.decreaseRate();
//		bk5.decreaseRate();
//		bk5.decreaseRate();
//		bk5.decreaseRate();
//		bk5.decreaseRate();SSystem.out.println("\t출판사: " + this.publisher);
//		bk5.decreaseRate();
		for (int i = 0; i < 7; i++) {
			bk5.decreaseRate();
		}
		bk5.printBook();
		
		

		Book bk6 = new Book("안녕 앤 - 어린시절 앤의 이야기", "월슨", 4, "red/book/ann.gif",
				"8908098111222", 106, 4.45f, "추억이 새록새록 좋아요");
		bk6.decreaseRate();
		bk6.decreaseRate();
		bk6.decreaseRate();

		bk6.printBook();
	}

}
