package homework;

public class Guest {
	public static final String DEF_NAME = "È«±æµ¿";
	public static final int DEF_AGE = 19;
	
	
	public String name;
	public int age;
	public int flavor;
	
	public Guest() {
		this.name = DEF_NAME;
		this.age = DEF_AGE;
	}

	public Guest(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	
	
	public Guest(String name, int age, int flavor) {
		super();
		this.name = name;
		this.age = age;
		this.flavor = flavor;
	}



	@Override
	public String toString() {
		return name + ", " + age + "¼¼, - " + flavor;
	}
	
	
}
