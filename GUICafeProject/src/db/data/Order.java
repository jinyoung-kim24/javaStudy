package db.data;

import java.sql.Date;

/*
  id 관리번호(DB 기준 생성, 중복x, not null) 
	int <<PK>> + 시퀀스 적용(CAFE.order_seq 시퀀스 적용)
- orderNum 주문번호 10자리 문자들 char 10 NN (unique)
- member_id <<PK>> => 외래키 <<FK>> 누가 주문
		회원 1명 여러개의 주문을 할 수 있다. 1:n 대응관계
- member_login <<UQ>>
- memberName 
- food_id <<FK>> 무엇을 주문 외래키
- foodName
- orderAt 주문날자 
- unit 주문상품단위개수 int 기본 1개
- totalPrice 총합가격 (옵션, 단위수량...) int 기본 0원
- .....
 */
public class Order {
	public static final int DEF_UNIT = 1;
	private int id; // 관리번호(DB 기준 생성, 중복x, not null) 
//	 int <<PK>> + 시퀀스 적용(CAFE.order_seq 시퀀스 적용)
	private String orderNum; // 주문번호 10자리 문자들 char 10 NN (unique)
	private int memberId; // <<PK>> => 외래키 <<FK>> 누가 주문
		//회원 1명 여러개의 주문을 할 수 있다. 1:n 대응관계
	private String memberLogin; // <<UQ>>
	private int foodId; //  <<FK>> 무엇을 주문 외래키
	private String foodName;
	private Date orderAt; //주문날자 
	private int unit; // 주문상품단위개수 int 기본 1개
	private int totalPrice; // 총합가격 (옵션, 단위수량...) int 기본 0원
	
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
		// data의 글자들을 랜덤 조합하여 10자리 주문번호 생성
		// 62분의 1의 활률이 10자리 지속 !!
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
