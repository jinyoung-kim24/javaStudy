package ui.store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

// 	http://www.baskinrobbins.co.kr/menu/list.php?top=A
/*
 		** ���̽�ũ�� ����� 
 		�����
 		������
 		���Ҹ���
 		���ý�Ÿ
 		�ƺ��µ��ٺ�
 		���̽�Ȩ����
 		�����¿ܰ���
 		��������Ű
 		ġ���
 		Ʈ���ù���
 		���ǹ�������
 		
 		* ���̽�ũ������ ��� �׸�(���) ����: ���� �������� �͸� ����(��Ÿ��) radiobutton
 		(ũ��/������)   (���� ����)    (����)   
 		�̱���		1����..		3000
 		������		2			4500
 		Ʈ������		3			6000
 		������		4			10000
 		�й̸���		6			15000
 		����������		8			23000
 */
public class IcecreamStoreFrame5 extends JFrame implements ActionListener {

	public static final Font ftBig =
			new Font("����", Font.BOLD, 48);
	public static final Font ftSmall =
			new Font("����", Font.BOLD, 22);
	public static final Font ftIce =
			new Font("�ü�", Font.BOLD, 24);
	
	public static final String[] ICE_NAMES = {
			"�����", // 0
	 		"������",
	 		"���Ҹ���",
	 		"���ý�Ÿ",
	 		"�ƺ��µ��ٺ�",
	 		"���̽�Ȩ����",
	 		"�����¿ܰ���",
	 		"��������Ű",
	 		"ġ���",
	 		"Ʈ���ù���",
	 		"���ǹ�������"	// 10
	};
	
	public static final String[] ICE_BUNDLE_NAMES = {
			"�̱���", "������", // ��
			"Ʈ������", "������", "�й̸���", "����������" // ��
	};
	public static final int[] ICE_BUNDLE_LIMITS = {
		1, 2, 3, 4, 6, 8
	};
	public static final int DEF_BUNDLE = 1; // double cone
	
	JLabel lbTitle; 
	JLabel lbStatus; 
	
	JButton btnCheckOut; // �ֹ��ϱ�/���� ��ư
	
