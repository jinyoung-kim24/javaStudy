package colors;
// ��� �� https://color.adobe.com/ko/create/color-wheel
// https://color.adobe.com/ko/create/image
// 
// ���� �׸� 

// DOS â���� �����ϱ�
// cd c:\dev2021\java_ws\TextProject\bin>
// c:\dev2021\java_ws\TextProject\bin>java colors.ThemeColor > theme1.html

// https://en.wikipedia.org/wiki/Web_colors
// https://en.wikipedia.org/wiki/File:SVG_Recognized_color_keyword_names.svg

public class ThemeColor7 {

	public static final int THEME_COLORS = 5;
	
	public static void main(String[] args) {
		// �÷� �̸�(�����ܾ�ڿ�), �÷� �ڵ�(RGB �� ä�κ� byte == 3����Ʈ)
		// ���� �߰� �� 4����Ʈ �ּ� ǥ��..  
		// RED 0 ~ 255 �������� ������ ���� => 0x00 ~ 0xFF
		// ������� �ڵ�� 0xFF0000
		
		// �⺻���� nm �̸�, cr �ڵ�
		String nmWhite = "white"; 
		String crWhite = "0xFFFFFF"; 
		String nmBlack = "black";
		String crBlack = "0x000000";
		String nmLightGrey = "lightgrey";
		String crLightGrey = "0xBBBBBB";
		String nmDarkGrey = "darkgrey";
		String crDarkGrey = "0x333333";
		
		String nmRed = "red";
		String crRed = "0xFF0000";
		String nmGreen = "green";
		String crGreen = "0x00FF00";
		String nmBlue = "blue";
		String crBlue = "0x0000FF";
		
		String nmYellow = "yellow";
		String crYellow = "0xFFFF00"; // 1:1 ���� ����
		String nmCyan = "cyan";
		String crCyan = "0x00FFFF";
		String nmPurple = "purple";
		String crPurple = "0xFF00FF";
		
		String nmSalmon	= "salmon";
		String crSalmon = "0xFA8072";
		String nmDarkKhaki = "darkKhaki";
		String crDarkKhaki = "0xBDB76B";	
		String nmGold = "gold";
		String crGold = "0xFFD700"; 
		
		// �⺻ (���� dummy) �׸� �غ� -- 10�� �����ؼ� �ȷ�Ʈ�� ���..
//		String[] theme1Names = 
//			{nmRed, nmLightGrey, nmYellow, nmCyan,
//					nmGreen, nmPurple, nmBlue, 
//					nmSalmon, nmDarkKhaki, nmGold};
//		String[] theme1Codes = {
//			crRed, crLightGrey, crYellow, crCyan, 
//					crGreen, crPurple, crBlue,
//					crSalmon, crDarkKhaki, crGold
//		};
		
		String[] theme1Names = {
				"AliceBlue", "DarkViolet", "OliveDrab",
				"NavajoWhite", "Coral"};
		String[] theme1Codes = {
				"0xF0F8FF", "0x9400D3", "0x6B8E23",
				"0xFFDEAD", "0xFF7F50"};
		
		// �׸� �÷� ���� ���...		
		
		final String HTML_HEAD = 
				"<!DOCTYPE html>" + 
				"<html>" + 
				"	<head>" + 
				"		<title> "+"�׸� �÷���: 1 WIKI, 2 �׷����Ʈ, 3.����"+" </title>" + 
				"	</head>" + 
				"	<body>";
		final String HTML_TAIL = 
					"</body>" + 
				"</html>";
		
		int rows = theme1Names.length; // ���� ��
		String titleContent = "1. �׸� �÷� wiki WEB - "+rows+"�� �ȷ�Ʈ";
		String title = "<h3>" + titleContent + "</h3>";		
		String table = 
			
			makeColorTable(theme1Names, theme1Codes);		
		
//		LightSkyBlue87 CE FA DeepSkyBlue	00 BF FF RoyalBlue	41 69 E1 MediumBlue	00 00 CD DarkBlue	00 00 8B
		
		String[] theme2Names = {"LightSkyBlue", "DeepSkyBlue", "RoyalBlue", "MediumBlue", "DarkBlue"};
		String[] theme2Codes = {"0x87CEFA", "0x00BFFF", "0x4169E1", "0x0000CD", "0x00008B"};
		int rows2 = theme2Names.length; // ���� ��
		String titleContent2 = "2. �׸� �÷� gradient - "+rows2+"�� �ȷ�Ʈ";
		String title2 = "<h3>" + titleContent2 + "</h3>";		
		String table2 = 
				makeColorTable(theme2Names, theme2Codes);
		
		
		String[] theme3Names = {"�Ķ�", "���Ķ�", "���Ķ�", "�����Ķ�", "�����Ķ�", "���Ķ�", "��ũ�Ķ�"};
//		String[] theme3Codes = {"0x", "0x", "0x", "0x", "0x", "0x","0x"};
		String[] theme3Codes = new String[theme3Names.length]; // null�� �ʱ�ȭ
		// "" => null �ʱ�ȭ
		int rows3 = theme3Names.length; // ���� ��
		String titleContent3 = "2. �׸� �÷� gradient - "+rows2+"�� �ȷ�Ʈ";
		String title3 = "<h3>" + titleContent2 + "</h3>";
		
		// �׷����Ʈ ���� ����
		int blue = 255;
		for (int i = 0; i < theme3Codes.length; i++) {
			//"0x0000"
//			String code = "0x0000" + blue;
			String code = "0x0000" + Integer.toHexString(blue).toUpperCase();
			// int���� ����Ŭ������ IntegerŬ������ �Լ��� ����
			// ���̾ String Ŭ������ �ҹ��ڸ� ��� �빮�ڷ� ��ȯ
			theme3Codes[i] = code;
			//System.out.println(i + "blue => " + blue);
			//System.out.println(code);
			//blue = blue - 30;
			blue -= 36;
			// blue�� 0x0000?? ���ڿ��� �����ؼ� theme3Codes �迭��ҷ������ؾ���
			// ������ ���� blue�� 16������ ���ڿ� �α��ڷ� ����� ����.
		}
		String table3 = 
				makeColorTable(theme3Names, theme3Codes);
		
		// html ���
		System.out.println(HTML_HEAD);
		System.out.println(title);
		System.out.println(table);
		System.out.println("<hr>");
		System.out.println(title2);
		System.out.println(table2);
		System.out.println("<hr>");
		System.out.println(title3);
		System.out.println(table3);
		System.out.println(HTML_TAIL);
	}

