package shape.d1;

import shape.MyShape;
import shape.basic.MyPoint;

/*
 * ### 선 Line 스키마
 > shape.d1.MyLine
 > 두 좌표점을 이어주는 선상을 표현 일단 두 점을 잇는 직선만 표현(곡선은 별도로 취급)
 > 벡터 선은 아니며, 시작점이 있고, 끝점이 있음 (시작점 => 끝점)
 - 시작점 위치 점객체 MyPoint sp // start point
 - 끝점 위치 점객체 MyPoint ep // end point
 - 선이름태그 문자열          String tag
 - 선의 상태표현으로써의 컬러  String color (RGB 컬러코드 16진법 문자열)
 - 선의 종류 stroke, border, types... int strokeType
 - 선의 두께 정수형...				   int width
 - 측정: 선객체를 이루는 두 점 사이에 최단거리 (길이) 
 		실수형 수치값 double
 선의 종류
굵은 실선
가는 실선
파선
1점 쇄선
2점 쇄선
파형, 지그재그의 가는 실선
규칙적인 가는 빗금선
 */
public class MyLine {
	// 상수 필드
	public static final String TYPE = "선 LN";
	public static final int DEF_WIDTH = 1; // 선의 두께 상수들
	public static final int BOLD_WIDTH = 2;
	public static final int BOLDER_WIDTH = 4;
	// 선의 경계선타입 상수
	public static final String DEF_LINE_TAG = "기본선";
	// 변수필드
	private MyPoint sp; // start point
	private MyPoint ep; // end point
	// private 클래스 내부에서만 사용되게끔 보호(관리)되어 외부에서 직접 접근 안됨.
	public String tag; // 선의 이름태그 문자열
	public String color; // 직선의 상태표현으로써의 컬러
	public int strokeType; // 선의 종류 8가지
	public int width; // 선의 두께 정수
	private double distance; // 측정: 선객체를 이루는 두 점 사이의 최단거리(길이)
	// 두점 사이의 최단 직선 거리는 실측치로써 계산되어야함
	// 클래스 내부에서 그 계산값을 저장 및 갱신할 수 있음. 그러나 
	// 클래스 외부에서는 오직 읽을 수만 있다 => getter함수만 존재 read-only field
	
	public double getDistance() {
		// 여기서 계산해도 됩니다만.... 별도의 내부 길이 계산 함수를 따로 만들기 권장.
		this.measureDistance(); // RailWay 보정
		return this.distance;
	}
	
	public double measureDistance(MyPoint sp, MyPoint ep) {	
		return 0.0;
	}
	
	// 두점 사이의 최단 거리 계산 공식(알고리즘)
	private void measureDistance() {
		double dist = 0.0;
		// 수평편자, 수직편차, 수평편차^2, 수직편차^2
		// 각 편차거듭제곱합산 = 수평편차^2 + 수직편차^2
		// 제곱근(편차거듭제곱합산) squre root
		int xDiff = ep.x - this.sp.x;
		int yDiff = ep.y - this.sp.y;
		int x2 = xDiff * xDiff;
		int y2 = yDiff * yDiff;
		int sumDiff = x2 + y2;
		dist = Math.sqrt(sumDiff);
		this.distance = dist;
	}
	
	// public 필드는 읽기/쓰기가 자유로움
	// private 필드는 읽기/쓰기가 클래스 객치 내로 한정됨.
	public MyPoint getStartPoint() {
		// 관리, 보안, 암호, 가공, 일부데이터 한정...
		return this.sp; // private 필드를 public 메소드를 사용하여 읽을 수 있게 허가함.
	}

	// 게터 함수 getter method - 읽기전용 함수
	public MyPoint getEp() {
		this.ep.tag += " " + this.tag + "선객체의 끝점";
		return this.ep;
	}

	// 필드 설정/업데이트/변경 함수
	public void updateStartPoint(MyPoint newSp) {
		if (newSp != null) {
			this.sp = newSp;
			this.measureDistance();
		} else {
			System.out.println("입력 점객체가 null!!");
		}
	}
	// 세터 함수 setter method - 쓰기전용 함수 (설정자함수)
	public void setEp(MyPoint ep) {
		if(ep != null) {
			this.ep = ep;
			this.measureDistance();
		}
	}

	// 기본 생성자
	public MyLine() {
		this(new MyPoint(), MyShape.ORIGIN_PT);
//		this.sp = new MyPoint(); // 원점 시작점
//		this.ep = MyShape.ORIGIN_PT; // 원점 끝점
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	} // 기본 생성자

	// 중산 생성자들
	// 시작점을 원점객체로 가정하고 끝점객체만 입력받아서 선 객체 생성
	// 끝점 객체 하나를 외부에서 이미 NEW 초기화로 완성된 것을 입력 받기
	public MyLine(MyPoint ep) {
		this(MyShape.ORIGIN_PT, ep);
		// 끝 점객체 널이 아니라고 믿고
//		this.sp = MyShape.ORIGIN_PT; // 원점 시작점
//		this.ep = ep; // 원점 끝점
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}

