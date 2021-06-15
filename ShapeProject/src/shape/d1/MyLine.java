package shape.d1;

import shape.MyShape;
import shape.basic.MyPoint;

/*
 * ### �� Line ��Ű��
 > shape.d1.MyLine
 > �� ��ǥ���� �̾��ִ� ������ ǥ�� �ϴ� �� ���� �մ� ������ ǥ��(��� ������ ���)
 > ���� ���� �ƴϸ�, �������� �ְ�, ������ ���� (������ => ����)
 - ������ ��ġ ����ü MyPoint sp // start point
 - ���� ��ġ ����ü MyPoint ep // end point
 - ���̸��±� ���ڿ�          String tag
 - ���� ����ǥ�����ν��� �÷�  String color (RGB �÷��ڵ� 16���� ���ڿ�)
 - ���� ���� stroke, border, types... int strokeType
 - ���� �β� ������...				   int width
 - ����: ����ü�� �̷�� �� �� ���̿� �ִܰŸ� (����) 
 		�Ǽ��� ��ġ�� double
 ���� ����
���� �Ǽ�
���� �Ǽ�
�ļ�
1�� �⼱
2�� �⼱
����, ��������� ���� �Ǽ�
��Ģ���� ���� ���ݼ�
 */
public class MyLine {
	// ��� �ʵ�
	public static final String TYPE = "�� LN";
	public static final int DEF_WIDTH = 1; // ���� �β� �����
	public static final int BOLD_WIDTH = 2;
	public static final int BOLDER_WIDTH = 4;
	// ���� ��輱Ÿ�� ���
	public static final String DEF_LINE_TAG = "�⺻��";
	// �����ʵ�
	private MyPoint sp; // start point
	private MyPoint ep; // end point
	// private Ŭ���� ���ο����� ���ǰԲ� ��ȣ(����)�Ǿ� �ܺο��� ���� ���� �ȵ�.
	public String tag; // ���� �̸��±� ���ڿ�
	public String color; // ������ ����ǥ�����ν��� �÷�
	public int strokeType; // ���� ���� 8����
	public int width; // ���� �β� ����
	private double distance; // ����: ����ü�� �̷�� �� �� ������ �ִܰŸ�(����)
	// ���� ������ �ִ� ���� �Ÿ��� ����ġ�ν� ���Ǿ����
	// Ŭ���� ���ο��� �� ��갪�� ���� �� ������ �� ����. �׷��� 
	// Ŭ���� �ܺο����� ���� ���� ���� �ִ� => getter�Լ��� ���� read-only field
	
	public double getDistance() {
		// ���⼭ ����ص� �˴ϴٸ�.... ������ ���� ���� ��� �Լ��� ���� ����� ����.
		this.measureDistance(); // RailWay ����
		return this.distance;
	}
	
	public double measureDistance(MyPoint sp, MyPoint ep) {	
		return 0.0;
	}
	
	// ���� ������ �ִ� �Ÿ� ��� ����(�˰���)
	private void measureDistance() {
		double dist = 0.0;
		// ��������, ��������, ��������^2, ��������^2
		// �� �����ŵ������ջ� = ��������^2 + ��������^2
		// ������(�����ŵ������ջ�) squre root
		int xDiff = ep.x - this.sp.x;
		int yDiff = ep.y - this.sp.y;
		int x2 = xDiff * xDiff;
		int y2 = yDiff * yDiff;
		int sumDiff = x2 + y2;
		dist = Math.sqrt(sumDiff);
		this.distance = dist;
	}
	
	// public �ʵ�� �б�/���Ⱑ �����ο�
	// private �ʵ�� �б�/���Ⱑ Ŭ���� ��ġ ���� ������.
	public MyPoint getStartPoint() {
		// ����, ����, ��ȣ, ����, �Ϻε����� ����...
		return this.sp; // private �ʵ带 public �޼ҵ带 ����Ͽ� ���� �� �ְ� �㰡��.
	}

	// ���� �Լ� getter method - �б����� �Լ�
	public MyPoint getEp() {
		this.ep.tag += " " + this.tag + "����ü�� ����";
		return this.ep;
	}

	// �ʵ� ����/������Ʈ/���� �Լ�
	public void updateStartPoint(MyPoint newSp) {
		if (newSp != null) {
			this.sp = newSp;
			this.measureDistance();
		} else {
			System.out.println("�Է� ����ü�� null!!");
		}
	}
	// ���� �Լ� setter method - �������� �Լ� (�������Լ�)
	public void setEp(MyPoint ep) {
		if(ep != null) {
			this.ep = ep;
			this.measureDistance();
		}
	}

	// �⺻ ������
	public MyLine() {
		this(new MyPoint(), MyShape.ORIGIN_PT);
//		this.sp = new MyPoint(); // ���� ������
//		this.ep = MyShape.ORIGIN_PT; // ���� ����
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	} // �⺻ ������

	// �߻� �����ڵ�
	// �������� ������ü�� �����ϰ� ������ü�� �Է¹޾Ƽ� �� ��ü ����
	// ���� ��ü �ϳ��� �ܺο��� �̹� NEW �ʱ�ȭ�� �ϼ��� ���� �Է� �ޱ�
	public MyLine(MyPoint ep) {
		this(MyShape.ORIGIN_PT, ep);
		// �� ����ü ���� �ƴ϶�� �ϰ�
//		this.sp = MyShape.ORIGIN_PT; // ���� ������
//		this.ep = ep; // ���� ����
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}

