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
		
		FinalMemberMgr ttMgr = new FinalMemberMgr(store);
		// �߻� Ŭ������ new�� ���� 
		ttMgr.processJoinMembers(); // 2��
		ttMgr.printALLMembers();
		ttMgr.marketingPromotion(); // 3��
		ttMgr.readySearch(); // 4���� �������̽� �޼ҵ� ������
		int loginResult = ttMgr.readyLogin(new Scanner(System.in));
		
		switch (loginResult) {
		case MemberLogin.LOGIN_SUCCESS:
			System.out.println("�α��� ����");
			System.out.println(">> ������������ �̵�!!");
			break;
		case MemberLogin.LOGIN_ERR_ID_NULL:
		case MemberLogin.LOGIN_ERR_PW_NULL:
		case MemberLogin.LOGIN_ERR_ID_EMPTY:
		case MemberLogin.LOGIN_ERR_PW_EMPTY:
			System.out.println(">> �α��� ����! �������̳� �н����尡 ����");
			break;
		case MemberLogin.LOGIN_ERR_ID_NOT_FOUND:
			System.out.println(">> �α��� ����! ���Ծȵ� ȸ��");
			break;	
		case MemberLogin.LOGIN_ERR_PW_MISMATCH:
			System.out.println(">> �α��� ���� ��ȣ ����ġ");
			break;
		default:
			System.out.println("�α��� ����� ó�� �Ұ���!");
			break;
		}
	}
}
