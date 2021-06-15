package ui.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

//public class AwGuiMain2 {
//public class AwGuiMain2 extends Frame {
public class AwtGuiMain5 extends Frame 
					implements ActionListener
{
	// GUI â�� ������ �ڿ�(�÷�, ��Ʈ, ũ��, ��ġ, ���, �̹���)
	public static final Color crPink = Color.PINK;
	public static final Color crBlue = Color.BLUE;
	public static final Color crGreen = Color.GREEN;
	public static final Color crOrangle = Color.orange;
	public static final Color crRed = new Color(255, 0, 0);
	public static final Font ftNormal = new Font("����", Font.ITALIC, 30);
	public static final Font ftBig = new Font("�ü�ü", Font.BOLD, 60);
	public static final Font ftLable = new Font("����", Font.PLAIN, 32);
	public static final Font ftButton = new Font("����", Font.BOLD | Font.ITALIC, 40);
	// ui ������Ʈ �ʵ� ���� (����ʵ�ȭ)
	TextField txtHello; // �ʵ�ȭ - �⺻�� null !!!!
	TextField txtHuman;  
	Label lbResult; // ��ư �̺�Ʈ�� ����� �� ���̺��� ǥ��
	
	// ������ (������â �ʱ�ȭ)
	public AwtGuiMain5() {
//	this.setTitle("������� â");
		super("������� â");
	}
	
	
	public AwtGuiMain5(String title) {
		
		// frame â ���� �ʱ�ȭ
		
//		this.setTitle(title);
		super(title); // �θ� Frame(title) ������ ȣ�� �ʱ�ȭ
		
		// frame â�� ��Ī�� ũ�� ���� (����̽�/OS�� ȭ�� �ػ�/�е�..?)
//		setLocation(100, 100); // ȭ���� �»��(top-left corner) �������� �������� ������
		this.setLocation(new Point(100, 100));
//		this.setSize(800, 480); // ���� x ����(ũ��)
		setSize(new Dimension(800, 400));
		// frame â�� Ŭ���̾�Ʈ������ ������Ʈ�� ��ġ�ϱ� ����
		// ��ġ ������ ����
		//setLayout(new FlowLayout()); // �÷ο췹�̾ƿ�
			// �÷ο췹�̾ƿ�: ������Ʈ���� ���ι������� ä�� �����ٰ�
			// ���� �࿡�� ��踦 ������ ���� ��(�Ʒ���) ���� ������Ʈ���� ��ġ
			// word-wrapping�� ��� 
//		setLayout(new BorderLayout()); // Frameâ�� �⺻ ��ġ������ ����
		// Frame â�� �⺻ ���̾ƿ��Ŵ����� BorderLayout�� �⺻������.(��������)
		// �������̾ƿ�(��������+�߾�): �����¿�� �߾���
		// 5���� �������� â�� ��Ȱ�Ͽ� ������Ʈ�� ������ġ��
		// North ~ South, West ~East, Center
		// NSWE�� �� ���� â���(border)�� ���� �پ ����ũ�Ⱑ ����
		// Center������ �����ִ� ��� ������ �켱������ ��� ä������.
		
		// * ��ġ �����ڴ� ���� �����̳ʿ��� ������.
		
		
//		final Color crPink = Color.PINK;
//		final Color crBlue = Color.BLUE;
//		final Color crGreen = Color.GREEN;
//		final Color crOrangle = Color.orange;
////		final Color crRed = new Color(0xFF, 0, 0);
//		final Color crRed = new Color(255, 0, 0);
//		//
//		final Font ftNormal = new Font("����", Font.ITALIC, 30);
//		Font ftBig = new Font("�ü�ü", Font.BOLD, 60);
//		�� ������â�� �ٸ��� UI������Ʈ���� �غ��ϱ�
		// ������ �ؽ�Ʈ�� ǥ���ϴ� 
		Label lbTitle = new Label("*** �λ� �ϱ� ***");
		lbTitle.setFont(ftBig);
		lbTitle.setForeground(crBlue); // �����
		Label lbHello = new Label("Hello GUI!!");
		lbHello.setFont(ftNormal);
		Label lbHello2 = new Label("�ȳ��ϼ���?");
		lbHello2.setFont(ftNormal);  //ftBig);
		// ������� �⺸�� �ؽ�
		this.lbResult = new Label("���: ", Label.LEFT);
		lbResult.setFont(new Font("����", 
				Font.BOLD | Font.ITALIC, 
				38));
		lbResult.setBackground(Color.YELLOW);
		
//		TextField txtHello = new TextField(20);
		this.txtHello = new TextField(20);
		txtHello.setFont(ftNormal);
		txtHuman = new TextField("Mr. Park", 14);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(Color.CYAN);
		txtHuman.setBackground(Color.DARK_GRAY);
		
		
		//������� �̺�Ʈ(����)�� ó���� ���ִ� button ������Ʈ
		Button btnGreet = new Button("GREET!");
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif", Font.PLAIN, 22));
		
		// ** �̺�Ʈ ������ ���: Ư�� �̺�Ʈ�� �߻��Ǵ����� ����(����͸�) ���..
		// => �ش� �̺�Ʈ�� �߻����ڸ��� �ٷ� ����� �̺�Ʈó���޼ҵ�(�ڵ鷯)�� ����.
		// �� ��ư�� �̺�Ʈ�ڵ鷯�� �̺�Ʈ�� ���� 
		btnGreet.addActionListener(this);
		//������ �ڽ�â �ڱ��ڽŰ�ü actionPerformed()�� ������ ��ü�����ڰ���
		// ActionListener �̺�Ʈ �ڵ鷯 �Լ�  
		// actionPerformed()�� ������ ��ü�� ���ڷ�...
		
//		this.add(lbTitle); // ���� ���̺� ��ü�� ���� ���� ǥ��
//		add(lbHello); // flowlayout������ add ������ �߿�.
//		this.add(lbHello2);		
//		this.add(txtHello);
//		add(txtHuman);
//		this.add(btnGreet);
//		add(lbResult);
		// this�� ������ �ڽ�â �ڱ��ڽŰ�ü
		
		// Pane, Panel�� ���� �����̳�(html ������ div�±׿� ���) 
		// Panel �����̳ʷν� �⺻������ FlowLayout ��ġ�����ڸ� ���´�.
		Panel pn = new Panel(); // �г��� �⺻��ġ�� flowLayout 
		pn.add(lbHello); // flowlayout������ add ������ �߿�.
		pn.add(lbHello2);		
		pn.add(txtHello);
		pn.add(txtHuman);
		
		// �����̳��� Frame â�� �ڽ� �����͵��� (��ġ�����ڿ� ����) ��ġ
		add(pn, BorderLayout.CENTER); // �г��� �߾ӿ� ��ġ
		add(lbTitle, BorderLayout.NORTH);
		add(btnGreet, BorderLayout.EAST);
		add(lbResult, BorderLayout.SOUTH);
		
		this.setBackground(crOrangle); // ����
//		this.setVisible(true); // AWTâ�� close x��ư ���� �ȵ�.
	}
	
	// ��ư Ŭ�� �̺�Ʈ ó�� �Լ� (�̺�Ʈ�� ���� ��ι� �������̽��� �����ؾ� ��.)
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Greet! ��ư�� �������!!" + new Date());
			// ��ư Ŭ��..	
		String strHello = this.txtHello.getText();
		String strHumanName = this.txtHuman.getText();
		System.out.println(">> �λ��ϱ� " +  strHello 
				+ " " + strHumanName + "~!!!"); // �ܼ�â ���
		this.lbResult.setText(">> �λ��ϱ� " +  strHello 
				+ " " + strHumanName + "~!!!");
	}
	
	public static void main(String[] args) {
		AwtGuiMain5 frm1 = new AwtGuiMain5("�λ� ���ϱ� GREET ���α׷�"); 
		frm1.setVisible(true);
	}



}
