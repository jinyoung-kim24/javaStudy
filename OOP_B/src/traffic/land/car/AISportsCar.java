package traffic.land.car;

// 4����  Ż�� Ŭ����
// �ΰ����� AI ž�� + ��������(������, �����ϰ�)
public class AISportsCar extends SportsCar {
	public static final String AI_NORMAL = "������ N10";
	public static final String AI_KAKAO1 = "īī��I2021";
	public static final double AI_ACCEL = 10.0;
	public String aiType;
	
	
	public AISportsCar() {
		super(AI_ACCEL);
		this.aiType = AI_NORMAL;
		this.maker = "���� ��������īA";
		this.handleType = AUTONAV_HANDLE;
	}
	
	public AISportsCar(String aiType) {
		super(AI_ACCEL);
		this.aiType = aiType;
		this.maker = "���� ��������īA";
		this.handleType = AUTONAV_HANDLE;
	}

	
	public AISportsCar(String tire, String maker, double accel, String aiType) {
		super(tire, maker, accel);
		this.aiType = aiType;
		this.handleType = AUTONAV_HANDLE;
	}
	// AI�� �չ����̰� ������ �켱�� ���ӱ���� ����
	@Override
	public void accelerateCar(double max) {
		final double maxSafeSpeedForHuman = 500.0;
		// AI�� 1��: �������� ������ �� �ӵ��� ���� �ʰԸ� �����Ͻÿ�
		do { // �ϴ� �ѹ� ���� �غ� �ٵ� ������ ������ ���� ���� ó����
		double tempAccel = Math.random() * max;
		double tempSpeed = this.speed * tempAccel;
		if(tempSpeed <= maxSafeSpeedForHuman) {
			this.accel = tempAccel; // ���ӵ� ����
			String fmtAccel = String.format("%.2f km/h^2", accel);
			System.out.println(">> AI ������ī�� ���ӵ��� ������: " + fmtAccel);
			break;
		}else {
			System.out.println(tempSpeed + "km/h �ӵ��� ���ѹ��� �Ѿ�� ������ġ��...");
		}
		} while(true);
	}

	@Override
	public String toString() {
//		super.accelerateCar(this.accel);
		accelerateCar(this.accel); // ���� ����
		return " AI������ī�� (4���� ��Ŭ): made by " + maker + ", tire: " + this.tire + 
				"�ִ�ӵ�: " + (this.speed * accel) + ", AIž��: " + this.aiType;
	}
	
	
	
	
	
	
}
