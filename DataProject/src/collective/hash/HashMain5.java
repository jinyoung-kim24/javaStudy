package collective.hash;

import java.util.HashMap;
import java.util.Set;

public class HashMain5 {

	public static void main(String[] args) {
		// ���� Ű => ���ڿ� ��� ���� hashmap
		// https://edition.cnn.com/travel/article/cobra-superyacht-concept/index.html
		String src = "Rather than dropping in popularity, " + "superyachts have been more in demand "
				+ "than ever during global pandemic. " + "But the same can't be said for passenger"
				+ " jet airplanes. In fact, global business" + " jet deliveries dropped by 20.4% in 2020,"
				+ " while hundreds of airplanes have been " + "decommissioned, with some likely to never "
				+ "fly again.";

		// 'A' => "Airplane"
		HashMap<Character, String> hm = new HashMap<Character, String>();

		// src �� ���ڿ��� ��� �빮��ȭ�ϰ� ���� �ܾ��� �ɰ��� (split)
		String words[] = src.toUpperCase().split(" ");
		System.out.println("CNN ������� �ܾ� ��: " + words.length);
		for (String word : words) {
			System.out.println(word);
		}

		// ���ĺ� �빮�ڵ��� Ű��.... 'A' -- 'Z'
		for (char c = 'A'; c <= 'Z'; c++) { // 26��
			for (int i = 0; i < words.length; i++) {
				String word = words[i]; // �ܾ��� ù���ڰ� c�� ������?
				if (c == word.charAt(0)) {
					// �� ö��(Ű)�� �����ϴ� ù�ܾ ����Ϸ���
					if(hm.containsKey(c) == false) {
					hm.put(c, word); // 1���̻�
					}
				}
			}
			// �ش� �˹ٺ����� �����ϴ� �ܾ �ϳ��� ������
			if (hm.containsKey(c) == false) {
				hm.put(c, "____");
			}

		}
		Set<Character> keys = hm.keySet(); // ���� Ű���� ����
		for (Character c : keys) {
			System.out.printf("Ű %c => �ܾ� %s \n", c, hm.get(c));
		}
	}

}
