package newbook.libray;
import newbook.human.Librarian;
import java.util.Date;
import newbook.Book;
public class Library10 {

	public static void main(String[] args) {
		// �缭(Actor) ����
		Librarian man1 = new Librarian();
		man1.name = "����";
		man1.age = 19;
		man1.gender = Librarian.GENDER_FEMALE;
		man1.printLibrarian(true);
		// Ǯ������
		Librarian man2 = new Librarian("����", 23, Librarian.GENDER_MALE, "����� �սʸ�",
				2, new Date(), Librarian.LIB_POS[Librarian.LIB_POS_����], "�뿩���� ��� 3��");
		man2.printLibrarian(true);
	}

}
