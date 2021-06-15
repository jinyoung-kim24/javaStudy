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

public class ThemeColor4 {

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
		String[] theme1Names = 
			{nmRed, nmLightGrey, nmYellow, nmCyan,
					nmGreen, nmPurple, nmBlue, 
					nmSalmon, nmDarkKhaki, nmGold};
		String[] theme1Codes = {
			crRed, crLightGrey, crYellow, crCyan, 
					crGreen, crPurple, crBlue,
					crSalmon, crDarkKhaki, crGold
		};
		
		// �׸� �÷� ���� ���...
		int rows = theme1Names.length; // ���� ��
		String titleContent = "�׸� �÷� A - "+rows+"�� �ȷ�Ʈ";
		
		final String HTML_HEAD = 
				"<!DOCTYPE html>" + 
				"<html>" + 
				"	<head>" + 
				"		<title> "+titleContent+" </title>" + 
				"	</head>" + 
				"	<body>";
		final String HTML_TAIL = 
					"</body>" + 
				"</html>";
		String title = "<h3>" + titleContent + "</h3>";
		
		
		String table = "<table border='1'>";
		//
		table += "<tr> <th> �÷��̸� </th> <th> �÷��ڵ� </th> </tr>";
		for (int i = 0; i < theme1Names.length; i++) {					
			//table += "<tr bgcolor='"+ "#F08080" // lightcoral
			//table += "<tr bgcolor='"+ theme1Names[i] // �÷��̸�
//			table += "<tr bgcolor='"+ theme1Codes[i] // �÷� �ڵ�
			
			table += "<tr bgcolor='#"+
					getColorCodeOnly2(theme1Codes[i]) // ������ �÷� �ڵ�
				+"'> <td> "+theme1Names[i]
				+" </td> <td> <i>"+theme1Codes[i]+"</i> </td> </tr>";
		}
		// 
		table += "</table>";
		
		// html ���
		System.out.println(HTML_HEAD);
		System.out.println(title);
		System.out.println(table);
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




