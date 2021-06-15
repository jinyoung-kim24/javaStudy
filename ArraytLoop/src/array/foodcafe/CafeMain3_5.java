package array.foodcafe;

import java.util.Scanner;

import uility.ScanUtil;

public class CafeMain3_5 {
	
	public static final String NONE = ""; // 공통상수 

	public static void main(String[] args) {
		// 버거킹, 맥도널드, ... 패스트푸드 버거집..
		// 다 수의 버거이름들
		String strMainMenu[] = {
			"불고기버거", "싸이버거", "라이스버거", "징거버거",
			"빅맥", "와퍼", "새우버거", "치즈버거", "한우버거"
		}; 	// 9개 요소, 배열크기  strMainMenu.length => 9
			// 0 ~ 8 순서번호(인덱스)
		// 다 수의 버거들의 가격들
		int nMainPrices[] = {
			990, 5000, 6000, 4500,
			4000, 7000, 990, 1500, 8000
		};
		
		// 사이드메뉴들 이름
		String strSideMenu[] = {
			"감자튀김", "애플파이", "콘샐러드", "코오슬로", 
			"치즈스틱", "콜라", "커피", 
			new String("우유"), new String("너겟")  
		};
		
		int[] nSidePrices = new int[strSideMenu.length]; // 1차원 배열 공간이 생성 new int[strSideMenu.length]; // 1차원 배열 공간이 생성
		// 배열 선언과 동시에 메모리할당(요소 타입의 기본값으로 자동초기화!!)
		// int[] nSidePrices = { 0,0,0,0,0,0,0,0,0 }; 동일
//		double[] dPrices = new double[5]; // 각 요소값이 0.0 자동초기화
//		char[] cTemp = new char[5]; // 각 요소값이 '/0' 자동초기화
//		String strTemp[] = new String[5]; 
			// 클래스 String 타입의 기본값이 null이므로, 
			// 5개의 배열 공간에 각각 null로 자동초기화 
		//String strTemp[] = { null, null, null, null, null }; 
//		String strTemp[] = { "", "", "", "", "" }; 
		// 배열 초기화
		for (int i = 0; i < nSidePrices.length; i++) { //0 ~ 8
			nSidePrices[i] = 200 + 100*i;
		}
		
		// 이벤트 관리용 배열
		String []evMainMenu = { 
				"","","",
				"","","",    
				"","",""
		}; // 메인 메뉴용 이벤트 배열
		//final String NONE = ""; // main() 지역상수라서 함수 안에서만 사용됨.
		String[] evSideMenu = { 
				NONE,NONE,NONE,
				NONE,NONE,NONE,
				NONE,NONE,NONE 
		}; // 사이드 메뉴용 이벤트 배열 
		
		// 점장이 메뉴를 관리: 이벤트 대상 버거를 선택...
		// 0.불고기버거 오픈기념 1+1 이벤트 (490원가져가세요!!)
		nMainPrices[0] = 490;
		evMainMenu[0] = "오픈기념 1+1 이벤트";
		// 7.치즈버거를 버리고 '트리플치즈와퍼'를 출시.. 
		//   출시기념 6900 -> 1000원 이벤트!
		strMainMenu[7] = "트리플치즈와퍼";
		nMainPrices[7] = 1000;
		evMainMenu[7] = "출시기념 6900 -> 1000원 이벤트";
		// 2.콘샐러드를 리치딥콘샐러드... 런칭기념 가격 -100할인! 
		strSideMenu[2] = "리치딥콘샐러드";
		nSidePrices[2] -= 100;
		//nSidePrices[2] = nSidePrices[2] - 100; 
		evSideMenu[2] = "런칭기념 가격 -100할인!";
		
		// 메뉴 출력부
		System.out.println("=== MY CAFE ===");		
		printCafeMenu("메인 디쉬", strMainMenu, 
					nMainPrices, evMainMenu);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printCafeMenu("맛있는 사이드", 
			strSideMenu, nSidePrices, evSideMenu);
		
		// 메뉴 주문부
		// 메인메뉴 1개, 추가적으로 사이드 1~3개... 총 4개이하
		final int NO_SEL = 0; // 주문이 없는 상태
		// menuOrders 주문상태배열(주문받은 음식 번호 기억하는 곳)
		int menuOrders[] = new int[4]; // 0으로 4개 공간 자동초기화
			//{ NO_SEL, NO_SEL, NO_SEL, NO_SEL }; 
			//{ 메인, 사이드, 사이드, 사이드 };
		int order = 0; // 주문회차 카운터 
		// 주문 루프
		Scanner sc = new Scanner(System.in);
		do {			
			// 맨 처음.. 메인 디쉬 한 개 주문 받기 menuOrders[0]에 기억..
//			System.out.print(">> 메뉴을 선택하세요: ");
//			int menu = sc.nextInt();
			int menu = ScanUtil
				.userInputToIntInRange(
			">> 메뉴을 선택하세요: ", 1, strMainMenu.length);
			//menuOrders[0] = menu;
			menuOrders[order] = menu;
			order++;			
			if( order == menuOrders.length ) break;
		} while(true);
		//} while(order == menuOrders.length);
		System.out.println("=== 주문에 감사합니다. ===");
		
		for (int i = 0; i < menuOrders.length; i++) {
			System.out.println("메뉴: " + menuOrders[i]);
		}
	}

	
	// 함수 오버로딩 (Overloading)
	// 이벤트 출력할 수 있는 기능이 추가됨..
	private static void printCafeMenu(
			String subTitle, String[] strMenu, 
			int[] nPrices, String[] evMenu) {
		System.out.println("* "+subTitle+": "
					+ strMenu.length+"개");
		//String event = "";  //"☜ 왕 추천"; 
		
		for (int i = 0; i < strMenu.length; i++) {
			//if(evMenu[i] != "") event = "★ " + evMenu[i] + " ★";
//			if(evMenu[i] != NONE) event = "★ " + evMenu[i] + " ★";
//			else event = "☜ 왕 추천";
			//String event = (evMenu[i] != NONE) ? 
//			String event = !(evMenu[i] == NONE) ?
			//String event = (evMenu[i].isEmpty() == false) ?
			String event = (!evMenu[i].isEmpty()) ?
					"★ " + evMenu[i] + " ★"  :  "☜ 왕 추천"; 
			System.out.printf(
				"menu%02d - %s (%5d원) %s \r\n", i+1, 
				strMenu[i], nPrices[i], event );
		
//			System.out.printf(
//				"menu%02d - %s (%5d원) %s \r\n", i+1, 
//				strMenu[i], nPrices[i], 
//				((evMenu[i] != NONE) ? 
//				"★ " + evMenu[i] + " ★"  :  "☜ 왕 추천") );
			// 삼항식...
		}		
	}	
	
//	private static void printCafeMenu(
//			String subTitle, String[] strMenu, 
//			int[] nPrices, String[] evMenu) {
//		System.out.println("* "+subTitle+": "
//					+ strMenu.length+"개");
//		String event = "";  //"☜ 왕 추천"; 
//		
//		for (int i = 0; i < strMenu.length; i++) {
//			//if(evMenu[i] != "") event = "★ " + evMenu[i] + " ★";
//			if(evMenu[i] != NONE) event = "★ " + evMenu[i] + " ★";
//			else event = "☜ 왕 추천";
//			System.out.printf(
//				"menu%02d - %s (%5d원) %s \r\n", i+1, 
//				strMenu[i], nPrices[i], event );
//		}		
//	}

	
	
