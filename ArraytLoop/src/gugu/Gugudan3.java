package gugu;

public class Gugudan3 {
	public static final String EMPTY = "";
	public static void main(String[] args) {
		
		// �迭�� �����Ͽ� ������ �������� �ٷ� ������� �ʰ�,
		// ���� �ٸ������� ����ϱ� ���� ������.
		// length => 8��, ���� ��ȣ 0 ~ 7
		// 0������ 2������ ,.... 7��° �迭��� ���� 9�� ����..
		String[] guguArr = {
				EMPTY, EMPTY, EMPTY, EMPTY, 
				EMPTY, EMPTY,  EMPTY, EMPTY
		}; // �迭 ��Ұ��� EMPTY ���� �� �ϳ��� ������ ����� ������ ����.
		// �迭 ������ ������ �ִ� ���������� ������״ٰ�
		// ���� �ʿ信 ���ؼ� �ش� �迭�� ���������� �����Ͽ� ����ؾ���.
		
		//������ 2 ~ 9�� 
		final int DAN_LIMIT = 9;
		final int J_LIMIT = 10;
		for (int dan = 2; dan <= DAN_LIMIT; dan++) { // 8���� ����
			String danStr = "";
			danStr += "** " + dan + "��\n";
			for (int j = 1; j < J_LIMIT; j++) { // 9���� ����
				danStr += (dan + " x " + j + " = " + (dan*j) + "\n");
				//System.out.printf(" %d x %d = %d \n", dan,j, dan*j); 72�� ����
			}
			danStr += "-----------------------------------";
			//System.out.println("----------------------");
			//System.out.println(danStr);
			guguArr[dan-2] = danStr;
			//System.out.println(guguArr[dan-2]);
	}
		// ���� for�� �Ϸ��� ������ ������ ���ڿ����� guguArr�迭�� ��� �����
		
		System.out.println(guguArr[3-2]); // 3��
		System.out.println(guguArr[5-2]); // 5��
		System.out.println(guguArr[9-2]); // 9��
}
}