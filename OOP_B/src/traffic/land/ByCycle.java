package traffic.land;

import traffic.Vehicle;
/*
 * ### �����ŷ� ByCycle ��Ű�� Ŭ����
 > Vehicle�� ���� �ڽ� Ŭ����, ���� 2��.. ���.. �������
 */

public class ByCycle extends Vehicle {
	public static final int WHEEL_CNT = 2; // ���� 2��
	public static final String DEF_PEDAL = "���� ���"; 
	public static final String ADV_PEDAL = "ö�� ���";
	public static final String[] IM_TYPES = {
		"�θ�Թб�", "��̹߼���", "��޼���", "�����޼���", "�������"	
	};
	
	
	public String pedal; // ���
	public int immobility; // �������
	
	// ���� ������ (�⺻)
	public ByCycle() {
	this(NO_BRAND, 0);
	}

	public ByCycle(String brand, int immobility) {
		this(brand, 1, DEF_PEDAL, immobility);
	}
	
	// �߰� ������
	public ByCycle(String brand, int seats, String pedal, int immobility) {
		super(WHEEL_CNT, TYPE_BYCYCLE, brand, seats);
		this.pedal = pedal;
		this.immobility = immobility;
	}
	
	// Ǯ������
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
