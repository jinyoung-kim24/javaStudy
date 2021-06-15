package text;

public class TextMain {

	public static void main(String[] args) {
		// �ؽ�Ʈ ó�� �⺻�� => char ������ ( 16��Ʈ, 2����Ʈ)
		// ���� �Ѱ��� ǥ��, 0 ~ 65535 
		// (UTF-16 �����ڵ�ü�� => ASCII �ڵ� ü��)
		// ���ͷ� 'A' => �ش� �ڵ��(���ڼ�)�� ������ȣ��
		// ����Ŭ������ Chracter��..
		char c1 = 'A'; // 65
		Character c2 = 65; // 'A' // new Character('A')
		char c3 = c2.charValue(); // 'A'
		char c4 = 0x0041;
		char c5 = '\u0041';
		char c6 = 0; // '\0' ���Ṯ�� => �⺻��
		char c7 = '��';
		char c8 = '��';
		
		// ���� �迭 != ���ڿ� 
		// char Array != String
		// �� ������ ���ڵ� == ���ڵ��� ����? == ���ڹ迭����
		char[] cArr1 = { 'X', 'Y', 'Z'}; 
		// ���� 3�� , �迭���� =3, ������ȣ 0 ~ 2(length -1)
		// �ѹ� ���� ���ǵ� �迭�� ũ��
		// �� length�� ���� ���� ���� �Ұ��� �� �����.
		char a = cArr1[2]; // 'Z', // 90
		char z = cArr1[cArr1.length-1]; // ������ �ε��� last index
		
		for (int i = 0; i < cArr1.length; i++) {
			char cz = cArr1[i];
			System.out.printf("%d��° ���� �ϳ� %c [%d,0x%x]\n",i, cz, (int)cz, (int)cArr1[i]);
		}
		
		
		
	}

}
