package array.foodcafe;

public class CafeMain3 {

	public static final String NONE = ""; // ������
	
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
		// �迭 ����� ���ÿ� �޸� Ȱ�� (��� Ÿ���� �⺻������ �ڵ� �ʱ�ȭ!!)
		// int nSidePrices[] = {0,0,0,0,0,0,0,0,0}; ����
//		double[] dPrices = new double[5]; // �� ��� ���� 0.0 �ڵ��ʱ�ȭ
//		char[] cTemp = new char[5]; // �� ��Ұ��� '/0' �ڵ��ʱ�ȭ
		//String strTemp[] = new String[5]; 
			// Ŭ���� String Ÿ���� �⺻���� null�̹Ƿ�
			// 5���� �迭 ������ ���� null�� �ڵ��ʱ�ȭ
		//String strTemp[] = { null, null, null, null, null };
 		// �迭 �ʱ�ȭ
		for (int i = 0; i < nSidePrices.length; i++) { // 0 ~ 8 
			nSidePrices[i] = 200 + 100*i;
		}
		
		// �̺�Ʈ ������ �迭
		String evMainMenu[] = {
				"", "", "",
				"", "", "",
				"", "", ""
			}; // ���� �޴��� �̺�Ʈ �迭
//		final String NONE =""; // mian ��������� �Լ� �ȿ����� ��밡�� 
		String [] evSideMenu = {
				NONE, NONE, NONE,
				NONE, NONE, NONE,
				NONE, NONE, NONE
		}; // ���̵� �޴��� �̺�Ʈ �迭
		
		
		// ������ �޴��� ����: �̺�Ʈ ��� ���Ÿ� ����
		// �Ұ�� ���� ���±�� 1+1 �̺�Ʈ (490������������)
		nMainPrices[0] = 490;
		evMainMenu[0] = "���±�� 1+1 �̺�Ʈ";
		// 7. ġ����Ÿ� ������ Ʈ���� ġ����� �� ��� ��ñ�� 1000�� �̺�Ʈ
		strMainMenu[7] = "Ʈ������������";
		nMainPrices[7] = 1000;
		evMainMenu[7] = "��ñ�� 6900 -> 1000�� �̺�Ʈ";
		// 2. �ܻ����带 ��ġ���ܻ����� ������ 100�� Ȱ��
		strSideMenu[2] = "��ġ���ܻ�����";
		nSidePrices[2] -= 100;
		evSideMenu[2] = "��Ī��� ���� 100�� ����!!";
		
		
		// ��º�
		System.out.println("=== MY CAFE ===");
		printCafeMenu("���� ��", strMainMenu, nMainPrices, evMainMenu);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printCafeMenu("���̵�޴�", strSideMenu, nSidePrices, evSideMenu);
	}
	// �Լ� �����ε� ( Overloading)
	// �̺�Ʈ ����Ҽ� �ִ� ����� �߰���..
	private static void printCafeMenu(String subTitle, String[] strMenu, int[] nPrices, String[] evMenu) {
		
		System.out.println("*" + subTitle + ":" + strMenu.length + "��");
		String event = "";//"�� ����õ";
		
		for (int i = 0; i < strMenu.length; i++) {
			if(evMenu[i] != NONE) event = "��" + evMenu[i] + "��";
			else event = "�� ����õ";
			System.out.printf("menu%02d - %s (%5d��) %s \r\n", i, strMenu[i], nPrices[i], event);
		}
		
	}
	
	private static void printCafeMenu(String subTitle, String[] strMenu, int[] nPrices) {
		
		System.out.println("*" + subTitle + ":" + strMenu.length + "��");
		for (int i = 1; i <= strMenu.length; i++) {
			System.out.printf("menu%02d - %s (%5d��) ����õ\r\n", i, strMenu[i-1], nPrices[i-1]);
		}
		
	}

}
