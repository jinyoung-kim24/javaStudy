package hello; // ��Ű�� ���� (���� ���� ������ġ)
	// �� �ҽ������� Ŭ�������� �� ��Ű���� �Ҽӵ�.
	// hello.GreetMain

	// ���� �ּ� (Comment)
	/*
	  ���� �� �ּ�
	 */

	// Ű����, ����� (keyword, reserved)

// Ŭ���� ���� (Class Definition) => ���赵
public class GreetMain { // Ŭ���� ���� ����

	// �Լ� ���� (Function Definition) => ���
	// main() �����Լ� =>  ���α׷��� ���۰� ���� ����� �帧���� �Լ�
	// entry point(���� ������)					
	public static void main(String[] args) {
		System.out.println("main() ����..."); 
			// ���� Statement => ��� ������ �ּ� ����, �ݵ�� ; �����ݷ����� ����.
		System.
			out.	println(
			"main() ����..."		)		
			;
		
		System.out.println(); // ����Ű(����Ű) - ����
//		System.out.println("�ȳ��ϼ���? ȫ�浿!");// 11�� ���� �ؽ�Ʈ ���
//		System.out.println("�ȳ��ϼ���? " + "�Ӳ���!");
//		System.out.println("�ȳ��ϼ���? " + "����!");
		
		String GREET_MESSAGE = "�ȳ��ϼ���? "; // ������ ������ �Ҵ�
			// �Ҵ�(���� assign)������
		
		System.out.println( GREET_MESSAGE + "ȫ�浿!"); // ���� ����
		System.out.println( GREET_MESSAGE + "�Ӳ���!");
		System.out.println( GREET_MESSAGE + "����!");
		
		GREET_MESSAGE = "�ȳ��Ͻʴϱ�? "; // ���ο� �����ͷ� ���Ҵ�
	
		System.out.println( GREET_MESSAGE + "ȫ�浿!"); 
					// ���� ���� (���Ҵ�� ���ο� ������)
		System.out.println( GREET_MESSAGE + "�Ӳ���!");
		System.out.println( GREET_MESSAGE + "����!");
	}
	
//	public static void Main(String[] args)
//	{ // �Լ� ���� ����; main() ���α׷��� ����... 
//		System.out.println("main() ����...");
//
//	} // �Լ� ���� ��; main() ���α׷��� ��. (����)

} // Ŭ���� ���� ��



