package membership.manage;

import membership.data.Member;

// �������̽�
/*
 * �߻����� ��ɰ� ����� �������� ����
 * 
 * ���Ѿ��ϴ� ��Ģ�̳� ����, ���, ���� ���� �����ϴ� ��
 * �ϴ� �ڹ� 1.8 �������� �������̽��� ����
 * �߻�޼ҵ�� ����� ���� �־���.
 * 
 *   �߻�޼ҵ�� abstarct method
 *   : �Լ��� �ٵ� ����{}�� ���� �Լ��� �������� �ִ� ���
 *   
 */

public interface MemberSeach {
	public static final String DEF_MSG = "Ű���� �˻� ���!";
	// 6. ��ϵ� ȸ������ Ư�� ����/Ű����� �˻��� �� �ִ�
	public abstract void readySearch();
	public abstract void searchMembers(String keyword);
	public abstract Member[] searchMembersAndReturn(String keyword);
	
	
}
