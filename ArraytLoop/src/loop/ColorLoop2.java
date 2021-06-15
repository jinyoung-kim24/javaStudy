package loop;

public class ColorLoop2 {

	public static final int COLOR_BLACK = 1;
	public static final int COLOR_WHITE = 2;
	public static final int COLOR_RED = 3;
	public static final int COLOR_GREEN = 4;
	public static final int COLOR_BLUE = 5;
	public static final int COLOR_YELLOW = 6;
	public static final int COLOR_PURPLE = 7;
	public static final int COLOR_CYAN = 8;
	public static final int COLOR_NAVY = 9;
	public static final int COLOR_ORANGE = 0x0A; //10;
	public static final int COLOR_BROWN = 0x0B; //11;
	public static final int COLOR_PINK = 0x0C; //12;
	public static final int COLOR_GOLD = 0x0D; // 13;

	
	public static void main(String[] args) {
		// �迭 Array
		// ������ Ÿ���� �����͸� �ټ��� �������� �������� �ʿ���.
		// ������ Ÿ���� �ټ� �����͵��� �� �ϳ��� �迭������ ��� ǥ����.
		// �迭�� �� �ϳ��� ��ǥ �̸��� ����(Array Ÿ��)������ ����
		// �迭�� �� ���(element)���� Ÿ������ ������. 
		// �迭�� ��Ҹ� ���� �� �ִ� "�޸� ����"��.
		//String[] colors; // ���ڿ� �������� ���� �迭���� colors ����.
		//String []colors;
		//String colors[]; // ��ǥ�̸� colors�� �迭�� ����.
		//String[] colors = {}; // �迭 �ʱ�ȭ -- empty array �� �迭
		// �迭 ���� ���� �� �ʱ�ȭ
		String[] colors = {
			"black", "white", "red", "green",  // 0, 1, 2, 3
			"blue", "yellow", "purple", "cyan", // 4, 5, 6, 7
			"navy", "orange", "brown", "pink", // 8, 9, 10, 11 
			"gold"  						   // 12	
		};
		// �迭�� ������(���)�� �� 13���� �迭�� ����.
		// �迭�� ������, �� �� ��ҿ� ���� ������ �ݵ�� ������ȣ(index)�� �ؾ���.
		// �ڹ��� �迭 �ε���, �� ������ȣ�� 0���� �����Ͽ� ������ �ε��� N-1.
		// ��, ������ ������ȣ�� �迭�� �ѿ�Ұ��� - 1��.
		// �迭�� ũ�� (����) = ����� �� ���� = �迭��.length
		// �迭�� �ѹ� ���ǵǸ� �� ��Ұ����� ���� ���� �� ����.
		
		// �÷� �迭�� �̿��Ͽ� ������ ������ȣ��� �÷��̸��� ������.
		//int ranCr = (int)(Math.random() * 13); // 0 ~ 12
//		int ranCr = (int)(Math.random() * colors.length); 
//					// 0 ~ length-1
//		String ranColor = colors[ranCr];
//		System.out.printf("�����÷�[%d] = %s \n", 
//					ranCr, ranColor);
		int ranCr = (int)(Math.random() * colors.length) + 1;
					// 1 ~ 13
		
//		if( ranCr > COLOR_BLUE ) // YELLOW 6 ~ GOLD 13
//			System.out.println("���� ó�� ���ϴ� �÷�!");
//		else
//			System.out.println(colors[ranCr-1]); 
//			// �迭�� �� ������ ��� �߿� �ϳ��� ������. == ���ߺб⹮?
		
		if( ranCr <= COLOR_BLUE ) 
			System.out.println(colors[ranCr-1]);
		else				
			System.out.println("���� ó�� ���ϴ� �÷�!");
					
//		switch(ranCr) {
//			case COLOR_BLACK: 
//				//System.out.println("black"); break;
//				//System.out.println(colors[0]); break;
//				System.out.println(colors[COLOR_BLACK-1]); break;
//			case COLOR_WHITE: 
//				//System.out.println("white"); break;	
//				//System.out.println(colors[1]); break;
//				System.out.println(colors[COLOR_WHITE-1]); break;
//			case COLOR_RED: 
//				//System.out.println("red"); break;	
//				//System.out.println(colors[2]); break;
//				System.out.println(colors[COLOR_RED-1]); break;
//			case COLOR_GREEN: 
//				//System.out.println("green"); break;
////				System.out.println(colors[3]); break;
//				System.out.println(colors[COLOR_GREEN-1]); break;
//			case COLOR_BLUE: 
////				System.out.println("blue"); break;
////				System.out.println(colors[4]); break;
//				System.out.println(colors[COLOR_BLUE-1]); break;
//			default: // COLOR_YELLOW 6 ~ GOLD 13
//				System.out.println("���� ó�� ���ϴ� �÷�!");
//				//break;
//		}
	}

}

/*
colors.length = 13
ù��° color[0] = black
������ color[12] = gold
�÷� �̸�: black
�÷� �̸�: white
�÷� �̸�: red
�÷� �̸�: green
�÷� �̸�: blue
�÷� �̸�: yellow
�÷� �̸�: purple
�÷� �̸�: cyan
�÷� �̸�: navy
�÷� �̸�: orange
�÷� �̸�: brown
�÷� �̸�: pink
�÷� �̸�: gold
0�� �÷� �̸�: black 
1�� �÷� �̸�: white 
2�� �÷� �̸�: red 
3�� �÷� �̸�: green 
4�� �÷� �̸�: blue 
5�� �÷� �̸�: yellow 
6�� �÷� �̸�: purple 
7�� �÷� �̸�: cyan 
8�� �÷� �̸�: navy 
9�� �÷� �̸�: orange 
10�� �÷� �̸�: brown 
11�� �÷� �̸�: pink 
12�� �÷� �̸�: gold 
*/ 
