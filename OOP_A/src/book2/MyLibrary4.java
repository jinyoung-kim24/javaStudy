package book2;

public class MyLibrary4 {

	public static void main(String[] args) {

		
		MyBook book4 = new MyBook("�ȳ� �� - ���� ����� ����..", "���� ����", "�Ҽ�/����",
				300, 20000, 2, 0,
				4.89f, "987654321222", "� ���� �߾��� ���ϻ����ϳ׿�!!"); // ������ ���� �ʱ�ȭ
		book4.printBook();

		

		MyBook book5 = new MyBook();
		book5.init("�����̾߱�", "�����ҳ�", "ȯ��/���",  // ���� �� ���� ����
				100, 14900, 3, 1,
				1.32f, "987654321333", "������ ���� ���� �ʾƿ�");
		book5.printBook();
		
		MyBook book6 = new MyBook();
		book6.printBook();
		
		
		
	}
}