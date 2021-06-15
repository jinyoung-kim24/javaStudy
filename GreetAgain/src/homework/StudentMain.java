package homework;
/*
/*
실행 시 출력 예...

=== 학생 정보 출력 ===
* 학생번호 1 
	이름: 홍길동
	나이: 18 세
	전공: Java
--------------------
* 학생번호 2
...
--------------------
* 학생번호 3
...
====================
*/ 

//실습 
// printStudent() 함수 구현 
// 3명의 학생 데이터를 임의로 설정해서 실행

public class StudentMain {

	public static void main(String[] args) {
		String stName1 = "홍길동";
		int stAge1 = 18;
		String stMajor1 = "Java";
		//
		printStudent(1, stName1, stAge1, stMajor1); // 함수 호출
		// 번호, 이름, 나이, 전공... 4개의 인자들 필요.
	}

	// 함수 정의
	private static void printStudent(
			int i, String stName, 
			int stAge, String stMajor) {
		// ?
	}
}
