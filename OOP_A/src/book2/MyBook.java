package book2;

// Ŭ���� class ���� == java���� Ŭ������ ���ο� Ÿ���� ����°�.
// 	���赵....? 
// ��ü�������� ���󿡼� (�� ������ ��ü������ ���������� 3����)
// ��ü object��� ���� Ŭ������ ������ ��ü���� ���� ������� ����.
// 'å' �̶�� ����(��Ű�� Schema)�� Ŭ������ ǥ�� 
// �ش� ��Ű���� Ư¡���� Ŭ������ ������ҷ� ��ƾ� ��.
// å�� ���ø���.. ����, �о�(�帣), ����, ���ǻ�, �ʼ�, ���� (���ڵ�), ǥ��... 
// Ŭ������ �̷� Ư¡�� ���� ������� ǥ������ �ʰ� �� �������� �ϳ��� Ŭ���� ���� ����,
// ���⿡ ��Ű���� ó���� ����� ��ɵ��� �Լ��ν� �ش� Ŭ���� �����ؼ� ������
// ��, Ŭ������ ���� ������� (�ʵ�, �Ӽ�property) + ���� ���(�Լ� �޼ҵ�)��� ǥ����
// class = fields + methods
// ���� ������� ��� ������� �Լ� �������(�޼ҵ�)
// Ŭ������ ���ο� Ÿ���� ���� " �����Ϳͱ���� �ϳ��� ���� ���赵��)
// java������ Ư�� Ŭ������ ��ü�� �ڹ� JVM�޸� ���� �¾�� �ϱ� ���� 
// �ݵ�� new�� ������ ��ġ�� new �������� ����Ǹ� ��ü�� Ȱ����.

// å��Ű�� ǥ�� (���赵)
public class MyBook {
	// ������ ǥ��(�ʵ�)-------------------
	// (����) ��� �ʵ�
	public static final int DEF_PRICE = 2900;
	public static final String DEF_GENRE = "�Ҽ�";
	public static final String DEF_TITLE = "�������"; // null����
	public static final String DEF_AUTHOR = "���ھ���";
	public static final int DEF_PUB = 0;
	public static final String DEF_ISBN = "0000000000123";
	public static final String NO_COMMENT = "��۾���";
	
	// ���� �ʵ�(�������) // v1.0
	// public ���� �����ϸ� ��Ű���� �ٸ� Ŭ���������� ��밡����.
	public int no; // ��ȣ numeric order
	public String bookTitle; // ����
	public String bookGenre; // �о�(�帣)
	public String bookAuthor; // ����(�̸�)
	public int bookPages; // �ʼ�
	public int bookPrice; // ����
	// ��Ű�� �����... // v1.1
	public int publisher; // ���ǻ� (��ȣ)
	public String ISBN; // ���ڵ�/���� ǥ�� ������ȣ(�ε��� 13�ڸ�.)
	public float rate; // ���� 5������ ô�� 0.0 ~ 5.0 
	public String comment; // �ڸ�Ʈ
	
	// ������ �Լ� ���� Ŭ������ �̸��� �����ϸ鼭 �ݵ�� new�� ȣ��Ǵ� �Լ��� 
	// ������ �޸��� ��ü�� �ʵ���� �ʱ�ȭ�ϴ� ��Ȱ)
	// Ŭ������ Ư�� ��ü�� �����Ҷ� ���� �� �ѹ��� ȣ���..
	// ������ �Լ��� �������� ���� ������ 
	// ������ �Լ��� �ݵ�� ���� �� �ʱ�ȭ�� ��ģ ��ü�� �ּҸ� ���������� ������
//	public MyBook() { // ���� ������ �Լ� (dummy) - �⺻ ������
		// 
		// Ŭ������ new�� ������� ������ ��ü�� �� �ʵ����� �⺻������ �ڵ��ʱ�ȭ�� 
		// ������ 0 long 0L �Ǽ��� 0.0 float 0.0F ������ \0
		// ���� false ���۷�����(Ŭ������, �迭��)null�� �ʱ�ȭ
		
//	}
	
	public MyBook() { // �⺻������..
		bookTitle = DEF_TITLE;
		bookAuthor = DEF_AUTHOR;
		bookGenre = DEF_GENRE;
		bookPrice = DEF_PRICE;
		publisher = DEF_PUB;
		ISBN = DEF_ISBN;
		comment = NO_COMMENT;
		rate = 0.0f;
		no = 0;
		bookPages = 0;
		System.out.println("1�� MyBook() ������ �����");
	}
	
