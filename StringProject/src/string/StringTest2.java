package string;

public class StringTest2 {

	public static void main(String[] args) {
		// ���ڿ� �и� 
		String wiki = "The pigeon guillemot (Cepphus columba)" 
				+ " is a seabird in the auk family, Alcidae."
				+ " It is dark brown with a black iridescent"
				+ " sheen and a distinctive wing patch "
				+ "broken by a brown-black wedge in breeding "
				+ "plumage.";
		
		String keyword = "wing";
		int beginIndex = wiki.indexOf(keyword);
		int endIndex = beginIndex + keyword.length();
		System.out.println("beginIndex = " + beginIndex);
		System.out.println("endIndex = " + endIndex);
		for (int i = beginIndex; i < endIndex; i++) {
			System.out.printf("%c ", wiki.charAt(i));
		}
		System.out.println();
		System.out.println("subString = " + wiki.substring(beginIndex, endIndex));
		// �� ���ڿ��� �Ϻθ� �߶� ���ο� ���ڿ��� �κй��ڿ��� ����� ����
		// beginIndex �����Ͽ� endIndex �����Ա����� �κ� ���ڿ�..
		
		String data = "0123456789" + "ABCDEF";
		String numbers = data.substring(0, 10);
		System.out.println(numbers);
//		String alphas = data.substring(10, 16);
		String alphas = data.substring(10);
		// 10 �ε���(���ѹ��� ����)���� �� �ڿ����� ��� ���ڵ�...
		System.out.println("alphas = " + alphas);
		
		String pname = "elsa3";
		String pname2 = "elsa11";
		String name = pname.substring(0, 4);
		String number = pname.substring(4);
		System.out.println("���� �̸�: " + name);
		System.out.println("���� ��ȣ: " + number);
		
		String name2 = pname2.substring(0, 4);
		String number2 = pname2.substring(4);
		System.out.println("���� �̸�2: " + name2);
		System.out.println("���� ��ȣ2: " + number2);
	}

}
