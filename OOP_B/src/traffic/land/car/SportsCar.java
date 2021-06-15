package traffic.land.car;

import traffic.Vehicle;
import traffic.land.Car;
// 3���� Ż�� Ŭ����
public class SportsCar extends Car {
	public static final String SPORT_TIRE_A = "Ư�� ���ֿ� Ÿ�̾�A";
	public static final String SPORT_TIRE_S = "F1 ���ֿ� Ÿ�̾�S";
	public static final double DEF_ACCEL = 3.5; // ǥ�� ���ӵ� ���
	public static final float DEF_SPEED = 80f; // �⺻�ӵ�
	// �ӵ����� ��� ��� Ưȭ�� ��Ŭ?
	public double accel; // ���ӵ� ���� �ʵ�
	
	// �����ϴ� ���� �޼ҵ�
	public void accelerateCar(double max) {
		double temp = Math.random() * max;
//		this.accel += temp; // ���ӵ� ����
		this.accel = temp; // ���ӵ� ��ġ
		// ���ڿ��� ����ȭ�ؼ� �����ϴ� �Լ�
		String fmtAccel = String.format("%.2f km/h^2", accel);
		System.out.println(">> ������ī�� ���ӵ��� ������: " + fmtAccel);
	}
	
	@Override
	public String toString() {
		this.accelerateCar(this.accel);
		return " ������ī�� (3���� ��Ŭ): made by " + maker + ", tire: " + this.tire + "�ִ�ӵ�: " + (this.speed * accel);
	}
	
	// �⺻ ������
	public SportsCar() {
//		this.type = Vehicle.TYPE_CAR; // ������ī�� ī�� ������ 
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
	
	// �߰� ������
	public SportsCar(String tire, int immobility, String maker, double accel, String fuel) {
		super(4, immobility, tire, maker);
		this.accel = accel;
		this.fuel = FUEL_ELECTRIC;
		this.speed = DEF_SPEED; 
	}
	
	// Ǯ������
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
