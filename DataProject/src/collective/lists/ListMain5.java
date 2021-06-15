package collective.lists;

import java.util.ArrayList;

// �⵵ (year) ��Ű�� Ŭ����
// �����Ǵ��� �������� ����?
// �⵵��(��ġ��), �����Ǵ�����(����), era�����/�����/����

class MyYear {
	private boolean AD; // BC -> AD (����� true, ����� false)
	private int year;
	private boolean bLeap; // true�� ���� 
	
	public MyYear() {}
	
	public MyYear(int year) {
		super();
		this.year = year;
		AD = this.year > 0 ? true : false; // "���� AD" : "����� BC";
		this.bLeap = isLeapYear(this.year); // ���� true
	}
	
	// true ����, false ���
	private boolean isLeapYear(int year) {
		boolean result = false; // ����� ��ټ��̹Ƿ� �⺻
		if(year % 4 == 0) result = true; // ���� �ĺ�
		if(year % 4 == 0 && year % 100 == 0) result = false; // ��� �ĺ�
		if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0) result = true;
		// ���� �������� Ȯ��
		return result;
	}

	public MyYear(boolean AD, int year, boolean bLeap) {
		super();
		this.AD = AD;
		this.year = year;
		this.bLeap = bLeap;
	}
	// Read/Write
	public boolean isAD() {
		return AD;
	}
	
	public void setAD(boolean AD) {
		this.AD = AD;
	}
	// Readonly
	public int getYear() {
		return year;
	}
	
	public boolean isbLeap() {
		// boolean Ÿ���� �ʵ��� getter�� is �����ϴ��̸�
		return bLeap;
	}

	@Override
	public String toString() {
		return (AD ? "���� AD" : "����� BC") +
				year + "�⵵ => " +
				(bLeap == true ? "<<<����>>>" : "   ���");
	}
	
}

public class ListMain5 {

	public static void main(String[] args) {
		ArrayList<Integer> yearList = new ArrayList<>();
//		yearList.add(), get(), set(), remove();// CRUD
//		yearList.add(new Integer(365));
//		yearList.add(365);
//		yearList.add(3.14); x
		
		yearList.add(2021);
		yearList.add(2030);
		
		// �׷�����(1583��)���� ���� �⵵�� ����Ʈ�� �߰�
		for (int i = 0; i < 20; i++) {
			Integer year = (int)(Math.random() * 1000) + 1583;
			yearList.add(1,year); // ������ �� ��° ��ġ�� �߰�
				// 0��° (ù��°��Ҵ� ����!)
				// 2030�� ���� �ι�° ��ġ ������ ������
		}
//		for (Integer year : yearList) {
//			System.out.println(year);
//		}
		
		// MyTear��ҵ��� ����Ʈ
		ArrayList<MyYear> myList = new ArrayList<>();
//		MyYear my = new MyYear(1999);
//		myList.add(my);
		for (int year : yearList) {
			MyYear my = new MyYear(year);
			myList.add(my);
		}	
		// �⵵ ��ü ����Ʈ ���
		final int MY_YEAR = myList.size();
		System.out.println("�⵵�� �Ѱ���: " + MY_YEAR);
		int lyCnt = 0;
		for (int i = 0; i < MY_YEAR; i++) {
			MyYear my = myList.get(i);
			System.out.println(my);
			if(my.isbLeap()) {
				lyCnt++;
			}
		}
		System.out.println(">>> ������ ������? " + lyCnt + "��");
	}
		
	
	

}
