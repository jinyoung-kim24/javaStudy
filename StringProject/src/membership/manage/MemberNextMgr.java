package membership.manage;

import java.util.Scanner;

import membership.data.Member;

// ������ ȸ�������� Ŭ����
public class MemberNextMgr extends MemberMgr {
	public MemberNextMgr() {
		super();
		
	}

	public MemberNextMgr(int size) {
		super(size);
	
	}
	
	public MemberNextMgr(Member[] store) {
		super(store);
		
	}
	
	// 6. ��ϵ� ȸ������ Ư�� ����/Ű����� �˻��� �� �ִ�.
	// ������ Ű���� ���ڿ��� ȸ���� �̸�, �̸���, ������ 
	// �ش� Ű���尡 ���ԵǴ� �κ���ġ �˻��� ����
	public void readySearch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== ȸ�� �˻� ===");
		String keyword = inputString(sc, "�˻� Ű����:");
		searchMembers(keyword);
	}
	
	
	public void searchMembers(String keyword) {
		if(keyword == null || keyword.isEmpty()) return;
		for (Member member : _members) {
			if(member == null) break;
			String name = member.getName();
			String email = member.getEmail();
			String id = member.getId();
			if(name == null || email == null || id == null) {
				continue;
			}
			
			if(name.indexOf(keyword) != -1
				|| email.indexOf(keyword) != -1
				|| id.indexOf(keyword) != -1) {
				System.out.println("\t FOUND:: " + member);
			}else {
				System.out.println("...");
			}
			
		}
	}
	
}
