package homework.count;

import org.omg.CORBA.PUBLIC_MEMBER;

public class CountNumber {
	
	public static char evenNumbery = '¦';
	public static char oddNumbery = 'Ȧ';
	public static String END = "----------------------------------";
	public static final int RanDomNumBer = 100;
	
	
	public static void main(String[] args) {
		
		ResultEvenOdd();
	
	}
	
	
	
public static void ResultEvenOdd() {
	int evenNumber = 0;
	int oddNumber = 0;
	int count = 1; // ȸ��
		while(count <= RanDomNumBer) {
				int num = (int) ((Math.random() * 1000) + 1); // ����!!
	
				int num2 = num % 2; // ¦���� Ȧ�� ������ 
	char getMsg = ' ';
	
	getMsg = oddEven(num2);
	
	System.out.printf("\t%dȸ�� ����  %d���� => %s��\n", count, num, getMsg);
	++count;
	if(getMsg == evenNumbery) 
		evenNumber++;
	else if(getMsg == oddNumbery)
			oddNumber++;
	
	}
		System.out.println(END);
		System.out.printf("\t¦��:%d��,Ȧ��:%d��\n",evenNumber,oddNumber);
	
}
	
	private static char oddEven(int num) {
		char getMsg = 0;
		if(num == 0 ) {
			getMsg = evenNumbery;
		}else {
			getMsg = oddNumbery;
		}
		
		return getMsg;
	}

	

	}
