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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwtMemoFrame5 extends Frame implements ActionListener {	
	// ��� ����
	public static final Font ftNormal 
			= new Font("����", Font.PLAIN, 24);
	public static final Font ftMedium
			= new Font("����", Font.PLAIN | Font.ITALIC, 32);
	public static final Font ftBig
			= new Font("����", Font.BOLD, 48);
	public static final Color crAccent = Color.ORANGE;
	public static final Color crSub = new Color(128, 0, 200);

	// �ʵ� ���� (UI ������Ʈ)
	// ���� ���̺�
	private Label lbTitle;
	// �߾� �ؽ�Ʈ �Է�?
//	private TextField txtMemo; // �� �� ¥�� ���ڿ� �Է�
	private TextArea txtMemo; 
			// ���� �� ���ڿ� �Է�; �� x ��... ����Ű, ��ũ�ѹ�
	// �ϴ� ���� ���̺�
	private Label lbStatus; // �������ͽ� ��
	
	// ��ư 4�� �߰� - ����, ��Ʈ���������, �޸�����, �޸��б�
	private Button btnAbout;
	private Button btnChangeColor; // FG <=> BG
	private Button btnSave;
	private Button btnLoad;
	
	private Panel pnBottom; // south ��ġ�� ��ġ�� �г�(���� �����̳�)
	
	boolean bColorBlackOnWhite; // �÷� ���� �÷��� �ʵ�(���º���)
	
	public AwtMemoFrame5() {
		super("�������");
	}
	
	public AwtMemoFrame5(String title) {
		// ������ â ����....
		super(title);
//		this.setSize(480, 480); // ũ��
//		this.setLocation(100, 100); // ��ġ
		this.setBounds(100, 100, 480, 480);
			// setSize() + setLocation() �� ����... �ٿ��~
//		setBounds(new Rectangle(100, 100, 480, 480));
		setBackground(Color.gray);
		setResizable(false); // â ũ�� ���� �Ұ��� ����
		
		// â (��ġ) ���̾ƿ� ������
		// Frame�� ���ο� �⺻ ��ġ�����ڷ� Borderlayout ����.1
//		this.setLayout(new BorderLayout()); // ����
		
		// ������Ʈ �غ� Ȥ�� ����
		this.lbTitle = new Label("����: ");
//		txtMemo = new TextField("�޸� �Է��ϼ���!", 40);
		this.txtMemo = new TextArea
				("�޸� �Է��ϼ���!", 40, 40, 
				TextArea.SCROLLBARS_BOTH); // ��, ��, ��ũ�ѹ�
		this.lbStatus = new Label("���¹�: ooooooooooooooooooooooooo", Label.LEFT);		
		lbTitle.setFont(ftBig);
		lbStatus.setFont(ftNormal);
		txtMemo.setFont(ftMedium);
		
		// ����, ��Ʈ���������, �޸�����, �޸��б� 
		btnAbout = new Button("info");
		btnLoad = new Button("load");
		btnSave = new Button("save");
		btnChangeColor = new Button("F<->B"); // inversion 
		this.bColorBlackOnWhite = true; // B/W <==> W/B
		
		// �г� ����(��ġ �����ڵ� ���� ��������)
//		this.pnBottom = new Panel(); // flowLayout �⺻ ����
//		FlowLayout pnLayout = 
//			new FlowLayout(FlowLayout.LEFT, 0, 0);
		BorderLayout pnLayout = new BorderLayout();
		this.pnBottom = new Panel(pnLayout); // ���������߾�
		
		// �гο� ������Ʈ���� ��ġ
		pnBottom.add(lbStatus, BorderLayout.CENTER);
		//pnBottom.add(new Label("   ")); // ���鷹�̺� ��ü�� ����
		
		Panel pnBtns = new Panel();//flowLayout �⺻ ����
		pnBtns.add(btnAbout);
		pnBtns.add(new Label(" "));
		pnBtns.add(btnLoad);
		pnBtns.add(btnSave);		
		pnBtns.add(btnChangeColor);
		pnBottom.add(pnBtns, BorderLayout.EAST);
			// �гο� �� ������ ���� �ٸ� �г��� ��ġ
		
		// â�� ������Ʈ���� ��ġ
		this.add(lbTitle, BorderLayout.NORTH);
		this.add(txtMemo, BorderLayout.CENTER);
		this.add(pnBottom, BorderLayout.SOUTH);
//		this.add(lbStatus, BorderLayout.SOUTH);//���¹�
		 
		// �̺�Ʈ ���� (�̺�Ʈ��� ui������Ʈ���� �ڵ鷯 �Լ��� ���� ��Ŵ => ������ ���)
		btnChangeColor.addActionListener(this);
			// ActionListener �̺�Ʈ(�������̽�)�� ó���� �� �ִ�
			// ��ü�� �Է¹���/.
			// ó���Ѵٴ� ���� �ڵ鷯 �Լ��� �̺�Ʈ�������̽��� �߻�޼ҵ�
			// �����ߴٴ� ����.. �� actionPerforme() �����ؾ���
		// â ���̱�
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		AwtMemoFrame5 frm 
			= new AwtMemoFrame5("���� �޸���1");	
		//frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("�÷� ���� ��ư ������!!");
		if(bColorBlackOnWhite) { // true B/W
			System.out.println("�÷�����: to W/B");
			lbStatus.setText("�÷�����: to W/B");
			this.txtMemo.setForeground(Color.white); // ����
			this.txtMemo.setBackground(Color.black); // ���
			bColorBlackOnWhite = false;
		}else { // false W/B
			System.out.println("�÷�����: to B/W");
			lbStatus.setText("�÷�����: to B/W");
			this.txtMemo.setForeground(Color.black); // ����
			this.txtMemo.setBackground(Color.white); // ���
			bColorBlackOnWhite = true;
		}
		
//		bColorBlackOnWhite = !bColorBlackOnWhite;
		
	}

}
