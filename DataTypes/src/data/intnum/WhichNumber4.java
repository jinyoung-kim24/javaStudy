package data.intnum;

public class WhichNumber4 {

	public static void oddOrEvenNumber(int num) {
		// ��ó���� -- ���� ���� (�ڿ���)��... ó������ 
				//if( num >= 0 ) { ���̸����; } else { �����̸����; }
				if( num > 0 ) {
					// ����ó����
					if( num % 2 == 1 ) // Ȧ�� �������� �� true
						System.out.println(num + "��/�� Ȧ��Odd �Դϴ�.");
					else // ¦��  �������� ���� false
						System.out.println(num + "��/�� ¦��Even �Դϴ�.");
				} else {
					System.out.println(
						"¦Ȧ�� �Ǻ� ������ ���� ������ �˴ϴ�.^^ - ����: " + num);
		}		
	}
	
	public static void main(String[] args) {
		final int ODD_NUMBER = 1; // Ȧ��
		final int EVEN_NUMBER = 2; // ¦��
		final int ERROR_ZERO = 0; // ����0
		final int ERROR_MINUS = -1; // ���� ����
		
		int a = -7;
		int rType = oddOrEvenReturnInt(a);
		//if( rType == 1) System.out.println("Ȧ��");
		//if( rType == 2) System.out.println("¦��");
		if( rType == ODD_NUMBER) System.out.println("Ȧ��");
		if( rType == EVEN_NUMBER) System.out.println("¦��");
		if( rType == ERROR_ZERO) System.out.println("����0");
		if( rType == ERROR_MINUS) System.out.println("���� ����");
 	}

	// definition
	private static String oddOrEvenReturnMsg(int num) {
		final String ODD = "Ȧ��";
		final String EVEN = "¦��";
		String result = ""; // emtpy string
		//return null; // �ƹ��͵� ����Ű�� ���� ���� ǥ���� null ��
		//return ""; // ���ڿ�
		if( num % 2 == 0 ) result = EVEN;
		else result = ODD;
		return result;
	}

	// ¦���߶�� ����� �Ϲ� �Ǵ� �Լ�, true/false�� ����
	
		// ���� ���� �Է� �޾Ƽ� ���������� ¦�� , Ȧ�� �����ϰ� ����
		// ���� ������� �� ���ܸ� ����
		// �����ϴ� ������:
	    //      Ȧ���� 1�� �����մϴ� ¦���� 2�� ����
	    //      �����̰� ������ �ԷµȰŶ�� -1�� ����
	public static int oddOrEvenReturnInt(int num) {
		if(num < 0) {
			System.out.println("���� �߻�: ����");
			return -1; //���� ����
		}
		if(num == 0) {
			System.out.println("���� �߻�: 0");
			return 0; //���� 0
		}
		if(num % 2 == 1) return 1; // Ȧ��
		else // ¦��
			return 2;
		
	}
	}


