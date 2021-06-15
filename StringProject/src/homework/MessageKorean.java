package homework;

public class MessageKorean {
	public static final String[] KOREAN_MSG = {
			"안녕하세요?", "안녕히 주무셨어요?", "안녕히 주무세요.",
			"식사 하셨습니까?", "잘 지내셨습니까?", "오랜만입니다. ",
			"처음뵙겠습니다.", "다음에 또봅시다."
	};
	public int korean;
	
	public MessageKorean() {
		// TODO Auto-generated constructor stub
	}

	public MessageKorean(int korean) {
		super();
		this.korean = korean;
	}

	@Override
	public String toString() {
		return "MessageKorean [korean=" + korean + "]";
	}
	
	
}
