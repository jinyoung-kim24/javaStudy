package mulity;

public class switchMain3 {
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
		
		// switch ~case ���ߺб⹮
		switch(nColor) { // case�� ������ �߿�!!
		case COLOR_RED:
			strColor = "red";
			printColor(strColor);
			break; // break�� ������ case�� ������� switch�� ����
					// break�� ������ ������ case�� ������� switch�� ���ӽ���
		case COLOR_ORANGE:
			strColor = "orange";
			printColor(strColor);
			break;
		case COLOR_YELLOW:
			strColor = "yellow";
			printColor(strColor);
			break;
		case COLOR_GREEN:
			strColor = "green";
			printColor(strColor);
			break;
		case COLOR_BLUE:
			strColor = "blue";
			printColor(strColor);
			break; // case���� �������� �б��� break;
		case COLOR_NAVY:
			strColor = "navy";
			printColor(strColor);
			break;
		case COLOR_PURPLE:
			strColor = "purple";
			printColor(strColor);
			break;
		default: // if���� else ��ϰ��� ���
			strColor = COLOR_NAME_BLACK;
			// break;
				
		}
		
		
		
		// if ~ else if/ else ���ߺб⹮ 
//		// if ���ߺб⹮
//		//if(nColor == 1) 
//		if(nColor == COLOR_RED)		
//			strColor = "red"; // 0xFF0000
//		//else if(nColor != 1 && nColor == 2)
//		else if(nColor == COLOR_ORANGE)
//			strColor = "orange";
//		else if(nColor == COLOR_YELLOW)
//			strColor = "yellow";
//		else if(nColor == COLOR_GREEN)
//			strColor = "green";
//		else if(nColor == COLOR_BLUE)
//			strColor = "blue";
//		else if(nColor == COLOR_NAVY)
//			strColor = "navy";
//		else if(nColor == COLOR_PURPLE)
//			strColor = "purple";
//		else // �ս� 7���� ��� ������ ��� false�� �ǰ��� ���� ���� else�� ��.
//			strColor = COLOR_NAME_BLACK; //"black";
		
		System.out.printf(
			">> ���õ� ������ '%s (%d���÷�)'\n", strColor, nColor);
	}

}
