package collective.hash;

import java.util.HashMap;
import java.util.Set;

public class HashMain5 {

	public static void main(String[] args) {
		// 문자 키 => 문자열 밸류 대응 hashmap
		// https://edition.cnn.com/travel/article/cobra-superyacht-concept/index.html
		String src = "Rather than dropping in popularity, " + "superyachts have been more in demand "
				+ "than ever during global pandemic. " + "But the same can't be said for passenger"
				+ " jet airplanes. In fact, global business" + " jet deliveries dropped by 20.4% in 2020,"
				+ " while hundreds of airplanes have been " + "decommissioned, with some likely to never "
				+ "fly again.";

		// 'A' => "Airplane"
		HashMap<Character, String> hm = new HashMap<Character, String>();

		// src 긴 문자열을 모두 대문자화하고 이후 단어들로 쪼개기 (split)
		String words[] = src.toUpperCase().split(" ");
		System.out.println("CNN 뉴스기사 단어 수: " + words.length);
		for (String word : words) {
			System.out.println(word);
		}

		// 알파벳 대문자들이 키들.... 'A' -- 'Z'
		for (char c = 'A'; c <= 'Z'; c++) { // 26번
			for (int i = 0; i < words.length; i++) {
				String word = words[i]; // 단어의 첫글자가 c와 같은지?
				if (c == word.charAt(0)) {
					// 이 철자(키)로 시작하는 첫단어만 기억하려면
					if(hm.containsKey(c) == false) {
					hm.put(c, word); // 1번이상
					}
				}
			}
			// 해당 알바벳으로 시작하는 단어가 하나도 없을때
			if (hm.containsKey(c) == false) {
				hm.put(c, "____");
			}

		}
		Set<Character> keys = hm.keySet(); // 문자 키들의 집합
		for (Character c : keys) {
			System.out.printf("키 %c => 단어 %s \n", c, hm.get(c));
		}
	}

}
