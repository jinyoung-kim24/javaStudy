package timetable;

import java.util.Scanner;

import uility.ScanUtil;

/*  텍스트 모드에서는 시간표를 바르게 출력하려면
 *  고정가로폭(fixed-width) 폰트가 필요.. 나눔폰트, sourcecode pro, consol as..

 *** '홍길동'님의 시간표 ***
 ________________________________________
 |시간\요일| 월	 | 화 | 수 | 목 | 금 |
 ----------------------------------------
 |  1    |   |   |	 |   |   |
 |  2    |   |   |	 |   |   |
 |  3    |   |   |	 |   |   |
 |  4    |   |   |	 |   |   |
 |  5    |   |   |	 |   |   |
 |  6    |   |   |	 |   |   |
 |  7    |   |   |	 |   |   |
 ========================================
 
  과목을 요일과 시간에 할당....
  
*** '홍길동'님의 시간표 ***
 ________________________________________
 |시간\요일| 월	 | 화 | 수 | 목 | 금 |
 ----------------------------------------
 |  1    |   | 영 |	 |   |   |
 |  2    |   | 영 |	 | 영 |   |
 |  3    | 미 |   | 국 |   | 수  |
 |  4    |   |   |	 |   | 수 |
 |  5    | 미 |   |	 | 음 |   |
 |  6    |   | 과 |	 |   |   |
 |  7    |   |   | 코 | 코  |   |
 ========================================  
 
 */
public class TimeTable2 {

	// 클래스 공통 상수
	// 열번호 요일 상수들....
	public static final int DAY_MON = 0; //월요일
	public static final int DAY_TUE = 1; //화요일
	public static final int DAY_WED = 2; //수요일
	public static final int DAY_THR = 3; //목요일
	public static final int DAY_FRI = 4; //금요일
		
	public static final String[] DAY_OF_WEEKS_KR = {
		"월", "화", "수", "목", "금"	
	};
	public static final String[] DAY_OF_WEEKS_EN = {
		"Mon", "Tue", "Wed", "Thu", "Fri"	
	};
	
	// 과목 상수들 정의
	public static final int SUBJECT_NONE = 0; // 배정과목 없음 상태
	public static final int SUBJECT_KOREAN = 1; // 국어
	public static final int SUBJECT_ENGLISH = 2; // 영어
	public static final int SUBJECT_MATH = 3; // 수학
	public static final int SUBJECT_CODING = 4; // 코딩
	public static final int SUBJECT_SCIENCE = 5; // 과학
	public static final int SUBJECT_MUSIC = 6; // 음악
	public static final int SUBJECT_ART = 7; // 미술
	
	public static final String[] SUBJECTS_KR = {
		"    ", "국어", "영어", "수학", "코딩", "과학", "음악", "미술"
	};
	
	public static final String[] SUBJECTS_EN = {
		"    ", "KOREAN", "ENGLISH", "MATH", "CODING",
		"SCIENCE", "MUSIC", "ART"
	};
	
