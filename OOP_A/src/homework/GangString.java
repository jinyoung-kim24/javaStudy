package homework;

import java.util.Arrays;

public class GangString {

	public static void main(String[] args) {
		String wiki1 = "The Coterel gang";
		String wiki2 = "The Coterel gang was an armed group in the English North Midlands that roamed across the countryside in the late 1320s and early 1330s, a period of political upheaval and lawlessness. Despite repeated attempts by the crown to suppress James Coterel and his band, they committed murder, extortion and kidnapping across the Peak District.";
		// gang(wiki2);

		char[] wikiNum = wiki2.toCharArray();
		for (int i = 0; i < wiki2.length(); i++) {
			if (wikiNum[i] >= 'a' && wikiNum[i] <= 'z') {
				System.out.print(wikiNum[i]);
			}
		}
		System.out.println();
		for (char i = 'a'; i <= 'z'; i++) {
			int count = 0;
			boolean flag = true;
			for (int j = 0; j < wiki2.length(); j++) {
				if (flag && i == wikiNum[j]) {
					count = (j+1);
					flag = false;
				}
			}
			if(count == 0) {
				System.out.printf("%c의 첫위치 => 없음(-1)\n", i);
			}else {
			System.out.printf("%c의 첫위치 => %d번 등장\n", i, count);
			}
		}
			

	}

	public static char[] gang(String wiki1) {
		char[] wiki = new char[wiki1.length()];
		for (int i = wiki1.length(); i > 0; i--) {
			wiki = new char[wiki1.length()];
			wiki[i - 1] = wiki1.charAt(i - 1);
			System.out.printf("'%c'(%d)\n", wiki[i - 1], (int) wiki[i - 1]);
		}
		return wiki;

	}
}
