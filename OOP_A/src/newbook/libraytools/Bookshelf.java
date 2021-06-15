package newbook.libraytools;
// �ű� ��Ű��(����)
// - ����, å����, å����, å��.. , �Ͻ��ĵ�
// .. å ���뷮(����), ����, ũ��(��޼�),
// .. �Ϸù�ȣ(����), ��ġ����(��), �󺧽�ƼĿ??, ī�װ�
// + ���� ��¥, ������, ����, ����ڻ缭��
// ���:
//		å�� ��ġ�� �� �ִ� (å�迭�ʵ忡 �ϳ��� ��Ұ���(slot)�� å ��ü �߰�) 
//		å���� ������ ���������� ����Ҽ� �ִ�
//	 	������ ���� å �ϳ��� ���� �� �ִ�
// 		å�� �ϳ� ���� �� ���ִ�
//		��� å�� �� �����ִ�. 
//		å������ ����(���� ���뷮)�� Ȯ�� �� �� �ִ�.(�� �����, �Ϻ� ���������)
//		��� ��ä���� ����(�� �̻� �ű� å�� ��ġ�� �� ���� ����)
 import newbook.Book;

public class Bookshelf {
	public static final int DEF_SIZE = 4; // �ּ� 4�Ǻ��� �����ؾ� ������ å���� �ڰ��� ����.
	public static final Book EMPTY = null; // å�� �� �迭�� ��ĭ ǥ��
	// ���� �ʵ�
	public int no; // �Ϸù�ȣ(����)
	public String label; // �󺧽�ƼĿ??, ī�װ�, ����
	public int floor; // �� ��ȣ
	public int size; // å ���뷮 ����(volume)
	public Book[] books; // ���� å���� ��ġ�� ���� Ȯ�� .. �迭Ÿ�� �ʵ�
	// å���� ����� �ִ�? ��� ǥ�� ó���� å���� ������ ������ �����?

	// �⺻ ������
	public Bookshelf() {
		// �ʵ� ���� �ڽ��� �⺻������ �ڵ��ʱ�ȭ��
	}

	// �߰� �����ڵ�
	public Bookshelf(int no, String label, int floor) {
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = DEF_SIZE;
		this.books = new Book[this.size]; // size�� 4 ~ 100? ��������
		// ������ 4¥�� ���� �迭�� ���� �޸� Ȱ��...
		// this.books = new Book[]{ EMPTY, EMPTY, EMPTY, EMPTY};
	}

	// å���� ũ�⸸ ����ϸ� ������ ���ο��� å���� ������ �迭�������� ����Ȯ��.
	// ������ ���ذ� �����.
	public Bookshelf(int no, String label, int floor, int size) {
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = size;
		this.books = new Book[size]; // size�� 4 ~ 100? ��������
		// books�� å��ü���� �ټ��� ��, size������ŭ �ִ��� ��ġ�� �� �ִ�
		// å�尴ü�� ������ �迭�� ǥ��.
		// �迭 ���� �ʵ� books ��ü�� ���۷������̶� �ݵ��
		// �� �ѹ��� new�� ����ó���� �ؾ� ��μ� ������ ���´�.
		// �׸��� �� �迭�� ��� ���� ��δ� ���� null�� �ʱ�ȭ��
	}

	// Ǯ������
	// �ܺο��� å���� ��ġ�� ������ �迭�� '�̸�' ���� ������ å���� �ʱ�ȭ
	public Bookshelf(int no, String label, int floor, int size, Book[] books) {
		this.no = no;
		this.label = label;
		this.floor = floor;
		this.size = size;
		this.books = books;
	}
	
