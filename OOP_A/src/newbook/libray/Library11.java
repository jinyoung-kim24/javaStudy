package newbook.libray;
import newbook.human.Librarian;
import java.util.Date;
import newbook.Book;
public class Library11 {

	public static void main(String[] args) {
		// 사서(Actor) 등장
		Librarian man1 = new Librarian();
		man1.name = "엘사";
		man1.age = 19;
		man1.gender = Librarian.GENDER_FEMALE;
		man1.printLibrarian(true);
		// 풀생성자
		Librarian man2 = new Librarian("동현", 23, Librarian.GENDER_MALE, "서울시 왕십리",
				2, new Date(), Librarian.LIB_POS[Librarian.LIB_POS_과장], "대여관리 경력 3년");
		man2.printLibrarian(true);
		
		Librarian man3 = new Librarian("스파이더맨", 29, Librarian.GENDER_FEMALE);
		man3.libNum = 3;
		man3.major = "부정 열람/대여 감시 등";
		man3.printLibrarian(false);
		
		// 사서 5명 모집
		Librarian[] libMans = {man1, man2, new Librarian("안나", 17, Librarian.GENDER_FEMALE),
				man3, new Librarian("아이언맨", 46, Librarian.GENDER_MALE) };
				Librarian lib = libMans[4];
				lib.pos = Librarian.LIB_POS[Librarian.LIB_POS_수석];
				lib.major = "도서관 총관리자";
				System.out.println("==============================");
				// 사서 리스트 간이 출력
				for (int i = 0; i < libMans.length; i++) {
					System.out.printf("[] 사서%d : 이름 %s (%d세) - 직급%s\n",
							i+1, libMans[i].name, libMans[i].age, (libMans[i].pos == null ? "미정" : libMans[i].pos));
				}
				
	}
}
