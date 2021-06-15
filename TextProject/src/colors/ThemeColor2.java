package colors;
// ��� �� https://color.adobe.com/ko/create/color-wheel
// https://color.adobe.com/ko/create/image
// 
// ���� �׸� 

public class ThemeColor2 {

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
		
		// �⺻ (���� dummy) �׸� �غ� -- 7�� �����ؼ� �ȷ�Ʈ�� ���..
		String[] theme1Names = 
			{nmRed, nmLightGrey, nmYellow, nmCyan, nmGreen, nmPurple, nmBlue};
		String[] theme1Codes = {
			crRed, crLightGrey, crYellow, crCyan, crGreen, crPurple, crBlue	
		};
		
		// �׸� �÷� ���� ���... 
		int rows = theme1Names.length; // �����
		String titleContent = "<h3>�׸� �÷� A -" +rows + "�� �ȷ�Ʈ</h3>";
		
		final String HTML_HEAD = 
				"<!DOCTYPE html>" + 
				"<html>" + 
				"	<head>" + 
				"		<title>" + titleContent + "</title>" + 
				"	</head>" + 
				"	<body>";
		final String HTML_TAIL = 
					"</body>" + 
				"</html>";
		String title = "<h3>" + titleContent + "</h3>";
		String table = "<table border='1'>";
		table += "<tr> <th> �÷��̸� </th> <th> �÷��ڵ� </th> </tr>";
		for (int i = 0; i < theme1Names.length; i++) {
		table += "<tr bgcolor='"+theme1Names[i]
				+"'> <td>" + theme1Names[i] + "</td> <td>" + theme1Codes[i] + "</td> </tr>";
		}
		table += "</table>";
		
		// html ���
		System.out.println(HTML_HEAD);
		System.out.println(title);
		System.out.println(table);
		System.out.println(HTML_TAIL);
	}

}




