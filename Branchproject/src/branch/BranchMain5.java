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

public class BranchMain5 {
	// ���ϸ��� pt ���������ִ� Ȱ�� Action, �� Action ��� ����
	static final int ACTION_NO_ACT = 0; // ����
	static final int ACTION_LOGIN = 1; // �α��� 50
	static final int ACTION_WRITE = 2; // �۾��� 100
	static final int ACTION_READ = 3; // ���б� 10
	static final int ACTION_LIKE = 4; // ���ƿ� 500
	static final int ACTION_PURCHASE = 5; // ��ǰ���� ������ 1~3% ����
	static final int ACTION_SERVICE = 6; // �ΰ����񽺴�?
	
	// �׼��� �� ��� ���� �� ���� 
	static final int EXIT_ACTION_LIMIT = 10;
	
	// ���ϸ��� ����Ʈ�� ��� �Ǵ��� ���� ���� ���
	public static final int PLATINUM = 100000;
	public static final int DIAMOND = 40000;
	public static final int GOLD = 20000;
	public static final int SILVER = 12000;
	public static final int BRONZE = 5000;
	public static final int BASIC = 0; // �̻�~ ����
	public static final String NO_RANK = "��� ����";
	public static final int DEF_POINT = 3000;
	
	
	public static int getPurchaseMileage(int price) {
		int purchaseMile = 0;
		
		// ���� Ȱ���� ���� ���� => ���Ż�ǰ ������ 1.x ~ 3.0% ����(�ݿø�)
//		mileage = mileage + 2000;
//		int price = 50000; // ���Ż�ǰ ����
		
		double percent = Math.random() * 3.0 + 1.0;
		if( percent > 3.0 ) percent = 3.0; // ���� ���� (�ִ밪)
		
//		int purchaseMile = (int)(price * 0.01);  // 1%
//		purchaseMile = (int) Math.round(price * 0.01);
		purchaseMile = (int)(Math.round(price 
				* percent / 100.0));// �����(%) 
		
		System.out.println("\t��ǰ ���ž�: " + price + "��");
		System.out.println("\tpercent = " + percent + "% ������");
		System.out.println("\tpurchaseMile "
						+ purchaseMile + "pt");	
		
		return purchaseMile;
	}

	public static void main(String[] args) {		
		// ���ϸ��� ����
		// ȸ�� �ʱ�ȭ
		String name = "���";
		int mileage = DEF_POINT; // ȸ�� ����(Ȱ��)   12000;
		
		int activity = ACTION_NO_ACT; //0
				
		// ȸ�� Ȱ��: ����, �۾���, �α���, ���, ���ƿ�, ����, �ΰ����� ����, ���..
		// 	=> ����Ʈ�� �߻���Ű�� ȸ�� Ȱ����... (�ð�, ���� ���� ���)
		int count = 1;
		boolean flag = true;
		while(flag) {
			activity = (int) (Math.random() * 6) + 1;
			
			System.out.printf(">> %d ȸ�� Ȱ�� :", count);
			
			System.out.println(activity);
			
			System.out.printf(" �� ���ϸ���: %d pt\n", mileage);
			// ����
			if(count >= EXIT_ACTION_LIMIT) flag = false;
					count++;
		}
		
				
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
