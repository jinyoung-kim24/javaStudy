package array;
// 배열 Array
// 배열에는 차원(Dimension)이 존재함.
// 차원은 기준축이 있고, 인덱스축에 따라서 순서번호가 변화됨
// 1차원, 2차원, 3차원,  .... , 다차원 배열 
// i축, xy축, xyz축...    (행렬, 벡터...)
public class ArrayMain6 {

	public static void main(String[] args) {
		// 1차원 배열
		//int[] arr1D = {}; // 1D empty array
		int[] arr1D = { 2, 4, 6, 8, 10 };
		// index i      0  1  2  3   4   => 1차원 i축 선상에 요소 나열
		
		// 2차원 배열
		// 수학: 행렬 matrix, 벡터 vector
		// 시간표, 엑셀시트, 구글시트, 체스판, 바둑판, 테이블, 달력..
		// 평면 => 행(row) x 열(column)
		//int[][] arr2D = {}; // 2D empty array
		// 2차원 배열은 그냥 '배열의 배열'임. 
		// 즉, 1차원 배열을 그 요소로 가지는 배열이 2차원 배열. 
		int[][] arr2D = {
			{ 1, 2, 3 },   // [0]행
			{ 4, 5, 6 },   // [1]행	
			{ 7, 8, 9 }    // [2]행 -- row 행번호 범위 0 ~ 2 
		//   0열  1열  2열  -- column 열번호 범위 (각 행마다) 0 ~ 2?    
		}; // 3 x 3 배열
		//  행과 열의 순서번호를 좌표계로 표현하면  (row,column)
		//	 (0,0) => 1 (0,1) => 2 (0,2) => 3	
		//	 (1,0) => 4 (1,1) => 5 (1,2) => 6
		//   (2,0) => 7 (2,1) => 8 (2,2) => 9
		//  (0,0) ~ (2,2)로 각 요소값을 탐색 접근이 가능함.
		// 자바에서는 (2,2) ==> [2][2]
		System.out.println(
			"arr2D의 첫번째요소 (0,0) => " + arr2D[0][0]);
		System.out.println(
			"arr2D의 마지막요소 (2,2) => " + arr2D[2][2]);
		//
		// 이중 루프 (중첩루프 nested loop)
		for (int row = 0; row < 3; row++) { // 행루프
			for (int column = 0; column < 3; column++) 
			{ // 열루프 (각 row 행마다 별도의 열루프가 실행됨)
//				System.out.print(row +"행, " + column +"열");
				System.out.print(
						"(" +row +"," + 
						column +") = "+ arr2D[row][column]
						+" \t");
					//"(" +row +"," + column +") = 0 \t");				
			}
			System.out.println(); // 행바뀜...
		}
	}

}

/*
arr2D의 첫번째요소 (0,0) => 1
arr2D의 마지막요소 (2,2) => 9
(0,0) = 1 	(0,1) = 2 	(0,2) = 3 	
(1,0) = 4 	(1,1) = 5 	(1,2) = 6 	
(2,0) = 7 	(2,1) = 8 	(2,2) = 9 	
 
 */



