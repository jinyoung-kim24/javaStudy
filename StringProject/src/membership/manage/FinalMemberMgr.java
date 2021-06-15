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



	// �θ�� ������� ��� ������ �߻�޼ҵ���� �� �Ѱ��� �������
	// ��� �����Ͽ� �ڽ��� ��üȭ Ŭ��������
	@Override
	public int loginProcessWithErrors(String id, String pw) {
		if(id == null) return LOGIN_ERR_ID_NULL;
		if(id.isEmpty()) return LOGIN_ERR_ID_EMPTY;
		if(pw == null) return LOGIN_ERR_PW_NULL;
		if(pw.isEmpty()) return LOGIN_ERR_PW_EMPTY;
		final int readMbCnt = checkNumberofMembers();
		for (int i = 0; i < readMbCnt; i++) {
			Member mb = _members[i];
			String mbId = mb.getId(); // null�� �ƴ϶�� ����
			if(mbId.equals(id)) {
				String mbPw =mb.getPassword();
				if(mbPw.equals(pw)) {
					return LOGIN_SUCCESS;
				}else {					
					return LOGIN_ERR_PW_MISMATCH;
				}
			}
		}
		// ���Ե��� ����ȸ��
		return LOGIN_ERR_ID_NOT_FOUND;
	}

}
