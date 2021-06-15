package string;

public class StringTest {
	//https://en.wikipedia.org/wiki/Main_Page
	public static void main(String[] args) {
		String msg = "Presidency of James Buchanan " + 
				"James Buchanan (April 23, 1791 – June 1"
				+ ", 1868) served as President of the United"
				+ " States for a single term from 1857 to "
				+ "1861. He was unable to calm the growing "
				+ "sectional crisis that would divide the "
				+ "nation. In the midst of the growing "
				+ "chasm between slave states and free "
				+ "states, the Panic of 1857 occurred, "
				+ "causing widespread business failures "
				+ "and high unemployment.";
		String msg2 = "Presidency of James Buchanan ";
		//msg2 += "James Buchanan (April 23, 1791 – June 1";
//		msg2 = "Presidency of James Buchanan "
//				+ "James Buchanan (April 23, 1791 – June 1";
//		msg2 = "Presidency of James Buchanan ".concat(
//				"James Buchanan (April 23, 1791 – June 1");
		msg2 = msg2.concat(
				"James Buchanan (April 23, 1791 – June 1");
		// 자바 문자열처리 + 기호연산자? concat() 메소드의 간략식.
		// String은 일종의 불변 문자열, 한 번 생성되면 그 길이와 내용이 변하지 않음.
		System.out.println(msg2);
		
		// 문자열의 길이, 유니코드 문자의 개수 != 바이트 크기
		int len = msg.length();
		System.out.println("MSG 문자열의 길이 = " + len);
		
		// 문자열 객체상의 한 글자를 특정위치에서 뽑기
		char c = msg.charAt(200);
		System.out.printf("문자열 객체상의 한 글자를 특정위치에서 뽑기 = %c [%d, 0x%X]\n", c, (int)c, (int)c);
		
		// 문자열 객체를 문자배열로 리턴하기 (변환)
		char[] cArr = msg.toCharArray();
		for (char d : cArr) {
			System.out.print(d + " ");
		}
		System.out.println();
		
		// 문자열이 특정한 부분 문자열을 포함하는가? (포함 관계)
		System.out.println("states 부분문자열이 포함되었는가?" + msg.contains("states"));

		System.out.println("king 부분문자열이 포함되었는가?" + msg.contains("king"));
		
		
		// 위치파악: 해당 글자하나의 위치? 해당 문자열(단어)의 시작위치
		System.out.println("states 해당 문자열의 시작위치: " + msg.indexOf("states", 283 + 6));
		
		System.out.println("U 해당 문자열의 시작위치: " + msg.indexOf('U'));
		
		System.out.println("Queen 부분문자열이 포함되었는가?" + (msg.indexOf("Queen") == -1 ? "없습니다" : msg.indexOf("Queen")));
		
		// -- 역방향 위치 찾기
		System.out.println("states 문자열의 뒤에서 부터 찾은 시작 위치: " + msg.lastIndexOf("states"));

		System.out.println("U 문자열의 뒤에서 부터 찾은 시작 위치: " + msg.lastIndexOf('U'));
		
		// 문자열 변환, 비교
		String wordA = "banana";
		String wordB = new String("banana");
		String wordC = new String(new char[] {'b', 'a', 'n', 'a', 'n', 'a'});
		String wordD = new String(new char[] {'b', 'a', 'N', 'a', 'N', 'a'});
		System.out.println(wordA + "와" + wordB + "의 내용은 같다. =>" + wordA.equals(wordB));
		System.out.println(wordA + "와" + wordC + "의 내용은 같다. =>" + wordA.equals(wordC));
		System.out.println(wordA + "와" + wordD + "의 내용은 같다. =>" + wordA.equals(wordD));
		System.out.println(wordA + "와" + wordD.toLowerCase() + "의 내용은 같다. =>" + wordA.equals(wordD.toLowerCase()));
		System.out.println(wordA.toUpperCase() + "와" + wordD + "의 내용은 같다. =>" + wordA.toUpperCase().equals(wordD));
		System.out.println(wordA.toUpperCase() + "와" + wordD.toUpperCase() + "의 내용은 같다. =>" + wordA.toUpperCase().equals(wordD.toUpperCase()));
		
		System.out.println(wordA + "와" + wordD + "의 대소문자를 무시하고 내용은 같다. =>" + wordA.equalsIgnoreCase(wordD));
		
		String box = ""; // emtpy String length = 0
		if(box.length() == 0) System.out.println("빈문자열");
		if(box.isEmpty()) System.out.println("빈문자열");
		if(wordA.isEmpty()) System.out.println("빈문자열");
		else System.out.println(wordA + "는 빈문자열 아닙니다");
		
		// 문자열의 시작과 끝을 체크
		String name1 = "디즈엘사";
		String name2 = "디즈니안나";
		if(name1.charAt(0) == '디') // 문자하나 비교는 값의 비교 == 
			System.out.println(name1 + "은 '디'로 시작함.");
		if(name1.startsWith("디즈") && name2.startsWith("디즈"))
			System.out.println(name1 + "과" + name2 + "은 \"디즈\"로 시작함.");
		
		// 내문서 폴더안에 들어있는 파일들의 이름 목록
		String[] fileNames = { // 3개의 텍스트파일, 5개의 바이너리파일
			"mypic.jpg", "mymemory.txt",
			"mymemo.hwp","herpic.png",
			"hishistory.txt", "ourmemo.hwp",
			"myProg.java", "mydesign.psd"
		};
		
		int myFiles = 0; // 폴더안에 "my" 접두어로 시작하는 파일들의 개수
		System.out.println(" ** 내문서함 폴더 안에 내 파일들");
		for (String fname : fileNames) {
			if(fname.startsWith("my")) {
				System.out.println(" - " + fname);
			myFiles++;
			}
		}
		System.out.println("\t>> \"my\"로 시작하는 내 파일 개수: " + myFiles + "개");
		
		
		// 파일명에 포함된 맨 뒤에 확장자명으로 분류해보기 (file extension)
		// 이미지, 텍스트, 워드프로세서, 프로그래밍, 기타 파일들
		for (int i = 0; i < fileNames.length; i++) {
			String fname = fileNames[i];
			if( fname.endsWith(".jpg") ||
				fname.endsWith(".png") ||
				fname.endsWith(".gif") ||
				fname.endsWith(".bmp") ||
				fname.endsWith(".psd") ||
				fname.endsWith(".webp") ) {
				System.out.println(" * 이미지 파일 found : " + fname);
			}else if(fname.endsWith(".txt") ||
					 fname.endsWith(".md")) {
				System.out.println("* 텍스트 파일 found: " + fname);
			}else if(fname.endsWith(".hwp") ||
					 fname.endsWith(".doc") ||
					 fname.endsWith(".docx") ||
					 fname.endsWith(".rtf") ) {
				System.out.println("* 워드프로세서 파일 found: " + fname);
			}else if(fname.endsWith(".java") || 
					 fname.endsWith(".php") ||
					 fname.endsWith(".py") ||
					 fname.endsWith(".rb") ||
					 fname.endsWith(".c") ||
					 fname.endsWith(".js") ||
					 fname.endsWith(".dart") ||
					 fname.endsWith(".swift") ||
					 fname.endsWith(".kt") ||
					 fname.endsWith(".cs")) {
				System.out.println("* 프로그래밍 소스 파일 found: " + fname);
			}else {
				System.out.println(fname + "가없어요");
			}
		}
		
		
		
	}

}
