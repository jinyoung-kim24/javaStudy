package basictype;

public class BasicDataMain {

	public static void main(String[] args) {
		// �⺻�� primitives
		// ��ġ�� 
		// ���ڷ� ������ ��ġ�� ũ�⸦ ǥ�� (number value)
		// ������ ����Ʈ ũ�Ⱑ �� Ÿ�Ժ��� ������(����)
		// �ڹ��� ��� ��ġ�� Ÿ�Ե��� ��� ��ȣ�� �ִ� signed�� +/-
		// �����迭: long 8 > int 4 > short 2 > byte 1
		// 			=> �ڹ��� �������ͷ� ǥ���� �⺻�� int��  365 (4����Ʈ int)
		// 			=> ����(radix) ǥ���� ������ 0b0011 0x0F 088 100
 		// �Ǽ��迭: double 8 > float 4
		//      => ���е� ǥ��(�Ҽ���) 
		//		=> �ڹ��� �Ǽ� ǥ���� �⺻ double�� 3.14
		//		=> 0.0, 0.0D, 0.0F
		// ���� : boolean ���� ������ ���� �� ���� ���¸� ����.
		//		=> true, false ���� ����.
		//		=> ���ǽĿ� ����, �б⹮�� ����, �ݺ� ���� ����, ��۽���ġ, ����
		//		=> �⺻�� false
		// ������: char(character) �� �ϳ��� ���ڸ� ǥ��.
		//		=> �����δ� ���� �ɺ��� ���� �ڵ尪�� ��ġ�� ǥ���� ��. 
		// 		=> 2byte �����ڵ�� ǥ����.  0 ~ 65535, 0x0000 ~ 0xFFFF
		// 		=> UTF-16 �ڵ�ü��.
		//		=> �����ڵ� �ڵ弼Ʈ�� ������ȣ�� �����ڵ尪�ε�,
		//		=> 'A' ���� ����ǥ ���ͷ��� �����ڵ尪 ǥ��.
		//		=> �⺻�� 0, '\0'
		// ���۷����� �迭... 
		// ���ڿ��� String
		// 		�⺻���� �ƴ����� �ſ� ���� ����
		//		:abc" ���ͷ� ǥ����  �ϳ� �̻��� ���ڵ��� �������� ǥ��.
		// Ŭ����(��) => ��� Ŭ������ �� ��ü�� �ϳ��� ���� ������ Ÿ����.
		// �������̽�(interface��), ������(enum)
		//String str;
		//BasicDataMain basic;
		// �Լ���
		//	=> �⺻�� null (��) -- �ƹ��͵� ����Ű�� ���� ����
		
		// �밡���� ǥ���...
		byte bOne = 127;
		short sTwo = -32345;
		int iThree = 33;  // i => index, ������ȣ, ī����...
		int nFour = 44;
		long lFive = 555L;
		
		double dPi = 3.141592;
		final double dPi2 = Math.PI; // ���
		float fTemperature = 36.5f;
		
		boolean bFlag  = false;
		boolean bResult = 365 > 30; // ���ǽ��� ��������� ����, true
		
		
		char cSix = '��';
		char cSeven = 'A';
		char cEight = 97; // 'a'
		
		String strName = null;
	}

}
