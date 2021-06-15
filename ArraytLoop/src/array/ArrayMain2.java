package array;

public class ArrayMain2 {

	public static void main(String[] args) {
		// 정수 배열 초기화
		//int[] intArr = {}; // 빈배열 (요소가 들어간 "공간"이 없네..) 배열크기 = 0
		int[] intArr = { 1, 2, 3, 4, 5 }; 
			// 20 바이트의 요소공간에 정수 5개를 요소로써 배치... 
		System.out.println(" 배열크기 = " + intArr.length);
		intArr[0] = 7; // 1 => 7 
			// 배열의 요소공간 하나를 마치 intArr[0] 하나의 변수처럼 사용.
		intArr[0] = intArr[0] + 1;
		intArr[0] += 1;
		intArr[0]++;
//		int i = 0;
//		for ( ; i < intArr.length; i++) {		
		for ( int i = 0; i < intArr.length; i++) {
			System.out.printf(
				"arr[%d] => %d \n", i, intArr[i]);
		}
	}

}
