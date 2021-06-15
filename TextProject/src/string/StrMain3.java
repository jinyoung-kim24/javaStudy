package string;

public class StrMain3 {

	public static void main(String[] args) {
				
		// ���ڿ��� ���ڹ迭�� ��ȯ??
		String word3 = "August"; // "April";
		final int wlen3 = word3.length(); // 5
		char[] cArr4c = new char[word3.length()];
		
		// �������� 1 - ���������� ���ڿ� ��� ���� �ϳ��ϳ��� 
		// ���������� �ϳ��� �迭 ������ ����
		for (int i = 0; i < cArr4c.length; i++) {
			cArr4c[i] = word3.charAt(i);
		}
		printCharArray(cArr4c);
		
		// �������� 2 - �Լ�ȭ
		char[] manualCopyArr = toMyCharArray( word3 );
		printCharArray(manualCopyArr);
		
		// �ڵ����� 
		char[] copyArr = word3.toCharArray(); 
			// "April"  ----> { 'A', 'p', 'r', 'i', 'l' }
		printCharArray(copyArr);
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
/*
0��° ��� ���� -> A
1��° ��� ���� -> p
2��° ��� ���� -> r
3��° ��� ���� -> i
4��° ��� ���� -> l 
 */









