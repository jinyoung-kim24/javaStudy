package ui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class JSwingFrame2 extends JFrame implements ActionListener {
	
	int first; // 100 => btnNum1 ����
	int second; // 50
	JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
	JLabel lbStatus;
	public JSwingFrame2() {
//		super("����������");
		this("���� ������");
	}
	
	public JSwingFrame2(String title) {
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
		this.first = 100; this.second = 50;
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
		JButton[] btns = {
			btnNum1, btnOP, btnNum2, btnCal, btnReset
		};
		String[] tooltips = {
			"��ġ1", "������", "��ġ2", "����ϱ�", "�����ϱ�"
		};
		
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
		
		// �̺�Ʈ ���� ó�� -- �̺�Ʈ ������ ���
		btnCal.addActionListener(this); 
				// ActionListener �������̽� ������ ��ü�� ���� �ڰ�
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		JSwingFrame2 frm = new JSwingFrame2();
		frm.setVisible(true); // â
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// btnCal ���
		int result = this.first + this.second;
		System.out.printf("%d + %d = %d \n", first, second, result);
		
		this.lbStatus.setText("+ ������: " + result);
	}
	
}
