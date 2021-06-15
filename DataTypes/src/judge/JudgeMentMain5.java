package judge;

public class JudgeMentMain5 {
		// Ŭ���� ������ ����ƽ ��� (static constant)
		// Ŭ���� ������ ����Լ��ȿ��� �����Ǵ� ��� ����
	public static final double SUCCESS_LEVEL = 62.0; // 62cm, 62.0d;]
	
	public static final double INCH_TO_CM = 2.54;
		// inch�� cm�� ��ȯ�Ǵ� ���� ratio ���

	public static void main(String[] args) {
		//final double SUCCESS_LEVEL = 62.0; // 62cm, 62.0d;]
		// ������� ( local constant)
		// ���׸� ���ڸ� �ָ��ٱ� ���� ���α׷�
		// ���ڸ� ���ؿ��� �ָ��ٸ� inch������ ����� ������
		// ��ġ ���ڸ� ������ inch�� �Ÿ��� ���.
		// 1.0 inch = �� 2.54cm  (���� ������ ����)
		// �º�/��� �Ǵ��� inch������ �ƴ϶� cm������ �ϰ���. (��ȯ����)
		// �Ǵ� ������ ������ ������ ������ cm ������ 62cm�� �ϴ� ������ ����.
		
		// ���� ���� �� �ʱ�ȭ
		double ����_record = 20.0; // 20 inches
		double �缮_record = 55.78;
		double ����_record = 24.21;											
		double ����_record = 0.0;
		
		// �ݺ��� loop = Ư�� ����(���)�� ������ Ȥ�� ������ ������.
		// while(���ǽ�) {���;} // ���ǽ��� true�̸� ��� ����....
		
		//Ư�� �Է� ó��
		����_record = Math.random() * 40; // 0.00000000xx ~ 99.9999999999xx inch
		//while(true) {} // ���� ����
		final double ����_NEW_RECORD = 200.0;
		int count = 0; // ī���� ���� 
		//long lcount = 0; // 8����Ʈ
		boolean loopFlag = true; // �ݺ��� ���� ���� ����
		while(loopFlag) {
			����_record = Math.random() * 100;
			double ����_cm = convertInchToCm(����_record);
			// ����� 2m(200.0cm)�� ���� ������ ������ ��� �ݺ��ϰڴٰ� ������ ����
			count = count + 1; // 1�� ���� �����ϴ� ī���� ��Ϻ���....
			System.out.println(count + "��°----- ������ ����:" + ����_cm + "cm");
			//if(����_cm >=����_NEW_RECORD) // �������� ���� ���� üũ�ϱ�
			if(count == 100)  // 5���� ���� ���� �� ���� ����..
				loopFlag = false;
			//loopFlag = false; // ���� ���ʿ� ���� ���� �����ϰ� ����..
			
		}
		System.out.printf(">> ���� ī��Ʈ ȸ��: %d \n", count);
		// ������ ó���� (����)
		// ���� cm�� ��� �����͸� ��ȯ�ϰ� �� ��ȯ���� �������� ������ ���� 
		//����_cm = ����_record * INCH_TO_CM;
															
		
		
		// ���� ��� ���
		System.out.println("== ���׸� ���ڸ� �ָ��ٱ� ���� ���α׷� ==");
//		String runningMan =  "����";
//		System.out.println("R��� �̸�: " + runningMan);
//		System.out.printf("\t���ڵ�: %.2f inch ==> %.2f cm \n",����_record, ����_cm );
//		
//		if(����_cm >=SUCCESS_LEVEL) // �������� cm ������ �����Ͽ� ����
//			System.out.println("<<< ��ȿ SUCCESS >>>");
//		else
//			System.out.println("<<< Ż�� FAILURE >>>"); 
			// ���� ��� ��� (������ó�� ����)
		printJudgementForInch("����", ����_record);
		printJudgementForInch("�缮", �缮_record);
		printJudgementForInch("����", ����_record);
		printJudgementForInch("����", ����_record);
	}
	public static void printJudgementForInch(String runningMan, double record) {
		// return; // ���Ϲ��� ������ �Լ��� �ٷ� ����
		// record ���� ���� üũ??
		double cm = convertInchToCm(record);
		System.out.println("\nR��� �̸�: " + runningMan);
		System.out.printf("\t���ڵ�: %.2f inch ==> %.2f cm \n",record, cm );
		
		if(cm >=SUCCESS_LEVEL) // �������� cm ������ �����Ͽ� ����
			System.out.println("<<< ��ȿ SUCCESS >>>");
		else
			System.out.println("<<< Ż�� FAILURE >>>"); 
		System.out.println("---------------------------\n");
		
	}
	
		
	// inch�Է��� cm�� '���� ��ȯ'�Ͽ� �����ϴ� �Լ�
	private static double convertInchToCm(double inch) {
		double resultCm = 0.0;
		resultCm = inch * INCH_TO_CM; 
		return resultCm; // inch ==> cm
	}
	
	// cm�Է��� inch�� '���� ��ȯ'�Ͽ� �����ϴ� �Լ�
	public static double convertCmToInch(double cm) {
		double resultInch = 0.0;
		resultInch = cm / INCH_TO_CM;
		return resultInch; // cm ==> inch
		
		
	}
}
