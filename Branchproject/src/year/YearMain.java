package year;

// 윤년 판단...
// Leap year
/*
https://ko.wikipedia.org/wiki/%EC%9C%A4%EB%85%84
 
 윤년 판단 알고리즘 Algorithm
 
그레고리력의 정확한 윤년 규칙은 다음과 같다.

서력 기원 연수가 004로 나누어 떨어지는 해는 윤년으로 한다. (1984년, 1988년, 1992년, 1996년, 2004년, 2008년, 2012년, 2016년, 2020년, 2024년, 2028년, 2032년, 2036년, 2040년, 2044년 ...)
서력 기원 연수가 004, 100으로 나누어 떨어지는 해는 평년으로 한다. (1900년, 2100년, 2200년, 2300년, 2500년...)
서력 기원 연수가 004, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다. (2000년, 2400년...)

*/

public class YearMain {
	
	public static final String NONAME = ""; // empty string 빈문자열
	public static final String LEAP_YEAR = "윤년";
	public static final String COMMON_YEAR = "평년";
	
	public static void main(String[] args) {
		// 윤년 판단 프로그램
		// 준비, 입력 등
		int year = 2100; //2021;
		String yearName = NONAME;
		
		// 실행 (윤년 판단 등)
		
		yearName = whichYear(year);
		
		//서력 기원 연수가 004로 '나누어 떨어지는' 해는 윤년으로 한다. => 약수, 배수... 공약수...
//		if( year % 4 == 0 ) {
//			yearName = LEAP_YEAR;
//			// 서력 기원 연수가 004,(and) 100으로 나누어 떨어지는 해는 평년으로 한다.
//			if( year % 100 == 0 ) { 
//				yearName = COMMON_YEAR;
//				// 서력 기원 연수가 004, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다.
//				if( year % 400 == 0 ) yearName = LEAP_YEAR;
//				else yearName = COMMON_YEAR;
//			}
//			else yearName = LEAP_YEAR;
//		} else {
//			yearName = COMMON_YEAR;
//		}
		
		// 출력
		System.out.printf(
				">> 해당 %4d년도는 '%s' 입니다.\n", 
				year, yearName );
	}

	// 정수형 년도를 입력받아 윤년알고리즘 판단 후 
	// 문자열형 "윤년" 혹은 "평년"으로 리턴하는 함수
	private static String whichYear(int year) {
		String yearName = NONAME;
		
		if( year % 4 == 0 ) {
			yearName = LEAP_YEAR;
			// 서력 기원 연수가 004,(and) 100으로 나누어 떨어지는 해는 평년으로 한다.
			if( year % 100 == 0 ) { 
				yearName = COMMON_YEAR;
				// 서력 기원 연수가 004, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다.
				if( year % 400 == 0 ) yearName = LEAP_YEAR;
				else yearName = COMMON_YEAR;
			}
			else yearName = LEAP_YEAR;
		} else {
			yearName = COMMON_YEAR;
		}
		
		return yearName;
	}

}




