package branch.vote;
// 2016년도 미국 대선 투표 시뮬레이션 
// https://ko.wikipedia.org/wiki/2016%EB%85%84_%EB%AF%B8%EA%B5%AD_%EB%8C%80%ED%86%B5%EB%A0%B9_%EC%84%A0%EA%B1%B0
// https://namu.wiki/w/2016%EB%85%84%20%EB%AF%B8%EA%B5%AD%20%EB%8C%80%ED%86%B5%EB%A0%B9%20%EC%84%A0%EA%B1%B0
// https://ww.namu.la/s/28813ddfc7dc7c38c07003f9b20a79b8492da9d171794eb6ae40fe19de385b50ea70ccb95cbfcf2c3b84112e9a372d581767e695c67f2e9dd629469e862d86fb1cadb604521d984fa1c3586daf348895a4739172b863a9b519e53dc7d1b4e40796e23f1757cd5437f6fd584a7b5975dc
// 보수 vs. 진보 진영
// donald trump vs. hilary cliton
// 선거인단 538개 (투표, 개표하는 총 범위이 최대치)
// '당선 확실'하게 되는 선거인단의 득표수... 약 270개 

public class VoteMain8 {

	// 상수 정의 
	public static final int MAX_VOTES = 538; // 최대 선거인단 투표수
	public static final int WIN_VOTES = 270; // 당선확실 선거인단 득표수
	public static final char DONALD_PARTY = 'D';
	public static final char HILARY_PARTY = 'H';
	public static final char ETC_PARTY = 'E'; // 군소 후보들?
	public static final int GAP = 30; // 60; //40; //30; //50; //20; // 구간
	
	public static void main(String[] args) {
		// 변수 정의 - 정당 party 후보별 득표수 카운터 변수 
		int voteCountDonald = 0;// = 0; // 48% == 1 ~ 48 => 'D'
		int voteCountHilary = 0; // 48% == 49 ~ 96 => 'H'
		int voteCountEtc = 0; // 4% => 'E'
		
		// 선거인단이 개별 투표를 하다() 
		// => 1개의 투표가 진행, 개표를 통해 득표를 올려야 됨 
		
		int vorder = 1; // vote order 투표 회차수 카운터 (순서번호)
		boolean bAlmostWin = false; // 과반수 당선확정 '유력' 발표 유무
		//final int GAP = 30; //50; //20; // 구간
		//int status = GAP; // 구간 상태 변수 30, 60, 90,...
		//while(bFlag == true) {
		// 종료조건식 
		while(vorder <= MAX_VOTES) { // vorder <= 538
			// 랜덤하게 선거인단이 투표함.
			// 48 : 48 : 4   =>   3개 party 분할
			char party = voteToParty(); // 'D', 'H', 'E'
			
			// 득표수 누적 집계 D, H, E
			if( party == DONALD_PARTY ) // 'D')
				voteCountDonald++; // 도널드당 득표 1+
			else if( party == HILARY_PARTY )
				voteCountHilary++;
			else 
				voteCountEtc++;
			
//			System.out.printf("[%d 회차] 선거인단 투표 => %c \n", 
//					vorder, party); // 순서, 개수, 타입 일치...
			
			// 과반수 '당선확정' 처리!!  
			if( bAlmostWin == false ) {
				if( voteCountDonald == WIN_VOTES ) {
					System.out.println(
						" @@@ 도널드트럼프 당선 유력 당선확정 @@@ " + vorder 
							+ "회차까지 " + voteCountDonald + "득표!");
					bAlmostWin = true;
				}
				if( voteCountHilary == WIN_VOTES ) {
					System.out.println(
						" @@@ 힐러리클린턴 당선 유력 당선확정 @@@ "+ vorder 
							+ "회차까지 " + voteCountHilary + "득표!");
					bAlmostWin = true;
				}
			}
			// GAP ==> 30회 주기로 구간별 누적득표상황 표시
			//if( vorder == GAP ) {
			//if( vorder == status ) {
			if( vorder % GAP == 0 ) { // 구간 시작
				// 나머지 연산자로.. 약수연산처럼.. 긴 구간을 일정한 나머지 이하구간으로 반복함
				System.out.printf(
				//"[%3d 회차] 득표상황: Donald %d표 vs. Hilary %d표 (기타: %d표)\r\n",
				//"[%03d 회차] 득표상황: Donald %d표 vs. Hilary %d표 (기타: %d표)\r\n",						
				"[개표 진행률 %.2f%%] 득표상황: Donald %d표 vs. Hilary %d표 (기타: %d표)\r\n",						
				(double)vorder / MAX_VOTES * 100.0, 
				voteCountDonald, voteCountHilary,
				voteCountEtc);
//				status += GAP;  //status = status + GAP;
				
				// 이번 구간 까지의 우세 판정
				double donaldRatio = 
					(double)voteCountDonald / MAX_VOTES * 100.0;
							
				System.out.println("\t=== 우세 판정 ===");
				char winLose; // ><=
				if( voteCountDonald > voteCountHilary )
					winLose = '>';
					//System.out.println("\t 도널드가 winning~~~");
//					System.out.printf("\t 도널드 %.2f%% > 힐러리 %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				else if( voteCountDonald < voteCountHilary )
					winLose = '<';
//					System.out.println("\t 힐러리가 winning~~~");
//					System.out.printf("\t 도널드 %.2f%% < 힐러리 %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				else 
					winLose = '=';
//					System.out.println("\t 두 후보들이 무승부 중~~~");
//					System.out.printf("\t 도널드 %.2f%% = 힐러리 %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				
					// %% => '%' 문자로 출력
				System.out.printf("\t 도널드 %.2f%% %c 힐러리 %.2f%% \n", // '>' '<' '=' 
						donaldRatio, 
						winLose,
						(double)voteCountHilary /MAX_VOTES * 100.0 );
			} // 구간 끝
			
			
			//			
			++vorder; //vorder++; //vorder += 1;  // vorder = vorder + 1;
		} // loop exit
		
		System.out.println(" ===  선거 인단 투표 및 개표 끝 === ");
		
		// 최종 결과 출력 
		System.out.println("\n\n --- 최종 투표 결과 --- ");
		System.out.printf(
			"\t최종 득표상황: Donald %d표 vs. Hilary %d표 (기타: %d표)\r\n",
				voteCountDonald, voteCountHilary,
				voteCountEtc);
		// 당선인 결정하여 출력 d, h (기타는 무시함)
		System.out.print("\t ****** 당선자 : ");
		if(voteCountDonald > voteCountHilary) // trump win
			System.out.println(" 도널드 트럼프!!!");
		else if(voteCountDonald < voteCountHilary) // clinton win
			System.out.println(" 힐러리 클린턴!!!");
		else // draw 동일 
			System.out.println(" 무승부! 선거 다시!!");
			
	}

