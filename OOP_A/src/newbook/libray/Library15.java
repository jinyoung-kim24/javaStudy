package newbook.libray;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;
import newbook.libraytools.Bookshelf;
public class Library15 {
	
	// 도서를 사서가 도서관 책장에 입고처리하다.
	// 입고처리하면...
	// 해당 도서의 상태가 '도장이 찍혀서' stamp 필드가 true로 변경됨.
	// + 그리고 comment 필드에 해당 도서를 입고한 담당 사서의 이름과 입고내역이 기록됨.
	// 도서 객체와 사서 객체가 연동되는 함수
	public static void registerNewBookToLibrary(
			Book newBook, Librarian man) {
		if(newBook == null || man == null) {
			System.out.println("책이 없거나 사서가 없어서 입고처리 못함!!");
			return;
		}
		//if(newBook.stamp == false) { // 입고전 책이라면
		if(newBook.isBookRegister() == false) {
			newBook.stamp = true; // 도장찍기 (상태바뀜)		
			newBook.comment += "\n[입고기록] 양품 책입니다. by " + man.name + "(" + man.libNum + ")"
					+ "/처리시간 - " + new Date();
					
		}else {
			System.out.println(">> 이미 입고된 책이네요!!");
			// 이미 누가 이전에 도장은 찍은 책이네요!
		}
	}
	
	
	public static void main(String[] args) {
		Book bk1 = new Book(
				"부자 아빠 가난한 아빠 20주년 특별 기념판", 
				"기요사키", 4, 
				"giyo/richdad.jpg",
				"8908098200123", 
				101, 3.45f, "부자되고 싶은데...");
		
		Book bk2 = new Book(
				"안녕 앤 - 어린시절 앤의 이야기",				 
				"윌슨", 5,				
				"red/book/ann.gif",
				"8908098111222", 
				102, 5.00f, "추억이 새록새록 좋아요! ^_^");
	
		// 책 상자 배열에 책들을 임시로 일단 담아두자..
		Book[] bookBox = {
				new Book(104, "일본어 첫걸음", 
						"일본어동아리", 4),
				bk1, bk2, 
				new Book("월든", "헨리 데이비드 소로우", 
						2, "classic/walden.png", 
						"8908098111332", 
					103, 4.37f, "고전 좋아요!"), new Book("홍길동뎐", "허균")				
		}; // 도서 4권을 표현한 배열... 
		
		// 책 박스 내역 확인 
		for(Book book : bookBox) {
			System.out.println("#"+ book.no 
					+ ", 제목: " + book.title 
					+ ", 저자: " + book.author +" 님" );
		}
				
		// 사서(Actor) 등장
		Librarian man1 = new Librarian();// 기본생성자
		man1.name = "엘사";
		man1.age = 19;
		man1.gender = Librarian.GENDER_FEMALE; //1;
		//System.out.println(man1); // newbook.human.Librarian@33909752

		Librarian man2 = new Librarian( // 풀생성자
				"동현", 23, Librarian.GENDER_MALE, 
				"서울시 왕십리", 2, 
				new Date(), 
				Librarian.LIB_POS[Librarian.LIB_POS_대리], 
				"대여관리 경력 3년"); 
				//"프리랜서", major); // 순서, 개수, 타입
		
		Librarian man3 = new Librarian("스파이더맨",
				29, Librarian.GENDER_FEMALE);
		man3.libNum = 3;
		man3.major = "부정 열람/대여 감시 등";
		
		// 책장배치
		Bookshelf bs1 = new Bookshelf(1001, "나무/ 2010년/- 인문/교양A", 1); // 4권 수용량
		
		Bookshelf bs2 = new Bookshelf(1004, "철제, 2020년 - IT/개발", 2, 10); // 10권	
		
		Bookshelf bs3 = new Bookshelf(1011, "플라스틱, 2021년 - 입고/열람 대기용", 3, bookBox.length, bookBox); // 책박스 배열 통쨰로 입력.
		
		bs1.printBookshelf();
		System.out.println();
		bs2.printBookshelf();
		System.out.println();
		bs3.books[2] = Bookshelf.EMPTY;// 안녕 앤을 다른 사서가 개인적으로 잠시 책장에서 뽑아서 보고있음. 
		bs3.printBookshelf();
	}

}
