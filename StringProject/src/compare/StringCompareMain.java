package compare;

public class StringCompareMain {

	public static void main(String[] args) {
		char c = 'A'; // 65
		String s1; // ���� �������� ��� ���ڿ� ��ü�� ǥ��
		// s1�� ��ü�� �ּҸ� ���� �� �ִ� ������ ����.
		s1 = "ABCDE"; // ���ڿ� ��ü s1�� ����(�ּҸ� ����)
//		String s2 = "ABCDE";
		String s2 = new String("ABCDE");
		// �������� ������ ���ڿ� ��ü�� s2�� �� �ּҸ� ����
		
		char[] cArr1 = s1.toCharArray();
		char[] cArr2 = myToCharArray(s2);
		char[] cArr3 = new char[5];
		char[] cArr4 = {'A', 'B', 'C', 'D', 'E'};
		char[] cArr5 = new char[]{'A', 'B', 'C', 'D', 'E'};

		for (int i = 0; i < cArr3.length; i++) {
			cArr3[i] = (char)('A' + i);
		}
		System.out.println(cArr1);
		System.out.println(cArr2);
		System.out.println(cArr3);
		System.out.println(cArr4);
		System.out.println(cArr5);
	}

	private static char[] myToCharArray(String s2) {
		final int len = s2.length();
		char[] arr = new char[len]; // { '/0', '/0', '/0', '/0', '/0'};
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s2.charAt(i);
		}
		return arr;
	}

}
