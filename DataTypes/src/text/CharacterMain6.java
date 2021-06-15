package text;

/*
1번 구간 => A 
2번 구간 => B 
3번 구간 => C 
4번 구간 => D 
5번 구간 => E 
6번 구간 => F 
7번 구간 => G 
8번 구간 => H 
9번 구간 => I 
10번 구간 => J 
11번 구간 => K 
12번 구간 => L 
13번 구간 => M 
14번 구간 => N 
15번 구간 => O 
16번 구간 => P 
17번 구간 => Q 
18번 구간 => R 
19번 구간 => S 
20번 구간 => T 
21번 구간 => U 
22번 구간 => V 
23번 구간 => W 
24번 구간 => X 
25번 구간 => Y 
26번 구간 => Z 
문자 출력 loop 종료!!! 
 */

public class CharacterMain6 {

	// 공용상수
	public static final char SPC = ' ';
	
	// 대문자 하나를 입력받아 소문자로 변경하여 리턴하는 함수
	public static char upperToLower(char big) {
		// big 정상범위 입력으로 믿고!!! 
		// big이 대문자의 범위 문자코드값으로 가정.
		char small = 0; // '\0'; //0;
				// '0'는 48값으로 사용안됨..
		small = (char)(big + SPC);
		return small;
	}
	
	// 소문자 하나를 입력받아 대문자로 변경하여 리턴하는 함수 
	public static char lowerToUpper(char small) {
		// small이 소문자의 범위 문자코드값으로 가정. 97~122
		char big = (char)(small - SPC); //'\0';
		return big;
	}
	
	public static char lowerToUpper2(char small) {		
		return (char)(small - SPC);
	}
	
	// 토글함수 구현 
	// 문자 하나를 입력받아 해당 문자가 영문대문자라면 소문자로 변경하여 리턴하고, 
	// 만약 해당 문자가 영문소문자라면 대문자로 변경하여 리턴하는 함수
	public static char toggleCase(char c) {
		char convC = '\0'; // 종료문자
		// 영문 대문자라면 => 문자코드값이 문자셋에서 대문자의 범위에 있으면..
		//if( c >= 65 && c <= 65+25 )
		if( c >= 65 && c <= 90 ) // 대문자 판정
			convC = (char)(c + SPC); // 대 => 소
		if( c >= 97 && c <= 122 ) // 소문자 범위 판정 97+25)	
			convC = (char)(c - SPC); // 소 => 대
		return convC;		
	}
	
	public static char toggleCase2(char c) {
		char convC = '\0';
		if( c >= 65 && c <= 90 ) // 영문 대문자 판정
			convC = (char)(c + SPC); // 대 => 소
		else if( c >= 97 && c <= 122 ) // 영문 소문자 범위 판정 97+25)	
			convC = (char)(c - SPC); // 소 => 대
		else 
			System.out.println(">> '"+c+"' 는 영문 대소문자가 아닙니다!");
		return convC;		
	}
	public static final char ERROR_CHAR = 0;// '\0';
	public static char toggleCase3(char c) {		
		if( c >= 'A' && c <= 'Z' ) // 'A'+25 )
			return (char)(c + SPC); // 대 => 소
		else if( c >= 'a' && c <= 'z' ) 	
			return (char)(c - SPC); // 소 => 대
		else {
			System.out.println(">> '"+c+"' 는 영문 대소문자가 아닙니다!");
			return ERROR_CHAR;
		}
	}
	
