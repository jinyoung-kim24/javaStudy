package homework;

public class Restaurant {
	public static void main(String[] args) {
		FoodTable ft = new FoodTable("������̺�", FoodTable.FLAVOR_BAISC, 7);
		
		
		
		
		ft.chairs[0] = new Guest("������", 24, FoodTable.FLAVOR_SALTY);
		ft.chairs[1] = new Guest("�̼���", 34, FoodTable.FLAVOR_HOT);
		ft.chairs[2] = new Guest("������", 26, FoodTable.FLAVOR_BAISC);
		ft.chairs[3] = new Guest("����", 29, FoodTable.FLAVOR_BAISC);
		ft.chairs[4] = new Guest("�ȳ�", 5, FoodTable.FLAVOR_SWEET);
		ft.chairs[5] = new Guest("�ö���", 18, FoodTable.FLAVOR_BAISC);
		
		ft.printFoodTable2();
		
		
		
		
		
		
	}
}
