package array;

public class ArrayMain5 {

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
			
			intArr[i] = times(i+1, 2); // 2, 4, 6, 8, 10
		
			// �Լ����� ����� �迭 ����� �ʱⰪ���� ����
		}
		
		System.out.println(" �迭ũ�� = " + intArr.length);
		
		printIntArray(intArr); // �迭�� �Էº���(����)�� ����ϴ� �Լ� ȣ��
//		for ( int i = 0; i < intArr.length; i++) {
//			System.out.printf(
//				"arr[%d] => %d \n", i, intArr[i]);
//		}
		
		int[] tempArr = { 1, 3, 4, 5, 6, 2, 33, 56445, 223};
		printIntArray(tempArr);
	}
	// �迭 Ÿ���� �Է� ����(�Ķ����)�� �޴� �Լ� ����
	private static void printIntArray(int[] intArr) {
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