	public static char toggleCase4(char c) {		
		if( c >= 'A' && c <= 'Z' ) // 'A'+25 )
			return upperToLower(c); // 대 => 소
		else if( c >= 'a' && c <= 'z' ) {
			char t = lowerToUpper(c);
			return t; // 소 => 대
		} else {
			System.out.println(">> '"+c+"' 는 영문 대소문자가 아닙니다!");
			return ERROR_CHAR;
		}
	}
	
	
	public static void main(String[] args) {
		
//		printCharWithCode(upperToLower('A'));
//		printCharWithCode(lowerToUpper('z'));
//		printCharWithCode(upperToLower('다')); // '댄'
		// toggle 두가지 상태를 왔다갔다 스위칭..
		printCharWithCode(toggleCase4('A'));
		printCharWithCode(toggleCase4('z'));
		printCharWithCode(toggleCase4('F'));
		printCharWithCode(toggleCase4('p'));
		printCharWithCode(toggleCase4(toggleCase4('p')));
		printCharWithCode(toggleCase4('다'));
		printCharWithCode(toggleCase4('5'));
		printCharWithCode(toggleCase4(' '));
		printCharWithCode(toggleCase4('$'));
		printCharWithCode(toggleCase4('?'));
		
//		
//		
//		
//		boolean flag = true;
//		char start = 'a';//'A';
//		int count = 0; // 카운터 변수 정의 (빈도수, 진행 도수의 누적합)
//		final int ALPHABETS = 26;
//		while(flag == true) { // 반복 시작	(책 119페이지)	
////			count++; // 자신의 값을 1씩 증가시킴; 
////			System.out.printf("%d번 구간 => %c \n", count, 
////					(char)(start + count - 1));			
////			System.out.printf("%d번 구간 => %c \n", count+1, 
////					(char)(start + count));
//			char conv = (char)(start + count);
////			if( conv == 'k' ) // == 107 ) k이면 대문자로 변경!!
////				conv = lowerToUpper(conv);
////			if( conv == 'q' ) // q라면 대문자로 변경!!
////				conv = lowerToUpper(conv);
//			if( conv == 'k' || conv == 'q' ) // or
//				conv = lowerToUpper(conv);
//			System.out.printf("%d번 구간 => %c \n", count+1, 
//					conv);
//			count++; // 자신의 값을 1씩 증가시킴; 
//			//start = (char)(start + 1);
//			if( count == ALPHABETS ) flag = false; // 종료조건
//		} // 반복 끝 loop
//		System.out.println(start + "부터 26자 문자 출력 loop 종료!!!");
//		
	}

