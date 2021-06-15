package ui.store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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

import ui.store.event.IceFlavorHandler;

// 	http://www.baskinrobbins.co.kr/menu/list.php?top=A
/*
 		** ���̽�ũ�� ����� - 11��
 		* ���̽�ũ�� ������ ���� �������� ������ ���� checkbox
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
 		
 		* ���̽�ũ������ ��� �׸�(���) ����: 
 		* 			���� �� ������ �͸� ����(��Ÿ��) radiobutton 
 		(ũ��/������)   (���� ����)    (����)   
 		�̱���		1����..		3000
 		������		2			4500
 		Ʈ������		3			6000
 		������		4			10000
 		�й̸���		6			15000
 		����������		8			23000
 */

//class BundleSizeHanlder

public class IcecreamStoreFrame9 extends JFrame implements ActionListener, ItemListener {// �������̽� ���� ������ ������.
	// implements ActionListener {

	public static final Font ftBig = new Font("����", Font.BOLD, 48);
	public static final Font ftSmall = new Font("����", Font.BOLD, 22);
	public static final Font ftIce = new Font("�ü�", Font.BOLD, 24);

	public static final String[] ICE_NAMES = { "�����", // 0
			"������", "���Ҹ���", "���ý�Ÿ", "�ƺ��µ��ٺ�", "���̽�Ȩ����", "�����¿ܰ���", "��������Ű", "ġ���", "Ʈ���ù���", "���ǹ�������" // 10
	};

	public static final String[] ICE_BUNDLE_NAMES = { "�̱���", "������", // con
			"Ʈ������", "������", "�й̸���", "����������" // cup
	};
	public static final int[] ICE_BUNDLE_LIMITS = { 1, 2, 3, 4, 6, 8 };
	public static final int DEF_BUNDLE = 1; // double cone

	// �ʵ�
	JLabel lbTitle;
	public JLabel lbStatus;

	JButton btnCheckOut; // �ֹ��ϱ�/���� ��ư

	// ���̽�ũ�� 11�� üũ�ڽ� ���� �迭
	// JCheckBox[] cbIceFlavors; // ���̽�ũ�� �� üũ�ڽ� �迭
	public JCheckBox[] cbIceFlavors; // ���̽�ũ�� �� üũ�ڽ� �迭
	// ���� 6�� ������ư ���� �迭
	JRadioButton[] rdBundles;
	// �⺻ ���õ� ������ ������ȣ
	int nBundle;
	public ArrayList<Integer> selIcecreamList;
	// ���õ� ���̽�ũ������ ������ȣ���� ����ϴ� ��ٱ���(����Ʈ)
	JLabel lbIceBundle; // �ʵ�ȭ....

