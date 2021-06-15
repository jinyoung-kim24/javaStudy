package inherit;
// 상속 개념...
// 재사용성을 극대화한 방법

// 0세대 Objeect 모든 클래스의 최고위 조상 (항상 기본 상속되어 있음)

// 1세대 클래스 Object > parent
class Parent {
	String name;
	public Parent() {
		name = "부모";
	}
	public Parent(String name) {
		super();
		this.name = name;
	}	
	public void printName() {
		System.out.println("이름: " + this.name);
	}	
	
	// 가문, 가계, 가보의 공통 출력 함수정의
	public void printCommon() {
		this.printName();
	}
}
// 자식, 파생, 서브클래스 <= 부모, 슈퍼 클래스
// 2세대 클래스 Object > parent > Child
class Child extends Parent {
	public int age;
	
	public Child() {}
	public Child(int age){
		this.age = age;
		this.name = "무명";
	}
	public Child(String name){
		this.age = 18; // 자식 고유 필드 초기화
		this.name = name; // 부모클래스가 물려준 필드를 초기화
	}
	public Child(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	// 자신의 고유 기능
	public void printAge() {
		System.out.println("나이: " + this.age + "세");
	}
	
	// 가문, 가계, 가보의 공통 출력 함수정의
	// 오바라이딩
	@Override
	public void printCommon() {
		this.printName();
		this.printAge();
	}
	
}

// 3세대 클래스 Object > parent > Child > MoneyChild
class MoneyChild extends Child{
	public static final int DEF_MONEY = 10000;
	private int money;
	
	public MoneyChild() {
		this.name = "무명";
		this.age = 16;
		this.money = DEF_MONEY;
	}
	
	public MoneyChild(int money) {
		this.name = "무명";
		this.age = 16;
		this.money = money;
	}

	public MoneyChild(int age, String name, int money) {
		this.name = name; // 부모의 부모 필드 초기화
		this.age = age; // 부모 필드 초기화
		this.money = money; // 내 필드 초기화
//		super(age, name);
//		this.money = money;
	}
	
	public void printMoney() {
		System.out.println("돈 많아요..." + this.money + "원");
	}
	
	@Override
	public void printCommon() {
		this.printName();
		this.printAge();
		this.printMoney();
	}
}
// 3세대 클래스 Object > parent > Child > BookChild
class BookChild extends Child{
	private Book book;
	private double score;
	
	public BookChild() {
		this.name = "무명";
		this.age = 12;
		this.score = 3.0;
		this.book = new Book("인간에 대해서", "규진");
	}

	public BookChild(int age, String name, Book book, double score) {
//		super(age, name);
		this.name = name;
		this.age = age;
		this.book = book;
		this.score = score;
	}
	
	public void printMyBook() {
		System.out.print("내책: ");
		this.book.printBook();
	}
	
	public void printScore() {
		System.out.println("점수: " + score);
	}
	
	@Override
	public void printCommon() {
		this.printName();
		this.printAge();
		this.printScore();
		this.printMyBook();
	}
}
// 3세대 클래스 Object > parent > Child > FoodChild
class FoodChild extends Child{
	
}
public class InheritMain {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.name = "엄마";
		p1.printCommon();
//		p1.printName();
		Parent p2 = new Parent("아빠");
		p2.printCommon();
//		p2.printName();
//		p2.printAge(); // x
		
		Child c1 = new Child();
		c1.name = "딸";
		c1.age = 12;
//		c1.printName();
//		c1.printAge(); // extends 확장 기능? o
		c1.printCommon();
		
		Child c2 = new Child("아들");
		c2.printCommon();
		
		Child c3 = new Child(4, "꼬마 여동생");
		c3.printCommon();
		
		MoneyChild m1 = new MoneyChild();
		m1.printCommon();
		
		MoneyChild m2 = new MoneyChild(50000);
		m2.printCommon();
		
		MoneyChild m3 = new MoneyChild(20, "일론 머스크", 200000000);
		m3.printCommon();
		
		BookChild b1 = new BookChild(17, "이숍", new Book("이솝이야기", "이솝"), 5.0);
		b1.printCommon();
	}

}
