package collective.lists;

import java.util.ArrayList;

public class ListMain4 {

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
		for (Integer year : yearList) {
			System.out.println(year);
		}
		
		
	}

}
