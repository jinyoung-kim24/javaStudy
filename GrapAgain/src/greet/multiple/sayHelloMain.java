package greet.multiple;

//class A {}
//class B {}

	public class sayHelloMain {
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






