package branch;

// 마일리지 적립 및 등급 판정 프로그램 
/* 
 PLATINUM 등급 100000~ 이상 
 DIAMOND 등급 40000 ~ 100000 미만 
 GOLD 등급 20000 ~ 40000	
 SILVER 등급 12000 이상 ~ 20000 미만
 BRONZE 등급 5000 이상 ~ 12000 미만
 BASIC 기본등급 0(이상) ~ 5000미만
 */

public class BranchMain2 {
	
	// 마일리지 포인트로 등급 판단을 위한 공통 상수
	public static final int PLATINUM = 100000;
	public static final int DIAMOND = 40000;
	public static final int GOLD = 20000;
	public static final int SILVER = 12000;
	public static final int BRONZE = 5000;
	public static final int BASIC = 0; // 이상~ 기준
	public static final String NO_RANK = "등급 없음";
	public static final int DEF_POINT = 3000;

	public static void main(String[] args) {		
		// 마일리지 서비스
		// 회원 초기화
		String name = "재욱";
		int mileage = DEF_POINT; // 회원 가입(활동)   12000; 
				
		// 회원 활동: 가입, 글쓰기, 로그인, 댓글, 좋아요, 구매, 부가서비스 가입, 기부..
		mileage = mileage + 2000; // 구매 활동에 대한 보상
//		mileage += 7000; // 부가 서비스 가입에 대한 보상
//		mileage += 20000; // 기부에 대한 보상
		
		//mileage = -1; // ?
		
		// 등급 판정 - pt가 어느 구간에 속하는지?
		String rank = NO_RANK; //"등급 없음";
		
//		if( mileage >= 0 )
		if( mileage < 0 ) {
			System.out.println(
			"[에러] 처리할 수 없는 마일리지 발견! - " + mileage );
			//return;
		} else {
			// 정상적인 mileage에 대해서만 같은 수준의 비교 판단을 수행
			//rank = getMemberRank2(mileage);
			rank = getMemberRank5(mileage);
			
			// 등급 출력 
			System.out.println("-----------------");
			System.out.println(">> 회원 이름: " + name);
			System.out.println(">> 회원 마일리지: " + mileage + "pt");
			System.out.println(">> 회원 등급: " + rank);
			System.out.println("-----------------");
		}
		
//		if( mileage >= BASIC && mileage < BRONZE ) //;
//			rank = "Basic 등급";
//		//if( mileage >= BRONZE && mileage < SILVER )
//		else if( mileage >= BRONZE && mileage < SILVER )
//			rank = "Bronze 등급";
//		else if( mileage >= SILVER && mileage < GOLD )
//			rank = "Silver 등급";
//		else if( mileage >= GOLD && mileage < DIAMOND )
//			rank = "Gold 등급";
//		else if( mileage >= DIAMOND && mileage < PLATINUM )
//			rank = "Diamond 등급";
////		else 
////			rank = "PLATINUM 등급";
//		else if( mileage >= PLATINUM )
//			rank = "PLATINUM 등급";
//		else 
//			rank = "처리할 수 없는 등급!!";
		
//		// 등급 출력 
//		System.out.println("-----------------");
//		System.out.println(">> 회원 이름: " + name);
//		System.out.println(">> 회원 마일리지: " + mileage + "pt");
//		System.out.println(">> 회원 등급: " + rank);
//		System.out.println("-----------------");
	}

	
	private static String getMemberRank2(int mileage) {
		String rank;
		if( mileage >= BASIC && mileage < BRONZE )
			rank = "Basic 등급";
		//if( mileage >= BRONZE && mileage < SILVER )
		else if( mileage >= BRONZE && mileage < SILVER )
			rank = "Bronze 등급";
		else if( mileage >= SILVER && mileage < GOLD )
			rank = "Silver 등급";
		else if( mileage >= GOLD && mileage < DIAMOND )
			rank = "Gold 등급";
		else if( mileage >= DIAMOND && mileage < PLATINUM )
			rank = "Diamond 등급";
		else 
			rank = "PLATINUM 등급";
//		else if( mileage >= PLATINUM )
//			rank = "PLATINUM 등급";
//		else 
//			rank = "처리할 수 없는 등급!!";
		return rank;
	}


	private static String getMemberRank5(int mileage) {
		if( mileage >= BASIC && mileage < BRONZE )
			return "Basic 등급";
		// 앞의 선행 조건의 역조건이 이미 충족..
		else if( mileage < SILVER ) return "Bronze 등급";
		else if( mileage < GOLD ) return "Silver 등급";
		else if( mileage < DIAMOND ) return "Gold 등급";
		else if( mileage < PLATINUM ) return "Diamond 등급";
		else return "PLATINUM 등급"; 
	}	
	
	private static String getMemberRank4(int mileage) {
		// 가독성 높음
		if( mileage >= BASIC && mileage < BRONZE )
			return "Basic 등급";
		else if( mileage >= BRONZE && mileage < SILVER )
			return "Bronze 등급";
		else if( mileage >= SILVER && mileage < GOLD )
			return "Silver 등급";
		else if( mileage >= GOLD && mileage < DIAMOND )
			return "Gold 등급";
		else if( mileage >= DIAMOND && mileage < PLATINUM )
			return "Diamond 등급";
		else return "PLATINUM 등급";
	}

	
	
	private static String getMemberRank3(int mileage) {
		String rank = "PLATINUM 등급";
		if( mileage >= BASIC && mileage < BRONZE )
			rank = "Basic 등급";
		//if( mileage >= BRONZE && mileage < SILVER )
		else if( mileage >= BRONZE && mileage < SILVER )
			rank = "Bronze 등급";
		else if( mileage >= SILVER && mileage < GOLD )
			rank = "Silver 등급";
		else if( mileage >= GOLD && mileage < DIAMOND )
			rank = "Gold 등급";
		else if( mileage >= DIAMOND && mileage < PLATINUM )
			rank = "Diamond 등급";
//		else 
//			rank = "PLATINUM 등급";
//		else if( mileage >= PLATINUM )
//			rank = "PLATINUM 등급";
//		else 
//			rank = "처리할 수 없는 등급!!";
		return rank;
	}


	
	private static String getMemberRank(int mileage) {
		String rank;
		if( mileage >= BASIC && mileage < BRONZE )
			rank = "Basic 등급";
		//if( mileage >= BRONZE && mileage < SILVER )
		else if( mileage >= BRONZE && mileage < SILVER )
			rank = "Bronze 등급";
		else if( mileage >= SILVER && mileage < GOLD )
			rank = "Silver 등급";
		else if( mileage >= GOLD && mileage < DIAMOND )
			rank = "Gold 등급";
		else if( mileage >= DIAMOND && mileage < PLATINUM )
			rank = "Diamond 등급";
//		else 
//			rank = "PLATINUM 등급";
		else if( mileage >= PLATINUM )
			rank = "PLATINUM 등급";
		else 
			rank = "처리할 수 없는 등급!!";
		return rank;
	}

}
