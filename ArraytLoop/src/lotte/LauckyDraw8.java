package lotte; // Lotto 6/32

import java.util.Arrays;

import uility.ScanUtil;

public class LauckyDraw8 {
	// ��� ����
	public static final int MAX_BALLS = 32; // 20; //32; // 1 ~ 32 ������ں�
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1; // 0;
	public static final int DEFAULT_TICKETS = 3; // 1
	public static final int MIN_TICKETS = 3; // 3��..
	public static final int MAX_TICKETS = 20; // ����.. ��������

	public static void main(String[] args) {

		// �ִ� Ƽ�ϼ� �Է��� main args ���ڸ� ����ϴ� ����.
		int userWantTickets = 0;
		if (args.length == 0) {
			userWantTickets = ScanUtil.userInputToIntInRange("Ȥ��... Ƽ�� � �ֹ��ϼ���?", MIN_TICKETS, MAX_TICKETS);
		} else { // ����
			userWantTickets = getTicketCountFromArgs(args[0]);
		}
		System.out.println("=== LD6/32 ���Ƽ�ϻ̱� ���α׷� ===");
		// �� ������ ����Ƽ�� �߱� ����
		int ticketCount = 0; // Ƽ�� �߱�ȸ�� ī��Ʈ
		do { // do~~
				// �����迭�� �Լ� ������ ��� �����Ͽ� selBalls ������ ����
			int selBalls[] = selectLuckyBalls();
			Arrays.sort(selBalls);
			printOneLDTicket(selBalls, ++ticketCount, userWantTickets);
		} while (ticketCount < userWantTickets); // do~while ��.
	}

	public static int getTicketCountFromArgs(String arg0) {
		int userWantTickets = 0;
		String tickerStr = arg0;
		int temp = Integer.parseInt(tickerStr); // 5 (4����Ʈ)
		// parseInt() ������
		// �ϴ¹� ����ڰ� ���� ���� �������ڵ�� ������ ���ڿ��� �Է��ߴٰ�
		// 50 ����?
		// 5.22, ��������, ??, �浿, 123abc
		if (temp >= MIN_TICKETS && temp <= MAX_TICKETS) {
			// 3 ~ 20
			userWantTickets = temp;
		} else {
			if (temp <= 0) {
				System.out.println("�ּ� 3���� �Ⱦƾ� ��!! ");
				userWantTickets = MIN_TICKETS; // ���Ѻ���
			}
			if (temp > MAX_TICKETS) {
				System.out.println("���ο��� " + MAX_TICKETS + "���� �����!!");
				userWantTickets = MAX_TICKETS; // ���Ѻ���
				// �Ž������� �ڵ����� ����ؼ� ��...
			}
		}
		return userWantTickets;
	}

	// ���� �� ���� ������ 1 ~ 32 ������ ������ �ߺ����� 6���� �̾Ƽ�
	// ������� �����迭�� ��� �׹迭 ��ü�� �������ִ� �Լ�
	private static int[] selectLuckyBalls() {
		int selBalls[] = { NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL };

		int count = 0; // ���� ��ȣ(ȸ����) �̱� �õ� ī��Ʈ
		int selCount = 0; // ��Ű�� ���� ���� ī��Ʈ(�迭 ������ȣ)
		while (selCount < MATCH_BALLS) { // 0 ~ 5
			int ball = (int) (Math.random() * MAX_BALLS) + 1; // 1 ~ 32
			System.out.println(count + "ȸ�� �ڵ���ȣ �� ==> (" + ball + ")");

			// �ߺ� üũ
			boolean duplicated = false; // �ߺ��� ���ٰ� ����!!
			for (int i = 0; i < selBalls.length; i++) {
				if (ball == selBalls[i]) { // �ߺ� �¾�??
					duplicated = true; // �ߺ� ã����!!!
					break; // �ߺ� �߰ߵ��� ����.. üũ�� �׸���.
				}
			}
			// ���� '����'�ϰ� ����� �迭�� �����ѵ���.
			if (duplicated == false) { // �ߺ��ƴҶ�...
				selBalls[selCount] = ball;
				// NO_SEL �迭ĭ �ϳ��� ���� ball�� ä���...
				selCount++; // 0 => 1 ~ 5 �����... 6�̵Ǹ� while ����.
			} else { // �ߺ��϶�...
				System.out.println("\t>> �ߺ���!!! " + ball);
			}
			count++;
		} // ���� ���� ��..
		return selBalls;
	}

	public static void printOneLDTicket(int[] selBalls, int ticketCount, int userWantTickets) {
		System.out.println("\n===== LD 6/32 Ticket =====");
		System.out.println("* Ƽ�Ϲ߱Ǽ�: " + ticketCount + " / " + userWantTickets);
		System.out.println("* ���ι�ȣ: " + (long) (Math.random() * 100000000000000L));
		for (int i = 0; i < selBalls.length; i++) {
			System.out.print("(" + selBalls[i] + ") ");
		}
		System.out.println();
		System.out.println("\n==========================");
	}

}
