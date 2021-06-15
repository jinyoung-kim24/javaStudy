package mulity;

import java.util.Scanner; // ��ĳ�ʸ� ����ϰڴٰ� import ����

public class switchMain9 {
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
					+ "<style>"
					+ "	div {"
					+ "		border: 1px solid black;"
					+ "		width: 25%;"
					+ "		margin: 10px;"
					+ " }"
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
		printHTMLStart("������ �� ��� 7 (�ݺ�ȸ��,���� �Է�)");
		
		// java �⺻ �ܼ� �Է� ���� Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n>> ������ ī�� ���� ��� �̸� �Է�: ");
		String toName = sc.next(); // ���ڿ� �ܾ� �ϳ� �Է�
		System.out.println("<h2> �̸�: " + toName + "</h2>");
		
		System.out.print("\n>> �ݺ� ȸ���� �Է�: "); // �ȳ� guide ����		
		// Ư�� ȸ���� ��ġ�� ��ŭ �ݺ������� �������츦 ����ϱ�
		int countRainbow = sc.nextInt(); // Ű���� �Է� ������ ���...
			// ������ �ϳ��� �Է����� �޾Ƽ� ������0
		System.out.println("<h2> �ݺ�ȸ��: " +countRainbow
						+ "�� </h2>");
		
		System.out.println(
			"\n>> ���� ����: (1. red����, 2. purple����): ");
		int orderInput = sc.nextInt(); // 1 ~ 2 �������?
		final int FROM_RED = 1;
		final int FROM_PURPLE = 2;
		boolean order = false;
		
		if( orderInput == FROM_RED ) {
			order = true; // 1 )
			System.out.println("<h2>red���� purple����..</h2>");
		}
		else if( orderInput == FROM_PURPLE ) {
			order = false;
			System.out.println("<h2>purple���� red����..</h2>");
		}
		else { // ���� ���� �Է��� �ƴѰ��? ����, 0, 3�̻�...  (�⺻���� ����)
			order = true; // FROM_RED ����...
			System.out.println("���� ���� �Է��� �ƴ�; red���� ����..");
		}
		
		int count = 0; // 0, 1, 2, ...
		while( count < countRainbow ) { // 3 < 3, false ��������
//			if( order ) // == true )
//			printRainbow(
//			 "�׽�Ʈ �������� "+(count+1)
//			 	+"��: red -> purple", order);
//			else // order == false
//			printRainbow(
//			 "�׽�Ʈ �������� "+(count+1)
//			 	+"��: purple -> red", order);
//			String from;
//			if(order)
//			from= "red -> purple";
//			else
//			from = "purple -> red";
			// ���׽� (ternary operator)
			// ���ǽ� ? true�� �����ϴ� ������:false�� �����ϴ� ������
			// ���׽��� ����� �� �ϳ��� ������ �ǵ�����..
			// (���ǽ�) ? A : B�� if(���ǽ�) A else B;�� ����..
			String from = (order == true) ? "red -> purple" : "purple -> red";
			printRainbow(
				 "�׽�Ʈ �������� "+(count+1)
				 	+"��: "+from, order);
			count++;
			//+"��: red -> purple", true);
		}		
		
		printHTMLEnd();
		sc.close(); // �ڿ��� ȸ��, �ݳ� ó��.
		
		// ������ �� �̸� 7������ �����ϰ� ����ϱ�
//		int r = (int)(Math.random()*100) + 1; // 1 ~ 100
//		int nColor = (r % 7) + 1; // 0 ~ 6 => 1 ~ 7
		
//		String strColor = "�÷�����";		
//		strColor = whichColor(nColor);				
//		System.out.printf(
//			">> ���õ� ������ '%s (%d���÷�)'\n", strColor, nColor);
		
