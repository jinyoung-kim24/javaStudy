package operation;

public class OpMain2 {

	public static void main(String[] args) {
		// ������ ������
		// % rem mod
		int r = 300 % 99; // 3
		// �̱�? pick
		boolean flag = true;
		while(flag) {
			r = (int)(Math.random() * 100) + 1; // 1 ~ 100  => 1 ~ 30
			r = (r % 30) + 1; // ��ġ�� �Է� ������ ���� ����...
			if(r == 1) {
				System.out.println("Ư���!!");
			flag= false; // ���� ���� ����
			}else if(r >= 2 && r <= 6)  // 2 ~ 6
				System.out.println("�����" + r);
			else if(r > 6 && r <= 16)  // 7 ~ 16
				System.out.println("�����" + r);
			else // ��
				System.out.println("��!!!");
		}
		System.out.println("-- pick ���� ���� --");
	}

}
