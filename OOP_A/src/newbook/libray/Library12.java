package newbook.libray;
import newbook.human.Librarian;
import java.util.Date;
import newbook.Book;
public class Library12 {

	public static void main(String[] args) {
		// �缭(Actor) ����
		Librarian man1 = new Librarian();
		man1.name = "����";
		man1.age = 19;
		man1.gender = Librarian.GENDER_FEMALE;
	
		// Ǯ������
		Librarian man2 = new Librarian("����", 23, Librarian.GENDER_MALE, "����� �սʸ�",
				2, new Date(), Librarian.LIB_POS[Librarian.LIB_POS_����], "�뿩���� ��� 3��");
		
		
		Librarian man3 = new Librarian("�����̴���", 29, Librarian.GENDER_FEMALE);
		man3.libNum = 3;
		man3.major = "���� ����/�뿩 ���� ��";
		
		
		// �缭 5�� ����
		Librarian[] libMans = {man1, man2, new Librarian("�ȳ�", 17, Librarian.GENDER_FEMALE),
				man3, new Librarian("���̾��", 46, Librarian.GENDER_MALE) };
				Librarian lib = libMans[4];
				lib.pos = Librarian.LIB_POS[Librarian.LIB_POS_����];
				lib.major = "������ �Ѱ�����";
				System.out.println("==============================");
				// �缭 ����Ʈ ���� ���
				for (int i = 0; i < libMans.length; i++) {
					System.out.printf("[] �缭%d : �̸� %s (%d��) - ����%s\n",
							i+1, libMans[i].name, libMans[i].age, (libMans[i].pos == null ? "����" : libMans[i].pos));
				}
				System.out.println();
				System.out.println("===============================");
				int libIdx = 1;
				for(Librarian human : libMans) { // ���� ������ for��
					System.out.print("�缭�� #" + libIdx++);
					String name = human.name;
					System.out.println("�̸�: " + name + ", ����: " + (human.gender == Librarian.GENDER_FEMALE ? 
							"Female" : "Male")
							+ ", �ּ�: " + (human.address == null ? "�����" : human.address));
					human.printLibrarian(true);
				}
//				int libIdx = 1;
//				for(Librarian human : libMans) { // ���� ������ for��
//					System.out.print("�缭�� #" + libIdx++);
//					human.printLibrarian(true);
//				}
	}
}
