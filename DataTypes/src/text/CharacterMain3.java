package text;

public class CharacterMain3 {
	// 공용상수
	public static final char SPC = ' ';
	
	// 대문자 하나를 입력받아 소문자로 변경하여 리턴하는 함수
	public static char upperToLower(char big) {
		// big 정상범위 입력으로 믿고!! big이 대문자 범위 문자코드값으로 가정
		char small = '\0'; // 0; // '0'는 48값으로 사용안됨...
		small = (char)(big + SPC);
		return small;
	}
	// 소문자 하나를 입력받아 대문자로 변경하여 리턴하여 함수
	
	public static char lowerToUpper(char small) {
		// small이 소문자의 범위 문자코드값으로 가정 97~122
		char big = (char)(small - SPC);
		return big;
		
	}

	public static char lowerToUpper2(char small) {
		return (char)(small - SPC);
	}
	
	
	
	

	public static void main(String[] args) {
		
		printCharWithCode('W');
		printCharWithCode(upperToLower('W'));
		char conv = lowerToUpper('k');  // 'k' 저장
		printCharWithCode(conv);
						
		
		
		char c = 65; //'A';
		// 자바 char형 0 ~ 65535 코드값 범위 => 0x0000 ~ 0xFFFF
		final char SPACE = ' '; // ASCII 코드표에서 32번째 글자..
		final char SPACE2 = 32;
		final char SPACE3 = 0x0020; //0x20; // 32 = 16^1*2 + 16^0*0
		final char SPACE4 = 0b0000_0000_0010_0000;
		final char SPACE5 = '\u0020'; // unicode 리터럴 
		
		if('A' > 'B') { // 코드값을 비교
			System.out.println("실행됨!!!");
		} else
			System.out.println("거짓이네요!!!");
		
		if('z' == 'a'+25) // offset
			System.out.println("z참이네요!!!");
		
		if('A' < 'a')  // 대문자들은 소문자들보다 코드표상 앞에 정의...
			System.out.println("A < a 참이네요");
		
		if('A' == 'a'-32)
			System.out.println("A == a 참이네요");
		
//		printCharWithCode((char)('A'+' ')); // 소문자로 변경 
//		printCharWithCode((char)('A'+ SPACE));
//		printCharWithCode((char)('A'+32));
//		
//		printCharWithCode((char)('a'-32));// 대문자로 변경
//		printCharWithCode((char)('a'-SPACE));
		
//		printCharWithCode('가');
//		printCharWithCode((char)('가'+ 1)); // char +  - 연산은 순서번호 코드값 변경을 의미.
//		printCharWithCode((char)('가'+ 2));
//		printCharWithCode((char)('가'+ 3));
//		printCharWithCode((char)('가'+ 4));
		
		
		
		
		
		
		
		
		
		// 텍스트 편집기 (메모장)
		// abcd ABCD 가나다 123123 ~!@#^ ( => text 텍스트 정보)
		// 문자 하나 => 자바(컴퓨터)에서 문자코득밧(수치형데이터)로 표현. 
		// 문자를 직접 표현하거나 처리할 수는 없음. 하지만,
		// 문자에 대응되는 순서 번호값을 부여하여 문자를 처리할 수 있음.
		// A => 1, B => 2, ........., Z => 26
		// 문자형 character type 
		//char c; // 단 하나의 글자 하나만 저장할 메모리 공간 확보.
		// 2바이트, 2byte = 16 bits 65536가지수 표현 == short 비슷
		// 0 ~ 65535까지 문자코드값
		// "abc123" 문자열(String) 리터럴 " 큰따음표.
		// 'a' 문자하나(char) 리터럴 ' 작은따음표.
		// 각 문자들은 모두 현재 선택된 문자셋( character set )에 따라서 표현됨.
		// 자바언어는 char형 문자에 대해서 UTF_16형식으로 처리함.
		// 즉 유니코드(unicode)로 처리함.
		// 다만, 가장 자주 사용되는 즉, 키보드 자판으로 표현되는 문자들은
		// ASCII 아스키 코드셋을 따라 인코딩됨.
//		c = 'A'; // 65 코드값을 표현. 
//		c = 65; // 십진법  코드값  
//		c = 0x41;  // 65 = 16^1 * 4 + 16^0 * 1
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
	
//		printCharWithCode('A');
//		printCharWithCode('a');
//		printCharWithCode('가');
//		printCharWithCode('하');
//		printCharWithCode('z');
//		printCharWithCode('!');
//		printCharWithCode(' ');
//		printCharWithCode('お');
//		printCharWithCode('й');
		
		
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
