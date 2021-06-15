

package array.foodcafe;

import java.util.Scanner;

import uility.ScanUtil;

public class CafeMain3_7 {
	
	public static final String NONE = ""; // ������ 

	public static void main(String[] args) {
		// ����ŷ, �Ƶ��ε�, ... �н�ƮǪ�� ������..
		// �� ���� �����̸���
		String strMainMenu[] = {
			"�Ұ�����", "���̹���", "���̽�����", "¡�Ź���",
			"���", "����", "�������", "ġ�����", "�ѿ����"
		}; 	// 9�� ���, �迭ũ��  strMainMenu.length => 9
			// 0 ~ 8 ������ȣ(�ε���)
		// �� ���� ���ŵ��� ���ݵ�
		int nMainPrices[] = {
			990, 5000, 6000, 4500,
			4000, 7000, 990, 1500, 8000
		};
		
		// ���̵�޴��� �̸�
		String strSideMenu[] = {
			"����Ƣ��", "��������", "�ܻ�����", "�ڿ�����", 
			"ġ�ƽ", "�ݶ�", "Ŀ��", 
			new String("����"), new String("�ʰ�")  
		};
		
		int[] nSidePrices = new int[strSideMenu.length]; // 1���� �迭 ������ ���� new int[strSideMenu.length]; // 1���� �迭 ������ ����

		// �迭 �ʱ�ȭ
		for (int i = 0; i < nSidePrices.length; i++) { //0 ~ 8
			nSidePrices[i] = 200 + 100*i;
		}
		
		// �̺�Ʈ ������ �迭
		String []evMainMenu = { 
				"","","",
				"","","",    
				"","",""
		}; // ���� �޴��� �̺�Ʈ �迭
		//final String NONE = ""; // main() ��������� �Լ� �ȿ����� ����.
		String[] evSideMenu = { 
				NONE,NONE,NONE,
				NONE,NONE,NONE,
				NONE,NONE,NONE 
		}; // ���̵� �޴��� �̺�Ʈ �迭 
		
		// ������ �޴��� ����: �̺�Ʈ ��� ���Ÿ� ����...
		// 0.�Ұ����� ���±�� 1+1 �̺�Ʈ (490������������!!)
		nMainPrices[0] = 490;
		evMainMenu[0] = "���±�� 1+1 �̺�Ʈ";
		// 7.ġ����Ÿ� ������ 'Ʈ����ġ�����'�� ���.. 
		//   ��ñ�� 6900 -> 1000�� �̺�Ʈ!
		strMainMenu[7] = "Ʈ����ġ�����";
		nMainPrices[7] = 1000;
		evMainMenu[7] = "��ñ�� 6900 -> 1000�� �̺�Ʈ";
		// 2.�ܻ����带 ��ġ���ܻ�����... ��Ī��� ���� -100����! 
		strSideMenu[2] = "��ġ���ܻ�����";
		nSidePrices[2] -= 100;
		//nSidePrices[2] = nSidePrices[2] - 100; 
		evSideMenu[2] = "��Ī��� ���� -100����!";
		
//		// �޴� ��º�
//		System.out.println("=== MY CAFE ===");		
//		printCafeMenu("���� ��", strMainMenu, 
//					nMainPrices, evMainMenu);
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		printCafeMenu("���ִ� ���̵�", 
//			strSideMenu, nSidePrices, evSideMenu);
		
		// �޴� �ֹ���
		// ���θ޴� 1��, �߰������� ���̵� 1~3��... �� 4������
		final int NO_SEL = 0; // �ֹ��� ���� ����
		// menuOrders �ֹ����¹迭(�ֹ����� ���� ��ȣ ����ϴ� ��)
		int menuOrders[] = new int[4]; // 0���� 4�� ���� �ڵ��ʱ�ȭ
			//{ NO_SEL, NO_SEL, NO_SEL, NO_SEL }; 
			//{ ����, ���̵�, ���̵�, ���̵� };
		int order = 0; // �ֹ�ȸ�� ī���� 
		// �ֹ� ����
		Scanner sc = new Scanner(System.in);
		do {
			if(order > 0) { // Ȥ�� ���̵� �߰����� �ƴϸ� �ֹ� ��������
				int goStop = ScanUtil.userInputToIntInRange(
						"�߰�1. ���̵� �ֹ��ϽǷ���? �ƴϸ�2. ����?", 1, 2);
				if(goStop == 2) break;
			}
			// �� ó��.. ���� �� �� �� �ֹ� �ޱ� menuOrders[0]�� ���..
//			System.out.print(">> �޴��� �����ϼ���: ");
//			int menu = sc.nextInt();
			if(order == 0)
				printCafeMenu("���� ��", strMainMenu, 
						nMainPrices, evMainMenu);
			else
				printCafeMenu("���ִ� ���̵�", 
						strSideMenu, nSidePrices, evSideMenu);
			System.out.println("---------------------------------");
			String mtype = order == 0 ? "���� " : "���̵�";
			int menu = ScanUtil
				.userInputToIntInRange(
						">>"+ mtype+"�޴��� �����ϼ���: ", 1, strMainMenu.length);
			//menuOrders[0] = menu;
			menuOrders[order] = menu;
			order++;			
			if( order == menuOrders.length ) break;
		} while(true);
		//} while(order == menuOrders.length);
		System.out.println("=== �ֹ��� �����մϴ�. ===");
		
		for (int i = 0; i < menuOrders.length; i++) {
			if(menuOrders[i] == NO_SEL) continue; //break;
			System.out.println("�޴�: " + menuOrders[i]);
		}
	}
	// �Լ� �����ε� (Overloading)
	// �̺�Ʈ ����� �� �ִ� ����� �߰���..
	private static void printCafeMenu(
			String subTitle, String[] strMenu, 
			int[] nPrices, String[] evMenu) {
		System.out.println("* "+subTitle+": "
					+ strMenu.length+"��");
		//String event = "";  //"�� �� ��õ"; 
		
		for (int i = 0; i < strMenu.length; i++) {
			String event = (!evMenu[i].isEmpty()) ?
					"�� " + evMenu[i] + " ��"  :  "�� �� ��õ"; 
			System.out.printf(
				"menu%02d - %s (%5d��) %s \r\n", i+1, 
				strMenu[i], nPrices[i], event );
		}
	}	
	private static void printCafeMenu(
		String subTitle, String[] strMenu, int[] nPrices) {
		System.out.println("* "+subTitle+": "
					+ strMenu.length+"��");
		for (int i = 1; i <= strMenu.length; i++) {
			System.out.printf(
				"menu%02d - %s (%5d��) �� ��õ \r\n", i, 
				strMenu[i-1], nPrices[i-1] );
		}		
	}
}