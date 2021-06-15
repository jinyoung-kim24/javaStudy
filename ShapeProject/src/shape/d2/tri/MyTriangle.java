package shape.d2.tri;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.basic.MyPoint;
import shape.d1.MyLine;

/*
##### MyTriange ��Ű�� (�Ϲݻﰢ��)
> shape.d2.tri.MyTriangle Ŭ����
> 2���� ���󿡼� 3���� ������ �����, Ȥ�� ������ ���� �̾����� ����� ��� ����Ǵ� ����� ����. 
- ��(vertex ������) 3��     	MyPoint a, b, c;
- ��(line ����) 3��		MyLine ab, bc, ca;
- �ﰢ���� �̸��±� ���ڿ� 		String tag
- �ﰢ�� ���� ������ ä���� �÷�	String color (RGB �÷��ڵ� 16���� ���ڿ�)
- ����: ���� (����) double area;
- ����: �ѷ� (���� = ��� ���е��� ������ ����) double perimeter; 
- ����: ������ (���а� ���� ������ ����, degree, radian; 
	���� AB�� ���� BC ������ ����) double angleAB_BC; 
 */
public class MyTriangle {
	// �ʵ�
	public static final String TYPE = "�ﰢ�� TA";
	protected MyPoint ptA; // rw ������ A ~ C
	protected MyPoint ptB; // rw
	protected MyPoint ptC; // rw
	protected MyLine lnAB; // read only ptA-ptB �����ϴ� ����
	protected MyLine lnBC; // r ptB-ptC �����ϴ� ����
	protected MyLine lnCA; // r ptC-ptA �����ϴ� ����
	public String tag;
	public String color;
	private double area; // r ����
	private double perimeter; // r �ѷ�
	private double angleCA_AB; // r A�� ����
	private double angleAB_BC; // r B�� ����
	private double angleBC_CA; // r C�� ����
	
	// ����(������)/ ����(������)
	// �ʵ���� ù���ڸ� �빮�ڷ� �ϰ� set, get�� ���̸� ��.
	// setter ����
	public void setPtA(MyPoint ptA) { // write
		this.ptA = ptA; // ���� �ƴ϶�� �ϰ�..
	}
	// getter ����
	public MyPoint getPtA() { // read
		return this.ptA;
	}
	
	// ��Ŭ���� setter/getter �ڵ� ����  shiht_alt_s
	public MyPoint getPtB() {
		return ptB;
	}
	public void setPtB(MyPoint ptB) {
		this.ptB = ptB;
	}
	public MyPoint getPtC() {
		return ptC;
	}
	public void setPtC(MyPoint ptC) {
		this.ptC = ptC;
	}
	public MyLine getLnAB() {
		return lnAB;
	}
	public MyLine getLnBC() {
		return lnBC;
	}
	public MyLine getLnCA() {
		return lnCA;
	}
	// �ﰢ���� ����(����) m^2 => �Ϲݻﰢ���� ���� ����
	// ����� ���� 
	// ������ ���� a, b, c��� �ϰ�
	// �ѷ��� ���� hp = (a + b + c) / 2.0
	// ���� sqrrt( hp * (hp-a) * (hp-b) * (hp-c) )
	public double getArea() {
		double hp = this.getPerimeter() / 2.0;
		double lnABDif = hp - this.lnAB.getDistance();
		double lnBCDif = hp - this.lnBC.getDistance();
		double lnCADif = hp - this.lnCA.getDistance();
		double area = Math.sqrt(hp * lnABDif * lnBCDif * lnCADif);
		this.area = area;
		return area;
	}
//	public double measureArea() {
//		
//	}
	// �ﰢ���� �ٱ��ѷ�
	// ���� (����)�� ������ ��
	public double getPerimeter() {
		return perimeter;
	}
	public double measurePerimeter() {
		double perimeter = this.lnAB.getDistance() + this.lnBC.getDistance() + this.lnCA.getDistance();
		this.perimeter = perimeter;
		return this.perimeter;
	}
	// ���� CA�� ���� AB�� ����Ǿ� �ִ� ������ A�� ���̿� �� ���� ���ϱ�
	// �ﰢ�Լ� ���� �߿��� '��2�ڻ��� ��Ģ'�� ������ �����ϸ� ������ ���Ҽ��ִ�
	// angleA = arccos(b^2 + c^2 - a^2) / (2 * b * c); 
	public double getAngleCA_AB() {
		double angleA = 0.0;
		// �������� ���ֺ��� ��(����)
		double a = this.lnBC.getDistance();
		double b = this.lnCA.getDistance();
		double c = this.lnAB.getDistance();
		double cosA = (b * b + c * c - a * a) / (2.0 * b * c);
		angleA = Math.acos(cosA);
		this.angleCA_AB = angleA;
		return angleCA_AB;
	}
	public double getAngleAB_BC() {
		return angleAB_BC;
	}
	public double getAngleBC_CA() {
		return angleBC_CA;
	}

	
	
