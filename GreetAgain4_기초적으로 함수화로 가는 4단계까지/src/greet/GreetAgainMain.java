package greet;

public class GreetAgainMain { // brace
						// ( parenthesis?
	
	// 반복된 코드, 공통으로 적용되는 코드, 특정의미를 부여한 코드 
	// 묶어서 대표 이름을 붙임
	// 함수정의 = 선언 + 구현부
	public static void sayHello() { // 함수 정의 시작 
		String MSG_JP = "こんにちは?";
		String name1 = "엘사";
		System.out.println(MSG_JP + " " + name1);
	} // 함수 정의 끝
	
	// who라고 하는 문자열 입력데이터가 함수 호출시 반드시 제공되어야 함. 
	// sayHello2(); 오류...    sayHello2("홍길동");
	// who는 입력변수(파라미터 parameter, 아규먼트 argument, 인자)로써 
	// 함수 호출시에 초기화됨. 
	public static void sayHello2(String who) {
		//who = "aaa";
		String MSG_JP = "こんにちは?";
		String name1 = who; // "엘사";
		//System.out.println(MSG_JP + " " + name1);
		System.out.println(MSG_JP + "\t~~" + name1);
	}
	
	public static void sayHello2B(String who) {
		String MSG_JP = "こんにちは?";
		String name1 = who;
//		System.out.println(MSG_JP + "\t~~" + name1);
		sayHello3(MSG_JP, who);
	}
	
	// 컴마 , comma 연산자로 2개 이상의 입력변수 인자들을 함수정의에 포함.
	public static void sayHello3(String msg, String who) {
		System.out.println(
				"dear: " +
				msg + "\t... " + who + "~~!!");
	}
	
	public static void main(String[] args) { // [ bracket
		// unicode.org 유니코드로 자바는 모든 문자를 인코딩함.
		// 문자열 변수 선언 및 초기화
		String MSG_KR; // 변수 variable 선언
		MSG_KR = "안녕하세요?" + "^o^"; // 할당 (초기화 initialization)
		String MSG_JP = "こんにちは?";
		String MSG_CN = "你好?";
		String MSG_RU = "Здравствуй?";
		String MSG_MG = "Сайн уу?";
		final String MSG_EN = "Hello?";
		
		final String MSG_JP2 = "はじめまして。";
			// 상수 선언 및 초기화 constant => 처음 초기화로 값과 타입이 고정됨.
//		MSG_JP = "aaa"; // 새로운 값으로 언제든지 변수는 재할당이 가능.
//		MSG_JP2 = "bbb"; // 상수는 재할당이 에러남...
		
		String name1 = "엘사";
		String name2 = "홍길동";
		
		System.out.println(MSG_KR + " " + name1);
			// println() 함수임.
			// println(입력값).. 즉 괄호안에 입력값을 받아서 함수 자신에게
			// 정의된 고유 기능을 수행함. 
		MSG_JP = MSG_JP2; // "はじめまして。"  
			// 상수값을 참조하여 변수에 재할당
		name1 = "올라프";
		System.out.println(MSG_JP + " " + name1);
		System.out.println(MSG_CN + " " + name1);
		
		System.out.println(MSG_RU + " " + name2);
		System.out.println(MSG_MG + " " + name2);
		System.out.println(MSG_EN + " " + name2);
		
		sayHello(); // 함수호출 Function Call => 함수이름();
//		sayHello(); // 함수호출
//		sayHello(); // 함수호출
//		sayHello(); // 함수호출
		
		sayHello2("안나"); 
			// "안나" 입력 문자열 데이터가 sayHello2()함수
			// 안쪽의 who 변수에 할당됨.
		sayHello2("올라프");
//		sayHello2(); // who에 넘겨지는 인자가 없어서.. 에러.				
		//
		sayHello3("좋은 아침이네요.", "크리스토프");
		sayHello3("당근드세요.", "스벤");
		String name3 = "물소스벤";
		name3 = "멋진 " + name3;
		sayHello3("고마워요!", name3);
	}

}
