package lotte; // Lotto 6/32

import java.util.Arrays;

import uility.ScanUtil;

public class LauckyDraw8 {
	// 상수 정의
	public static final int MAX_BALLS = 32; // 20; //32; // 1 ~ 32 정상숫자볼
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1; // 0;
	public static final int DEFAULT_TICKETS = 3; // 1
	public static final int MIN_TICKETS = 3; // 3개..
	public static final int MAX_TICKETS = 20; // 법적.. 정부제한

	public static void main(String[] args) {

		// 최대 티켓수 입력을 main args 인자를 사용하는 버젼.
		int userWantTickets = 0;
		if (args.length == 0) {
			userWantTickets = ScanUtil.userInputToIntInRange("혹시... 티켓 몇개 주문하세요?", MIN_TICKETS, MAX_TICKETS);
		} else { // 정상
			userWantTickets = getTicketCountFromArgs(args[0]);
		}
		System.out.println("=== LD6/32 행운티켓뽑기 프로그램 ===");
		// 다 수개의 행운권티켓 발권 루프
		int ticketCount = 0; // 티켓 발권회수 카운트
		do { // do~~
				// 정수배열을 함수 실행의 결과 리턴하여 selBalls 변수에 저장
			int selBalls[] = selectLuckyBalls();
			Arrays.sort(selBalls);
			printOneLDTicket(selBalls, ++ticketCount, userWantTickets);
		} while (ticketCount < userWantTickets); // do~while 끝.
	}

	public static int getTicketCountFromArgs(String arg0) {
		int userWantTickets = 0;
		String tickerStr = arg0;
		int temp = Integer.parseInt(tickerStr); // 5 (4바이트)
		// parseInt() 막실행
		// 믿는바 사용자가 정말 오직 정수문자들로 구성된 문자열만 입력했다고
		// 50 정상?
		// 5.22, ㅎㅎㅎㅎ, ??, 길동, 123abc
		if (temp >= MIN_TICKETS && temp <= MAX_TICKETS) {
			// 3 ~ 20
			userWantTickets = temp;
		} else {
			if (temp <= 0) {
				System.out.println("최소 3개는 팔아야 됨!! ");
				userWantTickets = MIN_TICKETS; // 하한보정
			}
			if (temp > MAX_TICKETS) {
				System.out.println("정부에서 " + MAX_TICKETS + "까지 허용함!!");
				userWantTickets = MAX_TICKETS; // 상한보정
				// 거스름돈을 자동으로 계산해서 줌...
			}
		}
		return userWantTickets;
	}

	// 실행 시 마다 임의의 1 ~ 32 범위의 행운숫자 중복없이 6개를 뽑아서
	// 순서대로 정수배열에 담아 그배열 자체를 리턴해주는 함수
	private static int[] selectLuckyBalls() {
		int selBalls[] = { NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL };

		int count = 0; // 랜덤 번호(회차수) 뽑기 시도 카운트
		int selCount = 0; // 럭키볼 저장 기준 카운트(배열 순서번호)
		while (selCount < MATCH_BALLS) { // 0 ~ 5
			int ball = (int) (Math.random() * MAX_BALLS) + 1; // 1 ~ 32
			System.out.println(count + "회차 자동번호 볼 ==> (" + ball + ")");

			// 중복 체크
			boolean duplicated = false; // 중복이 없다고 믿자!!
			for (int i = 0; i < selBalls.length; i++) {
				if (ball == selBalls[i]) { // 중복 맞아??
					duplicated = true; // 중복 찾았음!!!
					break; // 중복 발견되자 마자.. 체크를 그만둠.
				}
			}
			// 이제 '안전'하게 저장소 배열에 기억시켜두자.
			if (duplicated == false) { // 중복아닐때...
				selBalls[selCount] = ball;
				// NO_SEL 배열칸 하나를 정상볼 ball로 채우기...
				selCount++; // 0 => 1 ~ 5 저장됨... 6이되면 while 종료.
			} else { // 중복일때...
				System.out.println("\t>> 중복됨!!! " + ball);
			}
			count++;
		} // 선택 루프 끝..
		return selBalls;
	}

	public static void printOneLDTicket(int[] selBalls, int ticketCount, int userWantTickets) {
		System.out.println("\n===== LD 6/32 Ticket =====");
		System.out.println("* 티켓발권수: " + ticketCount + " / " + userWantTickets);
		System.out.println("* 승인번호: " + (long) (Math.random() * 100000000000000L));
		for (int i = 0; i < selBalls.length; i++) {
			System.out.print("(" + selBalls[i] + ") ");
		}
		System.out.println();
		System.out.println("\n==========================");
	}

}
