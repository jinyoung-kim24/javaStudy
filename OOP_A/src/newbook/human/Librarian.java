package newbook.human;
/*
도서관 관리 프로그램 storyboard 상....
등장인물 스키마 actor를 추가
도서관리자 => 사서 Librarian (스키마)
 데이터 /필드
 사람으로써의 속성들: 이름, 나이, 성별, 주소, 주민번호
 관리자로써의 속성들: 직원번호, 입사날짜, 직급, 직무
 
 메소드/함수
 기능들: 책을 입고 시킨다(도서에 사서 코맨트 추가하기 포함).
 		책열람관리, 책 검색 관리, 책 대여관리....
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Librarian {
	// 데이터 /상수필드
	public static final String NO_NAME = "이름없음";
	public static final int DEF_AGE = 18;
	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_MALE = 2;
	public static final String NO_ADDR = "주소미정";
	public static final String PREFIX = "LIB_HUMAN"; // 사원증의 직원 번호 LIB_HUMAN_0078
	public static final String[] LIB_POS = {"견습", "주임", "대리", "과장", "차장", "부장", "수석"}; // 직책명 배열 상수
	public static final int LIB_POS_견습 = 0;
	public static final int LIB_POS_주임 = 1;
	public static final int LIB_POS_대리 = 2;
	public static final int LIB_POS_과장 = 3;
	public static final int LIB_POS_차장 = 4;
	public static final int LIB_POS_부장 = 5;
	public static final int LIB_POS_수석 = 6;
	public static final String DEF_JOB = "책 입고 관리"; // 기본직무
	
	
//	데이터 /필드
//	 사람으로써의 속성들: 이름, 나이, 성별, 주소, 주민번호 => 비식별 조치 필수
	public String name; // 이름
	public int age; // 나이
	public int gender; // 성별 1 여성 female, 2 남성 male
	public String address; // 주소
	
//	 관리자로써의 속성들: 직원번호, 입사날짜, 직급, 직무
	public int libNum; // 직원번호
	public Date joinDay; // 입사 날짜
	public String pos; // 직급
	public String major; // 직무
	
	// 생성자 함수
	// 기본 생성자는 생략이 가능
	public Librarian() { // 각 변수필드를 각각의 데이터형의 기본값으로 초기화
		this.name = NO_NAME;
		this.age = DEF_AGE;
		this.gender = GENDER_FEMALE;
		this.address = NO_ADDR;
		this.libNum = 0;
		this.joinDay = new Date(); // 날짜 객체 생성(JVM이 속한 OS의 지역날짜 시간을 가져옴 - 타임존, 로케일)
		this.pos = LIB_POS[LIB_POS_견습];
		this.major = DEF_JOB;
	}
	
	// 중간 생성자
	// 이름, 나이, 성별	
	public Librarian(String name, int age, int gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	// 풀생성자 모든 필드 설정으로 객체초기화
	public Librarian(String name, int age, int gender, String address, int libNum, Date joinDay, String pos,
			String major) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.libNum = libNum;
		this.joinDay = joinDay;
		this.pos = pos;
		this.major = major;
	}	


//	 메소드/함수
//	 기능들: 책을 입고 시킨다(도서에 사서 코맨트 추가하기 포함).
//	 		책열람관리, 책 검색 관리, 책 대여관리....
	// 사서 자신의 정보 출력 기능
	public void printLibrarian() {
		System.out.println("** 사서:: " + PREFIX + this.libNum);
		System.out.println("\t * 이름: " + this.name);
		System.out.println("\t * 나이: " + this.age + "세");
		System.out.println("\t * 성별: " + this.gender);
		System.out.println("\t * 주소: " + this.address);
		System.out.println("\t * 입사일: " + this.joinDay);
		System.out.println("\t * 직급: " + this.pos);
		System.out.println("\t * 담당직무: " + this.major);
		System.out.println("---------------------------------");
	}
	
	public void printLibrarian(boolean detail) {
		System.out.println("** 사서:: " + PREFIX + this.libNum);
		System.out.println("\t * 이름: " + this.name);
		System.out.println("\t * 나이: " + this.age + "세");
		System.out.println("\t * 성별: [" + 
		(this.gender == GENDER_FEMALE? "여성" : "남성") + "]");
		// "여성" : "남성" 1 : 2
		System.out.println("\t * 주소: " + this.address);
		// 날짜시간 객체를 사용자저으이(custom) 서식으로 출력하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
//		System.out.println("\t * 입사일: " + this.joinDay);
		String wantDate = this.joinDay == null ? "날자모름" : sdf.format(this.joinDay);
		System.out.println("\t * 입사일: " + wantDate);
		System.out.println("\t * 직급: " + this.pos);
		System.out.println("\t * 담당직무: " + this.major);
		System.out.println("---------------------------------");
	}
	
//	public void printLibrarian(boolean detail) {
//		System.out.println("** 사서:: " + PREFIX + this.libNum);
//		System.out.println("\t * 이름: " + this.name);
//		System.out.println("\t * 나이: " + this.age + "세");
//		System.out.println("\t * 성별: [" + 
//		(this.gender == GENDER_FEMALE? "여성" : "남성") + "]");
//		// "여성" : "남성" 1 : 2
//		System.out.println("\t * 주소: " + this.address);
//		System.out.println("\t * 입사일: " + this.joinDay);
//		System.out.println("\t * 직급: " + this.pos);
//		System.out.println("\t * 담당직무: " + this.major);
//		System.out.println("---------------------------------");
//	}
}
