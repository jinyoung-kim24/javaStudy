package membership.manage;

import membership.data.Member;

public class MemberShoppingMgr extends MemberMgr {
	public MemberShoppingMgr() {
		//this.
		super();
	}

	public MemberShoppingMgr(int size) {
		super(size);
		//super();
//		this._members = new Member[size];
	}

	public MemberShoppingMgr(Member[] store) {
		super(store);
	}
	
	public void marketingPromotion() {
		System.out.println(">> ������:: ��ǰ ���θ��!!!!");		
	}
}
