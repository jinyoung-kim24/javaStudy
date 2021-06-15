package collective.hash;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class HashMain12 {

	public static void main(String[] args) {
		// ��������(preferences)�� ������ ǥ���ϱ�
		// �������� ���� ���ڿ�Ű => ���ڿ������ ����...
		// Setting, preferences, Configuations,
		// system.ini �ʱ⼳������? fonts.ini ����
		
//		HashMap<String, String> config = new HashMap<>();
		// ��Ʈ ������ ��... myFonts.ini ���Ϸ� ��
//		config.put("�����̸�", "������");
//		config.put("font-family", "Arial"); // ttf
//		config.put("font-unit", "pt");
//		config.put("font-size", String.valueOf(200));
//		config.put("font-size", "" + 120);
//		config.put("font-weight", "bold");
//		config.put("font-file", "c:/system/fonts/Arial.ttf");
		
		// HashTable�� ���� Ŭ����
		Properties config = new Properties();
		// ���ڿ�Ű => ���ڿ����� ����
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
			// �������Ͽ� ��Ʈũ�� ������ �Ǿ��ִٸ�
			if(config.getProperty(TARGET_FONT_CONF) != null &&
					!config.getProperty(TARGET_FONT_CONF).isEmpty())
				swApplyFontSize = Integer.parseInt(config.getProperty(TARGET_FONT_CONF));
		} else { // �ش缳���� ���ٸ�
			swApplyFontSize = DEF_FONT_SIZE;			
		}
		// sw�� ���� �����ϱ�
		System.out.println("=== ����� ��Ʈ ���� ===");
		System.out.println(">> ��Ʈ���� - size: " + swApplyFontSize);
		
		// properties ������ ������ ������ ����
		// iteration? Enumeration? ������ 
		// �÷��ǿ��� ������ ���� ��Ұ� �ִ���? üũ? hashMoreElements()
		// �ִٸ� �� ��Ұ��� ������ ���� nextElement()
		Enumeration<String> keys = (Enumeration<String>) config.propertyNames();
		// hashmap.ketSet() Ű����? Ű��������ü
		
		while(keys.hasMoreElements() == true) {
			String key = keys.nextElement();
			String value = config.getProperty(key);
			System.out.println(key + " => " + value);
		}
		System.out.println("Ű ��� ���� ��");
		
		
	}

}
