package greet.multiple;

//class A {}
//class B {}

public class SayHelloMain {
	public static void main(String[] args) {
		// �Լ�ȭ �ܰ�
		// 1�ܰ� '�����ϰ�'
		System.out.println("���� ��ħ�Դϴ�." 
				+ "\t" + "����" + "~~!!" ); // �Լ� ȣ��
		System.out.println("------------------------");
		System.out.println("\r\n"); // ASCII, UNICODE
		System.out.println("�ȳ��� �ֹ��̾��?" 
				+ "\t" + "�ȳ�" + "~~!!" ); 
		System.out.println("------------------------");
		System.out.println("\r\n");
		System.out.println("���� ���ְ� �弼��." 
				+ "\t" + "�ö���" + "~~!!" ); 
		System.out.println("------------------------");
		System.out.println("\r\n"); 
		System.out.println("���� �����Դϴ�." 
				+ "\t" + "����" + "~~!!" ); 
		System.out.println("------------------------");
		System.out.println("\r\n"); 
		
		// 2�ܰ� ���ȭ (������� ������ �ʴ� ���� ������)
		final String TAB = "\t";// "           ";//"\t";
		final String PUNC = "~~!!";
		final String SEP = "------------------------";
		final String END = "\r\n"; // ����Ű, ���๮��
		
		System.out.println("���� ��ħ�Դϴ�." 
				+ TAB + "����" + PUNC ); // �Լ� ȣ��
		System.out.println(SEP);
		System.out.println(END); // ASCII, UNICODE
		
		System.out.println("�ȳ��� �ֹ��̾��?" 
				+ TAB + "�ȳ�" + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
		System.out.println("���� ���ְ� �弼��." 
				+ TAB + "�ö���" + PUNC ); 
		System.out.println(SEP);
		System.out.println(END); 
		System.out.println("���� �����Դϴ�." 
				+ TAB + "����" + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
		
		// 3�ܰ� ����ȭ ���� (������� �Ź� ����ø��� �Է����� ������ ���ϴ� ������)
		String msgGreeting; // �λ縻 ����� ����
		String toName; // �λ��� �̸� ����� ����
		
		msgGreeting = "���� ��ħ�Դϴ�.";
		toName = "����";
		System.out.println(msgGreeting 
				+ TAB + toName + PUNC ); // �Լ� ȣ��
		System.out.println(SEP);
		System.out.println(END); // ASCII, UNICODE
		
		msgGreeting = "�ȳ��� �ֹ��̾��?";
		toName = "�ȳ�";
		System.out.println(msgGreeting 
				+ TAB + toName + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
		
		msgGreeting = "���� ���ְ� �弼��.";
		toName = "�ö���";
		System.out.println( msgGreeting
				+ TAB + toName + PUNC ); 
		System.out.println(SEP);
		System.out.println(END); 
		
		msgGreeting = "���� �����Դϴ�.";
		toName = "����";
		System.out.println(msgGreeting 
				+ TAB + toName + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
		
		
		// 4�ܰ� �Լ�ȭ (����κ��� �������� �ϳ��� ���� ������� ��� ����)
		// 			+ ���ǵ� �Լ��� �� �̸����� ���� �ʿ� �ø��� ȣ�� 
		//sayGreetingMsgToName( msgGreeting, toName );
			// �Լ� ȣ�⹮��
		sayGreetingMsgToName("���� ��ħ�Դϴ�.", "����");
		sayGreetingMsgToName("�ȳ��� �ֹ��̾��?", "�ȳ�");
		sayGreetingMsgToName("���� ���ְ� �弼��.", "�ö���");
		sayGreetingMsgToName("���� �����Դϴ�.", "����");
	    private static String pickAndReturnMessage(int select) {
			return null;
		}
	    return "�޽��� ����"; 
	    System.out.println(pickAndReturnMessage());{
		System.out.println(pickAndReturnMessage());
		System.out.println(pickAndReturnMessage());
		System.out.println(pickAndReturnMessage());
		System.out.println(pickAndReturnMessage()); 
	    	
	    }
		// ��� ����
		final String PREFIX = "winter_";
		final String SAY_A = PREFIX + "���� ��ħ�Դϴ�."; //+ myfunc()
		//SAY_A "ddd" // ����� ��Ȱ�� �� ����..
		final String SAY_B = "�ȳ��� �ֹ��̾��?";
		final String SAY_C = "���� ���ְ� �弼��.";
		final String SAY_D = "���� �����Դϴ�.";
		
		final String TITLE = "����";
				// ���� ����
		String queen = "����";
		
		pickAndShowMessage(selection);
		
		
		// � �λ縻�� ���տ��� ���� ����
		int selection =2; // SAY_A
		// ���� ��ȣ 1 ~ 4������ ������ �Է�, SAY_A ~SAY_D ������Ŵ
		
		// ������ �� ���� ������ �����Ͽ� ���ù�ȣ�� �Է��غ��� 
		double ran = Math.random(); // �Ҽ����� ǥ���� �� �ִ� �Ǽ��� double Ÿ�� 
		double PI = 3.142592; 
		// 0.0 ~ 0.xxxx ~ 0.99999xxxxx ����
		// 0.0 �̻� �׸��� 1.0 �̸��� ������ ������ �Ǽ�(�Ҽ���  �ִ�)�� �߻���
		// double ������ ���� �Ǽ��� ������ .
		// �ڹ���  random() ���緥���̴�.
		// ���� �Ǽ� �Ҽ������� ������ ��ȯ�ϱ�
		// 4���� ����� ���� ������ �Ǽ��� ������Ű��
		selection = (int)(ran * 4); // 0.1.2.3 => 0~3  
		selection = (int)(ran * 4); 
		// 0.1.2.3 => 0~3 + 1 => 
	     // ������ �������� Ÿ���� �����ϴ� "Ÿ��ĳ���� Eype casting".
		//System.out.println(pickAndReturnMessageremdonly(selection));
		System.out.println(pickAndReturnMessageremdonly(selection));
		
		
		String temp = 
		// duble ran = 0.334225;
		int myPI = 3.14; // �Ҽ����� ǥ���ϴ� ������ Ÿ�� ����
		System.out.println("�Ǽ�(�Ҽ���) = " + ran);
		System.out.println("���õ� ���� selection = " + selection);
		// ���� => �б�� (if ���Ǻκб��)
		if(selection ==1 )
		sayGreetingMsgToName(SAY_A, queen+TITLE);
		if(selection ==2 )
		sayGreetingMsgToName(SAY_B, queen+TITLE);
		if(selection ==3 )
		sayGreetingMsgToName(SAY_C, queen+TITLE);
		if(selection ==4 )
		sayGreetingMsgToName(SAY_D, queen+TITLE);
		// ȭ�鿡 ����ϰ� pickAndReturnMessage () �Լ� ���� ����� temp ������ �ӽ� ����� 
		// ���� ������ �ʿ信 ���� temp ���� ���� ��� ����.
		String retMsg = "";
		
		private static String pickAndReturnMessageremdonly(selection);{	
		final String PREFIX = :winter_";
		final String SAY_A = PREFIX + "���� ��ħ�Դϴ�."; //+ myfunc()
		//SAY_A "ddd" // ����� ��Ȱ�� �� ����..
		final String SAY_B = "�ȳ��� �ֹ��̾��?";
		final String SAY_C = "���� ���ְ� �弼��.";
		final String SAY_D = "���� �����Դϴ�.";
		
		final String TITLE = "����"
		// ���� ����
		String queen = "����";
			
		if(selection ==1 ) retMsg = SAY_A;
			sayGreetingMsgToName(SAY_A, queen+TITLE);
		if(selection ==2 ) retMsg = SAY_B;
			sayGreetingMsgToName(SAY_B, queen+TITLE);
		if(selection ==3 ) retMsg = SAY_C;
			sayGreetingMsgToName(SAY_C, queen+TITLE);
		if(selection ==4 ) retMsg = SAY_D;							
			sayGreetingMsgToName(SAY_D, queen+TITLE);
		return retMsg; //�Լ��� return�� ������ �ٷ� ����,
		}		
		
		
	}

	// Ŭ���� �ȿ����� ��밡���� �Լ��� private
	// �Լ� ���Ǻ�
	// �Լ� ����(ȣ��) ����� �ݵ�� ���ڿ� �����͸� ����(�ǵ�����)��.
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
		return "abc";
		// pickAndReturnMessage
		
		
		
	}
}
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
	





