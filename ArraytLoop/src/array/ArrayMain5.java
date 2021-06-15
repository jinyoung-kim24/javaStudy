package array;

public class ArrayMain5 {

	public static void main(String[] args) {
		// 정수 배열 초기화
		//int[] intArr = {}; // 빈배열 (요소가 들어간 "공간"이 없네..) 배열크기 = 0
//		int[] intArr = { 1, 2, 3, 4, 5 }; // 선언과 동시 초기화
			// 20 바이트의 요소공간에 정수 5개를 요소로써 배치...
		int[] intArr = { 0, 0, 0, 0, 0 }; 
			// 정수 기본값으로 우선 5자리 공간 확보		
//		intArr[0] = 1;
//		intArr[1] = 2;
//		intArr[2] = 3;
//		intArr[3] = 4;
//		intArr[4] = 5; // 배열의 각 요소를 별도로 순차적으로 초기화
		
		// 루프문으로 배열 초기화
		for (int i = 0; i < intArr.length; i++) {
			
			intArr[i] = times(i+1, 2); // 2, 4, 6, 8, 10
		
			// 함수실행 결과를 배열 요소의 초기값으로 설정
		}
		
		System.out.println(" 배열크기 = " + intArr.length);
		
		printIntArray(intArr); // 배열을 입력변수(인자)로 사용하는 함수 호출
//		for ( int i = 0; i < intArr.length; i++) {
//			System.out.printf(
//				"arr[%d] => %d \n", i, intArr[i]);
//		}
		
		int[] tempArr = { 1, 3, 4, 5, 6, 2, 33, 56445, 223};
		printIntArray(tempArr);
	}
	// 배열 타입을 입력 변수(파라미터)로 받는 함수 정의
	private static void printIntArray(int[] intArr) {
		for ( int i = 0; i < intArr.length; i++) {
			System.out.printf(
				"arr[%d] => %d \n", i, intArr[i]);
		}
		
	}

	public static int times(int num, int time) {
		System.out.println( time + "배율 함수 실행..");
		return time * num;
	}
	
	private static int toDouble2(int num) {		
		return times(num, 2);
	}
	
	private static int toDouble(int num) {	
		return 2 * num;
	}

}
