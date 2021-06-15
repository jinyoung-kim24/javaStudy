package data.realnum;

public class RealDataMain {

	private static float num3;

	public static void main(String[] args) {
		// 자바의 수치형 데이터 표현(셀 수 있음, 양)
		// 정수 byte, short, int, long
		// 혹은 실수 float, double
		// 정수 표현: 자바의 기본은 무조건 int형 취급 (4바이트 int)
        // 123       100        5         0 
		// 실수( 소수점 )표현: 자바의 기본 double형 취급 (8바이트 double)
		// 0.0       1.0       0.1       324.3432344334
		// float 실수형은 4바이트
		// 실수형 수치값의 크기 및 양의 개념이 아님!!!!!!
		// real number는 실수, 소숫점
		// ======> 정밀도 (precision) 문제를 다룸......
	    // 0, 0L, 0l, 0.0, 0.0F, 0.0f
		// f, F 수치값 끝에 붙이면 4바이트 실수형 float형 데이터가 됨.
		//double PI = Math.PI
				//The double value that is closer than any other to pi, the ratio of the circumference of a circle to itsdiameter
		double num1 = 3.141592;
		double num2 = 3.14592653589793;
		double num3 = 3.14159265358979323846264338;
		float num4 = 3.14F;
		float num5 = 3.14592653589793F;
		float num5b = 3.1459265123456F;
 		float num6 = (float)num3;
 		
		
		System.out.println("실수형 데이터 표시;");
	    System.out.println("num1=" + num1);
	    System.out.println("num2=" + num2);
	    System.out.println("num3=" + num3);
	    System.out.println("num4=" + num4);
	    System.out.println("num5=" + num5);
	    System.out.println("num6=" + num6);
	    System.out.println("num5b=" + num5b);
	    
		
	}

}
