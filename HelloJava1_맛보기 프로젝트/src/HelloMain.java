/**
 * 
 */

/**
 * benjamin
 *
 */
public class HelloMain {

	/*
	 * ㄹㄴㅇㄴㅇㄹ

	 * ㄹㅇㄴ
	 * ㄹㅇ
	 * ㄹㅇㄴ
	 다중 설명문 주석 
	 */
	
	// main 함수(function) -- 프로그램의 시작 위치
	public static void main(String[] args) {
		// 주석... comment -- 명령어부분이 아니고
		// 		    자유로운 설명문...

		// println() 출력 기능 함수
		//System.out.println("Hello Java!!");
//		System.out.print("Hello Java!!");
		System.out.print("Hello Java!! "); 
			// 공백문자도 데이터다..
		System.out.println("안녕 Java!!");
		
		// sysout 자동완성 매크로 단축키 ctrl + space키
		// ctrl + F11 ==> RUN
		System.out.println("Hello! " + "자바..?" + 
		
						" 프로그래밍 언어 "
						+ 2021 + "year!!"				
				);
		// + 기호는 두개의 문자열을 붙여준다. 

		// text 텍스트 =>  문자열  string
		// 리터럴 기호 "사용하여 문자열을 표현.
		// "로 시작해서 "로 끝나는 문자들의 일련의 집합..
		// "abc", "AbCdef", "12345", "제임스 고즐링"
//		System.out.println("제임스 고즐링");
		
		String  who  = "제임스 고즐링"; // 변수 선언과 초기화
	//  타입 	   변수(명) 할당(저장)연산자    문자열데이터   명령의끝(문장의끝)
	//	String age = "60";
		int age = 60;  // 정수 타입  (수치형 , 값...)
		System.out.println("famous GURU! " + who ); // 변수 참조
		who = "스티브 잡스";
		System.out.println("famous GURU II !!" + who);
		age = 22;
		who = "엘사공주";
		System.out.println("famous guru: 이름 " + who + 
				"님!!, 나이 " + age +"세" );
	}

}
