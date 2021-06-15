package gugu;

public class Gugudan2 {
	public static final String EMPTY = "";
	public static void main(String[] args) {
		
		// 배열을 정의하여 구구단 실행결과를 바로 출력하지 않고,
		// 이후 다목적으로 사용하기 위해 저장함.
		// length => 8개, 순서 번호 0 ~ 7
		// 0번쨰에 2단저장 ,.... 7번째 배열요소 공간 9단 저장..
		String[] guguArr = {
				EMPTY, EMPTY, EMPTY, EMPTY, 
				EMPTY, EMPTY,  EMPTY, EMPTY
		}; // 배열 요소공간 EMPTY 마다 단 하나의 구구단 결과를 저장할 예정.
		
		//구구단 2 ~ 9단 
		final int DAN_LIMIT = 9;
		final int J_LIMIT = 10;
		for (int dan = 2; dan <= DAN_LIMIT; dan++) { // 8번을 실행
			String danStr = "";
			danStr += "** " + dan + "단\n";
			for (int j = 1; j < J_LIMIT; j++) { // 9번을 실행
				danStr += (dan + " x " + j + " = " + (dan*j) + "\n");
				//System.out.printf(" %d x %d = %d \n", dan,j, dan*j); 72번 실행
			}
			danStr += "-----------------------------------";
			//System.out.println("----------------------");
			System.out.println(danStr);
	}
}
}