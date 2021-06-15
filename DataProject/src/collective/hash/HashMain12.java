package collective.hash;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class HashMain12 {

	public static void main(String[] args) {
		// 설정사항(preferences)을 맵으로 표현하기
		// 설정맵은 보통 문자열키 => 문자열밸류로 적용...
		// Setting, preferences, Configuations,
		// system.ini 초기설정파일? fonts.ini 파일
		
//		HashMap<String, String> config = new HashMap<>();
		// 폰트 설정의 예... myFonts.ini 파일로 예
//		config.put("설정이름", "설정값");
//		config.put("font-family", "Arial"); // ttf
//		config.put("font-unit", "pt");
//		config.put("font-size", String.valueOf(200));
//		config.put("font-size", "" + 120);
//		config.put("font-weight", "bold");
//		config.put("font-file", "c:/system/fonts/Arial.ttf");
		
		// HashTable의 하위 클래스
		Properties config = new Properties();
		// 문자열키 => 문자열밸루로 적용
		// setProperty(), getProperty();
		config.setProperty("font-family", "Arial");
		config.setProperty("font-unit", "pt");
		config.setProperty("font-size", String.valueOf(200));
		config.setProperty("font-size", "" + 120);
		config.setProperty("font-weight", "bold");
		config.setProperty("font-file", "c:/system/fonts/Arial.ttf");
		//
		final String TARGET_FONT_CONF = "font-size";
		int swApplyFontSize = 0;
		final int DEF_FONT_SIZE = 12;
		if(config.containsKey(TARGET_FONT_CONF) == true) {
			// 설정파일에 폰트크기 설정이 되어있다면
			if(config.getProperty(TARGET_FONT_CONF) != null &&
					!config.getProperty(TARGET_FONT_CONF).isEmpty())
				swApplyFontSize = Integer.parseInt(config.getProperty(TARGET_FONT_CONF));
		} else { // 해당설정이 없다면
			swApplyFontSize = DEF_FONT_SIZE;			
		}
		// sw에 설정 적용하기
		System.out.println("=== 사용자 폰트 설정 ===");
		System.out.println(">> 폰트설정 - size: " + swApplyFontSize);
		
		// properties 설정의 내용을 열거해 보자
		// iteration? Enumeration? 열거형 
		// 컬렉션에서 가져올 다음 요소가 있는지? 체크? hashMoreElements()
		// 있다면 그 요소값을 가져와 리턴 nextElement()
		Enumeration<String> keys = (Enumeration<String>) config.propertyNames();
		// hashmap.ketSet() 키집합? 키열거형객체
		
		while(keys.hasMoreElements() == true) {
			String key = keys.nextElement();
			String value = config.getProperty(key);
			System.out.println(key + " => " + value);
		}
		System.out.println("키 목록 열거 끝");
		
		
	}

}
