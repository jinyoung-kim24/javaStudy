package text;

public class CharacterMain {

	public static void main(String[] args) {
		// 텍스트 편집기 (메모장)
		// abcd ABCD 가나다 123123 ~!@#^ ( => text 텍스트 정보)
		// 문자 하나 => 자바(컴퓨터)에서 문자코득밧(수치형데이터)로 표현. 
		// 문자를 직접 표현하거나 처리할 수는 없음. 하지만,
		// 문자에 대응되는 순서 번호값을 부여하여 문자를 처리할 수 있음.
		// A => 1, B => 2, ........., Z => 26
		// 문자형 character type 
		char c; // 단 하나의 글자 하나만 저장할 메모리 공간 확보.
		// 2바이트, 2byte = 16 bits 65536가지수 표현 == short 비슷
		// 0 ~ 65535까지 문자코드값
		// "abc123" 문자열(String) 리터럴 " 큰따음표.
		// 'a' 문자하나(char) 리터럴 ' 작은따음표.
		// 각 문자들은 모두 현재 선택된 문자셋( character set )에 따라서 표현됨.
		// 자바언어는 char형 문자에 대해서 UTF_16형식으로 처리함.
		// 즉 유니코드(unicode)로 처리함.
		// 다만, 가장 자주 사용되는 즉, 키보드 자판으로 표현되는 문자들은
		// ASCII 아스키 코드셋을 따라 인코딩됨.
		c = 'A'; // 65 코드값을 표현. 
		c = 65; // 십진법  코드값  
		c = 0x41;  // 65 = 16^1 * 4 + 16^0 * 1
		char c2 = 'B'; //66;
		char c3 = 66;
		char c4 = 65 + 1; // 코드값을 수치형으로 보고 +거나 -면 순서가 변경.
		char c5 = 'A' + 1;
		char d = 'a'; // 97;, 0x61
		char e = '0'; // 48 숫자문자... 외우세요  0x30
		char space = ' '; // 32 => 0x20  공백문자 스페이스
		String strEmpty = ""; // 문자열형 빈문자열.
		
		
//		System.out.println('A'); // 아스키코드 영문대문자
//		System.out.println('가'); // 한글 유니코드문자
//		System.out.println('\t'); // 특수문자 \n, \b, \r 
		// %c는 문자하나를 폰트로 출력하는 서식자
//		System.out.printf("문자 %c => 코드값%d \n", 'A', (int)'A');
//		System.out.printf("문자 %c  => 코드값%d \n", 'a', (int)'a');
//		System.out.printf("문자 %c  => 코드값%d \n", '가', (int)'가');
//		System.out.printf("문자 %c  => 코드값%d \n", c5, (int)c5); // 'B';
//		System.out.printf("문자 %c  => 코드값%d \n", e, (int)e); // '0';
//		System.out.printf("문자 %c  => 코드값%d \n", space, (int)space); // ' ';
	
		printCharWithCode('A');
		printCharWithCode('a');
		printCharWithCode('가');
		printCharWithCode('하');
		printCharWithCode('z');
		printCharWithCode('!');
		printCharWithCode(' ');
		printCharWithCode('お');
		printCharWithCode('й');
		
		
//		System.out.printf("문자 %c => 코드값%d [0x%X] \n", 'A', (int)'A', (int)'A');
//		System.out.printf("문자 %c  => 코드값%d [0x%X] \n", 'a', (int)'a', (int)'a'); // (int)97
//		System.out.printf("문자 %c  => 코드값%d [0x%X] \n", '가', (int)'가', (int)'가');
//		System.out.printf("문자 %c  => 코드값%d [0x%X] \n", c5, (int)c5, (int)c5); // 'B';
//		System.out.printf("문자 %c  => 코드값%d [0x%X] \n", e, (int)e, (int)e); // '0';
//		System.out.printf("문자 %c  => 코드값%d [0x%X] \n", space, (int)space, (int)space); // ' ';
	}

	private static void printCharWithCode(char c) {
		System.out.printf("문자 %c => 코드값%d [0x%X] \n", c, (int)c, (int)c);
		
	}

}
