package homework;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import homework.data.product;

public class productMain {

	public static void main(String[] args) {
		ArrayList<product> pr = new ArrayList<>();
		pr.add(new product("가전제품", 2000000, 1, "세탁기"));
		pr.add(new product("옷", 15000, 7, "구찌"));
		pr.add(new product("장난감", 20000, 5, "또봇"));
		pr.add(new product("신발", 100000, 8, "나이키"));
		pr.add(new product("음식", 8000, 1, "라면"));
		
		
		
	
	}
	public static void getAvgUnitPriceFromList(ArrayList<product> pt) {
		System.out.println("| 종류	| 상품개수        | 평균단가 |");
		for (product ptq : pt) {
			System.out.println(ptq.getType()	+ "\t" + ptq.getCount() + "\t" + ptq.getUnitPrice());			
		}
		System.out.println("-------------------------------");
	}

}
