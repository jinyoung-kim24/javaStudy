package collective;
import java.util.HashSet;

public class DataMain2 {
	public static void main(String[] args) {
		// ����(��ü)���� ���� -- Character ��ü
		HashSet hs = new HashSet();
		hs.add('X');
		char c= 'Y';
		hs.add(c);
		
		for (Object ch : hs) {
			char p = (char)ch;
			System.out.printf(" ���� �ϳ� %c(%d)\n", p, (int)p);
		}
		
		String xyz = "XYZ";
		hs.add(xyz.charAt(xyz.length()-1));
		
		hs.add('a'); hs.add('b'); hs.add('c');
		hs.add('��'); hs.add('��'); hs.add('��');
		
		for (Object ch : hs) {
			char p = (char)ch;
			System.out.printf(" ���� �ϳ� %c(%d)\n", p, (int)p);
		}
		// ������ ������ �ǹ̰� ��� ������ �߿��� ó����� 
		// ���� �����͸� �迭 ����Ʈ�� �����Ͽ� ������ ó���ؾ���
		
		
	}
}