	public static char voteToParty() {
		char party;
		int ranVote = (int)(Math.random() * 100) + 1; // 1 ~ 100
		if( ranVote >= 1 && ranVote <= 48 ) 
			party = DONALD_PARTY; // 'D'; // 도날드가 한표 얻음.		
		//else if( ranVote > 48 && ranVote <= 96 )
		else if( ranVote <= 96 )
			party = HILARY_PARTY; //'H'
		else 	
			party = ETC_PARTY; // 'E'
		
		return party;
	}

}

/*
[개표 진행률 5.58%] 득표상황: Donald 17표 vs. Hilary 13표 (기타: 0표)
=== 우세 판정 ===
 도널드 3.16% > 힐러리 2.42% 
[개표 진행률 11.15%] 득표상황: Donald 35표 vs. Hilary 24표 (기타: 1표)
=== 우세 판정 ===
 도널드 6.51% > 힐러리 4.46% 
[개표 진행률 16.73%] 득표상황: Donald 48표 vs. Hilary 41표 (기타: 1표)
=== 우세 판정 ===
 도널드 8.92% > 힐러리 7.62% 
[개표 진행률 22.30%] 득표상황: Donald 65표 vs. Hilary 53표 (기타: 2표)
=== 우세 판정 ===
 도널드 12.08% > 힐러리 9.85% 
[개표 진행률 27.88%] 득표상황: Donald 81표 vs. Hilary 66표 (기타: 3표)
=== 우세 판정 ===
 도널드 15.06% > 힐러리 12.27% 
[개표 진행률 33.46%] 득표상황: Donald 92표 vs. Hilary 82표 (기타: 6표)
=== 우세 판정 ===
 도널드 17.10% > 힐러리 15.24% 
[개표 진행률 39.03%] 득표상황: Donald 101표 vs. Hilary 102표 (기타: 7표)
=== 우세 판정 ===
 도널드 18.77% < 힐러리 18.96% 
[개표 진행률 44.61%] 득표상황: Donald 114표 vs. Hilary 116표 (기타: 10표)
=== 우세 판정 ===
 도널드 21.19% < 힐러리 21.56% 
[개표 진행률 50.19%] 득표상황: Donald 132표 vs. Hilary 128표 (기타: 10표)
=== 우세 판정 ===
 도널드 24.54% > 힐러리 23.79% 
[개표 진행률 55.76%] 득표상황: Donald 151표 vs. Hilary 137표 (기타: 12표)
=== 우세 판정 ===
 도널드 28.07% > 힐러리 25.46% 
[개표 진행률 61.34%] 득표상황: Donald 164표 vs. Hilary 154표 (기타: 12표)
=== 우세 판정 ===
 도널드 30.48% > 힐러리 28.62% 
[개표 진행률 66.91%] 득표상황: Donald 177표 vs. Hilary 169표 (기타: 14표)
=== 우세 판정 ===
 도널드 32.90% > 힐러리 31.41% 
[개표 진행률 72.49%] 득표상황: Donald 194표 vs. Hilary 182표 (기타: 14표)
=== 우세 판정 ===
 도널드 36.06% > 힐러리 33.83% 
[개표 진행률 78.07%] 득표상황: Donald 208표 vs. Hilary 198표 (기타: 14표)
=== 우세 판정 ===
 도널드 38.66% > 힐러리 36.80% 
[개표 진행률 83.64%] 득표상황: Donald 221표 vs. Hilary 215표 (기타: 14표)
=== 우세 판정 ===
 도널드 41.08% > 힐러리 39.96% 
[개표 진행률 89.22%] 득표상황: Donald 233표 vs. Hilary 231표 (기타: 16표)
=== 우세 판정 ===
 도널드 43.31% > 힐러리 42.94% 
[개표 진행률 94.80%] 득표상황: Donald 248표 vs. Hilary 244표 (기타: 18표)
=== 우세 판정 ===
 도널드 46.10% > 힐러리 45.35% 
===  선거 인단 투표 및 개표 끝 === 


--- 최종 투표 결과 --- 
최종 득표상황: Donald 265표 vs. Hilary 253표 (기타: 20표)
 ****** 당선자 :  도널드 트럼프!!!
*/