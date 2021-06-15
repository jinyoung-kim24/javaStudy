package operation;

public class OpMain3 {

	public static void main(String[] args) {
		// 증감연상자: 증가++ 감소--  '점진적인'  incremental, decrease
		// pre ++A --B post C++ D--
		int one = 10, two = 20;
		int nResult = 0;
		//nResult = one++;  //++one;
		//nResult = one--; //--one;
		nResult = ++one + two--; // 11 + 20 = 31
		System.out.println("one = " + one);
		System.out.println("two = " + two);
		System.out.println("nResult = " + nResult);
		// 
		nResult = 0;
		//nResult = one-- * 10 + ++two;
		nResult = one * 10;
		one = one - 1;
		two = two + 1;
		nResult = nResult + two;
		System.out.println("one = " + one);
		System.out.println("two = " + two);
		System.out.println("nResult = " + nResult);
		
		//
		nResult = 0;
		nResult = (one-- + two--) / ++one;
		System.out.println("one = " + one);
		System.out.println("two = " + two);
		System.out.println("nResult = " + nResult);
		
		// 증감연산자는 사실 복합연산자의 한 종류 (Composite Operator)
		int x = 10;
		++x;
		x++; // 
		x = x + 1;
		x += 1; // 복합 덧셈
		x -= 1; // x= x-1; x--; --x;
		x += 5;
		x *= 3; // x = x * 3;
		x /= 2; // x = x / 2;
		x %= 2; // 나머지 연산자  x = x % 2;
		
		
	}

}
