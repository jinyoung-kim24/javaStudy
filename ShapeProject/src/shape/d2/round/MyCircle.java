package shape.d2.round;

import shape.MyShape;
import shape.basic.MyPoint;

/*
 *  #### 원 Circle 스키마
 > Shape.d2.round.MyCircle 
 > 임의의 한 점에서 직선거리가 동일하게 떨어진 모든 점들을 
	연결한 2차원 평면상의 폐공간
 - 중심점  MyPoint ptCenter
 - 반지름  double radius;
 - 원의 이름태그 문자열 String tag;
 - 원 내부 영역에 채워진 컬러 String color;(RGB 컬러코드 16진법 문자열)
 - 측정: 넓이(면적) double area;
 - 측정: 둘레(길이) double perimeter;

 */
public class MyCircle {
	public static final double PI = Math.PI;
	public static final double DEF_R = 25.0;
	
	
	
	public MyPoint ptCenter; // 중심점
	public double radius; // 반지름
	public String tag; 
	public String color; // (RGB 컬러코드 16진법 문자열)
	public double area; // PI * R * R 
	public double perimeter; // 2 * PI * R
	
	// 둘레 측정
	public double measurePerimeter() {
		this.perimeter = 2 * PI * radius;
		return perimeter;
	}
	// 넓이 측정
	public double measureArea() {
		this.area = PI * radius * radius;
		return area;
	}
	
	public void printCircle() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "MyCircle [ptCenter=" + ptCenter + ", radius=" + radius + ", tag=" + tag + ", color=" + color + ", area="
				+ area + ", perimeter=" + perimeter + "]";
	}

	// 더미 생성자
	public MyCircle() {
		this(MyShape.ORIGIN_PT, DEF_R);
	}
	
	// 중간 생성자
	public MyCircle(MyPoint ptCenter, double radius) {
		this(ptCenter, radius, MyShape.EMPTY_TAG, MyShape.COLOR_BLACK, 0.0, 0.0); 
//		super();
//		this.ptCenter = ptCenter;
//		this.radius = radius;
	}
	
	public MyCircle(int ptCX, int ptCY, double radius) {
		this(new MyPoint(ptCX, ptCY), radius);
	}

	// 풀 생성자
	public MyCircle(MyPoint ptCenter, double radius, String tag, String color, double area, double perimeter) {
		super();
		this.ptCenter = ptCenter;
		this.radius = radius;
		this.tag = tag;
		this.color = color;
		this.area = area;
		this.perimeter = perimeter;
	}
	
	
}
