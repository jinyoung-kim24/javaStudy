package newbook.human;
/*
������ ���� ���α׷� storyboard ��....
�����ι� ��Ű�� actor�� �߰�
���������� => �缭 Librarian (��Ű��)
 ������ /�ʵ�
 ������ν��� �Ӽ���: �̸�, ����, ����, �ּ�, �ֹι�ȣ
 �����ڷν��� �Ӽ���: ������ȣ, �Ի糯¥, ����, ����
 
 �޼ҵ�/�Լ�
 ��ɵ�: å�� �԰� ��Ų��(������ �缭 �ڸ�Ʈ �߰��ϱ� ����).
 		å��������, å �˻� ����, å �뿩����....
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Librarian {
	// ������ /����ʵ�
	public static final String NO_NAME = "�̸�����";
	public static final int DEF_AGE = 18;
	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_MALE = 2;
	public static final String NO_ADDR = "�ּҹ���";
	public static final String PREFIX = "LIB_HUMAN"; // ������� ���� ��ȣ LIB_HUMAN_0078
	public static final String[] LIB_POS = {"�߽�", "����", "�븮", "����", "����", "����", "����"}; // ��å�� �迭 ���
	public static final int LIB_POS_�߽� = 0;
	public static final int LIB_POS_���� = 1;
	public static final int LIB_POS_�븮 = 2;
	public static final int LIB_POS_���� = 3;
	public static final int LIB_POS_���� = 4;
	public static final int LIB_POS_���� = 5;
	public static final int LIB_POS_���� = 6;
	public static final String DEF_JOB = "å �԰� ����"; // �⺻����
	
	
//	������ /�ʵ�
//	 ������ν��� �Ӽ���: �̸�, ����, ����, �ּ�, �ֹι�ȣ => ��ĺ� ��ġ �ʼ�
	public String name; // �̸�
	public int age; // ����
	public int gender; // ���� 1 ���� female, 2 ���� male
	public String address; // �ּ�
	
//	 �����ڷν��� �Ӽ���: ������ȣ, �Ի糯¥, ����, ����
	public int libNum; // ������ȣ
	public Date joinDay; // �Ի� ��¥
	public String pos; // ����
	public String major; // ����
	
	// ������ �Լ�
	// �⺻ �����ڴ� ������ ����
	public Librarian() { // �� �����ʵ带 ������ ���������� �⺻������ �ʱ�ȭ
		this.name = NO_NAME;
		this.age = DEF_AGE;
		this.gender = GENDER_FEMALE;
		this.address = NO_ADDR;
		this.libNum = 0;
		this.joinDay = new Date(); // ��¥ ��ü ����(JVM�� ���� OS�� ������¥ �ð��� ������ - Ÿ����, ������)
		this.pos = LIB_POS[LIB_POS_�߽�];
		this.major = DEF_JOB;
	}
	
	// �߰� ������
	// �̸�, ����, ����	
	public Librarian(String name, int age, int gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	// Ǯ������ ��� �ʵ� �������� ��ü�ʱ�ȭ
	public Librarian(String name, int age, int gender, String address, int libNum, Date joinDay, String pos,
			String major) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.libNum = libNum;
		this.joinDay = joinDay;
		this.pos = pos;
		this.major = major;
	}	


//	 �޼ҵ�/�Լ�
//	 ��ɵ�: å�� �԰� ��Ų��(������ �缭 �ڸ�Ʈ �߰��ϱ� ����).
//	 		å��������, å �˻� ����, å �뿩����....
	// �缭 �ڽ��� ���� ��� ���
	public void printLibrarian() {
		System.out.println("** �缭:: " + PREFIX + this.libNum);
		System.out.println("\t * �̸�: " + this.name);
		System.out.println("\t * ����: " + this.age + "��");
		System.out.println("\t * ����: " + this.gender);
		System.out.println("\t * �ּ�: " + this.address);
		System.out.println("\t * �Ի���: " + this.joinDay);
		System.out.println("\t * ����: " + this.pos);
		System.out.println("\t * �������: " + this.major);
		System.out.println("---------------------------------");
	}
	
	public void printLibrarian(boolean detail) {
		System.out.println("** �缭:: " + PREFIX + this.libNum);
		System.out.println("\t * �̸�: " + this.name);
		System.out.println("\t * ����: " + this.age + "��");
		System.out.println("\t * ����: [" + 
		(this.gender == GENDER_FEMALE? "����" : "����") + "]");
		// "����" : "����" 1 : 2
		System.out.println("\t * �ּ�: " + this.address);
		// ��¥�ð� ��ü�� �����������(custom) �������� ����ϱ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
//		System.out.println("\t * �Ի���: " + this.joinDay);
		String wantDate = this.joinDay == null ? "���ڸ�" : sdf.format(this.joinDay);
		System.out.println("\t * �Ի���: " + wantDate);
		System.out.println("\t * ����: " + this.pos);
		System.out.println("\t * �������: " + this.major);
		System.out.println("---------------------------------");
	}
	
//	public void printLibrarian(boolean detail) {
//		System.out.println("** �缭:: " + PREFIX + this.libNum);
//		System.out.println("\t * �̸�: " + this.name);
//		System.out.println("\t * ����: " + this.age + "��");
//		System.out.println("\t * ����: [" + 
//		(this.gender == GENDER_FEMALE? "����" : "����") + "]");
//		// "����" : "����" 1 : 2
//		System.out.println("\t * �ּ�: " + this.address);
//		System.out.println("\t * �Ի���: " + this.joinDay);
//		System.out.println("\t * ����: " + this.pos);
//		System.out.println("\t * �������: " + this.major);
//		System.out.println("---------------------------------");
//	}
}
