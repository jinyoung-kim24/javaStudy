package mulity;

public class switchMain4 {
	// ���� Colors
	// RGB(Red, Green, Blue, ����), RGBA, HSV/HSI, CMYK
	
	private static final int COLOR_RED = 1; // ��
	private static final int COLOR_ORANGE = 2;
	private static final int COLOR_YELLOW = 3;
	private static final int COLOR_GREEN = 4;
	private static final int COLOR_BLUE = 5;
	private static final int COLOR_NAVY = 6;
	private static final int COLOR_PURPLE = 7; // ��
	private static final String COLOR_NAME_BLACK = "black";
	
	
	public static void printColor(String color) {
		System.out.println("===" + color + "===");
		
	}

	public static void main(String[] args) {
		// ������ �� �̸� 7������ �����ϰ� ����ϱ�
		int r = (int)(Math.random()*100) + 1; // 1 ~ 100
		int nColor = (r % 7) + 1; // 0 ~ 6 => 1 ~ 7
		
		String strColor = "�÷�����";
		
		strColor = whichColor(nColor);
		
		
		
	
		
		System.out.printf(
			">> ���õ� ������ '%s (%d���÷�)'\n", strColor, nColor);
	}
	// �÷� ������ �Է��ϸ� �÷��̸� ���ڿ��� �����ϴ� �Լ�
	public static String whichColor(int nColor) {
		
			String strColor;
			switch(nColor) { // case�� ������ �߿�!!
			case COLOR_RED:
				strColor = "red"; break; // break�� ������ case�� ������� switch�� ����
						// break�� ������ ������ case�� ������� switch�� ���ӽ���
			case COLOR_ORANGE:
				strColor = "orange"; break;
			case COLOR_YELLOW:
				strColor = "yellow"; break;
			case COLOR_GREEN:
				strColor = "green"; break;
			case COLOR_BLUE:
				strColor = "blue"; break; // case���� �������� �б��� break;
			case COLOR_NAVY:
				strColor = "navy"; break;
			case COLOR_PURPLE:
				strColor = "purple"; break;
			default: // if���� else ��ϰ��� ���
				strColor = COLOR_NAME_BLACK;
				// break;
			return strColor;
		}
			return strColor;
	}

}
