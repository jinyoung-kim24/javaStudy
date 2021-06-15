package uility;
// 공통 기능들을 전문 클래스로 분리하여 정의 

import java.util.Scanner;

// 스캐너 관련 기능 함수를 모아둔 유틸리티 클래스 
public class ScanUtil2 {

	// 스캐너로 정수 입력 받아오는 함수
	// ScanUtil.userInputToInt("OOOO"); 호출
	//private static int userInputToInt(String msg) {
	public static int userInputToInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int year = sc.nextInt();
		//sc.close();
		return year;
	}
	
	// 함수 오버로딩 적용
	// 스캐너로 정수 입력 받아오는데 '정상'적인 min ~ max에서만 받아오는 정수입력 함수
	// 경계의 문제를 처리할 수 있는 함수
	public static int userInputToInt(
			String msg, int min, int max) {
		if(min > max) {
			System.out.println("min > max 입력 오류!!!");
			return -99999999;
		}  // 논리적 입력 오류 필터링......
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		while( true ) {
			System.out.println(msg);
			input = sc.nextInt();
			// 정상범위(min이상... max이하)
			if( input >= min && input <= max ) break;
		}
		return input; // min ~ max
	}
}


