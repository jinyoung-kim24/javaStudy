package homework;

public class Restaurant {
	public static void main(String[] args) {
		FoodTable ft = new FoodTable("찌게테이블", FoodTable.FLAVOR_BAISC, 7);
		
		
		
		
		ft.chairs[0] = new Guest("김진영", 24, FoodTable.FLAVOR_SALTY);
		ft.chairs[1] = new Guest("이순신", 34, FoodTable.FLAVOR_HOT);
		ft.chairs[2] = new Guest("원종태", 26, FoodTable.FLAVOR_BAISC);
		ft.chairs[3] = new Guest("엘사", 29, FoodTable.FLAVOR_BAISC);
		ft.chairs[4] = new Guest("안나", 5, FoodTable.FLAVOR_SWEET);
		ft.chairs[5] = new Guest("올라프", 18, FoodTable.FLAVOR_BAISC);
		
		ft.printFoodTable2();
		
		
		
		
		
		
	}
}
