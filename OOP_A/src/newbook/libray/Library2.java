package newbook.libray;

import newbook.Book;

public class Library2 {

	public static void main(String[] args) {
		

		Book bk1 = new Book();
		bk1.printBook();	
		//
		Book bk2 = new Book("�̻��ѳ��󿤸���", "���̽� ĳ��", 1);
		bk2.printBook();
		
		Book bk3 = new Book(127, "Ȳ�ݾ��� ���� ����", "������", 2);
		bk3.imgPath = "jinyoung/goose.png";
		bk3.ISBN = "00000000000123";
		bk3.comment = Book.NO_COMMENT; // Ŭ���� ��� �ʱ�ȭ.
		bk3.printBook();
		
		Book bk4 = new Book("����������", "����");
		bk4.printBook();
		
		
	}

}
