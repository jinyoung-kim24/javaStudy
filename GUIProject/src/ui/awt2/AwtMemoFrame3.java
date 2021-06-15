package ui.awt2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;

public class AwtMemoFrame3 extends Frame {
	
	// ��� ����
	public static final Font ftNormal = new Font("����", Font.PLAIN, 24); // ��Ʈ ���� ����ʵ�
	public static final Font ftMedium = new Font("����", Font.PLAIN | Font.ITALIC, 32);
	public static final Font ftBig = new Font("����", Font.BOLD, 48);
	public static final Color crAccent = Color.orange;
	public static final Color crSub = new Color(128, 0, 200);
	
	// �ʵ� ����(UI ������Ʈ)
	// ���� ���̺�
	private Label lbTitle;
	// �߾� �ؽ�Ʈ �Է�
//	private TextField txtMemo; // �� �� ¥�� ���ڿ� �Է�
	private TextArea txtMemo; // ���� �� ���ڿ� �Է�
	// �ϴ� ���� ���̺�
	private Label lbStatus; // �������ͽ���
	
	// ��ư 4�� �߰� - ����, ��Ʈ���������, �޸�����, �޸��б�
	private Button btnAbout;
	private Button btnChangeColor; // FG <=> BG
	private Button btnSave;
	private Button btnLoad;
	
	private Panel pnBottom; // south ��ġ�� ��ġ�� �г� (���� �����̳�)
	
	public AwtMemoFrame3() {
		super("�������~~");
	}
	
	public AwtMemoFrame3(String title) {
		// ������ â ����
		super(title);
//		this.setSize(480, 480); // ũ��
//		this.setLocation(100, 100); // ��ġ
		this.setBounds(100, 100, 480, 480);
			// setSize() + SetLocation() �ѹ��� �ٿ��
//		setBounds(new Rectangle(100, 100, 480, 480));
		setBackground(Color.gray); // ȭ�� ����
		setResizable(false); // â ũ�� ���� �Ұ��� ����
		
		// â (��ġ) ���̾ƿ� ������ 
		// Frame�� ���ο� �⺻ ��ġ�����ڷ� Borderlayout ����
//		this.setLayout(new BorderLayout()); // ���� ����
		
		// ������Ʈ �غ� Ȥ�� ����
		this.lbTitle = new Label("����: ");
		this.txtMemo = new TextArea("�޸� �Է��ϼ���!", 40, 40, TextArea.SCROLLBARS_BOTH);
		// ��, ��, ��ũ�ѹ�
//		txtMemo = new TextField("�޸� �Է��ϼ���!", 40);
		this.lbStatus = new Label("���¹�: ", Label.LEFT);
		
		lbTitle.setFont(ftBig);
		lbStatus.setFont(ftNormal);
		txtMemo.setFont(ftMedium);
		
		// ����, ��Ʈ���������, �޸�����, �޸��б�
		btnAbout = new Button("info");
		btnLoad = new Button("load");
		btnSave = new Button("save");
		btnChangeColor = new Button("F<=>B");
		
		// �г� ����(��ġ �����ڵ� ���� ��������)
		FlowLayout pnLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		this.pnBottom = new Panel(pnLayout);
		
		// �гο� ������Ʈ���� ��ġ
		pnBottom.add(lbStatus);
		pnBottom.add(new Label("   ")); // ���鷹�̺� ��ü�� ����
		pnBottom.add(btnAbout);
		pnBottom.add(new Label("   "));
		pnBottom.add(btnLoad);
		pnBottom.add(btnSave);
		pnBottom.add(btnChangeColor);
		
		// â�� ������Ʈ���� ��ġ
		this.add(lbTitle, BorderLayout.NORTH);
		this.add(txtMemo, BorderLayout.CENTER);
//		this.add(lbStatus, BorderLayout.SOUTH);
		this.add(pnBottom, BorderLayout.SOUTH);
		
		// ������ â ���̱�	
		this.setVisible(true); // â
		
	}

	public static void main(String[] args) {
		AwtMemoFrame3 frm = new AwtMemoFrame3("���� �޸���1");
		//frm.setVisible(true); // â
		
		

	}

}
