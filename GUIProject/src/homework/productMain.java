package homework;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import homework.data.product;

public class productMain {

	public static void main(String[] args) {
		ArrayList<product> pr = new ArrayList<>();
		pr.add(new product("������ǰ", 2000000, 1, "��Ź��"));
		pr.add(new product("��", 15000, 7, "����"));
		pr.add(new product("�峭��", 20000, 5, "�Ǻ�"));
		pr.add(new product("�Ź�", 100000, 8, "����Ű"));
		pr.add(new product("����", 8000, 1, "���"));
		
		
		
	
	}
	public static void getAvgUnitPriceFromList(ArrayList<product> pt) {
		System.out.println("| ����	| ��ǰ����        | ��մܰ� |");
		for (product ptq : pt) {
			System.out.println(ptq.getType()	+ "\t" + ptq.getCount() + "\t" + ptq.getUnitPrice());			
		}
		System.out.println("-------------------------------");
	}

}
