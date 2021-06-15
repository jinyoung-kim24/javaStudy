package judge;

public class JudgeMentMain5 {
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
		
		// 반복문 loop = 특정 구간(블록)을 여러번 혹은 무한히 수행함.
		// while(조건식) {명령;} // 조건식이 true이면 계속 실행....
		
		//특별 입력 처리
		종국_record = Math.random() * 40; // 0.00000000xx ~ 99.9999999999xx inch
		//while(true) {} // 무한 루프
		final double 종국_NEW_RECORD = 200.0;
		int count = 0; // 카운터 변수 
		//long lcount = 0; // 8바이트
		boolean loopFlag = true; // 반복문 루프 제어 변수
		while(loopFlag) {
			종국_record = Math.random() * 100;
			double 종국_cm = convertInchToCm(종국_record);
			// 기록이 2m(200.0cm)를 넘지 않으면 스스로 계속 반복하겠다고 기준을 정함
			count = count + 1; // 1씩 값이 증가하는 카운터 기록변수....
			System.out.println(count + "번째----- 종국의 도전:" + 종국_cm + "cm");
			//if(종국_cm >=종국_NEW_RECORD) // 종료조건 충족 여부 체크하기
			if(count == 100)  // 5번만 루프 실행 후 루프 종료..
				loopFlag = false;
			//loopFlag = false; // 다음 차례에 루프 시작 중지하고 나감..
			
		}
		System.out.printf(">> 최종 카운트 회수: %d \n", count);
		// 데이터 처리부 (판정)
		// 먼저 cm로 기록 데이터를 변환하고 그 변환값을 기준으로 판정을 수행 
		//광수_cm = 광수_record * INCH_TO_CM;
															
		
		
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
			// 판정 결과 출력 (데이터처리 포함)
		printJudgementForInch("광수", 광수_record);
		printJudgementForInch("재석", 재석_record);
		printJudgementForInch("하하", 하하_record);
		printJudgementForInch("종국", 종국_record);
	}
	public static void printJudgementForInch(String runningMan, double record) {
		// return; // 리턴문을 만나면 함수는 바로 종료
		// record 정상 범위 체크??
		double cm = convertInchToCm(record);
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
