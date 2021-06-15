package shape.main;
import shape.MyShape;
import shape.basic.MyPoint;
public class ShapeMain {

	public static void main(String[] args) {
		MyPoint pt1 = new MyPoint(); 
		// 더미생성자 호출하여 생성하면 원점 객체
		pt1.printPoint();
		MyPoint pt2 = new MyPoint(); 
		pt2.x = 100;
		pt2.tag = "";
		pt2.printPoint(); // x축에서 100만큼 +방향으로 떨어진 점 좌표
		
		MyPoint pt3 = new MyPoint(80, 40, "왕십리역", MyShape.COLOR_RED);
		pt3.printPoint();
		
		MyPoint pt4 = new MyPoint(150, true); // x축 위에 있는점
		pt4.printPoint();
		
		MyPoint pt5 = new MyPoint(150, false); // x축 위에 있는점
		pt5.printPoint();
		
		MyPoint pt6 = pt3; // 동일점객체(주소)를 pt3, pt6가 동시에 가리킴.
		MyPoint pt7 = new MyPoint(pt3); // 복제로 새로 생성된 뉴 점객체
		pt3.tag = "이전 왕십리역!";
		pt6.printPoint();
		
		pt7.printPoint();
		
		System.out.println("---------------");
		System.out.println(pt6);
		System.out.println(pt7); // toString()이 자동 호출됨.
		
		
		
		
		
		
	}

}