	// ����/���� Ŭ���� ���� (inner class/ nested class)
	// ����Ŭ������ �ܺ�Ŭ������ ��ȣ?�� ������,
	// �ڽ��� ���� �ܺ� Ŭ������ �ڿ����� ������� ������ ����� ����..
//	private class BundleSizeHanlder implements ItemListener {
//	public class BundleSizeHanlder implements ItemListener {
	class BundleSizeHanlder implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
//			selIcecreamList.add(1); // �ܺ�Ŭ���� ��ü �ڿ� ����..?
//			this. ??
			JRadioButton rd = (JRadioButton) e.getItemSelectable();
//			System.out.println(rd.getText());
//			// ��Ÿ�� ������ 2�� �̺�Ʈ �߻�
//			// DESELECT ������ ���̾� SELECT�� �߻���..
//			if( e.getStateChange() == ItemEvent.SELECTED ) {
//				System.out.println(rd.getText() + " ���õ�!");
//			}
			if (rd.isSelected()) {
				System.out.println(rd.getText() + " ���õ�!!");

				// ���� ������ �̹��� ��ü ǥ��
				// ������ ���̽�ũ�� ���� ���̺� ����
				// nBundle ���ù�ȣ�� ����
				changeBundleSize(rd.getText());
			}
		}

	}

	public void changeBundleSize(String bundleName) {
		System.out.println(bundleName);

		// "�ѱ�" Ű => "����" ���
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("�̱���", "single");
		map.put("������", "double");
		map.put("Ʈ������", "triple");
		map.put("������", "quarter");
		map.put("�й̸���", "family");
		map.put("����������", "half-galon");

		String changedBundleName;
		String cntBunlde = "";
		if (map.containsKey(bundleName)) {
			changedBundleName = map.get(bundleName); // ���� �����̸�
			int limit = 0;
			for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
				String name = ICE_BUNDLE_NAMES[i];
				if (name.equals(bundleName)) { // ��� �����
					this.nBundle = i; // ���õ� ������ ������ȣ.
					limit = ICE_BUNDLE_LIMITS[i]; // ���̽�ũ�� ����
					break;
				}
			}
			cntBunlde = " " + limit + "���� ��!";
		} else {
			System.out.println(">> ���� ����Ű: " + bundleName);
			changedBundleName = "double";
			cntBunlde = " 2���� ��!";
			this.nBundle = DEF_BUNDLE; // 1
		}

		// ���� ������ �̹��� ��ü ǥ��
		String filename = "./store/bundle/" + changedBundleName + ".PNG";
		ImageIcon icBundle = new ImageIcon(filename);
		lbIceBundle.setIcon(icBundle);
		// ������ ���̽�ũ�� ���� ���̺� ����
		lbIceBundle.setText(changedBundleName + cntBunlde);
		// nBundle ���ù�ȣ�� ����
	}

	public IcecreamStoreFrame9() {
		super("���� ���̽�ũ�� �����");
		// setBounds(100, 100, 1200, 900); // ������...
		setBounds(100, 100, 1200, 780); // ������...
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		this.setLayout(new BorderLayout());

		// ��� �ΰ� Ÿ�̺� ���̺� �غ�
		ImageIcon icLogo = new ImageIcon("./store/logo2.PNG");
		this.lbTitle = new JLabel("���̾��̽� MyIce");
		lbTitle.setFont(ftBig);
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		lbTitle.setIcon(icLogo);

		// ���̽�ũ�� ���� ������ư �г� �غ�
//		JPanel pnBundles = new JPanel(new GridLayout(1, 6));
		JPanel pnBundles = new JPanel(new GridLayout(1, 2)); // 2���
		pnBundles.setBackground(Color.pink);
		pnBundles.setBorder(new LineBorder(Color.orange, 3, true));
		rdBundles = new JRadioButton[ICE_BUNDLE_NAMES.length];
//		JPanel pnLeft = new JPanel(); // flowlayout
//		JPanel pnRight = new JPanel();
		JPanel pnLeft = new JPanel(new BorderLayout());
		JPanel pnRight = new JPanel(new BorderLayout());
//		JPanel pnIces = new JPanel(); // flowlayout
		JPanel pnIces = new JPanel(new GridLayout(2, 3)); // 6��
		ButtonGroup rdGrp = new ButtonGroup();
		BundleSizeHanlder bundleSizeHanlder = new BundleSizeHanlder();
		for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
			JRadioButton bundle = new JRadioButton(ICE_BUNDLE_NAMES[i]);
			bundle.setFont(ftSmall);
			bundle.setToolTipText(ICE_BUNDLE_LIMITS[i] + "������ ��!");
//			pnBundles.add(bundle); // �г� ǥ�ÿ� ���
//			pnLeft.add(bundle); // ���� ���� �гο� ���
			pnIces.add(bundle);
			rdBundles[i] = bundle; // ������ �迭/����Ʈ ���
			rdGrp.add(bundle); // ��Ÿ�� �׷쿡 ���

			// bundle.addItemListener(this);
			// bundle.addItemListener(ifh);
			bundle.addItemListener(bundleSizeHanlder);
		}
		JLabel lbSubTitle = new JLabel(":: ���� ���� ::");
		lbSubTitle.setFont(ftIce);
		lbSubTitle.setHorizontalAlignment(JLabel.CENTER);
		pnLeft.add(lbSubTitle, BorderLayout.NORTH);
		pnLeft.add(pnIces, BorderLayout.CENTER);
		// �⺻ ���� ���� double cone
		this.nBundle = DEF_BUNDLE;
