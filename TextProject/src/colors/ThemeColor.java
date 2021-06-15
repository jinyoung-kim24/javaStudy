package colors;
// 어도비 쿨러 https://color.adobe.com/ko/create/color-wheel
// https://color.adobe.com/ko/create/image
// 
// 색상 테마 

public class ThemeColor {

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
		
		// 기본 (더미 dummy) 테마 준비 -- 오직 5개 선택해서 팔레트에 담아..
		String[] theme1Names = 
			{nmRed, nmLightGrey, nmGreen, nmBlack, nmBlue};
		String[] theme1Codes = {
			crRed, crLightGrey, crGreen, crBlack, crBlue	
		};
		
		// 테마 컬러 샘플 출력... 
		final String HTML_HEAD = 
				"<!DOCTYPE html>" + 
				"<html>" + 
				"	<head>" + 
				"		<title> 테마 컬러 1 - 5색 팔레트 </title>" + 
				"	</head>" + 
				"	<body>";
		final String HTML_TAIL = 
					"</body>" + 
				"</html>";
		String title = "<h3>테마 컬러 1 - 5색 팔레트</h3>";
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
		
		// html 출력
		System.out.println(HTML_HEAD);
		System.out.println(title);
		System.out.println(table);
		System.out.println(HTML_TAIL);
	}

}




