package shape.d2.tri;
/*
#### MyIsoTriangle �̵�ﰢ�� (isosceles ��üȭ �ﰢ��1)
> shape.d2.tri.MyIsoTriangle Ŭ���� (MyTriangle �ڽ�/����/�Ļ� Ŭ����)
> 2���� ����(��)�� ���̰� �����ϴٴ� �������� (Ư��)
- �ڽ��� ������ ǥ���ϴ� String shapeType "�̵ �ﰢ��"
*/

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

// ��� ���� ���ó���� �ſ� �ٸ�... �ڹٴ� ���� OOP�� ���� ���� ��Ӹ� ���� ������.
// ��, �ڽ� Ŭ������ ���� �� �ϳ��� �θ� Ŭ�������� ���� �� �ֽ��ϴ�. 
// x public class MyIsoTriangle  extends MyTriangle, MyRectangle {

// ��ӿ��� �θ���� private �ڿ����� �������� ���� ����. ������ ����� �����ϴ�.
// public �ʵ�/�޼ҵ�� �θ�Ŭ�������� ����� �ٷ� �ȴ�.

//public class MyIsoTriangle extends MyTriangle {
public class MyIsoTriangle extends MyTriangle {
	public String shapeType;// "�̵ �ﰢ��"
	
	// > 2���� ����(��)�� ���̰� �����ϴٴ� �������� (Ư��)
	// ������ �̵�ﰢ������ üũ�ϴ� ���� �Լ� true�� �̵��!
	private boolean isIsoTriangle() {
//		if(this.lnAB.getDistance() == this.lnBC.getDistance() 
//		|| this.lnBC.getDistance() == this.lnCA.getDistance() 
//		||	this.lnCA.getDistance() == this.lnAB.getDistance())
//			return true;
//		else {
//			return false;
//		}
		// ���׽�
		return this.lnAB.getDistance() == this.lnBC.getDistance() 
				|| this.lnBC.getDistance() == this.lnCA.getDistance() 
				||	this.lnCA.getDistance() == this.lnAB.getDistance();
	}
	
	
	public MyIsoTriangle() {
		//super(); // ������ ������.
		this.shapeType = "�̵ �ﰢ��"; 
	}
	
	// ��Ŭ������ �ڵ� toString
	@Override
	public String toString() {
		return "MyIsoTriangle [shapeType=" + shapeType + " ��ǰ����?" + (this.isIsoTriangle() ? " �̵ ����" : " ��¥!") + 
				", ptA=" + ptA + ", ptB=" + ptB + ", ptC=" + ptC + ", lnAB="
				+ lnAB + ", lnBC=" + lnBC + ", lnCA=" + lnCA + ", tag=" + tag + ", color=" + color + "]";
	}
	
	
	public void printIsoTriangle() {
		System.out.println(TYPE + " " + this);
	}
	

	// ��Ŭ������ �ڵ����� ������ ����
	public MyIsoTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
			String color, double area, double perimeter, double angleCA_AB, double angleAB_BC, double angleBC_CA,
			String shapeType) {
		super(ptA, ptB, ptC, lnAB, lnBC, lnCA, tag, color, area, perimeter, angleCA_AB, angleAB_BC, angleBC_CA);
		this.shapeType = shapeType;
	}






	public MyIsoTriangle(MyPoint[] pts) {
		super(pts[0], pts[1], pts[2]);
		this.shapeType = "�̵ �ﰢ��";
	}
	
	public MyIsoTriangle(int x1, int y1,
			int x2, int y2, int x3, int y3, String name) {
		super(new MyPoint(x1, y1), new MyPoint(x2, y2), new MyPoint(x3, y3));
//		this(new MyPoint(x1, y1), new MyPoint(x2, y2), new MyPoint(x3, y3));
//		this.shapeType = name;
	}
	
	
//	public MyIsoTriangle(int x1, int y1,
//			int x2, int y2, int x3, int y3, String name) {
////		super(); // MyTriangle2()
//		this.ptA = new MyPoint(x1, y1);
//		this.ptB = new MyPoint(x2, y2);
//		this.ptC = new MyPoint(x3, y3);
//		this.lnAB = new MyLine(ptA, ptB);
//		this.lnBC = new MyLine(ptB, ptC);
//		this.lnCA = new MyLine(ptC, ptA);
//		this.color = MyShape.COLOR_BLACK;
//		this.tag = MyShape.EMTPY_TAG;
////		this.area = 0.0; // ?
////		this.perimeter = 0.0; // ?		
//		//
//		this.shapeType = name;
//	}
	
	public MyIsoTriangle(MyPoint ptA, 
			MyPoint ptB, MyPoint ptC) {
		// this. ��ü �ڽ� �ȿ� �ִ� �ʵ�/�޼ҵ� ����
		// this() �ٸ� �����ڸ� ȣ���Ͽ� �ʱ�ȭ ����
		//this.shapeType; // �ڽ� ��ü���� ��
		//super.shapeType; // �ڽ� Ŭ�������̰�, �θ� Ŭ�������� �ƴ϶�..
		//super(); // �θ�Ŭ����  MyTriangle() ������ ȣ��..
		//super(); // �ڵ�ȣ��..
		super(ptA, ptB, ptC); 
			// �θ�Ŭ������ �����ִ� ��� �ʵ� �ʱ�ȭ�� ���� ����
			// �θ�Ŭ����  MyTriangle(ptA, ptB, ptC) ������ ȣ��..
		this.shapeType = "�̵ �ﰢ��"; // �ڽ�Ŭ���� �ʵ常 ������ �ʱ�ȭ
//		this.ptA; // private -> public 
//		this.lnAB; // private -> public
		//MyPoint p = this.ptA; // �ڽ� ��ü���� �θ�ü�� protected �ʵ忡 ���� (���)
		
		//this.getLnAB()??
		//super(ptA, ptB, ptC); // �θ�Ŭ������ �����ڸ� ȣ���Ͽ� �ʱ�ȭ.
	}
}
