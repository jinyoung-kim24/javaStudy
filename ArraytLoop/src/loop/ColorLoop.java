package loop;

public class ColorLoop {

	public static void main(String[] args) {
		// 배열 Array
		// 동일한 타입의 데이터를 다수개 여러개의 변수들이 필요함.
		// 동일한 타입의 다수 데이터들을 단 하나의 배열변수로 묶어서 표현함.
		// 배열은 단 하나의 대표 이름을 변수(Array 타입)명으로 설정
		// 배열은 그 요소(element)들의 타입으로 선언함. 
		// 배열은 요소를 넣을 수 있는 "메모리 공간"임.
		//String[] colors; // 문자열 여러개를 묶은 배열변수 colors 선언.
		//String []colors;
		//String colors[]; // 대표이름 colors인 배열을 선언.
		//String[] colors = {}; // 배열 초기화 -- empty array 빈 배열
		// 배열 변수 선언 및 초기화
		String[] colors = {
			"black", "white", "red", "green", 	// 0, 1, 2, 3
			"blue", "yellow", "purple", "cyan",// 4, 5, 6, 7
			"navy", "orange", "brown", "pink",// 8, 9, 10, 11
			"gold" 							 // 12
		};
		// 배열의 데이터(요소)가 총 13개인 배열을 정의.
		// 배열은 데이터, 즉 각 요소에 대한 접근을 반드시 순서번호(index)로 해야함.
		// 자바의 배열 인덱스, 즉 순서번호는 0부터 시작하여 마지막 인덱스 N-1.
		// 즉, 마지막 순서번호는 배열의 총요소개수 - 1임.
		// 배열의 크기 (길이) = 요소의 총 개수 = 배열명.length
		// 배열은 한번 정의되면 그 요소개수가 절대 변할 수 없다.
		System.out.println("colors.length = " + colors.length);
		System.out.println("첫번쨰 color[0] = " + colors[0]);
		System.out.println("마지막 color[12] = " + colors[colors.length-1]);
		int cr = 0; // 배열의 각 요소를 탐색(개별접근)할 순서번호
		while(cr < colors.length) { // cr 0 ~ 12접근
			String color = colors[cr++]; // black
			System.out.println("컬러 이름: " + color);
			//cr++;
		}
		
		// 배열 요소값 변경 	요소공간은 배열명[i]가 개별변수처럼 동작....
		colors[3] = "mint"; // 저장, 활당 "grean" -> "mint"
		colors[4] = "lime"; // blue -> lime
		colors[5] = colors[3];	
			for (int i = 0; i < colors.length; i++) {
			String color = colors[i]; 
			System.out.printf("%d번 컬러 이름: %s\r\n", i, color);
		}
		
		
		
	}

}
