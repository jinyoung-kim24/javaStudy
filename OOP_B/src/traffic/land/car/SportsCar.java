package traffic.land.car;

import traffic.Vehicle;
import traffic.land.Car;
// 3세대 탈것 클래스
public class SportsCar extends Car {
	public static final String SPORT_TIRE_A = "특수 경주용 타이어A";
	public static final String SPORT_TIRE_S = "F1 경주용 타이어S";
	public static final double DEF_ACCEL = 3.5; // 표준 가속도 계수
	public static final float DEF_SPEED = 80f; // 기본속도
	// 속도감과 경기 운영에 특화된 비클?
	public double accel; // 가속도 고유 필드
	
	// 가속하다 고유 메소드
	public void accelerateCar(double max) {
		double temp = Math.random() * max;
//		this.accel += temp; // 가속도 누적
		this.accel = temp; // 가속도 대치
		// 문자열을 서식화해서 리턴하는 함수
		String fmtAccel = String.format("%.2f km/h^2", accel);
		System.out.println(">> 스포츠카의 가속도가 증가됨: " + fmtAccel);
	}
	
	@Override
	public String toString() {
		this.accelerateCar(this.accel);
		return " 스포츠카종 (3세대 비클): made by " + maker + ", tire: " + this.tire + "최대속도: " + (this.speed * accel);
	}
	
	// 기본 생성자
	public SportsCar() {
//		this.type = Vehicle.TYPE_CAR; // 스포츠카는 카의 한종류 
		this.accel = DEF_ACCEL;
		super.tire = SPORT_TIRE_A;
		this.speed = DEF_SPEED;
	}

	public SportsCar(double accel) {
		 this(SPORT_TIRE_S, "Tesla", accel);
	}
	
	public SportsCar(String tire, String maker, double accel) {
		this(tire, Car.IM_4WD, maker, accel, FUEL_OIL);
	}
	
	// 중간 생성자
	public SportsCar(String tire, int immobility, String maker, double accel, String fuel) {
		super(4, immobility, tire, maker);
		this.accel = accel;
		this.fuel = FUEL_ELECTRIC;
		this.speed = DEF_SPEED; 
	}
	
	// 풀생성자
	public SportsCar(int wheel, int type, String brand, int seats, float speed, long distance, String handleType,
			String fuel, int immobility, String tire, String maker, double accel) {
		super(wheel, type, brand, seats, speed, distance, handleType, fuel, immobility, tire, maker);
		this.accel = accel;
	}

//	@Override
//	public String toString() {
//		return "SportsCar [accel=" + accel + ", immobility=" + immobility + ", tire=" + tire + ", maker=" + maker
//				+ ", wheel=" + wheel + ", type=" + type + ", brand=" + brand + ", seats=" + seats + ", speed=" + speed
//				+ ", distance=" + distance + ", handleType=" + handleType + ", fuel=" + fuel + "]";
//	}
	
	
	
	
	
}
