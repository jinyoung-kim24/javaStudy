package text;

public class TextMain {

	public static void main(String[] args) {
		// 텍스트 처리 기본형 => char 문자형 ( 16비트, 2바이트)
		// 글자 한개를 표현, 0 ~ 65535 
		// (UTF-16 유니코드체계 => ASCII 코드 체계)
		// 리터럴 'A' => 해당 코드셋(문자셋)의 순서번호값
		// 렙퍼클래스형 Chracter형..
		char c1 = 'A'; // 65
		Character c2 = 65; // 'A' // new Character('A')
		char c3 = c2.charValue(); // 'A'
		char c4 = 0x0041;
		char c5 = '\u0041';
		char c6 = 0; // '\0' 종료문자 => 기본값
		char c7 = '한';
		char c8 = 'あ';
		
		// 문자 배열 != 문자열 
		// char Array != String
		// 다 수개의 글자들 == 문자들의 집합? == 문자배열구조
		char[] cArr1 = { 'X', 'Y', 'Z'}; 
		// 글자 3개 , 배열길이 =3, 순서번호 0 ~ 2(length -1)
		// 한번 생성 정의된 배열의 크기
		// 즉 length는 이후 절대 변경 불가능 즉 상수임.
		char a = cArr1[2]; // 'Z', // 90
		char z = cArr1[cArr1.length-1]; // 마지막 인덱스 last index
		
		for (int i = 0; i < cArr1.length; i++) {
			char cz = cArr1[i];
			System.out.printf("%d번째 문자 하나 %c [%d,0x%x]\n",i, cz, (int)cz, (int)cArr1[i]);
		}
		
		
		
	}

}
