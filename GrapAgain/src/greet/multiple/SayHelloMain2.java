package greet.multiple;

public class SayHelloMain2 {
	public static void main(String[] args) {		
		// 4�ܰ� �Լ�ȭ (����κ��� �������� �ϳ��� ���� ������� ��� ����)
		// 			+ ���ǵ� �Լ��� �� �̸����� ���� �ʿ� �ø��� ȣ�� 
		//sayGreetingMsgToName( msgGreeting, toName );
			// �Լ� ȣ�⹮��
//		sayGreetingMsgToName("���� ��ħ�Դϴ�.", "����");
//		sayGreetingMsgToName("�ȳ��� �ֹ��̾��?", "�ȳ�");
//		sayGreetingMsgToName("���� ���ְ� �弼��.", "�ö���");
//		sayGreetingMsgToName("���� �����Դϴ�.", "����");
		
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
		
		// ���� => �б⹮ (if ���Ǻκб⹮) 
		if( selection == 1 ) 
			sayGreetingMsgToName(SAY_A, queen+TITLE);
		if( selection == 2 ) sayGreetingMsgToName(SAY_B, queen+TITLE);
		if( selection == 3 )
			sayGreetingMsgToName(SAY_C, queen+TITLE);
		if( selection == 4 )
			sayGreetingMsgToName(SAY_D, queen+TITLE);
		
		
	} // main() ��

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






