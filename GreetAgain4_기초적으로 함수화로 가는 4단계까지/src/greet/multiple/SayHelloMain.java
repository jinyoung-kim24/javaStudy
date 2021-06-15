package greet.multiple;

//class A {}
//class B {}

public class SayHelloMain {
	public static void main(String[] args) {
		// 함수화 단계
		// 1단계 '무식하게'
		System.out.println("좋은 아침입니다." 
				+ "\t" + "엘사" + "~~!!" ); // 함수 호출
		System.out.println("------------------------");
		System.out.println("\r\n"); // ASCII, UNICODE
		System.out.println("안녕히 주무셨어요?" 
				+ "\t" + "안나" + "~~!!" ); 
		System.out.println("------------------------");
		System.out.println("\r\n");
		System.out.println("점심 맛있게 드세요." 
				+ "\t" + "올라프" + "~~!!" ); 
		System.out.println("------------------------");
		System.out.println("\r\n"); 
		System.out.println("좋은 저녁입니다." 
				+ "\t" + "스벤" + "~~!!" ); 
		System.out.println("------------------------");
		System.out.println("\r\n"); 
		
		// 2단계 상수화 (결과에서 변하지 않는 고정 데이터)
		final String TAB = "\t";// "           ";//"\t";
		final String PUNC = "~~!!";
		final String SEP = "------------------------";
		final String END = "\r\n"; // 엔터키, 개행문자
		
		System.out.println("좋은 아침입니다." 
				+ TAB + "엘사" + PUNC ); // 함수 호출
		System.out.println(SEP);
		System.out.println(END); // ASCII, UNICODE
		
		System.out.println("안녕히 주무셨어요?" 
				+ TAB + "안나" + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
		System.out.println("점심 맛있게 드세요." 
				+ TAB + "올라프" + PUNC ); 
		System.out.println(SEP);
		System.out.println(END); 
		System.out.println("좋은 저녁입니다." 
				+ TAB + "스벤" + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
		
		// 3단계 변수화 적용 (결과에서 매번 실행시마다 입력으로 들어오는 변하는 데이터)
		String msgGreeting; // 인사말 저장용 변수
		String toName; // 인사대상 이름 저장용 변수
		
		msgGreeting = "좋은 아침입니다.";
		toName = "엘사";
		System.out.println(msgGreeting 
				+ TAB + toName + PUNC ); // 함수 호출
		System.out.println(SEP);
		System.out.println(END); // ASCII, UNICODE
		
		msgGreeting = "안녕히 주무셨어요?";
		toName = "안나";
		System.out.println(msgGreeting 
				+ TAB + toName + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
		
		msgGreeting = "점심 맛있게 드세요.";
		toName = "올라프";
		System.out.println( msgGreeting
				+ TAB + toName + PUNC ); 
		System.out.println(SEP);
		System.out.println(END); 
		
		msgGreeting = "좋은 저녁입니다.";
		toName = "스벤";
		System.out.println(msgGreeting 
				+ TAB + toName + PUNC ); 
		System.out.println(SEP);
		System.out.println(END);
		
		
		// 4단계 함수화 (공통부분의 명령행들을 하나의 독립 기능으로 묶어서 정의)
		// 			+ 정의된 함수는 그 이름으로 이후 필요 시마다 호출 
		//sayGreetingMsgToName( msgGreeting, toName );
			// 함수 호출문장
		sayGreetingMsgToName("좋은 아침입니다.", "엘사");
		sayGreetingMsgToName("안녕히 주무셨어요?", "안나");
		sayGreetingMsgToName("점심 맛있게 드세요.", "올라프");
		sayGreetingMsgToName("좋은 저녁입니다.", "스벤");
	    private static String pickAndReturnMessage(int select) {
			return null;
		}
	    return "메시지 없음"; 
	    System.out.println(pickAndReturnMessage());{
		System.out.println(pickAndReturnMessage());
		System.out.println(pickAndReturnMessage());
		System.out.println(pickAndReturnMessage());
		System.out.println(pickAndReturnMessage()); 
	    	
	    }
		// 상수 정의
		final String PREFIX = "winter_";
		final String SAY_A = PREFIX + "좋은 아침입니다."; //+ myfunc()
		//SAY_A "ddd" // 상수는 재활당 시 에러..
		final String SAY_B = "안녕히 주무셨어요?";
		final String SAY_C = "점심 맛있게 드세요.";
		final String SAY_D = "좋은 저녁입니다.";
		
		final String TITLE = "여왕";
				// 변수 정의
		String queen = "엘사";
		
		pickAndShowMessage(selection);
		
		
		// 어떤 인사말을 여왕에게 할지 선택
		int selection =2; // SAY_A
		// 선택 번호 1 ~ 4까지의 범위로 입력, SAY_A ~SAY_D 대응시킴
		
		// 예측할 수 없는 램덤성 적용하여 선택번호를 입력해보자 
		double ran = Math.random(); // 소수점을 표현할 수 있는 실수형 double 타입 
		double PI = 3.142592; 
		// 0.0 ~ 0.xxxx ~ 0.99999xxxxx 범위
		// 0.0 이상 그리고 1.0 미만의 범위의 램덤한 실수(소수점  있는)가 발생함
		// double 형으로 램덤 실수를 돌려줌 .
		// 자바의  random() 유사램덤이다.
		// 램덤 실수 소수점수를 정수로 변환하기
		// 4가지 경우의 수에 램덤을 실수를 대응시키기
		selection = (int)(ran * 4); // 0.1.2.3 => 0~3  
		selection = (int)(ran * 4); 
		// 0.1.2.3 => 0~3 + 1 => 
	     // 강제로 데이터의 타입을 변경하느 "타입캐스팅 Eype casting".
		//System.out.println(pickAndReturnMessageremdonly(selection));
		System.out.println(pickAndReturnMessageremdonly(selection));
		
		
		String temp = 
		// duble ran = 0.334225;
		int myPI = 3.14; // 소수점을 표현하는 정수형 타입 에러
		System.out.println("실수(소수점) = " + ran);
		System.out.println("선택된 램덤 selection = " + selection);
		// 선택 => 분기분 (if 조건부분기분)
		if(selection ==1 )
		sayGreetingMsgToName(SAY_A, queen+TITLE);
		if(selection ==2 )
		sayGreetingMsgToName(SAY_B, queen+TITLE);
		if(selection ==3 )
		sayGreetingMsgToName(SAY_C, queen+TITLE);
		if(selection ==4 )
		sayGreetingMsgToName(SAY_D, queen+TITLE);
		// 화면에 출력하고 pickAndReturnMessage () 함수 리턴 결과가 temp 변수이 임시 저장됨 
		// 이후 여러번 필요에 따라 temp 변수 값을 사용 가능.
		String retMsg = "";
		
		private static String pickAndReturnMessageremdonly(selection);{	
		final String PREFIX = :winter_";
		final String SAY_A = PREFIX + "좋은 아침입니다."; //+ myfunc()
		//SAY_A "ddd" // 상수는 재활당 시 에러..
		final String SAY_B = "안녕히 주무셨어요?";
		final String SAY_C = "점심 맛있게 드세요.";
		final String SAY_D = "좋은 저녁입니다.";
		
		final String TITLE = "여왕"
		// 변수 정의
		String queen = "엘사";
			
		if(selection ==1 ) retMsg = SAY_A;
			sayGreetingMsgToName(SAY_A, queen+TITLE);
		if(selection ==2 ) retMsg = SAY_B;
			sayGreetingMsgToName(SAY_B, queen+TITLE);
		if(selection ==3 ) retMsg = SAY_C;
			sayGreetingMsgToName(SAY_C, queen+TITLE);
		if(selection ==4 ) retMsg = SAY_D;							
			sayGreetingMsgToName(SAY_D, queen+TITLE);
		return retMsg; //함수는 return을 만나면 바로 종료,
		}		
		
		
	}

	// 클래스 안에서만 사용가능한 함수는 private
	// 함수 정의부
	// 함수 실행(호출) 결과로 반드시 문자열 데이터를 리턴(되돌려줌)함.
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
		return "abc";
		// pickAndReturnMessage
		
		
		
	}
}
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
	





