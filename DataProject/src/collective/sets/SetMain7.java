package collective.sets;

import java.util.HashSet;

public class SetMain7 {

	// ���հ� ���ջ����� ����
	// ������ setA n setB ����
	public static HashSet<Character> intersectionSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���");
			return null;

		}
		if (!setA.isEmpty() || setB.size() > 0) {
			HashSet<Character> intersection = new HashSet<Character>();
			for (Character c : setA) {
				if (setB.contains(c)) {
					intersection.add(c);
				}
			}
			return intersection;
		} else { // �� �� �ϳ� �̻��� ������
			return new HashSet<Character>(); // 0ũ���� ������
		}
	}

	public static void main(String[] args) {
		// HashSet<char> hs = new HashSet<char>(); // error
//		HashSet<Character> hs = new HashSet<Character>(); // ok
		// �ڹ� ���׸�, Ÿ�� �Ķ���� ����,������ ���� ����� Ÿ����
		// ��ü������ ���۷���Ÿ������ �����ؾ���. �⺻�� �ȵ�.. ����Ŭ���� �������.
		HashSet<Character> hsA = new HashSet<>(); // �����ڸ����� �� ���׸��̸��� ���� ������ ok
		HashSet<Character> hsB = new HashSet<Character>();
		
//
//		hsA.add('K');
//		hsA.add('G');
//		hsA.add('B');
		fillRandomCharToSet(hsA, 4);
		printCharSet(hsA, "�������� HS_A");

		// hsB �� ���տ� ������ �빮�� ���ڰ�ü ��Ҹ� 20�� ���� �Է��� �ֱ�
		fillRandomCharToSet(hsB, 14);

		printCharSet(hsB, "�������� ���� HS_B");
		// limit�� �빮�� ������ �Ѿ�� �ȵ�!! (���ѷ���!)

		
		// ���� ���� ����� (2�� �̻��� ���յ��� ���迬��)
		// ������(intersection)
//		HashSet<Character> intersection = intersectionSet(hsA, hsB); // ������{}
//		printCharSet(intersection, "������ setA n setB");
		printCharSet(MySets.intersectionSet(hsA, hsB),"������ setA n setB");
		printCharSet(MySets.unionSetReturn(hsA, hsB), "������ setA u setB");
		printCharSet(MySets.differenceSet(hsA, hsB), "������ setA - setB");
		printCharSet(MySets.differenceSet(hsB, hsA), "������ setB - setA");
		
	}

	// �Լ� ���ο��� ������ ���������Ͽ� �� ������ ä���� ������..
	public static HashSet<Character> fillRandomCharToSetReturn(int inputLimit) {
		HashSet<Character> hs = new HashSet<Character>();
//		fillRandomCharToSet(hs, inputLimit);
//		
		final int limit = inputLimit > 0 ? inputLimit : 20;
		for (int i = 0; i < limit; i++) {
			boolean b = false;
			do {
				char c = (char) ((int) (Math.random() * 26) + 'A'); //
				b = hs.add(c);
//				if( b == false )   // if( !b )
//					System.out.println(">> �ߺ��߰� !" + c);
			} while (b == false);
		}
		return hs;
	}

	// limit ������ŭ�� ���� �빮�� ��ҵ��� �Է����տ� ä���ִ� �Լ�
	public static void fillRandomCharToSet(HashSet<Character> hs, int inputLimit) {
		if (hs == null)
			hs = new HashSet<Character>();// ������
		final int limit = inputLimit > 0 ? inputLimit : 20;
		for (int i = 0; i < limit; i++) {
			boolean b = false;
			do {
				char c = (char) ((int) (Math.random() * 26) + 'A'); //
				b = hs.add(c);
			} while (b == false);
		}
	}

	public static void printCharSet(HashSet<Character> hs, String title) {
		System.out.println(title + " : " + hs.size());
		for (Character ch : hs) {
			System.out.printf("%c ", ch);
		}
		System.out.println("\n-------------------------------");
	}

}

/*
 * �������� HS_A 3 B G K �������� HS_B 20 A D E F G H I J K L O Q R S T U V X Y Z
 */