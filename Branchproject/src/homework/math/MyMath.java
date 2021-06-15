package homework.math;

public class MyMath {
	public static double in = 0.5;

	public static void main(String[] args) {
		
		double input1 = 3.141592;
		double input2 = 5.50;
		double input3 = 3.99;
		double input4 = 3.0;
		double input5 = 0.0;
		double input6 = 0.000001;
		double input7 = -3.51;
	
		int roundValue1 = myRound(input1);
		int roundValue2 = myRound(input2);
		int roundValue3 = myRound(input3);
		int roundValue4 = myRound(input4);
		int roundValue5 = myRound(input5);
		int roundValue6 = myRound(input6);
		int roundValue7 = myRound(input7);
		
		int floorValue1 = myFloor(input1);
		int floorValue2 = myFloor(input2);
		int floorValue3 = myFloor(input3);
		int floorValue4 = myFloor(input4);
		int floorValue5 = myFloor(input5);
		int floorValue6 = myFloor(input6);
		int floorValue7 = myFloor(input7);
		
		int ceilValue1 = myCeil(input1);
		int ceilValue2 = myCeil(input2);
		int ceilValue3 = myCeil(input3);
		int ceilValue4 = myCeil(input4);
		int ceilValue5 = myCeil(input5);
		int ceilValue6 = myCeil(input6);
		int ceilValue7 = myCeil(input7);
		
		
		System.out.println(roundValue1);
		System.out.println(roundValue2);
		System.out.println(roundValue3);
		System.out.println(roundValue4);
		System.out.println(roundValue5);
		System.out.println(roundValue6);
		System.out.println(roundValue7);
		System.out.println("--------------");
		System.out.println(floorValue1);
		System.out.println(floorValue2);
		System.out.println(floorValue3);
		System.out.println(floorValue4);
		System.out.println(floorValue5);
		System.out.println(floorValue6);
		System.out.println(floorValue7);
		System.out.println("--------------");
		System.out.println(ceilValue1);
		System.out.println(ceilValue2);
		System.out.println(ceilValue3);
		System.out.println(ceilValue4);
		System.out.println(ceilValue5);
		System.out.println(ceilValue6);
		System.out.println(ceilValue7);
		
	}

	private static int myCeil(double input1) {
		double myCeil = input1;
		if(myCeil > 0) {
			myCeil++;
		} 
			
		return (int) myCeil;
	}

	private static int myFloor(double input1) {
		double myFloor = input1;
		if(myFloor < 0) {
			--myFloor;
		}
		
		return (int) myFloor;
	}

	private static int myRound(double input1) {
		double myRound = input1 ;
		if(myRound > 0) {
			myRound = myRound + 0.5;
		}
		
		
		return (int) myRound;
	}
	
}
