package loop;

//import utility.*; // �ش� ��Ű���� �ִ� ��� Ŭ�������� ��밡����.
import uility.ScanUtil;

public class FruitsMain6 {

	public static void main(String[] args) {
		// '���� �̸�' �迭 ǥ�� (��� Ÿ�� => "" ���ڿ���)
		// �ѱ���
		String fruitNamesKr[] = { // �迭 ���� �� �ʱ�ȭ
			"���", "����", "������", "�ڸ�", "���",
			"�ٳ���", "���ξ���", "�챸", "������", "�ڵ�"
		}; // length ���� 10�� �����̸����� �迭; index 0 ~ 9���� ���ٵ�.
		// ����
		String fruitNamesEn[] = { 
			"melon", "watermelon", "orange", "grapefruit", "apple",
			"banana", "pineapple", "apricot", "peach", "plum"
			,"cherry", "strawberry", "blueberry"
		}; // 0 ~ 12 ������ȣ
		
		int lang = ScanUtil.userInputToIntInRange(
				"���� (1. �ѱ���,  2. ����)"
			+ " / Select language (1. Kr, 2. En): ", 1, 2);
			
			String msg = (lang == LANG_KR) ? "����� �̸��� �Է��ϼ���: "
					: "Insert user's name in English: ";
			String userName =					
					ScanUtil.userInputToString(msg);
			
			int len = (lang == LANG_EN) ? fruitNamesEn.length : fruitNamesKr.length;
			int frName = (int)(Math.random()* len); // 10
			
			userEatsFruit(userName, (lang == LANG_KR) ? fruitNamesKr[frName] : fruitNamesEn[frName]);
//		if( lang == LANG_KR ) { // KR
//			String userName = 
//				ScanUtil.userInputToString("����� �̸��� �Է��ϼ���: ");
//			int frName = (int)(Math.random()*fruitNamesKr.length); // 10
//			if( frName >= 0 && frName <= 9 )
//				userEatsFruit(userName, fruitNamesKr[frName]);
//		} else { // EN
//			String userName = 
//				ScanUtil.userInputToString("Insert user's name in English: ");
//			int frName = (int)(Math.random()*fruitNamesEn.length); // 13
//			userEatsFruit(userName, fruitNamesEn[frName]);
//		}
	}

	// ���� ��� ��� ����
	public static final int LANG_KR = 1;
	public static final int LANG_EN = 2;
	
	// ���� �迭 ��� ���� (���α׷� ���ۺ��� ������ ����..)
	public static final String[] FRUIT_FLAVORS = {	
			"������", "������", "��ŭ��", "��ŭ��", "�����", 
			"�ູ��", "�����" 
	};	
	
	private static void userEatsFruit(
			String userName, String fruitName) {
//		String fruitFlavors[] = {	
//				"������", "������", "��ŭ��", "��ŭ��", "�����", 
//				"�ູ��", "�����" 
//		};
		String flavor = 
				FRUIT_FLAVORS[(int)(
			Math.random()*FRUIT_FLAVORS.length)]; // 0 ~ 6
		System.out.println(userName + "��/�� " 
			//+ "������ " + "������/��" + " �Դ´�.");
			//+ "������ " + fruit + "��/��" + " �Դ´�.");
			+ flavor + " " + fruitName + "��/��" + " �Դ´�.");		
	}

}