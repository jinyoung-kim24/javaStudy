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

public class BranchMain6 {
	// 마일리지 pt 적립시켜주는 활동 Action, 각 Action 상수 정의
	static final int ACTION_NO_ACT = 0; // 없음
	static final int ACTION_LOGIN = 1; // 로그인 50
	static final int ACTION_WRITE = 2; // 글쓰기 100
	static final int ACTION_READ = 3; // 글읽기 10
	static final int ACTION_LIKE = 4; // 좋아요 500
	static final int ACTION_PURCHASE = 5; // 상품구매 가격의 1~3% 랜덤
	static final int ACTION_SERVICE = 6; // 부가서비스는?
	
	// 액션을 총 몇번 수행 후 종료 
	static final int EXIT_ACTION_LIMIT = 20; //10;
	
	// 마일리지 포인트로 등급 판단을 위한 공통 상수
	public static final int PLATINUM = 100000;
	public static final int DIAMOND = 40000;
	public static final int GOLD = 20000;
	public static final int SILVER = 12000;
	public static final int BRONZE = 5000;
	public static final int BASIC = 0; // 이상~ 기준
	public static final String NO_RANK = "등급 없음";
	public static final int DEF_POINT = 3000;
	
	
	public static int getPurchaseMileage(int price) {
		int purchaseMile = 0;
		
		// 구매 활동에 대한 보상 => 구매상품 가격의 1.x ~ 3.0% 적립(반올림)
//		mileage = mileage + 2000;
//		int price = 50000; // 구매상품 가격
		
		double percent = Math.random() * 3.0 + 1.0;
		if( percent > 3.0 ) percent = 3.0; // 상한 보정 (최대값)
		
//		int purchaseMile = (int)(price * 0.01);  // 1%
//		purchaseMile = (int) Math.round(price * 0.01);
		purchaseMile = (int)(Math.round(price 
				* percent / 100.0));// 백분율(%) 
		
		System.out.println("\t상품 구매액: " + price + "원");
		System.out.println("\tpercent = " + percent + "% 적립률");
		System.out.println("\tpurchaseMile "
						+ purchaseMile + "pt");	
		
		return purchaseMile;
	}

