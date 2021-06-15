package ui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;

public class JSwingFrame4 extends JFrame implements ActionListener {

	int first; // 100 => btnNum1 ����
	int second; // 50
	JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
	JLabel lbStatus;
	
	// �ɼǹ�ư(üũ�ڽ���ư)
	JToggleButton tgbtn1, tgbtn2, tgbtn3, tgbtn4;
//	JToggleButton[] tgbtns;
	
	
	public JSwingFrame4() {
//		super("����������");
		this("���� ������");
	}

	public JSwingFrame4(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(800, 400);
//		this.setLocation(100, 100);
		this.setBounds(100, 100, 800, 400);

		// ��ġ ������
//		this.setLayout(new BorderLayout()); // ����
//			BorderLayout EWSN + C 5����

		JLabel lb1 = new JLabel("���� ��ư �׽�Ʈ", JLabel.CENTER);
		lb1.setFont(new Font("����", Font.BOLD, 40));

//		this.add(lb1, BorderLayout.NORTH);
		this.getContentPane().add(lb1, BorderLayout.NORTH);

//		JButton btn = new JButton("+"); // add op ���� ��ư
//		this.getContentPane().add(btn, BorderLayout.SOUTH);

		// ��ġ�� 2��, ������, =���, ���� ��ư�� 5��
//		JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
//		btnNum1 = new JButton("100");
//		btnNum2 = new JButton("50");
		this.first = 100;
		this.second = 50;
		btnNum1 = new JButton("" + first);
		btnNum2 = new JButton("" + second);
		// ������ ����
		ImageIcon icNum1 = new ImageIcon("./icons/bell.png");
		ImageIcon icNum2 = new ImageIcon("./icons/bug.png");
		btnNum1.setIcon(icNum1);
		btnNum2.setIcon(icNum2);

		ImageIcon icplus = new ImageIcon("./icons/add.png");
		btnOP = new JButton("");
		btnOP.setIcon(icplus);
		btnCal = new JButton("", new ImageIcon("./icons/calculator.png"));

		btnReset = new JButton("", new ImageIcon("./icons/arrow_refresh.png"));
		btnReset.setToolTipText("���±��");
		Font btFnt = new Font("�ü�", Font.BOLD, 26);

		JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pn1.setBackground(Color.orange);
		pn1.setBorder(new EtchedBorder(Color.RED, Color.darkGray));
		// ��ο� ��Īȿ�� ��輱(border) ����.

		// �г��ϳ��� ��ư 5���� ��� ǥ��
		JButton[] btns = { btnNum1, btnOP, btnNum2, btnCal, btnReset };
		String[] tooltips = { "��ġ1", "������", "��ġ2", "����ϱ�", "�����ϱ�" };

//		pn1.add(btnNum1);
		int i = 0;
		for (JButton jbtn : btns) {
			jbtn.setFont(btFnt);
			jbtn.setToolTipText(tooltips[i++]);
			pn1.add(jbtn);

		}

		getContentPane().add(pn1, BorderLayout.CENTER);
//		getContentPane().add(btnNum1, BorderLayout.WEST);
//		getContentPane().add(btnNum2, BorderLayout.EAST);

		lbStatus = new JLabel("���¹�::", icNum1, JLabel.LEADING);

		lbStatus.setFont(new Font("�ü�", Font.PLAIN, 24));

		getContentPane().add(lbStatus, BorderLayout.SOUTH);

		Font tgFont = lbStatus.getFont(); // ���̺� �̹� ����� ��Ʈ�� ������.
		
		// ������� �� ���������ִ� 4���� �ɼ� ��ư��
		// JToggleButton ��۹�ư: ���� ����(������)/����(�ö��)
		// == ����ġ on/off, up/down, left/right, true/false
		this.tgbtn1 = new JToggleButton("+100");
		tgbtn1.setFont(tgFont);
		this.tgbtn2 = new JToggleButton("x2");
		tgbtn2.setFont(tgFont);
		this.tgbtn3 = new JToggleButton("x10");
		tgbtn3.setFont(tgFont);
		this.tgbtn4 = new JToggleButton("x100");
		tgbtn4.setFont(tgFont);
		
//		JPanel pn2 = new JPanel(); // flowlayout ���������� ��ư 4���� ��ġ
		JPanel pn2 = new JPanel(new GridLayout(4, 1, 20, 10));
						// �׸��� ��ġ(��x��) ����ũ���� ĭ(���̺�)���� ������ �ְ�, ������� ��ġ
		pn2.setBackground(Color.GREEN);
		pn2.add(tgbtn1); // grid cell (0,0)ĭ
		pn2.add(tgbtn2); // grid cell (1,0)ĭ
		pn2.add(tgbtn3); // grid cell (2,0)ĭ
		pn2.add(tgbtn4); // grid cell (3,0)ĭ
		getContentPane().add(pn2, BorderLayout.WEST);
		
		// �̺�Ʈ ���� ó�� -- �̺�Ʈ ������ ���
		btnCal.addActionListener(this);
		// ActionListener �������̽� ������ ��ü�� ���� �ڰ�
		btnNum1.addActionListener(this);
		btnNum2.addActionListener(this);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		JSwingFrame4 frm = new JSwingFrame4();
		frm.setVisible(true); // â

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evBtn = (JButton) e.getSource();
		if (evBtn == btnNum1) {
			// btnNum1 ���
			int r = (int) (Math.random() * 1000) + 1;
			System.out.println("frist ������: " + r);
			this.first = r;
			this.btnNum1.setText("" + first);
			btnNum1.setToolTipText("first ������ " + r);
		}
		// btnNum2 ���
		else if (evBtn == btnNum2) {
			int r2 = (int) (Math.random() * 1000) + 1;
			System.out.println("second ������: " + r2);
			this.second = r2;
			this.btnNum2.setText(String.valueOf(r2));
			btnNum2.setToolTipText("second ������ " + r2);
		} else if (evBtn == btnCal) {
			// btnCal ���
			int result = this.first + this.second;
			System.out.printf("%d + %d = %d \n", first, second, result);
			// �ɼǹ�ư�� ó�� +100 x2 x10 x100
			// �� ��� ��ư���� ���ȳ�? isSelecte() true����?
			if(this.tgbtn1.isSelected() == true) {
				result += 100;
				System.out.println(">> �ɼ� + 100 : " + result);
			}if(this.tgbtn2.isSelected() == true) {
				result *= 2;
				System.out.println(">> �ɼ� x 2 : " + result);
			}if(this.tgbtn3.isSelected() == true) {
				result *= 10;
				System.out.println(">> �ɼ� x 10 : " + result);
			}if(this.tgbtn4.isSelected() == true) {
				result *= 100;
				System.out.println(">> �ɼ� x 100 : " + result);
			}
			
			this.lbStatus.setText("+ ������: " + result);
		} else if (evBtn == btnOP) { // ������
			System.out.println("TBD ���� ����");
		} else if (evBtn == btnReset) { // reset
			System.out.println("TBD ���� ����");
		} else {
			System.out.println("ó�����ϴ� ��ư???");
		}
	}

}