	// �߰� ���� ������ - 5���� ����
		public MyBook(String bookTitle, String bookAuthor, String bookGenre,
				int bookPages, int bookPrice) {		
			this.bookTitle = bookTitle;
			this.bookAuthor = bookAuthor;
			this.bookGenre = bookGenre;
			this.bookPages = bookPages;
			this.bookPrice = bookPrice;
			this.no = 0;
			this.publisher = DEF_PUB;
			this.rate = 0.0f;
			this.ISBN = DEF_ISBN;
			this.comment = NO_COMMENT;
					
			System.out.println("2�� MyBook() ������ �����");
		}
	
	// Ǯ ���� ������ full 
	public MyBook(String bookTitle, String bookAuthor, String bookGenre,
			int bookPages, int bookPrice, int no, int publisher,
			float rate, String ISBN, String comment ) {
//		bookTitle = bookTitle; // ���ں��� = ���ں��� ����?
		// �̸��� �浹? ���������� �ʵ�� ������ �ȵ�?
//		this ��ü �ڱ� �ڽ��� �ּ� ��ü�� ǥ���ϴ°�
		// this.ooo�� ��� �ʵ�� ��� �޼ҵ�(�Լ�)�� ������ �� ����
		// this.ABC�� �׳� ABC�� �ٸ� �̸� �̸�����(namespace)
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookPages = bookPages;
		this.bookPrice = bookPrice;
		this.no = no;
		this.publisher = publisher;
		this.rate = rate;
		this.ISBN = ISBN;
		this.comment = comment;
		System.out.println("3�� MyBook() ������ �����");
	}
	
	
	// ������ �Լ� �����ε�  ��� �ʵ� (FULL) Ǯ������
//	public MyBook(String newTitle, String newAuthor, String newGenre,
//			int newPages, int newPrice, int newNo, int newPublisher,
//			float newRate, String newISBN, String newComment ) {
//		bookTitle = newTitle;
//		bookAuthor = newAuthor;
//		bookGenre = newGenre;
//		bookPages = newPages;
//		bookPrice = newPrice;
//		no = newNo;
//		publisher = newPublisher;
//		rate = newRate;
//		ISBN = newISBN;
//		comment = newComment;
//	}
	
	
	
	
	// ��ü�� �� �ʵ带 �⺻ �ʱ�ȭ�ϴ� �Լ� ( ��ü �ʱ�ȭ�Լ�)
	public void init() {
		bookTitle = "�ڹٰ� ���� ������!";
		bookAuthor = "���ӽ� ����";
		bookGenre = DEF_GENRE;
		bookPages = 500;
		bookPrice = DEF_PRICE;
		no = 1;
		publisher = 5;
		rate = 4.12f;
		ISBN = "987654321011";
		comment = "���� �ʾҾ��....";
	}
	
	
	//�ʵ� �Է��� ��� �޾Ƽ� ��ü�� �ʱ�ȭ�ϴ� �Լ�
	// �Լ� �����ε� ������ -- �Լ� ȣ��� ������ ������ Ÿ������ 
	// �ش� �Լ� ���Ǹ� ����)
	public void init(String newTitle, String newAuthor, String newGenre,
			int newPages, int newPrice, int newNo, int newPublisher,
			float newRate, String newISBN, String newComment ) {
		bookTitle = newTitle;
		bookAuthor = newAuthor;
		bookGenre = newGenre;
		bookPages = newPages;
		bookPrice = newPrice;
		no = newNo;
		publisher = newPublisher;
		rate = newRate;
		ISBN = newISBN;
		comment = newComment;
	}
	
	
	// ��ü�� �� �ʵ� ���� ��� �޼ҵ�(�Լ�)
	// ��� ǥ��(�޼ҵ�, ����Լ�)
	public void printBook() {
		System.out.println("BOOK" + no);
		System.out.println("\t ����: " + bookTitle);
		System.out.println("\t �о�: " + bookGenre);
		System.out.println("\t ����(������): " + bookPrice + "won");
		System.out.println("\t ����: " + bookAuthor + "��");
		System.out.println("\t �ʼ�: " + bookPages + "PP");
		System.out.println("\t ���ǻ� ��ȣ : " + publisher);
		System.out.println("\t ISBN : " + ISBN);
		System.out.println("\t ����: " + rate);
		System.out.println("\t ���� �ڸ�Ʈ: " + comment);
		System.out.println("---------------------------------------");
	
	}
	
	

}
