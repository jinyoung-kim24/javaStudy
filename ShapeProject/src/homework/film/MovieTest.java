package homework.film;
import java.util.Scanner;
import homework.film.MyMoive;


public class MovieTest {

	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println(">> 영화 내용을 입력해주세요!");
//		System.out.print("* 영화 이름: ");
//		String name = sc.next();
//		System.out.print("* 영화 장르:");
//		String genr = sc.next();
//		System.out.print("* 영화 개봉년도:");
//		int year = sc.nextInt();
//		System.out.print("* 영화 관객수:");
//		int person = sc.nextInt();
//		System.out.print("* 영화 평점:");
//		float rate = sc.nextFloat();
//		System.out.print("* 영화 객체를 생성합니다.");
//		MyMoive mv = new MyMoive(name, genr, year, person, rate, MyMoive.DEF_COMMENT);
		
//		mv.printMyMoive();
		
		MyTheater mt = new MyTheater("미래CGV", "(성동구 11번지...)", 7);
		mt.mtmoive[0] = new MyMoive("홍길동", "액션", 20, 3.0f);
		mt.mtmoive[1] = new MyMoive("'터미네이터'", "판타지/액션", 34, 4.2f);
		mt.mtmoive[2] = new MyMoive("'노바디'", " 액션", 14, 5.1f);
		mt.mtmoive[3] = new MyMoive("'겟아웃'", "공포/호러", 42, 6.8f);
		mt.mtmoive[4] = new MyMoive("'극한직업'", "코미디/액션", 27, 8.86f);
		mt.mtmoive[5] = new MyMoive("'괴물'", "판타지/공포", 35, 9.55f);
		mt.mtmoive[6] = new MyMoive("'멜로가체질'", "로맨스/멜로", MyTheater.DEF_AGE, 1.33f);
		mt.addMoiveToTheater();
		
		
		
		
	}

}
