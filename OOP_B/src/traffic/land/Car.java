package traffic.land;

import traffic.Vehicle;
/*
 *  ### ī�� Car ��Ű�� Ŭ����
 > traffic.land.Car �ڵ�����
 >  => ����, ����, ����, RV, SUV, ������ī
 > Vehicle�� ���� �ڽ� Ŭ����, ����4���̻�... �������, Ÿ�̾�(����), ����Ŀ
 */
public class Car extends Vehicle {
	public static final int WHEEL_CNT = 4; // ���� 4���̻�
	public static final String  DEF_TIRE = "�Ϲ� ��Ÿ�̾�A";
	public static final String  ADV_TIRE = "Ư�� �� Ÿ�̾�S";
	public static final int IM_2WD = 0; // 2������
	public static final int IM_4WD = 1; // 4������
	public static final String[] IMWD = {
			"2�� ������", "4�� ������"
	};
	public static final String DEF_MAKER = "OEM";
	
	public int immobility; // ������� 2WD, 4WD
	public String tire; // Ÿ�̾�(����)
	public String maker; // ����Ŀ
	
	// ���̻�����
	public Car() {
		super.type = TYPE_CAR;
		this.wheel = WHEEL_CNT; // 4
		this.immobility = IM_2WD;
		this.tire = DEF_TIRE;
		this.maker = DEF_MAKER;
	}
	
	public Car(String tire, String maker) {
		this(WHEEL_CNT, IM_2WD, tire, maker);
	}
	
	public Car(int wheel,int immobility, String tire, String maker) {
		this.type = TYPE_CAR;
		this.brand = NO_BRAND;
		this.seats = DEF_SEATS;
		this.wheel = wheel;
		this.immobility = immobility;
		this.tire = tire;
		this.maker = maker;
	}
	
	// �߰�������
	public Car(int wheel, int type, String brand, int seats, int immobility, String tire, String maker) {
		super(wheel, type, brand, seats);
		this.immobility = immobility;
		this.tire = tire;
		this.maker = maker;
	}
		
	// Ǯ������
	public Car(int wheel, int type, String brand, int seats, float speed, long distance, String handleType, String fuel,
			int immobility, String tire, String maker) {
		super(wheel, type, brand, seats, speed, distance, handleType, fuel);
		this.immobility = immobility;
		this.tire = tire;
		this.maker = maker;
	}

	@Override
	public String toString() {
		return "Car [immobility=" + IMWD[immobility] + ", tire=" + tire + ", maker=" + maker + "]";
	}

	
	
	
	
	
}
