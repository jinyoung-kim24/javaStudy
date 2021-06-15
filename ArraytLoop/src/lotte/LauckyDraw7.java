package lotte; // Lotto 6/32

import java.util.Arrays;

import uility.ScanUtil;

public class LauckyDraw7 {
	// 상수 정의
	public static final int MAX_BALLS = 45; // 20; //32; // 1 ~ 32 정상숫자볼
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1; // 0;
	public static final int DEFAULT_TICKETS = 3; // 1
	public static final int MIN_TICKETS = 3; // 최소 
	public static final int MAX_TICKETS = 20; // 법적 최대
	public static void main(String[] args) {

		// 최대 티켓수 입력을 main args 인자를 사용하는 버젼.
		int userWantTickets = 0;
		if(args.length == 0) {
			System.out.println(">> 입력 티켓수가 없음!!");
			userWantTickets = MIN_TICKETS;
			// main() args에 입력이 전혀 없어도 무조건 3개 최소 발권
		} // legnth >= 1
		else { // 정상
			String tickerStr = args[0]; // 5 10 1 0
			int temp = Integer.parseInt(tickerStr);
			if(temp >= MIN_TICKETS && temp <= MAX_TICKETS) {
				// 3 ~ 20 
				userWantTickets = temp;
			}else {
				if(temp <= 0) {
					System.out.println("최소 3개는 팔아야 됨!!");
					userWantTickets = MIN_TICKETS; // 하한보정
				}if(temp > MAX_TICKETS) {
					System.out.println("정부에서" + MAX_TICKETS + "까지만 허용함!!");
					userWantTickets = MAX_TICKETS; // 상한보정
					// 거스름돈을 자동으로 계산해서 줌....
				}
			}
			
		}

		System.out.println("=== LD6/32 행운티켓뽑기 프로그램 ===");
		

		// 다수개의 행운권티켓 발권 루프
		int ticketCount = 0; // 티켓 발권회수 카운트
		do {

			int selBalls[] = { NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL };

			// 6개 안전 럭키(번호)볼을 뽑아서 저장하는 루프 (저장기준으로 루프 제어)
			int count = 0; // 랜덤 번호(회차수) 뽑기 시도 카운트
			int selCount = 0; // 럭키볼 저장 기준 카운트(배열 순서번호)
			while (selCount < MATCH_BALLS) { // 0 ~ 5
				// 랜덤한 숫자볼 뽑기
				int ball = (int) (Math.random() * MAX_BALLS) + 1; // 1 ~ 32
				System.out.println(count + "회차 자동번호 볼 ==> (" + ball + ")");
				// count+"회차 자동번호 볼 ==> (" + 0 + ")");

				// 중복 체크
				boolean duplicated = false; // 중복이 없다고 믿자!!

				for (int i = 0; i < selBalls.length; i++) {
					if (ball == selBalls[i]) { // 중복 맞아??
						duplicated = true; // 중복 찾았음!!!
						break; // 중복 발견되자 마자.. 체크를 그만둠.
					}
				}
				// 이번 반복회차에 나온 럭키볼 번호가 중복되지 않았다면...
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

			// 결과배열에 담긴 중복없는 행운번호 6개를 오름차순(내림차순)으로 정렬??
			// Sort 정렬... 특정 기준으로 데이터들의 순서를 재배치하는 것.. (알고리즘)
			// sort()하면 배열 자체가 변경되므로... 원본배열을 백업복사해놓자...

			// int[] oriSelBalls = new int[6];
			int[] oriSelBalls = { NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL };
			for (int i = 0; i < oriSelBalls.length; i++) {
				oriSelBalls[i] = selBalls[i];
			}
			Arrays.sort(selBalls);
			// 오름차순으로 배열의 요소의 순서들을 재배치 정렬 수행

			// 행운권 티켓 = 6개의 볼 조합 리스트
			// 티켓 출력
			ticketCount++;
			System.out.println("\n===== LD 6/32 Ticket =====");
			System.out.println("* 티켓발권수: " + ticketCount + " / " + userWantTickets);
			System.out.println("* 승인번호: " + (long) (Math.random() * 100000000000000L));
			for (int i = 0; i < selBalls.length; i++) {
				System.out.print("(" + selBalls[i] + ") ");
			}
			System.out.println();
			System.out.println("--------------------------");
			System.out.println(" 원본선택볼번호리스트:: ");
			for (int i = 0; i < oriSelBalls.length; i++) {
				// if( i == 5 ), if( i < oriSelBalls.length-1)
				// System.out.print(oriSelBalls[i] + ",");
				System.out.print(oriSelBalls[i] + (i < oriSelBalls.length - 1 ? "," : ""));
				// 마지막번호 뒤 컴마 안찍기..
			}
			System.out.println("\n==========================");
		} while (ticketCount < userWantTickets); // do ~ while 끝.

	}

}

/*
 * 0회차 자동번호 볼 ==> (5) 1회차 자동번호 볼 ==> (27) 2회차 자동번호 볼 ==> (4) 3회차 자동번호 볼 ==> (5)
 * >> 중복됨!!! 5 4회차 자동번호 볼 ==> (14) 5회차 자동번호 볼 ==> (21) 6회차 자동번호 볼 ==> (25)
 * 
 * ===== LD 6/32 Ticket ===== 승인번호: 3865999379481 4 5 14 21 25 27
 * ==========================
 * 
 */