package mulity;

public class switchMain7 {
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

	
	
	// html로 출력을 보여주기위한 함수 추가 
	public static void printHTMLStart(String title) {
		final String HTML_START 
			= "<!DOCTYPE html>"
			+ "<html>"
				+ "<head>"
				+ "<meta charset='EUC-KR' />"
					//+ "<title> 무지개 출력 1 </title>"
					+ "<title> " + title + " </title>"
							+ "<style>"
							+ "	div	{"
							+ "		border:1px solid black;"
							+ "		width: 25%;"
							+ "		margin: 10px;"
							+ "	}"
							+ "</style>"
				+ "</head>"
				+ "<body>"
					+ "<h1>" + title + "</h1>"
					+ "<hr>";
		System.out.println(HTML_START);				
	}
	
	public static void printHTMLEnd() {
		final String HTML_END = 
				  "</body>"
			+ "</html>";
		System.out.println(HTML_END);
	}
	
	
	
	public static void printColor(String color) {
		System.out.println(" === " + color + " === ");
	}
	
	public static void main(String[] args) {
		printHTMLStart("무지개 띠 출력 4");
		
		// 무지개 색 이름 7가지를 랜덤하게 출력하기
		int r = (int)(Math.random()*100) + 1; // 1 ~ 100
		int nColor = (r % 7) + 1; // 0 ~ 6 => 1 ~ 7
		
//		String strColor = "컬러없음";		
//		strColor = whichColor(nColor);				
//		System.out.printf(
//			">> 선택된 색상은 '%s (%d번컬러)'\n", strColor, nColor);
		
		// Rainbow 무지개 색상 띠 찍어보기 
		// I. 빨간색부터 보라색까지 출력하기
		String caption = "무지개띠 A (빨강에서 보라까지)";
		printRainbow(caption);
		// printRainbow(caption, true); //true 인자 생략됨..
//		printRainbow("무지개띠 B (red to purlple..");
//		printRainbow("무지개띠 C (R to P)");
		printRainbow("무지개띠 B (red to purlple..)", false);
		printRainbow("무지개띠 C (R to P)", true);
		printRainbow("무지개띠 D (P to R)", false);
//		System.out.println("<h3>----- 무지개 (red => purple) ------</h3>");
//		int startColor = COLOR_RED;// 1
//		while(startColor++ <= COLOR_PURPLE) { // 7
////			String strColorName = whichColor(startColor-1); // "red"
//			String strColorName = whichColorToHTML(startColor-1); // "red"
//			System.out.println(
//					(startColor-1) + "번 컬러: " + strColorName + "<br>");
//					//startColor++ + "번 컬러: " + strColorName);
//			//startColor++; 
//			//startColor += 1; //startColor = startColor + 1;
//		}
		
//		while(startColor <= COLOR_PURPLE) { // 7
//			String strColorName = whichColor(startColor); // "red"
//			System.out.println(
//					startColor + "번 컬러: " + strColorName);
//			startColor++; 
//			//startColor += 1; //startColor = startColor + 1;
//		}
		System.out.println("--------------------------------");
		System.out.println();
//		System.out.println("----- 무지개 (purple => red) ------");
//		int startColor2 = COLOR_PURPLE;
//		while() {
//			
//		}
//		System.out.println("--------------------------------");
		
		printHTMLEnd();
	}
	private static void printRainbow(String caption) {
		System.out.println("<div>");
		System.out.println("<h3>----- "+caption+" ------</h3>");
		int startColor = COLOR_RED;// 1
		while(startColor++ <= COLOR_PURPLE) { // 7
			String strColorName = 
					whichColorToHTML(startColor-1); // "red"
			System.out.println(
				(startColor-1) + "번 컬러: "
							+ strColorName + "<br>");
		}
		System.out.println("</div>");
	}
	// order가 true라면 red => purple로 순방향 무지개 출력
	// order가 false라면 purple => red로 역방향 무지개 출력
	// 동일한 함수이름으로 다수개의 함수 바디를 정의할 수 있음..
	// 함수 오버로딩 정의(Function Overloading) => 다형성
	private static void printRainbow(String caption, boolean order) {
		System.out.println("<div>");
		System.out.println("<h3>----- "+caption+" ------</h3>");
		int startColor = COLOR_RED;// 1
		if(order == true) {
		// 순방향 true
//			int startColor = COLOR_RED;// 1
			startColor = COLOR_RED;// 1
			while(startColor++ <= COLOR_PURPLE) { // 7
				String strColorName = 
						whichColorToHTML(startColor-1); // "red"
				System.out.println(
					(startColor-1) + "번 컬러: "
								+ strColorName + "<br>");
			}
		}else { // order == false
		// 역방향 false
		startColor = COLOR_PURPLE;
		while(startColor >= COLOR_RED) {
			System.out.println(startColor + "번 컬러: "
					+ whichColorToHTML(startColor) + "<br>");
			startColor--;
		}
		}
		System.out.println("</div>");
	}
	private static String whichColorToHTML(int nColor) {
		String strColor = whichColor(nColor);
		return "<b style='color:"+
				strColor+"'>"+strColor+"</b>";
	}
	// 컬러 번호를 입력받아 색상표현을 포함한 html tag로 감싸진 컬러이름 문자열 리턴.
	private static String whichColorToHTMLOrigin(int nColor) {
		String strColor;
		switch(nColor) { // case의 순서가 중요! 
			case COLOR_RED: strColor = "red"; break;				
			//case COLOR_RED: strColor = "<b style='color:red'>red</b>"; break;
			case COLOR_ORANGE: strColor = "orange"; break;
			//case COLOR_ORANGE: 
				//strColor = "<b style='color:orange'>orange</b>"; break;
			case COLOR_YELLOW: strColor = "yellow"; break;
			case COLOR_GREEN: 
				strColor = "green"; break;
			case COLOR_BLUE: strColor = "blue";
				break; 
			case COLOR_NAVY: 
				strColor = "navy";				
				break;
			case COLOR_PURPLE: strColor = "purple"; break;	
			default: 
				strColor = COLOR_NAME_BLACK;
				//printColor(strColor);
				//break;
		} // switch...
		
		// 색상 이름 문자열 내용을 태그로 "감싸기"..
//		String colorTag = 
//				"<b style='color:"+
//					strColor+"'>"+strColor+"</b>";
//		
//		return colorTag;
		return "<b style='color:"+
				strColor+"'>"+strColor+"</b>";
		//return strColor;
	}

	// 컬러 정수를 입력하면 컬러이름 문자열로 리턴하는 함수
	public static String whichColor(int nColor) {
		String strColor;
		switch(nColor) { // case의 순서가 중요! 
			case COLOR_RED: strColor = "red"; break;				
			case COLOR_ORANGE: strColor = "orange"; break;
			case COLOR_YELLOW: strColor = "yellow"; break;
			case COLOR_GREEN: 
				strColor = "green"; break;
			case COLOR_BLUE: strColor = "blue";
				break; 
			case COLOR_NAVY: 
				strColor = "navy";				
				break;
			case COLOR_PURPLE: strColor = "purple"; break;	
			default: 
				strColor = COLOR_NAME_BLACK;
				//printColor(strColor);
				//break;
		} // switch...
		return strColor;
	}

}




/*  
----- 무지개 (red => purple) ------

1번 컬러: red
2번 컬러: orange
3번 컬러: yellow
4번 컬러: green
5번 컬러: blue
6번 컬러: navy
7번 컬러: purple
--------------------------------

 
*/