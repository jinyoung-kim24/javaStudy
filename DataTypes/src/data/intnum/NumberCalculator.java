package data.intnum;

public class NumberCalculator {

	public static void main(String[] args) {
		// 정수 계열의 변수들 나열...
		// 부호 signed + - 
		int numA = 100; // +100;
		int numB = 48; //-100;
		
		// 산술 연산자 (Arithmetic Operator)
		// + - * /  사칙연산
		int sumVal, diffVal, mulVal, 
			divVal = 0;
		
		numB = 0;
//		numB = 3;
		
		sumVal = numA + numB;
		diffVal = numA - numB;
		mulVal = numA * numB;
		
		// 나머지 연산자 (중요함!!)
		int modVal = 0;		
		
		//if( numB > 0 ) {  // if절 블록의 시작
		//			
		//	} // if의 끝
		if( numB != 0 ) {  // 값이 같지 않음.. 
			divVal = numA / numB;
			System.out.println(">> 나눗셈 실행중...");		
			// Exception in thread "main" java.lang.ArithmeticException: / by zero
			// 0으로 나눗셈을 수행하면 예외가 (실시간 에러) 발생...
			modVal = numA % numB;
			System.out.println(">> 나머지 연산 실행중...");
		}
		else // numB == 0
		{
			System.out.println("0으로 나눌 수 없어요!!");
			System.out.println();
		}
		
//		// 나머지 연산자 (중요함!!)
//		int modVal = 0;
//		modVal = numA % numB;
		
		System.out.println(numA + " + " + numB + " = " + sumVal);
		System.out.println(numA + " - " + numB + " = " + diffVal);
		System.out.println(numA + " - " + numB + " = " + (numA-numB));
		System.out.println(numA + " × " + numB + " = " + mulVal);
		System.out.println(numA + " ÷ " + numB + " = " + divVal);
							// 'ㄷ' + 한자키... 수학기호
		System.out.println(numA + " % " + numB + " = " + modVal);
	}

}

/*
0으로 나눌 수 없어요!!

100 + 0 = 100
100 - 0 = 100
100 - 0 = 100
100 × 0 = 0
100 ÷ 0 = 0
100 % 0 = 0

*/