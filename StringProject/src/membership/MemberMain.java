package membership;

import java.util.Date;

import membership.data.Member;
import membership.manage.MemberMgr;

public class MemberMain {
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
		MemberMgr mgr = new MemberMgr(store);
		if (!mgr.isMembersEmpty())
			mgr.printALLMembers();
		else
			System.out.println("���� ���ȸ���� �� �� ���׿�!");

		// ȸ�� ���� - 1�� �߰� ���
		Member newMb = mgr.joinNewMember(null);
		if(newMb != null) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t" + newMb.getName() + "�� ������ �����մϴ�");
			System.out.println("\t ���� ����::");
			System.out.println(newMb); 
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

		}
		if (!mgr.isMembersEmpty())
			mgr.printALLMembers();
		else
			System.out.println("���� ���ȸ���� �� �� ���׿�!");
	}

}
