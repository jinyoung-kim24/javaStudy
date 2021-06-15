package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

public class ShapeMain4 {

	public static void main(String[] args) {
		MyLine ln1 = new MyLine(20, 10, 500, -150);
		ln1.tag = "��ȭ���� 5���ⱸ���� �̼����屺 ��������� ���";
		//ln1.sp // �Ⱥ���, ���� �Ұ����� �ʵ�? private
		MyPoint sp = ln1.getStartPoint();
		MyPoint ep = ln1.getEp();
		System.out.println(sp.toString());
		System.out.println(ep);
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		 ln1.updateStartPoint(new MyPoint(-20, -38, "��ȭ���� 3���ⱸ", MyShape.COLOR_RED));
		ln1.printLine();
		
		double path1 = ln1.getDistance();
		// �Ÿ��� ������ 1.0 �������� ���͹� 1���� �����ϴ� ô��(scale)
		System.out.printf(">> '%s' �Ÿ�: %.2fm �Դϴ�\n",ln1.tag, ln1.getDistance());
		
		
	}

}
