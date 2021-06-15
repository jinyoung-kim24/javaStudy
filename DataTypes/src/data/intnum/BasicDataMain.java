package data.intnum;

public class BasicDataMain {
	public static void main(String[] args) {
		// 데이터 타입 data type == 자료형(테이터 종류)
		// 자바 기본형 (프리미티브 =primitives)
		// 정수 계열은 8가지 기본형이 존재함.
		// 자바는 매우 강력한 정적 데이터 타입 언어 
		// 정수 계열 기본형 (수지형)
		// ..-3, -2, -1, 0, +1, +2, +3
		// 정수 계열의 크기 (수를 표현하는 경우의수 == 범위)
		// byte 바이트 단위로 표현.
		// 1 바이트 ~ 8 바이트
		// 1 바이트  = 8비트 1byte = 8bits
		byte value1; // 변수 선언 == 메모리 예약, 저장공간 확보
		       // 1바이트, 즉 8비트의 공간이 확보됨. 정수가 저장될 메모리 확보.
		       // 총 256가지의 경우의 수 표현함. (0 ~ 255까지 범위)
		       // byte 자료형 범위 2^8 == 256가지
		       // -128 ~ + 127
			   // -2^7 ~0 ~ (+2^7-1)
		       // +- 부호가 있는 정수를 표현
			   // 이진법 00000000 ~ 11111111
			   // 4비트 단위 니블 (nibble); 2nibbles = 1 byte
		value1 = 100; // -10; // 0;
		value1 = 127;
		value1 = 127; // error
		value1 = -127;
		value1 = -128;
		
		byte value2 = (byte)128; // 타입강제 변환 (캐스팅) 넣을수는 있지만 정상적이지 않음
		// short 2바이트, 16비트의 정수 공간
		// 2^16 가지수 표현, 65536의 경우의 수 표현.
		short value3 = 0;
		value3 = 32767;
		value3 = 32767;  // error 
		value3 = 32767;  // error 
		value3 = 32767;  // error 
		value3 = -32768; // ok
		value3 = -32768; // error 
		
		// 4bytes 정수 수치형 데이터 int형 타입
		// integer 타입; 32 bits 공간
		// 총 경우의 수 2^32 가지 표현
		// -2^31 ~ 0 ~ +(2^31-1) 약 21억정도?
		int value4 = 32767 + 1;
		 value4 = value3 - 1;
		 value4 = 2100000000; //21억
		// value4 = 2200000000; //22억? 에러 리터럴 에러
		        // 2200000000 수치형 표현은 자바에서 허용 안됨,
		 //value4 = 2200000000L; //22억을 표현하는 8바이트 정수표현 long형.
		 // 자바의 일반 수치값 데이터는 모두 기본 int형으로 표현되고,
		 // 모든 정수 연산의 처리도 int형을 기본으로 함.
		 long value5 = 2200000000L; // 8바이트 2^64가지 경우의 수
		 
		 int a = 0; // 4바이트 정수0 수치데이터
		 long b = 0; //0L; // 8바이트 정수 0 수치데이터
		 // L은 long형 정수값을 표현하는 literal 리터럴 기호임.
		 
		 // byte < short < int(integer) < long
		 
		 // 정수 연산 operation
		 byte num1; // 변수 선언
		 num1 = 127;// 데이터 활당
		 byte num2 = -127; // 초기화
		 //byte c = num1 + num2; // 엉뚱한 결과?
		 short num3 = (short)(num1 + num2);
		 int num4 = num1 + num2; // 연산결과가 정수라서 정수변수에 저장됨
		 
		 // 정수의 표현 (radix) => base 기준의 수체계
		 int decimal = 10; // 10 진법 0 ~ 9
		 int hex = 0xA; // hexadecimal 16 진법 0 ~ 9, A ,B ,C, D, E, F
		 // 0x 리터럴 기호로 16진법 정수를 표현.
		 int hex1 = 0x0000000A; // 4바이트로 표현하는 16진법
		 // 16 진법의 자리수 하나는 4비트를 표현. 1바이트는 16진법에서 2자리수. 
		 
		 // 0xFFFF =F*16^3 + F*16^2 F*16^1 + F*16^0
		 // = 65535
		 // 0xFF = F*16^1 + F*16^0
		 //   = 15 * 16 + 15 * 1 = 240 + 15 = 255
		 int binary =
				 0b1010; // 1*2^3 + 0*2^2 + 1*2^1 + 0*2^0
	                      //	8 + 2 = 10
				 // 0b 리터럴 기호로 2진법 정수 표현함.
		 int binary2 = 0b00000000000000000000000000001010;
		 int binary3 = 0b00000000_00000000_00000000_00001010;
		 
		 int octal = 012; // 8진법 
		   // 0 ~ 7까지만 존재함
		   // 1 * 8^1 _ 2 * 8^0 = 8 + 2 = 10
		 System.out.println("decimal ="+ decimal);
		 System.out.println("hex =" + hex);
		 System.out.println("binary =" + binary);
		 System.out.println("octal =" + octal);
		 
		    
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
	}
	
 }
