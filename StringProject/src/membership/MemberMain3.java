package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;
import membership.manage.MemberNextMgr;

public class MemberMain3 {
	// ȸ�� (���� ���) Member
	// ȸ�� ������ MemberManager => MemberMgr
	public static void main(String[] args) {
		// ȸ�� ������(��Ű��)
		Member mb1 = new Member("����", "elsa@winter.com", "elsa", "1234", new Date());
		mb1.setMileage(mb1.getMileage() + 500.0);
//		System.out.println(Member.order);
//		System.out.println(mb1);

		// ȸ�� ���� ��� (ȸ�� ��Ű�� �߰�����)
		Member[] store = { mb1, new Member("�ȳ�", "anna@winter.com", "anna", "1234", new Date()),
				null, null, null,null };
		MemberNextMgr nMgr = new MemberNextMgr(store);
		nMgr.processJoinMembers();
		nMgr.printALLMembers();
		
		nMgr.readySearch();
		
	
	}
		

}
