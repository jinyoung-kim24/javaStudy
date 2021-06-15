package collective.lists;

import java.util.ArrayList;

/*
 * ����Ʈ List (���) => �迭�� ����Ʈ�� ���� �� ����
 * java.util.List �������̽�
 * > ����� �ߺ��� ����.
 * > ��ҵ��� �߰��� ����(��ȣ; �ε���) ����
 * > ������ȣ(index) 0 ~ size()-1 ����
 *  ����Ʈ �������̽��� ���� �� ������ ����ü Ŭ���� ArrayList
 *  
 *  ArrayList ������ ������ ����ҷν��� CRUD �������� ����
 *  CRUD(Create, Read,/Retrieve, Update, Delete)
 *  	add()/insert?, 	get(), 	set(), 	remove()
 */
public class ListMain3 {

	public static void main(String[] args) {
		// ���׸� generic: Ÿ�� �Ķ���� ����
//		ArrayList nameList = new ArrayList(); // �Ϲ� ����Ʈ 
		ArrayList<String> nameList = new ArrayList<>();
		// ����Ʈ �÷����� ���Ÿ���� ��� ���ڿ��� ���ѽ�Ŵ
		nameList.add("���");
//		nameList.add(22);
//		nameList.add("" + 22);
//		nameList.add(String.valueOf(22));
		// <=> Integer.parseInt("22")
		nameList.add("����"); // add() ����Ʈ�� �ǵڿ� ���ο� ��Ҹ� �߰�
		nameList.add("����");
		nameList.add("����"); // Create

		printNameList(nameList);

		System.out.println("** �л��̸� ����Ʈ(������Reberse):" + nameList.size() + "��");
		final int CNT_NAMES = nameList.size();
		for (int i = CNT_NAMES - 1; i >= 0; i--) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");
		
		nameList.add("����"); // �ǵ�(��ġ)�� �߰�
		nameList.add(2,"����"); // 2�� ��ġ�� ���Ӱ� ������ �߰�
		
		printNameList(nameList);
		
		nameList.add(0, "����"); // ����Ʈ�� �� ��(��ġ�� �߰�)
		
		printNameList(nameList);
		
		nameList.add(0, "����"); // ����Ʈ�� �� ��(��ġ�� �߰�)
		nameList.add("����");
		nameList.add(nameList.size(),"����"); // �ǵ�(��ġ)�� �߰�
		printNameList(nameList);
		
		
		// Update
		nameList.set(8, "����  original");
		printNameList(nameList);
//		String oldEntitle = nameList.get(8); // backup
		String oldEntitle = nameList.set(8, "���� �Ҽ���");
			// set�� �������� �ش� ��ġ�� ���� ��Ұ� ���ϵ�.
		nameList.set(8, "���� �Ҽ���");
		printNameList(nameList);
		System.out.println("old => " + oldEntitle);
		
		
		// Delete
		nameList.add(oldEntitle);
		nameList.remove(2); 
		nameList.remove(9); // �����ǵ��� �ٸ��� ����!!!!
		// ���� ��ġ �������� ���� ��ҵ��� ��� 1��ġ�� ������ �����!!
		printNameList(nameList);
		
		// Fast Enumerations
		for (String name : nameList) {
			System.out.println(">> " + name);
		}
		
	}

	public static void printNameList(ArrayList<String> nameList) {
		System.out.println("** �л��̸� ����Ʈ(������Forward):" + nameList.size() + "��");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");
		
	}

}
