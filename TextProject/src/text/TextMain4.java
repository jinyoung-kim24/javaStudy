package text;

public class TextMain4 {

	public static void main(String[] args) {
		String input = "abcdeXYZJQK012789 -+*/%$@&^�����٫���������";
		final int cntInput = input.length(); // �����ڵ� ���� ����
		System.out.println("cntInput = " + cntInput);
	

		for (int i = 0; i < input.length(); i++) { // 0 ~ 34	
		char c = input.charAt(i);
		if(isKorean(c) == true)
		System.out.println(c + "���ڴ� �ѱ��� �����Դϴ�.");
		else if(isEngUpper(c))
			System.out.println(c + "���ڴ� ���� �빮�� �Դϴ�.");
		else if(isEngLower(c))
			System.out.println(c + "���ڴ� ���� �ҹ��� �Դϴ�.");
		else if(isNumeric(c))
			System.out.println(c + "���ڴ� ���� ���� �Դϴ�.");
		else if(isJapanese(c))
			System.out.println(c + "���ڴ� �Ϻ��� �������� �Դϴ�.");
		else if(isSpaceBar(c))
			System.out.println(c + "���ڴ� ���� ��ȣ �����Դϴ�");
		else 
			System.out.println(c + "���ڴ� ��Ÿ �����Դϴ�");
	}
		
		
	}

	// ���� �Ǻ��ϴ� �Լ���
	// �����̽��� ��������?
	public static boolean isSpaceBar(char c) {
		return c == ' '; // c == 32
	}
	
	// ���� ��������? 
	public static Boolean isNumeric(char c) { 
		return c >= '0' && c <= '9';
	}
	
	// ���� �빮������?
	public static boolean isEngUpper(char c) {
		return c >= 'A' && c <= 'Z';
	}
	// ���� �ҹ�������?
	public static boolean isEngLower(char c) {
		return c >= 'a' && c <= 'z';
	}
	// �ѱ� ��������?
	public static boolean isKorean(char c) { // unicord.org
		return c >= '��' && c <= '�R';
	}		// AC00 ~ D7AF
	// �Ϻ���(�ܱ���) ��������?
	public static boolean isJapanese(char c) {
		return c >= 0x3041 && c <= 0x30FF;
	}
	
}
