package lotte;  // Lotto 6/32

import java.util.Arrays;

// ��� �̱�:  32������ 6���� ����(��)�� �̾ƺ���. (���༺)
//   (����; �ߺ����� �ʴ� ���ڸ� 6���� ���ʴ�� ����ؾ���) 
/*
 *		1��	�� ���߸� ��ġ
 *  	2��	5��.. 
 *  	3�� 	4��..
 *  	4��	3��..
 */
public class LauckyDraw5 {
	// ��� ���� 
	public static final int MAX_BALLS = 32; //20; //32; // 1 ~ 32 ������ں�
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1; //0; 
	public static final int DEFAULT_TICKETS = 3; // 1
	public static void main(String[] args) {
		// �߱ǹ�ȣ���� ����ų �迭 ������� ���� -- ���� 6���� �޸� ����!
		//int selBalls[]; // �迭 ���� (�׷��� ���� ������ ����)
//		int selBalls[] = new int[6];
//		int selBalls[] = new int[MATCH_BALLS];
//		int selBalls[] = {
//			0, 0, 0, 0, 0, 0	
//		};
		// �ټ����� ����Ƽ�� �߱� ����
		int ticketCount = 0; // Ƽ��  �߱�ȸ�� ī��Ʈ
		do {
			
		
			int selBalls[] = {
				NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL	
			};
			
			// ���� �ڵ� ��Ű��ο�Ƽ�� �߱� 
	//		int selBalls[] = {	
	//			7, 9, 18, 19, 20, 21		
	//		};
	//		// ���� ���ڵ� ��Ű��ο�Ƽ�� �߱� (�Ϻθ� �ڵ�)
	//		int selBalls[] = {
	//			7, 9, NO_SEL,NO_SEL,NO_SEL,NO_SEL 		
	//		};
			
			// 6�� ���� ��Ű(��ȣ)���� �̾Ƽ� �����ϴ� ����  (����������� ���� ����)
			int count = 0; // ���� ��ȣ(ȸ����) �̱� �õ� ī��Ʈ
			int selCount = 0; // ��Ű�� ���� ���� ī��Ʈ(�迭 ������ȣ)
			while( selCount < MATCH_BALLS ) { // 0 ~ 5
				// ������ ���ں� �̱� 
				int ball = (int)(Math.random()*MAX_BALLS)+1; // 1 ~ 32
				System.out.println(
						count+"ȸ�� �ڵ���ȣ �� ==> (" + ball + ")");
						//count+"ȸ�� �ڵ���ȣ �� ==> (" + 0 + ")");
				
				// �ߺ� üũ
				boolean duplicated = false; // �ߺ��� ���ٰ� ����!!
				// �ߺ� ó�� ����: 
				// duplicated�� false�� �����ϰ�, 
				// for���� �� �����ϰ� ���ͼ��� ������ false��� �ߺ��� �ƴ�.
				// �ٵ�, �� �ѹ��̶� ������ �ߺ����� �����Ǹ� true �����. 
				// true �迭�� �������� �ʰ�, ����ȸ�� count���� �ٽ� ������ �̾ƾ���.
				for (int i = 0; i < selBalls.length; i++) {
					if( ball == selBalls[i] ) { // �ߺ� �¾�??
						duplicated = true; // �ߺ� ã����!!!
						break; // �ߺ� �߰ߵ��� ����.. üũ�� �׸���.
					}
				}
				// �̹� �ݺ�ȸ���� ���� ��Ű�� ��ȣ�� �ߺ����� �ʾҴٸ�...
				// ���� '����'�ϰ� ����� �迭�� �����ѵ���.
				if( duplicated == false ){ // �ߺ��ƴҶ�...
					selBalls[selCount] = ball;
						// NO_SEL �迭ĭ �ϳ��� ���� ball�� ä���...
					selCount++; // 0 => 1 ~ 5 �����... 6�̵Ǹ� while ����.
				} else { // �ߺ��϶�...
					System.out.println("\t>> �ߺ���!!! " + ball);
				}
				count++;
			} // ���� ���� ��..
			
			// ����迭�� ��� �ߺ����� ����ȣ 6���� ��������(��������)���� ����??
			// Sort ����... Ư�� �������� �����͵��� ������ ���ġ�ϴ� ��.. (�˰���)
			// sort()�ϸ� �迭 ��ü�� ����ǹǷ�... �����迭�� ��������س���...
			
	//		int[] oriSelBalls = new int[6];
			int[] oriSelBalls = { 
					NO_SEL,NO_SEL,NO_SEL,NO_SEL,NO_SEL,NO_SEL    
			};
			for (int i = 0; i < oriSelBalls.length; i++) {
				oriSelBalls[i] = selBalls[i];
			}
			Arrays.sort(selBalls); 
				// ������������ �迭�� ����� �������� ���ġ ���� ����
			
			// ���� Ƽ�� = 6���� �� ���� ����Ʈ
			// Ƽ�� ���  
			ticketCount++;
			System.out.println("\n===== LD 6/32 Ticket =====");
			System.out.println("* Ƽ�Ϲ߱Ǽ�: " + ticketCount + " / " + DEFAULT_TICKETS);
			System.out.println("* ���ι�ȣ: " + 
					(long)(Math.random()*100000000000000L));
			for (int i = 0; i < selBalls.length; i++) {
				System.out.print("("+selBalls[i] + ") ");
			}
			System.out.println();
			System.out.println("--------------------------");
			System.out.println(" �������ú���ȣ����Ʈ:: ");
			for (int i = 0; i < oriSelBalls.length; i++) {
				// if( i == 5 ), if( i < oriSelBalls.length-1)
				//System.out.print(oriSelBalls[i] + ",");
				System.out.print(oriSelBalls[i] + 
						( i < oriSelBalls.length-1
								? "," : "") ); 
						// ��������ȣ �� �ĸ� �����..
			}
			System.out.println("\n==========================");
		} while(ticketCount < DEFAULT_TICKETS); // do ~ while ��.
	
	}

}

/*
0ȸ�� �ڵ���ȣ �� ==> (5)
1ȸ�� �ڵ���ȣ �� ==> (27)
2ȸ�� �ڵ���ȣ �� ==> (4)
3ȸ�� �ڵ���ȣ �� ==> (5)
	>> �ߺ���!!! 5
4ȸ�� �ڵ���ȣ �� ==> (14)
5ȸ�� �ڵ���ȣ �� ==> (21)
6ȸ�� �ڵ���ȣ �� ==> (25)

===== LD 6/32 Ticket =====
���ι�ȣ: 3865999379481
4 5 14 21 25 27 
==========================

*/