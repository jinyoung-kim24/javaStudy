package membership;

import java.util.Date;
import java.util.Scanner;

import membership.data.Member;
import membership.manage.FinalMemberMgr;
import membership.manage.MemberLogin;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;
import membership.manage.MemberTotalMgr;

public class MemberMain6 {
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
		
		FinalMemberMgr ttMgr = new FinalMemberMgr(store);
		// 추상 클래스는 new를 통해 
		ttMgr.processJoinMembers(); // 2대
		ttMgr.printALLMembers();
		ttMgr.marketingPromotion(); // 3대
		ttMgr.readySearch(); // 4대의 인터페이스 메소드 재정의
		int loginResult = ttMgr.readyLogin(new Scanner(System.in));
		
		switch (loginResult) {
		case MemberLogin.LOGIN_SUCCESS:
			System.out.println("로그인 성공");
			System.out.println(">> 마이페이지로 이동!!");
			break;
		case MemberLogin.LOGIN_ERR_ID_NULL:
		case MemberLogin.LOGIN_ERR_PW_NULL:
		case MemberLogin.LOGIN_ERR_ID_EMPTY:
		case MemberLogin.LOGIN_ERR_PW_EMPTY:
			System.out.println(">> 로그인 에러! 계정명이나 패스워드가 없음");
			break;
		case MemberLogin.LOGIN_ERR_ID_NOT_FOUND:
			System.out.println(">> 로그인 에러! 가입안된 회원");
			break;	
		case MemberLogin.LOGIN_ERR_PW_MISMATCH:
			System.out.println(">> 로그인 에러 암호 불일치");
			break;
		default:
			System.out.println("로그인 결과가 처리 불가능!");
			break;
		}
	}
}
