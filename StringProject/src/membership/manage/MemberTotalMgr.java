package membership.manage;

import java.util.Scanner;

import membership.data.Member;

// object > MemberMgr > MemberShoppingMgr
// > MemberShoppingChildMgr
// abstract 클래스 추상클래스 선언 한개 이상의 추상 메소드를 가져도 정상인 클래슨
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

	// 자신의 고유한 추상메소드를 선언함
	public abstract int readyLogin(Scanner sc); 
		
	
	
	@Override
	public boolean loginProcess(String id, String pw) {
		final String dummyPw = "1234";
		if(pw.equals(dummyPw) || pw.isEmpty()) return true;
		else return false;
	}

	// 추상 메소드 수현 못함
//	@Override
//	public int loginProcessWithErrors(String id, String pw) {
//		
//		return 0;
//	}
	
	
	
}
