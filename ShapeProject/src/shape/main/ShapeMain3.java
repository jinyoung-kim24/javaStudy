package shape.main;
import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;;
public class ShapeMain3 {

	public static void main(String[] args) {
		MyPoint pt = new MyPoint(100,-100); // 4��и�? �ݽð�������� 
//		pt.printPoint();
//		System.out.println(pt.toString()); // ��ü�� ������ ���ڿ��� ���?
//		System.out.println(pt.toString()); // Object �ְ� Ŭ������ toString()�� �ڵ� ȣ���
//		String test = "" + pt;
//		System.out.println(test);
		
		// �� �׽�Ʈ
		MyLine ln1 = new MyLine();
		MyPoint pt2 = new MyPoint(200, 200);
		MyLine ln2 = new MyLine(pt, pt2, "�п����� ������CU ������ �ִܰŸ�",
				MyShape.COLOR_GREEN, MyShape.ST_DOTTED, MyLine.BOLD_WIDTH, 0.0);
//		ln1.printLine();
//		ln2.printLine();
		
		MyPoint oriPt = MyShape.ORIGIN_PT;
		MyPoint bankPt = new MyPoint(-70, 20, "�ϳ�����", MyShape.COLOR_PURPLE);
		MyLine ln3 = new MyLine(bankPt); // �������� �ϳ����� �������� �� 
		ln3.tag = "�������� �ϳ����� �������� ��";
		ln3.printLine();
		
		MyLine ln4 = new MyLine(300, 400); // �������� �츮���� ��ǥ������ ��
		ln4.tag = "�������� �츮���� ��ǥ������ ��";
		System.out.println(ln4);
		
//		MyLine ln5 = new MyLine(oriPt, bankPt);
//		ln5.printLine(); // ln3�� ����ü��� ������ ���� �׷��� ����ü�� �ٸ� ��ü.
//		
//		MyLine ln6 = new MyLine(oriPt.x, oriPt.y, bankPt.x, bankPt.y);
//		ln6.printLine();
		MyPoint pts[] = { new MyPoint(150, true),
				new MyPoint(-300, -150, "3��и� ����", MyShape.COLOR_CYAN)
		};
		MyLine ln7 = new MyLine(pts); // ���迭 �޾Ƽ� ����ü �����
		ln7.printLine();
	}

}
