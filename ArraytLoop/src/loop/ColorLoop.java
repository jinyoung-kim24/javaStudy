package loop;

public class ColorLoop {

	public static void main(String[] args) {
		// �迭 Array
		// ������ Ÿ���� �����͸� �ټ��� �������� �������� �ʿ���.
		// ������ Ÿ���� �ټ� �����͵��� �� �ϳ��� �迭������ ��� ǥ����.
		// �迭�� �� �ϳ��� ��ǥ �̸��� ����(Array Ÿ��)������ ����
		// �迭�� �� ���(element)���� Ÿ������ ������. 
		// �迭�� ��Ҹ� ���� �� �ִ� "�޸� ����"��.
		//String[] colors; // ���ڿ� �������� ���� �迭���� colors ����.
		//String []colors;
		//String colors[]; // ��ǥ�̸� colors�� �迭�� ����.
		//String[] colors = {}; // �迭 �ʱ�ȭ -- empty array �� �迭
		// �迭 ���� ���� �� �ʱ�ȭ
		String[] colors = {
			"black", "white", "red", "green", 	// 0, 1, 2, 3
			"blue", "yellow", "purple", "cyan",// 4, 5, 6, 7
			"navy", "orange", "brown", "pink",// 8, 9, 10, 11
			"gold" 							 // 12
		};
		// �迭�� ������(���)�� �� 13���� �迭�� ����.
		// �迭�� ������, �� �� ��ҿ� ���� ������ �ݵ�� ������ȣ(index)�� �ؾ���.
		// �ڹ��� �迭 �ε���, �� ������ȣ�� 0���� �����Ͽ� ������ �ε��� N-1.
		// ��, ������ ������ȣ�� �迭�� �ѿ�Ұ��� - 1��.
		// �迭�� ũ�� (����) = ����� �� ���� = �迭��.length
		// �迭�� �ѹ� ���ǵǸ� �� ��Ұ����� ���� ���� �� ����.
		System.out.println("colors.length = " + colors.length);
		System.out.println("ù���� color[0] = " + colors[0]);
		System.out.println("������ color[12] = " + colors[colors.length-1]);
		int cr = 0; // �迭�� �� ��Ҹ� Ž��(��������)�� ������ȣ
		while(cr < colors.length) { // cr 0 ~ 12����
			String color = colors[cr++]; // black
			System.out.println("�÷� �̸�: " + color);
			//cr++;
		}
		
		// �迭 ��Ұ� ���� 	��Ұ����� �迭��[i]�� ��������ó�� ����....
		colors[3] = "mint"; // ����, Ȱ�� "grean" -> "mint"
		colors[4] = "lime"; // blue -> lime
		colors[5] = colors[3];	
			for (int i = 0; i < colors.length; i++) {
			String color = colors[i]; 
			System.out.printf("%d�� �÷� �̸�: %s\r\n", i, color);
		}
		
		
		
	}

}
