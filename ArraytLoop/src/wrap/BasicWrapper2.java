package wrap;

public class BasicWrapper2 {

	public static void main(String[] args) {
		// 기본형과 랩퍼클래스형과의 관계...
		int num1 = 365 + 1;
		Integer num2 = 365 + 1;
		num2 = num1; // 자동박싱
		num1 = num2.intValue() +3; // 수동 언박싱 
		num1 = num2 - 5; // 자동언박싱
		Integer num3 = new Integer(365); // 수동 박싱
		// 4바이트 수치데이터값 객체화로 표현
		Integer num4 = 365; // new Integer(365);
		// 에러였으나 new Integer(nnn)를 생략할 수 있음
		// 오토박싱 (자동으로 박스, 즉, 랩페클래스형으로 담는다.)
		// 기본형 데이터를 자동으로 알아서 객체형 랩퍼형으로 변환함.
		// num4.toString()
		int num5 = num3.intValue(); // (수동) 언박싱 manual unboxing
		int num6 = num2; //num3;  // 자동언박싱(AutoUnboxing)
		
		float f = new Float(3.14f);
		Float f2 = 3.141592F;
		Float f3 = num3.floatValue(); // 365.0f
			// 정수객체에서 실스값으로 변경리턴되었다가 
			//바로 다시  실수 객체오토박싱
		
		char c = 'A';
		Character c2 = 'B';
		Character c3 = new Character('C');
		char c4 = new Character('C');
		char c5 = c3.charValue();
		char c6 = c2.charValue();
		char input = 'A';
		Character objectC = input; //'A';
		// 알파펫 글자니? 영문 대소문자 범위의 문자야???
		if(Character.isAlphabetic(c6) == true)
			System.out.println("영문대소문자임");
		else if(Character.isDigit(c6))
			System.out.println("숫자문자임");
		else if(Character.isWhitespace(c6))
			System.out.println("공백문자아님");
	}

}
