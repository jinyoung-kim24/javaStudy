package traffic.land;

import traffic.Vehicle;
/*
 * ### 자전거류 ByCycle 스키마 클래스
 > Vehicle의 직계 자식 클래스, 바퀴 2개.. 페달.. 구동방식
 */

public class ByCycle extends Vehicle {
	public static final int WHEEL_CNT = 2; // 바퀴 2개
	public static final String DEF_PEDAL = "나무 페달"; 
	public static final String ADV_PEDAL = "철제 페달";
	public static final String[] IM_TYPES = {
		"부모님밀기", "어린이발수동", "페달수동", "기어페달수동", "오토페달"	
	};
	
	
	public String pedal; // 페달
	public int immobility; // 구동방식
	
	// 더미 생성자 (기본)
	public ByCycle() {
	this(NO_BRAND, 0);
	}

	public ByCycle(String brand, int immobility) {
		this(brand, 1, DEF_PEDAL, immobility);
	}
	
	// 중간 생성자
	public ByCycle(String brand, int seats, String pedal, int immobility) {
		super(WHEEL_CNT, TYPE_BYCYCLE, brand, seats);
		this.pedal = pedal;
		this.immobility = immobility;
	}
	
	// 풀생성자
	public ByCycle(int wheel, int type, String brand, int seats, String pedal, int immobility) {
		super(wheel, type, brand, seats);
		this.pedal = pedal;
		this.immobility = immobility;
	}

	@Override
	public String toString() {
		return "Vehicle [wheel=" + wheel + ", type=" + type + ", brand=" + brand + ", seats=" + seats +
				"\n ByCycle [pedal=" + pedal + ", immobility=" + immobility + "]";
	}
	
//	@Override
//	public String toString() {
//		return "ByCycle [pedal=" + pedal + ", immobility=" + immobility + ", wheel=" + wheel + ", type=" + type
//				+ ", brand=" + brand + ", seats=" + seats + ", speed=" + speed + ", distance=" + distance
//				+ ", handleType=" + handleType + ", fuel=" + fuel + "]";
//	}
//	
	
	
}
