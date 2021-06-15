package array;

public class ArrayMain3 {

	public static void main(String[] args) {
		// 정수 배열 초기화 
		//int[] intArr = {}; // 빈배열 (요소가 들어간 공간이 없네..)
		//int[] intArr = {1, 2, 3, 4, 5}; // 20 바이트의 요소공간에 정수 5개를 요소로써 배치....
		
		int[] intArr = {0, 0, 0, 0, 0}; // 정수 기본값으로 우선 5자리 공간 확보
//		intArr[0] = 1;
//		intArr[1] = 2;
//		intArr[2] = 3;
//		intArr[3] = 4;
//		intArr[4] = 5; // 배열의 각 요소를 별도로 순차적으로 초기화
				
		// 루프문으로 배열 초기화
		for (int i = 0; i < intArr.length; i++) {
			//intArr[i] = 100; // 모든 요소가 1로 초기화
			intArr[i] = i + 1; // intArr[0] = 0 + 1
		}
		System.out.println("배열크기 = " + intArr.length);
		intArr[0] = 7; // 1 => 7 
		// 배열의 요소공간 하나를 마치 intArr[0] 하나의 변수처럼 사용.
		intArr[0] = intArr[0] + 1;
		intArr[0] += 1;
		intArr[0]++;
		
		for (int i = 0; i < intArr.length; i++) {
			System.out.printf("arr[%d] => %d \n",i, intArr[i]);
		}
	}

}
