package collective.lists;
// Data Structure 자료 구조 ( + 알고리즘)
// java 다 수의 데이터들을 효율적으로 표현하는 구조..
// 집합적인 collective data 데이터형..
// => 복합적인 구성, 가변적인 요소의 개수, 범위(경계), 계층,
// 	  관계, 순서/정렬, 내포, 중복, (시간?) 
// 배열?
// 자바의 3대 기본 컬렉션형
//  집합 Set, 리스트 List, 해시(Hash 맵/사전)
// JCF(자바 컬렉션 프레임워크) => 자바 집합적인 데이터들을 
// 표현 및 처리할 수 있는 인터페이스, 클래스들을 묶어놓은 도구. 
// JFC의 컬렉션 자료형의 모든 요소들은 오직 레퍼런스 형 '객체'만 가능함.
//					기본형 123 x    new Integer(123) o

import java.util.ArrayList;
import java.util.List;

public class ListMain1b {

	public static void main(String[] args) {
		// List 인터페이스 (규약)
		// ArrayList 클래스 ( List 인터페이스를 모두 구현한 리스트 클래스)
		// 일반 리스트 == '가변길이 배열'
		ArrayList list = new ArrayList();
		
		// 리스트의 맨 뒤에 위치에 아이템을 순서번호를 부여하여 순차적 추가
		list.add(100);
		list.add(new Integer(100));		
		list.add(1234567890L);
		list.add(new Long(1234567890L));
		list.add(3.141592f);
		list.add(new Float(3.141592f));
		list.add('라');
		list.add(new Character('라'));
		list.add(3 == 2); // false 생성
		list.add(new Boolean(3 == 2));
		// 요소 추가의 순서가 리스트 안에서 유지!!
		
		System.out.println("리스트의 크기: " + list.size());
		for (Object item : list) {
			System.out.println("- " + item);
		} // list 순서가 유지되며 출력.
		System.out.println("--------------------");
		// 배열과 동일하게 리스트는 순서번호 0 size() -1 사용함
		// 클래식 for문으로 인덱스기반 루프 탐색이 가능함.
		list.add("목록이다!!");
		list.add("목록이다!!");
		System.out.println("리스트의 크기: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ": " + list.get(i)); // 조회

		}
		
		
		
	}

}