	// å�� �� å�� ��� �������
	public void cleanBookshelf() {
		// å��� �迭 ������ ��� null�� EMTPY�� ä��(������ ����)
		for (int i = 0; i < books.length; i++) {
			books[i] = EMPTY;
		}
//		for(Book bk : books) { // ������� ���� 
//			bk = EMPTY;
//		}
		System.out.println(">> å���� �� ��������!! (" + size + ")�� ���� Ȯ��");
	}
	
	
	// �Լ� �����ε�
	public void printBookshelf(boolean detail) {
		System.out.println("��������������������������������������������������");
		System.out.println(this.no + "�� å��:: <" + floor + ">��");
		System.out.println("\t ���̺�: " + label);
		System.out.println("\t ���� ���뷮: " + this.size + "~�Ǳ��� ����");
		System.out.println("��������������������������������������������������");
		int slot = 0;
		for (Book book : this.books) {
			System.out.print("[" + (++slot) + "]");
			// å���� �̹� ȸ�� ���� ������ å�� ����?
			if (book == EMPTY) {
				System.out.println("---- slot ����� ----");
			} else {
				System.out.println(detail ? "BKNUM::" + book.no : "");
				System.out.print(book.title);
				System.out.print(" [" + book.author + " ]");
				System.out.print("����:" + (detail == true && book.stamp ? "�ݲ�reg" : "����"));
				System.out.print(detail == true ? book.comment : "");
				System.out.println(book.getStarRating3());
			}
		}
		System.out.println("��������������������������������������������������");
	}
	
	// å�� ���� ������ϱ� - å�� �� �迭������ ��ġ�� å��ü���� �������� ǥ��
	public void printBookshelf() {
		System.out.println("��������������������������������������������������");
		System.out.println(this.no + "�� å��:: <" + floor + ">��");
		System.out.println("\t ���̺�: " + label);
		System.out.println("\t ���� ���뷮: " + this.size + "~�Ǳ��� ����");
		System.out.println("��������������������������������������������������");
		int slot = 0;
		for (Book book : this.books) {
			System.out.print("[" + (++slot) + "]");
			// å���� �̹� ȸ�� ���� ������ å�� ����?
			if (book == EMPTY) {
				System.out.println("---- slot ����� ----");
			} else {
				System.out.print(book.title);
				System.out.print(" [" + book.author + " ]");
				System.out.println(book.getStarRating3());
			}
		}
		System.out.println("��������������������������������������������������");
	}
	// å�� ���� ��������ϱ�
	
	// å�� �ϳ��� ��ġ�� �� �ִ�.(å�迭 �ʵ忡 �ϳ��� ��� ���� (slot)�� å ��ü
	// �������, �ڵ����?
	// �ΰ�üå, �帣����ġ å, ���Թ�ȣ ������, ������ ��밡��? empty?
	public boolean addBook(int slot, Book book) {
		if(book == null) {
			System.out.println("å�忡 ���� å ��ü�� �����. null");
			return false;
		} // �ּ� 1�� �̻��� ���뷮�� ����Ǹ� ���� ����..
		if(this.isFull() == true) {
			System.out.println("�ش� å���� �ִ���뷮" + this.size + "�� �̹� �����Ͽ��� �� �̻� ��ġ ����!!");
			return false;
		}
		if(slot >= 0 && slot <= this.size - 1) {	
			if(this.books[slot] == EMPTY) {
				// �����ϰ� å ��ġ ���� ����?
				books[slot] = book; // å���� ĭ�� å �ֱ�
				return true;
			}else {
				Book anotherBook = this.books[slot];
				System.out.println("�ش� ������ �̹� �����(�ٸ�å: " + anotherBook.title + ")");
				return false;
			}
		}else {
			System.out.println("���� ��ȣ�� ������ ��� ����!!" + slot + " / " + size);
			return false;
		}
		
	}
	// ��� �� ä���� ����(�� �̻� �ű� å�� ��ġ �� �� ���� ����..)�� üũ�ϱ�
	public boolean isFull() {
		for (int i = 0; i < books.length; i++) {
			if(books[i] == EMPTY) // ��ó�� ������ �� �ϳ��� ��ĭ�� FULL�� �ƴ�!!
			return false;
		}
		return true;
	}

}
