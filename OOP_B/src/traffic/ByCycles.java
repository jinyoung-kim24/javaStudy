package traffic;
import traffic.land.ByCycle;
public class ByCycles {

}


class UniCycle extends ByCycle {
	public UniCycle() {
		super();
		this.wheel = 1;
		this.brand = "유니씨클 서커스";
	}

	@Override
	public String toString() {
		return "UNI :: " + brand + "한바퀴로 묘기 부리기!!";
	}
}

class MotoBike extends ByCycle {
	public static final String DEF_ENGINE = "moto엔진";
	public String engine;
	public MotoBike() {
		this.engine = DEF_ENGINE;
		immobility = 4; // 오토
		brand = "혼다?기아";
	}
	@Override
	public String toString() {
		return "MOTO:: " + "엔진 : " + this.engine;
	}
}

class Tukshai extends MotoBike { 
	public static final int ASIA_WHEEL = 3;
	public Tukshai() {
		this.engine = DEF_ENGINE;
		immobility = 4; // 오토
		brand = "툭툭이 (태국)";
		this.wheel = ASIA_WHEEL;
	}
	@Override
	public String toString() {
		return "TUKTUKI:: 동남아 관광산업용 3바퀴 모토바이크!";
	}
}










