package books;

// Ŭ���� class ���� == java���� Ŭ������ ���ο� Ÿ���� ����°�.
// 	���赵....? 
// ��ü�������� ���󿡼� (�� ������ ��ü������ ���������� 3����)
// ��ü object��� ���� Ŭ������ ������ ��ü���� ���� ������� ����.
// 'å' �̶�� ����(��Ű�� Schema)�� Ŭ������ ǥ�� 
// �ش� ��Ű���� Ư¡���� Ŭ������ ������ҷ� ��ƾ� ��.
// å�� ���ø���.. ����, �о�(�帣), ����, ���ǻ�, �ʼ�, ���� (���ڵ�), ǥ��... 
// Ŭ������ �̷� Ư¡�� ���� ������� ǥ������ �ʰ� �� �������� �ϳ��� Ŭ���� ���� ����,
// ���⿡ ��Ű���� ó���� ����� ��ɵ��� �Լ��ν� �ش� Ŭ���� �����ؼ� ������
// ��, Ŭ������ ���� ������� (�ʵ�, �Ӽ�property) + ���� ���(�Լ� �޼ҵ�)��� ǥ����
// class = fields + methods
// ���� ������� ��� ������� �Լ� �������(�޼ҵ�)
// Ŭ������ ���ο� Ÿ���� ���� " �����Ϳͱ���� �ϳ��� ���� ���赵��)
// java������ Ư�� Ŭ������ ��ü�� �ڹ� JVM�޸� ���� �¾�� �ϱ� ���� 
// �ݵ�� new�� ������ ��ġ�� new �������� ����Ǹ� ��ü�� Ȱ����.

// å��Ű�� ǥ�� (���赵)
public class MyBook {
	// ������ ǥ��(�ʵ�)-------------------
	// (����) ��� �ʵ�
	public static final int DEF_PRICE = 2900;
	public static final String DEF_GENRE = "�Ҽ�";
	
	// ���� �ʵ�(�������)
	String bookTitle; // ����
	String bookGenre; // �о�(�帣)
	String bookAuthor; // ����(�̸�)
	int bookPages; // �ʼ�
	int bookPrice; // ����
	
	// ��� ǥ��(�޼ҵ�, ����Լ�)
	public void printBook() {
		System.out.println("BOOK");
		System.out.println("\t ����: " + bookTitle);
		System.out.println("\t �о�: " + bookGenre);
		System.out.println("\t ����(������): " + bookPrice + "won");
		System.out.println("\t ����: " + bookAuthor + "��");
		System.out.println("\t �ʼ�: " + bookPages + "PP");
		System.out.println("---------------------------------------");
		
				
	}
	
	

}