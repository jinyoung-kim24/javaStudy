package branch;

// ���ϸ��� ���� �� ��� ���� ���α׷� 
/* 
 PLATINUM ��� 100000~ �̻� 
 DIAMOND ��� 40000 ~ 100000 �̸� 
 GOLD ��� 20000 ~ 40000	
 SILVER ��� 12000 �̻� ~ 20000 �̸�
 BRONZE ��� 5000 �̻� ~ 12000 �̸�
 BASIC �⺻��� 0(�̻�) ~ 5000�̸�
 */

public class BranchMain2 {
	
	// ���ϸ��� ����Ʈ�� ��� �Ǵ��� ���� ���� ���
	public static final int PLATINUM = 100000;
	public static final int DIAMOND = 40000;
	public static final int GOLD = 20000;
	public static final int SILVER = 12000;
	public static final int BRONZE = 5000;
	public static final int BASIC = 0; // �̻�~ ����
	public static final String NO_RANK = "��� ����";
	public static final int DEF_POINT = 3000;

	public static void main(String[] args) {		
		// ���ϸ��� ����
		// ȸ�� �ʱ�ȭ
		String name = "���";
		int mileage = DEF_POINT; // ȸ�� ����(Ȱ��)   12000; 
				
		// ȸ�� Ȱ��: ����, �۾���, �α���, ���, ���ƿ�, ����, �ΰ����� ����, ���..
		mileage = mileage + 2000; // ���� Ȱ���� ���� ����
//		mileage += 7000; // �ΰ� ���� ���Կ� ���� ����
//		mileage += 20000; // ��ο� ���� ����
		
		//mileage = -1; // ?
		
		// ��� ���� - pt�� ��� ������ ���ϴ���?
		String rank = NO_RANK; //"��� ����";
		
//		if( mileage >= 0 )
		if( mileage < 0 ) {
			System.out.println(
			"[����] ó���� �� ���� ���ϸ��� �߰�! - " + mileage );
			//return;
		} else {
			// �������� mileage�� ���ؼ��� ���� ������ �� �Ǵ��� ����
			//rank = getMemberRank2(mileage);
			rank = getMemberRank5(mileage);
			
			// ��� ��� 
			System.out.println("-----------------");
			System.out.println(">> ȸ�� �̸�: " + name);
			System.out.println(">> ȸ�� ���ϸ���: " + mileage + "pt");
			System.out.println(">> ȸ�� ���: " + rank);
			System.out.println("-----------------");
		}
		
//		if( mileage >= BASIC && mileage < BRONZE ) //;
//			rank = "Basic ���";
//		//if( mileage >= BRONZE && mileage < SILVER )
//		else if( mileage >= BRONZE && mileage < SILVER )
//			rank = "Bronze ���";
//		else if( mileage >= SILVER && mileage < GOLD )
//			rank = "Silver ���";
//		else if( mileage >= GOLD && mileage < DIAMOND )
//			rank = "Gold ���";
//		else if( mileage >= DIAMOND && mileage < PLATINUM )
//			rank = "Diamond ���";
////		else 
////			rank = "PLATINUM ���";
//		else if( mileage >= PLATINUM )
//			rank = "PLATINUM ���";
//		else 
//			rank = "ó���� �� ���� ���!!";
		
//		// ��� ��� 
//		System.out.println("-----------------");
//		System.out.println(">> ȸ�� �̸�: " + name);
//		System.out.println(">> ȸ�� ���ϸ���: " + mileage + "pt");
//		System.out.println(">> ȸ�� ���: " + rank);
//		System.out.println("-----------------");
	}

	
	private static String getMemberRank2(int mileage) {
		String rank;
		if( mileage >= BASIC && mileage < BRONZE )
			rank = "Basic ���";
		//if( mileage >= BRONZE && mileage < SILVER )
		else if( mileage >= BRONZE && mileage < SILVER )
			rank = "Bronze ���";
		else if( mileage >= SILVER && mileage < GOLD )
			rank = "Silver ���";
		else if( mileage >= GOLD && mileage < DIAMOND )
			rank = "Gold ���";
		else if( mileage >= DIAMOND && mileage < PLATINUM )
			rank = "Diamond ���";
		else 
			rank = "PLATINUM ���";
//		else if( mileage >= PLATINUM )
//			rank = "PLATINUM ���";
//		else 
//			rank = "ó���� �� ���� ���!!";
		return rank;
	}


	private static String getMemberRank5(int mileage) {
		if( mileage >= BASIC && mileage < BRONZE )
			return "Basic ���";
		// ���� ���� ������ �������� �̹� ����..
		else if( mileage < SILVER ) return "Bronze ���";
		else if( mileage < GOLD ) return "Silver ���";
		else if( mileage < DIAMOND ) return "Gold ���";
		else if( mileage < PLATINUM ) return "Diamond ���";
		else return "PLATINUM ���"; 
	}	
	
	private static String getMemberRank4(int mileage) {
		// ������ ����
		if( mileage >= BASIC && mileage < BRONZE )
			return "Basic ���";
		else if( mileage >= BRONZE && mileage < SILVER )
			return "Bronze ���";
		else if( mileage >= SILVER && mileage < GOLD )
			return "Silver ���";
		else if( mileage >= GOLD && mileage < DIAMOND )
			return "Gold ���";
		else if( mileage >= DIAMOND && mileage < PLATINUM )
			return "Diamond ���";
		else return "PLATINUM ���";
	}

	
	
	private static String getMemberRank3(int mileage) {
		String rank = "PLATINUM ���";
		if( mileage >= BASIC && mileage < BRONZE )
			rank = "Basic ���";
		//if( mileage >= BRONZE && mileage < SILVER )
		else if( mileage >= BRONZE && mileage < SILVER )
			rank = "Bronze ���";
		else if( mileage >= SILVER && mileage < GOLD )
			rank = "Silver ���";
		else if( mileage >= GOLD && mileage < DIAMOND )
			rank = "Gold ���";
		else if( mileage >= DIAMOND && mileage < PLATINUM )
			rank = "Diamond ���";
//		else 
//			rank = "PLATINUM ���";
//		else if( mileage >= PLATINUM )
//			rank = "PLATINUM ���";
//		else 
//			rank = "ó���� �� ���� ���!!";
		return rank;
	}


	
	private static String getMemberRank(int mileage) {
		String rank;
		if( mileage >= BASIC && mileage < BRONZE )
			rank = "Basic ���";
		//if( mileage >= BRONZE && mileage < SILVER )
		else if( mileage >= BRONZE && mileage < SILVER )
			rank = "Bronze ���";
		else if( mileage >= SILVER && mileage < GOLD )
			rank = "Silver ���";
		else if( mileage >= GOLD && mileage < DIAMOND )
			rank = "Gold ���";
		else if( mileage >= DIAMOND && mileage < PLATINUM )
			rank = "Diamond ���";
//		else 
//			rank = "PLATINUM ���";
		else if( mileage >= PLATINUM )
			rank = "PLATINUM ���";
		else 
			rank = "ó���� �� ���� ���!!";
		return rank;
	}

}
