package operation;

public class OpMain3 {

	public static void main(String[] args) {
		// ����������: ����++ ����--  '��������'  incremental, decrease
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
		
		// ���������ڴ� ��� ���տ������� �� ���� (Composite Operator)
		int x = 10;
		++x;
		x++; // 
		x = x + 1;
		x += 1; // ���� ����
		x -= 1; // x= x-1; x--; --x;
		x += 5;
		x *= 3; // x = x * 3;
		x /= 2; // x = x / 2;
		x %= 2; // ������ ������  x = x % 2;
		
		
	}

}
