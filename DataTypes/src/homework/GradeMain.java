package homework;
/*
������������������������������������������������������
 ���� ��� ���α׷� -- ver 1.0
===========================
* �л���: �ȳ�
---------------------------
* [���α׷��� ���] ����: 13�� 
* [���ڰ��� ����] ����: 59�� 
* [�����ͺ��̽�] ����: 40�� 
* [�˰���] ����: 100�� 
---------------------------
 ���� ����: 212�� (4 ����) 
---------------------------
 ��� ����: 53.00�� 
===========================
 ���հ� �Ф� 
������������������������������������������������������

������������������������������������������������������
 ���� ��� ���α׷� -- ver 1.0
===========================
* �л���: �ȳ�
---------------------------
* [���α׷��� ���] ����: 13�� 
* [���ڰ��� ����] ����: 59�� 
* [�����ͺ��̽�] ����: 68�� 
* [�˰���] ����: 100�� 
---------------------------
 ���� ����: 240�� (4 ����) 
---------------------------
 ��� ����: 60.00�� 
===========================
 �ڡڡ� �հ� �ڡڡ�
������������������������������������������������������


*/

// ����.... 

public class GradeMain {

	public static void main(String[] args) {
		// �ڰ����� ���� ���� �� ���α׷�
		// ���� ��������� 60.0 �̻��̸� �հ�, �̸��̸� ���հ�... ����.
		
		// ��� ���Ǻ� ------
		final int NUMBER_OF_SUBJECTS = 4; // �����
		final String TITLE = " ���� ��� ���α׷� -- ver 1.0";
		final String BEGIN_ROW = "������������������������������������������������������";
		final String END_ROW = "������������������������������������������������������";
		final String DOUBLE_ROW = "===========================";
		final String SINGLE_ROW = "---------------------------";		

		// ���� ����� (�ʱ�ȭ) ------
//		String name = "����"; // ������
//		String subject1 = "���α׷��� ���"; // ����� 1 
//		int subScore1 = 100; // ����1 ���� 
//		String subject2 = "���ڰ��� ����"; // ����� 2
//		int subScore2 = 40; // ����2 ���� 
//		String subject3 = "�����ͺ��̽�"; 	// ����� 3
//		int subScore3 = 60; // ����3 ���� 
//		String subject4 = "�˰���";		// ����� 4
//		int subScore4 = 83; // ����4 ���� 
		
		String name = "�ȳ�"; // ������
		String subject1 = "���α׷��� ���"; // ����� 1 
		int subScore1 = 13; // ����1 ���� 
		String subject2 = "���ڰ��� ����"; // ����� 2
		int subScore2 = 59; // ����2 ���� 
		String subject3 = "�����ͺ��̽�"; 	// ����� 3
		int subScore3 = 40+28;// +27;// 27.6; // 39.6; // ����3 ���� 
		String subject4 = "�˰���";		// ����� 4
		int subScore4 = 100; // ����4 ���� 
		
		int totalScore = 0; // ���� ���� ��� �����
		double averageScore = 0.0;	// ��� ���� ��� ����� (������)
		
		// ��� ó���� (�˰��� ����) ------
		// ����
		totalScore = getSumScores(subScore1, 
				subScore2, subScore3, subScore4);
//		totalScore = subScore1 + subScore2 
//					+ subScore3 + subScore4;
//		totalScore = (((subScore1 + subScore2) 
//				+ subScore3) + subScore4); // �������..
		// ��� (������)
//		averageScore = (subScore1 + subScore2 
//				+ subScore3 + subScore4) / 4; // �������� ������ ����� ����.
//		averageScore = (subScore1 + subScore2 
//				+ subScore3 + subScore4) / 4.0; // �Ǽ��� ����
//		averageScore = (subScore1 + subScore2 
//				+ subScore3 + subScore4) / (double)4;
//										// �Ǽ��� ĳ�����Ͽ� ����
//		averageScore = (double)(subScore1 + subScore2 
//				+ subScore3 + subScore4) / 4;
//										// �Ǽ��� ĳ�����Ͽ� ����
//		averageScore = (double)(subScore1 + subScore2 
//				+ subScore3 + subScore4) / (double)4;
//										// �Ǽ��� ĳ�����Ͽ� ����
//		averageScore = (double) ( (subScore1 + subScore2 
//				+ subScore3 + subScore4) / 4 );	
//						// ������ �ս� �� ĳ������... ����!!! 	
//		averageScore = (double)totalScore 
//							/ NUMBER_OF_SUBJECTS;
		averageScore = getAvgScore(subScore1, 
				subScore2, subScore3, subScore4);
		
		// ��º� ------
		System.out.println(BEGIN_ROW);
		System.out.println(TITLE);
		System.out.println(DOUBLE_ROW);
		System.out.println("* �л���: " + name );
		System.out.println(SINGLE_ROW);
		System.out.printf("* [%s] ����: %d�� \n", subject1, subScore1);
		System.out.printf("* [%s] ����: %d�� \n", subject2, subScore2);
		System.out.printf("* [%s] ����: %d�� \n", subject3, subScore3);
		System.out.printf("* [%s] ����: %d�� \n", subject4, subScore4);
		//System.out.printf("* [%s] ����: %d�� \n", "", 0);
		System.out.println(SINGLE_ROW);
		
		System.out.printf(" ���� ����: %d�� (%d ����) \n",
						totalScore, 4);
		System.out.println(SINGLE_ROW);
		System.out.printf(" ��� ����: %.2f�� \n", averageScore);
		System.out.println(DOUBLE_ROW);
		
		// �հ����� ���� ��º�
//		final double PASS_SCORE = 60.0;
//		//if( averageScore >= PASS_SCORE ) // �̻�
//		if( averageScore >= PASS_SCORE && averageScore <= 100.0 )
//			System.out.println(" �ڡڡ� �հ� �ڡڡ�");
//		else // �̸� averageScore < 60...
//			System.out.println(" ���հ� �Ф� ");
		String passMsg = "";
		passMsg = getPassMark(averageScore);
		System.out.println(passMsg);
		System.out.println(END_ROW);
	}

	
	
	private static String getPassMark(double averageScore) {
		// TODO ��� ������ �Է¹޾� �հ�/���հ��� �����Ͽ� ���ڿ� �����ϴ� �Լ�
		String msg = "";
		if(averageScore >= 60) {
			msg = "�ڡڡ� �հ� �ڡڡ�";
		}
		else {
			msg = "���հ� �Ф�";
		}
		return msg;

	}
	private static double getAvgScore(int subScore1, int subScore2, int subScore3, int subScore4) {
		// TODO ��� ���� �����ϴ� �Լ� ����
		double average = getSumScores(subScore1, subScore2, subScore3, subScore4) / (double)4;
		//double average = (subScore1 + subScore2 + subScore3 + subScore4) / (double)4;
		return average;
	}



	private static int getSumScores(int subScore1, int subScore2, int subScore3, int subScore4) {
		// TODO ������ �����ϴ� �Լ� ���� 
		int total = subScore1 + subScore2 + subScore3 + subScore4;
		
		return total;
	}

}
