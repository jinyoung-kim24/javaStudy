package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;

public class MemberMain4 {
	// ȸ�� (���� ���) Member 
	// ȸ�� ������ 	   MemberManager => MemberMgr	
	public static void main(String[] args) {
		// ȸ�� ������ (��Ű��)
		Member mb1 = new Member(
				"����", "elsa@winter.com",
				"elsa", "1234", new Date());
//		System.out.println(Member.order);
		mb1.setMileage(mb1.getMileage() + 500.0);
//		System.out.println(mb1);
		
		// ȸ�� ���� ��� (ȸ�� ��Ű�� �߰�����)
		Member[] store = {
			mb1, new Member("�ȳ�", "anna@winter.com",
					"anna", "1234", new Date())
			, null, null, null, null
		};
		
//		MemberNextChildMgr nMgr = new MemberNextChildMgr(store);
//		nMgr.processJoinMembers();
//		nMgr.printAllMembers();
//		nMgr.readySearch(); // next ���뿡�� �˻� ��������� Ȯ���..
//		
//		MemberShoppingMgr sMgr = new MemberShoppingMgr(3);
//		sMgr.processJoinMembers();
//		sMgr.marketingPromotion(); // shopping ���뿡�� �������� ����..
//		sMgr.printAllMembers();
//		sMgr.readySearch(); // ?
		
		//MemberShoppingChildMgr sMgr = new MemberShoppingChildMgr(3);
		MemberShoppingChildMgr sMgr = 
				new MemberShoppingChildMgr(store);
		sMgr.processJoinMembers();
		sMgr.marketingPromotion(); // shopping ���뿡�� �������� ����..
		sMgr.printALLMembers();
		
		Member[] result = sMgr
				.searchMembersAndReturn("el");
		System.out.println("** ���� ���ϵ� �˻����:: ");
		for (Member member : result) {
			if( member == null ) break;
			System.out.println(member);
		}
	}

}

