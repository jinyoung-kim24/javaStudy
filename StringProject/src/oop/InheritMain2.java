package oop;

//class Dummy {}
//class Dummy extends Object {}
class Dummy {
	public void sayDummy() {
		System.out.println(this.toString());// oop.Dummy@3d4eac69
	}
	
	// �Լ������� override �������̵�
	public String toString() {
		return "��������ü! " + super.toString();
	}
}

class Dummy2 {
	private int _myHashCode;
	public Dummy2( ) {
//		this._myHashCode = (int)(Math.random() * 10) + 1; // 1 ~ 10
		// ����2�� ��ü���� �¾ �� ����?��ȣ�� �ο� �޴´�.
		this._myHashCode = (int)(Math.random() * 60) + 1; // 1 ~ 60
	}
	
	public void sayDummy() {
		System.out.println("����ǥ��: " + this.toString());
		System.out.println("���ǰ�����: " + this.hashCode());
		System.out.println("���� ��: " + this.equals(this));// true
	}

	@Override
	public int hashCode() {
		return this._myHashCode;
//		return (int)(Math.random() * 10) + 1; // 1 ~ 10
//		return super.hashCode();
	}

	// ��ü���� ���迡���� ��ü�� ������ ��� �񱳴� �����ϱ� ����.
	// ��, equals() �Լ� �����Ƿ� �Ǵܵ�. true ����, false �ٸ�.
	@Override
	public boolean equals(Object obj) {
		//return true;
//		return (int)(Math.random() * 10) % 2 == 0;
		//return super.equals(obj);
		if( obj instanceof Dummy2 ) {
			int meHC = this.hashCode();
			int youHC = ((Dummy2)obj).hashCode();
			if( meHC == youHC ) return true;
			else return false;
		} else
			return false;
	}

	@Override // �ΰ���� ������̼�
//	public String toString(int a) {
	public String toString() {
		return "������II��ü! " + super.toString();
	}
	
	
	
	// �Լ������� override �������̵�
//	public String toString() {
//		return "������II��ü! " + super.toString();
//	}
}

//public class InheritMain extends Object { // ����
public class InheritMain2 {

	public static void main(String[] args) {
		// ���: inherit (�θ�Ŭ������ �ڿ�-�ʵ�/�޼ҵ��� �����޾� ����)
		// 		Object�� �ֻ��� �ڹ� Ŭ�����ν� �Ͻ������� ����� 
		//		��� Ŭ������ ������
		//		=> Object�� �� ���� �Ϲ�ȭ, ���� ��¡ȭ�� �ֻ��� �з�.
		//		- ��ü���... �������ϴ� �ּ��� �Ϲ� ����� ���� ���� Object��.
		//		1. ��ü �ڽ��� ������ ǥ���� �� �ִ�. toString() 
		//		2. ��ü�鰣�� ��/�Ǵ��� ���� �� �� �ִ�. equals() 
		//      3. ��ü�� ������ȣ�� ���� �� �ִ�. hashCode()
		InheritMain2 in = new InheritMain2();
//		System.out.println(in); // toString()
		System.out.println(in.toString());
		System.out.println(in.hashCode());
		InheritMain2 in2 = new InheritMain2();
		System.out.println(in2.toString());
		System.out.println(in2.hashCode());
		
//		if( in == in2 ) 
//			System.out.println("�츮�� ���� ���ƿ�!!");
//		else // in != in2
//			System.out.println("�츮�� ���� �޶��..");
		System.out.println("���� ����? " + (in == in2));
		System.out.println("���� �ٸ���? " + (in != in2));
//		System.out.println("���� �ٸ���? " + ((in == in2)==false));
		if( in.equals(in2) == true )
			System.out.println("�츮�� �ѹ���!");
		else
			System.out.println("�츮�� �ٹ���!!!");
		//
//		Object obj = new Object(); // Ÿ��?
//		obj.toString();
		
		Object ob1 = in; // ��� ������
		Object ob2 = in2;
		Object ob3 = "abcd";
		Object ob4 = 3.14;
		Object ob5 = 'A'; 
		// Object Ÿ�� �������� �ڹ��� ��� �����͸� ���� �� ����.
		// � Ÿ���� �����͵��� Object���� �����.
		
//		Dummy d0 = new Dummy(); 
////		System.out.println(d0); // d0.toString()
//		d0.sayDummy();
		Dummy2 d2 = new Dummy2(); // ���� ����
		d2.sayDummy();
//		System.out.println(d2.hashCode());
//		System.out.println(d2.hashCode());
//		System.out.println(d2.hashCode());
		
		Dummy2 da = new Dummy2();
		Dummy2 db = new Dummy2();
		Dummy2 dc = new Dummy2();
		Dummy2 dd = new Dummy2();
		Dummy2[] dms = { da, db, dc, dd };
		for (int i = 0; i < dms.length; i++) {
//			Dummy2 dmm = dms[i];
//			dmm.sayDummy();
			System.out.print(i+"��° dmm => ");
			dms[i].sayDummy();
			if( d2.equals(dms[i]) == true ) 
				System.out.println("\t ������ ���̳׿�!!!");
			else 
				System.out.println(">> ���� �ٸ� ���̵�..");
			System.out.println("-------------");
		}
	}

}
