package db.data;

public class Recipe {
	String MainDish;
	String ProcessPicture;
	String ProcessTxt;
	String YoutubeAddress;
	String Servings;
	String CookingTime;
	String Difficulty;
	String Material;
	int DishNum;
	String DishName;
	
	public Recipe() {
	}

	public Recipe(String mainDish, String processPicture, String processTxt, String youtubeAddress, String servings,
			String cookingTime, String difficulty, String material, int dishNum, String dishName) {
		super();
		DishName = dishName;
		DishNum = dishNum;
		MainDish = mainDish;
		ProcessPicture = processPicture;
		ProcessTxt = processTxt;
		YoutubeAddress = youtubeAddress;
		Servings = servings;
		CookingTime = cookingTime;
		Difficulty = difficulty;
		Material = material;
	}

	@Override
	public String toString() {
		return "Recipe [MainDish=" + MainDish + ", ProcessPicture=" + ProcessPicture + ", ProcessTxt=" + ProcessTxt
				+ "\r\nYoutubeAddress=" + YoutubeAddress + ", Servings=" + Servings + ", CookingTime=" + CookingTime
				+ ", Difficulty=" + Difficulty + "\r\n Material=" + Material + "\r\n DishNum=" + DishNum + ", DishName="
				+ DishName + "]";
	}

	public String getMainDish() {
		return MainDish;
	}

	public void setMainDish(String mainDish) {
		MainDish = mainDish;
	}

	public String getProcessPicture() {
		return ProcessPicture;
	}

	public void setProcessPicture(String processPicture) {
		ProcessPicture = processPicture;
	}

	public String getProcessTxt() {
		return ProcessTxt;
	}

	public void setProcessTxt(String processTxt) {
		ProcessTxt = processTxt;
	}

	public String getYoutubeAddress() {
		return YoutubeAddress;
	}

	public void setYoutubeAddress(String youtubeAddress) {
		YoutubeAddress = youtubeAddress;
	}

	public String getServings() {
		return Servings;
	}

	public void setServings(String servings) {
		Servings = servings;
	}

	public String getCookingTime() {
		return CookingTime;
	}

	public void setCookingTime(String cookingTime) {
		CookingTime = cookingTime;
	}

	public String getDifficulty() {
		return Difficulty;
	}

	public void setDifficulty(String difficulty) {
		Difficulty = difficulty;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public int getDishNum() {
		return DishNum;
	}

	public void setDishNum(int dishNum) {
		DishNum = dishNum;
	}

	public String getDishName() {
		return DishName;
	}

	public void setDishName(String dishName) {
		DishName = dishName;
	}
	
}
