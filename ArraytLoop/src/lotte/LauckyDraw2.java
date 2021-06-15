package lotte;  // Lotte 6/32
// 행운 뽑기 32개에서 6개를 숫자(공)를 뽑아보자. (사행성)
// (조합; 중복되지 않는 숫자를 6개를 차례대로 기억해야함)
/*
 * 	1등 다 맞추면 일치	 
 * 	2등 5개
 * 	3등 4개
 * 	4등 3개
 */
public class LauckyDraw2 {
	// 상수 정의
	public static final int MAX_BALLS = 20; // 1 ~ 32
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1;
	public static void main(String[] args) {
		// 발권번호볼을 기억시킬 배열 저장공간 정의 정수 6개의 메모리 공간!
		// int selBalls[]; // 배열 선언 (그러나 아직 공간은 없음)
		// int selBalls[] = new int [6];
		int selBalls[] = {
			NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL
		};
		
		// 완전 자동 럭키드로우티켓 발권 
//		int selBalls[] = {
//				7, 9, 18, 19, 20, 21
//		};
//		// 완전 자동 럭키드로우티켓 발권  (일부만 자동)
//		int selBalls[] = {
//				7, 9, NO_SEL, NO_SEL, NO_SEL, NO_SEL
//		};
		// 6개 안전 럭키번호볼을 뽑아서 저장하는 루프 ( 저장기준으로 루프 제어)
		int count = 0; // 램덤 번호(회차수) 뽑기 시도 카운트
		int selcount = 0; // 럭키볼 저장 기준 카운트
		while(selcount < MATCH_BALLS) { // 0 ~ 5
			// 렌덤한 숫자볼 뽑기
			int ball = (int) ((Math.random() * MAX_BALLS) + 1);
			
			
			System.out.println(count + "회차 자동번호 볼 ==> (" + ball +")");
			
			// 중복 체크
			boolean duplicated = false; // 중복이 없다고 믿자
			// 중복 처리
			// duplicated를 false로 가정하고, for문을 다 수행하고 나와서도 여전히 false라면 중복이 아님
			// 근데 단 한번이라도 동일한 중복수로 판정되면 true로 변경됨
			// true배열에 저장하지 않고 다음 회차 count에서 다시 랜덤볼 뽑아야함.
			for (int i = 0; i < selBalls.length; i++) {
				if(ball == selBalls[i]) // 중복 맞아??
					duplicated = true; // 중복찾았음
			}
			// 이번 반복회차에 나온 럭키볼 번호가 중복 되지 않았다면
			// 이제 안전하게 저장소 배열에 기억시켜두자.
			if(duplicated == false){ 
			selBalls[selcount] = ball;
			// No_SEL 배열칸 하나를 정상볼 ball로 채우기....
			selcount++;
			}else { // 중복일때
				System.out.println("\t>> 중복됨" + ball);
			}
			count++;
		} // 선택 루프 끝.
		
		// 행운권 티켓 = 6개의 볼 조합 리스트
		// 티켓출력
		System.out.println(" ===== LD 6/32 TICKET =====");
		System.out.println("승인번호: " + (long)(Math.random() * 1000000000000000L));
		for (int i = 0; i < selBalls.length; i++) {
			System.out.print(selBalls[i] + " ");
		}
		System.out.println();
		System.out.println("========================");
	}

}
