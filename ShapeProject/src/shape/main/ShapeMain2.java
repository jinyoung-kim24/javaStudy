package shape.main;
import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;;
public class ShapeMain2 {

	public static void main(String[] args) {
		MyPoint pt = new MyPoint(100,-100); // 4사분면? 반시계방향으로 
//		pt.printPoint();
		System.out.println(pt.toString()); // 객체의 내용을 문자열로 출력?
//		System.out.println(pt.toString()); // Object 최고 클래스의 toString()가 자동 호출됨
//		String test = "" + pt;
//		System.out.println(test);
		
		// 선 테스트
		MyLine ln1 = new MyLine();
		MyPoint pt2 = new MyPoint(200, 200);
		MyLine ln2 = new MyLine(pt, pt2, "학원에서 편의점CU 까지의 최단거리", MyShape.COLOR_GREEN, MyShape.ST_DOTTED, MyLine.BOLD_WIDTH, 0.0);
		ln1.printLine();
		ln2.printLine();
	}

}