	/*
1번 구간 => a 
2번 구간 => b 
3번 구간 => c 
4번 구간 => d 
5번 구간 => e 
6번 구간 => f 
7번 구간 => g 
8번 구간 => h 
9번 구간 => i 
10번 구간 => j 
11번 구간 => k 
12번 구간 => l 
13번 구간 => m 
14번 구간 => n 
15번 구간 => o 
16번 구간 => p 
17번 구간 => q 
18번 구간 => r 
19번 구간 => s 
20번 구간 => t 
21번 구간 => u 
22번 구간 => v 
23번 구간 => w 
24번 구간 => x 
25번 구간 => y 
26번 구간 => z 
a부터 26자 문자 출력 loop 종료!!!
 
	 */
	
//	public static void main(String[] args) {
//		
//		printCharWithCode('W');
//		printCharWithCode(upperToLower('W'));
//		char conv = lowerToUpper('k'); // 'K' 저장
//		printCharWithCode(conv);
//
//		char c = 65;// 'A'; 
//		// 자바 char형 0 ~ 65535 코드값 범위 => 0x0000 ~ 0xFFFF		
//		final char SPACE = ' '; // ASCII 코드표에서 32번째 글자..
//		final char SPACE2 = 32;
//		final char SPACE3 = 0x0020; // 0x20;// 32 = 16^1*2 + 16^0*0
//		final char SPACE4 = 0b0000_0000_0010_0000;
//		final char SPACE5 = '\u0020'; // unicode 리터럴
//		
//		//if( 'A' == 'B' ) {
////		if( 'A' != 'B' ) { // 코드값을 비교
//		//if( 'A'+1 == 'B' ) { // 64 + 1 == 65
//		if( 'A'  > 'B' ) {
//			System.out.println("실행됨!!!");
//		} else 
//			System.out.println("거짓이네요!!!!");
//		
//		if( 'z' == 'a' + 25 ) // offset
//			System.out.println("z 참이네요."); 
//		
//		if( 'A' < 'a' ) // 대문자들은 소문자들보다 코드표상 앞에 정의..
//			System.out.println("A < a 참이네요.");
//		
//		if( 'A' == 'a'-32 )
//			System.out.println("A == a-32 참이네요.");
//		if( 'A'+32 == 'a' )
//			System.out.println("A+32 == a 참이네요.");
//		
//		if( 'A'+SPACE == 'a' )
//			System.out.println("A+SPACE == a 참이네요.");
//		
////		printCharWithCode((char)('A'+32)); // 소문자로 변경
////		printCharWithCode((char)('A'+' ')); // 소문자로 변경
////		printCharWithCode((char)('A'+SPACE)); // 소문자로 변경
////		
////		printCharWithCode((char)('j'-SPACE)); // 대문자로 변경
////		printCharWithCode((char)('y'-SPACE)); // 대문자로 변경
//		
//		
////		printCharWithCode('가');		
////		printCharWithCode((char)('가'+1)); // char + - 연산은 순서번호 코드값 변경을 의미.
////		printCharWithCode((char)('가'+2)); // '가' 다다음 글자?
////		printCharWithCode((char)('가'+3));
////		printCharWithCode((char)('가'+4));
//		
//		
//		
//		
//		
//		// 텍스트 편집기 (메모장)
//		// abcd ABCD 가나다 1232213^&*#!#*( => text 텍스트 정보
//		// 문자 하나 => 자바(컴퓨터)에서 문자코드값(수치형데이터)로 표현.
//		// 문자를 직접 표현하거나 처리할 수는 없음. 하지만, 
//		// 문자에 대응되는 순서번호값을 부여하여 문자를 처리할 수 있음.
//		// A => 1, B => 2, ..... , Z => 26
//		// 문자형 character type
////		char c; // 단 하나의 글자 하나만 저장할 메모리 공간 확보.
//		// 2바이트, 2 bytes = 16 bits = 65536가지수 표현 == short 비슷
//		// 0 ~ 65535까지 문자코드값
//		// "abc123" 문자열(String) 리터럴 " 큰따옴표.
//		// 'a' 문자하나(char) 리터럴 ' 작은따옴표.
//		// 각 문자들은 모두 현재 선택된 문자세트(character set)에 따라서 표현됨.
//		// 자바언어는 char형 문자에 대해서 UTF-16형식으로 처리함.
//		// 즉, 유니코드(unicode)로 처리함.
//		// 다만, 가장 자주 사용되는 즉, 키보드 자판으로 표현되는 문자들은 
//		// ASCII 아스키 코드셋을 따라 인코딩됨.
//		// https://ko.wikipedia.org/wiki/ASCII
//		
////		c = 'A'; // 65 코드값을 표현.
////		c = 65; // 십진법 코드값 
////		c = 0x41; // 65 = 16^1 * 4 + 16^0 * 1
////		char c2 = 'B';// 66;
////		char c3 = 66;
////		char c4 = 65 + 1; // 코드값을 수치형으로보고 +거나 -면 순서가 변경.
////		char c5 = 'A' + 1;
////		
////		char d = 'a'; // 97, 0x61  아스키코드셋 문자표에서 찾아보기!!!
////		char e = '0'; // 48 숫자문자... 외우세요. 
////		char space = ' '; // 32 => 0x20 공백문자 스페이스 
////		String strEmpty = ""; // 문자열형의 빈문자열.
//		
////		System.out.println('A'); // 아스키코드 영문대문자
////		System.out.println('가'); // 한글 유니코드문자
////		System.out.println('\t'); // 특수문자 \n, \b, \r
//		
//		// %c는 문자하나를 폰트로 출력하는 서식자
//		// d != java.lang.Character 에러...
////		System.out.printf("문자 %c => 코드값 %d \n", 'A', (int)'A');
////		System.out.printf("문자 %c => 코드값 %d \n", 'a', (int)'a');
////		System.out.printf("문자 %c => 코드값 %d \n", '가', (int)'가');
////		System.out.printf("문자 %c => 코드값 %d \n", c5, (int)c5); // 'B');
////		System.out.printf("문자 %c => 코드값 %d \n", e, (int)e); // '0');
////		System.out.printf("문자 %c => 코드값 %d \n", space, (int)space); // ' ');
//		
////		printCharWithCode('A');
////		printCharWithCode('a');
////		printCharWithCode('가');
////		printCharWithCode('하');
////		printCharWithCode('z');
////		printCharWithCode('!');
////		printCharWithCode(' ');
////		printCharWithCode('お');
////		printCharWithCode('й');
//		
//		
////		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
////							'A', (int)'A', (int)'A'); // 십진법, 16진법 코드값들..
////		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
////							'a', (int)'a', (int)'a'); // (int)97
////		System.out.printf("문자 %c => 코드값 %d [0x%X] \n",
////							'가', (int)'가', (int)'가');
////		System.out.printf("문자 %c => 코드값 %d [0x%X] \n",
////							c5, (int)c5, (int)c5); // 'B');
////		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
////							e, (int)e, (int)e); // '0');
////		System.out.printf("문자 %c => 코드값 %d [0x%X] \n",
////							space, (int)space, (int)space); // ' ');
//		/*
// 			문자 A => 코드값 65 [0x41] 
//			문자 a => 코드값 97 [0x61] 
//			문자 가 => 코드값 44032 [0xAC00] 
//			문자 B => 코드값 66 [0x42] 
//			문자 0 => 코드값 48 [0x30] 
//			문자   => 코드값 32 [0x20] 
//		 */
//	}

	private static void printCharWithCode(char c) {
		if( c == 0 )  //'\0'
			return;
		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}
	
	
//	private static void printCharWithCode(char c) {
//		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
//				c, (int)c, (int)c); 
//	}

}
/*
문자 A => 코드값 65 
문자 a => 코드값 97 
문자 가 => 코드값 44032 
문자 B => 코드값 66 
문자 0 => 코드값 48 
문자   => 코드값 32  
*/
