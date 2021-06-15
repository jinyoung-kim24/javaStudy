package text;

public class TextMain5 {
	// String[] ¹®ÀÚ charÀÇ ±âÁØÀ¸·Î º¸¸é 2Â÷¿ø¹è¿­°ú ±¸Á¶°ú ºñ½Á..
	public static void main(String[] args) {

		String input = "±ÔÁø¾¾°¡ English·Î «¢«¤¸¦ ¿ÜÃÆ´Ù~~!";
		// "abcdeXYZJQK012789 -+*/%$@&^°¡³ª´Ù«¢«¨«¤«ª«¦";

		if (args.length == 0) {
			// printStringInformation(input);
			printStringInformation(input);
		}else { // length > 0 ¹®ÀÚ¿­ ·çÇÁ
			for (int i = 0; i < args.length; i++) {
				String word =args[i];
				System.out.println("--- " + i + "¹øÂ° word: " + word);
				printStringInformation(word);
				System.out.println("_______________________________");
			}
		}
	}

	private static void printStringInformation(String input) {
		final int cntInput = input.length(); // À¯´ÏÄÚµå ±ÛÀÚ °³¼ö
		System.out.println("cntInput = " + cntInput);

		for (int i = 0; i < input.length(); i++) { // 0 ~ 34
			char c = input.charAt(i);
			if (isKorean(c) == true)
				System.out.println(c + "¹®ÀÚ´Â ÇÑ±¹¾î ±ÛÀÚÀÔ´Ï´Ù.");
			else if (isEngUpper(c))
				System.out.println(c + "¹®ÀÚ´Â ¿µ¾î ´ë¹®ÀÚ ÀÔ´Ï´Ù.");
			else if (isEngLower(c))
				System.out.println(c + "¹®ÀÚ´Â ¿µ¾î ¼Ò¹®ÀÚ ÀÔ´Ï´Ù.");
			else if (isNumeric(c))
				System.out.println(c + "¹®ÀÚ´Â ¼ýÀÚ ¹®ÀÚ ÀÔ´Ï´Ù.");
			else if (isJapanese(c))
				System.out.println(c + "¹®ÀÚ´Â ÀÏº»¾î °¡³ª¹®ÀÚ ÀÔ´Ï´Ù.");
			else if (isSpaceBar(c))
				System.out.println(c + "¹®ÀÚ´Â °ø¹é ±âÈ£ ¹®ÀÚÀÔ´Ï´Ù");
			else
				System.out.println(c + "¹®ÀÚ´Â ±âÅ¸ ¹®ÀÚÀÔ´Ï´Ù");
		}

	}

	// ¹®ÀÚ ÆÇº°ÇÏ´Â ÇÔ¼öµé
	// ½ºÆäÀÌ½º¹Ù ¹®ÀÚÀÎÁö?
	public static boolean isSpaceBar(char c) {
		return c == ' '; // c == 32
	}

	// ¼ýÀÚ ¹®ÀÚÀÎÁö?
	public static Boolean isNumeric(char c) {
		return c >= '0' && c <= '9';
	}

	// ¿µ¹® ´ë¹®ÀÚÀÎÁö?
	public static boolean isEngUpper(char c) {
		return c >= 'A' && c <= 'Z';
	}

	// ¿µ¹® ¼Ò¹®ÀÚÀÎÁö?
	public static boolean isEngLower(char c) {
		return c >= 'a' && c <= 'z';
	}

	// ÇÑ±Û ¹®ÀÚÀÎÁö?
	public static boolean isKorean(char c) { // unicord.org
		return c >= '°¡' && c <= 'ÆR';
	} // AC00 ~ D7AF
	// ÀÏº»¾î(¿Ü±¹¾î) ¹®ÀÚÀÎÁö?

	public static boolean isJapanese(char c) {
		return c >= 0x3041 && c <= 0x30FF;
	}

}
