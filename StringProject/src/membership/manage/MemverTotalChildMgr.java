package membership.manage;

import java.util.Scanner;

import membership.data.Member;

public abstract class MemverTotalChildMgr extends MemberTotalMgr {

	// �θ� Ŭ������ �߻�޼ҵ带 ������� �����ؾ���
//	@Override
//	public int loginProcessWithErrors(String id, String pw) {
//		
//		return 0;
//	}

	// �θ� �߻�Ŭ���� ������ �߻�޼ҵ带 �ڽ��� �������Ͽ� ��üȭ�޼ҵ�
	// 
	@Override
	public int readyLogin(Scanner sc) {
		System.out.println("--- �α��� ó�� ---");
		System.out.println(">> �α���: ");
		String login = sc.next();
		String pw = inputString(sc, ">> �н�����: ");
		return loginProcessWithErrors(login, pw);
	}
	
	public MemverTotalChildMgr() {
		// TODO Auto-generated constructor stub
	}

	public MemverTotalChildMgr(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	public MemverTotalChildMgr(Member[] store) {
		super(store);
		// TODO Auto-generated constructor stub
	}
	
	

}
