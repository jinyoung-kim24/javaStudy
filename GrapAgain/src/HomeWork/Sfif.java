package HomeWork;

public class Sfif {

	public static void main(String[] args) {
		System.out.println("=== �л� ���� ��� ===");
		jinyoung(1, "ȫ�浿", (int) (Math.random() * 40), "ü���а�", true);
		jinyoung(2, "������", (int) (Math.random() * 40), "�����а�", true);
		jinyoung(3, "ȫ����", (int) (Math.random() * 40), "��ȣ�а�", false);
		
		
		
		

	}
	public static void jinyoung(int tnt, String name, int age, String major, boolean line ) {
		System.out.println("* �л���ȣ" + tnt);
		System.out.println("\t" + "�̸�:" + name);
		System.out.println("\t" + "����:" + (int) (Math.random() * 40) + "��");
		System.out.println("\t" + "����:" + major);
		
		if(line== true)
			System.out.println("-----------------------------");
		else
			System.out.println("=============================");
	
		if((int) (Math.random() * 40)<= 18)
			System.out.println("<û��>");
		else
			System.out.println("<��û��>");
		 
		
		
	}
	
}

