package homework;

import java.util.Scanner;

public class ToyDoll {

	public static void main(String[] args) {
		String LEGEND[] = { "�Ƿη�", "ũ��", "����", "��Ƽ", "����", "�ظ�", "������", "����" };

		String SUPER[] = { "���̾��", "�����̴���", "ĸƾAm.", "�丣", "��ũ" };

		String RARE[] = { "����", "�ȳ�", "�����" };

		String NORMAL[] = { "���", "����", "����", "��ũ" };
		getSumRandom(LEGEND, SUPER, RARE, NORMAL);

		String petMsg = "";
		int legendNumber = 0;
		int superNumber = 0;
		int rareNumber = 0;
		int normalNumber = 0;
		int bonus = 0;
		int count = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("�ݾ��� �Է��ϼ���:");
		int money = sc.nextInt();
		System.out.println(">> �Էµ� �ݾ� : ��" + money + "��");
		while (true) {
			if (money >= 5000) {
				System.out.println(">> 10ȸ �ϰ��̱� ����...");
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
						System.out.printf("%dȸ�� %s (���� �ݾ�: %d��)\n", count++, petMsg, money);
					} else {
						System.out.printf("%dȸ�� %s\n", count++, petMsg);
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
				System.out.printf("<FREE ���ʽ�> %dȸ�� %s\n", count++, petMsg);
				bonus++;
			} else {
				if (money < 500) {
					System.out.println("<�̱� �ݾ� ����!!!>");
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

					System.out.printf("%dȸ�� %s (���� �ݾ�: %d��)\n", count++, petMsg, money);
				}

			}
		}

		nanugi(legendNumber, count);

		System.out.println("------------------------------");
		System.out.printf("LEGEND: %dȸ (%.2f%%)\n", legendNumber, nanugi(legendNumber, count));
		System.out.printf("SUPER: %dȸ (%.2f%%)\n", superNumber, nanugi(superNumber, count));
		System.out.printf("RARE: %dȸ (%.2f%%)\n", rareNumber, nanugi(rareNumber, count));
		System.out.printf("NORMAL: %dȸ (%.2f%%)\n", normalNumber, nanugi(normalNumber, count));
		System.out.printf("+ ���ʽ�: %dȸ", bonus);
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
