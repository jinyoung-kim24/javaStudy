package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;

public class ShapeMain4 {

	public static void main(String[] args) {
		MyLine ln1 = new MyLine(20, 10, 500, -150);
		ln1.tag = "광화문역 5번출구에서 이순신장군 동상까지의 경로";
		//ln1.sp // 안보임, 접근 불가능한 필드? private
		MyPoint sp = ln1.getStartPoint();
		MyPoint ep = ln1.getEp();
		System.out.println(sp.toString());
		System.out.println(ep);
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		 ln1.updateStartPoint(new MyPoint(-20, -38, "광화문역 3번출구", MyShape.COLOR_RED));
		ln1.printLine();
		
		double path1 = ln1.getDistance();
		// 거리의 단위를 1.0 실제에서 미터법 1미터 대응하는 척도(scale)
		System.out.printf(">> '%s' 거리: %.2fm 입니다\n",ln1.tag, ln1.getDistance());
		
		
	}

}
