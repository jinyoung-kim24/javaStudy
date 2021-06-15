package year;

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

public class YearMain {
	
	public static final String NONAME = ""; // empty string ���ڿ�
	public static final String LEAP_YEAR = "����";
	public static final String COMMON_YEAR = "���";
	
	public static void main(String[] args) {
		// ���� �Ǵ� ���α׷�
		// �غ�, �Է� ��
		int year = 2100; //2021;
		String yearName = NONAME;
		
		// ���� (���� �Ǵ� ��)
		
		yearName = whichYear(year);
		
		//���� ��� ������ 004�� '������ ��������' �ش� �������� �Ѵ�. => ���, ���... �����...
//		if( year % 4 == 0 ) {
//			yearName = LEAP_YEAR;
//			// ���� ��� ������ 004,(and) 100���� ������ �������� �ش� ������� �Ѵ�.
//			if( year % 100 == 0 ) { 
//				yearName = COMMON_YEAR;
//				// ���� ��� ������ 004, 100, 400���� ������ �������� �ش� �������� �д�.
//				if( year % 400 == 0 ) yearName = LEAP_YEAR;
//				else yearName = COMMON_YEAR;
//			}
//			else yearName = LEAP_YEAR;
//		} else {
//			yearName = COMMON_YEAR;
//		}
		
		// ���
		System.out.printf(
				">> �ش� %4d�⵵�� '%s' �Դϴ�.\n", 
				year, yearName );
	}

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




