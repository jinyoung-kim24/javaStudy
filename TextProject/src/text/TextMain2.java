package text;

public class TextMain2 {

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
		} // 2��° ���� �ϳ� Z [90, 0x5A]
		
		char[] name1 = {}; // length�� 0�� �� �迭 empty array
		char[] name2 = {'��', '��', '��'};
//				0��° ���� �ϳ� �� [51076,0xc784]
//				1��° ���� �ϳ� �� [44221,0xacbd]
//				2��° ���� �ϳ� �� [51652,0xc9c4]

		char[] name3 = {51076, 44221, 51652};
		char[] name3b = {0xC784, 0xACBD, 0xC9C4};
		char[] name3c = {0b1100_0111_1000_0100,
				0xACBD, 0xC9C4}; // 8421ü��
		char[] name3d = { '\uC784', '\uACBD', '\uC9C4'};
		
 		char nameN1[] = new char[3]; 
 		// char �� ��� ������ 3�� Ȱ��, �׸��� 0���� �� ��Ұ����� ä����(�ڵ��ʱ�ȭ)
 		char nameN2[] = {'\0', '\0', '\0'};
 		nameN1[0] = '��';
 		nameN1[0] = 0b1100_0111_1000_0100; // ��
 		nameN1[1] = 44221;
 		nameN1[2] = 0xC9C4;
 		
 		nameN2[0] = '\uC784';
 		nameN2[3-2] = 0xACBD;
 		nameN2[3-1] = '��';
 		nameN2[nameN2.length-1] = nameN1[2];
 		
 		
 		
 		// ���ڿ��� String Ŭ���� Ÿ�� ��ü ������(���۷����� reference)
 		// ���۷����� ������ �����Ͱ� ��ü�� �����°� �ƴ϶�
 		// Ư�� �������� ��ġ�� ����Ű�� �ּ�address���� �����ϰ� ����.
 		// ���ڿ����� ���ڹ迭ó�� �ټ����� ���ڵ��� ǥ���ϰ� ����.
 		// ���ڿ��� String�� ������ => "���ڵ�" literal ǥ��
 		String kname1 = "������"; // ������� ���ڿ� ��ü�� ����.
 		String kname2 = new String("������"); // ���� ��ü ���� �� �ʱ�ȭ.
 		char kname[] = {'��', '��', '��'};
 		System.out.println(kname1);
 		System.out.println(kname2);
 		//System.out.println(kname);
 		for (int i = 0; i < kname.length; i++) {
			System.out.printf("�� ���� �� => %c \n", kname[i]);
		}
 		// length() �Լ��� ���ڿ��������� ��ü �� ������ �����ڵ� ���� ����
 		for (int i = 0; i < kname1.length(); i++) {
			char c = kname1.charAt(i); // ���ڿ��� ��ü���� ������� ���Ե� ���� �ϳ��� char������ �������ִ� �Լ�
			System.out.printf("�� ���� �� => %c \n", kname1.charAt(i));
		}
 		
 		String princess = "Anna ����"; // �� 7���� 0 ~ 6 ������ȣ.
 		System.out.printf("%c => %c \n",princess.charAt(0), princess.charAt(6));
 		
 		
 		System.out.printf("%c => %c \n",princess.charAt(0), princess.charAt(princess.length()-1));
 		
 		
 		
 		
 		
 		
	}

}