//		JRadioButton selBundle = rdBundles[nBundle];
//		selBundle.setSelected(true); // �� ������ư(����)�� ���õ�

		ImageIcon icDouble = new ImageIcon("./store/bundle/double.PNG");
		lbIceBundle = new JLabel( // �ʵ庯��
				"double 2������", icDouble, JLabel.CENTER);

		rdBundles[nBundle].setSelected(true); // NULL ��ġ!!
		// ������ �гο� ������ �̹��� ǥ��
		JLabel lbSubBundle = new JLabel(":: ���� ����(���� ��) ::");
		lbSubBundle.setHorizontalAlignment(JLabel.CENTER);
		lbSubBundle.setFont(ftIce);
//		ImageIcon icDouble = 
//			new ImageIcon("./store/bundle/double.PNG");
		// new ImageIcon("store\\bundle\\double.PNG");
		// JLabel lbIceBundle = new JLabel( // ��������
//		lbIceBundle = new JLabel( // �ʵ庯�� ==> �ʱ�ȭ ��ġ �̵�!!!!
//				"double 2������", icDouble, 
//				JLabel.CENTER);
		lbIceBundle.setFont(ftIce);
//		pnRight.add(lbIceBundle);
		pnRight.add(lbSubBundle, BorderLayout.NORTH);
		pnRight.add(lbIceBundle, BorderLayout.CENTER);

		pnBundles.add(pnLeft);
		pnBundles.add(pnRight);

		// ���̽�ũ�� üũ�ڽ� �г� �غ�
		JPanel pnIcecreams = new JPanel(new GridLayout(4, 3, 6, 6)); // 4�� 3��
		pnIcecreams.setBackground(Color.CYAN);
		pnIcecreams.setBorder(new EtchedBorder());
		cbIceFlavors = new JCheckBox[ICE_NAMES.length]; // [11];
		// ���̽�ũ�� ���� �ϳ����� JCheckBox�� ����
		for (int i = 0; i < ICE_NAMES.length; i++) {
			JCheckBox iceChk = new JCheckBox(ICE_NAMES[i]);
			iceChk.setFont(ftIce);
			iceChk.setIcon(new ImageIcon("./store/icecreams_sized/" + ICE_NAMES[i] + ".png"));
			iceChk.setSelectedIcon(new ImageIcon("./store/icecreams_seljh/" + ICE_NAMES[i] + ".png"));
			pnIcecreams.add(iceChk);
			this.cbIceFlavors[i] = iceChk;
		}

		this.lbStatus = new JLabel("���¹� ::");
		this.setFont(new Font("����", Font.PLAIN, 22));
		this.btnCheckOut = new JButton("���̽�ũ�� �ֹ�!!");

		JPanel pnCenter = new JPanel(new BorderLayout(5, 5));

		pnCenter.add(pnBundles, BorderLayout.NORTH); // �гξȿ� �г�
		pnCenter.add(pnIcecreams, BorderLayout.CENTER);
		pnCenter.add(btnCheckOut, BorderLayout.SOUTH);
		add(lbTitle, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		// add(pnIcecreams, BorderLayout.CENTER);
//		add(btnCheckOut, BorderLayout.SOUTH);
		add(lbStatus, BorderLayout.SOUTH); // ���¹� �߰�

		// ��ٱ��� �ʱ�ȭ
		this.selIcecreamList = new ArrayList<>(); // size 0
		lbStatus.setText(">> ���õ� ���̽�ũ�� ����: 0��");

		// �̺�Ʈ ó�� (������ ���)
		IceFlavorHandler ifh = new IceFlavorHandler(this);

		btnCheckOut.addActionListener(this);
		for (int i = 0; i < cbIceFlavors.length; i++) {
			JCheckBox cbIceF = cbIceFlavors[i];
//			cbIceF.addItemListener(this); // 1. ���� ������ ��ü
			cbIceF.addItemListener(ifh); // 2. ���ο� ���� �̺�Ʈ���� ��ü
		}

		setVisible(true);
	}

	public static void main(String[] args) {
		IcecreamStoreFrame9 store = new IcecreamStoreFrame9();
	}

	public static final int BUNDLE_OVER = 1; // ��ħ
	public static final int BUNDLE_MATCH = 2; // ��ġ
	public static final int BUNDLE_UNDER = 3; // ����

	public int compareBundleSizeForLimit() {
		int bdSize = this.selIcecreamList.size(); // ��ٱ��� ũ��
		int bdList = ICE_BUNDLE_LIMITS[nBundle]; // ���� ������ �ִ� ���̽�ũ�� ����
		System.out.println("��ٱ��� " + bdSize + " vs ����Ʈ" + bdList);
		if (bdSize > bdList) {
			System.out.println("��ٱ��� ���Ŀ�!!!!!!!!");
			return BUNDLE_OVER;
		} else if (bdSize < bdList) {
			System.out.println("��ٱ��� ���߶��!!!!!!");
			return BUNDLE_UNDER;
		} else {

			System.out.println("��ٱ��Ͽ� ��������ũ�� ��ġ!! => �ֹ�����!!");
			return BUNDLE_MATCH;
		}
	}

	// checkout ��ư
	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ٱ��� ����Ʈ "������" ����
