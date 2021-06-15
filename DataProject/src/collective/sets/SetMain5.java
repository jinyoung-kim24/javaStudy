package collective.sets;

import java.util.HashSet;

public class SetMain5 {

	public static void main(String[] args) {
		//HashSet<char> hs = new HashSet<char>(); // error
//		HashSet<Character> hs = new HashSet<Character>(); // ok
		// �ڹ� ���׸�, Ÿ�� �Ķ���� ����,������ ���� ����� Ÿ���� 
		// ��ü������ ���۷���Ÿ������ �����ؾ���. �⺻�� �ȵ�.. ����Ŭ���� �������.
		HashSet<Character> hsA = new HashSet<>();			// �����ڸ����� �� ���׸��̸��� ���� ������ ok
		HashSet<Character> hsB = new HashSet<Character>();
		HashSet<Character> hsC;// = null; //new HashSet<>();
		
		hsA.add('K'); hsA.add('G'); hsA.add('B');
	
		printCharSet(hsA, "�������� HS_A");
	
		// hsB �� ���տ� ������ �빮�� ���ڰ�ü ��Ҹ� 20�� ���� �Է��� �ֱ�
		fillRandomCharToSet(hsB, 20);
		
		printCharSet(hsB, "�������� ���� HS_B");
		// limit�� �빮�� ������ �Ѿ�� �ȵ�!! (���ѷ���!)
		hsC = fillRandomCharToSetReturn(10); // 7);//3);
		printCharSet(hsC, "�������� ���� HS_C");
	}

	// �Լ� ���ο��� ������ ���������Ͽ� �� ������ ä���� ������..
	public  static HashSet<Character> 
		fillRandomCharToSetReturn(int inputLimit) {
		 HashSet<Character> hs = new HashSet<Character>();
//		fillRandomCharToSet(hs, inputLimit);
//		
		final int limit = inputLimit > 0 ? inputLimit: 20;
		for (int i = 0; i < limit; i++) {
			boolean b = false;
			do {
				char c = (char)((int)(Math.random()*26)+'A'); // 
				b = hs.add(c);
				if( b == false )   // if( !b )
					System.out.println(">> �ߺ��߰� !" + c);
			} while(b == false);
		}	
		return hs;	
	}

	// limit ������ŭ�� ���� �빮�� ��ҵ��� �Է����տ� ä���ִ� �Լ�
	public static void fillRandomCharToSet(
			HashSet<Character> hs, int inputLimit) {
		if( hs == null ) hs = new HashSet<Character>();// ������
		final int limit = inputLimit > 0 ? inputLimit: 20;
		for (int i = 0; i < limit; i++) {
			boolean b = false;
			do {
				char c = (char)((int)(Math.random()*26)+'A'); // 
				b = hs.add(c);			
			} while(b == false);
		}		
	}

	public static void printCharSet(
			HashSet<Character> hs, String title) {
		System.out.println(title + " : " + hs.size());
		for (Character ch : hs) {
			System.out.printf("%c ", ch); 
		}
		System.out.println("\n-------------------------------");
	}

}

/*
�������� HS_A 3
B G K �������� HS_B 20
A D E F G H I J K L O Q R S T U V X Y Z 
*/