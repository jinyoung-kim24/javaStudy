package greet.multiple;
//�Լ� ������ ����...
public class TestMain {
	
	public static String dummyName() {
		return "ȫ�浿";
	}

	public static int dummyInt() {
		return 100;
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int add2(int a, int b) {
		int temp = a + b;
		System.out.println("�ӽð��: "+ temp);
		return temp;
	}
	
	public static void main(String[] args) {
		int a = 60;
		int b = 100;
		int c = a + b; // 160
		System.out.println("c ��� = " + c);
		int d = add(a, b); // a + b
		System.out.println("d ��� = " + d);
		int e = add2(a, b); // a + b
		System.out.println("e ��� = " + e);
		System.out.println(dummyInt());
	}

}
