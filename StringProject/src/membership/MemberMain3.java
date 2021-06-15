package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextMgr;

public class MemberMain3 {
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
		MemberNextMgr nMgr = new MemberNextMgr(store);
		nMgr.processJoinMembers();
		nMgr.printALLMembers();
		
		nMgr.readySearch();
		
	
	}
		

}
