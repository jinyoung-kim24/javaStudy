package greet; // 패키지 = 폴더 = 이름공간(namespace)
// <프로젝트폴더>\src\greet\HelloMain.java 소스파일
// greet.HelloMain 클래스 타입명

public class HelloMain {
	
	// 성별 gender 여성, 남성 인지를 표현..
	// boolean 부울대수( true, false만 존재.. 오직 2가지 상태만 존재함)
	// 낮/밤, 참/거짓, yes/no, 상/하.... 흑/백...
	// isFemale 입력변수가 true면 여성 음악가로 설정, 
	// 만약 false라면 남성 음악가로 간주함. 
	public static void sayHelloToMusician2(
			String msg, String name, boolean isFemale ) {
		System.out.println("+=====+=====+=====+=====+");
		System.out.println("      " + msg + "~~~");
		
		// if 조건부분기문.. 조건식에 결과에 따라 이 문장 혹은 저 문장을 분기하여 수행함.
		// isFemale == true 조건식(무조건 최종 결과가  true, false로만 나옴.)
		if(isFemale == true) // 비교 연산자 == 
			System.out.println("\t" + name + "부인" + "~~~!");// 여성
		else 
			System.out.println("\t" + name + "씨" + "~~~!");// 남성
		
		System.out.println("+=====+=====+=====+=====+");
		System.out.println(); // 개행문자가 포함됨 "\n"
	}
	
	
	public static void main(String[] args) {
		System.out.println("~~~ 음악가 인사하기 프로그램 ~~~");
		final String MSG = "멋진 음악이네요"; // 상수 선언과 동시에 정의.
		String who1 = "베토벤"; 
		String who2 = "바흐", who3 = "헨델", who4 = "신사임당";
//		sayHelloToMusician("멋진 날씨네요", "모짜르트");
//		sayHelloToMusician("멋진 광경이네요", "조수미");
//		sayHelloToMusician(MSG, who2);
		//
		sayHelloToMusician2(MSG, who1, false); // 남
		sayHelloToMusician2("멋진 광경이네요", who4, true); // 여
		sayHelloToMusician2("아름다운 하늘이네요.", "조수미", true);
		sayHelloToMusician2("멋진 날씨네요", who3, true);  // false);
	} // main() 끝..
	
	// 함수 정의는 위치가 상관없다. 
	public static void sayHelloToMusician(
			String msg, String name) {
		System.out.println("+=====+=====+=====+=====+");
		System.out.println("      " + msg + "~~~");
		System.out.println("\t" + name + "씨" + "~~~!");
		System.out.println("+=====+=====+=====+=====+");
		System.out.println(); // 개행문자가 포함됨 "\n"
	}
	
} // 클래스 끝.


/*
  
  ~~~ 음악가 인사하기 프로그램 ~~~
+=====+=====+=====+=====+
      멋진 음악이네요~~~
	베토벤씨~~~!
+=====+=====+=====+=====+

+=====+=====+=====+=====+
      멋진 광경이네요~~~
	신사임당부인~~~!
+=====+=====+=====+=====+

+=====+=====+=====+=====+
      아름다운 하늘이네요.~~~
	조수미부인~~~!
+=====+=====+=====+=====+

+=====+=====+=====+=====+
      멋진 날씨네요~~~
	헨델부인~~~!
+=====+=====+=====+=====+


 
 
 */
