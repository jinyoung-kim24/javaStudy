package specialtask;

public class OneMain {

	public static void main(String[] args) {
		System.out.println((byte)0b00000100);
		// -4�� �켱 ��� 4�� 0b00000100�� ǥ���ϰ� �Ǿտ� 1�� ���� 0b10000100
		// �׸��� ������ ��Ʈ�� ��� ���� 0 => 1, 1 => 0����
		// 0b11111011�κ��� ���⿡ +1�� ���Ѵ� 
		// 0b11111011 + 00000001 = 0b11111100
		// ���� 0b 11111100
		System.out.println((byte)0b11111100);
		
	}

}
