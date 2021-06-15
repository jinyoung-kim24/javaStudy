package newbook.libray;
import newbook.human.Librarian;
import newbook.Book;
import java.util.Date;
import java.util.EnumMap;

import newbook.libraytools.Bookshelf;
public class Library16 {
	
	// ������ �缭�� ������ å�忡 �԰�ó���ϴ�.
	// �԰�ó���ϸ�...
	// �ش� ������ ���°� '������ ������' stamp �ʵ尡 true�� �����.
	// + �׸��� comment �ʵ忡 �ش� ������ �԰��� ��� �缭�� �̸��� �԰����� ��ϵ�.
	// ���� ��ü�� �缭 ��ü�� �����Ǵ� �Լ�
	public static void registerNewBookToLibrary(
			Book newBook, Librarian man) {
		if(newBook == null || man == null) {
			System.out.println("å�� ���ų� �缭�� ��� �԰�ó�� ����!!");
			return;
		}
		//if(newBook.stamp == false) { // �԰��� å�̶��
		if(newBook.isBookRegister() == false) {
			newBook.stamp = true; // ������� (���¹ٲ�)		
			newBook.comment += "\n[�԰���] ��ǰ å�Դϴ�. by " + man.name + "(" + man.libNum + ")"
					+ "/ó���ð� - " + new Date();
					
		}else {
			System.out.println(">> �̹� �԰�� å�̳׿�!!");
			// �̹� ���� ������ ������ ���� å�̳׿�!
		}
	}
	
	
	public static void main(String[] args) {
		Book bk1 = new Book(
				"���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� �����", 
				"����Ű", 4, 
				"giyo/richdad.jpg",
				"8908098200123", 
				101, 3.45f, "���ڵǰ� ������...");
		
		Book bk2 = new Book(
				"�ȳ� �� - ����� ���� �̾߱�",				 
				"����", 5,				
				"red/book/ann.gif",
				"8908098111222", 
				102, 5.00f, "�߾��� ���ϻ��� ���ƿ�! ^_^");
	
		// å ���� �迭�� å���� �ӽ÷� �ϴ� ��Ƶ���..
		Book[] bookBox = {
				new Book(104, "�Ϻ��� ù����", 
						"�Ϻ���Ƹ�", 4),
				bk1, bk2, 
				new Book("����", "� ���̺�� �ҷο�", 
						2, "classic/walden.png", 
						"8908098111332", 
					103, 4.37f, "���� ���ƿ�!"), new Book("ȫ�浿��", "���")				
		}; // ���� 4���� ǥ���� �迭... 
		
		// å �ڽ� ���� Ȯ�� 
		for(Book book : bookBox) {
			System.out.println("#"+ book.no 
					+ ", ����: " + book.title 
					+ ", ����: " + book.author +" ��" );
		}
				
		// �缭(Actor) ����
		Librarian man1 = new Librarian();// �⺻������
		man1.name = "����";
		man1.age = 19;
		man1.gender = Librarian.GENDER_FEMALE; //1;
		//System.out.println(man1); // newbook.human.Librarian@33909752

		Librarian man2 = new Librarian( // Ǯ������
				"����", 23, Librarian.GENDER_MALE, 
				"����� �սʸ�", 2, 
				new Date(), 
				Librarian.LIB_POS[Librarian.LIB_POS_�븮], 
				"�뿩���� ��� 3��"); 
				//"��������", major); // ����, ����, Ÿ��
		
		Librarian man3 = new Librarian("�����̴���",
				29, Librarian.GENDER_FEMALE);
		man3.libNum = 3;
		man3.major = "���� ����/�뿩 ���� ��";
		
		// å���ġ
		Bookshelf bs1 = new Bookshelf(1001, "����/ 2010��/- �ι�/����A", 1); // 4�� ���뷮
	
//		bs1.books[0] = new Book("4�� �̾߱�", "���", 2);
//		bs1.books[2] = new Book("5�� �̾߱�", "���", 2);
//		if(bs1.books[2] == Bookshelf.EMPTY)
//		bs1.books[2] = new Book("6�� �̾߱�", "���", 2);
		
		Bookshelf bs2 = new Bookshelf(1004, "ö��, 2020�� - IT/����", 2, 10); // 10��	
		
		Bookshelf bs3 = new Bookshelf(1011, "�ö�ƽ, 2021�� - �԰�/���� ����", 3, bookBox.length, bookBox); // å�ڽ� �迭 �뤊�� �Է�.
		
		bs1.printBookshelf();
		System.out.println(bs1.no + "�� å����" +
				(bs1.isFull() ? "��á�׿�." : "������ �ֳ׿�"));
		if(!bs1.isFull()) {
			bs1.addBook(0, new Book("���A", "EBS", 2));
			bs1.addBook(1, new Book("���B", "EBS", 2));
			bs1.addBook(2, new Book("���C", "EBS", 2));
			bs1.addBook(-1, new Book("�������", "disney", 4));
			bs1.addBook(5, new Book("�������again", "disney", 4));
			bs1.addBook(2, new Book("������� zero", "disney", 4));
		}
		bs1.printBookshelf();
		bs1.cleanBookshelf();
		bs1.printBookshelf();
		bs2.printBookshelf(true);
		System.out.println(bs2.no + "�� å����" +
				(bs2.isFull() ? "��á�׿�." : "������ �ֳ׿�"));
		for (int i = 0; i < 10; i++) {
			Book bk = new Book("������ �ڹ��̾߱�", "���ӽ� ���� guru", 1, "Origin/java.png",
					"0123456789000", i+1, 2.0f, "�ڹ� ���?");
			
			if(((int)(Math.random() * 6) +1 )% 2 == 0)
			registerNewBookToLibrary(bk, man3);
			
			bs2.addBook(i, bk);
		}
		bs2.printBookshelf(true);
		bs3.printBookshelf();
		System.out.println(bs3.no + "�� å����" +
				(bs3.isFull() ? "��á�׿�." : "������ �ֳ׿�"));
	}

}
