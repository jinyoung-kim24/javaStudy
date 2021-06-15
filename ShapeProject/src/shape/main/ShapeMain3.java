package shape.main;
import shape.MyShape;
import shape.basic.MyPoint;
import shape.d1.MyLine;;
public class ShapeMain3 {

	public static void main(String[] args) {
		MyPoint pt = new MyPoint(100,-100); // 4사분면? 반시계방향으로 
//		pt.printPoint();
//		System.out.println(pt.toString()); // 객체의 내용을 문자열로 출력?
//		System.out.println(pt.toString()); // Object 최고 클래스의 toString()가 자동 호출됨
//		String test = "" + pt;
//		System.out.println(test);
		
		// 선 테스트
		MyLine ln1 = new MyLine();
		MyPoint pt2 = new MyPoint(200, 200);
		MyLine ln2 = new MyLine(pt, pt2, "학원에서 편의점CU 까지의 최단거리",
				MyShape.COLOR_GREEN, MyShape.ST_DOTTED, MyLine.BOLD_WIDTH, 0.0);
//		ln1.printLine();
//		ln2.printLine();
		
		MyPoint oriPt = MyShape.ORIGIN_PT;
		MyPoint bankPt = new MyPoint(-70, 20, "하나은행", MyShape.COLOR_PURPLE);
		MyLine ln3 = new MyLine(bankPt); // 원점에서 하나은행 점까지의 선 
		ln3.tag = "원점에서 하나은행 점까지의 선";
		ln3.printLine();
		
		MyLine ln4 = new MyLine(300, 400); // 원점에서 우리은행 좌표까지의 선
		ln4.tag = "원점에서 우리은행 좌표까지의 선";
		System.out.println(ln4);
		
//		MyLine ln5 = new MyLine(oriPt, bankPt);
//		ln5.printLine(); // ln3의 점객체들과 내용은 동일 그러나 선객체는 다른 객체.
//		
//		MyLine ln6 = new MyLine(oriPt.x, oriPt.y, bankPt.x, bankPt.y);
//		ln6.printLine();
		MyPoint pts[] = { new MyPoint(150, true),
				new MyPoint(-300, -150, "3사분면 지점", MyShape.COLOR_CYAN)
		};
		MyLine ln7 = new MyLine(pts); // 점배열 받아서 선객체 만들기
		ln7.printLine();
	}

}
