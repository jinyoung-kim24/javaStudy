package membership.data;
import java.rmi.MarshalException;
import java.util.Date;
/* ȸ���� ������ ����
  	
  	ȸ�� ��Ű��(Member)
  	- ��Ŭ, ���Ƹ�, Ȯȸ ����?
  	- ������ȣ(�������� ü����), �̸�, ����, �̸���, �������, ���Գ�¥, ���ϸ���
  	+ ������(ID ������ ���ڿ�) / ��ȣ(password)
  	
  	
  	
 */

// DATA CLASS => VO-value object/DTO-data transfer object
// Member VO�� ȸ�� 1���� ��Ű���� ������ ���� �׸����� ȸ����ü
public class Member {
	private int no; // ������ȣ(�������� ü����),
	private String name; // �̸�,
	private int age; // ����,
	private String email; // �̸���,
	private double mileage; // ���ϸ���
  	private String id; // ������(ID ������ ���ڿ�)
  	private String password; // ��ȣ(password)
  	private Date birthDay; // �������,
  	private Date joinDay; // ���Գ�¥,
  	
  	public static final int DEF_AGE = 18;
  	public static final double DEF_MILE = 1000.0;
  	public static int order = 0; // ������ȣ�� ���ذ�
  	
  	
  	
  	
  	
  	
  	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Date getJoinDay() {
		return joinDay;
	}

	public void setJoinDay(Date joinDay) {
		this.joinDay = joinDay;
	}

	// �⺻������
  	public Member() {}

  	// �߰� ������
  	public Member(String name, String email, String id, String password, Date birthDay) {
  		this(++order, name, DEF_AGE, email, DEF_MILE, id, password, birthDay, new Date());
  	}
  	
  	// Ǯ������
	public Member(int no, String name, int age, String email, double mileage, String id, String password, Date birthDay,
			Date joinDay) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.email = email;
		this.mileage = mileage;
		this.id = id;
		this.password = password;
		this.birthDay = birthDay;
		this.joinDay = joinDay;
	}

	@Override
	public String toString() {
		return no + ", " + name + "," + age + "," + email + "," + mileage
				+ ", " + id + ", " + password + "," + birthDay + "," + joinDay;
	}
  	
  	
  	
  	
}
