package data.intnum;

public class WhichNumber2 {

	public static void oddOrEvenNumber(int num) {
		// 전처리부 -- 양의 정수 (자연수)만 처리하자
		//if(num >= 0) {} else {}
		if(num > 0) {
		if(num % 2 == 1) // 홀수 기준으로 참 true
			System.out.println(num + "은/는 홀수Odd 입니다.");
		else // 짝수 기준으로 거짓 false
			System.out.println(num + "은/는 짝수even 입니다.");
		
	}else {
		System.out.println("짝홀수 판별 대상수는 양의 정수만 됩니다.^^ - 대상수:" + num);
	}
		
		// 메인처리부
		if(num % 2 == 1) // 홀수 기준으로 참 true
			System.out.println(num + "은/는 홀수Odd 입니다.");
		else // 짝수 기준으로 거짓 false
			System.out.println(num + "은/는 짝수even 입니다.");
		
	}
	
	public static void main(String[] args) {
		int a = 256;
		int b = 37;
		
		oddOrEvenNumber(100); // 짝홀수 판정 결과 출력하는 함수
		oddOrEvenNumber(37);
		oddOrEvenNumber(123456);
		oddOrEvenNumber(0);
		oddOrEvenNumber(-39);
		
		String oddEvenMsg; // 짝홀수 판정 결과가 "짝수" , "홀수"로 담기는 변수
		oddEvenMsg = oddOrEvenReturnMsg(200); //call
		// 짝홀수 판정 결과를 함수 안에서 바로 출력하지 않고!!!
		// 문자열 데이터 리턴으로 가져오는 함수
		System.out.println(200 + "은/는" + oddEvenMsg + "로 판정되었음." );
		
		
		
		// 짝수even (pair), 홀수 odd
		// 나머지 연산자 %
		// 임의 정수를 2로 나눈 나머지가 0으로 딱 떨어지면 짝수.
		// 임의 정수를 2로 나눈 나머지가 1이면 홀수.
		// int r = a % 2; 
		int r = b % 2;
		
		//if(조건식) { 조건식이 true 이면 실행}
		// else { 조건식이 false이면 실행; }
		
		if(r == 0)
			System.out.println("짝수 입니다.");
		else
			System.out.println("홀수 입니다.");

		
		//if(a % 2 == 1) // 언제나 true
		if(true) // 홀수면...
			System.out.println("홀수 입니다.");
		else
			System.out.println("짝수 입니다.");
			
		//if(b % 2 == 0)
		//if(b % 2 != 1)	// 홀수가 아니면...
		//if(1 != 1) // 언제나 false
		//if(2 < 1)
		if(false)
			System.out.println("짝수 입니다.");
		else
			System.out.println("홀수 입니다.");
		
		//if(3 + 4 == 4)
	}

	private static String oddOrEvenReturnMsg(int num) {
		final String ODD = "홀수";
		final String EVEN = "짝수";		
		String result = ""; // empty string
		//return null; // 아무것도 가리키지 않은 상태 표현함 null 널
		//return ""; //빈문자열
		if(num % 2 == 0) result = EVEN;
		else result = ODD;
		return result;
		
	}

}
