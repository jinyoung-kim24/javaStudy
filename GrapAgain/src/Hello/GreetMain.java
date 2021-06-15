package Hello;  // 패키지 선언(가장 맨위 시작위치)
     // 이소스 파일의 클래스들은 이 패키지에 소유됨.
     // hello.GreetMain
     
     // 주석 ((comment)
     //*
         // 키워드, 예약이(keyward, reeserved)
         

// 클래스 정의 (class Definition)


public class GreetMain { //클래스 정의 시작
     // 함수 정의 (Function Definition) = 기능
     // main() 메인함수= 프로그램의 시작과 끝을 담당함 흐름제어의 함수
	 // entry point(시작 진입점)
	public static void main(String[] args) { // 함수 정의 시작 main() 프로그램의 시작...
		// TODO Auto-generated method stub
   System.out.println("main() 실행..."); // 문장 Statement = 명령 실행의 최소 단위, 반드시; 세미클론으로 끝남.
   
   
   System.out.println(); // 엔터키(리턴키)
   System.out.println("안녕하세요? 홍길동!");// 11개의 글자 텍스트 출력
   System.out.println("안녕하세요? " + "임꺽정!");
   System.out.println("안녕하세요? " + "엘사!");
   
   String GREET_MESSAGE = "안녕하세요? "; // 변수에 데이터 활당
      // 할당(저장 assign)연산자
   System.out.println(GREET_MESSAGE + "홍길동!");// 변수 참조
   System.out.println(GREET_MESSAGE + "임꺽정!");
   System.out.println(GREET_MESSAGE + "엘사!");
    
   GREET_MESSAGE = "안녕하십니까?"; // 새로운 데이터로 재활당
   
   System.out.println(GREET_MESSAGE + "홍길동!");// 변수 참조 (재활당된 새로운 데이터)
   System.out.println(GREET_MESSAGE + "임꺽정!");
   System.out.println(GREET_MESSAGE + "엘사!");
   
	}  // 함수정의 끝; main() 프로그램의 끝, (종료)

} // 클래스 정의 끝