//		for (int i = 0; i < cbIceFlavors.length; i++) {
//			JCheckBox cbIce = cbIceFlavors[i];
//			if( cbIce.isSelected() ) { // ���õ� ���̽�ũ�����ΰ�?
////				System.out.println(
////					i +"��°: " +	cbIce.getText());
//				selIcecreamList.add(i); // ��� size++
//			}
//		}
		int comp = compareBundleSizeForLimit();
		if (comp == BUNDLE_MATCH) {
			// �ֹ��� ��ٱ��� ��� Ȯ��
			System.out.println("-------------------");
			System.out.println(">> �ֹ���ȣ: " + (long)(Math.random()* 10000000010000L));
			System.out.println(">> �ֹ��Ͻ�: " + new Date());
			System.out.println(">> �ֹ��� ��ٱ��� ����Ʈ: " + selIcecreamList.size());
			lbStatus.setText(">> ���õ� ���̽�ũ�� ����: " + selIcecreamList.size() + "��");
			for (int selIceOrder : selIcecreamList) {
				System.out.println(selIceOrder + " : " + ICE_NAMES[selIceOrder]);
			}
		}else {
			System.out.println("������!! ũ�� ����!!");
		}
	}

	// �������� ���°� ����� ������ ��� ����Ǵ� �̺�Ʈ �ڵ鷯.
	// 11���� ���̽�ũ�� üũ�ڽ��� �� �Լ� ����
	// ���õ� ���� �̺�Ʈ���.. ��ٱ��� add(),
	// ��������ϴ� ���� �̺�Ʈ���.. ��ٱ��� remove()..
	@Override
	public void itemStateChanged(ItemEvent ie) {
		System.out.println("������ ���°� �ٲ�����ϴ�! " + new Date());
		JCheckBox cb = (JCheckBox) ie.getItemSelectable();
//		System.out.println(cb.getText());
		for (int i = 0; i < cbIceFlavors.length; i++) {
			if (cb == cbIceFlavors[i]) { // ���ϼ� ��
				System.out.print(i + "��° ���̽�ũ�� üũ�ڽ� ");
//				System.out.println(ICE_NAMES[i]);
				if (ie.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(ICE_NAMES[i] + " ��ٱ��Ͽ� �߰���.");
					selIcecreamList.add(i);
				} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println(ICE_NAMES[i] + " ��ٱ��Ͽ� ������.");
//					selIcecreamList.remove(i); // x ū�ϳ�!! ����!!
					// i��� ����üũ�ڽ� �������� ��ٱ��ϸ���Ʈ���� ������ȣ j�� ã�ƾ���.
					int rmPos = -1;
//					for (int j = 0; j < selIcecreamList.size(); j++) {
//						if( selIcecreamList.get(j) == i ) rmPos = j;
//					}
					rmPos = selIcecreamList.indexOf(i);
					selIcecreamList.remove(rmPos);
				} else {
					System.out.println("????");
				}
				lbStatus.setText(">> ���õ� ���̽�ũ�� ����: " + selIcecreamList.size() + "��");
			}
		}
	}

}