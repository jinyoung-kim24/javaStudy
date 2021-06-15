package colors;
// 어도비 쿨러 https://color.adobe.com/ko/create/color-wheel
// https://color.adobe.com/ko/create/image
// 
// 색상 테마 

public class ThemeColor2 {

	public static final int THEME_COLORS = 5;
	
	public static void main(String[] args) {
		// 컬러 이름(영문단어문자열), 컬러 코드(RGB 각 채널별 byte == 3바이트)
		// 투명도 추가 시 4바이트 최소 표현..  
		// RED 0 ~ 255 빨간색의 정도의 차이 => 0x00 ~ 0xFF
		// 레드색의 코드는 0xFF0000
		
		// 기본색들 nm 이름, cr 코드
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
		String crYellow = "0xFFFF00"; // 1:1 동률 조합
		String nmCyan = "cyan";
		String crCyan = "0x00FFFF";
		String nmPurple = "purple";
		String crPurple = "0xFF00FF";
		
		// 기본 (더미 dummy) 테마 준비 -- 7개 선택해서 팔레트에 담아..
		String[] theme1Names = 
			{nmRed, nmLightGrey, nmYellow, nmCyan, nmGreen, nmPurple, nmBlue};
		String[] theme1Codes = {
			crRed, crLightGrey, crYellow, crCyan, crGreen, crPurple, crBlue	
		};
		
		// 테마 컬러 샘플 출력... 
		int rows = theme1Names.length; // 색상수
		String titleContent = "<h3>테마 컬러 A -" +rows + "색 팔레트</h3>";
		
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
		table += "<tr> <th> 컬러이름 </th> <th> 컬러코드 </th> </tr>";
		for (int i = 0; i < theme1Names.length; i++) {
		table += "<tr bgcolor='"+theme1Names[i]
				+"'> <td>" + theme1Names[i] + "</td> <td>" + theme1Codes[i] + "</td> </tr>";
		}
		table += "</table>";
		
		// html 출력
		System.out.println(HTML_HEAD);
		System.out.println(title);
		System.out.println(table);
		System.out.println(HTML_TAIL);
	}

}




