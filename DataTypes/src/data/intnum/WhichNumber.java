package data.intnum;

public class WhichNumber {

	public static void oddOrEvenNumber(int num) {
		// ��ó���� -- ���� ���� (�ڿ���)�� ó������
		//if(num >= 0) {} else {}
		if(num > 0) {
		if(num % 2 == 1) // Ȧ�� �������� �� true
			System.out.println(num + "��/�� Ȧ��Odd �Դϴ�.");
		else // ¦�� �������� ���� false
			System.out.println(num + "��/�� ¦��even �Դϴ�.");
		
	}else {
		System.out.println("¦Ȧ�� �Ǻ� ������ ���� ������ �˴ϴ�.^^ - ����:" + num);
	}
		
		// ����ó����
		if(num % 2 == 1) // Ȧ�� �������� �� true
			System.out.println(num + "��/�� Ȧ��Odd �Դϴ�.");
		else // ¦�� �������� ���� false
			System.out.println(num + "��/�� ¦��even �Դϴ�.");
		
	}
	
	public static void main(String[] args) {
		int a = 256;
		int b = 37;
		
		oddOrEvenNumber(100); // ¦Ȧ�� ���� ��� ����ϴ� �Լ�
		oddOrEvenNumber(37);
		oddOrEvenNumber(123456);
		oddOrEvenNumber(0);
		oddOrEvenNumber(-39);
		
		
		
		
		// ¦��even (pair), Ȧ�� odd
		// ������ ������ %
		// ���� ������ 2�� ���� �������� 0���� �� �������� ¦��.
		// ���� ������ 2�� ���� �������� 1�̸� Ȧ��.
		// int r = a % 2; 
		int r = b % 2;
		
		//if(���ǽ�) { ���ǽ��� true �̸� ����}
		// else { ���ǽ��� false�̸� ����; }
		
		if(r == 0)
			System.out.println("¦�� �Դϴ�.");
		else
			System.out.println("Ȧ�� �Դϴ�.");

		
		//if(a % 2 == 1) // ������ true
		if(true) // Ȧ����...
			System.out.println("Ȧ�� �Դϴ�.");
		else
			System.out.println("¦�� �Դϴ�.");
			
		//if(b % 2 == 0)
		//if(b % 2 != 1)	// Ȧ���� �ƴϸ�...
		//if(1 != 1) // ������ false
		//if(2 < 1)
		if(false)
			System.out.println("¦�� �Դϴ�.");
		else
			System.out.println("Ȧ�� �Դϴ�.");
		
		//if(3 + 4 == 4)
	}

}