package uility;
// ���� ��ɵ��� ���� Ŭ������ �и��Ͽ� ���� 

import java.util.Scanner;

// ��ĳ�� ���� ��� �Լ��� ��Ƶ� ��ƿ��Ƽ Ŭ���� 
public class ScanUtil {

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
		if( min > max )	{
			System.out.println("min > max �Է� ����!!!");
			return -99999999;
		}	// ���� �Է� ���� ���͸�....	
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
	
	// ���� �Է� ��, min < max �Լ�...
	public static int userInputToIntInRange(
			String msg, int min, int max) {
		if( min > max )	{
			System.out.println("min > max �Է� ����!!!");
			return -99999999;
		}	// ���� �Է� ���� ���͸�....	
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		//while( true ) {
		// �� 1���� ���� ������ �����ϴ� �ݺ��� do ~ while()��. 
		// �ϴ� 1�� �����ϰ�..������ ���ǽ��� ���� �ݺ��������� ������. 
//		do {
//			System.out.println(msg);
//			input = sc.nextInt();
//			// �������(min�̻�... max����)
//			if( input >= min && input <= max ) break;
//		} while(true);
		
		do {
			System.out.println(msg);
			input = sc.nextInt();
			// �������(min�̻�... max����)
			//if( input >= min && input <= max ) break;
		} while(!(input >= min && input <= max)); // ����ƴ�.
//		} while( (input >= min && input <= max) == false); // ����ƴ�.
		// !true == false, true == !false
		//} while(input < min || input > max); // ����ƴ�..
		//} while(input >= min && input <= max); // ����
		
		return input; // min ~ max
	}
	
	
	public static int userInputToIntInRange2(
			String msg, int min, int max) {
		if( min > max )	{
			System.out.println("min > max �Է� ����!!!");
			return -99999999;
		}		
		int input = 0;				
		do {			
			input = userInputToInt(msg);			
		} while(!(input >= min && input <= max)); // ����ƴ�.
		return input; // min ~ max
	}
	
	public static int userInputToIntInRange3(
			String msg, int min, int max) {
		if( min > max )	{
			System.out.println("min > max �Է� ����!!!");
			return -99999999;
		}		
		if( min <= 0 ) {
			System.out.println("�ּ� 1���� �����Ͻ���.");
			return -1;
		}
		int input = 0;				
		do {			
			input = userInputToInt(msg);
			if( input == 0 ) return 0; //System.exit(0);
		} while(!(input >= min && input <= max)); // ����ƴ�.
		return input; // min ~ max
	}
	// ������� Ű���� �Է��� ��ĳ�ʷ� �ܾ� ���ڿ��� �޾Ƽ� �����ϴ� �Լ�
	public static String userInputToString(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}
}


