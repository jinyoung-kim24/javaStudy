package calculator;

public class CalcMain {
	// Ŭ���� ���� ��� ����
	public static final char OP_ADD = '+'; // 43
	public static final char OP_SUBTRACT = '-';
	public static final char OP_MULTIPLY = '*';
	public static final char OP_DIVIDE = '/';
	public static final char OP_REM = '%';
	public static final char OP_NONE = ' '; // 32 space
	// �ŵ�����.... �����... 
	public static void main(String[] args) {
		// �غ�: ����, �ʱ�ȭ
		int val1 = 0, val2 = 0; // �� operand
		char op = OP_NONE;   //'\0'; // ������ operator +-*/%
		double result = 0.0;
		
		//�Էº�
		val1 = 200; op = OP_REM; val2 = 0;
		
		// ��� �����
		if(op == OP_ADD)result = val1 + val2;
		else if(op == OP_SUBTRACT)result = val1 - val2;
		else if(op == OP_MULTIPLY)result = val1 * val2;
		else if(op == OP_DIVIDE) {
			if(val2 != 0)
			result = val1 / val2;
			else
				System.out.println("error");
		}
		else if(op == OP_REM) {
			if(val2 != 0)
			result = val1 % val2;
			else 
				System.out.println("error");
		}
		else{
			System.out.println("���� ���� ����: ");
			System.out.println(op + "�����ڴ� ���� �������� ���߽��ϴ�.");
		}
		
		// ��º�
		System.out.println("============================");
		System.out.println("\t���� ver 1.0");
		System.out.printf("����: %d %c %d = %.2f \n",val1, op , val2 , result);
		
	}

}
