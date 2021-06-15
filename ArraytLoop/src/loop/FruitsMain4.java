package loop;

//import utility.*; // �ش� ��Ű���� �ִ� ��� Ŭ�������� ��밡����.
import uility.ScanUtil;

public class FruitsMain4 {

	public static void main(String[] args) {
		// '���� �̸�' �迭 ǥ�� (��� Ÿ�� => "" ���ڿ���)
//		String fruitNames[]; // �迭 ����.
//		String[] fruitNames;
//		String []fruitNames = {}; 
		// ���� 0�� empty array ��迭. �����ü�� �ϳ��� ����...
		String fruitNames[] = { // �迭 ���� �� �ʱ�ȭ
			"���", "����", "������", "�ڸ�", "���",
			"�ٳ���", "���ξ���", "�챸", "������", "�ڵ�"
		}; // length ���� 10�� �����̸����� �迭; index 0 ~ 9���� ���ٵ�.
//		String fruitFlavors[] = {	
//			"������", "������", "��ŭ��", "��ŭ��", "������", 
//			"�ູ��", "�����" 
//		};
		
		//String userName = "�浿";
		String userName = 
			ScanUtil.userInputToString("����� �̸�: ");
		
		int frName = (int)(Math.random()*fruitNames.length);
		String fruit = fruitNames[frName];
		
		userEatsFruit("ȫ�浿", "ü��");
		userEatsFruit(userName, fruit);
		userEatsFruit(userName, fruitNames[0]); // "���"
		
//		String flavor = 
//			fruitFlavors[(int)(
//				Math.random()*fruitFlavors.length)]; // 0 ~ 6
//		System.out.println(userName + "��/�� " 
//				//+ "������ " + "������/��" + " �Դ´�.");
//				//+ "������ " + fruit + "��/��" + " �Դ´�.");
//				+ flavor + " " + fruit + "��/��" + " �Դ´�.");
	}

	// ���� �迭 ��� ���� (���α׷� ���ۺ��� ������ ����..)
	public static final String[] FRUIT_FLAVORS = {	
			"������", "������", "��ŭ��", "��ŭ��", "������", 
			"�ູ��", "�����" 
	};
	
	
	private static void userEatsFruit(
			String userName, String fruitName) {
//		String fruitFlavors[] = {	
//				"������", "������", "��ŭ��", "��ŭ��", "������", 
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