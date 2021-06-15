package year;

import java.util.Scanner;
import uility.ScanUtil;

// ���� �Ǵ�...
// Leap year
/*
https://ko.wikipedia.org/wiki/%EC%9C%A4%EB%85%84
 
 ���� �Ǵ� �˰��� Algorithm
 
�׷������� ��Ȯ�� ���� ��Ģ�� ������ ����.

���� ��� ������ 004�� ������ �������� �ش� �������� �Ѵ�. (1984��, 1988��, 1992��, 1996��, 2004��, 2008��, 2012��, 2016��, 2020��, 2024��, 2028��, 2032��, 2036��, 2040��, 2044�� ...)
���� ��� ������ 004, 100���� ������ �������� �ش� ������� �Ѵ�. (1900��, 2100��, 2200��, 2300��, 2500��...)
���� ��� ������ 004, 100, 400���� ������ �������� �ش� �������� �д�. (2000��, 2400��...)

*/

public class YearMain5 {
	
	public static final String NONAME = ""; // empty string ���ڿ�
	public static final String LEAP_YEAR = "����";
	public static final String COMMON_YEAR = "���";
	public static final String YEAR_INPUT_MSG
		= "���� �Ǵܿ� �⵵ �Է�(1900~2400): ";
	
	public static void main(String[] args) {
		// ���� �Ǵ� ���α׷�
		int c = 0; // counter
		//final int LIMIT_YEARS = 4;
		final int LIMIT_YEARS = 
				ScanUtil.userInputToIntInRange3(
						">> ������ �⵵�� ������ �Է�(�ݺ�ȸ��1~10 �� 0�̸� ����) :", 1, 10);
		if(LIMIT_YEARS == 0) {
			// ���� ����, ��� , �ʱ�ȭ
			System.out.println("���� �Ǵ� ���α׷� EXIT");
			return; // ���α׷� ����
		}
		
		//while(c < LIMIT_YEARS) { // c�� 0 ~ 3���� ����, 4���� ����.
		do {
			
			c += 1;
			int year  = 
					ScanUtil.userInputToIntInRange2(
					"["+c+" ȸ��] ���� �Ǵܿ� �⵵ �Է�(1900~2400):"
							, 1900, 2400); // 1900~2400	
			System.out.printf(
					">> �ش� %4d�⵵�� '%c��' �Դϴ�.\n", 
					year, (isLeapYear(year) ? '��': '��') );
		}while(c < LIMIT_YEARS);
		
		System.out.println(" c = " + c );
	}



	// �Ϲ�ȭ
	// ������ �⵵�� �Է¹޾� ����˰��� �Ǵ� �� 
	// �����̸� true�� ����̸� false�� �Ǵܰ���� �����ϴ� �Լ�
	public static boolean isLeapYear(int year) {
		boolean bLeap = false; // ���
		if( year % 4 == 0 ) bLeap = true; //����
		if( year % 100 == 0 ) bLeap = false; // ���
		if( year % 400 == 0 ) bLeap = true; // ����
		return bLeap;
	}
	
	// ��üȭ
	// ������ �⵵�� �Է¹޾� ����˰��� �Ǵ� �� 
	// ���ڿ��� "����" Ȥ�� "���"���� �����ϴ� �Լ�
	private static String whichYear(int year) {
		String yearName = NONAME;
		
		if( year % 4 == 0 ) {
			yearName = LEAP_YEAR;
			// ���� ��� ������ 004,(and) 100���� ������ �������� �ش� ������� �Ѵ�.
			if( year % 100 == 0 ) { 
				yearName = COMMON_YEAR;
				// ���� ��� ������ 004, 100, 400���� ������ �������� �ش� �������� �д�.
				if( year % 400 == 0 ) yearName = LEAP_YEAR;
				else yearName = COMMON_YEAR;
			}
			else yearName = LEAP_YEAR;
		} else {
			yearName = COMMON_YEAR;
		}
		
		return yearName;
	}

}




