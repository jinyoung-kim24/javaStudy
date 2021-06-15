package soeulmetrosubway;

import shape.basic.MyPoint;
import shape.d2.round.MyCircle;
// ����ö ���� ���� ��Ű�� Ŭ���� 
/* 
 	���̳� �� �������� ���� ǥ���� ����.
 	���� �̸�(��/��), ���� ������ȣ, ���� ����(�뼱�� ����)
 	���� ���� �뼱�� ������ȣ,
 	(�ֺ�����, �ⱸ ����, ���� �������, ����/�浵 ����.., ��������)
 */

//public class Station { // extends MyCircle { // ������� ǥ��
//MyCircle cc; // �ʵ�� ǥ��
public class Station extends MyCircle {
	public static final double DEF_ST_RADIUS = 20.0;
	public String stName; // ���� �̸�(��/��)
	public int stOrder;//���� ������ȣ
	public String stColor; // ���� ����(�뼱�� ����)
	public int stSubwayLineNumber;//  	���� ���� �뼱�� ������ȣ
	
	public Station() {
		//super(); // ȣ��
	}

	public Station(int ptX, int ptY, 
			String stName, int stOrder, String stColor,
			int stSubwayLineNumber) {
		super(ptX, ptY, DEF_ST_RADIUS);
		//
		this.stName = stName;
		this.stOrder = stOrder;
		this.stColor = stColor;
		super.color = stColor;
		this.stSubwayLineNumber = stSubwayLineNumber;
		super.tag = "<" + stName + ">��";
	}	
	
	public Station(MyPoint ptCenter, 
			String stName, int stOrder, String stColor,
			int stSubwayLineNumber) {
		super(ptCenter, DEF_ST_RADIUS); // MyCircle �θ� �ʱ�ȭ
//		super();
//		this.ptCenter = ptCenter;
//		this.radius = DEF_ST_RADIUS;
		this.stName = stName;
		this.stOrder = stOrder;
		this.stColor = stColor;
		this.stSubwayLineNumber = stSubwayLineNumber;
	}
	

	public Station(MyPoint ptCenter, double radius, 
			String stName, int stOrder, String stColor,
			int stSubwayLineNumber) {
		super(ptCenter, radius); // MyCircle �θ� �ʱ�ȭ
		this.stName = stName;
		this.stOrder = stOrder;
		this.stColor = stColor;
		this.stSubwayLineNumber = stSubwayLineNumber;
	}

	
	@Override
	public String toString() {
		return "Station [stName=" + stName + ", stOrder=" + stOrder + ", stColor=" + stColor + ", stSubwayLineNumber="
				+ stSubwayLineNumber + ", ptCenter=" + ptCenter + ", radius=" + radius + ", tag=" + tag + ", color="
				+ color + ", area=" + area + ", perimeter=" + perimeter + "]";
	}
		
	

	
	
}



