package string;

public class StrMain4 {

	public static void main(String[] args) {
				
		// ���ڿ��� ���ڹ迭�� ��ȯ??
		String word3 = "August"; // "April";
		final int wlen3 = word3.length(); // 5
		char[] cArr4c = new char[word3.length()];
		
		// ���� ����Ŭ�������� �迭
		char[] abc = { 'a', 'b', 'c' };
		Character[] coArr = { 'a', 'b', 'c' }; // ����ڽ�
				// new Character()�� �ڵ� ���μ� �����..
		Character[] coArr2 = { 
				new Character('a'), 
				new Character('b'), 
				new Character('c')
		};
		
		String word4 = "Princess Elsa"; // 13��
		//Character[] coArr3 = new Character[3];
		Character[] coArr3 = new Character[word4.length()];
		for (int i = 0; i < coArr3.length; i++) {
			coArr3[i] = word4.charAt(i); // 0 ~ 12 ����ڽ�
//			coArr3[i] = new Character(
//					word4.charAt(i)); // 0 ~ 12 �����ڽ�
		}
		
//		printCharArray(coArr3); // ����? char[] != Character[]
		// classic for�� (c��� ��Ÿ��) 
		for (int i = 0; i < coArr3.length; i++) {
			Character c = coArr3[i];
			char cc = c.charValue(); // ���� ��ڽ�
			System.out.println(cc);
//			System.out.println(c);
//			System.out.println(coArr3[i]);
		}
		System.out.println("------------");
		// ���� for��; (java��� ��Ÿ��, ��ü������ ��Ÿ��); 
		// fast enumeration
		// for( ����Ÿ�Կ�Һ��� : �ݺ�������Ž���ҹ��� ) {}
		// �ݺ�������Ž���ҹ��� => �迭, ����, ����Ʈ, �ؽø�... 
		for( Character c : coArr3 ) {
			System.out.println(c);
		}
		char[] winter = word4.toCharArray();
		
		for( Character c : winter ) {
			System.out.println(c);
			//System.out.println(c.charValue());
		}
		for( char c : winter ) {
			System.out.println(c);
		}
		
//		// �������� 1 - ���������� ���ڿ� ��� ���� �ϳ��ϳ��� 
//		// ���������� �ϳ��� �迭 ������ ����
//		for (int i = 0; i < cArr4c.length; i++) {
//			cArr4c[i] = word3.charAt(i);
//		}
//		printCharArray(cArr4c);
//		
//		// �������� 2 - �Լ�ȭ
//		char[] manualCopyArr = toMyCharArray( word3 );
//		printCharArray(manualCopyArr);
//		
//		// �ڵ����� 
//		char[] copyArr = word3.toCharArray(); 
//			// "April"  ----> { 'A', 'p', 'r', 'i', 'l' }
//		printCharArray(copyArr);
	}
	
	private static char[] toMyCharArray2(String word) {
		if( word != null && word.length() > 0 ) { // ��üũ�ֿ켱
		//if( word.length() > 0 && word != null ) { // ����ȵ�!!
				char[] cArr = new char[word.length()];			
				for (int i = 0; i < cArr.length; i++) {
					cArr[i] = word.charAt(i);
				}
				return cArr;
		} else {
			System.out.println("word �Է��� ���̰� 0�̰ų� �Է��� null.");
			return null;
		}
	}
	

	private static char[] toMyCharArray(String word) {
		if( word != null ) { // ��üũ�� �켱!! ���̾ƴ� ���� ��� ����
			if( word.length() > 0 ) { // ���ڰ� ���ڿ��� 1���̻� �ִ���?
				char[] cArr = new char[word.length()];			
				for (int i = 0; i < cArr.length; i++) {
					cArr[i] = word.charAt(i);
				}
				return cArr;
			} else {
				System.out.println("word �Է��� ���̰� 0�̳׿�.");
				return new char[0];
			}
		} else {
			System.out.println("���ڿ��� ��ü�� �Է��� ����. ��!!");
			return null;
		}
	}

	private static void printCharArray(char[] cArr4c) {
		for (int i = 0; i < cArr4c.length; i++) {
			System.out.println(i+"��° ��� ���� -> " + cArr4c[i]);
		}		
	}

}