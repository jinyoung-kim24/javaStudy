package judge;

public class JudgeMentMain3 {
		// 클래스 수준의 스태틱 상수 (static constant)
		// 클래스 내에서 모든함수안에서 공유되는 상수 정의
	public static final double SUCCESS_LEVEL = 62.0; // 62cm, 62.0d;]
	
	public static final double INCH_TO_CM = 2.54;
		// inch가 cm로 변환되는 비율 ratio 상수

	public static void main(String[] args) {
		//final double SUCCESS_LEVEL = 62.0; // 62cm, 62.0d;]
		// 지역상수 ( local constant)
		// 런닝맨 제자리 멀리뛰기 판정 프로그램
		// 제자리 기준에서 멀리뛰면 inch단위의 기록이 측정됨
		// 인치 줄자를 가지고 inch로 거리를 잰다.
		// 1.0 inch = 약 2.54cm  (길이 단위의 비율)
		// 승부/등수 판단은 inch단위가 아니라 cm단위로 하겠음. (변환문제)
		// 판단 로직의 성공과 실패의 기준은 cm 단위로 62cm로 일단 기준을 정함.
		
		// 변수 선언 및 초기화
		double 광수_record = 20.0; // 20 inches
		double 재석_record = 55.78;
		double 하하_record = 24.21;
		double 종국_record = 0.0;
		double 광수_cm = 0.0; // 0.0d;
		double 재석_cm = 0.0;
		double 하하_cm = 0.0;
		double 종국_cm = 0.0;
		
		// 데이터 처리부 (판정)
		// 먼저 cm로 기록 데이터를 변환하고 그 변환값을 기준으로 판정을 수행 
		//광수_cm = 광수_record * INCH_TO_CM;
		광수_cm = convertInchToCm(광수_record); 
		재석_cm = convertInchToCm(재석_record);
		하하_cm = convertInchToCm(하하_record);
		종국_cm = convertInchToCm(종국_record);														
		
		
		// 판정 결과 출력
		System.out.println("== 런닝맨 제자리 멀리뛰기 판정 프로그램 ==");
//		String runningMan =  "광수";
//		System.out.println("R멤버 이름: " + runningMan);
//		System.out.printf("\t레코드: %.2f inch ==> %.2f cm \n",광수_record, 광수_cm );
//		
//		if(광수_cm >=SUCCESS_LEVEL) // 비교판정은 cm 단위로 통일하여 진행
//			System.out.println("<<< 유효 SUCCESS >>>");
//		else
//			System.out.println("<<< 탈락 FAILURE >>>"); 
		
		printJudgement("광수", 광수_record, 광수_cm);
		printJudgement("재석", 재석_record, 재석_cm);
		printJudgement("하하", 하하_record, 하하_cm);
		printJudgement("종국", 종국_record, 종국_cm);
	}
	public static void printJudgement(String runningMan, double record, double cm) {
		// return; // 리턴문을 만나면 함수는 바로 종료
		
		System.out.println("\nR멤버 이름: " + runningMan);
		System.out.printf("\t레코드: %.2f inch ==> %.2f cm \n",record, cm );
		
		if(cm >=SUCCESS_LEVEL) // 비교판정은 cm 단위로 통일하여 진행
			System.out.println("<<< 유효 SUCCESS >>>");
		else
			System.out.println("<<< 탈락 FAILURE >>>"); 
		System.out.println("---------------------------\n");
		
	}
	
		
	// inch입력을 cm로 '단위 변환'하여 리턴하는 함수
	private static double convertInchToCm(double inch) {
		double resultCm = 0.0;
		resultCm = inch * INCH_TO_CM; 
		return resultCm; // inch ==> cm
	}
	
	// cm입력을 inch로 '단위 변환'하여 리턴하는 함수
	public static double convertCmToInch(double cm) {
		double resultInch = 0.0;
		resultInch = cm / INCH_TO_CM;
		return resultInch; // cm ==> inch
		
		
	}
}