	// ���� ������
	public MyTriangle() {
	
	}
	
	// �߰� �����ڵ�
	// ����ü 3�� �ܺο��� �ϳ��� �迭�� �޾Ƽ� �ﰢ�� �ʱ�ȭ �ϱ�
	// (�־��� 3�� ������� ������ ���� ��ü 3���� �������� new ����)
	// �迭�� ���̰� 3�̻��� �ƴϸ�.. ����!!
	public MyTriangle(MyPoint[] pts) {
		this(pts[0], pts[1], pts[2]);
//		this(pts[0], pts[1], pts[2], 
//				new MyLine(pts[0], pts[1], "�ﰢ�� ���� AB"),
//				new MyLine(pts[1], pts[2], "�ﰢ�� ���� BC"),
//				new MyLine(pts[2], pts[0], "�ﰢ�� ���� CA"));
	}
	
	
	// �ﰢ���� ������ 3���� ���� �̷�� ��ǥ������, 6���� ���� �޾Ƽ� �ʱ�ȭ
	// ������ ���ο��� ����ü 3���� �켱 ���� ��... ���߿�
	// �� ����ü�� �̿��Ͽ� ����ü 3���� �� ���� �ʱ�ȭ.
	public MyTriangle(int ptAX, int ptAY, 
			int ptBX, int ptBY,	int ptCX, int ptCY ) {
		this.ptA = new MyPoint(ptAX, ptAY, 
				"������ A", MyShape.COLOR_RED);
		this.ptB = new MyPoint(ptBX, ptBY, 
				"������ B", MyShape.COLOR_GREEN);
		this.ptC = new MyPoint(ptCX, ptCY, 
				"������ C", MyShape.COLOR_BLUE);
		this.lnAB = new MyLine(this.ptA, this.ptB); // �Ÿ�����
		this.lnAB.tag = "�ﰢ�� ���� AB";
		this.lnBC = new MyLine(ptB, ptC); // �Ÿ�����
		this.lnBC.tag = "�ﰢ�� ���� BC";
		this.lnCA = new MyLine(ptC, ptA); // �Ÿ�����
		this.lnCA.tag = "�ﰢ�� ���� CA";
		this.tag = MyShape.EMPTY_TAG;
		this.color = MyShape.COLOR_BLACK;
		this.area = 0.0;
		this.perimeter = 0.0;
		this.angleCA_AB = 0.0;
		this.angleAB_BC = 0.0;
		this.angleBC_CA = 0.0;
	}
	
