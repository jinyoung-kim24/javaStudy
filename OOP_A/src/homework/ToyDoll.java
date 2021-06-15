package homework;

import java.util.Scanner;

public class ToyDoll {

	public static void main(String[] args) {
		String LEGEND[] = { "뽀로로", "크롱", "포비", "페티", "에디", "해리", "통통이", "루피" };

		String SUPER[] = { "아이언맨", "스파이더맨", "캡틴Am.", "토르", "헐크" };

		String RARE[] = { "엘사", "안나", "울라프" };

		String NORMAL[] = { "라바", "옐로", "레드", "핑크" };
		getSumRandom(LEGEND, SUPER, RARE, NORMAL);

		String petMsg = "";
		int legendNumber = 0;
		int superNumber = 0;
		int rareNumber = 0;
		int normalNumber = 0;
		int bonus = 0;
		int count = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("금액을 입력하세요:");
		int money = sc.nextInt();
		System.out.println(">> 입력된 금액 : 총" + money + "원");
		while (true) {
			if (money >= 5000) {
				System.out.println(">> 10회 일괄뽑기 진행...");
				for (int i = 0; i < 10; i++) {
					int percent = (int) (Math.random() * 100) + 1;
					if (percent > 0 && percent <= 5) {
						petMsg = "LEGEND" + LEGEND[(int) (Math.random() * LEGEND.length)];
						legendNumber++;
					} else if (percent <= 20) {
						petMsg = "SUPER" + SUPER[(int) (Math.random() * SUPER.length)];
						superNumber++;
					} else if (percent <= 50) {
						petMsg = "RARE" + RARE[(int) (Math.random() * RARE.length)];
						rareNumber++;
					} else {
						petMsg = "NORMAL" + NORMAL[(int) (Math.random() * NORMAL.length)];
						normalNumber++;
					}
					money -= 500;
					if (i == 9) {
						System.out.printf("%d회차 %s (남은 금액: %d원)\n", count++, petMsg, money);
					} else {
						System.out.printf("%d회차 %s\n", count++, petMsg);
					}
				}
				int percent = (int) (Math.random() * 100) + 1;
				if (percent > 0 && percent <= 5) {
					petMsg = "LEGEND" + LEGEND[(int) (Math.random() * LEGEND.length)];
					legendNumber++;
				} else if (percent <= 20) {
					petMsg = "SUPER" + SUPER[(int) (Math.random() * SUPER.length)];
					superNumber++;
				} else if (percent <= 50) {
					petMsg = "RARE" + RARE[(int) (Math.random() * RARE.length)];
					rareNumber++;
				} else {
					petMsg = "NORMAL" + NORMAL[(int) (Math.random() * NORMAL.length)];
					normalNumber++;
				}
				System.out.printf("<FREE 보너스> %d회차 %s\n", count++, petMsg);
				bonus++;
			} else {
				if (money < 500) {
					System.out.println("<뽑기 금액 부족!!!>");
					break;
				} else {
					money -= 500;
					int percent = (int) (Math.random() * 100) + 1;
					if (percent > 0 && percent <= 5) {
						petMsg = "LEGEND" + LEGEND[(int) (Math.random() * LEGEND.length)];
						legendNumber++;
					} else if (percent <= 20) {
						petMsg = "SUPER" + SUPER[(int) (Math.random() * SUPER.length)];
						superNumber++;
					} else if (percent <= 50) {
						petMsg = "RARE" + RARE[(int) (Math.random() * RARE.length)];
						rareNumber++;
					} else {
						petMsg = "NORMAL" + NORMAL[(int) (Math.random() * NORMAL.length)];
						normalNumber++;
					}

					System.out.printf("%d회차 %s (남은 금액: %d원)\n", count++, petMsg, money);
				}

			}
		}

		nanugi(legendNumber, count);

		System.out.println("------------------------------");
		System.out.printf("LEGEND: %d회 (%.2f%%)\n", legendNumber, nanugi(legendNumber, count));
		System.out.printf("SUPER: %d회 (%.2f%%)\n", superNumber, nanugi(superNumber, count));
		System.out.printf("RARE: %d회 (%.2f%%)\n", rareNumber, nanugi(rareNumber, count));
		System.out.printf("NORMAL: %d회 (%.2f%%)\n", normalNumber, nanugi(normalNumber, count));
		System.out.printf("+ 보너스: %d회", bonus);
	}

	private static void getSumRandom(String LEGEND[], String SUPER[], String RARE[], String NORMAL[] ) {
		String petMsg = "";
	int legendNumber = 0;
	int superNumber = 0;
	int rareNumber = 0;
	int normalNumber = 0;
		int percent = (int) (Math.random() *100) + 1;
		if (percent > 0 && percent <= 5) {
			petMsg = "LEGEND" + LEGEND[(int) (Math.random() * LEGEND.length)];
			legendNumber++;
		} else if (percent <= 20) {
			petMsg = "SUPER" + SUPER[(int) (Math.random() * SUPER.length)];
			superNumber++;
		} else if (percent <= 50) {
			petMsg = "RARE" + RARE[(int) (Math.random() * RARE.length)];
			rareNumber++;
		} else {
			petMsg = "NORMAL" + NORMAL[(int) (Math.random() * NORMAL.length)];
			normalNumber++;
		}
	}

	public static double nanugi(int legendNumber, int count) {
		double nanugi = ((double) legendNumber / (count - 1)) * 100.0;
		return nanugi;
	}
}
