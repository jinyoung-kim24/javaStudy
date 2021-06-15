package calculator;

import java.util.Scanner;

public class CalcMain9 {
	// Ŭ���� ���� ��� ����
	public static final char OP_ADD = '+'; // 43
	public static final char OP_SUBTRACT = '-';
	public static final char OP_MULTIPLY = '*';
	public static final char OP_DIVIDE = '/';
	public static final char OP_REM = '%';
	public static final char OP_NONE = ' '; // space 32
	// �ŵ�����... �����... 
	
	public static void main(String[] args) {
		// �غ��: ����, �ʱ�ȭ...
		int val1 = 0, val2 = 0; // �� operand
		char op = OP_NONE;// = '\0'; // ������ operator +-*/%
		double result = 0.0;
		
		final String MENU_MSG = "������ ��ȣ ����: \n"
				+ "\t 1. ����, 2. ����, "
				+ "3. ����, 4. ������, 5. ������ : ";
		
		// �Էº�
		//op = userInputToOperator(MENU_MSG);	// ����	
		//op = userInputToOperator(MENU_MSG, false);  // ����
		op = userInputToOperator(MENU_MSG, true); // ����
		val1 = userInput(">> ù��° ������ �Է�: ");
		val2 = userInput(">> �ι�° ������ �Է�: ");
		
		// ��� �����
		result = calculate(val1, op, val2);		
		
		// ��º�
		printResult(val1, op, val2, result);
	}
	
	// function overloding
	private static char userInputToOperator(
			String msg, boolean checked) {
		//if( checked == true ) {
		if( checked ) { // �������� �ɼ� �Ѵ�
			char op = OP_NONE;
			//boolean flag = true;
			//while() { // == true) {
			while(op == OP_NONE) {
				int inputOp = userInput(msg);
				switch( inputOp ) {
					case 1: op = OP_ADD; break;
					case 2: op = OP_SUBTRACT; break;
					case 3: op = OP_MULTIPLY; break;
					case 4: op = OP_DIVIDE; break;
					case 5: op = OP_REM;  break;
					default:
						System.out.println("�߸��� ������ ��ȣ�޴� ����!!!!");
//						flag = true;
				} // switch
			//	if( op != OP_NONE ) flag = false;
					// ������ ���������� �ݺ�flag ������..
			} // while
			return op;
		} else { // �������� �ɼ� ���� (original)
			char op = OP_NONE;
			int inputOp = userInput(msg);
			switch( inputOp ) {
				case 1: op = OP_ADD; break;
				case 2: op = OP_SUBTRACT; break;
				case 3: op = OP_MULTIPLY; break;
				case 4: op = OP_DIVIDE; break;
				case 5: op = OP_REM; break;
				default:
					System.out.println("�߸��� ������ ��ȣ�޴� ����!!!!");
			}
			return op;
		}		
	}

	private static char userInputToOperator(String msg) {
		char op = OP_NONE;
		int inputOp = userInput(msg);
		switch( inputOp ) {
			case 1: op = OP_ADD; break;
			case 2: op = OP_SUBTRACT; break;
			case 3: op = OP_MULTIPLY; break;
			case 4: op = OP_DIVIDE; break;
			case 5: op = OP_REM; break;
			default:
				System.out.println("�߸��� ������ ��ȣ�޴� ����!!!!");
		}
		return op;
	}

	// �ȳ����ڿ��� �Է¹޾Ƽ� ����ϰ� ���ο� ��ĳ�ʷ� ������� �����Է��� �޾� �����ϴ� �Լ�
	private static int userInput(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		return input;
	}

	private static void printResult(int val1, char op, int val2, double result) {
		System.out.println("==============================");
		System.out.println("\t���� ver 1.0");
		System.out.printf(" ����: %d %c %d = %.2f \n",
						val1, op, val2, result);
						//val1, '+', val2, result);
		System.out.println("==============================");
	}

	// ������ 2��, �����ȣ���� 1���� �Է� �޾Ƽ�, ��Ģ������ ���� ���� ��
	// double�� ������� �����ϴ� �Լ�
	private static double calculate(
			int val1, char op, int val2) {
		double result = 0.0;
		
		switch(op) {
			case OP_ADD: result = val1 + val2; break;
			case OP_SUBTRACT: result = val1 - val2; break;
			case OP_MULTIPLY: result = val1 * val2; break;
			case OP_DIVIDE:
				if( val2 != 0 ) result = (double)val1 / val2;
				else System.out.println("[error] Divide by Zero!");
				break;
			case OP_REM:
				if( val2 != 0 ) result = (double)val1 % val2;
				else System.out.println("[error] Rem by Zero!");
				break;
			default:
				System.out.println("���� ���� ����: ");
				System.out.println( op + " �����ڴ� ���� �������� ���߽��ϴ�.");
				//break;
		}
		
		return result;
	}

}


/*
������ ��ȣ ����: 
	 1. ����, 2. ����, 3. ����, 4. ������, 5. ������ : 8
�߸��� ������ ��ȣ�޴� ����!!!!
������ ��ȣ ����: 
	 1. ����, 2. ����, 3. ����, 4. ������, 5. ������ : 10
�߸��� ������ ��ȣ�޴� ����!!!!
������ ��ȣ ����: 
	 1. ����, 2. ����, 3. ����, 4. ������, 5. ������ : 0
�߸��� ������ ��ȣ�޴� ����!!!!
������ ��ȣ ����: 
	 1. ����, 2. ����, 3. ����, 4. ������, 5. ������ : -5
�߸��� ������ ��ȣ�޴� ����!!!!
������ ��ȣ ����: 
	 1. ����, 2. ����, 3. ����, 4. ������, 5. ������ : 4
>> ù��° ������ �Է�: 1000
>> �ι�° ������ �Է�: 3
==============================
	���� ver 1.0
 ����: 1000 / 3 = 333.33 
==============================
*/
