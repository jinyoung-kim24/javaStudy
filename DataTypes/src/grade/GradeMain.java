package grade;

public class GradeMain {

	public static void main(String[] args) {
		// 자격증에 대한 성적 평가 프로그램
		// 최종 평균점수가 60.0 이상이면 합격, 미만이면 불합격... 판정.
		// 상수 정의부 ------
		final int NUMBER_OF_SUBJECTS =4; // 과목수
		final String TITLE = "성적 출력 프로그램 -- ver 1.0";
		final String BEGIN_ROW = "┌───────────────────┐";
		final String END_ROW = "└────────────────────┘";
		final String DOUBLE_ROW = "========================";
		final String SINGLE_ROW = "------------------------";
		
		// 변수 선언부 (초기화) ------
		String name = "엘사"; // 응시자
		String subject1 = "프로그래밍 언어"; // 과목명1
		int subscore1 = 13; // 과목1점수
		String subject2 = "전자계산기 구조"; // 과목명2
		int subscore2 = 59; // 과목2점수
		String subject3 = "데이터베이스";  // 과목명3
		int subscore3 = 40+28; // 과목3점수
		String subject4 = "알고리즘";    // 과목명4
		int subscore4 = 100; // 과목4점수
		
		int totalScore = 0; // 총합 점수 결과 저장용 
		double averageScore = 0.0; // 평균 점수 결과 저장용 (산술평균)
		// 계산 처리부 (알고리즘 수행) -----
		// 총합
		totalScore = subscore1 + subscore2 + subscore3 + subscore4;
		//totalScore = (((subscore1 + subscore2) + subscore3) + subscore4); // 연산순서..
		// 평균
		//averageScore = (subscore1 + subscore2 + subscore3 + subscore4) / 4 ; // 정수끼리 연산은 결과도 정수.
		//averageScore = (subscore1 + subscore2 + subscore3 + subscore4) / (double)4.0; // 실수로 나눔
		averageScore = (double) totalScore
				/ NUMBER_OF_SUBJECTS;// 실수로 캐스팅하여 나눔
		//averageScore = (double)( (subscore1 + subscore2 + subscore3 + subscore4) / 4); // 데이터 손실 후 캐스팅임... 주의!!!
 
		// 출력부  -----
		System.out.println(BEGIN_ROW);
		System.out.println(TITLE);
		System.out.println(DOUBLE_ROW);
		System.out.println("* 학생명:" + name);
		System.out.println(SINGLE_ROW);
		System.out.printf("* [%s] 점수: %d점\n", subject1 , subscore1);
		System.out.printf("* [%s] 점수: %d점\n", subject2, subscore2);
		System.out.printf("* [%s] 점수: %d점\n", subject3, subscore3);
		System.out.printf("* [%s] 점수: %d점\n", subject4, subscore4);
		System.out.println(SINGLE_ROW);
		System.out.printf(" 총합 점수: %d점 (%d 과목)\n",
				totalScore, 4);
		System.out.println(SINGLE_ROW);
		System.out.printf(" 평균 점수: %.2f점\n",
				averageScore);
		System.out.println(DOUBLE_ROW);
		

		// 합격 유무 판정 출력부
		final double PASS_SCORE = 60.0;
		if(averageScore >= PASS_SCORE && averageScore <= 100.0) // 이상
			System.out.println(" ★★★ 합격 ★★★ ");
		else // 미만 averageScore < 60 ....
			System.out.println(" 불합격 ㅠㅠ");	
		System.out.println(END_ROW);
		

	}
}
