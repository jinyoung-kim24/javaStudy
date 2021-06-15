package collective.lists;

import java.util.ArrayList;

// 년도 (year) 스키마 클래스
// 윤년판단을 목적으로 정의?
// 년도값(수치형), 윤년판단유무(논리형), era기원전/기원후/서기

class MyYear {
	private boolean AD; // BC -> AD (기원후 true, 기원전 false)
	private int year;
	private boolean bLeap; // true면 윤년 
	
	public MyYear() {}
	
	public MyYear(int year) {
		super();
		this.year = year;
		AD = this.year > 0 ? true : false; // "서기 AD" : "기원전 BC";
		this.bLeap = isLeapYear(this.year); // 윤년 true
	}
	
	// true 윤년, false 평년
	private boolean isLeapYear(int year) {
		boolean result = false; // 평년이 대다수이므로 기본
		if(year % 4 == 0) result = true; // 윤년 후보
		if(year % 4 == 0 && year % 100 == 0) result = false; // 평년 후보
		if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0) result = true;
		// 최종 윤년으로 확정
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
		// boolean 타입의 필드의 getter는 is 시작하는이름
		return bLeap;
	}

	@Override
	public String toString() {
		return (AD ? "서기 AD" : "기원전 BC") +
				year + "년도 => " +
				(bLeap == true ? "<<<윤년>>>" : "   평년");
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
		
		// 그레고리력(1583년)으로 랜덤 년도를 리스트에 추가
		for (int i = 0; i < 20; i++) {
			Integer year = (int)(Math.random() * 1000) + 1583;
			yearList.add(1,year); // 무조건 두 번째 위치에 추가
				// 0번째 (첫번째요소는 고정!)
				// 2030이 원래 두번째 위치 였으나 끝으로
		}
//		for (Integer year : yearList) {
//			System.out.println(year);
//		}
		
		// MyTear요소들의 리스트
		ArrayList<MyYear> myList = new ArrayList<>();
//		MyYear my = new MyYear(1999);
//		myList.add(my);
		for (int year : yearList) {
			MyYear my = new MyYear(year);
			myList.add(my);
		}	
		// 년도 객체 리스트 출력
		final int MY_YEAR = myList.size();
		System.out.println("년도의 총개수: " + MY_YEAR);
		int lyCnt = 0;
		for (int i = 0; i < MY_YEAR; i++) {
			MyYear my = myList.get(i);
			System.out.println(my);
			if(my.isbLeap()) {
				lyCnt++;
			}
		}
		System.out.println(">>> 윤년의 개수는? " + lyCnt + "개");
	}
		
	
	

}
