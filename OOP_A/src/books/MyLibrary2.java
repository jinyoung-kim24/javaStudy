package books;

public class MyLibrary2 {

	public static void main(String[] args) {
		//MyBook book = null; // ���ο� Ÿ�� MyBook Ŭ������ ���� book ����
//		System.out.println(book.toString());
		MyBook book = new MyBook(); // Ŭ������ ������ �̸��� �Լ�(�������Լ� constructor)�� 
		// �ݵ�� new�� �Բ� �ѹ��� �����ؼ� ��ü�� ��������.
		// ������� ��ü�� book ������ ����,
		
		// ��ü�� Ŭ������ ���·� ��������� �ϳ��� ������ ��
		// �� ��ü ���� �Լ��� ������ ������� ��ü��.ooo�� �������ٰ���
		book.bookTitle = "�ڹٰ� ���� ������!";
		book.bookAuthor = "���ӽ� ����";
		book.bookGenre = "IT ����";
		book.bookPages = 500;
		book.bookPrice = 30000;
		
		
		MyBook book2 = new MyBook(); // ��ü�� �¾�� �ϱ�����
		// JVM�� �޸𸮸� Ȯ���ϰ� ���� �����͸� �ʱ�ȭ�Ͽ�
		// book2 ������ ��ü�� ����Ŵ
		book2.bookAuthor = "��� ��� ������";
		book2.bookTitle = "���� �Ӹ� ��";
		book2.bookGenre = "�Ҽ�/����";
		book2.bookPrice = 16800;
		book2.bookPages = 532;
		
		
		book.printBook();
		book2.printBook();
		
		
		
	}
}