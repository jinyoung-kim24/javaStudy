package compare;

public class StringCompareMain2 {

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
		
		char temp[] = null;
		System.out.println("�� �迭�� ��������?" + (cArr1 == temp));
		int ret = compareCharArrays(cArr1, temp);
		switch (ret) {
		case COMPARE_NULL_INPUT:
			System.out.println("�� ���� �迭���� NULL ����!");			
			break;
		case COMPARE_DIFF_LENGTH:
			System.out.println("�� ���� �迭���� ���� ���ڼ��� �ٸ� ����");			
			break;
		case COMPARE_MATCH:
			System.out.println("�� ���� �迭���� ���� ������ ������!");			
			break;
		case COMPARE_MISMATCH:
			System.out.println("�� ���� �迭���� ���� ������ �ٸ�");			
			break;
		default:
			break;
		}
	}
	
	// �ΰ��� ���� �迭���� �޾Ƽ� �� ������ �������� ���ϱ�
	public static final int COMPARE_NULL_INPUT = 0;
	public static final int COMPARE_DIFF_LENGTH = 1;
	public static final int COMPARE_MISMATCH = 2;
	public static final int COMPARE_MATCH = 3;
	// �迭�� ��ü�� �׸��� ��ü������ ���Ǵ��� �������(����/�ʿ信 ���� �����ϱ� ����)
	public static int compareCharArrays(char[] cArrA, char[] cArrB) {
		// ��üũ
		if(cArrA == null || cArrB == null)
			return COMPARE_NULL_INPUT;
		// ���̰� �������� ������ ��
		if(cArrA.length != cArrB.length)
			return COMPARE_DIFF_LENGTH;
		// �������� ���ڿ�� ���������� ���� ������ ����
		for (int i = 0; i < cArrB.length; i++) {
			if(cArrA[i] != cArrB[i]) {
				return COMPARE_MISMATCH;
				// FM ���� ��Ұ� ���� �� �ϳ��� �޸��ٸ� ��� ��
			}
		}
		return COMPARE_MATCH; // �ΰ迭�� ��� ���ڿ�Ұ� ������ ���� ��ġ!!
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
