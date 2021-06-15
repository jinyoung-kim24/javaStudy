package data.realnum;

public class RealCalMain2 {
	
	public static void printRealNumber(double first, double second, double result) {
		System.out.printf("%.2f + %.2f = %.2f \n", first, second, result);
	}
	
	// op => "+", "-", "*", "/"
	public static void printRealNumberCal(double first, String op, double second, double result) {
		System.out.printf("%.2f %s %.2f = %.2f \n", first, op, second, result);
		
	}
		
	public static void main(String[] args) {
		int a = 3;
		long b = 3L;
		long c = 3;
		double x = 3.14f;
		double y = Math.PI; // 스태틱 상수 PI ∏
		
		// 산술연산
		double z1 = x + y;
		double z2 = x - y;
		double z3 = x * y;
		double z4 = x / y;
		
		printRealNumberCal(x, "+", y, z1);
		printRealNumberCal(x, "-", y, z2);
		printRealNumberCal(x, "*", y, z3);
		printRealNumberCal(x, "/", y, z4);
		
		//printRealNumberCal(10.00, "+", 5.12, 10.00 + 5.12);
		//printRealNumberCal(10.00, "-", 5.12, 10.00 - 5.12);
		//printRealNumberCal(10.00, "*", 5.12, 10.00 * 5.12);
		//printRealNumberCal(10.00, "/", 5.12, 10.00 / 5.12);
		
		
		//printRealNumber(3.14, 2, 5.14);
		//printRealNumber(3.14, 2.00, 3.14 + 2.00);
		//printRealNumber(x, y, z1);
		//printRealNumber(x, y, x + y);
		
		//System.out.println(x + "+" + y + "=" + z1);
		//System.out.println(x + "-" + y + "=" + z2);
		//System.out.println(x + "*" + y + "=" + z3);
		//System.out.println(x + "/" + y + "=" + z4);
		
		//System.out.printf("%.2f + %.2f = %.2f \n", x, y, z1);
		//System.out.printf("%.2f + %.2f = %.2f \n", x, y, z2);
		//System.out.printf("%.2f + %.2f = %.2f \n", x, y, z3);
		//System.out.printf("%.2f + %.2f = %.3f \n", x, y, z4);
		
		
		// printf() 포맷 format을 가지고 출력
		// %f 같은 서식자 나중에 변화는 값이나 변수 같은 데이터가 서식자에 위치에 출력됨.
		// 3.140000 더하기  0.990000 는? 1.000000
		// %f는 실수형 소수점 자리수 데이터를 출력해주는 서식자임.
		// %.3f는 소수점 이하 3자리만 출력하기라는 뜻.
		//System.out.printf(" %f 더하기  %f 는? %f \n", 3.14, 0.99, 1.0);
		//System.out.printf(" %.2f 더하기  %.2f 는? %.2f \n ",
								//3.14, 0.99, 1.0);

	}

}
