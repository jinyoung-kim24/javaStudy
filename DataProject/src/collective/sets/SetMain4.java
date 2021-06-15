package collective.sets;

import java.util.HashSet;

public class SetMain4 {

	public static void main(String[] args) {
//		HashSet<> hs = new HashSet<>(c) //error
//		HashSet<Character> hs = new HashSet<Character>();
		// �ڹ� ���׸�, Ÿ�� �Ķ���� ���ѿ����� ���� ����� Ÿ���� 
		// ��ü������ ���۷���Ÿ������ �����ؾ���. �⺻�� �ȵ�.. ����Ŭ���� �������.
		HashSet<Character> hsA = new HashSet<>();
		// �����ڸ����� �� ���׸��̸��� ���� ������ ok
		HashSet<Character> hsB = new HashSet<Character>();
		
		hsA.add('K'); // autoboxing
//		hsA.add(new Character('K'));
		hsA.add('G');
		hsA.add('B');
		
		System.out.println("�������� HS A " + hsA.size());
		for (Character ch : hsA) {
			System.out.printf("%c \n", ch.charValue()); // manualboxing
//			System.out.printf("%c ", ch); // autounboxing
		}
		
		// hsB �� ���տ� ������ �빮�� ���ڰ�ü ��Ҹ� 20�� ���� �Է��� �ֱ�
		final int limit = 20;
		boolean b = false;
		for (int i = 0; i < limit; i++) {
			do {
			char c = (char)((int)(Math.random() * 26) + 'A');
			b = hsB.add(c); // ���տ� ����߰� ������ true
			// �ߺ��Ǿ ����ʰ� ���н� false
			if(b == false)
				System.out.println("�ߺ��߰� ! " + c);
			}while(b == false);
		}
			
		System.out.println("�������� HS B " + hsB.size());
		for (Character ch : hsB) {
			System.out.printf("%c ", ch.charValue());
		}
	}

}
