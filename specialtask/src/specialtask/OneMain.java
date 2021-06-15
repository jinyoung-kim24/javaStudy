package specialtask;

public class OneMain {

	public static void main(String[] args) {
		System.out.println((byte)0b00000100);
		// -4를 우선 양수 4인 0b00000100로 표현하고 맨앞에 1로 변경 0b10000100
		// 그리고 나머지 비트를 모두 변경 0 => 1, 1 => 0으로
		// 0b11111011로변경 여기에 +1을 더한다 
		// 0b11111011 + 00000001 = 0b11111100
		// 답은 0b 11111100
		System.out.println((byte)0b11111100);
		
	}

}