	private static void printCafeMenu(
		String subTitle, String[] strMenu, int[] nPrices) {
		System.out.println("* "+subTitle+": "
					+ strMenu.length+"개");
		for (int i = 1; i <= strMenu.length; i++) {
			System.out.printf(
				"menu%02d - %s (%5d원) ☜ 추천 \r\n", i, 
				strMenu[i-1], nPrices[i-1] );
		}		
	}

}

/*
=== MY CAFE ===
* 메인 디쉬: 9개
menu01 - 불고기버거 (  490원) ★ 오픈기념 1+1 이벤트 ★ 
menu02 - 싸이버거 ( 5000원) ☜ 왕 추천 
menu03 - 라이스버거 ( 6000원) ☜ 왕 추천 
menu04 - 징거버거 ( 4500원) ☜ 왕 추천 
menu05 - 빅맥 ( 4000원) ☜ 왕 추천 
menu06 - 와퍼 ( 7000원) ☜ 왕 추천 
menu07 - 새우버거 (  990원) ☜ 왕 추천 
menu08 - 트리플치즈와퍼 ( 1000원) ★ 출시기념 6900 -> 1000원 이벤트 ★ 
menu09 - 한우버거 ( 8000원) ☜ 왕 추천 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 맛있는 사이드: 9개
menu01 - 감자튀김 (  200원) ☜ 왕 추천 
menu02 - 애플파이 (  300원) ☜ 왕 추천 
menu03 - 리치딥콘샐러드 (  300원) ★ 런칭기념 가격 -100할인! ★ 
menu04 - 코오슬로 (  500원) ☜ 왕 추천 
menu05 - 치즈스틱 (  600원) ☜ 왕 추천 
menu06 - 콜라 (  700원) ☜ 왕 추천 
menu07 - 커피 (  800원) ☜ 왕 추천 
menu08 - 우유 (  900원) ☜ 왕 추천 
menu09 - 너겟 ( 1000원) ☜ 왕 추천 
>> 메뉴을 선택하세요: 
4
>> 메뉴을 선택하세요: 
2
>> 메뉴을 선택하세요: 
1
>> 메뉴을 선택하세요: 
8
=== 주문에 감사합니다. ===
메뉴: 4
메뉴: 2
메뉴: 1
메뉴: 8
*/