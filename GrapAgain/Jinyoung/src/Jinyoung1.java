
public class Jinyoung1 {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int count = 0;
		while(count < 1000) {
			char msg = (char) ((Math.random() * 95) + 33);
			System.out.printf("%dȸ�� '%c' ���� => ", count+1, msg);
			count++;
			if(msg >= 65 && msg <= 90) {
				System.out.println("���� �빮��");
				a++;
			}else if(msg >= 97 && msg <= 122) {
				System.out.println("�����ҹ���");
				b++;
			}else if(msg >= 48 && msg <= 57) {
				System.out.println("���ڹ���");
				c++;
			}else {
				System.out.println("��ȣ����");
				d++;
			}
			double e = jin(a);
		}
		System.out.println("-----------------------");
		System.out.printf("���� �빮��: %d�� (%.2f%%) \n",a,jin(a));
		System.out.printf("���� �ҹ���: %d�� (%.2f%%) \n",b,jin(b));
		System.out.printf("���ڹ���: %d�� (%.2f%%) \n",c,jin(c));
		System.out.printf("��ȣ����: %d�� (%.2f%%) \n",d,jin(d));
		
		
	}

	private static double jin(int a) {
		double e = 0.0;
		e = (double)(a / 1000.0) * 100.0;
		return e;
	}

	

}
