package books;

public class MyLibrary {

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
		
		book.printBook();
		
		
		
		
		
		
		
	}
}