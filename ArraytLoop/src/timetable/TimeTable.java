package timetable;

import java.util.Scanner;

/*  텍스트 모드에서는 시간표를 바르게 출력하려면
 *  고정가로폭(fixed-width) 폰트가 필요.. 나눔폰트, sourcecode pro, consol as..

 *** '홍길동'님의 시간표 ***
 ________________________________________
 |시간\요일| 월	 | 화 | 수 | 목 | 금 |
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
 ----------------------------------------
 |시간\요일| 월	 | 화 | 수 | 목 | 금 |
 |  1    |   | 영 |	 | 영 |   |
 |  2    |   | 영 |	 | 영 |   |
 |  3    | 국 |   | 국 |   | 수  |
 |  4    |   |   |	 |   | 수 |
 |  5    |   |   |	 | 음 |   |
 |  6    |   | 과 |	 |   |   |
 |  7    |   |   | 코 | 코  |   |
 ========================================  
 
 */
public class TimeTable {
	
	// 클래스 공통 상수
	// 열번호 요일 상수들......
	public static final int DAY_MON = 0; // 월요일
	public static final int DAY_TUE = 1; // 화요일
	public static final int DAY_WED = 2; // 수요일
	public static final int DAY_THR = 3; // 목요일
	public static final int DAY_FRI = 4; // 금요일
	
	public static final String[] DAY_OF_WEEKS_KR = {
			"월", "화", "수", "목", "금"
	};
	public static final String[] DAY_OF_WEEKS_EN = {
			"Mon", "Tue", "Wed", "Thu", "Fri"
	};
	
	// 과목 상수를 정의
	public static final int SUBJECT_NONE = 0; // 배정과목 없음 상태
	public static final int SUBJECT_KOREAN = 1; // 국어
	public static final int SUBJECT_ENGLISH = 2; // 영어	
	public static final int SUBJECT_MATH = 3; // 수학
	public static final int SUBJECT_DOFING = 4; // 코딩
	public static final int SUBJECT_SCIENCE = 5; // 과학
	public static final int SUBJECT_MUSIC = 6; // 음악
	public static final int SUBJECT_ART = 7; // 미술
	
	public static final String[] SUBJECT_KR = {
		"  ",	"국어", "영어", "수학", "코딩", "과학", "음악", "미술"	
	};
	public static final String[] SUBJECT_EN = {
		"  ",	"KOREAN", "ENGLISH", "MATH", "CODING", "SCIENCE", "MUSIC", "ART"	
	};
	public static final String[] SUBJECT_JP = {
		"  ",	"韓国語", "英語", "数学", "コーディング", "科学", "音楽", "アート"	
	};
	
	public static void main(String[] args) {
		// 7교시 5개요일 가진 7 X 5 2차원 정수배열에 시간표를 표현
		//int[][] timeTable = new int[7][5];
		// 행번호는 교시 번호, 열번호는 월~금 요일이름 대응..
//		int[][] timeTable = {
//			{0, 0, 0, 0, 0}, // 1교시 행 0 ~ 4요일들
//			{0, 0, 0, 0, 0}, // 2교시 행 0 ~ 4요일들
//			{0, 0, 0, 0, 0}, // 3교시 행 0 ~ 4요일들
//			{0, 0, 0, 0, 0}, // 4교시 행 0 ~ 4요일들
//			{0, 0, 0, 0, 0}, // 5교시 행 0 ~ 4요일들
//			{0, 0, 0, 0, 0}, // 6교시 행 0 ~ 4요일들
//			{0, 0, 0, 0, 0}  // 7교시 행 0 ~ 4요일들
//	// 열 	0월 1화 2수 3목 4금 
//		};
		int[][] timeTable = {
				{3, 4, 1, 4, 3}, // 1교시 행 0 ~ 4요일들
				{1, 4, 3, 2, 2}, // 2교시 행 0 ~ 4요일들
				{0, 2, 0, 5, 0}, // 3교시 행 0 ~ 4요일들
				{0, 0, 6, 0, 4}, // 4교시 행 0 ~ 4요일들
				{5, 0, 6, 7, 0}, // 5교시 행 0 ~ 4요일들
				{0, 0, 0, 0, 1}, // 6교시 행 0 ~ 4요일들
				{0, 7, 0, 6, 0}  // 7교시 행 0 ~ 4요일들
		// 열 	0월 1화 2수 3목 4금 
			};
		
		String name = "guest";
		System.out.println(">> 시간표 사용자 이름: ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		
		System.out.printf("*** '%s'님의 시간표 *** \n", name);
		System.out.println("________________________________________"); // 40개의 밑줄문자
		System.out.print("|시간\\요일|"); // 역슬래시 문자 그자체 '\\'
		//System.out.println(" 월 | 화 | 수 | 목 | 금 |");
		// 요일 출력 루프문 
		for (int w = 0; w < DAY_OF_WEEKS_KR.length; w++) {
			System.out.print(" "+DAY_OF_WEEKS_KR[w]+" |");
		}
//		for (int w = 0; w < DAY_OF_WEEKS_EN.length; w++) {
//			System.out.print(" "+DAY_OF_WEEKS_EN[w]+" |");
//		}

		System.out.println();
		System.out.println("----------------------------------------");
		for (int i = 0; i < 7; i++) {  // i교시 0 ~ 6 => 1 ~ 7교시
			System.out.print("| "+ (i+1) +"교시 |");
			for (int j = 0; j < 5; j++) { // j요일 0 ~ 4 => 월 ~ 금
				// 35번 반복... 시간표 칸수..
				System.out.printf(" %s |",SUBJECT_KR[timeTable[i][j]]);
				// 과목 번호에 대한 과목명찾아서 출력
			}
			System.out.println();
		}
		
		System.out.println("========================================");

//		    | 영 |	 | 영 |   |
//		    | 영 |	 | 영 |   |
//			    국 |   | 국 |   | 수  |
//		    |   |	 |   | 수 |
//		    |   |	 | 음 |   |
//		    | 과 |	 |   |   |
//		    |   | 코 | 코  |   |
//		 ========================================  
//		 
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
