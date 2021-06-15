package data.realnum;

public class RealCalMain4 {

	// Ŭ���� ���� ��� ���� (Ŭ���� ���, ����ƽ ���)
	public static final float ZERODIV_ERROR = -0.001f;
	
	public static void main(String[] args) {
		//3.14f;
		float x = 20.333f, y = (float)Math.PI;
		float z = 0.0F; // �ʱ�ȭ(������ ���ذ�) ����
		
		// �Ǽ� ������ ���� �� ����ϴ� �Լ�
		//dividePrint(x, y);
		dividePrint(365.0f, 31.0f); // �Լ� ȣ��
		dividePrint(x, y);
		// �Ǽ� ������ ���� �� �� ����� ���ϰ����� �ǵ��� �༭ z�� �����Ű�� �Լ�
//		y = 0.0f;
//		final float ZERODIV_ERROR = -0.001f; // ���� ��� local constant
		z = divideReturn(x, y);
		//if( z == -0.001f )
		if( z == ZERODIV_ERROR )
			System.out.println("���Ѵ� ���� �߻�!!!");
		else
			System.out.println("z = " + z);
		
		// result = (100.0f / 33.0f) / 2.0f;
		//float result = divideReturn(100.0f, 33f) / 2.0f;
		float result = 
			 divideReturn(divideReturn(100.0f, 33f), 2.0f);
			// �Լ��� ���� ��� ���ϰ��� ���̾ �ٽ� �Լ��� �Է����� ����.
		System.out.println("result = " + result);
		//
		float temp = divideReturn(100.0f, 33f); // �ӽ� ����Ͽ� ��� ����ϱ�
		float result2 = divideReturn(temp, 2.0f);
		System.out.println("result2 = " + result2);
		System.out.println("temp = " + temp);
	} // main() ��.

	
	
	public static float divideReturn(float a, float b) {
//		final float ZERODIV_ERROR = -0.001f; // ���� ��� local constant
		if( b == 0.0f ) {
			System.out.println("0.0���� ������ �õ�! infinity!!");
			//return -0.001f; // ?
			return ZERODIV_ERROR;
		}
		float c = a / b; 
		
		return c; //0; // 0.0F; //0f; //0.0f;
	}

	// �Լ� ����
	private static void dividePrint(float x, float y) {
		if( y == 0.0f ) {
			System.out.println("0.0���� ������ �õ�! infinity!!");
			return; // ������ ������ �Լ��� �ٷ� ����.
					// �ٸ�, void�������̱⿡ ���ϰ��� ����
		}
		
		float z = x / y;
		//System.out.printf("�Ǽ� ������: %f �� %f = %f \n",
		System.out.printf("�Ǽ� ������: %.2f �� %.2f = %.3f \n",
					x, y, z
					//3.0f, 3.2f, 3322.0f
				); 
		// %f���� �����ڿ��� �����ͳ� ������ 
		// "����, ����, Ÿ��"�� ��ġ�ϸ� �������� 
		// �� ����Ű		
		//return;
	}

}


