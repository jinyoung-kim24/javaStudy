package mulity;

public class switchMain4 {
	// 색상 Colors
	// RGB(Red, Green, Blue, 투명도), RGBA, HSV/HSI, CMYK
	
	private static final int COLOR_RED = 1; // 빨
	private static final int COLOR_ORANGE = 2;
	private static final int COLOR_YELLOW = 3;
	private static final int COLOR_GREEN = 4;
	private static final int COLOR_BLUE = 5;
	private static final int COLOR_NAVY = 6;
	private static final int COLOR_PURPLE = 7; // 보
	private static final String COLOR_NAME_BLACK = "black";
	
	
	public static void printColor(String color) {
		System.out.println("===" + color + "===");
		
	}

	public static void main(String[] args) {
		// 무지개 색 이름 7가지를 랜덤하게 출력하기
		int r = (int)(Math.random()*100) + 1; // 1 ~ 100
		int nColor = (r % 7) + 1; // 0 ~ 6 => 1 ~ 7
		
		String strColor = "컬러없음";
		
		strColor = whichColor(nColor);
		
		
		
	
		
		System.out.printf(
			">> 선택된 색상은 '%s (%d번컬러)'\n", strColor, nColor);
	}
	// 컬러 정수를 입력하면 컬러이름 문자열로 리턴하는 함수
	public static String whichColor(int nColor) {
		
			String strColor;
			switch(nColor) { // case의 순서가 중요!!
			case COLOR_RED:
				strColor = "red"; break; // break를 만나면 case에 상관없이 switch문 종료
						// break를 만나지 않으면 case에 상관없이 switch문 지속실행
			case COLOR_ORANGE:
				strColor = "orange"; break;
			case COLOR_YELLOW:
				strColor = "yellow"; break;
			case COLOR_GREEN:
				strColor = "green"; break;
			case COLOR_BLUE:
				strColor = "blue"; break; // case들이 나눠지는 분기점 break;
			case COLOR_NAVY:
				strColor = "navy"; break;
			case COLOR_PURPLE:
				strColor = "purple"; break;
			default: // if문의 else 블록같은 경우
				strColor = COLOR_NAME_BLACK;
				// break;
			return strColor;
		}
			return strColor;
	}

}
