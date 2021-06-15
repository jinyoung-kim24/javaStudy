package newbook.libray;
import newbook.human.Librarian;
import java.util.Date;
import newbook.Book;
public class Library10 {

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
	}

}
