package wrap;
// �� ���� (wrap) ��ü�� ��ȣ �ܺο��� ����� ó������ ����
// �ڹ��� �⺻�� 8������ ������������ ��� �ڽŸ��� ����Ŭ������ ����
// �⺻�� primitives ������Ƽ�� 8������ ����Ŭ������
// OOP �� ��ü���������� �⺻���� ����ϴ� ����� �ٷ� ����Ŭ������
// �ڹ� �⺻���� <=====> ���� Ŭ������
// byte <=====> Byte
// short <=====> Short
// int <=====> Integer (Int �ƴ�)
// long <=====> Long
// float <=====> Float
// double <=====> Double
// char <=====> Character (Char) �ƴ� 

public class BasicWrapper {

	public static void main(String[] args) {
		int a = 3; // �⺻�� ������ 4����Ʈ ��ġ�� a������ ����.
		// a. ?? ����
		Integer b = 3; // ����Ŭ������ ������ü ( ū ����Ʈ) �ּҰ� b������ ����.
		// b. �޼ҵ�() Ok ��ü!!!
		System.out.println("byte size ��Ʈ��=> " + Byte.SIZE);
		System.out.println("byte byte ����Ʈ�� => " + Byte.BYTES);
		System.out.println("byte min �ּ� => " + Byte.MIN_VALUE);
		System.out.println("byte max �ִ� => " + Byte.MAX_VALUE);
		
		System.out.println("short size ��Ʈ��=> " + Short.SIZE);
		System.out.println("short byte ����Ʈ�� => " + Short.BYTES);
		System.out.println("short min �ּ� => " + Short.MIN_VALUE);
		System.out.println("short max �ִ� => " + Short.MAX_VALUE);

		
		System.out.println("int size ��Ʈ��=> " + Integer.SIZE);
		System.out.println("int byte ����Ʈ�� => " + Integer.BYTES);
		System.out.println("int min �ּ� => " + Integer.MIN_VALUE);
		System.out.println("int max �ִ� => " + Integer.MAX_VALUE);

		
		System.out.println("long size ��Ʈ��=> " + Long.SIZE);
		System.out.println("long byte ����Ʈ�� => " + Long.BYTES);
		System.out.println("long min �ּ� => " + Long.MIN_VALUE);
		System.out.println("long max �ִ� => " + Long.MAX_VALUE);
		// 2^64

		System.out.println("float size ��Ʈ��=> " + Float.SIZE);
		System.out.println("float byte ����Ʈ�� => " + Float.BYTES);
		System.out.println("float min �ּ� => " + Float.MIN_VALUE);
		System.out.println("float max �ִ� => " + Float.MAX_VALUE);
		System.out.println("float ���ھƴ� => " + Float.NaN);// Not-a-Number

		System.out.println("double size ��Ʈ��=> " + Double.SIZE);
		System.out.println("double byte ����Ʈ�� => " + Double.BYTES);
		System.out.println("double min �ּ� => " + Double.MIN_VALUE);
		System.out.println("double max �ִ� => " + Double.MAX_VALUE);
		System.out.println("double ���ھƴ� => " + Double.NaN);
		
		System.out.println("char size ��Ʈ��=> " + Character.SIZE);
		System.out.println("char byte ����Ʈ�� => " + Character.BYTES);
		System.out.println("char min �ּ� => " + (int)Character.MIN_VALUE);
		System.out.println("char max �ִ� => " + (int)Character.MAX_VALUE);

		System.out.println("boolean �� ��=> " + Boolean.TRUE);
		System.out.println("boolean �� ����=> " + Boolean.FALSE);
		
		boolean b1 = true;
		boolean b2 = false;
		
		
		
		
	}

}
