package dbtest.data;
//������ ��Ű�� �߽� ��� 
//DB coporations TBL <----> java Company Ŭ���� ��������
// ���ڵ� �ϳ�	

/*

  CREATE TABLE "DEVEL"."CORPORATIONS" 
   (	"ID" NUMBER(*,0) DEFAULT 0 NOT NULL ENABLE, 
	"NAME" VARCHAR2(64 BYTE) NOT NULL ENABLE, 
	"DOMAIN" VARCHAR2(64 BYTE) DEFAULT '�����', 
	"CEO" VARCHAR2(32 BYTE) NOT NULL ENABLE, 
	"RATE" NUMBER(4,2) DEFAULT 5.0 NOT NULL ENABLE, 
	"RANK" VARCHAR2(16 BYTE) DEFAULT 'N' NOT NULL ENABLE, 
	 CONSTRAINT "CORPORATIONS_PK" PRIMARY KEY ("ID")
	 
��Ű�� Ŭ����  CORPORATIONS
	int id ������ȣ // <<pk>>
	String name �̸� 
	String domain �о�
	String ceo ��ǥ�̻�
	float rate ����
	String rank ���
 */
// ������ Ŭ���� (��Ű���� ������ Ŭ����; �� Ŭ����, ��ƼƼ ǥ��)
// ��Ű�� ������ ��� �׸����ν��� ��ü�� �����ϴ� ���� Ŭ����
// class CompanyVO (value object)
public class Company {
	public static final int DEF_ID = 0;
	public static final String DEF_DOMAIN = "�����";
	public static final float DEF_RATE = 5.0f;
	public static final String DEF_RANK = "N";
	//
	private int id;
	private String name;
	private String domain;
	private String ceo;
	private float rate;
	private String rank;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	// default, nullable


	public Company(int id, String name, String ceo) {
		this(id, name, DEF_DOMAIN, ceo);
//		super();
//		this.id = id;
//		this.name = name;
//		this.ceo = ceo;
	}

	public Company(int id, String name, String domain, String ceo) {
		this(id, name, domain, ceo, DEF_RATE, DEF_RANK);
	}
	
	public Company(int id, String name, String domain, String ceo, float rate, String rank) {
		super();
		this.id = id;
		this.name = name;
		this.domain = domain;
		this.ceo = ceo;
		this.rate = rate;
		this.rank = rank;
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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "ITȸ�� : " + id + ", " + name + ", " + domain + ", " + ceo + "��, " + rate
				+ "��, " + rank + " ���";
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Company [id=");
//		builder.append(id);
//		builder.append(", name=");
//		builder.append(name);
//		builder.append(", domain=");
//		builder.append(domain);
//		builder.append(", ceo=");
//		builder.append(ceo);
//		builder.append(", rate=");
//		builder.append(rate);
//		builder.append(", rank=");
//		builder.append(rank);
//		builder.append("]");
//		return builder.toString();
//	}
	
	
	
	
	
	
}
