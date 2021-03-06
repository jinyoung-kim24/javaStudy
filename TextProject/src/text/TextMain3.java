package text;

public class TextMain3 {

	public static void main(String[] args) {
		String input = "abcdeXYZJQK012789 -+*/%$@&^가나다アエイオウ";
		int cntInput = input.length(); // 유니코드 글자 개수
		System.out.println("cntInput = " + cntInput);
		
		char c = ' ';
		if(isKorean(c) == true)
		System.out.println(c + "문자는 한국어 글자입니다.");
		else if(isEngUpper(c))
			System.out.println(c + "문자는 영어 대문자 입니다.");
		else if(isEngLower(c))
			System.out.println(c + "문자는 영어 소문자 입니다.");
		else if(isNumeric(c))
			System.out.println(c + "문자는 숫자 문자 입니다.");
		else if(isJapanese(c))
			System.out.println(c + "문자는 일본어 가나문자 입니다.");
		else if(isSpaceBar(c))
			System.out.println(c + "문자는 공백 기호 문자입니다");
		else 
			System.out.println(c + "문자는 기타 문자입니다");
	}

	// 문자 판별하는 함수들
	// 스페이스바 문자인지?
	public static boolean isSpaceBar(char c) {
		return c == ' '; // c == 32
	}
	
	// 숫자 문자인지?
	public static Boolean isNumeric(char c) { 
		return c >= '0' && c <= '9';
	}
	
	// 영문 대문자인지?
	public static boolean isEngUpper(char c) {
		return c >= 'A' && c <= 'Z';
	}
	// 영문 소문자인지?
	public static boolean isEngLower(char c) {
		return c >= 'a' && c <= 'z';
	}
	// 한글 문자인지?
	public static boolean isKorean(char c) { // unicord.org
		return c >= '가' && c <= '힣';
	}		// AC00 ~ D7AF
	// 일본어(외국어) 문자인지?
	public static boolean isJapanese(char c) {
		return c >= 0x3041 && c <= 0x30FF;
	}
	
}
