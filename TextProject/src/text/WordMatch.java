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
		// Ư�� ������(����) ��� �����ϰ� �ִ���? (�󵵼�)
		int count = 0; // ���� ���� �󵵼� ī����
		char target = 'a';//'A';
		for (int i = 0; i < cArrText.length; i++) {
			if(cArrText[i] == target || cArrText[i] == target - ' ') count++; // �ҹ���
			
		}	
//		System.out.println(target + "���ڰ� �߰ߵ� ȸ��: " + count);
		System.out.println(target + "���ڰ� �߰ߵ� ȸ��: " + count);
		System.out.println("text�� ���Ե� �� ���ڼ�: " + nLen);
		
	}

}
