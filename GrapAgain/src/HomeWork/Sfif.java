package HomeWork;

public class Sfif {

	public static void main(String[] args) {
		System.out.println("=== 학생 정보 출력 ===");
		jinyoung(1, "홍길동", (int) (Math.random() * 40), "체육학과", true);
		jinyoung(2, "김진영", (int) (Math.random() * 40), "조리학과", true);
		jinyoung(3, "홍동길", (int) (Math.random() * 40), "간호학과", false);
		
		
		
		

	}
	public static void jinyoung(int tnt, String name, int age, String major, boolean line ) {
		System.out.println("* 학생번호" + tnt);
		System.out.println("\t" + "이름:" + name);
		System.out.println("\t" + "나이:" + (int) (Math.random() * 40) + "세");
		System.out.println("\t" + "전공:" + major);
		
		if(line== true)
			System.out.println("-----------------------------");
		else
			System.out.println("=============================");
	
		if((int) (Math.random() * 40)<= 18)
			System.out.println("<청년>");
		else
			System.out.println("<미청년>");
		 
		
		
	}
	
}

