package text;

/*
문자 가 => 코드값 44032 [0xAC00] 
문자 힣 => 코드값 55203 [0xD7A3] 
문자 お => 코드값 12362 [0x304A] 
>> 유니코드 총 한글문자수: 11172개
바는 한글 맞아요!
문자 바 => 코드값 48148 [0xBC14] 
폾는 한글 맞아요!
문자 폾 => 코드값 54270 [0xD3FE] 
X는 한글 아닙니다..!
お는 한글 아닙니다..!
 
 */

public class UnicodeMain {

	// 문자 하나를 입력받아서 한글인지 아니닌를 체크하여 리턴하는 함수
	public static boolean isKorean(char c) {
		boolean answer;// = false;
		// 한글이라면... 
		// 문자코드값이 유니코드 한글 '가'에서 '힣' 범위에 있으면 한글문자임.
		if( c >= '가' && c <= '힣' )  answer = true;
		//if( c >= 0xAC00 && c <= 0xD7A3 )  answer = true;
		//if( c >= '\uAC00' && c <= '\uD7A3' )  answer = true;
//		if( c >= 44032 && c <= 55203 )  answer = true;
		else answer = false;
		
		return answer;
	}
	
	public static boolean isKorean2(char c) {
		if( c >= '가' && c <= '힣' ) return  true;
		else return false;		
	}
//	
//	public static boolean isKorean3(char c) {
//		return c >= '가' && c <= '힣';		
//	}
	
	public static void main(String[] args) {
//		printCharWithCode('한');
//		printCharWithCode('글');
		// 문자 한 => 코드값 54620 [0xD55C] 
		// 문자 글 => 코드값 44544 [0xAE00]
//		char c1 = '한', c2 = '글';
//		printCharWithCode(c1);
		printCharWithCode('가'); // 문자 가 => 코드값 44032 [0xAC00]
		printCharWithCode('힣'); // 문자 힣 => 코드값 55203 [0xD7A3] 
		printCharWithCode('お'); // 코드값 12362 [0x304A] 
		
		System.out.println(">> 유니코드 총 한글문자수: "
					+ ('힣'-'가'+1) + "개");		
		
		boolean b = isKorean('바');
		if( b == true ) {
			System.out.println('바'+"는 한글 맞아요!");
			printCharWithCode('바');
		}
		boolean b2 = isKorean('폾');
		if( b2 == true ) {
			System.out.println('폾'+"는 한글 맞아요!"); 
			printCharWithCode('폾');
		}
		
		if( isKorean('X') == true ) {
			System.out.println('X'+"는 한글 맞아요!"); 
			printCharWithCode('X');
		} else
			System.out.println('X'+"는 한글 아닙니다..!");
		
		if( isKorean('お') == true ) {
			System.out.println('お'+"는 한글 맞아요!"); 
			printCharWithCode('お');
		} else
			System.out.println('お'+"는 한글 아닙니다..!");	
		
		// 유니코드 unicode.org 
		// '가' ~ '힣'
		// 0xAC00 ~ 0xD7A3
		// http://www.unicode.org/charts/PDF/UAC00.pdf
		// https://www.unicode.org/versions/Unicode13.0.0/ch18.pdf
	}
	
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
	
	
	public static void printCharWithCode(char c) {
		if( c == 0 )  //'\0'
			return;
		System.out.printf("문자 %c => 코드값 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}

}
