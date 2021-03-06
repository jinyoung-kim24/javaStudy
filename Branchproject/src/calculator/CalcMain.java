package calculator;

public class CalcMain {
	// 클래스 공통 상수 정의
	public static final char OP_ADD = '+'; // 43
	public static final char OP_SUBTRACT = '-';
	public static final char OP_MULTIPLY = '*';
	public static final char OP_DIVIDE = '/';
	public static final char OP_REM = '%';
	public static final char OP_NONE = ' '; // 32 space
	// 거듭제곱.... 백분율... 
	public static void main(String[] args) {
		// 준비: 선언, 초기화
		int val1 = 0, val2 = 0; // 값 operand
		char op = OP_NONE;   //'\0'; // 연산자 operator +-*/%
		double result = 0.0;
		
		//입력부
		val1 = 200; op = OP_REM; val2 = 0;
		
		// 계산 실행부
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
			System.out.println("연산 수행 오류: ");
			System.out.println(op + "연산자는 아직 구현되지 못했습니다.");
		}
		
		// 출력부
		System.out.println("============================");
		System.out.println("\t계산기 ver 1.0");
		System.out.printf("계산식: %d %c %d = %.2f \n",val1, op , val2 , result);
		
	}

}
