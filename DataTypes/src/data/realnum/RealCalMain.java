package data.realnum;

public class RealCalMain {

	public static void main(String[] args) {
		int a = 3;
		long b = 3L;
		long c = 3;
		double x = 3.14f;
		double y = Math.PI; // ����ƽ ��� PI ��
		
		// �������
		double z1 = x + y;
		double z2 = x - y;
		double z3 = x * y;
		double z4 = x / y;
		
		System.out.println(x + "+" + y + "=" + z1);
		System.out.println(x + "-" + y + "=" + z2);
		System.out.println(x + "*" + y + "=" + z3);
		System.out.println(x + "/" + y + "=" + z4);
		
		System.out.printf("%.2f + %.2f = %.2f \n", x, y, z1);
		System.out.printf("%.2f + %.2f = %.2f \n", x, y, z2);
		System.out.printf("%.2f + %.2f = %.2f \n", x, y, z3);
		System.out.printf("%.2f + %.2f = %.3f \n", x, y, z4);
		
		
		// printf() ���� format�� ������ ���
		// %f ���� ������ ���߿� ��ȭ�� ���̳� ���� ���� �����Ͱ� �����ڿ� ��ġ�� ��µ�.
		// 3.140000 ���ϱ�  0.990000 ��? 1.000000
		// %f�� �Ǽ��� �Ҽ��� �ڸ��� �����͸� ������ִ� ��������.
		// %.3f�� �Ҽ��� ���� 3�ڸ��� ����ϱ��� ��.
		//System.out.printf(" %f ���ϱ�  %f ��? %f \n", 3.14, 0.99, 1.0);
		//System.out.printf(" %.2f ���ϱ�  %.2f ��? %.2f \n ",
								//3.14, 0.99, 1.0);

	}

}
