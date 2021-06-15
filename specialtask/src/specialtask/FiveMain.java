package specialtask;

public class FiveMain {

	public static void main(String[] args) {
		int[][] text = {
		{11,7,4,2,1},
		{1,12,8,5,3},
		{6,2,13,9,6},
		{10,7,3,14,10},
		{13,11,8,4,15},
		{15,14,12,9,5}
		};
		for (int i = 0; i < 6; i++) {
			System.out.println("\t");
			
			for (int j = 0; j < 5; j++) {
				System.out.print("\t" + text[i][j]);
			}
			System.out.println();
		}
	}

}

