package db.data;

public class Foods {
	public static final int DEF_makeMinute=15;
	public static final int DEF_EATINGPER=1;
	public static final String DEF_cookGrade="УЪБо";
	
	
	
	String foodType;
	String foodName;
	int makeMinute;
	int eatingPerson;
	String cookGrade;
	String imagePath;
	
	public Foods() {
		// TODO Auto-generated constructor stub
	}
	

	public String getfoodType() {
		return foodType;
	}


	public void setfoodType(String foodType) {
		this.foodType = foodType;
	}


	public String getfoodName() {
		return foodName;
	}


	public void setfoodName(String foodName) {
		this.foodName = foodName;
	}


	public int getmakeMinute() {
		return makeMinute;
	}


	public void setmakeMinute(int makeMinute) {
		this.makeMinute = makeMinute;
	}


	public int geteatingPerson() {
		return eatingPerson;
	}


	public void seteatingPerson(int eatingPerson) {
		this.eatingPerson = eatingPerson;
	}


	public String getcookGrade() {
		return cookGrade;
	}


	public void setcookGrade(String cookGrade) {
		this.cookGrade = cookGrade;
	}
	

	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	@Override
	public String toString() {
		return "Foods [foodType=" + foodType + ", foodName=" + foodName + ", makeMinute=" + makeMinute
				+ ", eatingPerson=" + eatingPerson + ", cookGrade=" + cookGrade +imagePath+ "]";
	}
	

	public Foods(String foodType, String foodName, int makeMinute, int eatingPerson, String cookGrade,String imagePath) {
		super();
		this.foodType = foodType;
		this.foodName = foodName;
		this.makeMinute = makeMinute;
		this.eatingPerson = eatingPerson;
		this.cookGrade = cookGrade;
		this.imagePath= imagePath;
	}


	public Foods(String imagePath) {
		super();
		this.imagePath = imagePath;
	}
	
	
}
