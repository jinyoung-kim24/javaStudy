package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMainUTF {

	public static void main(String[] args) {
		// �ѱ� ���� ����Ʈ?
		ArrayList<Character> cList1
						= new ArrayList<>();
		for(char c = '��'; c <= '�R'; c++ ) {
//			cList1.add( new Character(c));
			cList1.add(c);
		}
//		for (int i = 0; i < cList1.size(); i++) {
//			System.out.print(cList1.get(i) +" ");
//			if( (i + 1) % 10 == 0)
//				System.out.println();
//		}
		
		// ��������: ���� ��Ұ� ����Ʈ�� ���
		// ����Ʈ�� ��Ұ� ���� ���..?
		
		// ���ڿ�Ű  => ���ڹ�� ���� ǥ�� 
		// ����Ʈ�� ��ҷν� �� ���� ������� ����.
		
		// ���� ���ڸ�(?) ����Ʈ
		// ���� ���ڸ� ��ü ����� Ű�� String���� ����̸�
		//		https://www.compart.com/en/unicode/U+0041
		// 		���� �빮�� UPPER ���,  
		//  	https://www.compart.com/en/unicode/U+0061
		//		���� �ҹ��� LOWER ���...
		//		https://www.compart.com/en/unicode/U+24B6
		// 		���� ��Ŭ���� CIRCLE ���...
		//		https://www.compart.com/en/unicode/U+212B
		//		??
		//		https://www.compart.com/en/unicode/U+1F130
		//		���� ������� SQUARE ���...
		
		ArrayList<HashMap<String,Character>>
			cList2 = new ArrayList<>();
		
		// ���� �빮�� Ž�� ���� A ~ Z
//		for (char c = 0; c <= 25; c++) {
		for (char c = 'A'; c <= 'Z'; c++) {
			HashMap<String,Character>
			 eng = new HashMap<String,Character>();
			eng.put("UPPER", c); // 'A'
			eng.put("LOWER", (char)(c+' ')); // 'a' = 'A' + 32
			//
			eng.put("CIRCLE", (char)(0x24B6+c-'A'));
			eng.put("ETC", (char)(0x212B+c-'A'));
			cList2.add(eng);
		}
		
		// ��庰 ���
		final String modeKey = "UPPER";
		for (int i = 0; i < cList2.size(); i++) {
			HashMap<String, Character> c
							= cList2.get(i);
			System.out.print(c.get(modeKey));
		}
		System.out.println();
		final String modeKey2 = "LOWER";
		for (int i = 0; i < cList2.size(); i++) {
			HashMap<String, Character> c
							= cList2.get(i);
			System.out.print(c.get(modeKey2));
		}
		System.out.println();
		final String modeKey3 = "CIRCLE";
		for (int i = 0; i < cList2.size(); i++) {
			HashMap<String, Character> c
							= cList2.get(i);
			System.out.print(c.get(modeKey3));
		}
		System.out.println();
		final String modeKey4 = "ETC";
		for (int i = 0; i < cList2.size(); i++) {
			HashMap<String, Character> c
							= cList2.get(i);
			System.out.print(c.get(modeKey4));
		}
		System.out.println();
		
	}

}