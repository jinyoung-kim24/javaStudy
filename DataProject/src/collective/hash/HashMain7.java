package collective.hash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://ko.wikipedia.org/wiki/%EB%A7%88%EB%B8%94_%EC%BD%94%EB%AF%B9%EC%8A%A4
	������ ��ȸ���� ������ ĳ���� Hero�� 
	
	ĸƾ �Ƹ޸�ī, �丣, �����̴���, ������,
	 ��Ÿ��ƽ ��, ��ũ, ���̾� ��, �� ǻ��, 
	 ���� ��Ʈ������, ȣũ����, ���̵�, �۴ϼ�, 
	 �����, Ÿ�뽺, �� �Ҽ�, ��Ʈ ���̴�, 
	 ��Ʈ��, �׷�Ʈ? ������� ���� ������ �� ���� �� �˷��� �ִ�. 
 */

// ����/DC ���� ĳ���͵� ��Ű�� II 
//class NeoHero {
//	public static final String DC_TEAM = "_DC_";
//	public static final String MARVEL_TEAM = "_Marvel_";
//	
//	private String name; // �ݵ�� ������ �ʵ� (���� Ű)
//	private int ability;
//	private Date birthDay;
//	private String team; // ��Ű�� �ʵ� �߰�
//	
//	public NeoHero() {}
//	public NeoHero(String name) {
//		this(name, (int)(Math.random()*100)+1,
//				new Date());
//	}
//	public NeoHero(String name, String team) {
//		this(name, (int)(Math.random()*100)+1, 
//				new Date(), team);
//	}
//	public NeoHero(String name, int ability, Date birthDay) {
//		this(name, ability, birthDay, DC_TEAM);
//	}
//	
//	public NeoHero(String name, int ability, Date birthDay, String team) {
//		super();
//		this.name = name;
//		this.ability = ability;
//		this.birthDay = birthDay;
//		this.team = team;
//	}
//	@Override
//	public String toString() {
//		return "Hero [name=" + name 
//				+ ", �Ҽ���=" + team 
//				+ ", ability=" + ability + ", birthDay=" + birthDay + "]";
//	}
//	
//	
//	
//	public String getTeam() {
//		return team;
//	}
//	public void setTeam(String team) {
//		this.team = team;
//	}
//	public int getAbility() {
//		return ability;
//	}
//	public void setAbility(int ability) {
//		this.ability = ability;
//	}
//	public String getName() {
//		return name;
//	}
//	public Date getBirthDay() {
//		return birthDay;
//	}
//	
//	
//}

public class HashMain7 {

	public static void main(String[] args) {
		// �������� �� �̸����� �����Ͽ�(Ű) ���� �ؽø�
		// https://namu.wiki/w/%EB%A7%88%EB%B8%94%20%EC%BD%94%EB%AF%B9%EC%8A%A4/%EC%BA%90%EB%A6%AD%ED%84%B0
		// https://namu.wiki/w/DC%20%EC%BD%94%EB%AF%B9%EC%8A%A4/%EC%BA%90%EB%A6%AD%ED%84%B0%EC%99%80%20%ED%8C%80

//		HashMap<String, NeoHero> heroes = null;
		
		final String[] DC_HEROES = {  // 5
			"DC���۸�", "DC�������", "DC��Ʈ��", "DC����Ƹ�", "DC�����˽�Ÿ��" 	
		};
		final String[] MARVEL_HEROES = { // 7
			"MVĸƾ �Ƹ޸�ī", "MV�丣", "MV�����̴���", "MV������,",
			"MV�� �Ҽ�", "MV�׷�Ʈ", "MV����"
		};
		// 2���� �迭 = �迭�� �迭, (��Ұ� 1�����迭�� �迭)
		final String[][] HERO2d = { DC_HEROES, MARVEL_HEROES };
		
		// ���� ������ �̸� ����Ʈ (DC + Marvel) �ݶ�
		ArrayList<String> nameList = new ArrayList<String>();
		for (int i = 0; i < HERO2d.length; i++) { // 2
			for (int j = 0; j < HERO2d[i].length; j++) {
				nameList.add(HERO2d[i][j]); // ���� ���� ����
			}
		}
		
		// ���� ������ �̸�����Ʈ ���		
		for (String name : nameList) {
			System.out.println(name);
		}
		System.out.println("--------------------");
		
		// ���ø� �ϱ� (�������� ���� ��ȯ�ϱ�)
		for (int i = 0; i < 10; i++) {
			shuffleHeroList(nameList);
		}		
				
		for (String name : nameList) {
			System.out.println(name);
		}
		System.out.println("--------------------");
		
		// �������� �̸��� ��������Ʈ�� ���� ������ �غ�.
		// �� ������ ����Ʈ�� Ž���ϸ鼭 ������ü(NeoHero) �����Ͽ�
		// ��������Ʈ�� ����
		ArrayList<NeoHero> heroList = new ArrayList<>();
		for (String name : nameList) {
			String team = name.startsWith("DC") ?
					NeoHero.DC_TEAM : NeoHero.MARVEL_TEAM;
			NeoHero hero = new NeoHero(name, team);
			heroList.add(hero);
		}
		HashMap<String, NeoHero> heroes = new HashMap<>();
		// �̸� ����Ʈ�� ���� ����Ʈ�� �ϳ��� ��� ������ ǥ��.
		for (NeoHero hero : heroList) {
			heroes.put(hero.getName(), hero);
		}
		
		for (String name : nameList) {
			System.out.println(name + " hero => "
					+ heroes.get(name).getTeam() );
		}
		System.out.println("---------------------");
		
	}

	// ���ø� �Լ� ȣ�� �� ���� ���� ������ up!
	private static void shuffleHeroList(
			ArrayList<String> nameList) {
		final int SIZE = nameList.size();
		for (int i = 0; i < SIZE; i++) {
			int movePos = -1;
			do {
				movePos = (int)(Math.random()*SIZE);
			} while( movePos == i );
			String iName = nameList
				.set(i, nameList.get(movePos));
			nameList.set(movePos, iName); // ��ġ �¹ٲ�..
//			String iName = nameList.get(i);
//			String mName = nameList.get(movePos);
//			nameList.set(i, mName);
//			nameList.set(movePos, iName);
		}
	}

}