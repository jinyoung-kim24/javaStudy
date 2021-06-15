package shape;

import shape.basic.MyPoint;

// ���� ������Ʈ�� ��� ����� ��Ƶ� ������Ŭ����
public class MyShape {
	// ���� ����� RGB �÷� 16����
	public static final String COLOR_BLACK = "000000";
	public static final String COLOR_WHITE = "FFFFFF";
	public static final String COLOR_RED = "FF0000";
	public static final String COLOR_GREEN = "00FF00";
	public static final String COLOR_BLUE = "0000FF";
	public static final String COLOR_YELLOW = "FFFF00";
	public static final String COLOR_CYAN = "00FFFF";
	public static final String COLOR_PURPLE = "FF00FF";
	public static final int BOLDER_WIDTH = 4;
	// �±� ���
	public static final String EMPTY_TAG = "";
	
	// �� ���
	public static final MyPoint ORIGIN_PT = new MyPoint();
	// �� ���...
	public static final int ST_SOLID = 0; // �Ǽ�
	public static final int ST_DOTTED = 1; // ����
	public static final int ST_DASHED = 2; // ���
	public static final int ST_DOUBLE = 3; // ���߼�
	public static final int ST_GROOVE = 4; // �����
	public static final int ST_RIDGE = 5; // ����
	public static final int ST_INSET = 6; // �μ�
	public static final int ST_OUTSET = 7; // �ƿ���
	public static final String[] STROKES = { 
			"�Ǽ�", "����", "���", "���߼�",
			"�����","����", "�μ�", "�ƿ���" };
}
