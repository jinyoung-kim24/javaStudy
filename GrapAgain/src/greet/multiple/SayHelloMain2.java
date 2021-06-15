package greet.multiple;

public class SayHelloMain2 {
	public static void main(String[] args) {		
		// 4단계 함수화 (공통부분의 명령행들을 하나의 독립 기능으로 묶어서 정의)
		// 			+ 정의된 함수는 그 이름으로 이후 필요 시마다 호출 
		//sayGreetingMsgToName( msgGreeting, toName );
			// 함수 호출문장
//		sayGreetingMsgToName("좋은 아침입니다.", "엘사");
//		sayGreetingMsgToName("안녕히 주무셨어요?", "안나");
//		sayGreetingMsgToName("점심 맛있게 드세요.", "올라프");
//		sayGreetingMsgToName("좋은 저녁입니다.", "스벤");
		
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
		
		// 선택 => 분기문 (if 조건부분기문) 
		if( selection == 1 ) 
			sayGreetingMsgToName(SAY_A, queen+TITLE);
		if( selection == 2 ) sayGreetingMsgToName(SAY_B, queen+TITLE);
		if( selection == 3 )
			sayGreetingMsgToName(SAY_C, queen+TITLE);
		if( selection == 4 )
			sayGreetingMsgToName(SAY_D, queen+TITLE);
		
		
	} // main() 끝

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






