package homework.film;
import homework.film.MyTheater;
public class MyMoive {
	public static final String DEF_NAME = "�̸�����";
	public static final String DEF_GENRE = "�帣����";
	public static final String DEF_COMMENT = "�ڸ�Ʈ����";
	
	
	public int mvno;
	public String mvname;
	public String mvgenre;
	public int mvyear;
	public int mvpersons;
	public float mvrate;
	public String mvcomment;
	public int age;
	
	public MyMoive() {
		mvname = DEF_NAME;
		mvgenre = DEF_GENRE;
		mvcomment = DEF_COMMENT;
		age = MyTheater.DEF_AGE;
	}
	
	
	
	
	public MyMoive(String mvname, String mvgenre, int age) {
		super();
		this.mvname = mvname;
		this.mvgenre = mvgenre;
		this.age = age;
	}
	
	
	public MyMoive(String mvname, String mvgenre, int age, float mvrate) {
		super();
		this.mvname = mvname;
		this.mvgenre = mvgenre;
		this.age = age;
		this.mvrate = mvrate;
	}
	
	




	public MyMoive(String mvname, String mvgenre, int mvyear, int mvpersons, float mvrate, String mvcomment, int age) {
		super();
		this.mvname = mvname;
		this.mvgenre = mvgenre;
		this.mvyear = mvyear;
		this.mvpersons = mvpersons;
		this.mvrate = mvrate;
		this.mvcomment = mvcomment;
		this.age = age;
	}
	
	
	


	@Override
	public String toString() {
		return "MyMoive [��ȭ��ȣ:" + mvno + ", ��ȭ�̸�:" + mvname + ", ��ȭ�帣:" + mvgenre + ", �����⵵:" + mvyear
				+ ", ������:" + mvpersons + ", ����:" + mvrate + ", ����:" + mvcomment + "]";
	}


	public void printMyMoive() {
		
	}
	
	
	
	
}
