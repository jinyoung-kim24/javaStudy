package Hello;

public class GreetMain2 {

	public static void main(String[] args) {
		//String GREET_MSG1 = ""; // ���ڿ� ""
		String GREET_MSG1 = "�ȳ�!";
		// ���� ���� ���ÿ� ������ Ȱ�� = �ʱ�ȭ
		String GREET_MSG2; // ���� ���� (������� �غ��϶�� �˷���)
		GREET_MSG2 = "�ȳ��ϼ���??";  // ���߿� ���� �ʱ�ȭ (�и�)
 		//
		String person1 = "ȫ�浿";
		String person2 = "�ȳ�"; 
		
		person1 = person1 + "~~!!!"; // "ȫ�浿~~!!!"
		// ������ ���Ӱ� ��Ȱ�� (����)
		// ���⼭ = Ȱ���ȣ �������� person1 ������ 
		// ���� ���� ���� "ȫ�浿" �����͸� ���� ������
		person2 = "princess~~" + person2;
		person2 = person2 + "����";
		
		
		System.out.println(GREET_MSG1 + " " + person1);
		System.out.println(GREET_MSG2 + " " + person2);
		System.out.println(GREET_MSG1 +" " + "ȫ�浿~~");
	}


}
