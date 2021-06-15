package array.foodcafe;

public class CafeMain3 {

	public static final String NONE = ""; // 공통상수
	
	public static void main(String[] args) {
		// 버거킹, 맥도널드, ... 패스트 푸드 버거집...
		// 다수의 버거이름들 나열
		String strMainMenu[] = {
			"불고기버거", "싸이버거", "라이스버거", "징거버거",
			"빅맥", "와퍼", "새우버거", "치즈버거", "한우버거" 
		}; // 9개의 요소, 배열크기 strMainMenu.lengrh => 9
		   // 0 ~ 8 순서 번호(인덱스)
		// 다 수 버거들의 가격들 나열
		int nMainPrices[] = {
			990, 5000, 6000, 4500,
			4000, 7000, 990, 1500, 8000
		};
		
		// 사이드메뉴들 이름 나열 
		String strSideMenu[] = {
			"감자튀김", "애플파이", "콘샐러드", "코오슬로",
			"치즈스틱", "콜라", "커피", new String("우유"), new String("너겟")
		};
		// "우유" => 문자열 객체, String 타입의 데이터

//		int nSidePrices[] = { // 배열의 선언과 동시에 메모리 활당, 초기화
//			200, 300, 400, 500,
//			600, 700, 800, 900, 1000
//		};
//		int nSidePrices[] = {0,0,0,0,0,0,0,0,0};
		int[] nSidePrices = new int[strSideMenu.length]; // 1차원 배열 공간이 생성
		// 배열 선언과 동시에 메모리 활당 (요소 타입의 기본값으로 자동 초기화!!)
		// int nSidePrices[] = {0,0,0,0,0,0,0,0,0}; 동일
//		double[] dPrices = new double[5]; // 각 요소 값이 0.0 자동초기화
//		char[] cTemp = new char[5]; // 각 요소값이 '/0' 자동초기화
		//String strTemp[] = new String[5]; 
			// 클래스 String 타입의 기본값이 null이므로
			// 5개의 배열 공간에 각각 null로 자동초기화
		//String strTemp[] = { null, null, null, null, null };
 		// 배열 초기화
		for (int i = 0; i < nSidePrices.length; i++) { // 0 ~ 8 
			nSidePrices[i] = 200 + 100*i;
		}
		
		// 이벤트 관리용 배열
		String evMainMenu[] = {
				"", "", "",
				"", "", "",
				"", "", ""
			}; // 메인 메뉴용 이벤트 배열
//		final String NONE =""; // mian 지역상수라서 함수 안에서만 사용가능 
		String [] evSideMenu = {
				NONE, NONE, NONE,
				NONE, NONE, NONE,
				NONE, NONE, NONE
		}; // 사이드 메뉴용 이벤트 배열
		
		
		// 점장이 메뉴를 관리: 이벤트 대상 버거를 선택
		// 불고기 버거 오픈기념 1+1 이벤트 (490원가져가세요)
		nMainPrices[0] = 490;
		evMainMenu[0] = "오픈기념 1+1 이벤트";
		// 7. 치즈버거를 버리고 트리플 치즈와퍼 를 출시 출시기념 1000원 이벤트
		strMainMenu[7] = "트리플지츠와퍼";
		nMainPrices[7] = 1000;
		evMainMenu[7] = "출시기념 6900 -> 1000원 이벤트";
		// 2. 콘샐러드를 리치딥콘샐러드 가격을 100원 활인
		strSideMenu[2] = "리치딥콘샐럴드";
		nSidePrices[2] -= 100;
		evSideMenu[2] = "런칭기념 가격 100원 할인!!";
		
		
		// 출력부
		System.out.println("=== MY CAFE ===");
		printCafeMenu("메인 디쉬", strMainMenu, nMainPrices, evMainMenu);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printCafeMenu("사이드메뉴", strSideMenu, nSidePrices, evSideMenu);
	}
	// 함수 오버로딩 ( Overloading)
	// 이벤트 출력할수 있는 기능이 추가됨..
	private static void printCafeMenu(String subTitle, String[] strMenu, int[] nPrices, String[] evMenu) {
		
		System.out.println("*" + subTitle + ":" + strMenu.length + "개");
		String event = "";//"☜ 왕추천";
		
		for (int i = 0; i < strMenu.length; i++) {
			if(evMenu[i] != NONE) event = "★" + evMenu[i] + "★";
			else event = "☜ 왕추천";
			System.out.printf("menu%02d - %s (%5d원) %s \r\n", i, strMenu[i], nPrices[i], event);
		}
		
	}
	
	private static void printCafeMenu(String subTitle, String[] strMenu, int[] nPrices) {
		
		System.out.println("*" + subTitle + ":" + strMenu.length + "개");
		for (int i = 1; i <= strMenu.length; i++) {
			System.out.printf("menu%02d - %s (%5d원) ☜추천\r\n", i, strMenu[i-1], nPrices[i-1]);
		}
		
	}

}
