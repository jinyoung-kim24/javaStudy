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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// about ��ư ���� �̺��� ó�� Ŭ���� ����
//class AboutButtonHandler implements ActionListener {
//	JMemoFrame6 frm;
//	public AboutButtonHandler(JMemoFrame6 frm) {
//		this.frm = frm; // �ڵ鷯�� ȣ���� ������â�� �ּҸ� �����.
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println(">> About ���� ǥ��...");
//		String about = "Information:: ";
//		about += frm.getTitle();
//		
//		JDialog aboutDlg =  // ��ȭ���ڵ� �ϳ��� �����̳�
//			new JDialog(frm, "info ��ȭ����..", true); // ��� modal
////											, false); // ��޸��� modaless
//		aboutDlg.setSize(240, 240);
//		aboutDlg.setLocation(100, 100); // ���߿��� ȭ�� �߾�, �θ�â �߾�??
//		
//		JLabel lbInfo = new JLabel(about, 
//				JLabel.CENTER);
////		lbInfo.setFont(frm.ftMedium);
//		aboutDlg.add(lbInfo);
//		
//		aboutDlg.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
//		
//		aboutDlg.setVisible(true);
//	}
//	
//}

// Ŭ������ �̸� J�����ϴ� GUIŬ������ SWING ����� ����.
public class JMemoFrame6 extends JFrame
			implements ActionListener
{	
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
	private JLabel lbTitle;
	// �߾� �ؽ�Ʈ �Է�?
//	private JTextField txtMemo; // �� �� ¥�� ���ڿ� �Է�
	private JTextArea txtMemo; 
			// ���� �� ���ڿ� �Է�; �� x ��... ����Ű, ��ũ�ѹ�
	// �ϴ� ���� ���̺�
	private JLabel lbStatus; // �������ͽ� ��
	
	// ��ư 4�� �߰� - ����, ��Ʈ���������, �޸�����, �޸��б�
	private JButton btnAbout;
	private JButton btnChangeColor; // FG <=> BG
	private JButton btnSave;
	private JButton btnLoad;
	
	private JPanel pnBottom; // south ��ġ�� ��ġ�� �г�(���� �����̳�)
	
	boolean bColorBlackOnWhite; // �÷� ���� �÷��� �ʵ� (���º���)
	
	public JMemoFrame6() {
		super("�������");
	}
	
	public JMemoFrame6(String title) {
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
		this.lbTitle = new JLabel("����: ");
//		txtMemo = new JTextField("�޸� �Է��ϼ���!", 40);
		this.txtMemo = new JTextArea
				("�޸� �Է��ϼ���!", 40, 40); // ��, ��
		this.lbStatus = new JLabel("���¹�: oooooooo", Label.LEFT);		
		lbTitle.setFont(ftBig);
		lbStatus.setFont(ftNormal);
		txtMemo.setFont(ftMedium);
		
		// ����, ��Ʈ���������, �޸�����, �޸��б� 
		btnAbout = new JButton("info");
		btnLoad = new JButton("load");
		btnSave = new JButton("save");
		btnChangeColor = new JButton("F<->B"); // inversion
		this.bColorBlackOnWhite = true; // B/W <==> W/B
		
		// �г� ����(��ġ �����ڵ� ���� ��������)
//		this.pnBottom = new Panel(); // flowLayout �⺻ ����
//		FlowLayout pnLayout = 
//			new FlowLayout(FlowLayout.LEFT, 0, 0);
		BorderLayout pnLayout = new BorderLayout();
		this.pnBottom = new JPanel(pnLayout); // ���������߾�
		
		// �гο� ������Ʈ���� ��ġ
		pnBottom.add(lbStatus, BorderLayout.CENTER);
		//pnBottom.add(new Label("   ")); // ���鷹�̺� ��ü�� ����
		
		JPanel pnBtns = new JPanel();//flowLayout �⺻ ����
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
		
		
		// �̺�Ʈ ���� 
		// (�̺�Ʈ��� ui������Ʈ���� �ڵ鷯 �Լ��� ���� ��Ŵ => ������ ���)
		btnChangeColor.addActionListener(this);
			// ActionListener �̺�Ʈ(�������̽�)�� ó���� �� �ִ�
			// ��ü�� �Է¹���..
			// ó���Ѵٴ� ���� �ڵ鷯 �Լ��� �̺�Ʈ�������̽��� �߻�޼ҵ带 
			// �����ߴٴ� ����.. ��  actionPerformed() �����ؾ���.
		
		AboutButtonHandler aboutHandler
			= new AboutButtonHandler(null);
		btnAbout.addActionListener(aboutHandler);
		
		
		// JFrame�� ���... â�� �⺻ �ݱ� �����ϰ�...
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
					// ���α׷� ��� ����...
		
		// â ���̱�
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		JMemoFrame6 frm 
			= new JMemoFrame6("���� �޸���2");	
		//frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("�÷� ���� ��ư ������!!");
		
		if( bColorBlackOnWhite ) { // == true B/W
			System.out.println("�÷�����: to W/B");
			lbStatus.setText("�÷�����: to W/B");
			this.txtMemo.setForeground(Color.WHITE); // ����
			this.txtMemo.setBackground(Color.black); // ���
			bColorBlackOnWhite = false;
		} else { // false W/B ����..
			System.out.println("�÷�����: to B/W");
			lbStatus.setText("�÷�����: to B/W");
			this.txtMemo.setForeground(Color.BLACK); // ����
			this.txtMemo.setBackground(Color.white); // ���
			bColorBlackOnWhite = true;
		}		
//		bColorBlackOnWhite = !bColorBlackOnWhite;
		
	}

}
