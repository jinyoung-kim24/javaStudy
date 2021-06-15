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
		System.out.println("** 수치 입력 통계 프로그램 **");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("반복회수를 입력: ");
			int number = sc.nextInt();
			int count = 1;
			if (number <= 0) {
				System.out.println("자연수가 0이거나 음수입니다 다시입력해주세요.");
			} else {
				while (count <= number) {
					System.out.println("자연수를 입력해주세요 : ");
					num = sc.nextInt();
					sum += num;
					average = ((double)sum / count);
					System.out.printf(">> stat: %d회차 입력 %d => 누적합: %d => 평균: %.2f\n",
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

					System.out.printf("100회까지의 입력 수 중 최대: %d\n", max);
					System.out.printf("100회까지의 입력 수 중 최소: %d\n", min);
					if (flag == false) {
						System.out.printf("평균 100.0이 넘는 최초의 회차: %d회차 => 평균: %.2f", b - 1, a);
					} else {
						System.out.println("평균 100.0이 넘는 최초의 회차: 없음.. ");
					}
						break;
			}

		}
	}

}
