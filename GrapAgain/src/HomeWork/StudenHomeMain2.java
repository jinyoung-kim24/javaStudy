package HomeWork;

public class StudenHomeMain2 {

	public static void main(String[] args) {
		System.out.println("=== �л� ���� ��� ===");
		student(1, "ȫ�浿", "�����а�", (int)(Math.random() * 31) + 10, true);
		student(2, "ȫ�浼", "��ȣ�а�", (int)(Math.random() * 31) + 10, true);
		student(3, "ȫ�海", "ü���а�", (int)(Math.random() * 31) + 10, false);

	}
	double jin = Math.random();
	int age = (int)(jin * 31) + 10;
	
	
public static void student(int tnt, String name, String major, int age, boolean line) {
	
	System.out.println("* �л���ȣ" + tnt);
	System.out.println("\t" +  "�̸�:" + name);
	System.out.print("\t" + "����:" + age + "��");
	if(age >= 18)
		System.out.println("<��û��>");
	else
		System.out.println("<û��>");
	System.out.println("\t" + "����:" + major);


if(true == line)
	System.out.println("-------------------------");
	else
	System.out.println("=========================");

}
	

}
