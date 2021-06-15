package collective.sets;

import java.util.HashSet;

public class SetMain5 {

	public static void main(String[] args) {
		//HashSet<char> hs = new HashSet<char>(); // error
//		HashSet<Character> hs = new HashSet<Character>(); // ok
		// 자바 제네릭, 타입 파라미터 제한,에서는 오직 요소의 타입을 
		// 객체지향형 레퍼런스타입으로 제한해야함. 기본형 안됨.. 랩퍼클래스 적용권장.
		HashSet<Character> hsA = new HashSet<>();			// 생성자명에서의 긴 제네릭이름은 생략 가능함 ok
		HashSet<Character> hsB = new HashSet<Character>();
		HashSet<Character> hsC;// = null; //new HashSet<>();
		
		hsA.add('K'); hsA.add('G'); hsA.add('B');
	
		printCharSet(hsA, "문자집합 HS_A");
	
		// hsB 빈 집합에 랜덤한 대문자 문자객체 요소를 20개 정도 입력해 넣기
		fillRandomCharToSet(hsB, 20);
		
		printCharSet(hsB, "램덤문자 집합 HS_B");
		// limit는 대문자 개수를 넘어서면 안됨!! (무한루프!)
		hsC = fillRandomCharToSetReturn(10); // 7);//3);
		printCharSet(hsC, "랜덤문자 집합 HS_C");
	}

	// 함수 내부에서 집합을 동적생성하여 그 내용을 채워서 리턴함..
	public  static HashSet<Character> 
		fillRandomCharToSetReturn(int inputLimit) {
		 HashSet<Character> hs = new HashSet<Character>();
//		fillRandomCharToSet(hs, inputLimit);
//		
		final int limit = inputLimit > 0 ? inputLimit: 20;
		for (int i = 0; i < limit; i++) {
			boolean b = false;
			do {
				char c = (char)((int)(Math.random()*26)+'A'); // 
				b = hs.add(c);
				if( b == false )   // if( !b )
					System.out.println(">> 중복발견 !" + c);
			} while(b == false);
		}	
		return hs;	
	}

	// limit 개수만큼의 랜덤 대문자 요소들을 입력집합에 채워주는 함수
	public static void fillRandomCharToSet(
			HashSet<Character> hs, int inputLimit) {
		if( hs == null ) hs = new HashSet<Character>();// 빈집합
		final int limit = inputLimit > 0 ? inputLimit: 20;
		for (int i = 0; i < limit; i++) {
			boolean b = false;
			do {
				char c = (char)((int)(Math.random()*26)+'A'); // 
				b = hs.add(c);			
			} while(b == false);
		}		
	}

	public static void printCharSet(
			HashSet<Character> hs, String title) {
		System.out.println(title + " : " + hs.size());
		for (Character ch : hs) {
			System.out.printf("%c ", ch); 
		}
		System.out.println("\n-------------------------------");
	}

}

/*
문자집합 HS_A 3
B G K 문자집합 HS_B 20
A D E F G H I J K L O Q R S T U V X Y Z 
*/