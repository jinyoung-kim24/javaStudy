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
public class ListMain2 {

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

		System.out.println("** �л��̸� ����Ʈ(������Forward):" + nameList.size() + "��");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");

		System.out.println("** �л��̸� ����Ʈ(������Reberse):" + nameList.size() + "��");
		final int CNT_NAMES = nameList.size();
		for (int i = CNT_NAMES - 1; i >= 0; i--) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");
		
		nameList.add("����"); // �ǵ�(��ġ)�� �߰�
		nameList.add(2,"����"); // 2�� ��ġ�� ���Ӱ� ������ �߰�
		
		System.out.println("** �л��̸� ����Ʈ(������Forward):" + nameList.size() + "��");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");
		
		nameList.add(0, "����"); // ����Ʈ�� �� ��(��ġ�� �߰�)
		
		System.out.println("** �л��̸� ����Ʈ(������Forward):" + nameList.size() + "��");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");
		
		nameList.add(0, "����"); // ����Ʈ�� �� ��(��ġ�� �߰�)
		nameList.add("����");
		nameList.add(nameList.size(),"����"); // �ǵ�(��ġ)�� �߰�
		System.out.println("** �л��̸� ����Ʈ(������Forward):" + nameList.size() + "��");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.printf("\t �л�: %03d�� => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");
		
		
		
		
		
		
	}

}
