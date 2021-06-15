package array;

public class ArrayMain {

	public static void main(String[] args) {
		// �迭 Array (�迭�� List(���) ����Ʈ �ڷᱸ���� �� �����̴�.)
		// "������ ��������" ��ҵ��� �� ���� ��ǥ�̸����� ������� ��. 
		// ������ȣ index�ν� �迭�� �� ��Ҹ� ����, ���� ���� ������ ����
		// ������ȣ ���� 0 ~ ��Ұ���-1����.
		// ��Ұ��� = �迭ũ��(����) = length '���'
		// �迭�� ũ��� ����̹Ƿ�, �� �� ���ǵ� �迭�� �� ũ�Ⱑ ���� ���� �� ����.
		
		// �ڹ� �⺻�� Primitives �迭�� --------
		
		// ��ġ�� �����迭 �迭
		//int[] intArr;  // ���� �迭 ���� (���� ��ҵ��� �� ���� ������ �迭 ����)
		int[] intArr = { 0, 365, -274, 674432 }; // ���� +�ʱ�ȭ = ����
		//   index       0   1     2     3(intArr.length-1)
		byte[] byteArr = { -128, 0, 127, 128-1, (byte)128 };
		short shortArr[] = { 0, -1, -32000, (short)65536/2, 
				-65536/2, 65536/2-1 };
		long []longArr = { 0, 0L, 2200000000L, -2100000000, 
				(long)2200000000L };
		
		// �Ǽ��迭 �迭
		float[] floatArr = { 0f, 0.0f, 
				(float)0.0, 1.234F, -2f, 3.1415f };
		double[] doubleArr = { 0, 0L, 0f, 0.0, 0.0D, 2.0, 
				-2.345, 3d, 100.0d, 3.141592, Math.PI 
		};
	
		// ������ �迭  Character Array != ���ڿ� (String) 
		char charArr[] = { 'ȫ', '��', '��', 0, '\0' };
		char c = '��'; // ���ڼ��� ������ȣ�� �ش� ���ڿ� ���� �ڵ尪(����)
		char []charArr2 = { 'A', 65, 'a', 97, ' ', 32, 
				'a'-'A', 'ȫ'-1, (char)(c+1),   
				charArr[2], (char)(charArr[2]-1) };
		System.out.println("charArr2 �迭�� ũ��: " +
				charArr2.length + "���ڼ�");
		for (int i = 0; i < charArr2.length; i++) {
			System.out.printf(
				"%d��° ���� ��� = %c [%d] \n", 
				i, charArr2[i], (int)(charArr2[i]));
				//i, charArr2[10], (int)(charArr2[10]));
//				i, charArr2[charArr2.length-1], 
//				(int)(charArr2[charArr2.length-1]));
		}
	
		// ���� �迭 
		boolean[] boolArr = 
		{ 
			true, true, false, true, false, 
			33 != 0,   // true
			100 > 300,  // false  => ���ǽ��� �׻� �������� ���.
			charArr2.length % 2 == 0
		};
	}
}
/*
charArr2 �迭�� ũ��: 11���ڼ�
0��° ���� ��� = A [65] 
1��° ���� ��� = A [65] 
2��° ���� ��� = a [97] 
3��° ���� ��� = a [97] 
4��° ���� ��� =   [32] 
5��° ���� ��� =   [32] 
6��° ���� ��� =   [32] 
7��° ���� ��� = �K [54860] 
8��° ���� ��� = �p [50649] 
9��° ���� ��� = �� [46041] 
10��° ���� ��� = �� [46040] 
*/