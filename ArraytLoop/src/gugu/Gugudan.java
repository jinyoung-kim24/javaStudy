package gugu;

public class Gugudan {

	public static void main(String[] args) {
		// 구구단 2 ~ 9단 
//		final int DAN_LIMIT = 9;
//		final int J_LIMIT = 9;
//		for (int dan = 2; dan <= DAN_LIMIT; dan++) {
//			for (int j = 1; j < J_LIMIT; j++) {
//				System.out.printf(" %d x %d = %d \n", dan,j, dan*j);
//			}
		
		
		final int DAN_LIMIT = 10;
		int dan = 2;
		while(dan < DAN_LIMIT) {
			int j = 1;
			while(j < DAN_LIMIT) {
	
				System.out.printf("%d x %d = %d \n",dan, j, dan * j);
				j++;
			}
			dan++;
			System.out.println("-----------------------------");
		}
		
	}
}
