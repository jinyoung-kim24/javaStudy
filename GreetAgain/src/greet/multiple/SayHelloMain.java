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
	}
}






