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

public class BranchMain6 {
	// ���ϸ��� pt ���������ִ� Ȱ�� Action, �� Action ��� ����
	static final int ACTION_NO_ACT = 0; // ����
	static final int ACTION_LOGIN = 1; // �α��� 50
	static final int ACTION_WRITE = 2; // �۾��� 100
	static final int ACTION_READ = 3; // ���б� 10
	static final int ACTION_LIKE = 4; // ���ƿ� 500
	static final int ACTION_PURCHASE = 5; // ��ǰ���� ������ 1~3% ����
	static final int ACTION_SERVICE = 6; // �ΰ����񽺴�?
	
	// �׼��� �� ��� ���� �� ���� 
	static final int EXIT_ACTION_LIMIT = 20; //10;
	
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
			//;
			activity = (int)(Math.random() * 6) + 1;			
			System.out.printf(">> %d ȸ�� Ȱ��: ", count);
			
			//System.out.println(activity);
			if( activity == ACTION_LOGIN ) {
				System.out.print("ACTION �α��� ����");
				mileage += 50;
			} else if( activity == ACTION_WRITE ) {
				System.out.print("ACTION �۾��� ����");
				mileage += 100;
			} else if( activity == ACTION_READ ) {
				System.out.print("ACTION ���б� ����");
				mileage += 10;
			} else if( activity == ACTION_LIKE ) {
				System.out.print("ACTION ���ƿ� ����");
				mileage += 500;
			} else if( activity == ACTION_PURCHASE ) {
				System.out.print("ACTION ��ǰ���� ����");
				int price = (int)(Math.random()*100000);
				mileage += getPurchaseMileage(price); 
			} else if( activity == ACTION_SERVICE ) {
				System.out.print("ACTION �ΰ����񽺰��� ����");
//				mileage += 5000; // ����
				// ������ �ΰ� ���� ���� 1 ~ 4 ����
				//int addSvc = (int)(Math.random()*4)+1; // 1 ~ 4
				int addSvc = (int)(Math.random()*4); // 0 ~ 3
				int[] ptsAddSvc = { 5000, 10000, 20000, 30000 };
				String[] namesAddSvc = {
					"��������", "�������", "������Ʈ����", "������Ư���ݰ�����"	
				}; // �迭 Array -- ���� ���� ���� �����͵��� �� �ϳ��� ��ǥ�̸����� ����.
				// �迭�� ptsAddSvc[0] ���...
				System.out.println("\n~~~ ������ �ΰ� ���� �̸�: "
							+ namesAddSvc[addSvc]);
				System.out.println("~~~ �ΰ����� ����pt: " 
							+ ptsAddSvc[addSvc]);
				int addSvcMile = ptsAddSvc[addSvc];
				mileage += addSvcMile;
			} else {
				System.out.println(
					">> ����ġ ���� activity: " + activity);
			}
			
			System.out.printf(" �� ���ϸ���: %d pt\n", mileage);
			
			// ���� ����
			if( count >= EXIT_ACTION_LIMIT ) flag = false;
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




/*
 		���� ���   ��..............
 		
>> 1 ȸ�� Ȱ��: ACTION ���б� ���� �� ���ϸ���: 3010 pt
>> 2 ȸ�� Ȱ��: ACTION �ΰ����񽺰��� ����
~~~ ������ �ΰ� ���� �̸�: ������Ư���ݰ�����
~~~ �ΰ����� ����pt: 30000
 �� ���ϸ���: 33010 pt
>> 3 ȸ�� Ȱ��: ACTION ���б� ���� �� ���ϸ���: 33020 pt
>> 4 ȸ�� Ȱ��: ACTION �۾��� ���� �� ���ϸ���: 33120 pt
>> 5 ȸ�� Ȱ��: ACTION �۾��� ���� �� ���ϸ���: 33220 pt
>> 6 ȸ�� Ȱ��: ACTION �α��� ���� �� ���ϸ���: 33270 pt
>> 7 ȸ�� Ȱ��: ACTION �ΰ����񽺰��� ����
~~~ ������ �ΰ� ���� �̸�: �������
~~~ �ΰ����� ����pt: 10000
 �� ���ϸ���: 43270 pt
>> 8 ȸ�� Ȱ��: ACTION ���б� ���� �� ���ϸ���: 43280 pt
>> 9 ȸ�� Ȱ��: ACTION �α��� ���� �� ���ϸ���: 43330 pt
>> 10 ȸ�� Ȱ��: ACTION �α��� ���� �� ���ϸ���: 43380 pt
>> 11 ȸ�� Ȱ��: ACTION �ΰ����񽺰��� ����
~~~ ������ �ΰ� ���� �̸�: ������Ʈ����
~~~ �ΰ����� ����pt: 20000
 �� ���ϸ���: 63380 pt
>> 12 ȸ�� Ȱ��: ACTION �ΰ����񽺰��� ����
~~~ ������ �ΰ� ���� �̸�: �������
~~~ �ΰ����� ����pt: 10000
 �� ���ϸ���: 73380 pt
>> 13 ȸ�� Ȱ��: ACTION �ΰ����񽺰��� ����
~~~ ������ �ΰ� ���� �̸�: ������Ư���ݰ�����
~~~ �ΰ����� ����pt: 30000
 �� ���ϸ���: 103380 pt
>> 14 ȸ�� Ȱ��: ACTION �۾��� ���� �� ���ϸ���: 103480 pt
>> 15 ȸ�� Ȱ��: ACTION �۾��� ���� �� ���ϸ���: 103580 pt
>> 16 ȸ�� Ȱ��: ACTION �۾��� ���� �� ���ϸ���: 103680 pt
>> 17 ȸ�� Ȱ��: ACTION �ΰ����񽺰��� ����
~~~ ������ �ΰ� ���� �̸�: ������Ʈ����
~~~ �ΰ����� ����pt: 20000
 �� ���ϸ���: 123680 pt
>> 18 ȸ�� Ȱ��: ACTION �۾��� ���� �� ���ϸ���: 123780 pt
>> 19 ȸ�� Ȱ��: ACTION �ΰ����񽺰��� ����
~~~ ������ �ΰ� ���� �̸�: ��������
~~~ �ΰ����� ����pt: 5000
 �� ���ϸ���: 128780 pt
>> 20 ȸ�� Ȱ��: ACTION ��ǰ���� ����	��ǰ ���ž�: 78203��
	percent = 1.1242456890300183% ������
	purchaseMile 879pt
 �� ���ϸ���: 129659 pt
-----------------
>> ȸ�� �̸�: ���
>> ȸ�� ���ϸ���: 129659pt
>> ȸ�� ���: PLATINUM ���
-----------------
 		
 		
 		
 */ 
