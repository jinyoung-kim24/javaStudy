package text;

public class TextMain2 {

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
		} // 2번째 문자 하나 Z [90, 0x5A]
		
		char[] name1 = {}; // length가 0인 빈 배열 empty array
		char[] name2 = {'임', '경', '진'};
//				0번째 문자 하나 임 [51076,0xc784]
//				1번째 문자 하나 경 [44221,0xacbd]
//				2번째 문자 하나 진 [51652,0xc9c4]

		char[] name3 = {51076, 44221, 51652};
		char[] name3b = {0xC784, 0xACBD, 0xC9C4};
		char[] name3c = {0b1100_0111_1000_0100,
				0xACBD, 0xC9C4}; // 8421체계
		char[] name3d = { '\uC784', '\uACBD', '\uC9C4'};
		
 		char nameN1[] = new char[3]; 
 		// char 형 요소 공간이 3개 활당, 그리고 0으로 각 요소공산을 채워줌(자동초기화)
 		char nameN2[] = {'\0', '\0', '\0'};
 		nameN1[0] = '임';
 		nameN1[0] = 0b1100_0111_1000_0100; // 임
 		nameN1[1] = 44221;
 		nameN1[2] = 0xC9C4;
 		
 		nameN2[0] = '\uC784';
 		nameN2[3-2] = 0xACBD;
 		nameN2[3-1] = '진';
 		nameN2[nameN2.length-1] = nameN1[2];
 		
 		
 		
 		// 문자열형 String 클래스 타입 객체 데이터(레퍼런스형 reference)
 		// 레퍼런스형 변수는 데이터값 자체를 가지는게 아니라
 		// 특정 데이터의 위치를 가리키는 주소address값을 저장하고 잇음.
 		// 문자열형도 문자배열처럼 다수개의 글자들을 표현하고 관리.
 		// 문자열형 String형 데이터 => "문자들" literal 표현
 		String kname1 = "이주현"; // 약식으로 문자열 객체를 생성.
 		String kname2 = new String("이주현"); // 정식 객체 생성 및 초기화.
 		char kname[] = {'이', '주', '현'};
 		System.out.println(kname1);
 		System.out.println(kname2);
 		//System.out.println(kname);
 		for (int i = 0; i < kname.length; i++) {
			System.out.printf("한 글자 씩 => %c \n", kname[i]);
		}
 		// length() 함수는 문자열형데이터 객체 의 구성된 유니코드 글자 개수
 		for (int i = 0; i < kname1.length(); i++) {
			char c = kname1.charAt(i); // 문자열형 객체에서 순서대로 포함된 글자 하나를 char형으로 리턴해주는 함수
			System.out.printf("한 글자 씩 => %c \n", kname1.charAt(i));
		}
 		
 		String princess = "Anna 공주"; // 총 7글자 0 ~ 6 순서번호.
 		System.out.printf("%c => %c \n",princess.charAt(0), princess.charAt(6));
 		
 		
 		System.out.printf("%c => %c \n",princess.charAt(0), princess.charAt(princess.length()-1));
 		
 		
 		
 		
 		
 		
	}

}
