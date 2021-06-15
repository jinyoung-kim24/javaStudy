package collective.sets;

import java.util.HashSet;

public class SetMain4 {

	public static void main(String[] args) {
//		HashSet<> hs = new HashSet<>(c) //error
//		HashSet<Character> hs = new HashSet<Character>();
		// 자바 제네릭, 타입 파라미터 제한에서는 오직 요소의 타입을 
		// 객체지향형 레퍼런스타입으로 제한해야함. 기본형 안됨.. 랩퍼클래스 적용권장.
		HashSet<Character> hsA = new HashSet<>();
		// 생성자명에서의 긴 제네릭이름은 생략 가능함 ok
		HashSet<Character> hsB = new HashSet<Character>();
		
		hsA.add('K'); // autoboxing
//		hsA.add(new Character('K'));
		hsA.add('G');
		hsA.add('B');
		
		System.out.println("문자집합 HS A " + hsA.size());
		for (Character ch : hsA) {
			System.out.printf("%c \n", ch.charValue()); // manualboxing
//			System.out.printf("%c ", ch); // autounboxing
		}
		
		// hsB 빈 집합에 랜덤한 대문자 문자객체 요소를 20개 정도 입력해 넣기
		final int limit = 20;
		boolean b = false;
		for (int i = 0; i < limit; i++) {
			do {
			char c = (char)((int)(Math.random() * 26) + 'A');
			b = hsB.add(c); // 집합에 요소추가 성공시 true
			// 중복되어서 요소초가 실패시 false
			if(b == false)
				System.out.println("중복발견 ! " + c);
			}while(b == false);
		}
			
		System.out.println("문자집합 HS B " + hsB.size());
		for (Character ch : hsB) {
			System.out.printf("%c ", ch.charValue());
		}
	}

}
