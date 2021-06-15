package calculator;
import java.util.Scanner;
public class CalcMain5 {
	// 클래스 공통 상수 정의
	public static final char OP_ADD = '+'; // 43
	public static final char OP_SUBTRACT = '-';
	public static final char OP_MULTIPLY = '*';
	public static final char OP_DIVIDE = '/';
	public static final char OP_REM = '%';
	public static final char OP_NONE = ' '; // space 32
	// 거듭제곱... 백분율... 
	
	public static void main(String[] args) {
		//CalcMain c;
		// 준비부: 선언, 초기화...
		int val1 = 0, val2 = 0; // 값 operand
		char op = OP_NONE;// = '\0'; // 연산자 operator +-*/%
		double result = 0.0;
		
		
//		// 입력부
//		Scanner sc = new Scanner(System.in); // 키보드 입력 버퍼를 소스로 삼음.
//		System.out.println("연산자 기호 선택:");
//		System.out.println("\t 1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지:");
//		//op = sc.nextInt(); // + - * / %
//		int inputOp = sc.nextInt(); // 1 2 3 4 5
		int inputOp = userInput("연산자 기호 선택:\n"+ "\t 1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지:");
		
		switch(inputOp) {
			case 1: op = OP_ADD; break;
			case 2: op = OP_SUBTRACT; break;
			case 3: op = OP_MULTIPLY; break;
			case 4: op = OP_DIVIDE; break;
			case 5: op = OP_REM; break;
			default:
				System.out.println("잘못된 연산자 번호메뉴 선택!!!");
		}
//		System.out.print(">> 첫번째 정수를 입력: ");
//		val1 = sc.nextInt();
		val1 = userInput(">> 첫번째 정수를 입력: ");
//		System.out.print(">> 두번째 정수를 입력: ");
		val2 = userInput(">> 두번째 정수를 입력: ");
//		val2 = sc.nextInt();
		
		//op = OP_ADD; //고정된 +로 테스트
		
		
		// 더미 data dummy
		//val1 = 100; op = OP_ADD; val2 = 49;
		//val1 = 100; op = OP_DIVIDE; val2 = 49;
		//val1 = 100; op = OP_REM; val2 = 49;
		//val1 = 200; op = OP_DIVIDE; val2 = 0; //7;
				// java.lang.ArithmeticException: / by zero 예외에러..
		
		// 계산 실행부
		result = calculate(val1, op, val2);
//		
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
//			System.out.println("연산 수행 오류: ");
//			System.out.println( op + " 연산자는 아직 구현되지 못했습니다.");
//		}		
		
		// 출력부
		printResult(val1 , op, val2, result);
//		System.out.println("==============================");
//		System.out.println("\t계산기 ver 1.0");
//		System.out.printf(" 계산식: %d %c %d = %.2f \n",
//						val1, op, val2, result);
//						//val1, '+', val2, result);
//		System.out.println("==============================");
	}
	// 안내문자열을 입력받아서 출력하고 내부에 스캐너로 사용자의 정수입력을 받아 리턴하는 함수
	private static int userInput(String msg) {
		System.out.println(msg);
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
	private static double calculate(int val1, char op, int val2) {
		double result = 0.0;
		
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
			System.out.println("연산 수행 오류: ");
			System.out.println( op + " 연산자는 아직 구현되지 못했습니다.");
	
			//break;
	}
		return result;
	}

}
