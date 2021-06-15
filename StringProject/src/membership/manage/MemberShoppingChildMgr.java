package membership.manage;

import membership.data.Member;

// ���(�����ڰ������ + ������ �������) + �˻������ ���ÿ� ����??
//public class MemberShoppingChildMgr
//		extends MemberShoppingMgr {

public class MemberShoppingChildMgr 
	extends MemberShoppingMgr
	implements MemberSeach { 
//	implements MemberSearch, ȸ������, ȸ��html���  { 
	// �������̽��� ��� �߻�޼ҵ���� �ݵ�� ��� ������ �Ϸ�(body�� ������ ����)
	
	public MemberShoppingChildMgr() {
		//this.
		super();
	}

	public MemberShoppingChildMgr(int size) {
		super(size);
		//super();
//		this._members = new Member[size];
	}

	public MemberShoppingChildMgr(Member[] store) {
		super(store);
	}
	
//	@Override
//	public void readySearch() {
//		// TODO Auto-generated method stub
//	}
	@Override
	public void readySearch() {
		// TODO Auto-generated method stub
	}
	@Override
	public void searchMembers(String keyword) {
		// TODO Auto-generated method stub
	}
	@Override
	public Member[] searchMembersAndReturn(String keyword) {
		if( keyword == null || keyword.isEmpty() ) return null;		
		Member[] foundMbs = new Member[checkNumberofMembers()];
		int countFound = 0;
		for (Member member : _members) {
			if( member == null ) break;
			String name = member.getName();
			String email = member.getEmail();
			String id = member.getId();
			if( name == null || email == null 
					|| id == null ) { 	continue; } //break;			
			if( name.indexOf(keyword) != -1 
				|| email.indexOf(keyword) != -1
					|| id.indexOf(keyword) != -1 ) {
				System.out.println("\t FOUND:: " + member.getName());
				foundMbs[countFound] = member;
				countFound++;				
			} else
				System.out.println("...");			
		}		
		System.out.println("*** ���: " + keyword +"�� �˻��� ȸ���� "+
				countFound +"�� �߰ߵ�!!");
		return foundMbs;
	}
	

}
