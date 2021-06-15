package lotte;  // Lotte 6/32
// ��� �̱� 32������ 6���� ����(��)�� �̾ƺ���. (���༺)
// (����; �ߺ����� �ʴ� ���ڸ� 6���� ���ʴ�� ����ؾ���)
/*
 * 	1�� �� ���߸� ��ġ	 
 * 	2�� 5��
 * 	3�� 4��
 * 	4�� 3��
 */
public class LauckyDraw2 {
	// ��� ����
	public static final int MAX_BALLS = 20; // 1 ~ 32
	public static final int MATCH_BALLS = 6;
	public static final int NO_SEL = -1;
	public static void main(String[] args) {
		// �߱ǹ�ȣ���� ����ų �迭 ������� ���� ���� 6���� �޸� ����!
		// int selBalls[]; // �迭 ���� (�׷��� ���� ������ ����)
		// int selBalls[] = new int [6];
		int selBalls[] = {
			NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL, NO_SEL
		};
		
		// ���� �ڵ� ��Ű��ο�Ƽ�� �߱� 
//		int selBalls[] = {
//				7, 9, 18, 19, 20, 21
//		};
//		// ���� �ڵ� ��Ű��ο�Ƽ�� �߱�  (�Ϻθ� �ڵ�)
//		int selBalls[] = {
//				7, 9, NO_SEL, NO_SEL, NO_SEL, NO_SEL
//		};
		// 6�� ���� ��Ű��ȣ���� �̾Ƽ� �����ϴ� ���� ( ����������� ���� ����)
		int count = 0; // ���� ��ȣ(ȸ����) �̱� �õ� ī��Ʈ
		int selcount = 0; // ��Ű�� ���� ���� ī��Ʈ
		while(selcount < MATCH_BALLS) { // 0 ~ 5
			// ������ ���ں� �̱�
			int ball = (int) ((Math.random() * MAX_BALLS) + 1);
			
			
			System.out.println(count + "ȸ�� �ڵ���ȣ �� ==> (" + ball +")");
			
			// �ߺ� üũ
			boolean duplicated = false; // �ߺ��� ���ٰ� ����
			// �ߺ� ó��
			// duplicated�� false�� �����ϰ�, for���� �� �����ϰ� ���ͼ��� ������ false��� �ߺ��� �ƴ�
			// �ٵ� �� �ѹ��̶� ������ �ߺ����� �����Ǹ� true�� �����
			// true�迭�� �������� �ʰ� ���� ȸ�� count���� �ٽ� ������ �̾ƾ���.
			for (int i = 0; i < selBalls.length; i++) {
				if(ball == selBalls[i]) // �ߺ� �¾�??
					duplicated = true; // �ߺ�ã����
			}
			// �̹� �ݺ�ȸ���� ���� ��Ű�� ��ȣ�� �ߺ� ���� �ʾҴٸ�
			// ���� �����ϰ� ����� �迭�� �����ѵ���.
			if(duplicated == false){ 
			selBalls[selcount] = ball;
			// No_SEL �迭ĭ �ϳ��� ���� ball�� ä���....
			selcount++;
			}else { // �ߺ��϶�
				System.out.println("\t>> �ߺ���" + ball);
			}
			count++;
		} // ���� ���� ��.
		
		// ���� Ƽ�� = 6���� �� ���� ����Ʈ
		// Ƽ�����
		System.out.println(" ===== LD 6/32 TICKET =====");
		System.out.println("���ι�ȣ: " + (long)(Math.random() * 1000000000000000L));
		for (int i = 0; i < selBalls.length; i++) {
			System.out.print(selBalls[i] + " ");
		}
		System.out.println();
		System.out.println("========================");
	}

}
