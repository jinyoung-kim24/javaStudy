package data.intnum;

public class NumberCalculator {

	public static void main(String[] args) {
		// ���� �迭�� ������ ����...
		// ��ȣ signed + - 
		int numA = 100; // +100;
		int numB = 48; //-100;
		
		// ��� ������ (Arithmetic Operator)
		// + - * /  ��Ģ����
		int sumVal, diffVal, mulVal, 
			divVal = 0;
		
		numB = 0;
//		numB = 3;
		
		sumVal = numA + numB;
		diffVal = numA - numB;
		mulVal = numA * numB;
		
		// ������ ������ (�߿���!!)
		int modVal = 0;		
		
		//if( numB > 0 ) {  // if�� ����� ����
		//			
		//	} // if�� ��
		if( numB != 0 ) {  // ���� ���� ����.. 
			divVal = numA / numB;
			System.out.println(">> ������ ������...");		
			// Exception in thread "main" java.lang.ArithmeticException: / by zero
			// 0���� �������� �����ϸ� ���ܰ� (�ǽð� ����) �߻�...
			modVal = numA % numB;
			System.out.println(">> ������ ���� ������...");
		}
		else // numB == 0
		{
			System.out.println("0���� ���� �� �����!!");
			System.out.println();
		}
		
//		// ������ ������ (�߿���!!)
//		int modVal = 0;
//		modVal = numA % numB;
		
		System.out.println(numA + " + " + numB + " = " + sumVal);
		System.out.println(numA + " - " + numB + " = " + diffVal);
		System.out.println(numA + " - " + numB + " = " + (numA-numB));
		System.out.println(numA + " �� " + numB + " = " + mulVal);
		System.out.println(numA + " �� " + numB + " = " + divVal);
							// '��' + ����Ű... ���б�ȣ
		System.out.println(numA + " % " + numB + " = " + modVal);
	}

}

/*
0���� ���� �� �����!!

100 + 0 = 100
100 - 0 = 100
100 - 0 = 100
100 �� 0 = 0
100 �� 0 = 0
100 % 0 = 0

*/