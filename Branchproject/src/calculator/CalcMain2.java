package calculator;

public class CalcMain2 {
	// Ŭ���� ���� ��� ����
	public static final char OP_ADD = '+'; // 43
	public static final char OP_SUBTRACT = '-';
	public static final char OP_MULTIPLY = '*';
	public static final char OP_DIVIDE = '/';
	public static final char OP_REM = '%';
	public static final char OP_NONE = ' '; // space 32
	// �ŵ�����... �����... 
	
	public static void main(String[] args) {
		//CalcMain c;
		// �غ��: ����, �ʱ�ȭ...
		int val1 = 0, val2 = 0; // �� operand
		char op = OP_NONE;// = '\0'; // ������ operator +-*/%
		double result = 0.0;
		
		// �Էº�
		//val1 = 100; op = OP_ADD; val2 = 49;
		//val1 = 100; op = OP_DIVIDE; val2 = 49;
		//val1 = 100; op = OP_REM; val2 = 49;
		val1 = 200; op = OP_DIVIDE; val2 = 0; //7;
				// java.lang.ArithmeticException: / by zero ���ܿ���..
		
		// ��� �����
		switch(op) {
			case OP_ADD: result = val1 + val2; break;
			case OP_SUBTRACT: result = val1 - val2; break;
			case OP_MULTIPLY: result = val1 * val2; break;
			case OP_DIVIDE:
				if( val2 != 0 )
					result = (double)val1 / val2;
				else 
					System.out.println("[error] Divide by Zero!");
				break;
			case OP_REM:
				if( val2 != 0 )
					result = (double)val1 % val2;
				else
					System.out.println("[error] Rem by Zero!");
				break;
			default:
				System.out.println("���� ���� ����: ");
				System.out.println( op + " �����ڴ� ���� �������� ���߽��ϴ�.");
		
				//break;
		}
//		if( op == OP_ADD ) result = val1 + val2;
//		else if( op == OP_SUBTRACT ) result = val1 - val2;
//		else if( op == OP_MULTIPLY ) result = val1 * val2;
//		else if( op == OP_DIVIDE ) {
//			if( val2 != 0 )
//				result = val1 / val2;
//			else 
//				System.out.println("[error] Divide by Zero!");
//		}
//		else if( op == OP_REM ) {
//			if( val2 != 0 )
//				result = val1 % val2;
//			else
//				System.out.println("[error] Rem by Zero!");
//		}
//		else {
//			System.out.println("���� ���� ����: ");
//			System.out.println( op + " �����ڴ� ���� �������� ���߽��ϴ�.");
//		}		
		
		// ��º�
		System.out.println("==============================");
		System.out.println("\t���� ver 1.0");
		System.out.printf(" ����: %d %c %d = %.2f \n",
						val1, op, val2, result);
						//val1, '+', val2, result);
		System.out.println("==============================");
	}

}
