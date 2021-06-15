package membership.manage;

import java.util.Scanner;

import membership.data.Member;

// object > MemberMgr > MemberShoppingMgr
// > MemberShoppingChildMgr
// abstract Ŭ���� �߻�Ŭ���� ���� �Ѱ� �̻��� �߻� �޼ҵ带 ������ ������ Ŭ����
public abstract class MemberTotalMgr 
	extends MemberShoppingChildMgr implements MemberLogin {

	public MemberTotalMgr() {
		
	}

	public MemberTotalMgr(int size) {
		super(size);
		
	}

	public MemberTotalMgr(Member[] store) {
		super(store);
		
	}

	// �ڽ��� ������ �߻�޼ҵ带 ������
	public abstract int readyLogin(Scanner sc); 
		
	
	
	@Override
	public boolean loginProcess(String id, String pw) {
		final String dummyPw = "1234";
		if(pw.equals(dummyPw) || pw.isEmpty()) return true;
		else return false;
	}

	// �߻� �޼ҵ� ���� ����
//	@Override
//	public int loginProcessWithErrors(String id, String pw) {
//		
//		return 0;
//	}
	
	
	
}
