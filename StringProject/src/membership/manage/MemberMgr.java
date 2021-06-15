package membership.manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import membership.data.Member;

// ȸ������ �����ϱ� ���� �߰� Ŭ����

// Member ��Ű��(������)�� CRUD �����ϴ� Ŭ����
// ȸ������, ȸ�� ����, ȸ�� ����, ȸ�� ��ȸ
public class MemberMgr {
	public static final int MAX_MEMBERS = 5;
	// �����Ǵ� ȸ���� (�����, �޸�, ����, DB, Ŭ����)

//	1. �� ���� ȸ������ ������ ������ �غ� (�������̽� ���̾�׷�)
	protected Member[] _members;

	public MemberMgr() {
		this._members = new Member[MAX_MEMBERS];

	}

	public MemberMgr(int size) {
//		super();
		if (size <= 0)
			size = MAX_MEMBERS;
		this._members = new Member[size];
	}

	public MemberMgr(Member[] store) {
		super();
		if (store != null && store.length > 0)
			this._members = store;
		else
			this._members = new Member[MAX_MEMBERS];
	}

	// 2. �� ���� ȸ������ �Ѹ� ����� �� �ִ�. (����)

	// ��ĵ�ʷ� ������ �Է¹޾� ������ ȸ��(vo ��ü)�� �����ϰ�,
	// �迭�� ����ϰ�, �� ȸ�� ��ü�� �����ϴ� �Լ�
	public Member joinNewMember(Scanner sc) {
		if (this.isMembersFull()) {
			System.out.println("�� �̻� �߰� ȸ�� �Ұ���!!");
			return null;
		}
		if (sc == null)
			sc = new Scanner(System.in);

		Member mb = null;
		// ��ĳ�ʷ� ȸ����ü ������ ���� ��� �������� �Է�
		int no = ++Member.order;
		String name = inputString(sc, ">> ȸ�� �̸�:");
		int age = inputInteger(sc, "ȸ������:");
		String email = inputString(sc, ">> �̸��� �ּ�:");
		double mileage = Member.DEF_MILE;
		String id = inputString(sc, ">> ȸ�� ���̵�:");
		String password = inputString(sc, ">> ȸ�� ��ȣ:");
		// ���� ���ڿ��� �Է� => ������ ��ü ��ȯ
		String birthStr = inputString(sc, ">> ȸ�� ������� [��:2020-03-14]:");
		Date birthDay = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
//			sdf.format(date)
			birthDay = sdf.parse(birthStr);
		} catch (ParseException e) {
			System.out.println("�߸��� ���� ������� �Է�!!");
			birthDay = new Date();
		}
		Date joinDay = new Date();
		// �������� new ȸ����ü ����
		mb = new Member(no, name, age, email, Member.DEF_MILE, id, password, birthDay, joinDay);

		// �迭������ �� ȸ�� ȸ�� ��ü ����
		int inputNo = checkNumberofMembers();
		_members[inputNo] = mb; // �迭�� �� �������� ä���� ���
		return mb;
	}

	public int inputInteger(Scanner sc, String msg) {
		System.out.println(msg);
		String input = sc.next();
		return Integer.parseInt(input);
	}

	public String inputString(Scanner sc, String msg) {
		System.out.println(msg);
		return sc.next();
	}

	// �� ���� ȸ���� ��ĳ�ʷ� ���������� ����ϴ� �Լ�( yes/no �߰�? ����?)
	public void processJoinMembers() {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		do {
		Member newMb = joinNewMember(null);
		if(newMb != null) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t" + newMb.getName() + "�� ������ �����մϴ�");
			System.out.println("\t ���� ����::");
			System.out.println(newMb); 
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			count++;

			}
			if(!isMembersFull()) {
				String conti = inputString(sc, ">> �߰� ȸ�� ����? (yes/no)");
				if(conti.equalsIgnoreCase("no") || conti.equals("n") || conti.equals("�ƴϿ�")) {
					break;
				}
			}else {
				System.out.println("�� �̻� ��� �Ұ�");
			}
		}while(true);
		System.out.println("\t �ű�ȸ��" + count + "���� �߰���.....");
				
	}

	// 3. ��ϵ� ȸ������ �� ����Ʈ�� ����� �� �ִ�.
	public void printALLMembers() {
		System.out.println("=== ȸ�� ����Ʈ === (" + checkNumberofMembers() + "/" + _members.length + "��)");
		System.out.println("��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������");
		System.out.println("------------------------------------------------------");
		for (Member mb : _members) {
			System.out.println(mb == null ? "Member ����" : mb.toString());
		}
		System.out.println("------------------------------------------------------");

	}

	// 4. ��ϵ� ��ü ȸ������ �� ����� Ȯ���� �� �ִ�.
	public int checkNumberofMembers() {
		// ��ϵ� ȸ�� ��� == ������� �迭���� null�ƴ� ����.
		int count = 0;
		for (int i = 0; i < _members.length; i++) {
			Member mb = _members[i];
			if (mb != null) {
				count++;
			}
		}
		return count;
	}

	// 5. ����Ұ� ����������? ��������� Ȯ�� �� �� �ִ�
	public boolean isMembersFull() {
//		if(checkNumberofMembers() == _members.length) return true;
//		else return false;
		return checkNumberofMembers() == _members.length;
	}

	public boolean isMembersEmpty() {
		return checkNumberofMembers() == 0;
	}
	// 6. ��ϵ� ȸ������ Ư�� ����/Ű����� �˻��� �� �ִ�.

	// 7. �α��� ���� ó�� �� �� �ִ�.

	// 8. �н����� ��ȣȭ �� �� �ִ�.

}
