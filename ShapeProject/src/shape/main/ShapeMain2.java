package shape.main;
import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;;
public class ShapeMain2 {

	public static void main(String[] args) {
		MyPoint pt = new MyPoint(100,-100); // 4��и�? �ݽð�������� 
//		pt.printPoint();
		System.out.println(pt.toString()); // ��ü�� ������ ���ڿ��� ���?
//		System.out.println(pt.toString()); // Object �ְ� Ŭ������ toString()�� �ڵ� ȣ���
//		String test = "" + pt;
//		System.out.println(test);
		
		// �� �׽�Ʈ
		MyLine ln1 = new MyLine();
		MyPoint pt2 = new MyPoint(200, 200);
		MyLine ln2 = new MyLine(pt, pt2, "�п����� ������CU ������ �ִܰŸ�", MyShape.COLOR_GREEN, MyShape.ST_DOTTED, MyLine.BOLD_WIDTH, 0.0);
		ln1.printLine();
		ln2.printLine();
	}

}
