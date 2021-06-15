package collective.sets;

import java.util.HashSet;

public class SetMain1 {
	
//	 ���� Set (��Ʈ)
//	 *    	(Ư�� Ÿ����) ��ҵ��� �ϳ��� ���� ���� ������� ��.
//	 *     ������ȣ(index) ���� ���� ����(���� ��ü�� �ǹ̸� �ο����� ����)
//	 *     �ڹٿ����� ��, ������ ��ҵ��� �ߺ��Ǵ� ���� ������� ����.
//	 *     ��� ��ҵ��� ���� ���۷��� �� '��ü'�� ������.
//	 *    	https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
	
	public static void main(String[] args) {
		// �Ϲ�����
		HashSet hs = new HashSet(); 
		// �����÷����� ��Ұ� 0��, size = 0
		// �÷���, �� ������ ������� ������(������)
		hs.add(123); // new Integer(123) ������ü
		hs.add(3.14f); // new Float(3.14) �Ǽ���ü
		hs.add('A'); // new Character('A') ���ڰ�ü
		hs.add("xyz"); // new String("xyz")
//		hs.add(������Ʈ��)
		// ��� Ÿ���� ���(��ü)�� ���տ� add��?
		System.out.println("����hs��ũ�� = " + hs.size());
		
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
		System.out.println("# ���α׷��� ����: " + hs2.size());
		for (String prog : hs2) {
			System.out.println("* " + prog + "���");
		}
		
		System.out.println("------------------");
		
		hs2.add("typescript");
		hs2.add("php");
		hs2.add("swift"); // �ߺ� x (������ �ߺ��� ������� ����)
		
		System.out.println("# ���α׷��� ����: " + hs2.size());
		for (String prog : hs2) {
			System.out.println("* " + prog + "���");
		}
		
		System.out.println("------------------");
		
		hs2.add(String.valueOf(1234)); // "1234"
		hs2.add(String.valueOf(3.141592));
		hs2.add(String.valueOf('��'));
		hs2.add(String.valueOf(true));
		hs2.add(""+1234); // �ߺ��� ������� ����
		System.out.println("# ���α׷��� ����: " + hs2.size());
		for (String prog : hs2) {
			System.out.println("* " + prog + "���");
		}
	}

}
