package string;

public class StrMain3 {

	public static void main(String[] args) {
				
		// 문자열을 문자배열로 전환??
		String word3 = "August"; // "April";
		final int wlen3 = word3.length(); // 5
		char[] cArr4c = new char[word3.length()];
		
		// 수동복사 1 - 루프문으로 문자열 요소 개별 하나하나를 
		// 순차적으로 하나씩 배열 공간에 복제
		for (int i = 0; i < cArr4c.length; i++) {
			cArr4c[i] = word3.charAt(i);
		}
		printCharArray(cArr4c);
		
		// 수동복사 2 - 함수화
		char[] manualCopyArr = toMyCharArray( word3 );
		printCharArray(manualCopyArr);
		
		// 자동복사 
		char[] copyArr = word3.toCharArray(); 
			// "April"  ----> { 'A', 'p', 'r', 'i', 'l' }
		printCharArray(copyArr);
	}
	
	private static char[] toMyCharArray2(String word) {
		if( word != null && word.length() > 0 ) { // 널체크최우선
		//if( word.length() > 0 && word != null ) { // 절대안됨!!
				char[] cArr = new char[word.length()];			
				for (int i = 0; i < cArr.length; i++) {
					cArr[i] = word.charAt(i);
				}
				return cArr;
		} else {
			System.out.println("word 입력이 길이가 0이거나 입력이 null.");
			return null;
		}
	}
	

	private static char[] toMyCharArray(String word) {
		if( word != null ) { // 널체크가 우선!! 널이아닐 때만 사용 가능
			if( word.length() > 0 ) { // 글자가 문자열에 1개이상 있는지?
				char[] cArr = new char[word.length()];			
				for (int i = 0; i < cArr.length; i++) {
					cArr[i] = word.charAt(i);
				}
				return cArr;
			} else {
				System.out.println("word 입력이 길이가 0이네요.");
				return new char[0];
			}
		} else {
			System.out.println("문자열이 자체가 입력이 없음. 널!!");
			return null;
		}
	}

	private static void printCharArray(char[] cArr4c) {
		for (int i = 0; i < cArr4c.length; i++) {
			System.out.println(i+"번째 요소 복제 -> " + cArr4c[i]);
		}		
	}

}
/*
0번째 요소 복제 -> A
1번째 요소 복제 -> p
2번째 요소 복제 -> r
3번째 요소 복제 -> i
4번째 요소 복제 -> l 
 */









