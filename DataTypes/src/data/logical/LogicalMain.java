package data.logical;

public class LogicalMain {

	// ������ �ʴ� ������ ���뵥���͸� ���ȭ (Ŭ����/����ƽ ��� ���Ǻ�)
	public static final String MARK = "���ڸ� "; //"����� "; 


	public static void main(String[] args) {
		// �ڹ� ������Ƽ�� primitives (�⺻��)
		// ��ġ�� �迭 = ����, �Ǽ�
		// ���� �迭 = �ο��� boolean (���� �����?)
		// ���� �� ���� ���� �� yes/no, b/w, true/false
		// ��/����... 
		// ����, �� ���ǽ� (conditional expression)
		//   ���ǽ��� ����� ������ ���� �� true, false��..
		boolean b1; // ���� ���� ���� ����
		b1 = true;
		boolean b2 = false;
		//int b3 = true; 
		
		boolean b3 = 33 > 20; // true; 
		boolean b4 = 33 < 20; // false;
		boolean b5 = 33 > 33; // false;
		boolean b6 = 33 < 33; // false;
		boolean b7 = 33 >= 33; // true; ������� ����? �ʰ��̻�̸�����
		boolean b8 = 2 == 2; // true;
		boolean b9 = (1 != 1); // false
		//
		int val = 17; //100; //20;
		boolean flag = val < 100 && 21 > 20; // and ����
				// flag = true && true;
				// flag = true;
				// true && true = true (�������Ǹ�� ���� �� ��)
				// true && false = false
				// false && true = false
				// false && false = false
				// '&' and ����, ampersand ����..
		System.out.println("flag = " + flag);
		
		//flagAction3(flag);
		//flagAction(flag);
		//flagAction(false);
		String result = flagAction4(flag); //false);
		System.out.println("���: => " + result);
		System.out.println("���: => " + flagAction4(false));
		
		String result5 = flagAction5B(flag);
		System.out.println("���5B: => " + result5);
	}
	
	public static String flagAction5B(boolean flag) {
		System.out.print("��� �׼�:: ");
		if( flag == true ) 
			//return "����� "+"�÷���!";				
			return MARK + "�÷���!";
		else  
			//return "����� "+"������!";		
			return MARK +"������!";
	}
	
	public static String flagAction5(boolean flag) {
		System.out.print("��� �׼�:: ");
		if( flag == true ) 
			return "����� �÷���!";				
		else  
			return "����� ������!";		
	}
	
	public static String flagAction4(boolean flag) {
		String result = ""; // empty string 
		System.out.print("��� �׼�:: ");
		if( flag == true ) {
			result = "����� �÷���!";				
		} else { 
			result = "����� ������!"; 
		}
		return result; // "����� �÷���!" Ȥ�� "����� ������!"�� �ݵ�� �����.
	}
	
	public static void flagAction3(boolean flag) {
		// if... A else B ���ǽ��� A�� B ����/����� �� �� �ϳ��� ������ �б� ���� 
		if( flag == true ) {
			System.out.println("����� �÷���!");				
		}
		else { // ���� ���ǽ��� false�� ���� else ������οͼ� ����
			System.out.println("����� ������!"); 
		}
		System.out.println("== �� ==");
	}
	

	
	public static void flagAction2(boolean flag) {
		if( flag == true ) {
			System.out.println("����� �÷���!");
			return; // �Լ� ��� ���� (�ڿ� ���� ���� ����)
		}
		if( flag == false ) {
			System.out.println("����� ������!"); return;
		}
//		return;
		System.out.println("== �� =="); // �ռ��� ���ϵǾ �̹��� ���� �ȵ�..
	}
	
	
	public static void flagAction(boolean flag) {
		// if(���ǽ�) ����;   
		// if�� ȥ�� ���Ǹ� ���ǽ��� true�϶� ������ �����ϰ�,
		// false�̸� �׳� �ǳʶ�.
		if( flag == true )
			System.out.println("����� �÷���!");
		
		if( flag == false )
			System.out.println("����� ������!");
		
		System.out.println("== �� ==");
	}

}



