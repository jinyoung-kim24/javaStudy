package data.realnum;

public class RealDataMain {

	private static float num3;

	public static void main(String[] args) {
		// �ڹ��� ��ġ�� ������ ǥ��(�� �� ����, ��)
		// ���� byte, short, int, long
		// Ȥ�� �Ǽ� float, double
		// ���� ǥ��: �ڹ��� �⺻�� ������ int�� ��� (4����Ʈ int)
        // 123       100        5         0 
		// �Ǽ�( �Ҽ��� )ǥ��: �ڹ��� �⺻ double�� ��� (8����Ʈ double)
		// 0.0       1.0       0.1       324.3432344334
		// float �Ǽ����� 4����Ʈ
		// �Ǽ��� ��ġ���� ũ�� �� ���� ������ �ƴ�!!!!!!
		// real number�� �Ǽ�, �Ҽ���
		// ======> ���е� (precision) ������ �ٷ�......
	    // 0, 0L, 0l, 0.0, 0.0F, 0.0f
		// f, F ��ġ�� ���� ���̸� 4����Ʈ �Ǽ��� float�� �����Ͱ� ��.
		//double PI = Math.PI
				//The double value that is closer than any other to pi, the ratio of the circumference of a circle to itsdiameter
		double num1 = 3.141592;
		double num2 = 3.14592653589793;
		double num3 = 3.14159265358979323846264338;
		float num4 = 3.14F;
		float num5 = 3.14592653589793F;
		float num5b = 3.1459265123456F;
 		float num6 = (float)num3;
 		
		
		System.out.println("�Ǽ��� ������ ǥ��;");
	    System.out.println("num1=" + num1);
	    System.out.println("num2=" + num2);
	    System.out.println("num3=" + num3);
	    System.out.println("num4=" + num4);
	    System.out.println("num5=" + num5);
	    System.out.println("num6=" + num6);
	    System.out.println("num5b=" + num5b);
	    
		
	}

}