	// ���̽�ũ�� 11�� üũ�ڽ� ���� �迭
	JCheckBox[] cbIceFlavors; // ���̽�ũ�� �� üũ�ڽ� �迭
	// ���� 6�� ������ư ���� �迭
	JRadioButton[] rdBundles;
	// �⺻ ���õ� ������ ������ȣ
	int nBundle;
	ArrayList<Integer> selIcecremList; 
		// ���õ� ���̽�ũ�� ���� ������ȣ���� ����ϴ� ��ٱ���(����Ʈ)
	public IcecreamStoreFrame5() {
		super("���� ���̽�ũ�� �����");
		setBounds(100, 100, 800, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		this.setLayout(new BorderLayout());
		// ��ܷΰ� Ÿ�̺� ���̺�
		ImageIcon icLogo = new ImageIcon("./store/logo2.PNG");
		this.lbTitle = new JLabel("���̾��̽� MyIce");
		lbTitle.setFont(ftBig);
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		lbTitle.setIcon(icLogo);
		
		// ���̽�ũ�� ���� ������ư �г� �غ�
		JPanel pnBundles = new JPanel(new GridLayout(1, 2));
		pnBundles.setBackground(Color.pink);
		pnBundles.setBorder(new LineBorder(Color.orange, 3, true));
		rdBundles = new JRadioButton[ICE_BUNDLE_NAMES.length];
//		JPanel pnLeft = new JPanel();
//		JPanel pnRight = new JPanel();
		JPanel pnLeft = new JPanel(new BorderLayout());
		JPanel pnRight = new JPanel(new BorderLayout());
		JPanel pnIces = new JPanel(new GridLayout(2, 3));
		ButtonGroup rdGrp = new ButtonGroup();
		for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
			JRadioButton bundle = new JRadioButton(ICE_BUNDLE_NAMES[i]);
			bundle.setFont(ftSmall);
			bundle.setToolTipText(ICE_BUNDLE_LIMITS[i] + "������ ��!!");
//			pnBundles.add(bundle); // �г� ǥ�ÿ� ���
//			pnLeft.add(bundle);
			pnIces.add(bundle);
			rdBundles[i] = bundle; // ������ �迭/����Ʈ ���
			rdGrp.add(bundle); // ��Ÿ�� �׷쿡 ���
		}
		JLabel lbSubTitle = new JLabel(":: ���� ����");
		lbSubTitle.setFont(ftIce);
		lbSubTitle.setHorizontalAlignment(JLabel.CENTER);
		pnLeft.add(lbSubTitle, BorderLayout.NORTH);
		pnLeft.add(pnIces, BorderLayout.CENTER);
		// �⺻ ���� ���� double cone
		this.nBundle = DEF_BUNDLE;
//		JRadioButton selBundle = rdBundles[nBundle];
//		selBundle.setSelected(true); // �� ������ư(����)�� ���õ� 
		rdBundles[nBundle].setSelected(true);
		// ������ ������ �̹��� ǥ��
		JLabel lbSubBundle = new JLabel(":: ���� ����(���� ��) ::");
		lbSubBundle.setHorizontalAlignment(JLabel.CENTER);
		lbSubBundle.setFont(ftIce);
		ImageIcon icDouble = new ImageIcon("./store/bundle/double.PNG");
		JLabel lbIceBundle = new JLabel("double 2������", icDouble, JLabel.CENTER);
//		pnRight.add(lbIceBundle);
		pnRight.add(lbSubBundle, BorderLayout.NORTH);
		pnRight.add(lbIceBundle, BorderLayout.CENTER);
		pnBundles.add(pnLeft);
		pnBundles.add(pnRight);
		
		// ���̽�ũ�� üũ�ڽ� �г��غ�
		JPanel pnIcecreams = new JPanel(
				new GridLayout(4,3, 6,6)); // 4�� 3��
		pnIcecreams.setBackground(Color.CYAN);
		pnIcecreams.setBorder(new EtchedBorder());
		cbIceFlavors = new JCheckBox[ICE_NAMES.length];
		// ���̽�ũ�� ���� �ϳ����� JCheckBox�� ����
		for (int i = 0; i < ICE_NAMES.length; i++) {
			JCheckBox iceChk = new JCheckBox(ICE_NAMES[i]);
			iceChk.setFont(ftIce);
			iceChk.setIcon(new ImageIcon(
				"./store/icecreams_sized/"+ICE_NAMES[i]+".png"));
			iceChk.setSelectedIcon(new ImageIcon(
					"./store/icecreams_sel_������ ����/"+ICE_NAMES[i]+".png"));
			pnIcecreams.add(iceChk);
			this.cbIceFlavors[i] = iceChk;
		}
		this.lbStatus = new JLabel("���¹�::");
		this.setFont(new Font("����", Font.PLAIN, 22));
		this.btnCheckOut = new JButton("���̽�ũ�� �ֹ�!!");
		
		JPanel pnCenter = new JPanel(new BorderLayout(5, 5));
		pnCenter.add(pnBundles, BorderLayout.NORTH); // 
		pnCenter.add(pnIcecreams, BorderLayout.CENTER);
		pnCenter.add(btnCheckOut, BorderLayout.SOUTH);
		add(lbTitle, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		// add(pnIcecreams, BorderLayout.CENTER);
//		add(btnCheckOut, BorderLayout.SOUTH);
		
		// ��ٱ��� �ʱ�ȭ
		this.selIcecremList = new ArrayList<>(); // size 0��
		lbStatus.setText(">> ���õ� ���̽�ũ�� ����: 0��");
		
		
		// �̺�Ʈ ó��(������ ���)
		btnCheckOut.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		IcecreamStoreFrame5 store = new IcecreamStoreFrame5();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ٱ��� ����Ʈ ����
		for (int i = 0; i < this.cbIceFlavors.length; i++) {
			JCheckBox cbIce = cbIceFlavors[i];
			if(cbIce.isSelected()) {// ���õ� ���̽�ũ�����ΰ�?
//				System.out.println(i + "��°:" + cbIce.getText());
				selIcecremList.add(i); // ���
			}
		}
		// ��ٱ��� ���Ȯ��
		System.out.println(">> ��ٱ��� ũ��: " + selIcecremList.size());
		lbStatus.setText(">> ���õ� ���̽�ũ�� ����: " + selIcecremList.size() + "��");
		for (int selIceOrder : selIcecremList) {
			System.out.println(selIceOrder + " : " + ICE_NAMES[selIceOrder]);
		}
		
		
	}

}

