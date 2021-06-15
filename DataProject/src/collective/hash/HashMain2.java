package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
	https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%85%8C%EC%9D%B4%EB%B8%94
	https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%95%A8%EC%88%98
	�ؽ� ���̺�(��), �ؽ� �Լ�
	
	�ؽ�(Hash, ��Map, ����Dictionary)
	: ����(mapping) ���踦 ǥ���� �ڷᱸ���� ��ǥ��.	
 	�������:  key(hat �ܾ��̸�) => value(���ڶ� �濡 ����)
 	����:     key(����/�浵) => value(������ �� ��ġ)
 	�̸� => �繰,  �±� => ������,   Ű => �ڹ���
 	
 	key => value �������谡 �ؽ��� �⺻ ����. 
 	�������踦 �ڹٿ����� MapEntry��� ��. (Ű,���)�� ������ Pair�����.
 	pair���� ������ �ؽø��̶�� ��.
 	
 	����������, �ؽø��� ����ó�� ������ ����.. �׳� pair���� ������. 
 	
 	�ݵ�� Key�� '����'�ؾ���. (�ߺ� x), Key���� ���߿� ������ ������...
 	�ٸ�, Value�� �������� �ʾƵ� �Ǹ�(�ߺ� o), ������ null�� ��.
 	java.util.Map �������̽�, �̸� ������ java.util.HashMap
 	https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
*/

public class HashMain2 {

	public static void main(String[] args) {
		//Map<K, V> �������̽� ����
		HashMap<String, Integer> hm
			//= new HashMap<String, Integer>();
			= new HashMap<>(); // �ؽø� size 0 ����
		// �ؽø�: ��(pair)�� ���Ÿ���� ���� generic(Ÿ���Ķ���� ����)
		//			ŰŸ���� ���ڿ��� ����, ���Ÿ���� ������ ����.
		
		// �л��̸� ���ڿ� Ű => ���� ����    ����
//		hm.put("����", 26); // size++
//		hm.put("����", 24); 
//		hm.put("����", new Integer(28)); // Create
////		hm.put(""+123, 33);
////		hm.put(String.valueOf(123), 24);
//		
//		System.out.println("** �ؽø��� ũ��(�л���): " + hm.size());
//		System.out.println("���徾�� ���� :   ����   =>  "
//						+ hm.get("����") + "��");  
//			// Read  ����Ű�� �����ϴ� ����� ����
//		System.out.println("�������� ���� :   ����   =>  "
//				+ hm.get("����") + "��");
//		System.out.println("�������� ���� :   ����   =>  "
//				+ hm.get("����") + "��");
//		System.out.println("���־��� ���� :   ����  =>  "
//				+ hm.get("����") + "��");
//		System.out.println("���־��� ���� :   ����  =>  "
//				+ hm.getOrDefault("����", 19) + "��");
//				// �⺻ ���� �ɼ����� ����..
		
		// �̸� �迭(keys) �غ�
		String[] keys = null;
//		keys = new String[10];
		keys = new String[] {
			"����", "����", "����", "����", "����",
			"����", "����", "���", "����", "����"
		};
		
		// ��� ����Ʈ(values) �غ�
		ArrayList<Integer> values = new ArrayList<>(); 
		for (int i = 0; i < keys.length; i++) {
			Integer age = (int)(Math.random() * 100) + 1;
			values.add(age);
		}
		
		// ����(mapping) ����: 10���� �� pair�� ��������� ��� �ؽø��� ��Ұ� ��.
		// Ű�迭 => �������Ʈ(Ű�� ������ ����)�� ���������� ���� ����
		for (int i = 0; i < keys.length; i++) {
			hm.put(keys[i], values.get(i));
		}
		
		// ���� Ű���� ������� Ű�� �߽����� ������ Ž���ϸ鼭 Pair�� ���
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i]; // ������ Ű ���ڿ�(�̸�)
			Integer value = hm.get(key);
			System.out.println("Ű: " + key + " => ���: " + value + "��");
		}
		System.out.println("-------------------------");
		for (int i = keys.length-1; i >= 0; i--) {
			System.out.println("Ű: " + keys[i] + " => ���: " + hm.get(keys[i]) + "��");
		}
		
	}

}
