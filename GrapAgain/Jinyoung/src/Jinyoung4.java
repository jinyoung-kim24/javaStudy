import java.util.Scanner;

public class Jinyoung4 {

	public static void main(String[] args) {
		boolean flag = true;
		int min = Integer.MAX_VALUE;
		int max = 0;
		int num = 0;
		int sum = 0;
		double a = 0;
		int b = 0;
		double average = 0.0;
		System.out.println("** ��ġ �Է� ��� ���α׷� **");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("�ݺ�ȸ���� �Է�: ");
			int number = sc.nextInt();
			int count = 1;
			if (number <= 0) {
				System.out.println("�ڿ����� 0�̰ų� �����Դϴ� �ٽ��Է����ּ���.");
			} else {
				while (count <= number) {
					System.out.println("�ڿ����� �Է����ּ��� : ");
					num = sc.nextInt();
					sum += num;
					average = ((double)sum / count);
					System.out.printf(">> stat: %dȸ�� �Է� %d => ������: %d => ���: %.2f\n",
							count, num, sum, average);
					count++;

					if (max < num) {
						max = num;
					}
					if (min > num) {
						min = num;
					}
					if (flag == true && average >= 100.0) {
						a = average;
						b = count;
						flag = false;
					}

				}

					System.out.printf("100ȸ������ �Է� �� �� �ִ�: %d\n", max);
					System.out.printf("100ȸ������ �Է� �� �� �ּ�: %d\n", min);
					if (flag == false) {
						System.out.printf("��� 100.0�� �Ѵ� ������ ȸ��: %dȸ�� => ���: %.2f", b - 1, a);
					} else {
						System.out.println("��� 100.0�� �Ѵ� ������ ȸ��: ����.. ");
					}
						break;
			}

		}
	}

}
