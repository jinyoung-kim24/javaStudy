package newbook;
// ������ �������� ������Ʈ
// �䱸�������ǹ��� SRS: SW ��ǰ(������Ʈ)�� �ʿ��� ��� ������ ����� ��ȹ��..
// ���丮�� �����ϴ� ��� ����� �߿���... �ֿ� ����� �м��ϰ�,
// ���⿡ �ʿ��� ��� ������� ��Ű��(Schema)�� ǥ���ϰ� �̸� ���� Ŭ������ ����,

// å�̶�� ����(��Ű��)�� �������� �Ӽ� ��� ������
// ����, ����, ���ǻ�, ����, �Ź��̹���, �Ⱓ/����⵵ �ʼ�, ISBN, �帣....
// + ������ȣ(�԰����), ����, �ڸ�Ʈ(����), �̷°���..

// Ŭ������ ���ο� Ÿ��(���赵), 
//Ŭ���� = ������(�ʵ�=���/����) + ���(�Լ�;�޼ҵ�)
public class Book {
	// ����, ����, ���ǻ�, ����, �Ź��̹���, �Ⱓ/����⵵ �ʼ�, ISBN, �帣....
	// + ������ȣ(�԰����), ����, �ڸ�Ʈ(����), �̷°���..
	// ��� �ʵ�( Ŭ������ ���� ������)
	public static final String NO_TITLE = "���� ����";
	public static final String NO_AUTHOR = "���� ����";
	public static final int DEF_PUB = 0; // ���� ���ǻ�
	public static final String DUMMY_COVER = "default/dummy.png";
	public static final String DUMMY_ISBN = "9876543210123";
	public static final String NO_COMMENT = "��۾���"; // "";
	public static final String[] PUB_NAMES = {
			"���� ���ǻ�", "�����", "�������л�", "������ǻ�", "�������ǻ�", "�Ϻ���ȭ��"
	}; // publisher�� PUB_NAMES�� ������ȣ
	// ���� �ʵ�
	public String title; // ����
	public String author; // ����
//	public String publisher; // ���ǻ�
	public int publisher; // ���ǻ� ��Ϲ�ȣ?
//	public int price; // ����
//	public Image cover; // åǥ������? 
	public String imgPath; // åǥ�� Ŀ���̹��� ������ ���ϸ�/��θ� ���ڿ�
	public String ISBN; // ���ڵ�
	
	public int no; // ������ȣ(�԰����) 0 �ڵ��ʱ�ȭ
	public float rate; // ����(5��ô��) 0.0f �ڵ��ʱ�ȭ
	public String comment; // �ڸ�Ʈ(����)
	
	// �������� �԰� ó���� ���� �ʵ�
	public boolean stamp; // false �԰���, true ������ ������ �԰� �Ϸ�
	
	
	// �����ڵ�
	// �������Լ�(Ŭ�������ϸ�; constructor)
	// => new�� ���� ��������� ��ü�� �ʱ�ȭ�� ���.
	// => �������� ���� ��ü�� ����� ���� �ʱ�ȭ�� ������ ����
	// �� ���� ��ü�� �޸𸮻��� ��ġ����(�ּ� address ��heap����)�� ������
	
	// �⺻������(���̻�����) �ڵ����� ���ǵǴ� �������Լ�
//	public Book() {} // �⺻�����ڴ� (Ŭ������ �����ڰ� �ϳ��� ���� �� ��������)
	public Book() {} // �� �����ʵ���� �ڽ��� Ÿ���� �⺻������ �ڵ� �ʱ�ȭ..
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.comment = Book.NO_COMMENT;
		this.imgPath = DUMMY_COVER;
		publisher = DEF_PUB;
		this.no = 0;
		this.rate = 0.0f;
		this.ISBN = DUMMY_ISBN;
	}
	
	
	// �߰� ������(�ʵ���� �Ϻθ� ������ ��ü�� �켱 �����)
	public Book(String atitle, String aauthor, int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
//		imgPath = null; // �ڵ��ʱ�ȭ
//		ISBN = null; // �ڵ��ʱ�ȭ
//		no = 0; // �ڵ��ʱ�ȭ
//		rate = 0.0f; // �ڵ��ʱ�ȭ
//		comment = null; // �ڵ��ʱ�ȭ
	}
	
	public Book(int no, String atitle, String aauthor, int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
		// ��ü�ʵ庯�� = ��������(����)
		// this.�ʵ庯�� = ��������(����)
//		imgPath = null; // �ڵ��ʱ�ȭ
//		ISBN = null; // �ڵ��ʱ�ȭ
//		no = no; // �ڵ��ʱ�ȭ
		this.no = no; //�ڽſ��� ���� no���� �ʵ忡 ���� no�� Ȱ��.
//		this��  ��ü �ڽ��� �ּ�(�ڱ��ڽ�) ==> �̸������� ����.
//		rate = 0.0f; // �ڵ��ʱ�ȭ
//		comment = null; // �ڵ��ʱ�ȭ
	}
	
	// old Ǯ ������ (��� �ʵ� �ʱ�ȭ ����)
	public Book(String atitle, String aauthor, int apublisher,String aimgPath,
			String aISBN, int ano, float arate, String acomment) {
		
			title = atitle;
			author = aauthor;
			publisher = apublisher;
			imgPath = aimgPath;
			ISBN = aISBN;
			no = ano;
			rate = arate;
			comment = acomment;
					
	}
	// �԰� �������� Ǯ������
	public Book(String title, String author, int publisher, String imgPath, String iSBN, int no, float rate,
			String comment, boolean stamp) {
//		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.imgPath = imgPath;
		ISBN = iSBN;
		this.no = no;
		this.rate = rate;
		this.comment = comment;
		this.stamp = stamp;
	}

	// �԰� ������ �Ǵ��Ͽ� ����ϰ� �� ���µ� �������ִ� �Լ�
	public boolean isBookRegister() {
//		if(stamp == true) {
//			System.out.println(this.title + "�� å�� �԰� �Ǿ����ϴ�");
//		}else {
//			System.out.println(this.title + "�� å�� �԰� �� �Դϴ�.");
//		}
		System.out.println(this.title + "å��" + (stamp ? "�԰� �Ǿ����ϴ�" : "�԰� �� �Դϴ�"));		
		return stamp;
	}
	
	// �޼ҵ�
	// ���� �ʵ� ���� ��� - (���� ó��)
	// 0.0 ~ 5.0 ��������?
