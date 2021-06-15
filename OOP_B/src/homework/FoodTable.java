package homework;

import java.util.Arrays;

import homework.Guest;

public class FoodTable {
	public static final int FLAVOR_BAISC = 0;
	public static final int FLAVOR_SWEET = 1;
	public static final int FLAVOR_SALTY = 2;
	public static final int FLAVOR_HOT = 3;
	public static final String[] FLAVORS = { "기본맛", "달콤한맛", "짠맛", "매운맛" };
	public String foodname;
	public int no;
	public int size;
	public int taste;
	public Guest[] chairs;

	public FoodTable() {

	}

	public FoodTable(String foodname, int taste, int size) {
		this.foodname = foodname;
		this.taste = taste;
		this.size = size;
		this.chairs = new Guest[this.size];
	}

	public FoodTable(String foodname, int no, int size, int taste, Guest[] chairs) {
		super();
		this.foodname = foodname;
		this.no = no;
		this.size = size;
		this.taste = taste;
		this.chairs = chairs;
	}

	public void printFoodTable() {
		int count = 0;
		System.out.println(++count + " 번 '" + foodname + " - " + FLAVORS[taste] + "!");
		int num = 0;
		for (Guest gu : chairs) {
			if (gu == null) {
				System.out.println("[" + ++num + "] 자리 비었음.");
			} else {
				System.out.println("[" + ++num + "] " + gu.name + ", " + gu.age + "세, " + FLAVORS[gu.flavor]);
			}
		}
	}

	public void printFoodTable2() {
		int count = 0;
		System.out.println(++count + " 번 '" + foodname + " - " + FLAVORS[taste] + "!");
		int num = 0;
		for (Guest gu : chairs) {
			if (gu == null) {
				System.out.println("[" + ++num + "] 자리 비었음.");
			} else {
				if (gu.flavor == taste) {
					System.out.println("[" + ++num + "] " + gu.name + ", " + gu.age + "세, " + FLAVORS[gu.flavor]);
				} else {
					System.out.println("\t >>" + gu.name + ", " + gu.age + "세, " + FLAVORS[gu.flavor] + " 제외됨.");
				}
			}
		}
	}

	public void printFoodTable3() {
		int count = 0;
		System.out.println(++count + " 번 '" + foodname + " - " + FLAVORS[taste] + "!");
		int num = 0;
		for (Guest gu : chairs) {
			if (gu == null) {
				System.out.println("[" + ++num + "] 자리 비었음.");
			} else {
				if (gu.flavor == taste) {
					System.out.println("[" + ++num + "] " + gu.name + ", " + gu.age + "세, " + FLAVORS[gu.flavor]);
				}
			}
		}
	}
}
