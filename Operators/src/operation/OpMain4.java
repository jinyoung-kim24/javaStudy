package operation;

public class OpMain4 {

	public static void main(String[] args) {
		// 증감 연산자 정리
		int a = 1, b = 1, c = 1, d = 1;
		// 실행전에 각 행의 출력결과를 예상으로 적어보자.
		System.out.println(a++ + a++); // 3 
		System.out.println("a =" + a); // 3
		System.out.println(++b + ++b); // 5
		System.out.println(b++ * 4 + ++b); //17 
		System.out.println("b = " + b); // 
		System.out.println(++c + c++); // 
		System.out.println("c = "+ c); // 
		System.out.println(d++ + ++d); //
		System.out.println("d = " + d);// 
	}

}
