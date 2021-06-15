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

public class ThemeColor4 {

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
		String[] theme1Names = 
			{nmRed, nmLightGrey, nmYellow, nmCyan,
					nmGreen, nmPurple, nmBlue, 
					nmSalmon, nmDarkKhaki, nmGold};
		String[] theme1Codes = {
			crRed, crLightGrey, crYellow, crCyan, 
					crGreen, crPurple, crBlue,
					crSalmon, crDarkKhaki, crGold
		};
		
		// 테마 컬러 샘플 출력...
		int rows = theme1Names.length; // 색상 수
		String titleContent = "테마 컬러 A - "+rows+"색 팔레트";
		
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
		table += "<tr> <th> 컬러이름 </th> <th> 컬러코드 </th> </tr>";
		for (int i = 0; i < theme1Names.length; i++) {					
			//table += "<tr bgcolor='"+ "#F08080" // lightcoral
			//table += "<tr bgcolor='"+ theme1Names[i] // 컬러이름
//			table += "<tr bgcolor='"+ theme1Codes[i] // 컬러 코드
			
			table += "<tr bgcolor='#"+
					getColorCodeOnly2(theme1Codes[i]) // 가공된 컬러 코드
				+"'> <td> "+theme1Names[i]
				+" </td> <td> <i>"+theme1Codes[i]+"</i> </td> </tr>";
		}
		// 
		table += "</table>";
		
		// html 출력
		System.out.println(HTML_HEAD);
		System.out.println(title);
		System.out.println(table);
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