	// 8���� ���ڷ� ǥ���� �÷��ڵ尡 ���ڿ��� �Էµ�.
	// ���� "0x" ���ξ ������ ���� 6���ڷ� �� ���ο� ���ڿ��� �ڵ尪���� ����.
	// red �������� ...
	// "0xFF0000" ���ڿ� �Է�....
	// �Էµ� ���ڿ��� �迭�� ǥ���غ���.. 
	// { '0', 'x', 'F', 'F', '0', '0', '0', '0' }�� ����. 
	// ���⼭ ���� { '0', 'x' }�� ������....!! 
	// { '\0','\0','\0','\0','\0','\0' } �غ�� �� �迭�� .. 
	// ���ʴ�� ��´�. 
	// {'F', 'F', '0', '0', '0', '0' } �� �迭�� �̷��� �����..
	// �迭�� ���������� �ʾƾ� �ϹǷ�...
	// �� ���̰� 6�� ��� �� �迭�� ���ڿ��� �����Ͽ� �����Ѵ�. 
	// => "FF0000"   ( new String(�迭) => "�迭����" )
	
	private static String makeColorTable(
			String[] theme1Names, String[] theme1Codes) {

		String table = "<table border='1'>";
		//
		table += "<tr> <th> �÷��̸� </th> <th> �÷��ڵ� </th> </tr>";
		for (int i = 0; i < theme1Names.length; i++) {					
			table += "<tr bgcolor='#"+
					getColorCodeOnly(theme1Codes[i])
			+"'> <td> "+theme1Names[i] +"�� </td> "
			+ "<td> <i>"+theme1Codes[i]+"</i> </td> </tr>";
		}
		// 
		table += "</table>";		
		return table;
	}

	private static String getColorCodeOnly(String inCr) {
		// �űԷ� �÷��ڵ� ���� 6�� ��� �迭������ Ȯ����.
		//char[] crArr = new char[6];
		char[] crArr = { '\0','\0','\0','\0','\0','\0' }; 
					//   RED         GREEN     BLUE
		for (int i = 0; i < crArr.length; i++) { // i=>0 ~ 5
			crArr[i] = inCr.charAt(i+2); // "0x" �ǳʶ�.
		}
		// Ȯ�� ����׿�..
//		for (int i = 0; i < crArr.length; i++) {
//			System.out.printf("%c \n", crArr[i]);
//		}
		//String retCr = new String("");// "";
		String retCr = new String(crArr);	
			// ���ڹ迭�� �Է¹޾� ���ڿ�(��ü)�� �������...!!! (�߿�)
		return retCr;
//		return crArr;// �迭 ���� �ȵ�..
	}

	private static String getColorCodeOnly2(String inCr) {
		char[] editArr = getColorArray(inCr);
		char[] crArr = new char[editArr.length-2];
		for (int i = 0; i < crArr.length; i++) {
			crArr[i] = editArr[i+2];
		}
		String str = new String(crArr); // ���ڹ迭 ���ڿ��� ��ȯ
		return str;
	}
	
	// ���� ������ "" ���ڿ� �Է���  Array �迭�� �����Ͽ� �����ϴ� �Լ�
	// "abcde"  =>  { 'a', 'b', 'c', 'd', 'e' }
	public static char[] getColorArray(String inCr) {
		//char[] retArr = {0,0,0,0,0,0}; // 6���� ��ȯ�Ѵٴ� ����..
		char[] retArr = new char[inCr.length()];
			// i 0 ~ length-1
		for (int i = 0; i < retArr.length; i++) {
			retArr[i] = inCr.charAt(i); 
			// ���ڿ� ��Ҹ� �ϳ��� �迭ĭ�� ���� 
		}
		return retArr;
	}	
}




