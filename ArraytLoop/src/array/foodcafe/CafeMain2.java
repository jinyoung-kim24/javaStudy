package array.foodcafe;

public class CafeMain2 {

	public static void main(String[] args) {
		// ����ŷ, �Ƶ��ε�, ... �н�Ʈ Ǫ�� ������...
		// �ټ��� �����̸��� ����
		String strMainMenu[] = {
			"�Ұ�����", "���̹���", "���̽�����", "¡�Ź���",
			"���", "����", "�������", "ġ�����", "�ѿ����" 
		}; // 9���� ���, �迭ũ�� strMainMenu.lengrh => 9
		   // 0 ~ 8 ���� ��ȣ(�ε���)
		// �� �� ���ŵ��� ���ݵ� ����
		int nMainPrices[] = {
			990, 5000, 6000, 4500,
			4000, 7000, 990, 1500, 8000
		};
		
		// ���̵�޴��� �̸� ���� 
		String strSideMenu[] = {
			"����Ƣ��", "��������", "�ܻ�����", "�ڿ�����",
			"ġ�ƽ", "�ݶ�", "Ŀ��", new String("����"), new String("�ʰ�")
		};
		// "����" => ���ڿ� ��ü, String Ÿ���� ������

//		int nSidePrices[] = { // �迭�� ����� ���ÿ� �޸� Ȱ��, �ʱ�ȭ
//			200, 300, 400, 500,
//			600, 700, 800, 900, 1000
//		};
//		int nSidePrices[] = {0,0,0,0,0,0,0,0,0};
		int[] nSidePrices = new int[strSideMenu.length]; // 1���� �迭 ������ ����
		// �迭 �ʱ�ȭ
		for (int i = 0; i < nSidePrices.length; i++) { // 0 ~ 8 
			nSidePrices[i] = 200 + 100*i;
		}
		
		// ��º�

		printCafeMenu("���� ��", strMainMenu, nMainPrices);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printCafeMenu("���̵�޴�", strSideMenu, nSidePrices);
	}

	private static void printCafeMenu(String subTitle, String[] strMenu, int[] nPrices) {
		
		System.out.println("*" + subTitle + ":" + strMenu.length + "��");
		for (int i = 1; i <= strMenu.length; i++) {
			System.out.printf("menu%02d - %s (%5d��) ����õ\r\n", i, strMenu[i-1], nPrices[i-1]);
		}
		
	}

}
