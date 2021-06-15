package collective;
import java.util.HashSet;

public class DataMain2 {
	public static void main(String[] args) {
		// 문자(객체)들의 집합 -- Character 객체
		HashSet hs = new HashSet();
		hs.add('X');
		char c= 'Y';
		hs.add(c);
		
		for (Object ch : hs) {
			char p = (char)ch;
			System.out.printf(" 문자 하나 %c(%d)\n", p, (int)p);
		}
		
		String xyz = "XYZ";
		hs.add(xyz.charAt(xyz.length()-1));
		
		hs.add('a'); hs.add('b'); hs.add('c');
		hs.add('가'); hs.add('바'); hs.add('하');
		
		for (Object ch : hs) {
			char p = (char)ch;
			System.out.printf(" 문자 하나 %c(%d)\n", p, (int)p);
		}
		// 집합은 순서에 의미가 없어서 순서가 중요한 처리라면 
		// 집합 데이터를 배열 리스트로 복제하여 정렬을 처리해야함
		
		
	}
}
