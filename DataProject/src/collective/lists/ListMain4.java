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
		
		// �׷�����(1583��)���� ���� �⵵�� ����Ʈ�� �߰�
		for (int i = 0; i < 20; i++) {
			Integer year = (int)(Math.random() * 1000) + 1583;
			yearList.add(1,year); // ������ �� ��° ��ġ�� �߰�
				// 0��° (ù��°��Ҵ� ����!)
				// 2030�� ���� �ι�° ��ġ ������ ������
		}
		for (Integer year : yearList) {
			System.out.println(year);
		}
		
		
	}

}
