package data.intnum;

public class MyCalculator {

	public static void main(String[] args) {
		// �� ������ ���ؼ� ��Ģ����, �������� ��� ������ �Լ��ν� ����
		int numA = 100, numB = 47;
		
		mycalAdd(numA, numB); // �Լ� ȣ��
		//mycalAdd(9999, 1);
		
//		return;
			// ���� �ڷδ� �������� �ʰ� �������� �ʱ⿡ ���� �ڵ�... ���๫..
		mycalSubtract(numA, numB);  
		mycalMultiply(numA, numB);
		mycalDivide(numA, 0); // numB);
//		mycalModulus(numA, numB);
		mycalModulus(numA, 0);
		mycalModulus2(numA, 22); // 0);
	}
	
	public static void mycalModulus2(int x, int y) {
		if( y == 0 ) {
			System.out.println("~~~ 0���� ������ �õ�!!! II");
		} else {		
			int z = 0;
			z = x % y;
			System.out.print(">> ������ ���� II: ");
			System.out.println(x + " % " + y + " = " + z);
		}
	}
	
	public static void mycalModulus(int x, int y) {
		if( y == 0 ) {
			System.out.println("~~~ 0���� ������ �õ�!!!");
			return; // mycalModulus() �Լ��� ����.
		}
		
		int z = 0;
		z = x % y;
		System.out.print(">> ������ ����: ");
		System.out.println(x + " % " + y + " = " + z);
	}
	
	public static void mycalDivide(int x, int y) {
		if( y == 0 ) {
			System.out.println("~~~ 0���� ������ �õ�!!!");
			return; // mycalDivide() �Լ��� ����.
		}
		
		int z = 0;
		z = x / y;
		System.out.print(">> ������ ����: ");
		System.out.println(x + " / " + y + " = " + z);
	}

	private static void mycalMultiply(int x, int y) {
		int z = 0;
		z = x * y;
		System.out.print(">> ���� ����: ");
		System.out.println(x + " * " + y + " = " + z);
	}
	
	private static void mycalSubtract(int x, int y) {
		int z = 0;
		z = x - y;
		System.out.print(">> ���� ����: ");
		System.out.println(x + " - " + y + " = " + z);
	}

	// �Լ� ����
	private static void mycalAdd(int x, int y) {
		int z = 0;
		z = x + y;
		System.out.print(">> ���� ����: ");
		System.out.println(x + " + " + y + " = " + z);
	}

}
