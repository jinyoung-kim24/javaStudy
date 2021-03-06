package calculator;

import java.util.Scanner;

public class CalcMain9 {
	// 클래스 공통 상수 정의
	public static final char OP_ADD = '+'; // 43
	public static final char OP_SUBTRACT = '-';
	public static final char OP_MULTIPLY = '*';
	public static final char OP_DIVIDE = '/';
	public static final char OP_REM = '%';
	public static final char OP_NONE = ' '; // space 32
	// 거듭제곱... 백분율... 
	
	public static void main(String[] args) {
		// 준비부: 선언, 초기화...
		int val1 = 0, val2 = 0; // 값 operand
		char op = OP_NONE;// = '\0'; // 연산자 operator +-*/%
		double result = 0.0;
		
		final String MENU_MSG = "연산자 기호 선택: \n"
				+ "\t 1. 덧셈, 2. 뺄셈, "
				+ "3. 곱셈, 4. 나눗셈, 5. 나머지 : ";
		
		// 입력부
		//op = userInputToOperator(MENU_MSG);	// 동일	
		//op = userInputToOperator(MENU_MSG, false);  // 동일
		op = userInputToOperator(MENU_MSG, true); // 검출
		val1 = userInput(">> 첫번째 정수를 입력: ");
		val2 = userInput(">> 두번째 정수를 입력: ");
		
		// 계산 실행부
		result = calculate(val1, op, val2);		
		
		// 출력부
		printResult(val1, op, val2, result);
	}
	
	// function overloding
	private static char userInputToOperator(
			String msg, boolean checked) {
		//if( checked == true ) {
		if( checked ) { // 오류검출 옵션 켜다
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
						System.out.println("잘못된 연산자 번호메뉴 선택!!!!");
//						flag = true;
				} // switch
			//	if( op != OP_NONE ) flag = false;
					// 연산자 결정났으니 반복flag 내리기..
			} // while
			return op;
		} else { // 오류검출 옵션 끄다 (original)
			char op = OP_NONE;
			int inputOp = userInput(msg);
			switch( inputOp ) {
				case 1: op = OP_ADD; break;
				case 2: op = OP_SUBTRACT; break;
				case 3: op = OP_MULTIPLY; break;
				case 4: op = OP_DIVIDE; break;
				case 5: op = OP_REM; break;
				default:
					System.out.println("잘못된 연산자 번호메뉴 선택!!!!");
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
				System.out.println("잘못된 연산자 번호메뉴 선택!!!!");
		}
		return op;
	}

	// 안내문자열을 입력받아서 출력하고 내부에 스캐너로 사용자의 정수입력을 받아 리턴하는 함수
	private static int userInput(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		return input;
	}

	private static void printResult(int val1, char op, int val2, double result) {
		System.out.println("==============================");
		System.out.println("\t계산기 ver 1.0");
		System.out.printf(" 계산식: %d %c %d = %.2f \n",
						val1, op, val2, result);
						//val1, '+', val2, result);
		System.out.println("==============================");
	}

	// 정수값 2개, 연산기호문자 1개를 입력 받아서, 사칙연산을 각각 실행 후
	// double형 결과값을 리턴하는 함수
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
				System.out.println("연산 수행 오류: ");
				System.out.println( op + " 연산자는 아직 구현되지 못했습니다.");
				//break;
		}
		
		return result;
	}

}


/*
연산자 기호 선택: 
	 1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지 : 8
잘못된 연산자 번호메뉴 선택!!!!
연산자 기호 선택: 
	 1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지 : 10
잘못된 연산자 번호메뉴 선택!!!!
연산자 기호 선택: 
	 1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지 : 0
잘못된 연산자 번호메뉴 선택!!!!
연산자 기호 선택: 
	 1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지 : -5
잘못된 연산자 번호메뉴 선택!!!!
연산자 기호 선택: 
	 1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지 : 4
>> 첫번째 정수를 입력: 1000
>> 두번째 정수를 입력: 3
==============================
	계산기 ver 1.0
 계산식: 1000 / 3 = 333.33 
==============================
*/
