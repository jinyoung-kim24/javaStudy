package data.realnum;

public class RealCalMain4 {

	// 클래스 공통 상수 정의 (클래스 상수, 스태틱 상수)
	public static final float ZERODIV_ERROR = -0.001f;
	
	public static void main(String[] args) {
		//3.14f;
		float x = 20.333f, y = (float)Math.PI;
		float z = 0.0F; // 초기화(안전한 기준값) 습관
		
		// 실수 나눗셈 실행 후 출력하는 함수
		//dividePrint(x, y);
		dividePrint(365.0f, 31.0f); // 함수 호출
		dividePrint(x, y);
		// 실수 나눗셈 실행 후 그 결과를 리턴값으로 되돌려 줘서 z에 저장시키는 함수
//		y = 0.0f;
//		final float ZERODIV_ERROR = -0.001f; // 지역 상수 local constant
		z = divideReturn(x, y);
		//if( z == -0.001f )
		if( z == ZERODIV_ERROR )
			System.out.println("무한대 에러 발생!!!");
		else
			System.out.println("z = " + z);
		
		// result = (100.0f / 33.0f) / 2.0f;
		//float result = divideReturn(100.0f, 33f) / 2.0f;
		float result = 
			 divideReturn(divideReturn(100.0f, 33f), 2.0f);
			// 함수의 실행 결과 리턴값이 연이어서 다시 함수의 입력으로 사용됨.
		System.out.println("result = " + result);
		//
		float temp = divideReturn(100.0f, 33f); // 임시 기억하여 몇번 사용하기
		float result2 = divideReturn(temp, 2.0f);
		System.out.println("result2 = " + result2);
		System.out.println("temp = " + temp);
	} // main() 끝.

	
	
	public static float divideReturn(float a, float b) {
//		final float ZERODIV_ERROR = -0.001f; // 지역 상수 local constant
		if( b == 0.0f ) {
			System.out.println("0.0으로 나누는 시도! infinity!!");
			//return -0.001f; // ?
			return ZERODIV_ERROR;
		}
		float c = a / b; 
		
		return c; //0; // 0.0F; //0f; //0.0f;
	}

	// 함수 정의
	private static void dividePrint(float x, float y) {
		if( y == 0.0f ) {
			System.out.println("0.0으로 나누는 시도! infinity!!");
			return; // 리턴을 만나면 함수는 바로 종료.
					// 다만, void리턴형이기에 리턴값이 없음
		}
		
		float z = x / y;
		//System.out.printf("실수 나눗셈: %f ÷ %f = %f \n",
		System.out.printf("실수 나눗셈: %.2f ÷ %.2f = %.3f \n",
					x, y, z
					//3.0f, 3.2f, 3322.0f
				); 
		// %f같은 서식자에는 데이터나 변수가 
		// "순서, 개수, 타입"이 일치하면 문제없음 
		// ㄷ 한자키		
		//return;
	}

}


