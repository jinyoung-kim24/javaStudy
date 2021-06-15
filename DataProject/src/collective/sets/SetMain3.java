package collective.sets;

import java.util.HashSet;

public class SetMain3 {

	// '���ڿ�' ������ �ϳ� �Է¹޾� �� ����, �� ��ҵ��� ����ϴ� �Լ�
	public static void printSet(HashSet<String> hs) {
		if (hs == null) {
			System.out.println("������ ��!");
			return;
		}
		System.out.println("# ���α׷��� ����: " + hs.size());
		if (hs.isEmpty()) {
			System.out.println("�� ���� �Դϴ�. empty");
		} else {
			for (String prog : hs) {
				System.out.println("* " + prog + "���");
			}

			System.out.println("------------------");
		}
	}

//	 ���� Set (��Ʈ)
//	 *    	(Ư�� Ÿ����) ��ҵ��� �ϳ��� ���� ���� ������� ��.
//	 *     ������ȣ(index) ���� ���� ����(���� ��ü�� �ǹ̸� �ο����� ����)
//	 *     �ڹٿ����� ��, ������ ��ҵ��� �ߺ��Ǵ� ���� ������� ����.
//	 *     ��� ��ҵ��� ���� ���۷��� �� '��ü'�� ������.
//	 *    	https://docs.oracle.com/javase/8/docs/api/java/util/Set.html

	public static void main(String[] args) {

		// ���(Element)Ÿ���� ������ Ư������
		// <E> ���Ÿ���� �����ϴ� ���׸�(Generic) - Ÿ���Ķ���� ����
		HashSet<String> hs2 = new HashSet<>();
//		hs2.add(���忭��;
		hs2.add("java");
//		hs2.add() // ���׸� Ÿ�� �Ķ���� ���ѹ޾� ����
		hs2.add("python");
		hs2.add("ruby");
		hs2.add("javascript");
		hs2.add("go");
		hs2.add("swift");
		hs2.add("kotlin");
		SetMain3.printSet(hs2);

		hs2.add("typescript");
		hs2.add("php");
		hs2.add("swift"); // �ߺ� x (������ �ߺ��� ������� ����)

		printSet(hs2);
		
		hs2.remove("typescript");
		hs2.remove("go");
		hs2.remove("java");

		printSet(hs2);
		hs2.clear(); // ��� ��Ҹ� �����÷��ǿ��� ����
		printSet(hs2);
		hs2.add("dart");
		printSet(hs2);
		

	}

}
