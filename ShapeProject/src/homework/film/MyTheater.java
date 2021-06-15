package homework.film;
import java.text.Format;
import java.util.Arrays;

import homework.film.MyMoive;



public class MyTheater {
	public static final String DEF_MOIVE = "�������.";
	public static final int DEF_AGE = 19;
	public String mtname;
	public String mtadress;
	public int theater;
	public MyMoive[] mtmoive;
	
	
	public MyTheater() {
		
	}

	public MyTheater(String mtname, String mtadress, int theater) {
		super();
		this.mtname = mtname;
		this.mtadress = mtadress;
		this.theater = theater;
		this.mtmoive = new MyMoive[theater];
	}
	
	
	public MyTheater(String mtname, String mtadress, int theater, MyMoive[] mtmoive) {
		super();
		this.mtname = mtname;
		this.mtadress = mtadress;
		this.theater = theater;
		this.mtmoive = mtmoive;
	}


	public void addMoiveToTheater() {
		int count = 0;
		for (MyMoive mv : mtmoive) {
			int level = (int) (Math.random() * 37) +4;
		System.out.println(++count + "." + mv.mvname + "\t" + mv.age + "�� =>" +
			(mv.age > level ? count + "���� ��ġ" : "��ġ ����"));
		}
		System.out.println(mtname + mtadress);
		int num = 0;
		for (MyMoive myMoive : mtmoive) {
			if(myMoive == null) {
				System.out.println("[" + (++num) + "��]" + DEF_MOIVE);
			}else {
				System.out.println("[" + (++num) + "��]" +
				"��ȭ:" + myMoive.mvname +
				" ��ȭ �帣:" + myMoive.mvgenre +
				" ��ȭ ����:" + myMoive.mvrate + "��");
			}
		}
	}
	
	public void printMyTheater() {
		System.out.println(mtname + mtadress);
		int count = 1;
		for (MyMoive myMoive : mtmoive) {
			if(myMoive == null) {
				System.out.println("[" + (count++) + "��]" + DEF_MOIVE);
			}else {
				System.out.println("[" + (count++) + "��]" +
				"��ȭ:" + myMoive.mvname +
				" ��ȭ �帣:" + myMoive.mvgenre +
				" ��ȭ ����:" + myMoive.mvrate + "��");
			}
		}
	}
	
	
}
