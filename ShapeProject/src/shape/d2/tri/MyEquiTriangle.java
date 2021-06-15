package shape.d2.tri;

import shape.basic.MyPoint;
import shape.d1.MyLine;

/*
 *  > shape.d2.tri.MyEquiTriangle Ŭ����
  > 3���� ����(��)�� ���̰� �����ϰ� 3�� ������ ������ �������� (Ư��)
  - �ڽ��� ������ ǥ���ϴ� String shapeType "���ﰢ��"
 */
public class MyEquiTriangle extends MyTriangle{
	public static final String TR_NAME = "�� �ﰢ��";
	
	public String shapeType; // = TR_NAME ���⼭ �ʱ�ȭ ����
	
	private boolean isEquiTriangle() {
		return this.lnAB.getDistance() == this.lnBC.getDistance() 
			&& this.lnBC.getDistance() == this.lnCA.getDistance(); 
			
	}
	
	
	public void printEquiTriangle() {
		System.out.println(this.toString());
//		System.out.println(toString());
//		System.out.println(this); // toString �ڵ� ȣ��
	}
	
	@Override
	public String toString() {
		return "MyEquiTriangle [shapeType=" + shapeType + ", ptA=" + ptA + ", ptB=" + ptB + ", ptC=" + ptC + ", lnAB="
				+ lnAB + ", lnBC=" + lnBC + ", lnCA=" + lnCA + ", tag=" + tag + ", color=" + color + ", getArea()="
				+ getArea() + ", getPerimeter()=" + getPerimeter() + ", getAngleCA_AB()=" + getAngleCA_AB() + "]";
	}
	
	// ���� ������
	public MyEquiTriangle() { // ����Ŭ���� ������ �� ���� �����ڴ� �ʼ��� ����
		this.shapeType = shapeType;
	}
	public MyEquiTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC) {
		super(ptA, ptB, ptC);
		this.shapeType = shapeType;
	}

	// Ǯ������
	public MyEquiTriangle(MyPoint ptA, MyPoint ptB, MyPoint ptC, MyLine lnAB, MyLine lnBC, MyLine lnCA, String tag,
			String color, double area, double perimeter, double angleCA_AB, double angleAB_BC, double angleBC_CA,
			String shapeType) {
		super(ptA, ptB, ptC, lnAB, lnBC, lnCA, tag, color, area, perimeter, angleCA_AB, angleAB_BC, angleBC_CA);
		this.shapeType = shapeType;
	}
	
	
}
