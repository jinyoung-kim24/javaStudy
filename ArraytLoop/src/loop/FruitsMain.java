package loop;

public class FruitsMain {

	public static void main(String[] args) {
		// '���� �̸�' �迭 ǥ�� (��� Ÿ�� => "" ���ڿ���)
//		String fruitNames[]; // �迭 ����.
//		String[] fruitNames;
//		String []fruitNames = {}; 
		// ���� 0�� empty array ��迭. �����ü�� �ϳ��� ����...
		String fruitNames[] = { // �迭 ���� �� �ʱ�ȭ
			"���", "����", "������", "�ڸ�", "���",
			"�ٳ���", "���ξ���", "�챸", "������", "�ڵ�"
		}; // length ���� 10�� �����̸����� �迭; index 0 ~ 9���� ���ٵ�.
		
		System.out.println("���Ϲ迭�� �������(����) = "
					+ fruitNames.length ); // ���
		System.out.println("ù��° ����: " + fruitNames[0]);
		System.out.println("��������° ����: " 
						+ fruitNames[fruitNames.length-1]);
		//System.out.println("��������° ����: " + fruitNames[9]);
		
		try {
			System.out.println("������ ����: " 
					+ fruitNames[fruitNames.length]); // 10 error
			// 10�� ������ȣ ���� 0 ~ 9�� ���...
			// ArrayIndexOutOfBoundsException ���� ������ �߻�..
		} catch(ArrayIndexOutOfBoundsException e) { // ����ó��
			System.out.println("�߸��� �迭��� ���ٽõ�! �����ڵ� F0301");
			//e.printStackTrace();
		}
	}

}
/*
���Ϲ迭�� �������(����) = 10
ù��° ����: ���
��������° ����: �ڵ�
�߸��� �迭��� ���ٽõ�! �����ڵ� F0301
*/