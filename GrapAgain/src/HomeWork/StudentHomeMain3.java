package HomeWork;

public class StudentHomeMain3 {

	public static void main(String[] args) {
		System.out.println("=== 학생 정보 출력 ===");
		jinyoung(1, "홍길동", 18, "체육학과", true);
		jinyoung(2, "김진영", 21, "조리학과", true);
		jinyoung(3, "홍동길", 35, "간호학과", false);
		
		

	}
	public static void jinyoung(int tnt, String name, int age, String major, boolean line ) {
		System.out.println("* 학생번호" + tnt);
		System.out.println("\t" + "이름:" + name);
		System.out.println("\t" + "나이:" + age + "세");
		System.out.println("\t" + "전공:" + major);
		
		if(line== true)
			System.out.println("-----------------------------");
		else
			System.out.println("=============================");
	
}
}