	// ����ü 3�� �ܺο��� �޾Ƽ� �ﰢ�� �ʱ�ȭ �ϱ�
	// (�־��� 3�� ������� ������ ���� ��ü 3���� �������� new ����)
	public MyTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC) {
		this(ptA, ptB, ptC, 
				new MyLine(ptA, ptB, "�ﰢ�� ���� AB"),
				new MyLine(ptB, ptC, "�ﰢ�� ���� BC"),
				new MyLine(ptC, ptA, "�ﰢ�� ���� CA"));
//		this(ptA, ptB, ptC, new MyLine(ptA, ptB),
//			new MyLine(ptB, ptC), new MyLine(ptC, ptA));
//		this.lnAB.tag = "�ﰢ�� ���� AB";
//		this.lnBC.tag = "�ﰢ�� ���� BC";
//		this.lnCA.tag = "�ﰢ�� ���� CA";
		//
//		this.ptA = ptA;
//		this.ptB = ptB;
//		this.ptC = ptC;
//		this.lnAB = new MyLine(ptA, ptB); // �Ÿ�����
//		this.lnAB.tag = "�ﰢ�� ���� AB";
//		this.lnBC = new MyLine(ptB, ptC); // �Ÿ�����
//		this.lnBC.tag = "�ﰢ�� ���� BC";
//		this.lnCA = new MyLine(ptC, ptA); // �Ÿ�����
//		this.lnCA.tag = "�ﰢ�� ���� CA";
//		this.tag = MyShape.EMTPY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.area = 0.0;
//		this.perimeter = 0.0;
//		this.angleCA_AB = 0.0;
//		this.angleAB_BC = 0.0;
//		this.angleBC_CA = 0.0;
	}
	
	public MyTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC,
			MyLine lnAB, MyLine lnBC, MyLine lnCA) {
//		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
//			MyShape.EMTPY_TAG, MyShape.COLOR_BLACK,
//			0.0, 0.0, 0.0, 0.0, 0.0);
		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, 
				MyShape.EMPTY_TAG, MyShape.COLOR_BLACK);
	}
	
	public MyTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC,
			MyLine lnAB, MyLine lnBC, MyLine lnCA,
			String tag,	String color) {
		this(ptA, ptB, ptC, lnAB, lnBC, lnCA, tag, color,
			0.0, 0.0, 0.0, 0.0, 0.0);
//		super();
//		this.ptA = ptA;
//		this.ptB = ptB;
//		this.ptC = ptC;
//		this.lnAB = lnAB;
//		this.lnBC = lnBC;
//		this.lnCA = lnCA;
//		this.tag = tag;
//		this.color = color;
	}
		
	// Ǯ ������ shift + alt + s
	public MyTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
			String color, double area, double perimeter, double angleCA_AB, double angleAB_BC, double angleBC_CA) {
//		super();
		this.ptA = ptA;
		this.ptB = ptB;
		this.ptC = ptC;
		this.lnAB = lnAB;
		this.lnBC = lnBC;
		this.lnCA = lnCA;
		this.tag = tag;
		this.color = color;
		this.area = area;
		this.perimeter = perimeter;
		this.angleCA_AB = angleCA_AB;
		this.angleAB_BC = angleAB_BC;
		this.angleBC_CA = angleBC_CA;
	}
	
	@Override
	//public String toString(int a) {
	public String toString() {
		return "MyTriangle [ptA=" + ptA 
			+ ", ptB=" + ptB + ", ptC=" + ptC.toString() 
			+ ", lnAB=" + lnAB.toString() 
			+ ", lnBC=" + lnBC
			+ ", lnCA=" + lnCA + ", tag=" + tag 
			+ ", color=" + color 
			+ ", area=" + area + "m^2 ����"
			+ ", perimeter=" + perimeter + "m �ѷ�"
			+ ", angleCA_AB=" + angleCA_AB + "�� ����" 
			+ ", angleAB_BC=" + angleAB_BC + "�� ����"
			+ ", angleBC_CA=" + angleBC_CA + "�� ����"+ "]";
	}

	public void printTriange() {
		System.out.println(TYPE + " " +this.toString());
	}
	
}

/*
�ﰢ�� TA MyTriangle [ptA=�� PT(0,0) �±�: �п�[�÷�: FF0000] 
, ptB=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, ptC=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, lnAB=MyLine [sp=�� PT(0,0) �±�: �п�[�÷�: FF0000] 
, ep=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, tag=�ﰢ�� ���� AB, color=000000, strokeType=0, width=1, distance=181.10770276274835], lnBC=MyLine [sp=�� PT(180,20) �±�: ������û[�÷�: 00FF00] 
, ep=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, tag=�ﰢ�� ���� BC, color=000000, strokeType=0, width=1, distance=395.60080889704966], lnCA=MyLine [sp=�� PT(-200,-90) �±�: ���ٹ�[�÷�: 0000FF] 
, ep=�� PT(0,0) �±�: �п�[�÷�: FF0000] 
, tag=�ﰢ�� ���� CA, color=000000, strokeType=0, width=1, distance=219.31712199461307], tag=Ŀ�� ���ô� ����, color=000000, area=0.0m^2 ����, perimeter=0.0m �ѷ�, angleCA_AB=0.0�� ����, angleAB_BC=0.0�� ����, angleBC_CA=0.0�� ����]
*/