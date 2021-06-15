package array.foodcafe;

public class CafeMain {

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
		// 배열 초기화
		for (int i = 0; i < nSidePrices.length; i++) { // 0 ~ 8 
			nSidePrices[i] = 200 + 100*i;
		}
		
		// 출력부
		System.out.println("=== MY CAFE ===");
		System.out.println("* 주메뉴: " + strMainMenu.length + "개");
		for (int i = 0; i < strMainMenu.length; i++) {
			System.out.printf("menu%02d - %s (%5d원) ☜추천\r\n", i+1, strMainMenu[i], nMainPrices[i]);
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("* 사이드메뉴: " + strSideMenu.length + "개");
		for (int i = 1; i <= strSideMenu.length; i++) {
			System.out.printf("menu%02d - %s (%5d원) ☜추천\r\n", i, strSideMenu[i-1], nSidePrices[i-1]);
		}
	}

}
