package collective.sets;

import java.util.HashSet;

public class SetMain3 {

	// '문자열' 집합을 하나 입력받아 그 내용, 즉 요소들을 출력하는 함수
	public static void printSet(HashSet<String> hs) {
		if (hs == null) {
			System.out.println("집합이 널!");
			return;
		}
		System.out.println("# 프로그래밍 언어들: " + hs.size());
		if (hs.isEmpty()) {
			System.out.println("빈 집합 입니다. empty");
		} else {
			for (String prog : hs) {
				System.out.println("* " + prog + "언어");
			}

			System.out.println("------------------");
		}
	}

//	 집합 Set (세트)
//	 *    	(특정 타입의) 요소들을 하나의 범위 내에 묶어놓은 것.
//	 *     순서번호(index) 존재 하지 않음(순서 자체에 의미를 부여하지 않음)
//	 *     자바에서는 단, 집합이 요소들이 중복되는 것을 허용하지 않음.
//	 *     모든 요소들은 오직 레퍼런스 형 '객체'만 가능함.
//	 *    	https://docs.oracle.com/javase/8/docs/api/java/util/Set.html

	public static void main(String[] args) {

		// 요소(Element)타입을 제한한 특수집합
		// <E> 요소타입을 제한하는 제네릭(Generic) - 타입파라미터 제한
		HashSet<String> hs2 = new HashSet<>();
//		hs2.add(문장열형;
		hs2.add("java");
//		hs2.add() // 제네릭 타입 파라미터 제한받아 에러
		hs2.add("python");
		hs2.add("ruby");
		hs2.add("javascript");
		hs2.add("go");
		hs2.add("swift");
		hs2.add("kotlin");
		SetMain3.printSet(hs2);

		hs2.add("typescript");
		hs2.add("php");
		hs2.add("swift"); // 중복 x (집합은 중복이 허용하지 않음)

		printSet(hs2);
		
		hs2.remove("typescript");
		hs2.remove("go");
		hs2.remove("java");

		printSet(hs2);
		hs2.clear(); // 모든 요소를 집합컬렉션에서 제거
		printSet(hs2);
		hs2.add("dart");
		printSet(hs2);
		

	}

}
