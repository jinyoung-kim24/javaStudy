package book2;

public class MyLibrary3 {

	public static void main(String[] args) {
		//MyBook book = null; // ���ο� Ÿ�� MyBook Ŭ������ ���� book ����
//		System.out.println(book.toString());
		MyBook book = new MyBook(); // Ŭ������ ������ �̸��� �Լ�(�������Լ� constructor)�� 
		// �ݵ�� new�� �Բ� �ѹ��� �����ؼ� ��ü�� ��������.
		// ������� ��ü�� book ������ ����,
		
		// ��ü�� Ŭ������ ���·� ��������� �ϳ��� ������ ��
		// �� ��ü ���� �Լ��� ������ ������� ��ü��.ooo�� �������ٰ���
//		book.bookTitle = "�ڹٰ� ���� ������!";
//		book.bookAuthor = "���ӽ� ����";
//		book.bookGenre = "IT ����";
//		book.bookPages = 500;
//		book.bookPrice = 30000;
//		
//		
//		MyBook book2 = new MyBook(); // ��ü�� �¾�� �ϱ�����
//		// JVM�� �޸𸮸� Ȯ���ϰ� ���� �����͸� �ʱ�ȭ�Ͽ�
//		// book2 ������ ��ü�� ����Ŵ
//		book2.bookAuthor = "��� ��� ������";
//		book2.bookTitle = "���� �Ӹ� ��";
//		book2.bookGenre = "�Ҽ�/����";
//		book2.bookPrice = 16800;
//		book2.bookPages = 532;
//		
//		
//		book.printBook();
//		book2.printBook();
		
		MyBook book3 = new MyBook(); // ��ü����
		book3.init(); // ��ü �ʱ�ȭ  
		book3.printBook(); // ��ü ���
		
		MyBook book4 = new MyBook();
		book4.init("�ȳ� �� - ���� ����� ����..", "���� ����", "�Ҽ�/����",
				300, 20000, 2, 0,
				4.89f, "987654321222", "� ���� �߾��� ���ϻ����ϳ׿�!!");
		book4.printBook();

		

		MyBook book5 = new MyBook();
		book5.init("�����̾߱�", "�����ҳ�", "ȯ��/���",
				100, 14900, 3, 1,
				1.32f, "987654321333", "������ ���� ���� �ʾƿ�");
		book5.printBook();
		
		
	}
}