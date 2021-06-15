package Hello;

public class GreetMain3 {

	public static void main(String[] args) {
		String str = "가나다" + "abc";
		System.out.println(str);
		String str2 = "가나다" + 123;
		System.out.println(str2);
		String str3 = "가나다" + "123";
		System.out.println(str3);
		String str4 = "1" + 3 + 5; // "???"
		//str4 = "1".concat("3").concat("5");
		String str5 = "1" + (3 + 5); // "???"
					// "1" + "8" = "18"
		System.out.println(str4);
		System.out.println(str5);
		int num = 1 + 3 + 5; // num = 9;
		System.out.println(num); // "9"
		System.out.println("num => " + num); 
		// "num => 9"
	}

}
