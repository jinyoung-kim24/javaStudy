package grade;

public class GradeMain {

	public static void main(String[] args) {
		// �ڰ����� ���� ���� �� ���α׷�
		// ���� ��������� 60.0 �̻��̸� �հ�, �̸��̸� ���հ�... ����.
		// ��� ���Ǻ� ------
		final int NUMBER_OF_SUBJECTS =4; // �����
		final String TITLE = "���� ��� ���α׷� -- ver 1.0";
		final String BEGIN_ROW = "������������������������������������������";
		final String END_ROW = "��������������������������������������������";
		final String DOUBLE_ROW = "========================";
		final String SINGLE_ROW = "------------------------";
		
		// ���� ����� (�ʱ�ȭ) ------
		String name = "����"; // ������
		String subject1 = "���α׷��� ���"; // �����1
		int subscore1 = 13; // ����1����
		String subject2 = "���ڰ��� ����"; // �����2
		int subscore2 = 59; // ����2����
		String subject3 = "�����ͺ��̽�";  // �����3
		int subscore3 = 40+28; // ����3����
		String subject4 = "�˰���";    // �����4
		int subscore4 = 100; // ����4����
		
		int totalScore = 0; // ���� ���� ��� ����� 
		double averageScore = 0.0; // ��� ���� ��� ����� (������)
		// ��� ó���� (�˰��� ����) -----
		// ����
		totalScore = subscore1 + subscore2 + subscore3 + subscore4;
		//totalScore = (((subscore1 + subscore2) + subscore3) + subscore4); // �������..
		// ���
		//averageScore = (subscore1 + subscore2 + subscore3 + subscore4) / 4 ; // �������� ������ ����� ����.
		//averageScore = (subscore1 + subscore2 + subscore3 + subscore4) / (double)4.0; // �Ǽ��� ����
		averageScore = (double) totalScore
				/ NUMBER_OF_SUBJECTS;// �Ǽ��� ĳ�����Ͽ� ����
		//averageScore = (double)( (subscore1 + subscore2 + subscore3 + subscore4) / 4); // ������ �ս� �� ĳ������... ����!!!
 
		// ��º�  -----
		System.out.println(BEGIN_ROW);
		System.out.println(TITLE);
		System.out.println(DOUBLE_ROW);
		System.out.println("* �л���:" + name);
		System.out.println(SINGLE_ROW);
		System.out.printf("* [%s] ����: %d��\n", subject1 , subscore1);
		System.out.printf("* [%s] ����: %d��\n", subject2, subscore2);
		System.out.printf("* [%s] ����: %d��\n", subject3, subscore3);
		System.out.printf("* [%s] ����: %d��\n", subject4, subscore4);
		System.out.println(SINGLE_ROW);
		System.out.printf(" ���� ����: %d�� (%d ����)\n",
				totalScore, 4);
		System.out.println(SINGLE_ROW);
		System.out.printf(" ��� ����: %.2f��\n",
				averageScore);
		System.out.println(DOUBLE_ROW);
		

		// �հ� ���� ���� ��º�
		final double PASS_SCORE = 60.0;
		if(averageScore >= PASS_SCORE && averageScore <= 100.0) // �̻�
			System.out.println(" �ڡڡ� �հ� �ڡڡ� ");
		else // �̸� averageScore < 60 ....
			System.out.println(" ���հ� �Ф�");	
		System.out.println(END_ROW);
		

	}
}