//	public void changeRate(float rate) {
//		this.rate = rate;
//	}
	//���� ������ ������ �������� �缳��
	public boolean changeRate(float rate) {
		if(rate >= 0.0f && rate <= 5.0f) {
		this.rate = rate;
		System.out.println(">> ����[" + title + "]�� ������ " +
		rate + "���� ����Ǿ����ϴ�");return true; 
		}else {
			System.out.println("���� ���� ���� ��� ����: " + rate);
			return false;
		}
	}
	public static final float RATE_UNIT = 0.5f;
	public void increaseRate() {
		if(this.changeRate(this.rate + RATE_UNIT) == false) {
			this.rate = 5.0f;
		}
	}
	public void decreaseRate() {
		if(this.changeRate(this.rate - RATE_UNIT) == false) {
			this.rate = 0.0f;
		}
	}
	
	// �Ǽ����� ���� rate�� �׷��ȿ���� ��ǥ�÷� ����ϱ�
	// ****** => �١� 
	// 0.0 ~ 5.0 => rate�� 6���� ����
	// �١١١١�
	// �ڡ١١١�
	// �ڡڡ١١�
	// �ڡڡڡ١�
	// �ڡڡڡڡ�
	// �ڡڡڡڡ�
	// private�� Ŭ���� ���ο����� ���� ���� ����̵� (������)
	public String getStarRating3() {
		String stars = "";
		final String RSTARS[] = {
				"�١١١١�",	"�ڡ١١١�", "�ڡڡ١١�",
				"�ڡڡڡ١�", "�ڡڡڡڡ�", "�ڡڡڡڡ�"
		};
		int starIndex = Math.round(rate);
		stars = RSTARS[starIndex];
		
		return "[" + stars + ">>"; 
	}
	private String getStarRating() {
		String stars = "";
		int starIndex = Math.round(rate);
		// 0.0 ~ 5.0 ==> 0
		switch (starIndex) {
		case 0: stars = "�١١١١�"; break;
		case 1: stars = "�ڡ١١١�"; break;
		case 2: stars = "�ڡڡ١١�"; break;
		case 3: stars = "�ڡڡڡ١�"; break;
		case 4: stars = "�ڡڡڡڡ�"; break;
		case 5: stars = "�ڡڡڡڡ�"; break;
			// case�� ���ڰ� ������(ä���� ���� ����)
		default: stars = "����";
			break;
		}
		return "[" + stars; 
	}
	private String getStarRating2() {
		String stars = "";
		if(rate >= 0.0f && rate < 0.5f) {
			stars = "�١١١١�";
		 }else if(rate >= 0.5f && rate < 1.5f) {
			 stars = "�ڡ١١١�";
		 }
		 else if(rate < 2.5f) {
			 stars = "�ڡڡ١١�";
		 }
		 else if(rate < 3.5f) {
			 stars = "�ڡڡڡ١�";
		 }
		 else if(rate < 4.5f) {
			 stars = "�ڡڡڡڡ�";
		 }else if(rate <= 5.0f){
			 stars = "�ڡڡڡڡ�";
		 }else {
			 stars = "����";
		 }
		 return stars;
	}
	
	
	// ���� ���� 1.0 �ø���
//	public void increaseRate() {
////		this.rate = this.rate + RATE_UNIT;
//		float tempRate = this.rate + RATE_UNIT;
//		if(tempRate >= 5.0f) {
//			System.out.println(">> ���� MAX ���! 5.0����ó��");
//			this.rate = 5.0f;
//		}else {
//			this.rate = tempRate;
//		}
//	}
//	// ���� ���� 1.0 ������
//	public void decreaseRate() {
////		this.rate = this.rate - RATE_UNIT;
//		float tempRate = this.rate - RATE_UNIT;
//		if(tempRate < 0.0f) {
//			System.out.println(">> ���� MIN ���! 0.0����ó��");
//			this.rate = 0.0f;
//		}else {
//			this.rate = tempRate;
//		}
//	}
	
	//å ��ü ���� ���
	public void printBook() {
		System.out.printf("������ å: #Bk-%06d\n", no);
		System.out.println("����: " + title);
		System.out.println("\t\t\t\t" + this.author + "����");
//		System.out.println("\t���ǻ�: " + this.publisher);
		System.out.println("\t���ǻ�: " + (publisher >= 0 && publisher < PUB_NAMES.length ?
				PUB_NAMES[publisher] : "���ǻ� ����"));
		System.out.println("\tĿ��ǥ��: " + imgPath);
		System.out.println("\tISBN: " + this.ISBN);
			String stars = this.getStarRating3();
		System.out.printf("\t\t ����: (%s) %.2f/5.0 pt \n",stars, this.rate);
		System.out.printf("\t\t ����: %s \n", comment);
		System.out.println("---------------------------------");
	}
	
}
