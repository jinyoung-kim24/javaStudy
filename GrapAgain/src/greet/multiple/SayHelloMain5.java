package greet.multiple;

public class SayHelloMain5 {
	public static void main(String[] args) {		
		// ��� ����
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "���� ��ħ�Դϴ�.";// + myfunc() * 3;
		//SAY_A = "ddd"; // ����� ���Ҵ� �� ����..
		final String SAY_B = PREFIX + "�ȳ��� �ֹ��̾��?";
		final String SAY_C = PREFIX + "���� ���ְ� �弼��.";
		final String SAY_D = PREFIX + "���� �����Դϴ�.";
		//
		final String TITLE = "����";
		// ���� ����
		String queen = "����";
		
		// � �λ縻�� ���տ��� ���� ����
		int selection = 2; //5 //0 //4;//1; // SAY_A
			// ���� ��ȣ 1 ~ 4������ ������ �Է�, SAY_A ~ SAY_D ������Ŵ
		
		// ������ �� ���� �������� �����Ͽ� ���ù�ȣ�� �Է��غ���.
		double ran = Math.random(); // �Ҽ����� ǥ���� �� �ִ� �Ǽ��� double Ÿ��
		// Returns a double value with a positive sign, greaterthan or equal to 0.0 and less than 1.0.
		// 0.0 ~ 0.xxxx ~ 0.99999xxxxx ����
		// 0.0 �̻� �׸��� 1.0 �̸��� ������ ������ �Ǽ�(�Ҽ��� �ִ�)�� �߻���.
		// double ������ ���� �Ǽ��� ������.
		// �ڹ��� random() ���緣���̴�. 
		
		// ���� �Ǽ� �Ҽ������� ������ ��ȯ�ϱ�
		// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random--
		// 4���� ����� ���� ������ �Ǽ��� ������Ű�� 
//		selection = (int)(ran * 4); // 0, 1, 2, 3 => 0 ~ 3
		selection = (int)(ran * 4) + 1; 
			// 0, 1, 2, 3 => 0 ~ 3 + 1 => 0+1 ~ 0+3=4 => 1 ~ 4
			// ������ �������� Ÿ���� �����ϴ� "Ÿ��ĳ���� type casting".
				
		//double ran = 0.334225; // 
		//double PI = 3.141592;
		//int myPi = 3.14; // �Ҽ����� ǥ���Ҵ� ������ Ÿ�� .. ����.
		System.out.println("�Ǽ�(�Ҽ���) = " + ran);
		System.out.println("���õ� ���� selection = " + selection);

		//System.out.println(pickAndReturnMessage(3));
		
		System.out.println(pickAndReturnMessage(selection));
			// ȭ�鿡 ����ϰ� pickAndReturnMessage()�Լ� ���� ����� ����.
		
		String temp = pickAndReturnMessage(selection);
			// pickAndReturnMessage()�Լ� ���� ����� temp ������ �ӽ� �����.
			// �� �� ������ �ʿ信 ���� temp ���� ���� ��� ����.
		System.out.println(temp);
		
		System.out.println(temp+"==========");
		
		System.out.println(pickAndReturnMessageRamdomly());
		System.out.println(pickAndReturnMessageRamdomly());
		System.out.println(pickAndReturnMessageRamdomly());
		
//		pickAndShowMessage(selection);
//		pickAndShowMessageRamdomly();
//		pickAndShowMessageRamdomly();
//		pickAndShowMessageRamdomly();
//		pickAndShowMessageRamdomly();
		
	} // main() ��

