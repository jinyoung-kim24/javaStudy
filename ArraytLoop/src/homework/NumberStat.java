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
		int count;// 회차 값
		int sum = 0; // 누적합
		double average = 0; // 평균값
		System.out.println("** 수치 입력 통계 프로그램 **");
		Scanner sc = new Scanner(System.in);
		System.out.println("반복회수를 입력: ");
		count = sc.nextInt();
		System.out.println("정수를 입력하세요");

		for (int i = 1; i <= count; i++) {
			System.out.printf("%d회 입력: \r\n", i);
			int num = sc.nextInt();
			sum += num;
			average = (double) (sum / i);
			System.out.printf(">> stat %d회차 입력: %d => 누적합: %d 평균:%.2f\r\n", i, num, sum, average);
		
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

		System.out.printf("%d회까지의 입력 수 중 최대: %d\r\n", count, max);
		System.out.printf("%d회까지의 입력 수 중 최소: %d\r\n", count, min);
		if (flag == false) {
			System.out.printf("평균 100.0이 넘는 최초의 회차: %d회차 => 평균: %.2f", a, d);
		} else {
			System.out.println("평균 100.0이 넘는 회차 없음");
		}
	}
}
