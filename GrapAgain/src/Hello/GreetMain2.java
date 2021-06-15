package Hello;

public class GreetMain2 {

	public static void main(String[] args) {
		//String GREET_MSG1 = ""; // 빈문자열 ""
		String GREET_MSG1 = "안녕!";
		// 변수 선언 동시에 데이터 활당 = 초기화
		String GREET_MSG2; // 변수 선언 (저장공간 준비하라고 알려줌)
		GREET_MSG2 = "안녕하세요??";  // 나중에 변수 초기화 (분리)
 		//
		String person1 = "홍길동";
		String person2 = "안나"; 
		
		person1 = person1 + "~~!!!"; // "홍길동~~!!!"
		// 변수값 새롭게 재활당 (갱신)
		// 여기서 = 활당기호 오른편의 person1 변수는 
		// 아직 갱신 전의 "홍길동" 데이터를 가진 변수임
		person2 = "princess~~" + person2;
		person2 = person2 + "공주";
		
		
		System.out.println(GREET_MSG1 + " " + person1);
		System.out.println(GREET_MSG2 + " " + person2);
		System.out.println(GREET_MSG1 +" " + "홍길동~~");
	}


}
