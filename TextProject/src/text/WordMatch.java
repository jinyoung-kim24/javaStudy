package text;

public class WordMatch {

	public static void main(String[] args) {

		String text = "It is a truth universally "
				+ "acknowledged, that a single man in "
				+ "possession of a good fortune, must be "
				+ "in want of a wife."  
				+ "However little known the feelings or"
				+ " views of such a man may be on his "
				+ "first entering a neighbourhood, this "
				+ "truth is so well fixed in the minds of"
				+ " the surrounding families, that he is "
				+ "considered the rightful property of "
				+ "some one or other of their daughters.";
		int nLen = text.length();
		char[] cArrText = text.toCharArray();
		// 특정 영문자(글자) 몇개를 포함하고 있는지? (빈도수)
		int count = 0; // 글자 개수 빈도수 카운터
		char target = 'a';//'A';
		for (int i = 0; i < cArrText.length; i++) {
			if(cArrText[i] == target || cArrText[i] == target - ' ') count++; // 소문자
			
		}	
//		System.out.println(target + "문자가 발견된 회수: " + count);
		System.out.println(target + "문자가 발견된 회수: " + count);
		System.out.println("text에 포함된 총 글자수: " + nLen);
		
	}

}
