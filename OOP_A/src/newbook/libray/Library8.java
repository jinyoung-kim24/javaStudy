package newbook.libray;
//import newbook.Book; // ��������� Book Ÿ���� �����ϰڴٴ� ����.
import newbook.*; // newbook ��Ű�� ���� ��� Ÿ�Ե��� �����ؼ� ����ϰڴٰ� ����.

public class Library8 {

	public static void main(String[] args) {
		Book bk1 = new Book("4�� �̾߱�", "���", 
				5, "japan/aprilstory.png", 
				"4789666611300", 1, 
				4.01f, Book.NO_COMMENT);
//		double e = Math.E;
		
		Book bk2 = new Book("�� �̾߱�", "���", 
				1, "jaewook/springstory.png", 
				"4789666611302", 2, 
				3.43f, Book.NO_COMMENT);
		
		Book bk3 = new Book("���� �̾߱�", "���", 
				1, "jaewook/springstory.png", 
				"4789666611303",3, 
				1.02f, Book.NO_COMMENT);
		
		Book bk4 = new Book("���� �̾߱�", "���", 
				1, "jaewook/springstory.png", 
				"4789666611304", 4, 
				5.00f, "��� �����...!");
		
		Book bk5 = new Book("�ܿ� �̾߱�", "���", 
				1, "jaewook/springstory.png", 
				"4789666611305", 5, 
				2.82f, Book.NO_COMMENT);
		//
		// ���� Ÿ�� Book Ÿ�� ��ü�� 5��.. ��� ���� �Լ� printBook()��
		// �����ϴ� ���� ����. �׸��� �������� 1~5������ ������ȣ�� ���̴� ����.
		// => �迭�� ���� �� �ֳ�!!
		//String[] strarr = { "aaa", "eee", "bbbb" };
//		String[] strarr = { 
//				new String("aaa"),
//				new String("eee"), 
//				new String("bbbb")
//		};
		Book[] books = {  // �迭�� å���� �ϳ��� �������.. 
			bk1, bk2, bk3, bk4, bk5,
			new Book("�����Ѽ����ϱ�", "����")
		}; // 0 ~ 5
		//Book bk6 = books[5]; // ������ å
//		Book bk6 = books[books.length-1]; // ������ å
//		bk6.no = 6;
//		bk6.increaseRate();	
		books[books.length-1].no = 6;
		books[books.length-1].increaseRate();
		
		// å ����Ʈ ���� ���
		System.out.println("=== ������ �԰� ���� ���� ����Ʈ ("+books.length+"��) ===");
		System.out.println("-----------------------------");
		System.out.println("|  ��ȣ   |    ����          |  ����     |  ����    |");
		System.out.println("-----------------------------");
		for (int i = 0; i < books.length; i++) {
			System.out.printf("| #%03d�� | ", i+1);
			System.out.print(
					books[i].title + " | "  +
					books[i].author + " ���� | " +
					books[i].rate + "�� | "
					);
			System.out.println();
		}
		System.out.println("-----------------------------");
		
//		for (int i = 0; i < books.length; i++) {
//			System.out.printf("Library%03d�� ����: ", i+1);
//			books[i].printBook();
////			Book bk = books[i]; //�迭�� i��° å ��ü�� ���ʷ� bk ������ ��� ����.
////			bk.printBook();
//		}
		
//		bk1.printBook();
//		bk2.printBook();
//		bk3.printBook();
//		bk4.printBook();
//		bk5.printBook();
	}

}

/*

=== ������ �԰� ���� ���� ����Ʈ (6��) ===
-----------------------------
|  ��ȣ   |    ����          |  ����     |  ����    |
-----------------------------
| #001�� | 4�� �̾߱� | ��� ���� | 4.01�� | 
| #002�� | �� �̾߱� | ��� ���� | 3.43�� | 
| #003�� | ���� �̾߱� | ��� ���� | 1.02�� | 
| #004�� | ���� �̾߱� | ��� ���� | 5.0�� | 
| #005�� | �ܿ� �̾߱� | ��� ���� | 2.82�� | 
| #006�� | �����Ѽ����ϱ� | ���� ���� | 0.5�� | 
-----------------------------


>> ���� [�����Ѽ����ϱ�]��  ������ 0.5���� ����Ǿ����ϴ�.
Library001�� ����: ������ å: #BK-000001 
����: 4�� �̾߱�
				��� ����
	���ǻ�: �Ϻ���ȭ��
	Ŀ��ǥ��: japan/aprilstory.png
	ISBN: 4789666611300
		 ����: (<<�ڡڡڡڡ�>>) 4.01/5.0 pt 
		 ����: ��۾��� 
-----------------------------
Library002�� ����: ������ å: #BK-000002 
����: �� �̾߱�
				��� ����
	���ǻ�: �����
	Ŀ��ǥ��: jaewook/springstory.png
	ISBN: 4789666611302
		 ����: (<<�ڡڡڡ١�>>) 3.43/5.0 pt 
		 ����: ��۾��� 
-----------------------------
Library003�� ����: ������ å: #BK-000003 
����: ���� �̾߱�
				��� ����
	���ǻ�: �����
	Ŀ��ǥ��: jaewook/springstory.png
	ISBN: 4789666611303
		 ����: (<<�ڡ١١١�>>) 1.02/5.0 pt 
		 ����: ��۾��� 
-----------------------------
Library004�� ����: ������ å: #BK-000004 
����: ���� �̾߱�
				��� ����
	���ǻ�: �����
	Ŀ��ǥ��: jaewook/springstory.png
	ISBN: 4789666611304
		 ����: (<<�ڡڡڡڡ�>>) 5.00/5.0 pt 
		 ����: ��� �����...! 
-----------------------------
Library005�� ����: ������ å: #BK-000005 
����: �ܿ� �̾߱�
				��� ����
	���ǻ�: �����
	Ŀ��ǥ��: jaewook/springstory.png
	ISBN: 4789666611305
		 ����: (<<�ڡڡڡ١�>>) 2.82/5.0 pt 
		 ����: ��۾��� 
-----------------------------
Library006�� ����: ������ å: #BK-000006 
����: �����Ѽ����ϱ�
				���� ����
	���ǻ�: �������ǻ�
	Ŀ��ǥ��: default/dummy.png
	ISBN: 9876543210123
		 ����: (<<�ڡ١١١�>>) 0.50/5.0 pt 
		 ����: ��۾��� 
-----------------------------
*/