package HomeWork;

public class StudenHomeMain2 {

	public static void main(String[] args) {
		System.out.println("=== 학생 정보 출력 ===");
		student(1, "홍길동", "조리학과", (int)(Math.random() * 31) + 10, true);
		student(2, "홍길돔", "간호학과", (int)(Math.random() * 31) + 10, true);
		student(3, "홍길돈", "체육학과", (int)(Math.random() * 31) + 10, false);

	}
	double jin = Math.random();
	int age = (int)(jin * 31) + 10;
	
	
public static void student(int tnt, String name, String major, int age, boolean line) {
	
	System.out.println("* 학생번호" + tnt);
	System.out.println("\t" +  "이름:" + name);
	System.out.print("\t" + "나이:" + age + "세");
	if(age >= 18)
		System.out.println("<미청년>");
	else
		System.out.println("<청년>");
	System.out.println("\t" + "전공:" + major);


if(true == line)
	System.out.println("-------------------------");
	else
	System.out.println("=========================");

}
	

}
