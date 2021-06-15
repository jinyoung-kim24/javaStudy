package text;

// �ܱ� (���۱� ����)
// https://www.gutenberg.org/ebooks/1342
// ���ٺ����� (������ ���)
// 
// �츮���� (����)
// http://projectgutenberg.kr/cate_view.php?cate_code1=02

public class WordMatch2 {

	public static void main(String[] args) {
		// https://www.gutenberg.org/files/1342/1342-h/1342-h.htm#link2HCH0001
		String text = "he" + 
				"It is a truth universally "
				+ "acknowledged, that a single man in "
				+ "possession of a good fortune, must be "
				+ "in want of a wife."  
				+ "However little known the feelings or"
				+ " views of such a man may be on his "
				+ "first entering a neighbourhood, this "
				+ "truth is so well fixed in the minds of"
				+ " the surrounding families, that he is "
				+ "considered the rightful property of "
				+ "some one or other of their daughters."
				+ "��My dear Mr. Bennet,�� said his lady to "
				+ "him one day, ��have you heard that "
				+ "Netherfield Park is let at last?��"
				+ "Mr. Bennet replied that he had not."  
				+ "��But it is,�� returned she; ��for Mrs. "
				+ "Long has just been here, and she told "
				+ "me all about it.��"
				+ "Mr. Bennet made no answer." 
				+ "��Do you not want to know who has taken it?�� "
				+ "cried his wife impatiently." 				
				+ "��You want to tell me, and I have no "
				+ "objection to hearing it.��"
				+ "This was invitation enough."  
				+ "��Why, my dear, you must know, Mrs. "
				+ "Long says that Netherfield is taken "
				+ "by a young man of large fortune "
				+ "from the north of England; that he "
				+ "came down on Monday in a chaise "
				+ "and four to see the place, and was "
				+ "so much delighted with it, that he "
				+ "agreed with Mr. Morris immediately; "
				+ "that he is to take possession before "
				+ "Michaelmas, and some of his servants "
				+ "are to be in the house by the end of "
//				+ "next week.��";
//				+ "next week.��man"; // OK
				+ "next week.��ma"; // error �񱳽� ��踦 ������
//				+ "next week.��m"; // error �񱳽� ��踦 ������
				//+ "next week.��he";
//				+ "next week.��h";
		
//		int nLen = text.length();
		
		char[] cArrText = text.toCharArray(); // 1190��?
		
		// �ܾ� ã��? 
		final String target = "man"; //"he";//"OK";//"to";//"of";
		System.out.println(">> ã�� �ܾ�: " + target); //Ű����
		//int nLen = text.length() - 2;
		int nLen = text.length() - (target.length()-1);
		
		int countWord = 0; // ã�� �ܾ��� ���� ī����
		final int NOT_FOUND = -1;
		int firstFound = NOT_FOUND; 
			// �ش� �ܾ ó�� �߰��� ������ȣ(��ġ)
//		for (int i = 0; i < cArrText.length; i++) {
		for (int i = 0; i < nLen; i++) {
			//if( cArrText[i] == target.charAt(0) )
//			if( cArrText[i+0] == 't'  //'o' 
//					&& cArrText[i+1] == 'o' ) { // 'f' ) {
			if( cArrText[i+0] == target.charAt(0)  //'o' 
					//&& cArrText[i+1] == target.charAt(1) ) { // 'f' ) {
					&& cArrText[i+1] == target.charAt(1) 
					&& cArrText[i+2] == target.charAt(2) ) {
				countWord++; // �߰�ī��Ʈ ����!!
				if( firstFound == NOT_FOUND)
					firstFound = i; // �߰� ��ġ �ε��� ���..
			}
		}
		//
		System.out.println(target + " �ܾ��� �߰�ȸ��: " + countWord);
		if( firstFound == NOT_FOUND)
			System.out.println(target + " �ܾ �����!!!");
		else
			System.out.println("\tó�� �߰ߵ� ��ġ: " + firstFound);
		
		System.out.println("he ó�� �߰��� ��ġ: " + text.indexOf(""));
		
	}
		
	
	
}





