package greet; // ��Ű�� = ���� = �̸�����(namespace)
// <������Ʈ����>\src\greet\HelloMain.java �ҽ�����
// greet.HelloMain Ŭ���� Ÿ�Ը�

public class HelloMain {
	
	// ���� gender ����, ���� ������ ǥ��..
	// boolean �ο���( true, false�� ����.. ���� 2���� ���¸� ������)
	// ��/��, ��/����, yes/no, ��/��.... ��/��...
	// isFemale �Էº����� true�� ���� ���ǰ��� ����, 
	// ���� false��� ���� ���ǰ��� ������. 
	public static void sayHelloToMusician2(
			String msg, String name, boolean isFemale ) {
		System.out.println("+=====+=====+=====+=====+");
		System.out.println("      " + msg + "~~~");
		
		// if ���Ǻκб⹮.. ���ǽĿ� ����� ���� �� ���� Ȥ�� �� ������ �б��Ͽ� ������.
		// isFemale == true ���ǽ�(������ ���� �����  true, false�θ� ����.)
		if(isFemale == true) // �� ������ == 
			System.out.println("\t" + name + "����" + "~~~!");// ����
		else 
			System.out.println("\t" + name + "��" + "~~~!");// ����
		
		System.out.println("+=====+=====+=====+=====+");
		System.out.println(); // ���๮�ڰ� ���Ե� "\n"
	}
	
	
	public static void main(String[] args) {
		System.out.println("~~~ ���ǰ� �λ��ϱ� ���α׷� ~~~");
		final String MSG = "���� �����̳׿�"; // ��� ����� ���ÿ� ����.
		String who1 = "���亥"; 
		String who2 = "����", who3 = "�", who4 = "�Ż��Ӵ�";
//		sayHelloToMusician("���� �����׿�", "��¥��Ʈ");
//		sayHelloToMusician("���� �����̳׿�", "������");
//		sayHelloToMusician(MSG, who2);
		//
		sayHelloToMusician2(MSG, who1, false); // ��
		sayHelloToMusician2("���� �����̳׿�", who4, true); // ��
		sayHelloToMusician2("�Ƹ��ٿ� �ϴ��̳׿�.", "������", true);
		sayHelloToMusician2("���� �����׿�", who3, true);  // false);
	} // main() ��..
	
	// �Լ� ���Ǵ� ��ġ�� �������. 
	public static void sayHelloToMusician(
			String msg, String name) {
		System.out.println("+=====+=====+=====+=====+");
		System.out.println("      " + msg + "~~~");
		System.out.println("\t" + name + "��" + "~~~!");
		System.out.println("+=====+=====+=====+=====+");
		System.out.println(); // ���๮�ڰ� ���Ե� "\n"
	}
	
} // Ŭ���� ��.


/*
  
  ~~~ ���ǰ� �λ��ϱ� ���α׷� ~~~
+=====+=====+=====+=====+
      ���� �����̳׿�~~~
	���亥��~~~!
+=====+=====+=====+=====+

+=====+=====+=====+=====+
      ���� �����̳׿�~~~
	�Ż��Ӵ����~~~!
+=====+=====+=====+=====+

+=====+=====+=====+=====+
      �Ƹ��ٿ� �ϴ��̳׿�.~~~
	�����̺���~~~!
+=====+=====+=====+=====+

+=====+=====+=====+=====+
      ���� �����׿�~~~
	�����~~~!
+=====+=====+=====+=====+


 
 
 */
