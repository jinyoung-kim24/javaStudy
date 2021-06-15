package db.data;

import java.util.Date;

/*
> CAFE.members TBL ���̺�
> data.db.Member ������ Ŭ����
> db.mgr.MemberDBMgr ������ DB�߰��� Ŭ����

- id ������ȣ(DB ���� ����, �ߺ�x, not null) 
	int <<PK>> + ������ ����(CAFE.member_seq ������ ����)
- name ȸ�� �Ǹ� (UI �Է�) varchar2 24
- login �α��θ� (UI �Է�) varchar2 4~12 �ߺ�x unique <<UQ>> NN
- pw �н����� (UI �Է�) varchar2 4~12 NN
- age ȸ�� ���� (UI �Է�) int 18�� �⺻ 18~50��...
- gender ȸ�� ���� (UI �Է�) int 1 ����, 2 ����
- mileage ���ϸ��� Ȱ�� ����Ʈ (DB ���� ����) int 1000�� �⺻
- joinedAt ���Գ���(DB ���� ����) Date 
 * 
 */
public class Member {
	public static final int DEF_AGE = 18;
	public static final int DEF_MILEAGE = 1000;
	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_MALE = 2;
	
	private int id; // <<pk>>
	private String name;
	private String login; // <<uq>>
	private String pw;
	private int age;
	private int gender;
	private int mileage;
	private Date joinedAt; // members.joined_at �÷��� ����
	
	public Member() {}
	
	// ȸ������ ���� ����ȭ�� ������ 
	public Member(String name, String login, String pw, int age, int gender) {
		this(0, name, login, pw, age, gender, DEF_MILEAGE, null);
//		super();
//		this.name = name;
//		this.login = login;
//		this.pw = pw;
//		this.age = age;
//		this.gender = gender;
		
	}

	public Member(int id, String name, String login, String pw, int age, int gender, int mileage, Date joinedAt) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.pw = pw;
		this.age = age;
		this.gender = gender;
		this.mileage = mileage;
		this.joinedAt = joinedAt;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public Date getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", login=" + login + ", pw=" + pw + ", age=" + age + ", gender="
				+ gender + ", mileage=" + mileage + ", joinedAt=" + joinedAt + "]";
	}
	
	
	
	
	
}
