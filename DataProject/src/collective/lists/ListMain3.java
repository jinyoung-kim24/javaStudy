package collective.lists;

import java.util.ArrayList;

/*
 * 리스트 List (목록) => 배열은 리스트의 작은 한 종류
 * java.util.List 인터페이스
 * > 요소의 중복이 허용됨.
 * > 요소들의 추가된 순서(번호; 인덱스) 유지
 * > 순서번호(index) 0 ~ size()-1 범위
 *  리스트 인터페이스를 가장 잘 구현한 구현체 클래스 ArrayList
 *  
 *  ArrayList 완전한 형태의 저장소로써의 CRUD 연산기능을 구현
 *  CRUD(Create, Read,/Retrieve, Update, Delete)
 *  	add()/insert?, 	get(), 	set(), 	remove()
 */
public class ListMain3 {

	public static void main(String[] args) {
		// 제네릭 generic: 타입 파라미터 제한
//		ArrayList nameList = new ArrayList(); // 일반 리스트 
		ArrayList<String> nameList = new ArrayList<>();
		// 리스트 컬렉션의 요소타입을 모두 문자열로 제한시킴
		nameList.add("재욱");
//		nameList.add(22);
//		nameList.add("" + 22);
//		nameList.add(String.valueOf(22));
		// <=> Integer.parseInt("22")
		nameList.add("규진"); // add() 리스트의 맨뒤에 새로운 요소를 추가
		nameList.add("동현");
		nameList.add("지원"); // Create

		printNameList(nameList);

		System.out.println("** 학생이름 리스트(역방향Reberse):" + nameList.size() + "명");
		final int CNT_NAMES = nameList.size();
		for (int i = CNT_NAMES - 1; i >= 0; i--) {
			System.out.printf("\t 학생: %03d번 => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");
		
		nameList.add("만섭"); // 맨뒤(위치)에 추가
		nameList.add(2,"지훈"); // 2번 위치에 새롭게 끼워서 추가
		
		printNameList(nameList);
		
		nameList.add(0, "석준"); // 리스트의 맨 앞(위치에 추가)
		
		printNameList(nameList);
		
		nameList.add(0, "지혜"); // 리스트의 맨 앞(위치에 추가)
		nameList.add("동근");
		nameList.add(nameList.size(),"동근"); // 맨뒤(위치)에 추가
		printNameList(nameList);
		
		
		// Update
		nameList.set(8, "동근  original");
		printNameList(nameList);
//		String oldEntitle = nameList.get(8); // backup
		String oldEntitle = nameList.set(8, "동근 소설가");
			// set의 정상리턴은 해당 위치의 기존 요소가 리턴됨.
		nameList.set(8, "동근 소설가");
		printNameList(nameList);
		System.out.println("old => " + oldEntitle);
		
		
		// Delete
		nameList.add(oldEntitle);
		nameList.remove(2); 
		nameList.remove(9); // 삭제의도와 다르게 동작!!!!
		// 삭제 위치 기준으로 다음 요소들이 모두 1위치씩 앞으로 당겨짐!!
		printNameList(nameList);
		
		// Fast Enumerations
		for (String name : nameList) {
			System.out.println(">> " + name);
		}
		
	}

	public static void printNameList(ArrayList<String> nameList) {
		System.out.println("** 학생이름 리스트(순방향Forward):" + nameList.size() + "명");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.printf("\t 학생: %03d번 => %s \n", i, nameList.get(i)); // read
		}
		System.out.println("------------------------");
		
	}

}
