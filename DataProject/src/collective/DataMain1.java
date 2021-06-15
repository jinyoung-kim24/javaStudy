package collective;

import java.util.HashSet;
import java.util.Set;

// Data Structure �ڷ� ���� ( + �˰���)
// java �� ���� �����͵��� ȿ�������� ǥ���ϴ� ����..
// �������� collective data ��������..
// => �������� ����, �������� ����� ����, ����(���), ����,
//	  ����, ����/����, ����, �ߺ�, (�ð�?) 
// �迭?
// �ڹ��� 3�� �⺻ �÷�����
//    ���� Set, ����Ʈ List, �ؽ�(Hash ��/����)
//  JCF(�ڹ� �÷��� �����ӿ�ũ) => �ڹ� �������� �����͵��� 
//   ǥ�� �� ó���� �� �ִ� �������̽�, Ŭ�������� ������� ����. 
//   JFC�� �÷��� �ڷ����� ��� ��ҵ��� ���� ���۷��� �� '��ü'�� ������.
//					�⺻�� 123 x    new Integer(123) o 

/* 
 *    ���� Set (��Ʈ)
 *    	(Ư�� Ÿ����) ��ҵ��� �ϳ��� ���� ���� ������� ��.
 *     ������ȣ(index) ���� ���� ����(���� ��ü�� �ǹ̸� �ο����� ����)
 *     �ڹٿ����� ��, ������ ��ҵ��� �ߺ��Ǵ� ���� ������� ����.
 *     ��� ��ҵ��� ���� ���۷��� �� '��ü'�� ������.
 *    	https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 */

public class DataMain1 {

	public static void main(String[] args) {
		//Set set1 = new Set()???  // Set �������̽�
		HashSet hs = new HashSet();    // Set �������̽��� ������ ��üȭ Ŭ������

		System.out.println("��� ����: " + hs.size()); 
								// ��������� ����� �Ѱ���
		hs.add(new 
		Integer(1999)); // ��ġ�� ��ü ���
		hs.add(1982); // auto-boxing 
		hs.add(2002);
		hs.add(2021);
		hs.add(2022);
		hs.add(2030);
		hs.add(2040);
		hs.add(2019);
		System.out.println("�⵵ ������ ��� ����: " + hs.size()); 
		
//		for (int i = 0; i < args.length; i++) {
		// ���տ��� ������ȣ ����.. ������ �� �� ����.
		for (Object year : hs) {
			System.out.println("* �⵵ :" + year);
		}	
		
		hs.add(3000);
		System.out.println("�⵵ ������ ��� ����: " + hs.size());
		for (Object year : hs) {
			Integer y = (Integer) year;
			//System.out.println("* �⵵ :" + y);
			System.out.println("* �⵵ :" + y);
		}
				
	}

}
