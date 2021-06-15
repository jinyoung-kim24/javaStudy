package db.data;

import java.util.Date;

public class Member {
	
	public static final int GENDER_MALE = 1; // ³²
	public static final int GENDER_FEMALE = 2; // ¿©
	
	private String id;
	private String pw;
	private String birthday;
	private int gender;
	private String name;
	private String address;
	private String postNum;
	private String email;
	private String phoneNumber;
	private int controlNum; // <<PK>>
	private int age;
	private Date joinDay;
	
	
	public Member() {}
	

	public Member(String id) {
		super();
		this.id = id;
	}

//	public Member(String id, String phoneNumber) {
//		super();
//		this.id = id;
//		this.phoneNumber = phoneNumber;
//	}

	public Member(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}



	public Member(String id, String pw, String birthday, int gender, String name, String address, String postNum,
			String email, String phoneNumber, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.birthday = birthday;
		this.gender = gender;
		this.name = name;
		this.address = address;
		this.postNum = postNum;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}


	public Member(String id, String pw, String birthday, int gender, String name, String address, String postNum,
			String email, String phoneNumber, int controlNum, int age, Date joinDay) {
		super();
		this.id = id;
		this.pw = pw;
		this.birthday = birthday;
		this.gender = gender;
		this.name = name;
		this.address = address;
		this.postNum = postNum;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.controlNum = controlNum;
		this.age = age;
		this.joinDay = joinDay;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPostNum() {
		return postNum;
	}


	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getControlNum() {
		return controlNum;
	}


	public void setControlNum(int controlNum) {
		this.controlNum = controlNum;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Date getJoinDay() {
		return joinDay;
	}


	public void setJoinDay(Date joinDay) {
		this.joinDay = joinDay;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", birthday=" + birthday + ", gender=" + gender + ", name=" + name
				+ ", address=" + address + ", postNum=" + postNum + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", controlNum=" + controlNum + ", age=" + age + ", joinDay=" + joinDay + "]";
	}


}