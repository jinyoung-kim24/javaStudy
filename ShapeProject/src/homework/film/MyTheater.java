package homework.film;
import java.text.Format;
import java.util.Arrays;

import homework.film.MyMoive;



public class MyTheater {
	public static final String DEF_MOIVE = "비어있음.";
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
		System.out.println(++count + "." + mv.mvname + "\t" + mv.age + "세 =>" +
			(mv.age > level ? count + "관에 배치" : "배치 안함"));
		}
		System.out.println(mtname + mtadress);
		int num = 0;
		for (MyMoive myMoive : mtmoive) {
			if(myMoive == null) {
				System.out.println("[" + (++num) + "관]" + DEF_MOIVE);
			}else {
				System.out.println("[" + (++num) + "관]" +
				"영화:" + myMoive.mvname +
				" 영화 장르:" + myMoive.mvgenre +
				" 영화 평점:" + myMoive.mvrate + "점");
			}
		}
	}
	
	public void printMyTheater() {
		System.out.println(mtname + mtadress);
		int count = 1;
		for (MyMoive myMoive : mtmoive) {
			if(myMoive == null) {
				System.out.println("[" + (count++) + "관]" + DEF_MOIVE);
			}else {
				System.out.println("[" + (count++) + "관]" +
				"영화:" + myMoive.mvname +
				" 영화 장르:" + myMoive.mvgenre +
				" 영화 평점:" + myMoive.mvrate + "점");
			}
		}
	}
	
	
}
