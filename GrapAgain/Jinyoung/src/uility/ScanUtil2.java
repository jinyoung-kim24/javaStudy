package uility;
// ���� ��ɵ��� ���� Ŭ������ �и��Ͽ� ���� 

import java.util.Scanner;

// ��ĳ�� ���� ��� �Լ��� ��Ƶ� ��ƿ��Ƽ Ŭ���� 
public class ScanUtil2 {

	// ��ĳ�ʷ� ���� �Է� �޾ƿ��� �Լ�
	// ScanUtil.userInputToInt("OOOO"); ȣ��
	//private static int userInputToInt(String msg) {
	public static int userInputToInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int year = sc.nextInt();
		//sc.close();
		return year;
	}
	
	// �Լ� �����ε� ����
	// ��ĳ�ʷ� ���� �Է� �޾ƿ��µ� '����'���� min ~ max������ �޾ƿ��� �����Է� �Լ�
	// ����� ������ ó���� �� �ִ� �Լ�
	public static int userInputToInt(
			String msg, int min, int max) {
		if(min > max) {
			System.out.println("min > max �Է� ����!!!");
			return -99999999;
		}  // ���� �Է� ���� ���͸�......
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		while( true ) {
			System.out.println(msg);
			input = sc.nextInt();
			// �������(min�̻�... max����)
			if( input >= min && input <= max ) break;
		}
		return input; // min ~ max
	}
}


