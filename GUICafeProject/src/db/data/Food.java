package db.data;

import java.util.Date;

/*

### ����(����) Food (��� ����Ʈ)
> CAFE.foods TBL
> db.data.Food ������ Ŭ����
> db.mgr.FoodDBMgr ������ DB�߰��� Ŭ����
> https://www.fromheartscoffee.com/Bakery �޴�

- id ������ȣ (DB ���� ����, �ߺ�x, not null-NN) 
	int <<PK>> + ������(CAFE.food_seq ������ ����)
- name ����/���� �̸� (�����ڰ� UI �Է�)  varchar2 32 NN <<UQ>>
- category ����ī�װ� (�����ڰ� UI �Է�)  varchar2 32 �⺻ '����'
- imagePath (�����ڰ� UI �Է�/����) ����/���� ���� ���� ��� varchar 512
- price ���� (�����ڰ� UI �Է�) int 1000�� �⺻
- hotIce �־��̽� (�����ڰ� UI �Է�/����) int  1 HOT 2 ICE
- regDate ��ϳ���(����) (�����ڰ� UI �Է�/����) date 
- like_members ���ƿ���ȸ���� id (login) ���... String... 
- like_count ���ƿ���ȸ����� int
- <1.1> description (�����ڰ� UI �Է�/����) ���� varchar 1024 
 */
public class Food {
	public static final String DEF_CATEGORY= "����";
	public static final int DEF_PRICE = 1000;
	public static final int TEMP_HOT = 1;
	public static final int TEMP_ICE = 2;
	private int id; // ������ȣ (DB ���� ����, �ߺ�x, not null-NN) 
				//int <<PK>> + ������(CAFE.food_seq ������ ����)
	private String name;// ����/���� �̸� (�����ڰ� UI �Է�)  varchar2 32 NN <<UQ>>
	private String  category;// ����ī�װ� (�����ڰ� UI �Է�)  varchar2 32 �⺻ '����'
	private String  imagePath;// (�����ڰ� UI �Է�/����) ����/���� ���� ���� ��� varchar 512
	private int  price;// ���� (�����ڰ� UI �Է�) int 1000�� �⺻
	private int  hotIce;// �־��̽� (�����ڰ� UI �Է�/����) int  1 HOT 2 ICE
	private Date regDate;// ��ϳ���(����) (�����ڰ� UI �Է�/����) date 
	private String  likeMembers;// ���ƿ���ȸ���� id (login) ���... String... 
	private int likeCount;// ���ƿ���ȸ����� int
	private String description; // ����.. <1.1 �߰�>
	
	public Food() {}
	
	public Food(String name, String category, String imagePath, int price, int hotIce) {
		super();
		this.name = name;
		this.category = category;
		this.imagePath = imagePath;
		this.price = price;
		this.hotIce = hotIce;
	}
	
	public Food(String name, String category, 
			String imagePath, int price, int hotIce, 
			String description) {
		super();
		this.name = name;
		this.category = category;
		this.imagePath = imagePath;
		this.price = price;
		this.hotIce = hotIce;
		this.description = description; //1.1
	}

	public Food(int id, String name, String category, String imagePath, int price, int hotIce, Date regDate,
			String likeMembers, int likeCount) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.imagePath = imagePath;
		this.price = price;
		this.hotIce = hotIce;
		this.regDate = regDate;
		this.likeMembers = likeMembers;
		this.likeCount = likeCount;
	}
	
	

	public Food(int id, String name, String category, String imagePath, int price, int hotIce, Date regDate,
			String likeMembers, int likeCount, String description) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.imagePath = imagePath;
		this.price = price;
		this.hotIce = hotIce;
		this.regDate = regDate;
		this.likeMembers = likeMembers;
		this.likeCount = likeCount;
		this.description = description;
	}

	// 1.1
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", category=" + category + ", imagePath=" + imagePath + ", price="
				+ price + ", hotIce=" + hotIce + ", regDate=" + regDate + ", likeMembers=" + likeMembers
				+ ", likeCount=" + likeCount + ", description=" + description + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Food [id=" + id + ", name=" + name + ", category=" + category + ", imagePath=" + imagePath + ", price="
//				+ price + ", hotIce=" + hotIce + ", regDate=" + regDate + ", likeMembers=" + likeMembers
//				+ ", likeCount=" + likeCount + "]";
//	}

	
	
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHotIce() {
		return hotIce;
	}

	public void setHotIce(int hotIce) {
		this.hotIce = hotIce;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getLikeMembers() {
		return likeMembers;
	}

	public void setLikeMembers(String likeMembers) {
		this.likeMembers = likeMembers;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}	
}
