package wrap;
// 랩 개념 (wrap) 본체를 보호 외부와의 입출력 처리등을 대행
// 자바의 기본형 8가지의 데이터형들을 모두 자신만의 랩퍼클래스를 가짐
// 기본형 primitives 프리미티브 8가지의 랩퍼클래스들
// OOP 즉 객체지향적으로 기본형을 사용하는 방법이 바로 랩퍼클래스임
// 자바 기본형과 <=====> 랩퍼 클래스형
// byte <=====> Byte
// short <=====> Short
// int <=====> Integer (Int 아님)
// long <=====> Long
// float <=====> Float
// double <=====> Double
// char <=====> Character (Char) 아님 

public class BasicWrapper {

	public static void main(String[] args) {
		int a = 3; // 기본형 정수값 4바이트 수치가 a변수에 저장.
		// a. ?? 에러
		Integer b = 3; // 랩퍼클래스형 정수객체 ( 큰 바이트) 주소가 b변수에 저장.
		// b. 메소드() Ok 객체!!!
		System.out.println("byte size 비트수=> " + Byte.SIZE);
		System.out.println("byte byte 바이트수 => " + Byte.BYTES);
		System.out.println("byte min 최소 => " + Byte.MIN_VALUE);
		System.out.println("byte max 최대 => " + Byte.MAX_VALUE);
		
		System.out.println("short size 비트수=> " + Short.SIZE);
		System.out.println("short byte 바이트수 => " + Short.BYTES);
		System.out.println("short min 최소 => " + Short.MIN_VALUE);
		System.out.println("short max 최대 => " + Short.MAX_VALUE);

		
		System.out.println("int size 비트수=> " + Integer.SIZE);
		System.out.println("int byte 바이트수 => " + Integer.BYTES);
		System.out.println("int min 최소 => " + Integer.MIN_VALUE);
		System.out.println("int max 최대 => " + Integer.MAX_VALUE);

		
		System.out.println("long size 비트수=> " + Long.SIZE);
		System.out.println("long byte 바이트수 => " + Long.BYTES);
		System.out.println("long min 최소 => " + Long.MIN_VALUE);
		System.out.println("long max 최대 => " + Long.MAX_VALUE);
		// 2^64

		System.out.println("float size 비트수=> " + Float.SIZE);
		System.out.println("float byte 바이트수 => " + Float.BYTES);
		System.out.println("float min 최소 => " + Float.MIN_VALUE);
		System.out.println("float max 최대 => " + Float.MAX_VALUE);
		System.out.println("float 숫자아님 => " + Float.NaN);// Not-a-Number

		System.out.println("double size 비트수=> " + Double.SIZE);
		System.out.println("double byte 바이트수 => " + Double.BYTES);
		System.out.println("double min 최소 => " + Double.MIN_VALUE);
		System.out.println("double max 최대 => " + Double.MAX_VALUE);
		System.out.println("double 숫자아님 => " + Double.NaN);
		
		System.out.println("char size 비트수=> " + Character.SIZE);
		System.out.println("char byte 바이트수 => " + Character.BYTES);
		System.out.println("char min 최소 => " + (int)Character.MIN_VALUE);
		System.out.println("char max 최대 => " + (int)Character.MAX_VALUE);

		System.out.println("boolean 논리 참=> " + Boolean.TRUE);
		System.out.println("boolean 논리 거짓=> " + Boolean.FALSE);
		
		boolean b1 = true;
		boolean b2 = false;
		
		
		
		
	}

}
