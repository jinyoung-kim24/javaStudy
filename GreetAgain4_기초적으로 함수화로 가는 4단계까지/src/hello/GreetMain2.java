package hello;

public class GreetMain2 {

//	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//String GREET_MSG1 = ""; // ���ڿ� "" 
		String GREET_MSG1 = "�ȳ�!"; 
			// ���� ���� ���ÿ� ������ �Ҵ� => �ʱ�ȭ
		String GREET_MSG2; // ���� ���� (������� �غ��϶�� �˷���)
		GREET_MSG2 = "�ȳ��ϼ���??"; // ���߿� ���� �ʱ�ȭ (�и�)
		//
		String person1 = "ȫ�浿";
		String person2 = "�ȳ�";
		
		person1 = person1 + "~~!!!"; // "ȫ�浿~~!!!"
			// ������ ���Ӱ� ���Ҵ� (����)
			// ���⼭ = �Ҵ��ȣ �������� person1������ 
			// ���� ���� ���� "ȫ�浿" �����͸� ���� ������
		person2 = "princess~~ " + person2;  
		person2 = person2 + "����";
		
		System.out.println(GREET_MSG1 + " " + person1);
		System.out.println(GREET_MSG2 + " " + person2);
//		System.out.println(GREET_MSG1 + " " + "ȫ�浿~~");
	}

}
