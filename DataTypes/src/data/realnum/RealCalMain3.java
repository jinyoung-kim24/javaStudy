package data.realnum;

public class RealCalMain3 {

	public static void main(String[] args) {
		double a = 3, b = 4.0;
		//b = 0.0; //0.0f; //0;
		
		double c;
		if( b != 0.0 ) {  // ��������� Ÿ���� ��ġ�ϰ� ������.
		//if( b != 0.0f ) {
//		if( b != 0 ) {
			c = a / b;
		} else {
			c = -9.999999; // Infinity ���Ѵ�?
		}
		
		//System.out.println("a / b = c");
		System.out.printf(
			"%.2f / %.2f = %.4f\n", a, b, c);
//		System.out.printf(
//			"%.2f / %.2f = %.4f\n", a, b, a / b);
		// 3.00 / 0.00 = Infinity
		System.out.printf(
			"%%~~ %.2f / %.2f = %.4f\n", a, b, c);
		// %%�� '%'��ȣ �����ϳ���.
		
//		int t = 34.0; // error
//		long s = 34.0; // err
//		double u = 34;
		// %d�� ���� ��ġ�� ������ ������
		System.out.printf(
			"%d / %d = %d\n", (int)a, (int)b, (int)c);
		// ���� ���� ���� �߻�
		// java.util.IllegalFormatConversionException: d != java.lang.Double
	}

}
