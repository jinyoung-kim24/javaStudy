package newbook.libray;
//import newbook.Book; // ��������� Book Ÿ���� �����ϰڴٴ� ����.
import newbook.*; // newbook ��Ű�� ���� ��� Ÿ�Ե��� �����ؼ� ����ϰڴٰ� ����.

public class Library9 {

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
		System.out.println("|  ��ȣ   |    ����          |  ����     |  ���ǻ�  |  ����    |");
		System.out.println("-----------------------------");
		for (int i = 0; i < books.length; i++) {
			System.out.printf("| #%03d�� | ", i+1);
			int pubNo = books[i].publisher;
			System.out.print(
					books[i].title + " | "  +
					books[i].author + " ���� | " +
					Book.PUB_NAMES[pubNo] + " | " +
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
		
		// �迭�� ������ ����°��� new Ÿ��[����]
		int[] intarr = { 1, 2, 3, 4, 5};
		int[] intarr2 = new int[5]; // 5���� ������ �� ���� Ȯ��
		String[] strarr = new String[5]; // 5���� ���ڿ�(��ü)���� �ڸ����� �޸� ���� Ȯ�� ��û
		// å ���� �迭 ������ �ټ��� å ��ü���� ��ġ�� ���� Ȯ��
		// å����, å�ڽ�, å����, å��, �Ͻ��ĵ�......
		Book[] bookarr = new Book[5]; // null�� 5���� �ʱ�ȭ
		// å ��ü�� �ִ� 5�Ǳ��� �����ϰ� �����Ҽ� �ִ� �迭 ���� ����.
		// 
		
	}
	

}
