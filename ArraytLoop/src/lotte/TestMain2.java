package lotte;

import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {

		// args 변수는 main 시작시 프로그램 맨 처음 실행에
		// 입력되는 초기값 파라미터 ==> Arguments
		System.out.println("Arguments == Parameters 인자, 입력변수");
		System.out.println(args);
		System.out.println("args.length = " + args.length);

//		Arguments == Parameters 인자, 입력변수
//				[Ljava.lang.String;@15db9742
//				args.length = 0
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}

		// if(args.length == 4)
		if (args.length >= 4) { // 안전한 코드

			String name = args[0]; // 김진영
			int age = Integer.parseInt(args[1]); // "24" => 24; 타입변환
			// 파싱 (parse), 파싱, 파서(parser)
			String engName = args[2]; // "kimjinyoung"
			double height = Double.parseDouble(args[3]); // "170.00" = 170.00; 타입변환
			System.out.println(name + "은 나이가" + age + "세가 되었습니다.");
			System.out.println("그래서 영어이름" + engName + "으로 불리게 되었고," + "어느새 키가" + height + "cm가 자랐습니다.");

		} else { // 4개 미만의 인자
			System.out.println("ARGS 인자가 4개 이상 필요..");
		}

//		Scanner sc = new Scanner(System.in);
//		System.out.println(">> 이름 입력: ");
//		String name = sc.next(); // 프로그램 실행중에
//		System.out.println(">> 나이 입력: ");
//		int age = sc.nextInt(); // 키보드 입력을 변수에 저장
//		System.out.println("이름: " + name);
//		System.out.println("나이: " + age);

	}//main

} // class
