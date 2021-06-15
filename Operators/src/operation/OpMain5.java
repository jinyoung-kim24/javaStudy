package operation;

public class OpMain5 {

	public static void main(String[] args) {
		// 논리형 boolean true, false 명제
		boolean flag = false;
		flag = 365 > 30; // true 
		flag = 365 % 2 == 0; // 비교연산자 => 조건식 짝수 => false
		flag = 365 % 2 == 1; // 홀수 => true
		flag = 365 % 2 != 0; // 짝수 아니면  => 홀수true
		flag = 'A' < 'a'; // 65 < 97 => true
		flag = ('Z' - 'A') == 25; // true
		
		if(1 == 1) System.out.println(true);
		if(2 != 1) System.out.println(true);
		if(2 > 1) System.out.println(true);
		if(2 > 2) System.out.println(false);
		if(2 >= 2) System.out.println(true);
		if(1 <= 3) System.out.println(true);
		
		
		
		if(true && true) System.out.println("true");
		//if(true && true == true)
		if(true && false) System.out.println("false");
		if(false && true) System.out.println("false");
		if(false && false) System.out.println("false");
		
		if(true || true) System.out.println("true");
		if(true || false) System.out.println("true");
		if(false || true) System.out.println("true");
		if(false || false) System.out.println("false");
		
		if(false 
				|| false
				|| false 
				|| false
				|| false
				|| true) System.out.println("finaltrue");
	
	
	
	
	}

}
