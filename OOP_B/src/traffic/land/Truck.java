package traffic.land;

import traffic.Vehicle;
/*
 * ### 화물차류 Truck 스키마 클래스
 > traffic.land.Truck 트럭/화물류
 > Vehicle의 직계 자식 클래스, 바퀴6개이상... 구동방식,
 	타이어(재질), 화물적재칸(용량), 화물적재무게(하중)
 */
// 자식들의 공통사항을 묶어서 상위 클래스로 표현하면 부모 클래스가 됨.
public class Truck extends Vehicle {
	public static final int WHEEL_CNT = 6;
	public static final double ONE_TON = 1000000; // g
	public static final long DEF_VOL = 1000;
	
	public int immobility; // 구동방식 2WD, 4WD
	public String tire; // 타이어(재질)
	public long volume; // 화물적재칸(용량)
	public double weight; // 화물적재무게(하중)
	
	// 더미생성자(기본)
	public Truck() {
		super(WHEEL_CNT, Vehicle.TYPE_TRUCK, NO_BRAND, 2);
		this.immobility = Car.IM_2WD;
		this.tire = Car.ADV_TIRE;
		this.volume = DEF_VOL;
		this.weight = ONE_TON;
	}
	
	public Truck(int immobility, String tire, long volume, double weight) {
//		super();
		this.wheel = WHEEL_CNT;
		this.type = TYPE_TRUCK;
		
		this.immobility = immobility;
		this.tire = tire;
		this.volume = volume;
		this.weight = weight;
	}
	
	// 풀생성자
	public Truck(int wheel, int type, String brand, int seats, float speed, long distance, String handleType,
			String fuel, int immobility, String tire, long volume, double weight) {
		super(wheel, type, brand, seats, speed, distance, handleType, fuel);
		this.immobility = immobility;
		this.tire = tire;
		this.volume = volume;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Truck [immobility=" + immobility + ", tire=" + tire + ", volume=" + volume + ", weight=" + weight
				+ ", wheel=" + wheel + ", type=" + type + ", brand=" + brand + ", seats=" + seats + ", speed=" + speed
				+ ", distance=" + distance + ", handleType=" + handleType + ", fuel=" + fuel + "]";
	}

	
	
}
