package traffic;
import traffic.land.ByCycle;
public class ByCycles {

}


class UniCycle extends ByCycle {
	public UniCycle() {
		super();
		this.wheel = 1;
		this.brand = "���Ͼ�Ŭ ��Ŀ��";
	}

	@Override
	public String toString() {
		return "UNI :: " + brand + "�ѹ����� ���� �θ���!!";
	}
}

class MotoBike extends ByCycle {
	public static final String DEF_ENGINE = "moto����";
	public String engine;
	public MotoBike() {
		this.engine = DEF_ENGINE;
		immobility = 4; // ����
		brand = "ȥ��?���";
	}
	@Override
	public String toString() {
		return "MOTO:: " + "���� : " + this.engine;
	}
}

class Tukshai extends MotoBike { 
	public static final int ASIA_WHEEL = 3;
	public Tukshai() {
		this.engine = DEF_ENGINE;
		immobility = 4; // ����
		brand = "������ (�±�)";
		this.wheel = ASIA_WHEEL;
	}
	@Override
	public String toString() {
		return "TUKTUKI:: ������ ��������� 3���� �������ũ!";
	}
}










