package homework;

import java.util.Scanner;

public class NumberStat {
	public static final double PERCENT = 100.0;

	public static void main(String[] args) {
		boolean flag = true;
		int a = 0;
		int b = 0;
		int c = 0;
		double d = 0;
		int max = 0;
		int min = Integer.MAX_VALUE;
		int count;// ȸ�� ��
		int sum = 0; // ������
		double average = 0; // ��հ�
		System.out.println("** ��ġ �Է� ��� ���α׷� **");
		Scanner sc = new Scanner(System.in);
		System.out.println("�ݺ�ȸ���� �Է�: ");
		count = sc.nextInt();
		System.out.println("������ �Է��ϼ���");

		for (int i = 1; i <= count; i++) {
			System.out.printf("%dȸ �Է�: \r\n", i);
			int num = sc.nextInt();
			sum += num;
			average = (double) (sum / i);
			System.out.printf(">> stat %dȸ�� �Է�: %d => ������: %d ���:%.2f\r\n", i, num, sum, average);
		
			if (max < num) {
				max = num;
			}
			if (min > num) {
				min = num;
			}
			if (flag && average >= PERCENT) {
				a = i;
				d = average;
				flag = false;
			}
		}

		System.out.printf("%dȸ������ �Է� �� �� �ִ�: %d\r\n", count, max);
		System.out.printf("%dȸ������ �Է� �� �� �ּ�: %d\r\n", count, min);
		if (flag == false) {
			System.out.printf("��� 100.0�� �Ѵ� ������ ȸ��: %dȸ�� => ���: %.2f", a, d);
		} else {
			System.out.println("��� 100.0�� �Ѵ� ȸ�� ����");
		}
	}
}
