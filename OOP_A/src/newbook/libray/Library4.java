package newbook.libray;

import newbook.Book;

public class Library4 {

	public static void main(String[] args) {
		

//		Book bk1 = new Book();
//		bk1.no = 101;
//		bk1.printBook();	
		//
		Book bk2 = new Book("�̻��ѳ��󿤸���", "���̽� ĳ��", 1);
		bk2.no = 102;
		bk2.changeRate(2.44f);
		bk2.printBook();
		
		Book bk3 = new Book(103, "Ȳ�ݾ��� ���� ����", "������", 2);
		bk3.imgPath = "jinyoung/goose.png";
		bk3.ISBN = "00000000000123";
		bk3.comment = Book.NO_COMMENT; // Ŭ���� ��� �ʱ�ȭ.
		bk3.changeRate(1.26f);
		bk3.printBook();
		bk3.changeRate(3.99f);
		bk3.printBook();
		Book bk4 = new Book("����������", "����");
		bk4.no = 104;
		bk4.rate = 3.21f;
		bk4.printBook();
		
		Book bk5 = new Book("���� �ƺ� ������ �ƺ� 20�ֳ� Ư�� �����", "����Ű", 2, "giyo/richdad.jpg",
				"8908098200123", 105, 3.45f, "���ڵǰ� ������");
//		bk5.rate = bk5.rate - 5.0f; // -1.55f
//		bk5.changeRate(-1.55f);
//		boolean b = bk5.changeRate(-1.55f);
		if(bk5.changeRate(-1.55f) == true) {
		bk5.printBook();
		}else {
			System.out.println("����ó���� ���� �߻� (�缭 ȣ��): " + bk5.no + "�� å" + bk5.title);
		}
		

		Book bk6 = new Book("�ȳ� �� - ����� ���� �̾߱�", "����", 3, "red/book/ann.gif",
				"8908098111222", 106, 4.45f, "�߾��� ���ϻ��� ���ƿ�");
		bk6.printBook();
	}

}
