package Hello;  // ��Ű�� ����(���� ���� ������ġ)
     // �̼ҽ� ������ Ŭ�������� �� ��Ű���� ������.
     // hello.GreetMain
     
     // �ּ� ((comment)
     //*
         // Ű����, ������(keyward, reeserved)
         

// Ŭ���� ���� (class Definition)


public class GreetMain { //Ŭ���� ���� ����
     // �Լ� ���� (Function Definition) = ���
     // main() �����Լ�= ���α׷��� ���۰� ���� ����� �帧������ �Լ�
	 // entry point(���� ������)
	public static void main(String[] args) { // �Լ� ���� ���� main() ���α׷��� ����...
		// TODO Auto-generated method stub
   System.out.println("main() ����..."); // ���� Statement = ��� ������ �ּ� ����, �ݵ��; ����Ŭ������ ����.
   
   
   System.out.println(); // ����Ű(����Ű)
   System.out.println("�ȳ��ϼ���? ȫ�浿!");// 11���� ���� �ؽ�Ʈ ���
   System.out.println("�ȳ��ϼ���? " + "�Ӳ���!");
   System.out.println("�ȳ��ϼ���? " + "����!");
   
   String GREET_MESSAGE = "�ȳ��ϼ���? "; // ������ ������ Ȱ��
      // �Ҵ�(���� assign)������
   System.out.println(GREET_MESSAGE + "ȫ�浿!");// ���� ����
   System.out.println(GREET_MESSAGE + "�Ӳ���!");
   System.out.println(GREET_MESSAGE + "����!");
    
   GREET_MESSAGE = "�ȳ��Ͻʴϱ�?"; // ���ο� �����ͷ� ��Ȱ��
   
   System.out.println(GREET_MESSAGE + "ȫ�浿!");// ���� ���� (��Ȱ��� ���ο� ������)
   System.out.println(GREET_MESSAGE + "�Ӳ���!");
   System.out.println(GREET_MESSAGE + "����!");
   
	}  // �Լ����� ��; main() ���α׷��� ��, (����)

} // Ŭ���� ���� ��
