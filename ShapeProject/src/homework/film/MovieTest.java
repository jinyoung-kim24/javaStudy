package homework.film;
import java.util.Scanner;
import homework.film.MyMoive;


public class MovieTest {

	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println(">> ��ȭ ������ �Է����ּ���!");
//		System.out.print("* ��ȭ �̸�: ");
//		String name = sc.next();
//		System.out.print("* ��ȭ �帣:");
//		String genr = sc.next();
//		System.out.print("* ��ȭ �����⵵:");
//		int year = sc.nextInt();
//		System.out.print("* ��ȭ ������:");
//		int person = sc.nextInt();
//		System.out.print("* ��ȭ ����:");
//		float rate = sc.nextFloat();
//		System.out.print("* ��ȭ ��ü�� �����մϴ�.");
//		MyMoive mv = new MyMoive(name, genr, year, person, rate, MyMoive.DEF_COMMENT);
		
//		mv.printMyMoive();
		
		MyTheater mt = new MyTheater("�̷�CGV", "(������ 11����...)", 7);
		mt.mtmoive[0] = new MyMoive("ȫ�浿", "�׼�", 20, 3.0f);
		mt.mtmoive[1] = new MyMoive("'�͹̳�����'", "��Ÿ��/�׼�", 34, 4.2f);
		mt.mtmoive[2] = new MyMoive("'��ٵ�'", " �׼�", 14, 5.1f);
		mt.mtmoive[3] = new MyMoive("'�پƿ�'", "����/ȣ��", 42, 6.8f);
		mt.mtmoive[4] = new MyMoive("'��������'", "�ڹ̵�/�׼�", 27, 8.86f);
		mt.mtmoive[5] = new MyMoive("'����'", "��Ÿ��/����", 35, 9.55f);
		mt.mtmoive[6] = new MyMoive("'��ΰ�ü��'", "�θǽ�/���", MyTheater.DEF_AGE, 1.33f);
		mt.addMoiveToTheater();
		
		
		
		
	}

}
