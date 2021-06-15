package collective.lists.pop;

import java.util.ArrayList;
import java.util.HashSet;

//�⵵ (MyPopYear) ��Ű�� Ŭ����
//�����Ǵ��� �������� ����?
//�⵵��(��ġ��), �����Ǵ�����(����), era �����/�����/����
class MyPopYear {
	private boolean AD; // BC -> AD (����� true, ����� false)
	private int year;
	private boolean bLeap; // true�� ����
	//
	public long popul; // �� �ؿ� �����
	
	public MyPopYear() {}
	
	public MyPopYear(int year) {
		super();
		this.year = year;
		AD = this.year > 0 ? true: false;  
					//"���� AD" : "����� BC";		
		this.bLeap = isLeapYear(this.year); // ���� true
		this.popul = (long)(Math.random()*1000000000l)+1L;// 10��
	}
	
	public MyPopYear(int year, long popul) {
		super();
		this.year = year;
		AD = this.year > 0 ? true: false;  
					//"���� AD" : "����� BC";		
		this.bLeap = isLeapYear(this.year); // ���� true
		this.popul = popul;
	}
	
	// true ����   false ���
	private boolean isLeapYear(int year) {
		boolean result = false; // ����� ��ټ��̹Ƿ� �⺻.
		if( year % 4 == 0 ) result = true; // ���� �ĺ�?
		if( year % 4 == 0 && year % 100 == 0 ) 
			result = false; // �����ϵ� �Ͽ����� ��� �ĺ�..
		if( year % 4 == 0 && year % 100 == 0  
				&& year % 400 == 0 ) result = true;
			//// �����ϵ� �Ͽ����� ��� �̾��ٰ� ���� �������� Ȯ��.		
		return result;
	}
	
	public MyPopYear(boolean AD, int year, boolean bLeap) {
		super();
		this.AD = AD;
		this.year = year;
		this.bLeap = bLeap;
		// popul = 0L;
	}
	
	public MyPopYear(boolean aD, int year, boolean bLeap, long popul) {
		super();
		AD = aD;
		this.year = year;
		this.bLeap = bLeap;
		this.popul = popul;
	}

	// Read/Write
	public boolean isAD() {
		return AD;
	}
	public void setAD(boolean aD) {
		AD = aD;
	}
	
	// Readonly
	public int getYear() {
		return year;
	}
	// Readonly
	public boolean isbLeap() { 
		// boolean Ÿ���� �ʵ��� getter�� is-- �����ϴ� �̸� 
		return bLeap;
	}
	
	@Override
	public String toString() {
		return (AD ? "���� AD " : "����� BC ") + 
				 year + "�⵵ => "
			 + (bLeap == true ? "<<<����>>>":"  ���   ")
			 + " / �����: " + this.popul + "��";
	}
	
	
	

}

// �⵵�� �α��� ���� Ŭ����
class PopAdmin {
	public String name;
	public double avg;
//	public MyPopYear[] ppy; // �迭:�Һ�
	public ArrayList<MyPopYear> pyList; // ����Ʈ: ����
//	public HashSet<MyPopYear> pySet; // ����: ����, ����x
	
	public PopAdmin() {
		// TODO Auto-generated constructor stub
	}
	
	public PopAdmin(String name) {
		super();
		this.name = name;
		this.avg = 0.0;
		this.pyList = new ArrayList<>();
	}
	
	public PopAdmin(String name, double avg, ArrayList<MyPopYear> pyList) {
		super();
		this.name = name;
		this.avg = avg;
		this.pyList = pyList;
	}

	@Override
	public String toString() {
		return "PopAdmin [name=" + name + ", avg=" + avg + ", pyList=" + pyList + "]";
	}
	
	// �ּ� �⵵, �ִ� �⵵ ??
	// �ִ� �����, �ִ� ������� �⵵
	// �ּ� �����, �ּ� ������� �⵵
	// ��� ����� (�л�, ǥ������)
	// ���� vs ��� ����, ���� vs ��� �������
	// CRUD �ű� MyPopYear �߰�, ����, ����/����
	
