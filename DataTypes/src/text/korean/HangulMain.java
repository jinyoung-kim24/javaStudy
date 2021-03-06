package text.korean;

import text.UnicodeMain;
/*
 * 도스창 콘솔 실행
 *  
 *   cd, dir, cd .., type, cls, java 콘솔 명령 실행

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain > hangul.txt

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain > 한글코드.txt

 */
public class HangulMain {

	public static void main(String[] args) {
		final char hSTART = '가'; // 문자상수
		final char hEND = '힣'; // 0xD7A3
		char hangul = hSTART;// '가'; // 0xAC00 == ?
		
		// 한글 문자 총개수
		//final int TOTAL_HANGULS = 0xD7A3 - 0xAC00 + 1; 
		final int TOTAL_HANGULS = '힣' - '가' + 1; // 11172개
		// '가' => 1번째 문자, '힣' => 11172번째 문자
		
		boolean flag = true;
		int order = 0; // 카운터변수 초기화 (루프를 진행하면서 변화되는 기준)
		while(flag == true) { // 반복구간 루프 시작
			//order = order + 1;
			order++; // 순서 변화..
			System.out.printf("order %d: ", order );
//			System.out.printf(" => %c (%d, 0x%X) \n",
//						hangul, (int)hangul, (int)hangul);
			UnicodeMain.printCharWithCode(hangul);
			// public으로 되어있는 다른 클래스의 함수는 이제 불러서 사용이 가능함.
			
			// 루프 종료 조건 
			if( order == TOTAL_HANGULS ) flag = false;
			hangul = (char) (hangul + 1);
//			if( hangul == hEND ) flag = false; // '힣'??? 생각꺼리!!
		} // 반복구간 루프 끝
		System.out.println("유니코드 한글 출력 loop 종료!!!");
	}

}
