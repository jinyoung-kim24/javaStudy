package homework;

public class MessageKorean {
	public static final String[] KOREAN_MSG = {
			"�ȳ��ϼ���?", "�ȳ��� �ֹ��̾��?", "�ȳ��� �ֹ�����.",
			"�Ļ� �ϼ̽��ϱ�?", "�� �����̽��ϱ�?", "�������Դϴ�. ",
			"ó���˰ڽ��ϴ�.", "������ �Ǻ��ô�."
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
