package branch;


// ���ϸ��� ���� �� ��� ���� ���α׷�
/*
 PLATINUM ��� 100000~�̻�
 DIAMOND ��� 40000�̻� ~ 100000�̸�
 GOLD ��� 20000�̻� ~ 40000�̸�
 SIVER ��� 12000�̻� ~ 20000�̸�
 BRONZE ���5000�̻� ~ 12000�̸�
 BASIC �⺻���0(�̻�) ~ 5000�̸�
 */


public class BranchMain{
	// ���ϸ��� ����Ʈ�� ��� �Ǵ��� ���� ���� ��� 
	public static final int PLATINUM = 100000;
	public static final int DIAMOND = 40000;
	public static final int GOLD = 20000;
	public static final int SIVER = 12000;
	public static final int BRONZE = 5000;
	public static final int BASIC = 0; // �̻�~ ���� 
	public static final String NO_RANK = "��޾���";
	

	public static void main(String[] args) {
		// ���ϸ��� ����
		// ȸ�� �ʱ�ȭ
		String name = "���";
		int mileage = 12000;
		
		// ȸ�� Ȱ��: ����, �۾���, �α���, ���, ���ƿ�, ����, �ΰ����� ����, ���
		mileage = mileage + 2000; // ���� Ȱ���� ���� ����
		mileage += 7000; // �ΰ� ���� ���Կ� ���� ����
		mileage += 20000; // ��ο� ���� ����
		
		// ��� ���� - pt�� ��� ������ ���ϴ���?
		String rank = NO_RANK;
		if(mileage >= BASIC && mileage < BRONZE)
			rank = "Basic ���";
		else if(mileage >= BRONZE && mileage < SIVER)
			rank = "Bronze���";
		else if(mileage >= SIVER && mileage < GOLD)
			rank = "Silver���";
		else if(mileage >= GOLD && mileage < DIAMOND)
			rank = "Gold���";
		else if(mileage >= DIAMOND && mileage < PLATINUM)
			rank = "Diamond���";
		else if(mileage >= PLATINUM)
			rank = "Platinum���";
		else 
			rank = "ó���� �� ���� ���!!";
		// ��� ���
		System.out.println("--------------------");
		System.out.println(">> ȸ�� �̸�: " + name);
		System.out.println(">> ȸ�� ���ϸ���: " + mileage + "pt");
		System.out.println(">> ȸ�� ���: " + rank);
		System.out.println("--------------------");
	}

}
 