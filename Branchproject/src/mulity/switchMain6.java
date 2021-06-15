package mulity;

public class switchMain6 {
	// ���� Colors
	// RGB(Red, Green, Blue, ������), RGBA, HSV/HSI, CMYK
	
	private static final int COLOR_RED = 1; // ��
	private static final int COLOR_ORANGE = 2;
	private static final int COLOR_YELLOW = 3;
	private static final int COLOR_GREEN = 4;
	private static final int COLOR_BLUE = 5;
	private static final int COLOR_NAVY = 6;
	private static final int COLOR_PURPLE = 7; // ��
	private static final String COLOR_NAME_BLACK = "black";

	
	
	// html�� ����� �����ֱ����� �Լ� �߰� 
	public static void printHTMLStart(String title) {
		final String HTML_START 
			= "<!DOCTYPE html>"
			+ "<html>"
				+ "<head>"
				+ "<meta charset='EUC-KR' />"
					//+ "<title> ������ ��� 1 </title>"
					+ "<title> " + title + " </title>"
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
		printHTMLStart("������ �� ��� 2");
		
		// ������ �� �̸� 7������ �����ϰ� ����ϱ�
		int r = (int)(Math.random()*100) + 1; // 1 ~ 100
		int nColor = (r % 7) + 1; // 0 ~ 6 => 1 ~ 7
		
//		String strColor = "�÷�����";		
//		strColor = whichColor(nColor);				
//		System.out.printf(
//			">> ���õ� ������ '%s (%d���÷�)'\n", strColor, nColor);
		
		// Rainbow ������ ���� �� ���� 
		// I. ���������� ��������� ����ϱ� 
		System.out.println("<h3>----- ������ (red => purple) ------</h3>");
		int startColor = COLOR_RED;// 1
		while(startColor++ <= COLOR_PURPLE) { // 7
//			String strColorName = whichColor(startColor-1); // "red"
			String strColorName = whichColorToHTML(startColor-1); // "red"
			System.out.println(
					(startColor-1) + "�� �÷�: " + strColorName + "<br>");
					//startColor++ + "�� �÷�: " + strColorName);
			//startColor++; 
			//startColor += 1; //startColor = startColor + 1;
		}
//		while(startColor <= COLOR_PURPLE) { // 7
//			String strColorName = whichColor(startColor); // "red"
//			System.out.println(
//					startColor + "�� �÷�: " + strColorName);
//			startColor++; 
//			//startColor += 1; //startColor = startColor + 1;
//		}
		System.out.println("--------------------------------");
		System.out.println();
//		System.out.println("----- ������ (purple => red) ------");
//		int startColor2 = COLOR_PURPLE;
//		while() {
//			
//		}
//		System.out.println("--------------------------------");
		
		printHTMLEnd();
	}
	
	// �÷� ��ȣ�� �Է¹޾� ����ǥ���� ������ html tag�� ������ �÷��̸� ���ڿ� ����.
	private static String whichColorToHTML(int nColor) {
		String strColor;
		switch(nColor) { // case�� ������ �߿�! 
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
		
		// ���� �̸� ���ڿ� ������ �±׷� ���α�..
//		String colorTag = 
//				"<b style='color:"+
//					strColor+"'>"+strColor+"</b>";
		
		return "<b style='color:"+
				strColor+"'>"+strColor+"</b>";
		//return strColor;
	}

	// �÷� ������ �Է��ϸ� �÷��̸� ���ڿ��� �����ϴ� �Լ�
	public static String whichColor(int nColor) {
		String strColor;
		switch(nColor) { // case�� ������ �߿�! 
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
----- ������ (red => purple) ------

1�� �÷�: red
2�� �÷�: orange
3�� �÷�: yellow
4�� �÷�: green
5�� �÷�: blue
6�� �÷�: navy
7�� �÷�: purple
--------------------------------

 
*/