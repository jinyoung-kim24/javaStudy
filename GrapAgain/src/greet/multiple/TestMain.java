package greet.multiple;
//함수 리턴의 이해...
public class TestMain {
	
	public static String dummyName() {
		return "홍길동";
	}

	public static int dummyInt() {
		return 100;
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int add2(int a, int b) {
		int temp = a + b;
		System.out.println("임시결과: "+ temp);
		return temp;
	}
	
	public static void main(String[] args) {
		int a = 60;
		int b = 100;
		int c = a + b; // 160
		System.out.println("c 결과 = " + c);
		int d = add(a, b); // a + b
		System.out.println("d 결과 = " + d);
		int e = add2(a, b); // a + b
		System.out.println("e 결과 = " + e);
		System.out.println(dummyInt());
	}

}
