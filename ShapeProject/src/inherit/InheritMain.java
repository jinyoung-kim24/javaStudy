package inherit;
// ��� ����...
// ���뼺�� �ش�ȭ�� ���

// 0���� Objeect ��� Ŭ������ �ְ��� ���� (�׻� �⺻ ��ӵǾ� ����)

// 1���� Ŭ���� Object > parent
class Parent {
	String name;
	public Parent() {
		name = "�θ�";
	}
	public Parent(String name) {
		super();
		this.name = name;
	}	
	public void printName() {
		System.out.println("�̸�: " + this.name);
	}	
	
	// ����, ����, ������ ���� ��� �Լ�����
	public void printCommon() {
		this.printName();
	}
}
// �ڽ�, �Ļ�, ����Ŭ���� <= �θ�, ���� Ŭ����
// 2���� Ŭ���� Object > parent > Child
class Child extends Parent {
	public int age;
	
	public Child() {}
	public Child(int age){
		this.age = age;
		this.name = "����";
	}
	public Child(String name){
		this.age = 18; // �ڽ� ���� �ʵ� �ʱ�ȭ
		this.name = name; // �θ�Ŭ������ ������ �ʵ带 �ʱ�ȭ
	}
	public Child(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	// �ڽ��� ���� ���
	public void printAge() {
		System.out.println("����: " + this.age + "��");
	}
	
	// ����, ����, ������ ���� ��� �Լ�����
	// ���ٶ��̵�
	@Override
	public void printCommon() {
		this.printName();
		this.printAge();
	}
	
}

// 3���� Ŭ���� Object > parent > Child > MoneyChild
class MoneyChild extends Child{
	public static final int DEF_MONEY = 10000;
	private int money;
	
	public MoneyChild() {
		this.name = "����";
		this.age = 16;
		this.money = DEF_MONEY;
	}
	
	public MoneyChild(int money) {
		this.name = "����";
		this.age = 16;
		this.money = money;
	}

	public MoneyChild(int age, String name, int money) {
		this.name = name; // �θ��� �θ� �ʵ� �ʱ�ȭ
		this.age = age; // �θ� �ʵ� �ʱ�ȭ
		this.money = money; // �� �ʵ� �ʱ�ȭ
//		super(age, name);
//		this.money = money;
	}
	
	public void printMoney() {
		System.out.println("�� ���ƿ�..." + this.money + "��");
	}
	
	@Override
	public void printCommon() {
		this.printName();
		this.printAge();
		this.printMoney();
	}
}
// 3���� Ŭ���� Object > parent > Child > BookChild
class BookChild extends Child{
	private Book book;
	private double score;
	
	public BookChild() {
		this.name = "����";
		this.age = 12;
		this.score = 3.0;
		this.book = new Book("�ΰ��� ���ؼ�", "����");
	}

	public BookChild(int age, String name, Book book, double score) {
//		super(age, name);
		this.name = name;
		this.age = age;
		this.book = book;
		this.score = score;
	}
	
	public void printMyBook() {
		System.out.print("��å: ");
		this.book.printBook();
	}
	
	public void printScore() {
		System.out.println("����: " + score);
	}
	
	@Override
	public void printCommon() {
		this.printName();
		this.printAge();
		this.printScore();
		this.printMyBook();
	}
}
// 3���� Ŭ���� Object > parent > Child > FoodChild
class FoodChild extends Child{
	
}
public class InheritMain {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.name = "����";
		p1.printCommon();
//		p1.printName();
		Parent p2 = new Parent("�ƺ�");
		p2.printCommon();
//		p2.printName();
//		p2.printAge(); // x
		
		Child c1 = new Child();
		c1.name = "��";
		c1.age = 12;
//		c1.printName();
//		c1.printAge(); // extends Ȯ�� ���? o
		c1.printCommon();
		
		Child c2 = new Child("�Ƶ�");
		c2.printCommon();
		
		Child c3 = new Child(4, "���� ������");
		c3.printCommon();
		
		MoneyChild m1 = new MoneyChild();
		m1.printCommon();
		
		MoneyChild m2 = new MoneyChild(50000);
		m2.printCommon();
		
		MoneyChild m3 = new MoneyChild(20, "�Ϸ� �ӽ�ũ", 200000000);
		m3.printCommon();
		
		BookChild b1 = new BookChild(17, "�̼�", new Book("�̼��̾߱�", "�̼�"), 5.0);
		b1.printCommon();
	}

}
