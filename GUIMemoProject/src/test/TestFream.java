package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestFream extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFream frame = new TestFream();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFream() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIProject\\icons\\award_star_bronze_1.png"));
		setTitle("\uD14C\uC2A4\uD2B8 \uD504\uB808\uC784\uCC3D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128), 3));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lbTitle = new JLabel("\uC2A4\uC719\uB514\uC790\uC774\uB108 \uD14C\uC2A4\uD2B8");
		lbTitle.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIProject\\icons\\application_go.png"));
		lbTitle.setToolTipText("\uD48D\uC120 \uB3C4\uC6C0\uB9D0");
		lbTitle.setForeground(new Color(0, 255, 0));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("휴먼매직체", Font.BOLD, 36));
		contentPane.add(lbTitle, BorderLayout.NORTH);
		
		JButton btnPay = new JButton("\uACB0\uC81C\uD558\uAE30");
		btnPay.setFont(new Font("휴먼매직체", Font.PLAIN, 46));
		contentPane.add(btnPay, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 191, 216));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("첫번째 버튼");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		// 익명객체 anonymous object 이벤트 핸들러 구현
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 눌렸음!!!");
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIProject\\icons\\arrow_divide.png"));
		panel.add(btnNewButton_4);
	}

}
