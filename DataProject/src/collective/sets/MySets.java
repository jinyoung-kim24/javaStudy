package collective.sets;

import java.util.HashSet;

public class MySets {
	// ���հ� ���ջ����� ���� (�������� ����� setA �ݿ�
	public static void unionSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���");
			return;
		}
		if (setA.isEmpty()) {
			for (Character c : setB) {
				setA.add(c); // ��Һ���
//			setA = setB; 
			}
		} else if (setB.isEmpty()) {
			System.out.println("setA�� ������ ��� �ڱ��ڽ���");
		} else { // �Ѵ� �������� �ƴ�
			for (Character c : setB) {
				setA.add(c); // �ߺ��� �ڵ� ���ŵ�
				// ���� B���� �ְ� ���� A�� ���� ���ڵ鸸 ����A�� �߰���.
			}
		}

	}

	// ������ setA u setB ���� (�������� ����� ���ο� �������� ����)
	public static HashSet<Character> unionSetReturn(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���");
			return null;
		}
		HashSet<Character> union = new HashSet<Character>();
		for (Character c : setA) {
			union.add(c);
		}
		for (Character c : setB) {
			union.add(c);
		}
		// �ߺ��� �ڵ� ���ŵǸ� �ߺ����� �ʴ�
		// B������ ��Ҹ� ���� union�� add��.
		return union;
	}

	// ���� setA u set B ����
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

	// ������ setA - setB = setA - (setA n setB)
	public static HashSet<Character> differenceSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null ������ �� �Ұ���");
			return null;
		}
		if (!setA.isEmpty() || setB.size() > 0) {
			HashSet<Character> minusAB = new HashSet<Character>();
			for (Character c : setA) {
				minusAB.add(c);
			}
//			minusAB = setA; // ���� ������ ����Ŵ ���ÿ� ����.
			HashSet<Character> interAB
				= intersectionSet(setA, setB);
			for (Character c : interAB) {
				minusAB.remove(c);
			}
			return minusAB;
		} else {
			System.out.println("������.....");
			return null;
		}
	}
}
