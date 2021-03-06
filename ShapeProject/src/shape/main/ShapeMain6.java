package shape.main;

import shape.MyShape;
import shape.basic.MyPoint;
import shape.d2.tri.MyTriangle;

public class ShapeMain6 {

	public static void main(String[] args) {
		MyPoint ptA = new MyPoint(0, 0, "학원", MyShape.COLOR_RED);
		MyPoint ptB = new MyPoint(180, 20, "성동구청", MyShape.COLOR_GREEN);
		MyPoint ptC = new MyPoint(-200, -90, "별다방", MyShape.COLOR_BLUE);
		MyPoint ptD = new MyPoint(-100, 80, "우체국", MyShape.COLOR_PURPLE);
		
		MyTriangle ta1 = new MyTriangle(ptA, ptB, ptC);
		ta1.tag = "커피 마시는 영역";
//		ta1.printTriange();
		ta1.measurePerimeter(); // 측정 실행
		System.out.println("커피 성지 삼각형 둘레 길이:" + ta1.getPerimeter() + "m");
		System.out.println("커피 성지 삼각형 영역 넓이:" + ta1.getArea() + "m^2");
		
		
		
		MyPoint pts[] = {ptD, ptB, ptC};
		MyTriangle ta2 = new MyTriangle(pts);
		ta2.tag = "공부하는 영역";
//		ta2.printTriange();
		double peri = ta2.measurePerimeter(); // 측정 실행
		System.out.println("공부 성지 삼각형 둘레 길이:" + peri + "m");
		System.out.println("공부 성지 삼각형 영역 넓이:" + ta2.getArea() + "m^2");
		// 1미터 제곱 == 0.000247에이커(ac)
		
	}

}
