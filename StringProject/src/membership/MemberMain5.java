package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextChildMgr;
import membership.manage.MemberNextMgr;
import membership.manage.MemberShoppingChildMgr;
import membership.manage.MemberShoppingMgr;
import membership.manage.MemberTotalMgr;

public class MemberMain5 {
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
		
//		MemberTotalMgr ttMgr = new MemberTotalMgr();
		// �߻� Ŭ������ new�� ���� 
//		ttMgr.marketingPromotion(); // 3��
//		ttMgr.readySearch(); // 4���� �������̽� �޼ҵ� ������
//		ttMgr.processJoinMembers(); // 2��S
//		if(ttMgr.loginProcess("hong", "123")) {
		
			System.out.println("hong �α��� ���� ����");
//		}
//		else {
			System.out.println("hong �α��� ���� ����");
//		}
	}
}