	// ���⸸�� ���
	public double getAvgPopForLeapYear() { // �������
		long sum = 0L;
		double tmpAvg = 0.0;
		int lyCnt = 0;
		for (MyPopYear mpy : pyList) {
			if(mpy.isbLeap()) {
			sum += mpy.popul;
			lyCnt++;
			}
		}
		tmpAvg = (double)sum / lyCnt;
		this.avg = tmpAvg;
		return avg;
	}
	
	// ���⵵
	public double getAvgPop() { // �������
		long sum = 0L;
		double tmpAvg = 0.0;
		for (MyPopYear mpy : pyList) {
			sum += mpy.popul;
		}
		tmpAvg = (double)sum / pyList.size();
		this.avg = tmpAvg;
		return avg;
	}
	
	
	public void printMaxPopAndYear() {
		long maxPop = pyList.get(0).popul;
		int maxPopYear = pyList.get(0).getYear();
		boolean maxPopYearLeap = pyList.get(0).isbLeap();
		for (int i = 1; i < pyList.size(); i++) {
			if(pyList.get(i).popul > maxPop ) {
				maxPop = pyList.get(i).popul;
				maxPopYear = pyList.get(i).getYear();
			}
		}
		System.out.println("�ִ� �����, �ִ� ������� �⵵");
		System.out.printf("\t �ִ� �����: %10d ��\n", maxPop);
		System.out.printf("\t �ִ� ������� �⵵: %10d ��\n", maxPopYear);
		System.out.printf("\t �ִ� ������� �⵵ �����Ǵ�: %s \n", (maxPopYearLeap ? "����" : "���"));
	}
	
	public void printMaxPopAndYear2() {
		MyPopYear max = pyList.get(0);
		for (int i = 1; i < pyList.size(); i++) {
			if(pyList.get(i).popul > max.popul) {
				max = pyList.get(i);
			} // ���Ǵ��� �ʵ� �ϳ��� �ϵ�, ������ ��ü�� ��°��
		}
		System.out.println("�ִ� �����, �ִ� ������� �⵵");
		System.out.printf("\t �ִ� �����: %10d ��\n", max.popul);
		System.out.printf("\t �ִ� ������� �⵵: %10d ��\n", max.getYear());
		System.out.printf("\t �ִ� ������� �⵵ �����Ǵ�: %s \n", (max.isbLeap() ? "����" : "���"));
	}
}


// �α� (���) ��踦 list�� ǥ�� -- �׷��� ?
public class Population {

	public static void main(String[] args) {
		MyPopYear ppy[] = new MyPopYear[10];
		for (int i = 0; i < ppy.length; i++) {
			ppy[i] = 
				new MyPopYear((int)(Math.random()*101)+1970);
				// ���� �⵵�� �������� ���� 50 ~ �̷� 50�Ⱓ..
		}
		
		for (int i = 0; i < ppy.length; i++) {
			MyPopYear mpy = ppy[i];
			System.out.println(mpy);
		}
		
		System.out.println("------------------------------");
		// �迭���� ����Ʈ�� �ű��..
		ArrayList<MyPopYear> pyList = new ArrayList<>();
		for (MyPopYear mpy : ppy) {
			pyList.add(mpy);
		}
		
		for (int i = 0; i < pyList.size(); i++) {
			MyPopYear mpy = pyList.get(i);
			System.out.println(mpy);
		}
		
		PopAdmin pa = new PopAdmin("�������", 0.0, pyList);
		pa.printMaxPopAndYear2();
		System.out.printf(">> %d ��ġ ��� �����: %.2f��\n",pa.pyList.size(), pa.getAvgPop());
		System.out.printf(">> %d �⵿�ȿ� ������ ��� �����: %.2f��\n",pa.pyList.size(), pa.getAvgPopForLeapYear());
	}

}
