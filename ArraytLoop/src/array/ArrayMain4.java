package array;

public class ArrayMain4 {

	public static void main(String[] args) {
		// ���� �迭 �ʱ�ȭ
		//int[] intArr = {}; // ��迭 (��Ұ� �� "����"�� ����..) �迭ũ�� = 0
//		int[] intArr = { 1, 2, 3, 4, 5 }; // ����� ���� �ʱ�ȭ
			// 20 ����Ʈ�� ��Ұ����� ���� 5���� ��ҷν� ��ġ...
		int[] intArr = { 0, 0, 0, 0, 0 }; 
			// ���� �⺻������ �켱 5�ڸ� ���� Ȯ��		
//		intArr[0] = 1;
//		intArr[1] = 2;
//		intArr[2] = 3;
//		intArr[3] = 4;
//		intArr[4] = 5; // �迭�� �� ��Ҹ� ������ ���������� �ʱ�ȭ
		
		// ���������� �迭 �ʱ�ȭ
		for (int i = 0; i < intArr.length; i++) {
			//intArr[i] = i * 5;  // 5�� ����� �迭 
			//intArr[i] = i * 2;  // ¦���� �迭..
			//intArr[i] = i * 10; // ������ �ڸ��� ��ȭ �迭
			//intArr[i] *= 10;
			//intArr[i] = toDouble(3);  // 6
//			intArr[i] = toDouble(i); // 0, 2, 4, 6, 8
			//intArr[i] = toDouble(i+1); // 2, 4, 6, 8, 10
			//intArr[i] = times(i+1, 2); // 2, 4, 6, 8, 10
			intArr[i] = times(i+1, 7); // 7, 14, 21, 28, 35
			// �Լ����� ����� �迭 ����� �ʱⰪ���� ����
		}
		
		System.out.println(" �迭ũ�� = " + intArr.length);
//		intArr[0] = 7; // 1 => 7 
//			// �迭�� ��Ұ��� �ϳ��� ��ġ intArr[0] �ϳ��� ����ó�� ���.
//		intArr[0] = intArr[0] + 1;
//		intArr[0] += 1;
//		intArr[0]++;
//		int i = 0;
//		for ( ; i < intArr.length; i++) {		
		for ( int i = 0; i < intArr.length; i++) {
			System.out.printf(
				"arr[%d] => %d \n", i, intArr[i]);
		}
	}

	public static int times(int num, int time) {
		System.out.println( time + "���� �Լ� ����..");
		return time * num;
	}
	
	private static int toDouble2(int num) {		
		return times(num, 2);
	}
	
	private static int toDouble(int num) {		
		return 2 * num;
	}

}
