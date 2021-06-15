package ui.store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

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
 		
 		(ũ��/������)   (���� ����)    (����)   
 		�̱���		1����..		3000
 		������		2			4500
 		Ʈ������		3			6000
 		������		4			10000
 		�й̸���		6			15000
 		����������		8			23000
 */
public class IcecreamStoreFrame extends JFrame {

	public static final Font ftBig =
			new Font("����", Font.BOLD, 48);
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
	
	JLabel lbTitle; 
	JLabel lbStatus; 
	
	JButton btnCheckOut; // �ֹ��ϱ�/���� ��ư
	
	public IcecreamStoreFrame() {
		super("���� ���̽�ũ�� �����");
		setBounds(100, 100, 800, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		this.setLayout(new BorderLayout());
		
		ImageIcon icLogo = new ImageIcon("./store/logo2.PNG");
		
		this.lbTitle = new JLabel("���̾��̽� MyIce");
		lbTitle.setFont(ftBig);
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		lbTitle.setIcon(icLogo);
		
		JPanel pnIcecreams = new JPanel(
				new GridLayout(4,3, 6,6)); // 4�� 3��
		pnIcecreams.setBackground(Color.CYAN);
		pnIcecreams.setBorder(new EtchedBorder());
		// ���̽�ũ�� ���� �ϳ����� JCheckBox�� ����
		for (int i = 0; i < ICE_NAMES.length; i++) {
			JCheckBox iceChk = new JCheckBox(ICE_NAMES[i]);
			iceChk.setFont(ftIce);
			iceChk.setIcon(new ImageIcon(
				"./store/icecreams_sized/"+ICE_NAMES[i]+".png"));
			iceChk.setSelectedIcon(new ImageIcon(
					"./store/icecreams_sel_������ ����/"+ICE_NAMES[i]+".png"));
			pnIcecreams.add(iceChk);
		}
		
		this.btnCheckOut = new JButton("���̽�ũ�� �ֹ�!!");
		
		add(lbTitle, BorderLayout.NORTH);
		add(pnIcecreams, BorderLayout.CENTER);
		add(btnCheckOut, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		IcecreamStoreFrame store = new IcecreamStoreFrame();
	}

}

