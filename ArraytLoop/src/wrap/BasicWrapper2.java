package wrap;

public class BasicWrapper2 {

	public static void main(String[] args) {
		// �⺻���� ����Ŭ���������� ����...
		int num1 = 365 + 1;
		Integer num2 = 365 + 1;
		num2 = num1; // �ڵ��ڽ�
		num1 = num2.intValue() +3; // ���� ��ڽ� 
		num1 = num2 - 5; // �ڵ���ڽ�
		Integer num3 = new Integer(365); // ���� �ڽ�
		// 4����Ʈ ��ġ�����Ͱ� ��üȭ�� ǥ��
		Integer num4 = 365; // new Integer(365);
		// ���������� new Integer(nnn)�� ������ �� ����
		// ����ڽ� (�ڵ����� �ڽ�, ��, ����Ŭ���������� ��´�.)
		// �⺻�� �����͸� �ڵ����� �˾Ƽ� ��ü�� ���������� ��ȯ��.
		// num4.toString()
		int num5 = num3.intValue(); // (����) ��ڽ� manual unboxing
		int num6 = num2; //num3;  // �ڵ���ڽ�(AutoUnboxing)
		
		float f = new Float(3.14f);
		Float f2 = 3.141592F;
		Float f3 = num3.floatValue(); // 365.0f
			// ������ü���� �ǽ������� ���渮�ϵǾ��ٰ� 
			//�ٷ� �ٽ�  �Ǽ� ��ü����ڽ�
		
		char c = 'A';
		Character c2 = 'B';
		Character c3 = new Character('C');
		char c4 = new Character('C');
		char c5 = c3.charValue();
		char c6 = c2.charValue();
		char input = 'A';
		Character objectC = input; //'A';
		// ������ ���ڴ�? ���� ��ҹ��� ������ ���ھ�???
		if(Character.isAlphabetic(c6) == true)
			System.out.println("������ҹ�����");
		else if(Character.isDigit(c6))
			System.out.println("���ڹ�����");
		else if(Character.isWhitespace(c6))
			System.out.println("���鹮�ھƴ�");
	}

}
