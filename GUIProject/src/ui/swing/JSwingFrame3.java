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

public class JSwingFrame3 extends JFrame implements ActionListener {

	int first; // 100 => btnNum1 연결
	int second; // 50
	JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
	JLabel lbStatus;

	public JSwingFrame3() {
//		super("무명프레임");
		this("무명 프레임");
	}

	public JSwingFrame3(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(800, 400);
//		this.setLocation(100, 100);
		this.setBounds(100, 100, 800, 400);

		// 배치 관리자
//		this.setLayout(new BorderLayout()); // 생략
//			BorderLayout EWSN + C 5영역

		JLabel lb1 = new JLabel("스윙 버튼 테스트", JLabel.CENTER);
		lb1.setFont(new Font("굴림", Font.BOLD, 40));

//		this.add(lb1, BorderLayout.NORTH);
		this.getContentPane().add(lb1, BorderLayout.NORTH);

//		JButton btn = new JButton("+"); // add op 덧셈 버튼
//		this.getContentPane().add(btn, BorderLayout.SOUTH);

		// 수치값 2개, 연산자, =계산, 리셋 버튼들 5개
//		JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
//		btnNum1 = new JButton("100");
//		btnNum2 = new JButton("50");
		this.first = 100;
		this.second = 50;
		btnNum1 = new JButton("" + first);
		btnNum2 = new JButton("" + second);
		// 아이콘 파일
		ImageIcon icNum1 = new ImageIcon("./icons/bell.png");
		ImageIcon icNum2 = new ImageIcon("./icons/bug.png");
		btnNum1.setIcon(icNum1);
		btnNum2.setIcon(icNum2);

		ImageIcon icplus = new ImageIcon("./icons/add.png");
		btnOP = new JButton("");
		btnOP.setIcon(icplus);
		btnCal = new JButton("", new ImageIcon("./icons/calculator.png"));

		btnReset = new JButton("", new ImageIcon("./icons/arrow_refresh.png"));
		btnReset.setToolTipText("리셋기능");
		Font btFnt = new Font("궁서", Font.BOLD, 26);

		JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pn1.setBackground(Color.orange);
		pn1.setBorder(new EtchedBorder(Color.RED, Color.darkGray));
		// 페널에 에칭효과 경계선(border) 설정.

		// 패널하나에 버튼 5개를 묶어서 표현
		JButton[] btns = { btnNum1, btnOP, btnNum2, btnCal, btnReset };
		String[] tooltips = { "수치1", "연산자", "수치2", "계산하기", "리셋하기" };

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

		lbStatus = new JLabel("상태바::", icNum1, JLabel.LEADING);

		lbStatus.setFont(new Font("궁서", Font.PLAIN, 24));

		getContentPane().add(lbStatus, BorderLayout.SOUTH);

		// 이벤트 연동 처리 -- 이벤트 리스너 등록
		btnCal.addActionListener(this);
		// ActionListener 인터페이스 구현한 객체가 인자 자격
		btnNum1.addActionListener(this);
		btnNum2.addActionListener(this);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		JSwingFrame3 frm = new JSwingFrame3();
		frm.setVisible(true); // 창

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evBtn = (JButton) e.getSource();
		if (evBtn == btnNum1) {
			// btnNum1 경우
			int r = (int) (Math.random() * 1000) + 1;
			System.out.println("frist 랜덤수: " + r);
			this.first = r;
			this.btnNum1.setText("" + first);
			btnNum1.setToolTipText("first 랜덤수 " + r);
		}
		// btnNum2 경우
		else if (evBtn == btnNum2) {
			int r2 = (int) (Math.random() * 1000) + 1;
			System.out.println("second 랜덤수: " + r2);
			this.second = r2;
			this.btnNum2.setText(String.valueOf(r2));
			btnNum2.setToolTipText("second 랜덤수 " + r2);
		} else if (evBtn == btnCal) {
			// btnCal 경우
			int result = this.first + this.second;
			System.out.printf("%d + %d = %d \n", first, second, result);

			this.lbStatus.setText("+ 연산결과: " + result);
		} else if (evBtn == btnOP) { // 연산자
			System.out.println("TBD 구현 예정");
		} else if (evBtn == btnReset) { // reset
			System.out.println("TBD 구현 예정");
		} else {
			System.out.println("처리못하는 버튼???");
		}
	}

}
