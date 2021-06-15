package traffic.land.car;

// 4세대  탈것 클래스
// 인공지능 AI 탑제 + 자율주행(빠르고, 안전하게)
public class AISportsCar extends SportsCar {
	public static final String AI_NORMAL = "보급형 N10";
	public static final String AI_KAKAO1 = "카카오I2021";
	public static final double AI_ACCEL = 10.0;
	public String aiType;
	
	
	public AISportsCar() {
		super(AI_ACCEL);
		this.aiType = AI_NORMAL;
		this.maker = "현대 자율주행카A";
		this.handleType = AUTONAV_HANDLE;
	}
	
	public AISportsCar(String aiType) {
		super(AI_ACCEL);
		this.aiType = aiType;
		this.maker = "현대 자율주행카A";
		this.handleType = AUTONAV_HANDLE;
	}

	
	public AISportsCar(String tire, String maker, double accel, String aiType) {
		super(tire, maker, accel);
		this.aiType = aiType;
		this.handleType = AUTONAV_HANDLE;
	}
	// AI가 합법적이고 안전성 우선의 가속기능을 수행
	@Override
	public void accelerateCar(double max) {
		final double maxSafeSpeedForHuman = 500.0;
		// AI법 1조: 법적으로 안전상 이 속도를 넘지 않게만 가속하시오
		do { // 일단 한번 가속 해봐 근데 제한을 넘으면 경고와 하한 처리함
		double tempAccel = Math.random() * max;
		double tempSpeed = this.speed * tempAccel;
		if(tempSpeed <= maxSafeSpeedForHuman) {
			this.accel = tempAccel; // 가속도 적용
			String fmtAccel = String.format("%.2f km/h^2", accel);
			System.out.println(">> AI 스포츠카의 가속도가 증가됨: " + fmtAccel);
			break;
		}else {
			System.out.println(tempSpeed + "km/h 속도가 제한법을 넘어서서 조정조치함...");
		}
		} while(true);
	}

	@Override
	public String toString() {
//		super.accelerateCar(this.accel);
		accelerateCar(this.accel); // 내꺼 실행
		return " AI스포츠카종 (4세대 비클): made by " + maker + ", tire: " + this.tire + 
				"최대속도: " + (this.speed * accel) + ", AI탑재: " + this.aiType;
	}
	
	
	
	
	
	
}
