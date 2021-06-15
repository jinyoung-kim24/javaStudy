package text.korean;

import text.UnicodeMain;
/*
 * ����â �ܼ� ����
 *  
 *   cd, dir, cd .., type, cls, java �ܼ� ��� ����

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain > hangul.txt

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain > �ѱ��ڵ�.txt

 */
public class HangulMain {

	public static void main(String[] args) {
		final char hSTART = '��'; // ���ڻ��
		final char hEND = '�R'; // 0xD7A3
		char hangul = hSTART;// '��'; // 0xAC00 == ?
		
		// �ѱ� ���� �Ѱ���
		//final int TOTAL_HANGULS = 0xD7A3 - 0xAC00 + 1; 
		final int TOTAL_HANGULS = '�R' - '��' + 1; // 11172��
		// '��' => 1��° ����, '�R' => 11172��° ����
		
		boolean flag = true;
		int order = 0; // ī���ͺ��� �ʱ�ȭ (������ �����ϸ鼭 ��ȭ�Ǵ� ����)
		while(flag == true) { // �ݺ����� ���� ����
			//order = order + 1;
			order++; // ���� ��ȭ..
			System.out.printf("order %d: ", order );
//			System.out.printf(" => %c (%d, 0x%X) \n",
//						hangul, (int)hangul, (int)hangul);
			UnicodeMain.printCharWithCode(hangul);
			// public���� �Ǿ��ִ� �ٸ� Ŭ������ �Լ��� ���� �ҷ��� ����� ������.
			
			// ���� ���� ���� 
			if( order == TOTAL_HANGULS ) flag = false;
			hangul = (char) (hangul + 1);
//			if( hangul == hEND ) flag = false; // '�R'??? ��������!!
		} // �ݺ����� ���� ��
		System.out.println("�����ڵ� �ѱ� ��� loop ����!!!");
	}

}
