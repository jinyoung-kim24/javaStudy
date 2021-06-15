package gugu;

public class Gugudan3b {

	public static final String EMTPY = "";
	public static void main(String[] args) {
		// 배열을 정의하여 구구단 실행결과를 바로 출력하지 않고, 
		// 이후 다목적으로 사용하기 위해 저장함.
		//  length => 8개, 순서번호 0 ~ 7
		// 0번째에 2단저장, ... 7번째 배열요소공간 9단저장..
		String[] guguArr = {
			EMTPY, EMTPY, EMTPY, EMTPY, 
			EMTPY, EMTPY, EMTPY, EMTPY
			//"", "", "", ""  	
			//null, null, null, null, null, null,null, null   	
		}; // 배열 요소공간 EMPTY 마다 단 하나의 구구단 결과를 저장할 예정.
		// 배열 공간에 관련이 있는 연산결과들을 저장시켰다가...
		// 이후 필요에 의해서 해당 배열에 구조적으로 접근하여 사용해야함. 
		
		// 구구단 2 ~ 9 단
		final int DAN_LIMIT = 9;//19; //9; // 인도, 일본?
		final int J_LIMIT = 10;//20; //10;
		for (int dan = 2; dan <= DAN_LIMIT; dan++) { // 8번실행
			guguArr[dan-2] += "** " + dan + "단 **\n";
			for (int j = 1; j < J_LIMIT; j++) { //9번실행
				guguArr[dan-2] += (dan + " x " + j 
						+ " = " + (dan*j) + "\n" );
			}
			guguArr[dan-2] += "-------------------";
		}
		// 이중 for문 완료 후 구구단 실행결과 문자열들을 guguArr배열에 모두 저장됨.
		
		System.out.println(guguArr[3-2]); // 3단
		System.out.println(guguArr[5-2]); // 5단
		System.out.println(guguArr[9-2]); // 9단
		
		
	}

}

