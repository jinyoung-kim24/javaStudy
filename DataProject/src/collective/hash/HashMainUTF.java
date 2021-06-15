package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMainUTF {

	public static void main(String[] args) {
		// ÇÑ±Û ¹®ÀÚ ¸®½ºÆ®?
		ArrayList<Character> cList1
						= new ArrayList<>();
		for(char c = '°¡'; c <= 'ÆR'; c++ ) {
//			cList1.add( new Character(c));
			cList1.add(c);
		}
//		for (int i = 0; i < cList1.size(); i++) {
//			System.out.print(cList1.get(i) +" ");
//			if( (i + 1) % 10 == 0)
//				System.out.println();
//		}
		
		// ¿µ¿õÆÀ¸Ê: ¸ÊÀÇ ¿ä¼Ò°¡ ¸®½ºÆ®ÀÎ °æ¿ì
		// ¸®½ºÆ®ÀÇ ¿ä¼Ò°¡ ¸ÊÀÎ °æ¿ì..?
		
		// ¹®ÀÚ¿­Å°  => ¹®ÀÚ¹ë·ù ¸ÊÀ» Ç¥Çö 
		// ¸®½ºÆ®ÀÇ ¿ä¼Ò·Î½á ÀÌ ¸ÊÀ» ¼ø¼­´ë·Î ÀúÀå.
		
		// ¿µ¹® ¹®ÀÚ¸Ê(?) ¸®½ºÆ®
		// ¿µ¹® ¹®ÀÚ¸Ê °´Ã¼ ¿ä¼ÒÀÇ Å°´Â String°ªÀº ¸ðµåÀÌ¸§
		//		https://www.compart.com/en/unicode/U+0041
		// 		¿µ¹® ´ë¹®ÀÚ UPPER ¸ðµå,  
		//  	https://www.compart.com/en/unicode/U+0061
		//		¿µ¹® ¼Ò¹®ÀÚ LOWER ¸ðµå...
		//		https://www.compart.com/en/unicode/U+24B6
		// 		¿µ¹® ¼­Å¬¹®ÀÚ CIRCLE ¸ðµå...
		//		https://www.compart.com/en/unicode/U+212B
		//		??
		//		https://www.compart.com/en/unicode/U+1F130
		//		¿µ¹® ½ºÄù¾î¹®ÀÚ SQUARE ¸ðµå...
		
		ArrayList<HashMap<String,Character>>
			cList2 = new ArrayList<>();
		
		// ¿µ¹® ´ë¹®ÀÚ Å½»ö ·çÇÁ A ~ Z
//		for (char c = 0; c <= 25; c++) {
		for (char c = 'A'; c <= 'Z'; c++) {
			HashMap<String,Character>
			 eng = new HashMap<String,Character>();
			eng.put("UPPER", c); // 'A'
			eng.put("LOWER", (char)(c+' ')); // 'a' = 'A' + 32
			//
			eng.put("CIRCLE", (char)(0x24B6+c-'A'));
			eng.put("ETC", (char)(0x212B+c-'A'));
			cList2.add(eng);
		}
		
		// ¸ðµåº° Ãâ·Â
		final String modeKey = "UPPER";
		for (int i = 0; i < cList2.size(); i++) {
			HashMap<String, Character> c
							= cList2.get(i);
			System.out.print(c.get(modeKey));
		}
		System.out.println();
		final String modeKey2 = "LOWER";
		for (int i = 0; i < cList2.size(); i++) {
			HashMap<String, Character> c
							= cList2.get(i);
			System.out.print(c.get(modeKey2));
		}
		System.out.println();
		final String modeKey3 = "CIRCLE";
		for (int i = 0; i < cList2.size(); i++) {
			HashMap<String, Character> c
							= cList2.get(i);
			System.out.print(c.get(modeKey3));
		}
		System.out.println();
		final String modeKey4 = "ETC";
		for (int i = 0; i < cList2.size(); i++) {
			HashMap<String, Character> c
							= cList2.get(i);
			System.out.print(c.get(modeKey4));
		}
		System.out.println();
		
	}

}