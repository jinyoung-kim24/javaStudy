import java.util.Scanner;

import uility.ScanUtil;

public class Jinyoung3 {
	public static final int lOTTENUMBER = 45;
	public static final int LUCKYNUMBER = 6;
	public static final int NOSEL = 0;
	public static final int MAXBALLS = 3;

	public static void main(String[] args) {
		int minBalls = 1;
		do {
			
			
		int balls[] = new int[6];
		int ballsCount = 0;
		int count = 0;
		boolean overlap = false;
		
		while (ballsCount < LUCKYNUMBER) {
			int luckBalls = (int) ((Math.random() * lOTTENUMBER) + 1);
			System.out.printf("%d회차 자동번호 볼 => (%d)\r\n", (count + 1), luckBalls);
			count++;
			if (luckBalls == balls[balls.length - 1]) {
				overlap = true;
			}
			if (overlap == false) {
				balls[ballsCount] = luckBalls;
				ballsCount++;
			}

		}
		System.out.println("________________________");
		System.out.println(minBalls + "/" + MAXBALLS + "번 로또");
		System.out.println("===== 로또 행운번호 =====");
		for (int i = 0; i < balls.length; i++) {
			System.out.printf("%d번 번호 (%d) \r\n",(i+1), balls[i]);
		}
		System.out.println("==========================");
	}while(minBalls++ < MAXBALLS);
		
		}

}
