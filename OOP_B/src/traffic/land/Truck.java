package traffic.land;

import traffic.Vehicle;
/*
 * ### ȭ������ Truck ��Ű�� Ŭ����
 > traffic.land.Truck Ʈ��/ȭ����
 > Vehicle�� ���� �ڽ� Ŭ����, ����6���̻�... �������,
 	Ÿ�̾�(����), ȭ������ĭ(�뷮), ȭ�����繫��(����)
 */
// �ڽĵ��� ��������� ��� ���� Ŭ������ ǥ���ϸ� �θ� Ŭ������ ��.
public class Truck extends Vehicle {
	public static final int WHEEL_CNT = 6;
	public static final double ONE_TON = 1000000; // g
	public static final long DEF_VOL = 1000;
	
	public int immobility; // ������� 2WD, 4WD
	public String tire; // Ÿ�̾�(����)
	public long volume; // ȭ������ĭ(�뷮)
	public double weight; // ȭ�����繫��(����)
	
	// ���̻�����(�⺻)
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
	
	// Ǯ������
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
