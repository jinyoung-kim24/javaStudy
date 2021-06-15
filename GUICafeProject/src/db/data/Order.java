package db.data;

import java.sql.Date;

/*
  id ������ȣ(DB ���� ����, �ߺ�x, not null) 
	int <<PK>> + ������ ����(CAFE.order_seq ������ ����)
- orderNum �ֹ���ȣ 10�ڸ� ���ڵ� char 10 NN (unique)
- member_id <<PK>> => �ܷ�Ű <<FK>> ���� �ֹ�
		ȸ�� 1�� �������� �ֹ��� �� �� �ִ�. 1:n ��������
- member_login <<UQ>>
- memberName 
- food_id <<FK>> ������ �ֹ� �ܷ�Ű
- foodName
- orderAt �ֹ����� 
- unit �ֹ���ǰ�������� int �⺻ 1��
- totalPrice ���հ��� (�ɼ�, ��������...) int �⺻ 0��
- .....
 */
public class Order {
	public static final int DEF_UNIT = 1;
	private int id; // ������ȣ(DB ���� ����, �ߺ�x, not null) 
//	 int <<PK>> + ������ ����(CAFE.order_seq ������ ����)
	private String orderNum; // �ֹ���ȣ 10�ڸ� ���ڵ� char 10 NN (unique)
	private int memberId; // <<PK>> => �ܷ�Ű <<FK>> ���� �ֹ�
		//ȸ�� 1�� �������� �ֹ��� �� �� �ִ�. 1:n ��������
	private String memberLogin; // <<UQ>>
	private int foodId; //  <<FK>> ������ �ֹ� �ܷ�Ű
	private String foodName;
	private Date orderAt; //�ֹ����� 
	private int unit; // �ֹ���ǰ�������� int �⺻ 1��
	private int totalPrice; // ���հ��� (�ɼ�, ��������...) int �⺻ 0��
	
	public Order() {}
	
	
	public Order(String orderNum, int memberId, String memberLogin, int foodId, String foodName, 
			int totalPrice) {
		super();
		this.orderNum = orderNum;
		this.memberId = memberId;
		this.memberLogin = memberLogin;
		this.foodId = foodId;
		this.foodName = foodName;
		this.unit = DEF_UNIT;
		this.totalPrice = totalPrice;
	}
	
	public Order(String orderNum, int memberId, String memberLogin, int foodId, String foodName, int unit,
			int totalPrice) {
		super();
		this.orderNum = orderNum;
		this.memberId = memberId;
		this.memberLogin = memberLogin;
		this.foodId = foodId;
		this.foodName = foodName;
		this.unit = unit;
		this.totalPrice = totalPrice;
	}

	public Order(int id, String orderNum, int memberId, String memberLogin, int foodId, String foodName, Date orderAt,
			int unit, int totalPrice) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.memberId = memberId;
		this.memberLogin = memberLogin;
		this.foodId = foodId;
		this.foodName = foodName;
		this.orderAt = orderAt;
		this.unit = unit;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public static String generateOrderNumber() {
		String small = "";
		for (char c = 'a'; c <= 'z'; c++) {
			small += c;
		}
		final String data = "ABCDEFGHIJKLMNOPQRSTU" + small + "0123456789";
		// data�� ���ڵ��� ���� �����Ͽ� 10�ڸ� �ֹ���ȣ ����
		// 62���� 1�� Ȱ���� 10�ڸ� ���� !!
		String orderNum = "ON";
		for (int i = 0; i < 8; i++) {
			char c = data.charAt((int)(Math.random() * data.length()));
			orderNum += c;
		}
		return orderNum;
	}

	public String getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getMemberLogin() {
		return memberLogin;
	}


	public void setMemberLogin(String memberLogin) {
		this.memberLogin = memberLogin;
	}


	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public Date getOrderAt() {
		return orderAt;
	}


	public void setOrderAt(Date orderAt) {
		this.orderAt = orderAt;
	}


	public int getUnit() {
		return unit;
	}


	public void setUnit(int unit) {
		this.unit = unit;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNum=" + orderNum + ", memberId=" + memberId + ", memberLogin=" + memberLogin
				+ ", foodId=" + foodId + ", foodName=" + foodName + ", orderAt=" + orderAt + ", unit=" + unit
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	
	
	
	
	
}
