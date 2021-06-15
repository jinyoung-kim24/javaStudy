package shape.main;

import shape.basic.MyPoint;
import shape.d2.tri.MyIsoTriangle;

public class ShapeMain8 {

	public static void main(String[] args) {
		MyIsoTriangle isoTr = new MyIsoTriangle();
		isoTr.setPtA(new MyPoint());
		isoTr.setPtB(new MyPoint(80, 0));
		isoTr.setPtC(new MyPoint(0, 80));
		
//		isoTr.printTriange(); //¿¡·¯
		MyIsoTriangle isoTr2 = new MyIsoTriangle(new MyPoint(), new MyPoint(80, 0), new MyPoint(0, 80));
		isoTr2.measurePerimeter();
		isoTr2.getArea();
		isoTr2.getAngleCA_AB();
//		isoTr2.printTriange();
		isoTr2.printIsoTriangle();
		
	}

}
