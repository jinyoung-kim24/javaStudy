package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;

public class MemberMain {
	// 회원 (관리 대상) Member
	// 회원 관리자 MemberManager => MemberMgr
	public static void main(String[] args) {
		// 회원 데이터(스키마)
		Member mb1 = new Member("엘사", "elsa@winter.com", "elsa", "1234", new Date());
		mb1.setMileage(mb1.getMileage() + 500.0);
//		System.out.println(Member.order);
//		System.out.println(mb1);

		// 회원 관리 운영자 (회원 스키마 중개관리)
		Member[] store = { mb1, new Member("안나", "anna@winter.com", "anna", "1234", new Date()),
				null, null, null,null };
		MemberMgr mgr = new MemberMgr(store);
		if (!mgr.isMembersEmpty())
			mgr.printALLMembers();
		else
			System.out.println("아직 등록회원이 한 명도 없네요!");

		// 회원 가입 - 1명 추가 등록
		Member newMb = mgr.joinNewMember(null);
		if(newMb != null) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t" + newMb.getName() + "님 가입을 축하합니다");
			System.out.println("\t 가입 내역::");
			System.out.println(newMb); 
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

		}
		if (!mgr.isMembersEmpty())
			mgr.printALLMembers();
		else
			System.out.println("아직 등록회원이 한 명도 없네요!");
	}

}
