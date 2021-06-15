package homework.data;

import java.util.ArrayList;




public class product {

	public static void getAvgUnitPriceFromList(ArrayList<product> pt) {
		System.out.println("| 종류	| 상품개수        | 평균단가 |");
		for (product ptq : pt) {
			System.out.println(ptq.type	+ "\t" + ptq.count + "\t" + ptq.unitPrice);			
		}
		System.out.println("-------------------------------");
	}
	
	
	public static final int DEF_NUMBER = 0;
	
	private int number; // 번호
	private String name; // 이름
	private int unitPrice; // 단가
	private int count; // 개수(수량)
	private String type; // 종류

	public product() {
	}

	public product(String name, int unitPrice, int count, String type) {
		super();
		this.number = DEF_NUMBER;
		this.name = name;
		this.unitPrice = unitPrice;
		this.count = count;
		this.type = type;
	}

	public product(int number, String name, int unitPrice, int count, String type) {
		super();
		this.number = number;
		this.name = name;
		this.unitPrice = unitPrice;
		this.count = count;
		this.type = type;
	}

	@Override
	public String toString() {
		return "product [number=" + number + ", name=" + name + ", unitPrice=" + unitPrice + ", count=" + count
				+ ", type=" + type + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {	
		this.type = type;
	}

	public int getNumber() {
		return number;
	}
	
}
