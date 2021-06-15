package colors;
// ��� �� https://color.adobe.com/ko/create/color-wheel
// https://color.adobe.com/ko/create/image
// 
// ���� �׸� 

public class ThemeColor {

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
		
		// �⺻ (���� dummy) �׸� �غ� -- ���� 5�� �����ؼ� �ȷ�Ʈ�� ���..
		String[] theme1Names = 
			{nmRed, nmLightGrey, nmGreen, nmBlack, nmBlue};
		String[] theme1Codes = {
			crRed, crLightGrey, crGreen, crBlack, crBlue	
		};
		
		// �׸� �÷� ���� ���... 
		final String HTML_HEAD = 
				"<!DOCTYPE html>" + 
				"<html>" + 
				"	<head>" + 
				"		<title> �׸� �÷� 1 - 5�� �ȷ�Ʈ </title>" + 
				"	</head>" + 
				"	<body>";
		final String HTML_TAIL = 
					"</body>" + 
				"</html>";
		String title = "<h3>�׸� �÷� 1 - 5�� �ȷ�Ʈ</h3>";
		String table = "<table border='1'>";
		table += "<tr bgcolor='"+theme1Names[0]
				+"'> <td> 1 </td> <td> 2 </td> </tr>";
		table += "<tr bgcolor='"+theme1Names[1]
				+"'> <td> 3 </td> <td> 4 </td> </tr>";
		table += "<tr bgcolor='"+theme1Names[2]
				+"'> <td> 5 </td> <td> 6 </td> </tr>";
		table += "<tr bgcolor='"+theme1Names[3]
				+"'> <td> 7 </td> <td> 8 </td> </tr>";
		table += "<tr bgcolor='"+theme1Names[4]
				+"'> <td> 9 </td> <td> 10 </td> </tr>";
		table += "</table>";
		
		// html ���
		System.out.println(HTML_HEAD);
		System.out.println(title);
		System.out.println(table);
		System.out.println(HTML_TAIL);
	}

}