	public static void main(String[] args) {		
		// 마일리지 서비스
		// 회원 초기화
		String name = "재욱";
		int mileage = DEF_POINT; // 회원 가입(활동)   12000;
		
		int activity = ACTION_NO_ACT; //0
				
		// 회원 활동: 가입, 글쓰기, 로그인, 댓글, 좋아요, 구매, 부가서비스 가입, 기부..
		// 	=> 포인트를 발생시키는 회원 활동들... (시간, 인증 등을 고려)
		int count = 1;
		boolean flag = true;
		while(flag) {
			//;
			activity = (int)(Math.random() * 6) + 1;			
			System.out.printf(">> %d 회차 활동: ", count);
			
			//System.out.println(activity);
			if( activity == ACTION_LOGIN ) {
				System.out.print("ACTION 로그인 실행");
				mileage += 50;
			} else if( activity == ACTION_WRITE ) {
				System.out.print("ACTION 글쓰기 실행");
				mileage += 100;
			} else if( activity == ACTION_READ ) {
				System.out.print("ACTION 글읽기 실행");
				mileage += 10;
			} else if( activity == ACTION_LIKE ) {
				System.out.print("ACTION 좋아요 실행");
				mileage += 500;
			} else if( activity == ACTION_PURCHASE ) {
				System.out.print("ACTION 상품구매 실행");
				int price = (int)(Math.random()*100000);
				mileage += getPurchaseMileage(price); 
			} else if( activity == ACTION_SERVICE ) {
				System.out.print("ACTION 부가서비스가입 실행");
//				mileage += 5000; // 고정
				// 랜덤한 부가 서비스 가입 1 ~ 4 선택
				//int addSvc = (int)(Math.random()*4)+1; // 1 ~ 4
				int addSvc = (int)(Math.random()*4); // 0 ~ 3
				int[] ptsAddSvc = { 5000, 10000, 20000, 30000 };
				String[] namesAddSvc = {
					"웹툰서비스", "오디오북", "비디오스트리밍", "무조건특가반값할인"	
				}; // 배열 Array -- 같은 종류 여러 데이터들을 단 하나의 대표이름으로 묶음.
				// 배열은 ptsAddSvc[0] 사용...
				System.out.println("\n~~~ 가입한 부가 서비스 이름: "
							+ namesAddSvc[addSvc]);
				System.out.println("~~~ 부가서비스 적립pt: " 
							+ ptsAddSvc[addSvc]);
				int addSvcMile = ptsAddSvc[addSvc];
				mileage += addSvcMile;
			} else {
				System.out.println(
					">> 예상치 못한 activity: " + activity);
			}
			
			System.out.printf(" 총 마일리지: %d pt\n", mileage);
			
			// 종료 조건
			if( count >= EXIT_ACTION_LIMIT ) flag = false;
			count++;
		}
				
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




/*
 		실행 결과   예..............
 		
>> 1 회차 활동: ACTION 글읽기 실행 총 마일리지: 3010 pt
>> 2 회차 활동: ACTION 부가서비스가입 실행
~~~ 가입한 부가 서비스 이름: 무조건특가반값할인
~~~ 부가서비스 적립pt: 30000
 총 마일리지: 33010 pt
>> 3 회차 활동: ACTION 글읽기 실행 총 마일리지: 33020 pt
>> 4 회차 활동: ACTION 글쓰기 실행 총 마일리지: 33120 pt
>> 5 회차 활동: ACTION 글쓰기 실행 총 마일리지: 33220 pt
>> 6 회차 활동: ACTION 로그인 실행 총 마일리지: 33270 pt
>> 7 회차 활동: ACTION 부가서비스가입 실행
~~~ 가입한 부가 서비스 이름: 오디오북
~~~ 부가서비스 적립pt: 10000
 총 마일리지: 43270 pt
>> 8 회차 활동: ACTION 글읽기 실행 총 마일리지: 43280 pt
>> 9 회차 활동: ACTION 로그인 실행 총 마일리지: 43330 pt
>> 10 회차 활동: ACTION 로그인 실행 총 마일리지: 43380 pt
>> 11 회차 활동: ACTION 부가서비스가입 실행
~~~ 가입한 부가 서비스 이름: 비디오스트리밍
~~~ 부가서비스 적립pt: 20000
 총 마일리지: 63380 pt
>> 12 회차 활동: ACTION 부가서비스가입 실행
~~~ 가입한 부가 서비스 이름: 오디오북
~~~ 부가서비스 적립pt: 10000
 총 마일리지: 73380 pt
>> 13 회차 활동: ACTION 부가서비스가입 실행
~~~ 가입한 부가 서비스 이름: 무조건특가반값할인
~~~ 부가서비스 적립pt: 30000
 총 마일리지: 103380 pt
>> 14 회차 활동: ACTION 글쓰기 실행 총 마일리지: 103480 pt
>> 15 회차 활동: ACTION 글쓰기 실행 총 마일리지: 103580 pt
>> 16 회차 활동: ACTION 글쓰기 실행 총 마일리지: 103680 pt
>> 17 회차 활동: ACTION 부가서비스가입 실행
~~~ 가입한 부가 서비스 이름: 비디오스트리밍
~~~ 부가서비스 적립pt: 20000
 총 마일리지: 123680 pt
>> 18 회차 활동: ACTION 글쓰기 실행 총 마일리지: 123780 pt
>> 19 회차 활동: ACTION 부가서비스가입 실행
~~~ 가입한 부가 서비스 이름: 웹툰서비스
~~~ 부가서비스 적립pt: 5000
 총 마일리지: 128780 pt
>> 20 회차 활동: ACTION 상품구매 실행	상품 구매액: 78203원
	percent = 1.1242456890300183% 적립률
	purchaseMile 879pt
 총 마일리지: 129659 pt
-----------------
>> 회원 이름: 재욱
>> 회원 마일리지: 129659pt
>> 회원 등급: PLATINUM 등급
-----------------
 		
 		
 		
 */ 
