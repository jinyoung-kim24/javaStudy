package collective.sets;

import java.util.HashSet;

public class MySets {
	// 집합과 집합사이의 연산 (합집합의 결과를 setA 반영
	public static void unionSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null 집합은 비교 불가능");
			return;
		}
		if (setA.isEmpty()) {
			for (Character c : setB) {
				setA.add(c); // 요소복제
//			setA = setB; 
			}
		} else if (setB.isEmpty()) {
			System.out.println("setA는 합집합 결과 자기자신임");
		} else { // 둘다 공집합이 아님
			for (Character c : setB) {
				setA.add(c); // 중복이 자동 제거됨
				// 집합 B에만 있고 집합 A는 없는 문자들만 집합A에 추가됨.
			}
		}

	}

	// 합집합 setA u setB 연산 (합집합의 결과과 새로운 집합으로 리턴)
	public static HashSet<Character> unionSetReturn(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null 집합은 비교 불가능");
			return null;
		}
		HashSet<Character> union = new HashSet<Character>();
		for (Character c : setA) {
			union.add(c);
		}
		for (Character c : setB) {
			union.add(c);
		}
		// 중복은 자동 제거되며 중복되지 않는
		// B집합의 요소만 앞의 union에 add됨.
		return union;
	}

	// 교집 setA u set B 연산
	public static HashSet<Character> intersectionSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null 집합은 비교 불가능");
			return null;

		}
		if (!setA.isEmpty() || setB.size() > 0) {
			HashSet<Character> intersection = new HashSet<Character>();
			for (Character c : setA) {
				if (setB.contains(c)) {
					intersection.add(c);
				}
			}
			return intersection;
		} else { // 둘 중 하나 이상이 공집합
			return new HashSet<Character>(); // 0크기의 공집합
		}
	}

	// 차집합 setA - setB = setA - (setA n setB)
	public static HashSet<Character> differenceSet(HashSet<Character> setA, HashSet<Character> setB) {
		if (setA == null || setB == null) {
			System.out.println("null 집합은 비교 불가능");
			return null;
		}
		if (!setA.isEmpty() || setB.size() > 0) {
			HashSet<Character> minusAB = new HashSet<Character>();
			for (Character c : setA) {
				minusAB.add(c);
			}
//			minusAB = setA; // 같은 집합을 가리킴 동시에 변함.
			HashSet<Character> interAB
				= intersectionSet(setA, setB);
			for (Character c : interAB) {
				minusAB.remove(c);
			}
			return minusAB;
		} else {
			System.out.println("공집합.....");
			return null;
		}
	}
}
