package book2;

public class MyLibrary4 {

	public static void main(String[] args) {

		
		MyBook book4 = new MyBook("안녕 앤 - 앤이 어렸을 적에..", "버지 월슨", "소설/고전",
				300, 20000, 2, 0,
				4.89f, "987654321222", "어린 적의 추억이 새록새록하네요!!"); // 생성과 동시 초기화
		book4.printBook();

		

		MyBook book5 = new MyBook();
		book5.init("날씨이야기", "날씨소년", "환경/기상",  // 생성 후 별도 실행
				100, 14900, 3, 1,
				1.32f, "987654321333", "날씨가 전혀 맞지 않아요");
		book5.printBook();
		
		MyBook book6 = new MyBook();
		book6.printBook();
		
		
		
	}
}