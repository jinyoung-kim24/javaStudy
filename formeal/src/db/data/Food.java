package db.data;

public class Food {
	private int foodnum;
	private String foodname;
	private String fooding;
	private int foodquantity;
	private int foodprice;
	private String foodimage;
	
	public Food() {}

	
	
	public Food(int foodnum, String fooding, int foodquantity, int foodprice, String foodimage) {
		super();
		this.foodnum = foodnum;
		this.fooding = fooding;
		this.foodquantity = foodquantity;
		this.foodprice = foodprice;
		this.foodimage = foodimage;
	}



	public Food(int foodnum, String foodname, String fooding, int foodquantity, int foodprice) {
//		this(foodnum, foodname, fooding, foodquantity, foodprice);
		super();
		this.foodnum = foodnum;
		this.foodname = foodname;
		this.fooding = fooding;
		this.foodquantity = foodquantity;
		this.foodprice = foodprice;
	}
	

	public Food(int foodnum, String foodname, String fooding, int foodquantity, int foodprice, String foodimage) {
		super();
		this.foodnum = foodnum;
		this.foodname = foodname;
		this.fooding = fooding;
		this.foodquantity = foodquantity;
		this.foodprice = foodprice;
		this.foodimage = foodimage;
	}



	public int getFoodnum() {
		return foodnum;
	}

	public void setFoodnum(int foodnum) {
		this.foodnum = foodnum;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFooding() {
		return fooding;
	}

	public void setFooding(String fooding) {
		this.fooding = fooding;
	}

	public int getFoodquantity() {
		return foodquantity;
	}

	public void setFoodquantity(int foodquantity) {
		this.foodquantity = foodquantity;
	}

	public int getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(int foodprice) {
		this.foodprice = foodprice;
	}



	public String getFoodimage() {
		return foodimage;
	}



	public void setFoodimage(String foodimage) {
		this.foodimage = foodimage;
	}



	@Override
	public String toString() {
		return "Food [foodnum=" + foodnum + ", foodname=" + foodname + ", fooding=" + fooding + ", foodquantity="
				+ foodquantity + ", foodprice=" + foodprice + ", foodimage=" + foodimage + "]";
	}

	
	
	
	
	
	
}
