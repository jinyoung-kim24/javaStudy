package branch.vote;
// 2016년도 미국 대선 투표 시뮬레이션 
// https://ko.wikipedia.org/wiki/2016%EB%85%84_%EB%AF%B8%EA%B5%AD_%EB%8C%80%ED%86%B5%EB%A0%B9_%EC%84%A0%EA%B1%B0
// https://namu.wiki/w/2016%EB%85%84%20%EB%AF%B8%EA%B5%AD%20%EB%8C%80%ED%86%B5%EB%A0%B9%20%EC%84%A0%EA%B1%B0
// https://ww.namu.la/s/28813ddfc7dc7c38c07003f9b20a79b8492da9d171794eb6ae40fe19de385b50ea70ccb95cbfcf2c3b84112e9a372d581767e695c67f2e9dd629469e862d86fb1cadb604521d984fa1c3586daf348895a4739172b863a9b519e53dc7d1b4e40796e23f1757cd5437f6fd584a7b5975dc
// 보수 vs 진보
// donald trump vs hilary cliton
// 선거인단 538개 ( 투표, 개표하는 총 범위의 최대치)
// 당선 확실 하게 되는 선거인단의 투표수..... 약 270개
public class VoteMain2 {

	// 상수 정의
	public static final int MAX_VOTES = 538; // 최대 선거인단 투표수
	public static final int WIN_VOTES = 270; // 당선 확실 선거인단 득표수
	public static final char DONALD_PARTY = 'D';
	public static final char HILARY_PARTY = 'H';
	public static final char ETC_PARTY = 'E'; // 군소 후보들
	
	public static void main(String[] args) {
		// 변수 정의 - party 후보별 듣표수 가운터 변수
		int voteCountDonald = 0; // 48% == 1 ~ 48 => 'D'
		int voteCountHilary = 0; // 48% == 49 ~ 96 => 'H'
		int voteCountEtc = 0; // 4% == 97 ~ 100 => 'E'
		// 선거 인단이 개별 투표를 하다() 
		//=> 1개의 투표가 진행, 개표를 통해 득표를 올려야 됨
		
		int vorder = 1; // vote order 투표 회차수 카운터 (순서 번호)
		 
		while(vorder <= MAX_VOTES) { // vorder <= 538
			
		
		// 램덤하게 선거인단이 투표함.
		// 48:48:4
		char party = 0;
		int ranvote = (int) (Math.random() * 100) + 1; // 1 ~ 100
			if(ranvote >= 1 && ranvote <= 48) party = DONALD_PARTY; 
			//else if(ranvote > 48 && ranvote <= 96)	party = HILARY_PARTY;
			else if(ranvote <= 96) party = HILARY_PARTY;
			else party = ETC_PARTY;
			System.out.printf(">> [%d 회차] 선거인단 투표 => %c \n", vorder, party); // 순서 개수 타입 일치해야함.
			//System.out.printf(">> 선거인단 투표 => %c \n", party);
			vorder++;
		} // loop exit
			System.out.println("=== 선거 인단 투표 및 개표 끝 ===");
	}

}
