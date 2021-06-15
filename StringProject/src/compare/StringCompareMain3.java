package compare;

public class StringCompareMain3 {

	public static void main(String[] args) {
		// ���� ��, ���ڹ迭(��ü) ��, ���ڿ� ��ü ��
		String a = "�����ͺ��̽�";
		String b = "JAVA";
		System.out.printf("a(%s) == b(%s) --> %s\n", a, b, (a == b));
		System.out.printf("a(%s) eqauls b(%s) --> %s\n", a, b, (a.equals(b)));
		
		String c = a;
		// c == a �� ��ü�� �ּҿ� ������ ��� ������(���ϼ� ��)
		System.out.printf("c(%s) == a(%s) --> %s\n", c, a, (c == a));
		// c.equals(a) �ΰ�ü�� ������ ��ġ��(��� ��)
		System.out.printf("c(%s) eqauls a(%s) --> %s\n", c, a, (c.equals(a)));
		
		String d = new String(a);
		// new�� ���ؼ� ���ο� �ּ��� ��ü Ȱ��
		System.out.printf("d(%s) == a(%s) --> %s\n", d, a, (d == a));
		System.out.printf("d(%s) eqauls a(%s) --> %s\n", d, a, (d.equals(a)));
		
//		char[] aArr = a.toCharArray();
		char[] aArr = {'��', '��', '��', '��', '��', '��'};
//		StringCompareMain2.compareCharArrays(aArr, d.toCharArray());
		String e = new String(aArr);
		
		System.out.printf("e(%s) == a(%s) --> %s\n", e, a, (e == a));
		System.out.printf("e(%s) eqauls a(%s) --> %s\n", e, a, (e.equals(a)));
		
		String f = "�����ͺ��̽�"; // ��ü ����� �ּҰ� ����
 		System.out.printf("f(%s) == a(%s) --> %s\n", f, a, (f == a));
		System.out.printf("f(%s) eqauls a(%s) --> %s\n", f, a, (f.equals(a)));
		
		String g = new String("�����ͺ��̽�");
		System.out.printf("g(%s) == a(%s) --> %s\n", g, a, (g == a));
		System.out.printf("g(%s) eqauls a(%s) --> %s\n", g, a, (g.equals(a)));
		
	}

}
