package data.intnum;

public class WhichNumber3 {

	public static void oddOrEvenNumber(int num) {
		// ��ó���� -- ���� ���� (�ڿ���)��... ó������ 
		//if( num >= 0 ) { ���̸����; } else { �����̸����; }
		if( num > 0 ) {
			// ����ó����
			if( num % 2 == 1 ) // Ȧ�� �������� �� true
				System.out.println(num + "��/�� Ȧ��Odd �Դϴ�.");
			else // ¦��  �������� ���� false
				System.out.println(num + "��/�� ¦��Even �Դϴ�.");
		} else {
			System.out.println(
				"¦Ȧ�� �Ǻ� ������ ���� ������ �˴ϴ�.^^ - ����: " + num);
		}		
	}
	
	public static void main(String[] args) {
		int a = 256;
		int b = 37;
		
		boolean b50 = isEvenNumber(50); 
			// true/false�� ��������� �����ϴ� �Լ� 
		//System.out.println(50+"�� ¦���� �¾ƿ�? " + b50);
		if( b50 == true ) System.out.println("b50 �� ¦��.");
		//if( b50 ) System.out.println("b50 �� ¦��.");
		else System.out.println("b50 �� Ȧ��.");
		
		boolean b37 = isEvenNumber(37);
		System.out.println(37+"�� ¦���� �¾ƿ�? " + b37);
		
		if( isEvenNumber(99) == true )
//		if( isEvenNumber(99) )
			System.out.println("99 �� ¦��.");
		else 
			System.out.println("99 �� Ȧ��(¦���� �ƴ�).");
		
		
		oddOrEvenNumber(100);// ¦Ȧ�� ���� ��� ����ϴ� �Լ�
		oddOrEvenNumber(37);
		oddOrEvenNumber(123456);
		oddOrEvenNumber(0);
		oddOrEvenNumber(-39);
		
		String oddEvenMsg; // ¦Ȧ�� ���� ����� "¦��", "Ȧ��"�� ���� ����
		oddEvenMsg = oddOrEvenReturnMsg(200); // call
		// ¦Ȧ�� ���� ����� �Լ� �ȿ��� �ٷ� ������� �ʰ�!!! 
		// ���ڿ� ������ �������� �������� �Լ� 
		System.out.println(200+"��/�� " + oddEvenMsg 
						+ "�� �����Ǿ���!");
		
		// ¦�� even (pair), Ȧ�� odd?
		// ������ ������ %
		// ���� ������ 2�� ���� �������� 0���� �� �������� ¦��.
		// ���� ������ 2�� ���� �������� 1�̸� Ȧ��.
//		int r = a % 2;
		int r = b % 2;
		
		// if( ���ǽ� ) { ���ǽ��� true�̸� ����; }
		// else { ���ǽ��� false�̸� ����; }
		if( r == 0 ) 
			System.out.println("¦�� �Դϴ�.");
		else
			System.out.println("Ȧ�� �Դϴ�.");
		
		//if( 1 == 1 ) // ������ true
		//if( a % 2 == 1 ) // Ȧ����...
		if( true )
			System.out.println("Ȧ�� �Դϴ�.");
		else 
			System.out.println("¦�� �Դϴ�.");
		
		//if( b % 2 == 0 )
		//if( 1 != 1 ) // ������ false
		//if( 2 < 1 )
		if( false )
		//if( b % 2 != 1 ) // Ȧ���� �ƴϸ�..
			System.out.println("¦�� �Դϴ�.");
		else 
			System.out.println("Ȧ�� �Դϴ�.");
		
		//if( 3 + 4 >= 7 ) System.out.println("error!");
	}

	// definition
	private static String oddOrEvenReturnMsg(int num) {
		final String ODD = "Ȧ��";
		final String EVEN = "¦��";
		String result = ""; // emtpy string
		//return null; // �ƹ��͵� ����Ű�� ���� ���� ǥ���� null ��
		//return ""; // ���ڿ�
		if( num % 2 == 0 ) result = EVEN;
		else result = ODD;
		return result;
	}

	// ¦���߶�� ����� �Ϲ� �Ǵ� �Լ�, true/false�� ����
	public static boolean isEvenNumber(int num) {
		boolean result = false;
		if( num % 2 == 0 ) result = true; // ¦��
		else result = false; // ¦���� �ƴ�, �� Ȧ��..
			// true�� ¦���� ������Ŵ...
		return result;
	}
}



