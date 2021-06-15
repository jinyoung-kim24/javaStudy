package membership.manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import membership.data.Member;

// 회원들을 관리하기 위한 중개 클래스

// Member 스키마(데이터)를 CRUD 조작하는 클래스
// 회원생성, 회원 갱신, 회원 삭제, 회원 조회
public class MemberMgr {
	public static final int MAX_MEMBERS = 5;
	// 관리되는 회원들 (저장소, 메모리, 파일, DB, 클라우드)

//	1. 다 수의 회원들을 저장할 공간을 준비 (유즈케이스 다이어그램)
	protected Member[] _members;

	public MemberMgr() {
		this._members = new Member[MAX_MEMBERS];

	}

	public MemberMgr(int size) {
//		super();
		if (size <= 0)
			size = MAX_MEMBERS;
		this._members = new Member[size];
	}

	public MemberMgr(Member[] store) {
		super();
		if (store != null && store.length > 0)
			this._members = store;
		else
			this._members = new Member[MAX_MEMBERS];
	}

	// 2. 다 수의 회원들을 한명씩 등록할 수 있다. (가입)

	// 스캔너로 정보를 입력받아 임의의 회원(vo 객체)를 생성하고,
	// 배열에 등록하고, 그 회원 객체도 리턴하는 함수
	public Member joinNewMember(Scanner sc) {
		if (this.isMembersFull()) {
			System.out.println("더 이상 추가 회원 불가능!!");
			return null;
		}
		if (sc == null)
			sc = new Scanner(System.in);

		Member mb = null;
		// 스캐너로 회원객체 생성을 위해 재료 정보들을 입력
		int no = ++Member.order;
		String name = inputString(sc, ">> 회원 이름:");
		int age = inputInteger(sc, "회원나이:");
		String email = inputString(sc, ">> 이메일 주소:");
		double mileage = Member.DEF_MILE;
		String id = inputString(sc, ">> 회원 아이디:");
		String password = inputString(sc, ">> 회원 암호:");
		// 날자 문자열을 입력 => 날자형 객체 변환
		String birthStr = inputString(sc, ">> 회원 생년월일 [예:2020-03-14]:");
		Date birthDay = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
//			sdf.format(date)
			birthDay = sdf.parse(birthStr);
		} catch (ParseException e) {
			System.out.println("잘못된 포맷 생년월일 입력!!");
			birthDay = new Date();
		}
		Date joinDay = new Date();
		// 동적으로 new 회원객체 생성
		mb = new Member(no, name, age, email, Member.DEF_MILE, id, password, birthDay, joinDay);

		// 배열공간에 그 회차 회원 객체 저장
		int inputNo = checkNumberofMembers();
		_members[inputNo] = mb; // 배열의 앞 공간부터 채워져 등록
		return mb;
	}

	public int inputInteger(Scanner sc, String msg) {
		System.out.println(msg);
		String input = sc.next();
		return Integer.parseInt(input);
	}

	public String inputString(Scanner sc, String msg) {
		System.out.println(msg);
		return sc.next();
	}

	// 다 수의 회원을 스캐너로 연속적으로 등록하는 함수( yes/no 추가? 정지?)
	public void processJoinMembers() {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		do {
		Member newMb = joinNewMember(null);
		if(newMb != null) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t" + newMb.getName() + "님 가입을 축하합니다");
			System.out.println("\t 가입 내역::");
			System.out.println(newMb); 
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			count++;

			}
			if(!isMembersFull()) {
				String conti = inputString(sc, ">> 추가 회원 가입? (yes/no)");
				if(conti.equalsIgnoreCase("no") || conti.equals("n") || conti.equals("아니오")) {
					break;
				}
			}else {
				System.out.println("더 이상 등록 불가");
			}
		}while(true);
		System.out.println("\t 신규회원" + count + "명이 추가됨.....");
				
	}

	// 3. 등록된 회원들의 총 리스트를 출력할 수 있다.
	public void printALLMembers() {
		System.out.println("=== 회원 리스트 === (" + checkNumberofMembers() + "/" + _members.length + "명)");
		System.out.println("번호, 이름, 나이, 이메일, 마일리지, 계정명, 암호, 생일, 가입일");
		System.out.println("------------------------------------------------------");
		for (Member mb : _members) {
			System.out.println(mb == null ? "Member 없음" : mb.toString());
		}
		System.out.println("------------------------------------------------------");

	}

	// 4. 등록된 전체 회원들의 총 명수를 확인할 수 있다.
	public int checkNumberofMembers() {
		// 등록된 회원 명수 == 저장공간 배열에서 null아닌 개수.
		int count = 0;
		for (int i = 0; i < _members.length; i++) {
			Member mb = _members[i];
			if (mb != null) {
				count++;
			}
		}
		return count;
	}

	// 5. 저장소가 꽉차였는지? 비워졌는지 확인 할 수 있다
	public boolean isMembersFull() {
//		if(checkNumberofMembers() == _members.length) return true;
//		else return false;
		return checkNumberofMembers() == _members.length;
	}

	public boolean isMembersEmpty() {
		return checkNumberofMembers() == 0;
	}
	// 6. 등록된 회원들을 특정 조건/키워드로 검색할 수 있다.

	// 7. 로그인 인증 처리 할 수 있다.

	// 8. 패스워드 암호화 할 수 있다.

}
