package text.korean;

import text.UnicodeMain;
/*
 * µµ½ºÃ¢ ÄÜ¼Ö ½ÇÇà
 *  
 *   cd, dir, cd .., type, cls, java ÄÜ¼Ö ¸í·É ½ÇÇà

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain > hangul.txt

C:\dev2021\java_ws\DataTypes\bin>java text.korean.HangulMain > ÇÑ±ÛÄÚµå.txt

 */
public class HangulMain {

	public static void main(String[] args) {
		final char hSTART = '°¡'; // ¹®ÀÚ»ó¼ö
		final char hEND = 'ÆR'; // 0xD7A3
		char hangul = hSTART;// '°¡'; // 0xAC00 == ?
		
		// ÇÑ±Û ¹®ÀÚ ÃÑ°³¼ö
		//final int TOTAL_HANGULS = 0xD7A3 - 0xAC00 + 1; 
		final int TOTAL_HANGULS = 'ÆR' - '°¡' + 1; // 11172°³
		// '°¡' => 1¹øÂ° ¹®ÀÚ, 'ÆR' => 11172¹øÂ° ¹®ÀÚ
		
		boolean flag = true;
		int order = 0; // Ä«¿îÅÍº¯¼ö ÃÊ±âÈ­ (·çÇÁ¸¦ ÁøÇàÇÏ¸é¼­ º¯È­µÇ´Â ±âÁØ)
		while(flag == true) { // ¹İº¹±¸°£ ·çÇÁ ½ÃÀÛ
			//order = order + 1;
			order++; // ¼ø¼­ º¯È­..
			System.out.printf("order %d: ", order );
//			System.out.printf(" => %c (%d, 0x%X) \n",
//						hangul, (int)hangul, (int)hangul);
			UnicodeMain.printCharWithCode(hangul);
			// publicÀ¸·Î µÇ¾îÀÖ´Â ´Ù¸¥ Å¬·¡½ºÀÇ ÇÔ¼ö´Â ÀÌÁ¦ ºÒ·¯¼­ »ç¿ëÀÌ °¡´ÉÇÔ.
			
			// ·çÇÁ Á¾·á Á¶°Ç 
			if( order == TOTAL_HANGULS ) flag = false;
			hangul = (char) (hangul + 1);
//			if( hangul == hEND ) flag = false; // 'ÆR'??? »ı°¢²¨¸®!!
		} // ¹İº¹±¸°£ ·çÇÁ ³¡
		System.out.println("À¯´ÏÄÚµå ÇÑ±Û Ãâ·Â loop Á¾·á!!!");
	}

}
