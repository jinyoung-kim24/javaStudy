package array;

public class ArrayMain2 {

	public static void main(String[] args) {
		// ���� �迭 �ʱ�ȭ
		//int[] intArr = {}; // ��迭 (��Ұ� �� "����"�� ����..) �迭ũ�� = 0
		int[] intArr = { 1, 2, 3, 4, 5 }; 
			// 20 ����Ʈ�� ��Ұ����� ���� 5���� ��ҷν� ��ġ... 
		System.out.println(" �迭ũ�� = " + intArr.length);
		intArr[0] = 7; // 1 => 7 
			// �迭�� ��Ұ��� �ϳ��� ��ġ intArr[0] �ϳ��� ����ó�� ���.
		intArr[0] = intArr[0] + 1;
		intArr[0] += 1;
		intArr[0]++;
//		int i = 0;
//		for ( ; i < intArr.length; i++) {		
		for ( int i = 0; i < intArr.length; i++) {
			System.out.printf(
				"arr[%d] => %d \n", i, intArr[i]);
		}
	}

}
