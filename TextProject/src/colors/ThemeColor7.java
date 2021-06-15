package colors;
// 어도비 쿨러 https://color.adobe.com/ko/create/color-wheel
// https://color.adobe.com/ko/create/image
// 
// 색상 테마 

// DOS 창에서 실행하기
// cd c:\dev2021\java_ws\TextProject\bin>
// c:\dev2021\java_ws\TextProject\bin>java colors.ThemeColor > theme1.html

// https://en.wikipedia.org/wiki/Web_colors
// https://en.wikipedia.org/wiki/File:SVG_Recognized_color_keyword_names.svg

public class ThemeColor7 {

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
		
		String nmSalmon	= "salmon";
		String crSalmon = "0xFA8072";
		String nmDarkKhaki = "darkKhaki";
		String crDarkKhaki = "0xBDB76B";	
		String nmGold = "gold";
		String crGold = "0xFFD700"; 
		
		// 기본 (더미 dummy) 테마 준비 -- 10개 선택해서 팔레트에 담아..
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
		
		// 테마 컬러 샘플 출력...		
		
		final String HTML_HEAD = 
				"<!DOCTYPE html>" + 
				"<html>" + 
				"	<head>" + 
				"		<title> "+"테마 컬러들: 1 WIKI, 2 그래디언트, 3.수동"+" </title>" + 
				"	</head>" + 
				"	<body>";
		final String HTML_TAIL = 
					"</body>" + 
				"</html>";
		
		int rows = theme1Names.length; // 색상 수
		String titleContent = "1. 테마 컬러 wiki WEB - "+rows+"색 팔레트";
		String title = "<h3>" + titleContent + "</h3>";		
		String table = 
			
			makeColorTable(theme1Names, theme1Codes);		
		
//		LightSkyBlue87 CE FA DeepSkyBlue	00 BF FF RoyalBlue	41 69 E1 MediumBlue	00 00 CD DarkBlue	00 00 8B
		
		String[] theme2Names = {"LightSkyBlue", "DeepSkyBlue", "RoyalBlue", "MediumBlue", "DarkBlue"};
		String[] theme2Codes = {"0x87CEFA", "0x00BFFF", "0x4169E1", "0x0000CD", "0x00008B"};
		int rows2 = theme2Names.length; // 색상 수
		String titleContent2 = "2. 테마 컬러 gradient - "+rows2+"색 팔레트";
		String title2 = "<h3>" + titleContent2 + "</h3>";		
		String table2 = 
				makeColorTable(theme2Names, theme2Codes);
		
		
		String[] theme3Names = {"파랑", "쪽파랑", "명파랑", "깊은파랑", "더쪽파랑", "딥파랑", "다크파랑"};
//		String[] theme3Codes = {"0x", "0x", "0x", "0x", "0x", "0x","0x"};
		String[] theme3Codes = new String[theme3Names.length]; // null로 초기화
		// "" => null 초기화
		int rows3 = theme3Names.length; // 색상 수
		String titleContent3 = "2. 테마 컬러 gradient - "+rows2+"색 팔레트";
		String title3 = "<h3>" + titleContent2 + "</h3>";
		
		// 그래디언트 생성 루프
		int blue = 255;
		for (int i = 0; i < theme3Codes.length; i++) {
			//"0x0000"
//			String code = "0x0000" + blue;
			String code = "0x0000" + Integer.toHexString(blue).toUpperCase();
			// int형의 랩퍼클래스형 Integer클래스의 함수를 적용
			// 연이어서 String 클래스의 소문자를 모두 대문자로 변환
			theme3Codes[i] = code;
			//System.out.println(i + "blue => " + blue);
			//System.out.println(code);
			//blue = blue - 30;
			blue -= 36;
			// blue를 0x0000?? 문자열로 변경해서 theme3Codes 배열요소로저장해야함
			// 십진법 정수 blue를 16진법의 문자열 두글자로 만드는 문제.
		}
		String table3 = 
				makeColorTable(theme3Names, theme3Codes);
		
		// html 출력
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

	// 8자의 문자로 표현된 컬러코드가 문자열로 입력됨.
	// 앞의 "0x" 접두어를 제거한 길이 6문자로 된 새로운 문자열을 코드값으로 리턴.
	// red 기준으로 ...
	// "0xFF0000" 문자열 입력....
	// 입력된 문자열을 배열로 표현해보면.. 
	// { '0', 'x', 'F', 'F', '0', '0', '0', '0' }와 같다. 
	// 여기서 앞의 { '0', 'x' }를 버리고....!! 
	// { '\0','\0','\0','\0','\0','\0' } 준비된 새 배열에 .. 
	// 차례대로 담는다. 
	// {'F', 'F', '0', '0', '0', '0' } 새 배열이 이렇게 저장됨..
	// 배열를 리턴하지는 않아야 하므로...
	// 이 길이가 6인 결과 새 배열을 문자열로 변경하여 리턴한다. 
	// => "FF0000"   ( new String(배열) => "배열내용" )
	
	private static String makeColorTable(
			String[] theme1Names, String[] theme1Codes) {

		String table = "<table border='1'>";
		//
		table += "<tr> <th> 컬러이름 </th> <th> 컬러코드 </th> </tr>";
		for (int i = 0; i < theme1Names.length; i++) {					
			table += "<tr bgcolor='#"+
					getColorCodeOnly(theme1Codes[i])
			+"'> <td> "+theme1Names[i] +"색 </td> "
			+ "<td> <i>"+theme1Codes[i]+"</i> </td> </tr>";
		}
		// 
		table += "</table>";		
		return table;
	}

	private static String getColorCodeOnly(String inCr) {
		// 신규로 컬러코드 문자 6개 담길 배열공간을 확보함.
		//char[] crArr = new char[6];
		char[] crArr = { '\0','\0','\0','\0','\0','\0' }; 
					//   RED         GREEN     BLUE
		for (int i = 0; i < crArr.length; i++) { // i=>0 ~ 5
			crArr[i] = inCr.charAt(i+2); // "0x" 건너뜀.
		}
		// 확인 디버그용..
//		for (int i = 0; i < crArr.length; i++) {
//			System.out.printf("%c \n", crArr[i]);
//		}
		//String retCr = new String("");// "";
		String retCr = new String(crArr);	
			// 문자배열을 입력받아 문자열(객체)로 만들어줌...!!! (중요)
		return retCr;
//		return crArr;// 배열 리턴 안됨..
	}

	private static String getColorCodeOnly2(String inCr) {
		char[] editArr = getColorArray(inCr);
		char[] crArr = new char[editArr.length-2];
		for (int i = 0; i < crArr.length; i++) {
			crArr[i] = editArr[i+2];
		}
		String str = new String(crArr); // 문자배열 문자열로 변환
		return str;
	}
	
	// 임의 길이의 "" 문자열 입력을  Array 배열로 변경하여 리턴하는 함수
	// "abcde"  =>  { 'a', 'b', 'c', 'd', 'e' }
	public static char[] getColorArray(String inCr) {
		//char[] retArr = {0,0,0,0,0,0}; // 6개만 변환한다는 전제..
		char[] retArr = new char[inCr.length()];
			// i 0 ~ length-1
		for (int i = 0; i < retArr.length; i++) {
			retArr[i] = inCr.charAt(i); 
			// 문자열 요소를 하나씩 배열칸에 복사 
		}
		return retArr;
	}	
}




