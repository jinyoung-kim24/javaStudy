package array;

public class ArrayMain3 {

	public static void main(String[] args) {
		// ���� �迭 �ʱ�ȭ 
		//int[] intArr = {}; // ��迭 (��Ұ� �� ������ ����..)
		//int[] intArr = {1, 2, 3, 4, 5}; // 20 ����Ʈ�� ��Ұ����� ���� 5���� ��ҷν� ��ġ....
		
		int[] intArr = {0, 0, 0, 0, 0}; // ���� �⺻������ �켱 5�ڸ� ���� Ȯ��
//		intArr[0] = 1;
//		intArr[1] = 2;
//		intArr[2] = 3;
//		intArr[3] = 4;
//		intArr[4] = 5; // �迭�� �� ��Ҹ� ������ ���������� �ʱ�ȭ
				
		// ���������� �迭 �ʱ�ȭ
		for (int i = 0; i < intArr.length; i++) {
			//intArr[i] = 100; // ��� ��Ұ� 1�� �ʱ�ȭ
			intArr[i] = i + 1; // intArr[0] = 0 + 1
		}
		System.out.println("�迭ũ�� = " + intArr.length);
		intArr[0] = 7; // 1 => 7 
		// �迭�� ��Ұ��� �ϳ��� ��ġ intArr[0] �ϳ��� ����ó�� ���.
		intArr[0] = intArr[0] + 1;
		intArr[0] += 1;
		intArr[0]++;
		
		for (int i = 0; i < intArr.length; i++) {
			System.out.printf("arr[%d] => %d \n",i, intArr[i]);
		}
	}

}
