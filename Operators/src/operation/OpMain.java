package operation;

public class OpMain {

	public static void main(String[] args) {
		// ��������� Arithmetic Operators
		// + - * / % 
		int one = 200;
		int two = 101;
		int nResult1 = one + two;
		int nResult2 = one - two;
		int nResult3 = one * two;
		int nResult4 = 0;
		float fResult4 = 0.0f;
		float fResult5 = 0.0f;
		if(two != 0) { // ����?
			// ������ �Ǵ� ���� ���
			nResult4 = one / two;
			fResult4 = (float)one / two;
			// �����Լ� - �ݿø�, ����, ����
			//fResult5 = Math.round(one / (float)two); // 0.5~
			//fResult5 = (float) Math.ceil(3.99);  // 4.0
			//fResult5 = (float) Math.ceil(3.01);  // 4.0
			//fResult5 = (float) Math.ceil(3); // 3.0 
			//fResult5 = (float)Math.ceil(one / (float)two);
			//fResult5 = (float)Math.floor(3.65); // 3.0
			//fResult5 = (float)Math.floor(3.01); // 3.0
			//fResult5 = (float)Math.floor(-2.05); // -3.0
			//fResult5 = (float)Math.floor(-0.01); // -1.000
		}else {
			System.out.println("zero ������ �õ�!!");
			
		}
		System.out.printf("������ ���: %d \r\n",nResult4);
		System.out.printf("������ ���: %.2f \r\n",fResult4);
		System.out.printf("������ ���Math: %.3f \r\n",fResult5);
	}

}
