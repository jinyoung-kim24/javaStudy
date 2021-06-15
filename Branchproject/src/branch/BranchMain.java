package branch;


// 마일리지 적립 및 등급 판정 프로그램
/*
 PLATINUM 등급 100000~이상
 DIAMOND 등급 40000이상 ~ 100000미만
 GOLD 등급 20000이상 ~ 40000미만
 SIVER 등급 12000이상 ~ 20000미만
 BRONZE 등금5000이상 ~ 12000미만
 BASIC 기본등급0(이상) ~ 5000미만
 */


public class BranchMain{
	// 마일리지 포인트로 등급 판단을 위한 공통 상수 
	public static final int PLATINUM = 100000;
	public static final int DIAMOND = 40000;
	public static final int GOLD = 20000;
	public static final int SIVER = 12000;
	public static final int BRONZE = 5000;
	public static final int BASIC = 0; // 이상~ 기준 
	public static final String NO_RANK = "등급없음";
	

	public static void main(String[] args) {
		// 마일리지 서비스
		// 회원 초기화
		String name = "재욱";
		int mileage = 12000;
		
		// 회원 활동: 가입, 글쓰기, 로그인, 댓글, 좋아요, 구매, 부가서비스 가입, 기부
		mileage = mileage + 2000; // 구매 활동에 대한 보상
		mileage += 7000; // 부가 서비스 가입에 대한 보상
		mileage += 20000; // 기부에 대한 보상
		
		// 등급 판정 - pt가 어느 구간에 속하는지?
		String rank = NO_RANK;
		if(mileage >= BASIC && mileage < BRONZE)
			rank = "Basic 등급";
		else if(mileage >= BRONZE && mileage < SIVER)
			rank = "Bronze등급";
		else if(mileage >= SIVER && mileage < GOLD)
			rank = "Silver등급";
		else if(mileage >= GOLD && mileage < DIAMOND)
			rank = "Gold등급";
		else if(mileage >= DIAMOND && mileage < PLATINUM)
			rank = "Diamond등급";
		else if(mileage >= PLATINUM)
			rank = "Platinum등급";
		else 
			rank = "처리할 수 없는 등급!!";
		// 등급 출력
		System.out.println("--------------------");
		System.out.println(">> 회원 이름: " + name);
		System.out.println(">> 회원 마일리지: " + mileage + "pt");
		System.out.println(">> 회원 등급: " + rank);
		System.out.println("--------------------");
	}

}
 