	// 시작점을 원점객체로 가정하고 끝점객체만 입력받아서 선 객체 생성
	// 끝점 객체를 생성할 재료 좌표 정수 2개를 입력받아 생성자 내부에서 끝점 객체 신규 생성하기
	public MyLine(int epx, int epy) {
		this(MyShape.ORIGIN_PT, new MyPoint(epx, epy));
		// 끝 점객체 널이 아니라고 믿고
//		this.sp = MyShape.ORIGIN_PT; // 원점 시작점
//		this.ep = new MyPoint(epx, epy, "끝점", MyShape.COLOR_RED); // 원점 끝점
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}

	// 두 점 객체들을 배열로 묶어서 받아서 선객체 초기화 하기
	// 외부에서 new 초기화가 끝난 두 점 객체를 입력받음
	public MyLine(MyPoint[] pts) { // pts.length == 2조건
//			this(sp, ep, DEF_LINE_TAG, color, strokeType, BOLDER_WIDTH, distance)
		this(pts[0], pts[1]); // 여러번 거치는 this() 생성자 위임
		// pts가 null이 아니고 pts.length >= == 2
//			MyPoint psp = pts[0]; // null 아님
//			MyPoint psp = pts[1]; // null 아님
//			this.sp = pts[0]; this.ep = pts[1];
//			this.sp = pts[0]; // 원점 시작점
//			this.ep = pts[1]; // 원점 끝점
//			this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//			this.color = MyShape.COLOR_BLACK;
//			this.strokeType = ST_SOLID;
//			this.width = DEF_WIDTH;
//			this.distance = 0.0;
	}

	public MyLine(MyPoint sp, MyPoint ep, String tag) {
		this(sp, ep);
		this.tag = tag;
	}
	
	// 두 점 객체들을 각각 받아서 선객체 초기화 하기
	// 외부에서 new 초기화가 끝난 두 점 객체를 입력받음
	public MyLine(MyPoint sp, MyPoint ep) {
		this(sp, ep, DEF_LINE_TAG, MyShape.COLOR_BLACK, MyShape.ST_SOLID, DEF_WIDTH, 0.0);
		// 두 점객체 모두 널이 아니라고 믿고
//		this.sp = sp; // 원점 시작점
//		this.ep = ep; // 원점 끝점
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
	}

	// 두 점을 만들기 위해 좌표정수 4개를 각각 받아서 선객체 초기화 하기
	// 점객체를 만들 재료(정수4개)를 받아서, 생성자 내부에서
	// new 초기화를 각각 진행하여 시작점, 끝점 객체를 생성해야 함.
	public MyLine(int x1, int y1, int x2, int y2) {
//		this.sp = new MyPoint(x1, y1); // 원점 시작점
//		this.ep = new MyPoint(x2, y2); // 원점 끝점
//		this.tag = DEF_LINE_TAG;// MyShape.EMPTY_TAG;
//		this.color = MyShape.COLOR_BLACK;
//		this.strokeType = ST_SOLID;
//		this.width = DEF_WIDTH;
//		this.distance = 0.0;
//		this(new MyPoint(x1, y1), new MyPoint(x2, y2));
		// this. (포인터) 객체 자신의 주소를 가리킴
		// this() 생성자 호출(위임 패턴의 한 예)
		this(new MyPoint(x1, y1), new MyPoint(x2, y2), DEF_LINE_TAG, MyShape.COLOR_BLACK, MyShape.ST_SOLID, DEF_WIDTH,
				0.0);
		// 다른 생성자 (여기선 full 생성자)를 호출하여 자신의 초기화 작업을
		// 위임한다
		this.tag += "좋아요!!";

	}

	// 풀생성자 ( 초기화 로직을 잘 정리해둔 유일한 진짜 생성자)
	public MyLine(MyPoint sp, MyPoint ep, String tag, String color, int strokeType, int width, double distance) {
		super();
		this.sp = sp;
		this.ep = ep;
		this.tag = tag;
		this.color = color;
		this.strokeType = strokeType;
		this.width = width;
//		this.distance = distance;
		this.measureDistance();
	}

	// 측정 함수

	// 출력 함수
	// @ annotation 어노테이션.. 부가기능?
	// @ Override 어노테이션은 함수 앞에 선언함.
	// 이 어노테이션은 해당 함수가 부모 클래스로 부터 정말로 이 형식으로
	// 해당 함수를 물려 받아서 재정의할 수 있는지를 사전 체크함.
	@Override
	public String toString() {
		return "MyLine [sp=" + sp + ", ep=" + ep + ", tag=" + tag + ", color=" + color + ", strokeType=" + strokeType
				+ ", width=" + width + ", distance=" + distance + "]";
	}

	public void printLine() {
		System.out.println(this); // toString() 자동호출
//		String line = this.toString();
//		System.out.println(line);
//		 this(); // this() 생성자는 생성자 함수 안에서만  호출됨. 

	}


}