	private static String pickAndReturnMessageRamdomly() {
		// ��� ����
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "���� ��ħ�Դϴ�.";// + myfunc() * 3;
		final String SAY_B = PREFIX + "�ȳ��� �ֹ��̾��?";
		final String SAY_C = PREFIX + "���� ���ְ� �弼��.";
		final String SAY_D = PREFIX + "���� �����Դϴ�.";
	
		int selection = (int)(Math.random() * 4) + 1;
		if( selection == 1 ) return SAY_A;
		if( selection == 2 ) return SAY_B;
		if( selection == 3 ) return SAY_C;
		if( selection == 4 ) return SAY_D;	
		return "�޽��� ����";
	}
	
	
	// �Լ� ����(ȣ��) ����� 	�ݵ�� ���ڿ� �����͸� ����(�ǵ�����)��.
	private static String pickAndReturnMessage(int selection) {
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "���� ��ħ�Դϴ�.";// + myfunc() * 3;
		final String SAY_B = PREFIX + "�ȳ��� �ֹ��̾��?";
		final String SAY_C = PREFIX + "���� ���ְ� �弼��.";
		final String SAY_D = PREFIX + "���� �����Դϴ�.";
		
		String retMsg = "";
		if( selection == 1 ) retMsg = SAY_A;
		if( selection == 2 ) retMsg = SAY_B;
		if( selection == 3 ) retMsg = SAY_C;
		if( selection == 4 ) retMsg = SAY_D;
	
		return retMsg; // �Լ��� return�� ������ �ٷ� ����.
		//return "abc";
	} // pickAndReturnMessage() ��
	
	
	private static void pickAndShowMessageRamdomly() {
		// ��� ����
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "���� ��ħ�Դϴ�.";// + myfunc() * 3;
		//SAY_A = "ddd"; // ����� ���Ҵ� �� ����..
		final String SAY_B = PREFIX + "�ȳ��� �ֹ��̾��?";
		final String SAY_C = PREFIX + "���� ���ְ� �弼��.";
		final String SAY_D = PREFIX + "���� �����Դϴ�.";
		//
		final String TITLE = "����";
		// ���� ����
		String queen = "����";
		int selection = (int)(Math.random() * 4) + 1;
		// ���� => �б⹮ (if ���Ǻκб⹮) 
		if( selection == 1 ) 
			sayGreetingMsgToName(SAY_A, queen+TITLE);
		if( selection == 2 ) sayGreetingMsgToName(SAY_B, queen+TITLE);
		if( selection == 3 )
			sayGreetingMsgToName(SAY_C, queen+TITLE);
		if( selection == 4 )
			sayGreetingMsgToName(SAY_D, queen+TITLE);			
	}
	
	
	private static void pickAndShowMessage(int selection) {
		//selection = 4;
		// ��� ����
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "���� ��ħ�Դϴ�.";// + myfunc() * 3;
		//SAY_A = "ddd"; // ����� ���Ҵ� �� ����..
		final String SAY_B = PREFIX + "�ȳ��� �ֹ��̾��?";
		final String SAY_C = PREFIX + "���� ���ְ� �弼��.";
		final String SAY_D = PREFIX + "���� �����Դϴ�.";
		//
		final String TITLE = "����";
		// ���� ����
		String queen = "����";
		
		// ���� => �б⹮ (if ���Ǻκб⹮) 
		if( selection == 1 ) 
			sayGreetingMsgToName(SAY_A, queen+TITLE);
		if( selection == 2 ) sayGreetingMsgToName(SAY_B, queen+TITLE);
		if( selection == 3 )
			sayGreetingMsgToName(SAY_C, queen+TITLE);
		if( selection == 4 )
			sayGreetingMsgToName(SAY_D, queen+TITLE);			
	}

	// Ŭ���� �ȿ����� ��밡���� �Լ��� private
	// �Լ� ���Ǻ�
	private static void sayGreetingMsgToName(
			String msgGreeting, String toName) {
		final String TAB = "\t";// "           ";//"\t";
		final String PUNC = "~~!!";
		final String SEP = "------------------------";
		final String END = "\r\n"; // ����Ű, ���๮��
		
		System.out.println(msgGreeting 
				+ TAB + toName + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
	}
}

/*
�Ǽ�(�Ҽ���) = 0.5863448274589801
���õ� ���� selection = 3
Winter_���� ���ְ� �弼��.	���翩��~~!!
------------------------ 
 */




