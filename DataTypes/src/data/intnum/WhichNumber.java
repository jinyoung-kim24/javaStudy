package data.intnum;

public class WhichNumber {

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

}
