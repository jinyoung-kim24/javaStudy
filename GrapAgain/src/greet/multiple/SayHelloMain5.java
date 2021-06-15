package greet.multiple;

public class SayHelloMain5 {
	public static void main(String[] args) {		
		// 상수 정의
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "좋은 아침입니다.";// + myfunc() * 3;
		//SAY_A = "ddd"; // 상수는 재할당 시 에러..
		final String SAY_B = PREFIX + "안녕히 주무셨어요?";
		final String SAY_C = PREFIX + "점심 맛있게 드세요.";
		final String SAY_D = PREFIX + "좋은 저녁입니다.";
		//
		final String TITLE = "여왕";
		// 변수 정의
		String queen = "엘사";
		
		// 어떤 인사말을 여왕에게 할지 선택
		int selection = 2; //5 //0 //4;//1; // SAY_A
			// 선택 번호 1 ~ 4까지의 범위로 입력, SAY_A ~ SAY_D 대응시킴
		
		// 예측할 수 없는 램덤성을 적용하여 선택번호를 입력해보자.
		double ran = Math.random(); // 소수점을 표현할 수 있는 실수형 double 타입
		// Returns a double value with a positive sign, greaterthan or equal to 0.0 and less than 1.0.
		// 0.0 ~ 0.xxxx ~ 0.99999xxxxx 범위
		// 0.0 이상 그리고 1.0 미만의 범위의 랜덤한 실수(소수점 있는)가 발생됨.
		// double 형으로 랜덤 실수를 돌려줌.
		// 자바의 random() 유사랜덤이다. 
		
		// 랜덤 실수 소수점수를 정수로 변환하기
		// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random--
		// 4가지 경우의 수에 램덤를 실수를 대응시키기 
//		selection = (int)(ran * 4); // 0, 1, 2, 3 => 0 ~ 3
		selection = (int)(ran * 4) + 1; 
			// 0, 1, 2, 3 => 0 ~ 3 + 1 => 0+1 ~ 0+3=4 => 1 ~ 4
			// 강제로 데이터의 타입을 변경하는 "타입캐스팅 type casting".
				
		//double ran = 0.334225; // 
		//double PI = 3.141592;
		//int myPi = 3.14; // 소수점을 표현할는 정수형 타입 .. 에러.
		System.out.println("실수(소수점) = " + ran);
		System.out.println("선택된 랜덤 selection = " + selection);

		//System.out.println(pickAndReturnMessage(3));
		
		System.out.println(pickAndReturnMessage(selection));
			// 화면에 출력하고 pickAndReturnMessage()함수 리턴 결과를 버림.
		
		String temp = pickAndReturnMessage(selection);
			// pickAndReturnMessage()함수 리턴 결과가 temp 변수에 임시 저장됨.
			// 이 후 여러번 필요에 따라 temp 변수 값을 사용 가능.
		System.out.println(temp);
		
		System.out.println(temp+"==========");
		
		System.out.println(pickAndReturnMessageRamdomly());
		System.out.println(pickAndReturnMessageRamdomly());
		System.out.println(pickAndReturnMessageRamdomly());
		
//		pickAndShowMessage(selection);
//		pickAndShowMessageRamdomly();
//		pickAndShowMessageRamdomly();
//		pickAndShowMessageRamdomly();
//		pickAndShowMessageRamdomly();
		
	} // main() 끝

	private static String pickAndReturnMessageRamdomly() {
		// 상수 정의
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "좋은 아침입니다.";// + myfunc() * 3;
		final String SAY_B = PREFIX + "안녕히 주무셨어요?";
		final String SAY_C = PREFIX + "점심 맛있게 드세요.";
		final String SAY_D = PREFIX + "좋은 저녁입니다.";
	
		int selection = (int)(Math.random() * 4) + 1;
		if( selection == 1 ) return SAY_A;
		if( selection == 2 ) return SAY_B;
		if( selection == 3 ) return SAY_C;
		if( selection == 4 ) return SAY_D;	
		return "메시지 없음";
	}
	
	
	// 함수 실행(호출) 결과로 	반드시 문자열 데이터를 리턴(되돌려줌)함.
	private static String pickAndReturnMessage(int selection) {
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "좋은 아침입니다.";// + myfunc() * 3;
		final String SAY_B = PREFIX + "안녕히 주무셨어요?";
		final String SAY_C = PREFIX + "점심 맛있게 드세요.";
		final String SAY_D = PREFIX + "좋은 저녁입니다.";
		
		String retMsg = "";
		if( selection == 1 ) retMsg = SAY_A;
		if( selection == 2 ) retMsg = SAY_B;
		if( selection == 3 ) retMsg = SAY_C;
		if( selection == 4 ) retMsg = SAY_D;
	
		return retMsg; // 함수는 return을 만나면 바로 종료.
		//return "abc";
	} // pickAndReturnMessage() 끝
	
	
	private static void pickAndShowMessageRamdomly() {
		// 상수 정의
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "좋은 아침입니다.";// + myfunc() * 3;
		//SAY_A = "ddd"; // 상수는 재할당 시 에러..
		final String SAY_B = PREFIX + "안녕히 주무셨어요?";
		final String SAY_C = PREFIX + "점심 맛있게 드세요.";
		final String SAY_D = PREFIX + "좋은 저녁입니다.";
		//
		final String TITLE = "여왕";
		// 변수 정의
		String queen = "엘사";
		int selection = (int)(Math.random() * 4) + 1;
		// 선택 => 분기문 (if 조건부분기문) 
		if( selection == 1 ) 
			sayGreetingMsgToName(SAY_A, queen+TITLE);
		if( selection == 2 ) sayGreetingMsgToName(SAY_B, queen+TITLE);
		if( selection == 3 )
			sayGreetingMsgToName(SAY_C, queen+TITLE);
		if( selection == 4 )
			sayGreetingMsgToName(SAY_D, queen+TITLE);			
	}
	
	
	private static void pickAndShowMessage(int selection) {
		//selection = 4;
		// 상수 정의
		final String PREFIX = "Winter_";
		final String SAY_A = PREFIX + "좋은 아침입니다.";// + myfunc() * 3;
		//SAY_A = "ddd"; // 상수는 재할당 시 에러..
		final String SAY_B = PREFIX + "안녕히 주무셨어요?";
		final String SAY_C = PREFIX + "점심 맛있게 드세요.";
		final String SAY_D = PREFIX + "좋은 저녁입니다.";
		//
		final String TITLE = "여왕";
		// 변수 정의
		String queen = "엘사";
		
		// 선택 => 분기문 (if 조건부분기문) 
		if( selection == 1 ) 
			sayGreetingMsgToName(SAY_A, queen+TITLE);
		if( selection == 2 ) sayGreetingMsgToName(SAY_B, queen+TITLE);
		if( selection == 3 )
			sayGreetingMsgToName(SAY_C, queen+TITLE);
		if( selection == 4 )
			sayGreetingMsgToName(SAY_D, queen+TITLE);			
	}

	// 클래스 안에서만 사용가능한 함수는 private
	// 함수 정의부
	private static void sayGreetingMsgToName(
			String msgGreeting, String toName) {
		final String TAB = "\t";// "           ";//"\t";
		final String PUNC = "~~!!";
		final String SEP = "------------------------";
		final String END = "\r\n"; // 엔터키, 개행문자
		
		System.out.println(msgGreeting 
				+ TAB + toName + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
	}
}

/*
실수(소수점) = 0.5863448274589801
선택된 랜덤 selection = 3
Winter_점심 맛있게 드세요.	엘사여왕~~!!
------------------------ 
 */




