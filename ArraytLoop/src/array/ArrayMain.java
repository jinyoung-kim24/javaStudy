package array;

public class ArrayMain {

	public static void main(String[] args) {
		// 배열 Array (배열은 List(목록) 리스트 자료구조으 한 종류이다.)
		// "동일한 데이터형" 요소들을 다 수개 대표이름으로 묶어놓은 것. 
		// 순서번호 index로써 배열의 각 요소를 접근, 변경 등의 관리가 가능
		// 순서번호 범위 0 ~ 요소개수-1까지.
		// 요소개수 = 배열크기(길이) = length '상수'
		// 배열의 크기는 상수이므로, 한 번 정의된 배열은 그 크기가 절대 변할 수 없다.
		
		// 자바 기본형 Primitives 배열들 --------
		
		// 수치형 정수계열 배열
		//int[] intArr;  // 정수 배열 선언 (정수 요소들을 다 수개 가지는 배열 공간)
		int[] intArr = { 0, 365, -274, 674432 }; // 선언 +초기화 = 정의
		//   index       0   1     2     3(intArr.length-1)
		byte[] byteArr = { -128, 0, 127, 128-1, (byte)128 };
		short shortArr[] = { 0, -1, -32000, (short)65536/2, 
				-65536/2, 65536/2-1 };
		long []longArr = { 0, 0L, 2200000000L, -2100000000, 
				(long)2200000000L };
		
		// 실수계열 배열
		float[] floatArr = { 0f, 0.0f, 
				(float)0.0, 1.234F, -2f, 3.1415f };
		double[] doubleArr = { 0, 0L, 0f, 0.0, 0.0D, 2.0, 
				-2.345, 3d, 100.0d, 3.141592, Math.PI 
		};
	
		// 문자형 배열  Character Array != 문자열 (String) 
		char charArr[] = { '홍', '길', '동', 0, '\0' };
		char c = '엘'; // 문자셋의 순서번호인 해당 문자에 대한 코드값(정수)
		char []charArr2 = { 'A', 65, 'a', 97, ' ', 32, 
				'a'-'A', '홍'-1, (char)(c+1),   
				charArr[2], (char)(charArr[2]-1) };
		System.out.println("charArr2 배열의 크기: " +
				charArr2.length + "글자수");
		for (int i = 0; i < charArr2.length; i++) {
			System.out.printf(
				"%d번째 문자 요소 = %c [%d] \n", 
				i, charArr2[i], (int)(charArr2[i]));
				//i, charArr2[10], (int)(charArr2[10]));
//				i, charArr2[charArr2.length-1], 
//				(int)(charArr2[charArr2.length-1]));
		}
	
		// 논리형 배열 
		boolean[] boolArr = 
		{ 
			true, true, false, true, false, 
			33 != 0,   // true
			100 > 300,  // false  => 조건식의 항상 논리값으로 결론.
			charArr2.length % 2 == 0
		};
	}
}
/*
charArr2 배열의 크기: 11글자수
0번째 문자 요소 = A [65] 
1번째 문자 요소 = A [65] 
2번째 문자 요소 = a [97] 
3번째 문자 요소 = a [97] 
4번째 문자 요소 =   [32] 
5번째 문자 요소 =   [32] 
6번째 문자 요소 =   [32] 
7번째 문자 요소 = 홌 [54860] 
8번째 문자 요소 = 엙 [50649] 
9번째 문자 요소 = 동 [46041] 
10번째 문자 요소 = 돘 [46040] 
*/