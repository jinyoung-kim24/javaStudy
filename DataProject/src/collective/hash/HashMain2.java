package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
	https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%85%8C%EC%9D%B4%EB%B8%94
	https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%95%A8%EC%88%98
	해시 테이블(맵), 해시 함수
	
	해시(Hash, 맵Map, 사전Dictionary)
	: 대응(mapping) 관계를 표현한 자료구조의 대표형.	
 	영어사전:  key(hat 단어이름) => value(모자란 뜻에 대응)
 	지도:     key(위도/경도) => value(지도상 한 위치)
 	이름 => 사물,  태그 => 데이터,   키 => 자물쇠
 	
 	key => value 대응관계가 해시의 기본 단위. 
 	대응관계를 자바에서는 MapEntry라고 함. (키,밸류)의 쌍으로 Pair라고함.
 	pair들의 집합을 해시맵이라고 함.
 	
 	엄밀히보면, 해시맵은 집합처럼 순서가 없음.. 그냥 pair들의 집합임. 
 	
 	반드시 Key는 '고유'해야함. (중복 x), Key들은 나중에 정렬이 가능함...
 	다만, Value는 고유하지 않아도 되며(중복 o), 심지어 null도 됨.
 	java.util.Map 인터페이스, 이를 구현한 java.util.HashMap
 	https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
*/

public class HashMain2 {

	public static void main(String[] args) {
		//Map<K, V> 인터페이스 구현
		HashMap<String, Integer> hm
			//= new HashMap<String, Integer>();
			= new HashMap<>(); // 해시맵 size 0 생성
		// 해시맵: 쌍(pair)의 요소타입을 제한 generic(타입파라미터 제한)
		//			키타입을 문자열로 제한, 밸류타입을 정수로 제한.
		
		// 학생이름 문자열 키 => 나이 정수    대응
//		hm.put("사헌", 26); // size++
//		hm.put("주현", 24); 
//		hm.put("경진", new Integer(28)); // Create
////		hm.put(""+123, 33);
////		hm.put(String.valueOf(123), 24);
//		
//		System.out.println("** 해시맵의 크기(학생수): " + hm.size());
//		System.out.println("사헌씨의 나이 :   사헌   =>  "
//						+ hm.get("사헌") + "세");  
//			// Read  고유키에 대응하는 밸류가 리턴
//		System.out.println("경진씨의 나이 :   경진   =>  "
//				+ hm.get("경진") + "세");
//		System.out.println("주현씨의 나이 :   주현   =>  "
//				+ hm.get("주현") + "세");
//		System.out.println("영주씨의 나이 :   영주  =>  "
//				+ hm.get("영주") + "세");
//		System.out.println("영주씨의 나이 :   영주  =>  "
//				+ hm.getOrDefault("영주", 19) + "세");
//				// 기본 값이 옵션으로 제공..
		
		// 이름 배열(keys) 준비
		String[] keys = null;
//		keys = new String[10];
		keys = new String[] {
			"지혜", "동근", "석준", "수현", "경진",
			"종세", "규진", "재욱", "사헌", "주현"
		};
		
		// 밸류 리스트(values) 준비
		ArrayList<Integer> values = new ArrayList<>(); 
		for (int i = 0; i < keys.length; i++) {
			Integer age = (int)(Math.random() * 100) + 1;
			values.add(age);
		}
		
		// 대응(mapping) 루프: 10개의 각 pair가 만들어지고 모두 해시맵의 요소가 됨.
		// 키배열 => 밸류리스트(키에 순서에 따라)에 순차적으로 대응 루프
		for (int i = 0; i < keys.length; i++) {
			hm.put(keys[i], values.get(i));
		}
		
		// 맵의 키들의 순서대로 키를 중심으로 루프를 탐색하면서 Pair를 출력
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i]; // 고유한 키 문자열(이름)
			Integer value = hm.get(key);
			System.out.println("키: " + key + " => 밸류: " + value + "세");
		}
		System.out.println("-------------------------");
		for (int i = keys.length-1; i >= 0; i--) {
			System.out.println("키: " + keys[i] + " => 밸류: " + hm.get(keys[i]) + "세");
		}
		
	}

}