	public static final String[] SUBJECTS_JP = {
		"    ", "韓国語", "英語", "数学", "コーディング"  
		, "科学", "音楽", "アート"
	};
	
	
	public static void main(String[] args) {
		// 7교시... 5개요일.. 가진 7 x 5 2차원 정수배열에 시간표를 표현.
		//int[][] timeTable = new int[7][5];
		// 행번호는 교시번호, 열번호는 월~금 요일이름 대응..
		int[][] timeTable = {
			{0, 0, 0, 0, 0},  // 1교시 행; 0 ~ 4 요일들...	
			{0, 0, 0, 0, 0},  // 2교시 행; 0 ~ 4 요일들...	
			{0, 0, 0, 0, 0},  // 3교시 행; 0 ~ 4 요일들...
			{0, 0, 0, 0, 0},  // 4교시 행; 0 ~ 4 요일들...
			{0, 0, 0, 0, 0},  // 5교시 행; 0 ~ 4 요일들...
			{0, 0, 0, 0, 0},  // 6교시 행; 0 ~ 4 요일들...
			{0, 0, 0, 0, 0}   // 7교시 행; 0 ~ 4 요일들...
			// 열        0월 1화 2수  3목 4금	
		};
		
		String name = ScanUtil.userInputToString(">> 시간표 사용자 이름: ");
		
		// 시간표에 사용자의 고유 과목을 활당 처리 (요일, 교시, 과목명 입력)
		int yoil = ScanUtil
				.userInputToIntInRange(">> 요일을 선택(0월 ~ 04금):", DAY_MON, DAY_FRI);
		int gyosi = ScanUtil
				.userInputToIntInRange(">> 교시선택( 1 ~ 7교시 ): ", 1, 7);
		int gwamok = ScanUtil
				.userInputToIntInRange(">> 과목선택( 국어1 ~ 미술7 ):", SUBJECT_KOREAN, SUBJECT_ART);
		System.out.println("\n" + name + "님이" + SUBJECTS_KR[gwamok] + 
				"과목을 시간표에" + DAY_OF_WEEKS_KR[yoil] + "요일" + gyosi + "교시에 추가 합니다.");
		
		// 실행부(처리부)... ( 교시입력과 요일 입력으로 결정된 시간표 칸에 과목번호 활당)
		timeTable[gyosi-1][yoil] = gwamok;
		
		System.out.printf("*** '%s'님의 시간표 ***\n", name);		
		System.out.println(lineDraw("~~@~~", 6)); // 40개의 밑줄문자 출력
		System.out.print("|시간\\요일|"); // 역슬래시 문자 그자체 '\\'
		//System.out.println(" 월 | 화 | 수 | 목 | 금 |");
		// 요일 출력 루프문
		for (int w = 0; w < DAY_OF_WEEKS_KR.length; w++) {
			System.out.print("  "+DAY_OF_WEEKS_KR[w]+" |");
		}
//		for (int w = 0; w < DAY_OF_WEEKS_EN.length; w++) {
//			System.out.print(" "+DAY_OF_WEEKS_EN[w]+" |");
//		}
		System.out.println();
		System.out.println(lineDraw("----", 10));
		
		for (int i = 0; i < timeTable.length; i++) { // i교시 0~6 => 1~7
			System.out.print("|  "+(i+1)+"교시  |");
			for (int j = 0; j < DAY_OF_WEEKS_KR.length; j++) { // j요일 0~4 => 월~금
				// 35번 반복... 시간표 칸수..				
				//System.out.printf(" %s |", timeTable[i][j]); 
				System.out.printf(" %s |", 
						SUBJECTS_KR[timeTable[i][j]] );
						//SUBJECTS_JP[timeTable[i][j]] );
				// 과목 번호에 대한 과목명찾아서 출력
			}
			System.out.println();
		}
//		 |  1교시  |   | 영 |	 |   |   |
//		 |  2교시  |   | 영 |	 | 영 |   |
//		 |  3교시  | 미 |   | 국 |   | 수  |
//		 |  4교시  |   |   |	 |   | 수 |
//		 |  5교시  | 미 |   |	 | 음 |   |
//		 |  6교시  |   | 과 |	 |   |   |
//		 |  7교시  |   |   | 코 | 코  |   |
		//System.out.println("========================================"); 
		System.out.println(lineDraw("=", 40)); 
	}
	public static String lineDraw(String patten, int length) {
		String line = "";
		for (int i = 0; i < length; i++) {
			line += patten;
		}
		return line;
	}
	
	
}


/*
>> 시간표 사용자 이름: 안나
*** '안나'님의 시간표 ***
________________________________________
|시간\요일| 월 | 화 | 수 | 목 | 금 |
----------------------------------------
|  1교시  
|  2교시  
|  3교시  
|  4교시  
|  5교시  
|  6교시  
|  7교시  
======================================== 
 */

/*
>> 시간표 사용자 이름: 동현
*** '동현'님의 시간표 ***
________________________________________
|시간\요일| 월 | 화 | 수 | 목 | 금 |
----------------------------------------
|  1교시  | 3 | 4 | 1 | 4 | 3 |
|  2교시  | 1 | 4 | 3 | 2 | 2 |
|  3교시  | 0 | 2 | 0 | 5 | 0 |
|  4교시  | 0 | 0 | 6 | 0 | 4 |
|  5교시  | 5 | 0 | 6 | 7 | 0 |
|  6교시  | 0 | 0 | 0 | 0 | 1 |
|  7교시  | 0 | 7 | 0 | 6 | 0 |
========================================
 
 
 >> 시간표 사용자 이름: Elsa
*** 'Elsa'님의 시간표 ***
________________________________________
|시간\요일| 월 | 화 | 수 | 목 | 금 |
----------------------------------------
|  1교시  | MATH | CODING | KOREAN | CODING | MATH |
|  2교시  | KOREAN | CODING | MATH | ENGLISH | ENGLISH |
|  3교시  |   | ENGLISH |   | SCIENCE |   |
|  4교시  |   |   | MUSIC |   | CODING |
|  5교시  | SCIENCE |   | MUSIC | ART |   |
|  6교시  |   |   |   |   | KOREAN |
|  7교시  |   | ART |   | MUSIC |   |
========================================

 */


