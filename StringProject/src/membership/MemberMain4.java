package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;

public class MemberMain4 {
	// 회원 (관리 대상) Member 
	// 회원 관리자 	   MemberManager => MemberMgr	
	public static void main(String[] args) {
		// 회원 데이터 (스키마)
		Member mb1 = new Member(
				"엘사", "elsa@winter.com",
				"elsa", "1234", new Date());
//		System.out.println(Member.order);
		mb1.setMileage(mb1.getMileage() + 500.0);
//		System.out.println(mb1);
		
		// 회원 관리 운영자 (회원 스키마 중개관리)
		Member[] store = {
			mb1, new Member("안나", "anna@winter.com",
					"anna", "1234", new Date())
			, null, null, null, null
		};
		
//		MemberNextChildMgr nMgr = new MemberNextChildMgr(store);
//		nMgr.processJoinMembers();
//		nMgr.printAllMembers();
//		nMgr.readySearch(); // next 계통에는 검색 고유기능이 확장됨..
//		
//		MemberShoppingMgr sMgr = new MemberShoppingMgr(3);
//		sMgr.processJoinMembers();
//		sMgr.marketingPromotion(); // shopping 계통에는 마케팅을 고유..
//		sMgr.printAllMembers();
//		sMgr.readySearch(); // ?
		
		//MemberShoppingChildMgr sMgr = new MemberShoppingChildMgr(3);
		MemberShoppingChildMgr sMgr = 
				new MemberShoppingChildMgr(store);
		sMgr.processJoinMembers();
		sMgr.marketingPromotion(); // shopping 계통에는 마케팅을 고유..
		sMgr.printALLMembers();
		
		Member[] result = sMgr
				.searchMembersAndReturn("el");
		System.out.println("** 쇼핑 차일드 검색결과:: ");
		for (Member member : result) {
			if( member == null ) break;
			System.out.println(member);
		}
	}

}

