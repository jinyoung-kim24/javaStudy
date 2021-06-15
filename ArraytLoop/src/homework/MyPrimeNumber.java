package homework;

public class MyPrimeNumber {
		
	
	public static void main(String[] args) {
		isPrimeNumber(31);
		System.out.println(isPrimeNumber(31));


	

		

		
	}

	private static int isPrimeNumber(int number) {
		int num = 0;
		for (int i = 2; i <= num; i++) {
			
		System.out.println(num % i == 0);
		}
		return num;
	}
}