		// Rainbow ������ ���� �� ���� 
		// I. ���������� ��������� ����ϱ�
//		String caption = "�������� A (�������� �������)";
//		printRainbow(caption);
//		//printRainbow(caption, true); // true ���� ������..
////		printRainbow("�������� B (red to purple..)");
////		printRainbow("�������� C (R to P)");
//		printRainbow("�������� B (red to purple..)", false); // purple -> red
//		printRainbow("�������� C (R to P)", true);
//		printRainbow("�������� D (P to R)", false);
		
		
//		System.out.println("<h3>----- ������ (red => purple) ------</h3>");
//		int startColor = COLOR_RED;// 1
//		while(startColor++ <= COLOR_PURPLE) { // 7
////			String strColorName = whichColor(startColor-1); // "red"
//			String strColorName = whichColorToHTML(startColor-1); // "red"
//			System.out.println(
//					(startColor-1) + "�� �÷�: " + strColorName + "<br>");
//					//startColor++ + "�� �÷�: " + strColorName);
//			//startColor++; 
//			//startColor += 1; //startColor = startColor + 1;
//		}
		
//		while(startColor <= COLOR_PURPLE) { // 7
//			String strColorName = whichColor(startColor); // "red"
//			System.out.println(
//					startColor + "�� �÷�: " + strColorName);
//			startColor++; 
//			//startColor += 1; //startColor = startColor + 1;
//		}
//		System.out.println("--------------------------------");
//		System.out.println();
//		System.out.println("----- ������ (purple => red) ------");
//		int startColor2 = COLOR_PURPLE;
//		while() {
//			
//		}
//		System.out.println("--------------------------------");
		
//		printHTMLEnd();
	}
	
	private static void printRainbow(String caption) {
		System.out.println("<div>");
		System.out.println("<h3>----- "+caption+" ------</h3>");
		int startColor = COLOR_RED;// 1
		while(startColor++ <= COLOR_PURPLE) { // 7
			String strColorName = 
					whichColorToHTML(startColor-1); // "red"
			System.out.println(
				(startColor-1) + "�� �÷�: "
							+ strColorName + "<br>");
		}
		System.out.println("</div>");
	}
	
	
	// order�� true��� red => purple�� ������ ������ ���
	// order�� false��� purple => red�� ������ ������ ���
	//private static void printRainbowTWO(
	// ������ �Լ��̸����� �ټ����� �Լ� �ٵ� ������ �� ����.. 
	// �Լ� �����ε� ����(Function Overloading) => ������
	private static void printRainbow(
			String caption, boolean order) {
		System.out.println("<div>");
		System.out.println("<h3>----- "+caption+" ------</h3>");
		int startColor;// ���� ��ġ�� ����.
		if(order == true ) {
			// ������ true
//			int startColor = COLOR_RED;// 1
			startColor = COLOR_RED;// 1
			while(startColor++ <= COLOR_PURPLE) { // 7
				String strColorName = 
						whichColorToHTML(startColor-1); // "red"
				System.out.println(
					(startColor-1) + "�� �÷�: "
								+ strColorName + "<br>");
			}
		} else // order == false 
		{
			// ������ false			
			startColor = COLOR_PURPLE;
			while( startColor >= COLOR_RED ) {
				System.out.println(startColor+ "�� �÷�: " 
						+ whichColorToHTML(startColor) + "<br>");
				startColor -= 1; //startColor--;
			}
		}
		
		System.out.println("</div>");
	}
	

	// �÷� ��ȣ�� �Է¹޾� ����ǥ���� ������ html tag�� ������ �÷��̸� ���ڿ� ����.
	//private static String whichColorToHTML(int nColor, boolean tag) {
	private static String whichColorToHTML(int nColor) {
		String strColor = whichColor(nColor);
		return "<b style='color:"+
				strColor+"'>"+strColor+"</b>";
	}
	
	private static String whichColorToHTMLOrigin(int nColor) {
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
		
		// ���� �̸� ���ڿ� ������ �±׷� "���α�"..
//		String colorTag = 
//				"<b style='color:"+
//					strColor+"'>"+strColor+"</b>";
//		
//		return colorTag;
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