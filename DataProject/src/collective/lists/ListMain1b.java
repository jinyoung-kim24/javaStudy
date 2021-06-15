package collective.lists;
// Data Structure �ڷ� ���� ( + �˰���)
// java �� ���� �����͵��� ȿ�������� ǥ���ϴ� ����..
// �������� collective data ��������..
// => �������� ����, �������� ����� ����, ����(���), ����,
// 	  ����, ����/����, ����, �ߺ�, (�ð�?) 
// �迭?
// �ڹ��� 3�� �⺻ �÷�����
//  ���� Set, ����Ʈ List, �ؽ�(Hash ��/����)
// JCF(�ڹ� �÷��� �����ӿ�ũ) => �ڹ� �������� �����͵��� 
// ǥ�� �� ó���� �� �ִ� �������̽�, Ŭ�������� ������� ����. 
// JFC�� �÷��� �ڷ����� ��� ��ҵ��� ���� ���۷��� �� '��ü'�� ������.
//					�⺻�� 123 x    new Integer(123) o

import java.util.ArrayList;
import java.util.List;

public class ListMain1b {

	public static void main(String[] args) {
		// List �������̽� (�Ծ�)
		// ArrayList Ŭ���� ( List �������̽��� ��� ������ ����Ʈ Ŭ����)
		// �Ϲ� ����Ʈ == '�������� �迭'
		ArrayList list = new ArrayList();
		
		// ����Ʈ�� �� �ڿ� ��ġ�� �������� ������ȣ�� �ο��Ͽ� ������ �߰�
		list.add(100);
		list.add(new Integer(100));		
		list.add(1234567890L);
		list.add(new Long(1234567890L));
		list.add(3.141592f);
		list.add(new Float(3.141592f));
		list.add('��');
		list.add(new Character('��'));
		list.add(3 == 2); // false ����
		list.add(new Boolean(3 == 2));
		// ��� �߰��� ������ ����Ʈ �ȿ��� ����!!
		
		System.out.println("����Ʈ�� ũ��: " + list.size());
		for (Object item : list) {
			System.out.println("- " + item);
		} // list ������ �����Ǹ� ���.
		System.out.println("--------------------");
		// �迭�� �����ϰ� ����Ʈ�� ������ȣ 0 size() -1 �����
		// Ŭ���� for������ �ε������ ���� Ž���� ������.
		list.add("����̴�!!");
		list.add("����̴�!!");
		System.out.println("����Ʈ�� ũ��: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ": " + list.get(i)); // ��ȸ

		}
		
		
		
	}

}
