package mulity;

public class switchMain2 {
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

	public static void main(String[] args) {
		// 무지개 색 이름 7가지를 랜덤하게 출력하기
		int r = (int)(Math.random()*100) + 1; // 1 ~ 100
		int nColor = (r % 7) + 1; // 0 ~ 6 => 1 ~ 7
		
		String strColor = "컬러없음";
		
		// switch ~case 다중분기문
		switch(nColor) { // case의 순서가 중요!!
		case COLOR_RED:
			strColor = "red";
			break;
		case COLOR_ORANGE:
			strColor = "orange";
			break;
		case COLOR_YELLOW:
			strColor = "yellow";
			break;
		case COLOR_GREEN:
			strColor = "green";
			break;
		case COLOR_BLUE:
			strColor = "blue";
			break;
		case COLOR_NAVY:
			strColor = "navy";
			break;
		case COLOR_PURPLE:
			strColor = "purple";
			break;
		default: // if문의 else 블록같은 경우
			strColor = COLOR_NAME_BLACK;
			// break;
				
		}
		
		
		
		// if ~ else if/ else 다중분기문 
//		// if 다중분기문
//		//if(nColor == 1) 
//		if(nColor == COLOR_RED)		
//			strColor = "red"; // 0xFF0000
//		//else if(nColor != 1 && nColor == 2)
//		else if(nColor == COLOR_ORANGE)
//			strColor = "orange";
//		else if(nColor == COLOR_YELLOW)
//			strColor = "yellow";
//		else if(nColor == COLOR_GREEN)
//			strColor = "green";
//		else if(nColor == COLOR_BLUE)
//			strColor = "blue";
//		else if(nColor == COLOR_NAVY)
//			strColor = "navy";
//		else if(nColor == COLOR_PURPLE)
//			strColor = "purple";
//		else // 앞썬 7개의 모든 조건이 모두 false로 판결이 나면 최종 else로 감.
//			strColor = COLOR_NAME_BLACK; //"black";
		
		System.out.printf(
			">> 선택된 색상은 '%s (%d번컬러)'\n", strColor, nColor);
	}

}
