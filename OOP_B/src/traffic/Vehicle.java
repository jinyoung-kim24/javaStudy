package traffic;

/*
 * ### Ż�� Vehicle ��Ű�� Ŭ���� (DB vehicle TBL ���̺�)
  - ����(wheel 1, 2, 3, 4, 6, ...) ����
  - ����
  - �귣��/�̸�
  - �ο����(ž���ڼ�)
  - ����Ÿ�
  - �ӵ�
  - �������(����, ����, + �������� 4�ܰ� �ô�)
  - ����(����/����)���
 */
public class Vehicle {
	public static final String[] TYPES = {
		"���� �����Ӹ� �ִ� Ż��", "�����ŷ�", "����ũ��",
		"�¿�����", "������", "ȭ������", "���Ϸ�"
	};
	public static final int TYPE_ZERO = 0;
	public static final int TYPE_BYCYCLE = 1;
	public static final int TYPE_MOTORBIKE = 2;
	public static final int TYPE_CAR = 3;
	public static final int TYPE_BUS = 4;
	public static final int TYPE_TRUCK = 5;
	public static final int TYPE_RAILS =6;
	public static final int DEF_SEATS = 4; // �⺻ �¼���
	public static final String NO_BRAND = "������ ��";
	public static final String MANUAL_HANDLE = "����";
	public static final String AUTO_HANDLE = "����";
	public static final String AUTONAV_HANDLE = "��������"; // ai
	public static final String FUEL_OIL = "����";
	public static final String FUEL_ELECTRIC = "����";
	
	public int wheel; // - ����(wheel 1, 2, 3, 4, 6, ...) ����
	public int type; // - ������ȣ (TYPES �ε���)
	public String brand; // -�귣��/����Ŀ/�̸�-
	public int seats; // �ڼ����� - �ο����(ž���ڼ�)
	public float speed; // - �ӷ�,  �ӵ�
	public long distance; // - ����Ÿ�
	public String handleType; // - �������(����, ����, + �������� 4�ܰ� �ô�)
	public String fuel; // - ����(����/����)���
	  
	// ���̻�����(�⺻)
	public Vehicle() {
		this(2, TYPE_ZERO);
	}
	
	public Vehicle(int wheel, int type) {
		this(wheel, type, NO_BRAND, DEF_SEATS);
	}
	
	// �߰�������
	public Vehicle(int wheel, int type, String brand, int seats) {
		this(wheel, type, brand, seats, 0.0f, 0, MANUAL_HANDLE, FUEL_OIL);
//		super();
//		this.wheel = wheel;
//		this.type = type;
//		this.brand = brand;
//		this.seats = seats;
//		this.speed = 0.0F;
//		this.distance = 0;
//		this.handleType = MANUAL_HANDLE;
//		this.fuel = FUEL_OIL;
	}

	// Ǯ ������
	public Vehicle(int wheel, int type, String brand, int seats, float speed, long distance, String handleType,
			String fuel) {
		super(); // Object ���� Ŭ���� �ʱ�ȭ
		this.wheel = wheel;
		this.type = type;
		this.brand = brand;
		this.seats = seats;
		this.speed = speed;
		this.distance = distance;
		this.handleType = handleType;
		this.fuel = fuel;
	}
	
	// �������̵�(�Լ� ������) - �θ��� ������ ����� �ڽ��� ����/�����Ͽ� ��������.
	@Override
	public String toString() {
		return "Vehicle [wheel=" + wheel + ", type=" + type + ", brand=" + brand + ", seats=" + seats + ", speed="
				+ speed + ", distance=" + distance + ", handleType=" + handleType + ", fuel=" + fuel + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
