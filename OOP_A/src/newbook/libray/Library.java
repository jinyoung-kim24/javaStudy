package newbook.libray;

import newbook.Book;

public class Library {

	public static void main(String[] args) {
		// Book bk1; // ����
		// ��ü�� �ݵ�� Ŭ����(���赵)�� ����
		// new �������Լ�() ȣ��θ� �޸𸮿� ������
		// (�������Լ� == Ŭ������ �����̸��Լ�)

		Book bk1 = new Book();
		// new�� ���� Book Ÿ�� ��ü�� ������� ����
		// JVM �޸𸮰� Ȯ���ǰ� �� ������
		// ������ Book() �Լ��� ���� �ʵ� �������� �ʱ�ȭ��.
		// �������� �� å��ü�� �ּ�(��ġ)�� bk1�� �˷���
		// (å ��ü ��� �ִ��� ������)
//		System.out.println(bk1);
		// newbook.Book@15db9742
		bk1.printBook();	
		//
		Book bk2 = new Book("�̻��ѳ��󿤸���", "���̽� ĳ��", 1);
		bk2.printBook();
		
		Book bk3 = new Book(127, "Ȳ�ݾ��� ���� ����", "������", 2);
		bk3.imgPath = "jinyoung/goose.png";
		bk3.ISBN = "00000000000123";
		bk3.comment = Book.NO_COMMENT; // Ŭ���� ��� �ʱ�ȭ.
		bk3.printBook();
		
		
		
		
	}

}
