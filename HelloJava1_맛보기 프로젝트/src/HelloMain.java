/**
 * 
 */

/**
 * benjamin
 *
 */
public class HelloMain {

	/*
	 * ������������

	 * ������
	 * ����
	 * ������
	 ���� ���� �ּ� 
	 */
	
	// main �Լ�(function) -- ���α׷��� ���� ��ġ
	public static void main(String[] args) {
		// �ּ�... comment -- ��ɾ�κ��� �ƴϰ�
		// 		    �����ο� ����...

		// println() ��� ��� �Լ�
		//System.out.println("Hello Java!!");
//		System.out.print("Hello Java!!");
		System.out.print("Hello Java!! "); 
			// ���鹮�ڵ� �����ʹ�..
		System.out.println("�ȳ� Java!!");
		
		// sysout �ڵ��ϼ� ��ũ�� ����Ű ctrl + spaceŰ
		// ctrl + F11 ==> RUN
		System.out.println("Hello! " + "�ڹ�..?" + 
		
						" ���α׷��� ��� "
						+ 2021 + "year!!"				
				);
		// + ��ȣ�� �ΰ��� ���ڿ��� �ٿ��ش�. 

		// text �ؽ�Ʈ =>  ���ڿ�  string
		// ���ͷ� ��ȣ "����Ͽ� ���ڿ��� ǥ��.
		// "�� �����ؼ� "�� ������ ���ڵ��� �Ϸ��� ����..
		// "abc", "AbCdef", "12345", "���ӽ� ����"
//		System.out.println("���ӽ� ����");
		
		String  who  = "���ӽ� ����"; // ���� ����� �ʱ�ȭ
	//  Ÿ�� 	   ����(��) �Ҵ�(����)������    ���ڿ�������   ����ǳ�(�����ǳ�)
	//	String age = "60";
		int age = 60;  // ���� Ÿ��  (��ġ�� , ��...)
		System.out.println("famous GURU! " + who ); // ���� ����
		who = "��Ƽ�� �⽺";
		System.out.println("famous GURU II !!" + who);
		age = 22;
		who = "�������";
		System.out.println("famous guru: �̸� " + who + 
				"��!!, ���� " + age +"��" );
	}

}
