package string;

public class StrMain2 {

	public static void main(String[] args) {
		// Empty String Empty char Array
		String word1 = ""; // �����Ĺ������� ��ü�� ����
		// ���ڿ�; ���ͷ� (���� - ���ڰ����� 0�� ���ڿ� ��ü)
		String word2 = new String(""); // Ŭ���� ��ü ����
		int wlen = word1.length(); // �Լ�ȣ��; ���� ����, ���� 0
		int wlen2 = word2.length(); // 0

		char[] cArr1 = {}; // ���ڹ迭; ���ͷ�{} ���� - ���ڿ�Ұ����� 0���� �迭
		char[] cArr2 = new char[0]; // ��Ұ��� 0�� ������ ���� ����
		int clen = cArr1.length; // ������� ��ұ��ڼ� ����, ���� 0
		int clen2 = cArr2.length; // ��Ұ��� 0
		
		// ���ڿ��� ���ڹ迭�� ��ȯ??
		String word3 = "April";
		final int wlen3 = word3.length(); // 5��
		char[] cArr3 = {'\0', '\0', '\0', '\0', '\0'}; // ��������
		char[] cArr4 = new char[5]; 
		// 5�� �޸� ������ ���� char�� ��ұ⺻�� '\0'�� �ڵ����� ��� ä��
//		char[] cArr4b = new char[wlen3]; 
		// �� ������ ����Ǵ� �� ����(runtime �ǽð�)�� �����Ǵ� wlen3��
		// �������� ũ�Ⱑ �����Ǵ� �迭�� ����.
		char[] cArr4c = new char[word3.length()];
		char[] cArrran = new char[(int)(Math.random() * 10)];
		// 0 ~ 9 ����� ���� �ٸ� ũ���� �迭�� �����ϰ� �������
		
		
		// �������� ���������� ���ڿ� ��� ���� �ϳ��ϳ��� 
		// ���������� �ϳ��� �迭 ������ ����
		for (int i = 0; i < cArr4c.length; i++) {
			cArr4c[i] = word3.charAt(i);
		}
		// "April" -------> { 'A', 'p', 'r', 'i', 'l'};
		
		// �迭 ���
		printCharArray(cArr4c);
//		for (int i = 0; i < cArr4c.length; i++) {
//			System.out.println(i + "��° ��� ���� -> " + cArr4c[i]);
//		}
		char[] copyArr = word3.toCharArray(); // �ڵ�����
		// "April" -------> { 'A', 'p', 'r', 'i', 'l'};
		printCharArray(copyArr);
		
	}

	private static void printCharArray(char[] cArr4c) {
		for (int i = 0; i < cArr4c.length; i++) {
			System.out.println(i + "��° ��� ���� -> " + cArr4c[i]);
		}
		
	}
}
