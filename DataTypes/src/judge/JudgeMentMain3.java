package judge;

public class JudgeMentMain3 {
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
		double ����_cm = 0.0; // 0.0d;
		double �缮_cm = 0.0;
		double ����_cm = 0.0;
		double ����_cm = 0.0;
		
		// ������ ó���� (����)
		// ���� cm�� ��� �����͸� ��ȯ�ϰ� �� ��ȯ���� �������� ������ ���� 
		//����_cm = ����_record * INCH_TO_CM;
		����_cm = convertInchToCm(����_record); 
		�缮_cm = convertInchToCm(�缮_record);
		����_cm = convertInchToCm(����_record);
		����_cm = convertInchToCm(����_record);														
		
		
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
		
		printJudgement("����", ����_record, ����_cm);
		printJudgement("�缮", �缮_record, �缮_cm);
		printJudgement("����", ����_record, ����_cm);
		printJudgement("����", ����_record, ����_cm);
	}
	public static void printJudgement(String runningMan, double record, double cm) {
		// return; // ���Ϲ��� ������ �Լ��� �ٷ� ����
		
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
