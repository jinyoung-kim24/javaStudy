package HomeWork;

public class StudentHomeMain3 {

	public static void main(String[] args) {
		System.out.println("=== �л� ���� ��� ===");
		jinyoung(1, "ȫ�浿", 18, "ü���а�", true);
		jinyoung(2, "������", 21, "�����а�", true);
		jinyoung(3, "ȫ����", 35, "��ȣ�а�", false);
		
		

	}
	public static void jinyoung(int tnt, String name, int age, String major, boolean line ) {
		System.out.println("* �л���ȣ" + tnt);
		System.out.println("\t" + "�̸�:" + name);
		System.out.println("\t" + "����:" + age + "��");
		System.out.println("\t" + "����:" + major);
		
		if(line== true)
			System.out.println("-----------------------------");
		else
			System.out.println("=============================");
	
}
}
