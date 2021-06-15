package string;

public class StrMain2 {

	public static void main(String[] args) {
		// Empty String Empty char Array
		String word1 = ""; // 간략식문법으로 객체가 생성
		// 빈문자열; 리터럴 (길이 - 글자개수가 0인 문자열 객체)
		String word2 = new String(""); // 클래스 객체 생성
		int wlen = word1.length(); // 함수호출; 글자 개수, 길이 0
		int wlen2 = word2.length(); // 0

		char[] cArr1 = {}; // 빈문자배열; 리터럴{} 길이 - 문자요소개수가 0개인 배열
		char[] cArr2 = new char[0]; // 요소개수 0인 문자형 개열 생성
		int clen = cArr1.length; // 상수참조 요소글자수 개수, 길이 0
		int clen2 = cArr2.length; // 요소개수 0
		
		// 문자열을 문자배열로 전환??
		String word3 = "April";
		final int wlen3 = word3.length(); // 5개
		char[] cArr3 = {'\0', '\0', '\0', '\0', '\0'}; // 사전고정
		char[] cArr4 = new char[5]; 
		// 5개 메모리 공간에 각각 char의 요소기본값 '\0'로 자동으로 모두 채움
//		char[] cArr4b = new char[wlen3]; 
		// 이 문장이 실행되는 그 순간(runtime 실시간)에 결정되는 wlen3에
		// 값에따라서 크기가 결정되는 배열이 생성.
		char[] cArr4c = new char[word3.length()];
		char[] cArrran = new char[(int)(Math.random() * 10)];
		// 0 ~ 9 실행시 마다 다른 크기의 배열이 랜덤하게 만들어짐
		
		
		// 수동복사 루프문으로 문자열 요소 개별 하나하나를 
		// 순차적으로 하나씩 배열 공간에 복제
		for (int i = 0; i < cArr4c.length; i++) {
			cArr4c[i] = word3.charAt(i);
		}
		// "April" -------> { 'A', 'p', 'r', 'i', 'l'};
		
		// 배열 출력
		printCharArray(cArr4c);
//		for (int i = 0; i < cArr4c.length; i++) {
//			System.out.println(i + "번째 요소 복제 -> " + cArr4c[i]);
//		}
		char[] copyArr = word3.toCharArray(); // 자동복사
		// "April" -------> { 'A', 'p', 'r', 'i', 'l'};
		printCharArray(copyArr);
		
	}

	private static void printCharArray(char[] cArr4c) {
		for (int i = 0; i < cArr4c.length; i++) {
			System.out.println(i + "번째 요소 복제 -> " + cArr4c[i]);
		}
		
	}
}
