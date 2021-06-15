package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d2.round.MyCircle;

public class ShapeMain9 {

	public static void main(String[] args) {
		MyCircle cc1 = new MyCircle(new MyPoint(), 100.0);
		cc1.tag = "��A";
		System.out.println(cc1);
		
		MyCircle cc2 = new MyCircle(50, -30, 50);
		cc2.color = MyShape.COLOR_PURPLE;
		cc2.tag = "��B";
		cc2.printCircle();

	}

}
