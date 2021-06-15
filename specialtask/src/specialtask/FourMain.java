package specialtask;

import java.util.Scanner;

public class FourMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("자연수 입력: ");
		int count = sc.nextInt();
		System.out.printf("총 %d회 루프 시작\n", count);
		char[] eng1 = new char[count];
		for (int i = 0; i < count; i++) {
			char eng = (char) ((int) (Math.random() * 25) + 65);
			System.out.println(eng);
			eng1[i] = eng;
		}
		for (int i = 'A'; i <= 'Z'; i++) {
			int num = 0;
			for (int j = 0; j < eng1.length; j++) {
				if(eng1[j] == i) {
					num++;
				}
			}
			System.out.printf("통계: %c(%d),\n", i, num);
		}
	}
}