package oop;

public class InheritMain {

	public static void main(String[] args) {
		// ���: inherit (�θ�Ŭ������ �ڿ�-�ʵ�/�޼ҵ��� �����޾� ����)
		// object�� �ֻ��� �ڹ� Ŭ�����ν� �Ͻ������� �����
		// ��� Ŭ������ ������
		// => object�� �� ���� �Ϲ�ȭ ���� ����ȭ�� �ֻ��� �з�.
		// - ��ü��� �������ϴ� �ּ��� �Ϲ� ����� ���� object��
		// �ڽ��� ������ ǥ���� ���ִ� toString() 
		// ��ü�鰣�� �� /�Ǵ��� ���� �� �� �ִ� equals()
		// ��ü�� ������ȣ�� ���� �� �ִ�. hashCode()
		InheritMain in = new InheritMain();
//		System.out.println(in); // toString() ����
		System.out.println(in.toString());
		System.out.println(in.hashCode());
		InheritMain in2 = new InheritMain();
		System.out.println(in2.toString());
		System.out.println(in2.hashCode());

		System.out.println("���ΰ���?" + (in == in2));
		System.out.println("���� �ٸ���?" + (in != in2));
		
		if(in.equals(in2) == true) {
			System.out.println("�츮�� �ѹ���!");
		}else {
			System.out.println("�츮�� �ٹ���");
		}
		
//		Object obj = new Object();
//		obj.toString();
		Object ob1 = in; // ��� ������ 
		Object ob2 = in2;
		Object ob3 = "abcd";
		Object ob4 = 3.14;
		Object ob5 = 'A'; 
		// Object Ÿ�� �������� �ڹ��� ��� �����͸� ���� �� ����
		// � Ÿ���� �����͵��� object���� �����
		
		
		
//		if(in == in2) {
//			System.out.println("�츮�� ���� ���ƿ�");
//		}else {
//			System.out.println("�츮�� ���� �޶��");
//		}
		

	}

}