	// �������� ������ü�� �����ϰ� ������ü�� �Է¹޾Ƽ� �� ��ü ����
	// ���� ��ü�� ������ ��� ��ǥ ���� 2���� �Է¹޾� ������ ���ο��� ���� ��ü �ű� �����ϱ�
	public MyLine(int epx, int epy) {
		this(MyShape.ORIGIN_PT, new MyPoint(epx, epy));
		// �� ����ü ���� �ƴ϶�� �ϰ�
//		this.sp = MyShape.ORIGIN_PT; // ���� ������
//		this.ep = new MyPoint(epx, epy, "����", MyShape.COLOR_RED); // ���� ����
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}

	// �� �� ��ü���� �迭�� ��� �޾Ƽ� ����ü �ʱ�ȭ �ϱ�
	// �ܺο��� new �ʱ�ȭ�� ���� �� �� ��ü�� �Է¹���
	public MyLine(MyPoint[] pts) { // pts.length == 2����
//			this(sp, ep, DEF_LINE_TAG, color, strokeType, BOLDER_WIDTH, distance)
		this(pts[0], pts[1]); // ������ ��ġ�� this() ������ ����
		// pts�� null�� �ƴϰ� pts.length >= == 2
//			MyPoint psp = pts[0]; // null �ƴ�
//			MyPoint psp = pts[1]; // null �ƴ�
//			this.sp = pts[0]; this.ep = pts[1];
//			this.sp = pts[0]; // ���� ������
//			this.ep = pts[1]; // ���� ����
//			this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//			this.color = MyShape.COLOR_BLACK;
//			this.strokeType = ST_SOLID;
//			this.width = DEF_WIDTH;
//			this.distance = 0.0;
	}

	public MyLine(MyPoint sp, MyPoint ep, String tag) {
		this(sp, ep);
		this.tag = tag;
	}
	
	// �� �� ��ü���� ���� �޾Ƽ� ����ü �ʱ�ȭ �ϱ�
	// �ܺο��� new �ʱ�ȭ�� ���� �� �� ��ü�� �Է¹���
	public MyLine(MyPoint sp, MyPoint ep) {
		this(sp, ep, DEF_LINE_TAG, MyShape.COLOR_BLACK, MyShape.ST_SOLID, DEF_WIDTH, 0.0);
		// �� ����ü ��� ���� �ƴ϶�� �ϰ�
//		this.sp = sp; // ���� ������
//		this.ep = ep; // ���� ����
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}

	// �� ���� ����� ���� ��ǥ���� 4���� ���� �޾Ƽ� ����ü �ʱ�ȭ �ϱ�
	// ����ü�� ���� ���(����4��)�� �޾Ƽ�, ������ ���ο���
	// new �ʱ�ȭ�� ���� �����Ͽ� ������, ���� ��ü�� �����ؾ� ��.
	public MyLine(int x1, int y1, int x2, int y2) {
//		this.sp = new MyPoint(x1, y1); // ���� ������
//		this.ep = new MyPoint(x2, y2); // ���� ����
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
//		this(new MyPoint(x1, y1), new MyPoint(x2, y2));
		// this. (������) ��ü �ڽ��� �ּҸ� ����Ŵ
		// this() ������ ȣ��(���� ������ �� ��)
		this(new MyPoint(x1, y1), new MyPoint(x2, y2), DEF_LINE_TAG, MyShape.COLOR_BLACK, MyShape.ST_SOLID, DEF_WIDTH,
				0.0);
		// �ٸ� ������ (���⼱ full ������)�� ȣ���Ͽ� �ڽ��� �ʱ�ȭ �۾���
		// �����Ѵ�
		this.tag += "���ƿ�!!";

	}

	// Ǯ������ ( �ʱ�ȭ ������ �� �����ص� ������ ��¥ ������)
	public MyLine(MyPoint sp, MyPoint ep, String tag, String color, int strokeType, int width, double distance) {
		super();
		this.sp = sp;
		this.ep = ep;
		this.tag = tag;
		this.color = color;
		this.strokeType = strokeType;
		this.width = width;
//		this.distance = distance;
		this.measureDistance();
	}

	// ���� �Լ�

	// ��� �Լ�
	// @ annotation ������̼�.. �ΰ����?
	// @ Override ������̼��� �Լ� �տ� ������.
	// �� ������̼��� �ش� �Լ��� �θ� Ŭ������ ���� ������ �� ��������
	// �ش� �Լ��� ���� �޾Ƽ� �������� �� �ִ����� ���� üũ��.
	@Override
	public String toString() {
		return "MyLine [sp=" + sp + ", ep=" + ep + ", tag=" + tag + ", color=" + color + ", strokeType=" + strokeType
				+ ", width=" + width + ", distance=" + distance + "]";
	}

	public void printLine() {
		System.out.println(this); // toString() �ڵ�ȣ��
//		String line = this.toString();
//		System.out.println(line);
//		 this(); // this() �����ڴ� ������ �Լ� �ȿ�����  ȣ���. 

	}


}
