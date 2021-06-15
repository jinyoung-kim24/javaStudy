package string;

public class StrMain {

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
		
		
		
		
	}

}
