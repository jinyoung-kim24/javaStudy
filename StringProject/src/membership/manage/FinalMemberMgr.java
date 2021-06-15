package membership.manage;

import membership.data.Member;

public class FinalMemberMgr extends MemverTotalChildMgr {

	public FinalMemberMgr() {
		
	}
	
	
	
	public FinalMemberMgr(int size) {
		super(size);
		
	}



	public FinalMemberMgr(Member[] store) {
		super(store);
		
	}



	// 부모님 조상들의 모든 물려준 추상메소드들을 단 한개도 남김없이
	// 모두 구현하여 자신은 구체화 클래스가됨
	@Override
	public int loginProcessWithErrors(String id, String pw) {
		if(id == null) return LOGIN_ERR_ID_NULL;
		if(id.isEmpty()) return LOGIN_ERR_ID_EMPTY;
		if(pw == null) return LOGIN_ERR_PW_NULL;
		if(pw.isEmpty()) return LOGIN_ERR_PW_EMPTY;
		final int readMbCnt = checkNumberofMembers();
		for (int i = 0; i < readMbCnt; i++) {
			Member mb = _members[i];
			String mbId = mb.getId(); // null이 아니라고 믿음
			if(mbId.equals(id)) {
				String mbPw =mb.getPassword();
				if(mbPw.equals(pw)) {
					return LOGIN_SUCCESS;
				}else {					
					return LOGIN_ERR_PW_MISMATCH;
				}
			}
		}
		// 가입되지 않은회원
		return LOGIN_ERR_ID_NOT_FOUND;
	}

}
