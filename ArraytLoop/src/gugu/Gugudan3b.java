package gugu;

public class Gugudan3b {

	public static final String EMTPY = "";
	public static void main(String[] args) {
		// �迭�� �����Ͽ� ������ �������� �ٷ� ������� �ʰ�, 
		// ���� �ٸ������� ����ϱ� ���� ������.
		//  length => 8��, ������ȣ 0 ~ 7
		// 0��°�� 2������, ... 7��° �迭��Ұ��� 9������..
		String[] guguArr = {
			EMTPY, EMTPY, EMTPY, EMTPY, 
			EMTPY, EMTPY, EMTPY, EMTPY
			//"", "", "", ""  	
			//null, null, null, null, null, null,null, null   	
		}; // �迭 ��Ұ��� EMPTY ���� �� �ϳ��� ������ ����� ������ ����.
		// �迭 ������ ������ �ִ� ���������� ������״ٰ�...
		// ���� �ʿ信 ���ؼ� �ش� �迭�� ���������� �����Ͽ� ����ؾ���. 
		
		// ������ 2 ~ 9 ��
		final int DAN_LIMIT = 9;//19; //9; // �ε�, �Ϻ�?
		final int J_LIMIT = 10;//20; //10;
		for (int dan = 2; dan <= DAN_LIMIT; dan++) { // 8������
			guguArr[dan-2] += "** " + dan + "�� **\n";
			for (int j = 1; j < J_LIMIT; j++) { //9������
				guguArr[dan-2] += (dan + " x " + j 
						+ " = " + (dan*j) + "\n" );
			}
			guguArr[dan-2] += "-------------------";
		}
		// ���� for�� �Ϸ� �� ������ ������ ���ڿ����� guguArr�迭�� ��� �����.
		
		System.out.println(guguArr[3-2]); // 3��
		System.out.println(guguArr[5-2]); // 5��
		System.out.println(guguArr[9-2]); // 9��
		
		
	}

}

