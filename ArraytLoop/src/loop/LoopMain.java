package loop;

public class LoopMain {

	public static void main(String[] args) {
		// ���� loop: �ݺ� ���� ���� (����, ����� ������ ����)
		// �Ź� �ݺ��� ������ ������ ���ϴ� �����Ͱ� �־�� �ϸ�
		// �̷� ��ȭ�Ǵ� �����͸� �������� ������ �����ؾ� ��.
		// �Ź� ���� �� ���ǽ��� ��ȭ�� ���켭 �ݺ����� ������. 
		// ���������� �� �����ؾ� ��. 
		// 1) WHILE ���� 
		// 		���ǽ��� true�� �������࿡ ����, 
		//		false��� �� �� ���� �������� ����.
		int w = 0; // �ʱ��
		while(w < 2) {  // ���ǽ�   2 < 2 ����..
			System.out.println(w + " ");
			w++; // ������(��ȭ��)
			//w = w + 1;
		}
		System.out.println();
		
		// 2) FOR ���� (C��� ��Ÿ�� Ŭ����)
		// �ʱ��(�� �ѹ� ����),
		// ���ǽ�(�Ź� �������� ���� ���� �ѹ� üũ), 
		// ������(�Ź� �������� ���� �� �ѹ��� ����)�� �ϳ��� ��� ǥ����.
		// ���ǽ��� true�̾������ ���������� ���۵�.
//		for( �ʱ��; ���ǽ�; ������ ) {
//			// �ݺ�����.
//		}
		int f = 1; // �ʱ��
		for(; f <= 10;) { //���ǽ�
			System.out.println(f + " ");
			f++; // ������
		}
		System.out.println();
		
//		for( int f = 1; f <= 10; f++ ) { // error
//		for( f = 1; f <= 10; f++ ) { 
		for( int f2 = 1; f2 <= 10; f2++ ) { // 1 ~ 10
			System.out.print(f2 + " ");
		}
		System.out.println();
		
		//for( int f2 = 0; f2 <= 10; f2++ ) { // 0 ~ 10 
		//for( int f2 = 0; f2 <= 9; f2++ ) { // 0 ~ 9
		for( int f2 = 0, a = 3; f2 < 10; f2++ ) { // 0 ~ 9
			System.out.print(f2 + " ");
		}
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d\t", i);
		}
		System.out.println();
		
//		for(int i = 0; i < 10; i+=1) { // 0 ~ 9 
		//for(int i = 0; i < 10; i+=2) { // 0 2 4 6 8
		for(int i = 0; i < 10; i += 3) { // 0 3 6 9 ~ 12
		// int i for���� �ʱ�Ŀ��� ����� ���� i�� for�� ����� ���ÿ� �����.
		//int i; // i������ for���� ������� �޸𸮿� ���� (�ݺ������Ŀ��� �������)
		//for(i = 0; i < 10; i += 3) { // 0 3 6 9 ~ 12
			System.out.printf("%d\t", i);
		}
//		System.out.printf("\n%d\t", i); // error
		System.out.println();
		
		// 99 -> 0, i�� 1�� �پ��ٰ� -1�� �Ǹ� ���� ����.
//		for (int i = 99; i >= 0; --i) {
		for (int i = 99; i >= 0; i--) {
			System.out.printf("%d ", i );
		}
		System.out.println();
		
		// 99 -> 0, i�� 1�� �پ��ٰ� -1�� �Ǹ� ���� ����.
		for (int i = 99; i > -1; --i) {
			System.out.printf("%d ", i );
		}
		System.out.println();
		
		// 100 ~ 1
		for (int i = 100; i > 0; --i) {
			System.out.printf("%d ", i );
		}
		System.out.println();
		
		// 100 ~ 0 (101��)
		for (int i = 100; i >= 0; --i) {
			System.out.printf("%d ", i );
		}
		System.out.println();
		
		// 99 ~ 0
		for (int i = 100; i > 0; --i) {
			System.out.printf("%d ", i-1 );
		}
		System.out.println();
				
		for (int i = 100; i >= 0; i -= 6) {
			System.out.printf("%d ", i );
		}
		System.out.println();
	}

}
