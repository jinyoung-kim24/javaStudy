package ui.calendarMain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ui.calendarMain.db.data.Member;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class GuiCalendarFrame extends JFrame {
	public static final Font ftDAY = new Font("����", Font.PLAIN, 20);
	public static final Font ftsDAY = new Font("����", Font.BOLD, 20);
	private JPanel contentPane;
	private JTextField txtYear;
	private JTextField txtMonth;
	JLabel lbStatus;
	JLabel[] lbDayOfWeek; // ���� ���̺� �迭 7
	JButton[] btnDays; // ���� ��ư �迭 42 (6�� �з�)

	// readonly getter
	public String getTxtYearText() {
		return txtYear.getText();
	}
	public JTextField getTxtYear() {
		return txtYear;
	}

	public JTextField getTxtMonth() {
		return txtMonth;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCalendarFrame frame = new GuiCalendarFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// �����ؿ� �޷� �˰��� �Լ�
	public void showMyCalGui(int year, int month) {
		// �׷����� ������ �޷����� ǥ�� (������ �޷�)
		// �⵵�� ���� 1582. 10/4 �� => 10/15 �� (10��ġ ���ڰ� �����)
		// 1583����� ���� �⵵ �Է�...
		// �Է� : �⵵, ��
		// => 5/1 ������ ���ϸ� ������ ����.
		// ������� �� �ϼ�, �� ���� (��)�ϼ�, ����(�� ���� ����1���� ����),
		// + �׷����� Ģ�� �޷��� ǥ��(�����Ǵ�)

		int totalDays = 0; // 2021. 5. 1�ϱ����� �� �ϼ���...

		// ���� 1 ~ ���� 2020 �⵵�� �� �ϼ� ��� (2021�� ���⵵/�۳������ ���ϼ� ��)
		for (int y = 1; y < year; y++) {
			if (y % 400 == 0)
				totalDays += 366; // ����
			else if (y % 100 == 0)
				totalDays += 365;// ���
			else if (y % 4 == 0)
				totalDays += 366; // ����
			else
				totalDays += 365;// ���
		} // 2020.12.31������ ��� �ϼ� ��...

		// Ÿ�Ͽ��� 2021�� �����Ǵ�
		boolean bLeap = false;// ���
		if (year % 400 == 0)
			bLeap = true; // ����
		else if (year % 100 == 0)
			bLeap = false;// ���
		else if (year % 4 == 0)
			bLeap = true; // ����
		else
			bLeap = false;// ���

		// Ÿ�Ͽ����� Ÿ�Ͽ� ���������� �� �ϼ� �� ���ϱ� (2�� �������� 29��/28��?)
		// �츮���
		int daysInMonth[] = { 0, 31, bLeap ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int m = 1; m < month; m++) {
			totalDays += daysInMonth[m];
		} // 4.30����..

		// Ÿ�ϳ�Ÿ�Ͽ��� 1���� �߰�
		totalDays++; // 5.1
		// ������� �Ͽ��Ϻ��� �����ϴ� �޷����� ��������.
		// 0�� �Ͽ���, 1�� ������ ~ 6 ����� // ������ 7�Ϸ� ���� �������� ���� ������ȣ.
		// 0 ~ 6 �� ~ ��
		int yoil = totalDays % 7;
//		System.out.println("yoil => " + yoil);

		// �ؽ�Ʈ ��� ������ �޷� ��� (���� ������ ��Ʈ fixed width)
//		System.out.println("MyCalendar::");
//		System.out.println(year + "��" + month + "��");
//		// �Ϸ� ����ĭ�� �����̽��� 4���� ĭ���� ����.
//		System.out.println("============================"); // 28
//		System.out.println(" SUN MON TUE WED THU FRI SAT"); // ���� �÷�
//		System.out.println("============================");

		// ���ϰ��� ���� ���
		final String SPC = "    ";
//		for (int i = 0; i < yoil; i++) {
//			System.out.print(SPC); // ���� 4ĭ�� �����ϸ��� ���
//		}
		// 42�� ���� ��ư ����
		for (JButton dayBtn : btnDays) {
			dayBtn.setText("");
			dayBtn.setEnabled(false);
			dayBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		}

		// ���Ϻ� ��¥�� �ִ��� ���
		for (int day = 1; day <= daysInMonth[month]; day++) {
//			System.out.printf("%4d", day);
			String dayStr = String.format("%4d", day);
			// ����� ���� �� �ְ� ������ ����
			JButton btnDay = btnDays[day + yoil - 1];
			btnDay.setText(dayStr);
			btnDay.setEnabled(true);
			// if((day+yoil) % 7 == 0)
//				System.out.println();
		}
//		System.out.println();
//		System.out.println("============================");
	}

	/**
	 * Create the frame.
	 */

	public GuiCalendarFrame() {
		this(1970, 1);
	}

	public GuiCalendarFrame(int year, int month) {
		setTitle("GUI \uCE98\uB9B0\uB354" + Member.loggedIn);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\calendar.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnTop = new JPanel();
		contentPane.add(pnTop, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("\uB144:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		pnTop.add(lblNewLabel);

		txtYear = new JTextField();
		txtYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtYear.setFont(new Font("����", Font.BOLD, 18));
		pnTop.add(txtYear);
		txtYear.setColumns(4);
		txtYear.setText("" + year);

		JLabel lblNewLabel_1 = new JLabel("\uC6D4:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 18));
		pnTop.add(lblNewLabel_1);

		txtMonth = new JTextField();
		txtMonth.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonth.setFont(new Font("����", Font.BOLD, 18));
		pnTop.add(txtMonth);
		txtMonth.setColumns(2);
		txtMonth.setText(String.valueOf(month));

		JLabel lblNewLabel_2 = new JLabel("          ");
		pnTop.add(lblNewLabel_2);

		JToolBar toolBar = new JToolBar();
		pnTop.add(toolBar);

		JButton bthShow = new JButton("");
		bthShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Integer.parseInt(txtYear.getText());
				int month = Integer.parseInt(txtMonth.getText());
				showMyCalGui(year, month);
			}
		});
		bthShow.setToolTipText("\uB2EC\uB825 \uBCF4\uAE30");
		bthShow.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUIMemoProject\\icons\\eye.png"));
		toolBar.add(bthShow);

		JButton btnToday = new JButton("");
		btnToday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ���� �޷� ǥ�� ó��
				Calendar cal = Calendar.getInstance();
				int nyear = cal.get(Calendar.YEAR);
				int nmonth = cal.get(Calendar.MONTH)+1;
				int nday = cal.get(Calendar.DAY_OF_MONTH);
				//
				txtYear.setText(""+nyear);
				txtMonth.setText(String.valueOf(nmonth));
				showMyCalGui(nyear, nmonth);
				// ���� ���� ��ư ǥ��
				String today = String.valueOf(nday); // "12"
				for (JButton btnDay : btnDays) {
					String strDay = btnDay.getText().trim(); 
								// " 1" => "1"
					if( strDay.equals(today) ) {
						// ���ð� ���� ���� ã����
						btnDay.setBorder(new 
								LineBorder(Color.ORANGE,4));
						break;
					}
				}
			}
		});
		btnToday.setToolTipText("\uC624\uB298 \uB0A0\uC790\uD45C\uC2DC");
		toolBar.add(btnToday);
		btnToday.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUIMemoProject\\icons\\calendar.png"));

		JButton btnPrevMonth = new JButton("");
		btnPrevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �̹��� ǥ��
				int pyear = Integer.parseInt(txtYear.getText());
				int pmonth = Integer.parseInt(txtMonth.getText());

				pmonth--; // 1���޿��� ���� 0����
				if (pmonth == 0) {
					pmonth = 12;
					pyear--;
				}
				txtYear.setText("" + pyear);
				txtMonth.setText("" + pmonth);
				showMyCalGui(pyear, pmonth);
			}
		});
		btnPrevMonth.setToolTipText("\uC774\uC804 \uB2EC \uD45C\uC2DC");
		toolBar.add(btnPrevMonth);
		btnPrevMonth.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUIMemoProject\\icons\\arrow_left.png"));

		JButton btnNextMonth = new JButton("");
		btnNextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qyear = Integer.parseInt(txtYear.getText());
				int qmonth = Integer.parseInt(txtMonth.getText());

				qmonth++; // 1���޿��� ���� 0����
				if (qmonth == 13) {
					qmonth = 1;
					qyear++;
				}
				txtYear.setText("" + qyear);
				txtMonth.setText("" + qmonth);
				showMyCalGui(qyear, qmonth);
			}
		});
		btnNextMonth.setFont(new Font("����", Font.BOLD, 18));
		btnNextMonth.setToolTipText("\uB2E4\uC74C \uB2EC \uD45C\uC2DC");
		toolBar.add(btnNextMonth);
		btnNextMonth.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUIMemoProject\\icons\\arrow_right.png"));

		JPanel pnCenter = new JPanel();
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new GridLayout(7, 7, 0, 0));
		// 49ĭ�� �޷� ����
		// 1�� 7ĭ���� ������� ���̺�� ä��..

		JLabel lbSunday = new JLabel("SUN");
		lbSunday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSunday.setForeground(Color.RED);
		pnCenter.add(lbSunday);

		JLabel lbMonday = new JLabel("MON");
		lbMonday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbMonday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbMonday);

		JLabel lbTuesday = new JLabel("TUE");
		lbTuesday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbTuesday);

		JLabel lbWednesday = new JLabel("WED");
		lbWednesday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbWednesday);

		JLabel lbThursday = new JLabel("THU");
		lbThursday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbThursday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbThursday);

		JLabel lbFriday = new JLabel("FRI");
		lbFriday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbFriday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbFriday);

		JLabel lbSaturday = new JLabel("SAT");
		lbSaturday.setFont(new Font("Broadway", Font.BOLD, 20));
		lbSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSaturday.setForeground(Color.BLUE);
		pnCenter.add(lbSaturday);

		// ���� ���̺� �迭 7
		this.lbDayOfWeek = new JLabel[] { lbSunday, lbMonday, lbTuesday, lbWednesday, lbThursday, lbFriday,
				lbSaturday };

		// ���� ��ư �迭 42 (6�ֺз�)
		final int BTN_LIMIT = 42;
		this.btnDays = new JButton[BTN_LIMIT];
		for (int i = 0; i < btnDays.length; i++) { // 0 ~ 42
			JButton btnDay = new JButton(""); // ���ڹ�ġ�� ���� ���� ��ư
			btnDay.setHorizontalAlignment(JButton.CENTER);

			if (i % 7 == 0) {
				btnDay.setForeground(Color.RED);
				btnDay.setFont(ftsDAY);
			} else if (i % 7 == 6) {
				btnDay.setForeground(Color.BLUE);
				btnDay.setFont(ftsDAY);
			} else {
				btnDay.setForeground(Color.BLACK);
				btnDay.setFont(ftDAY);
			}
			btnDays[i] = btnDay;
			pnCenter.add(btnDay); // gridlayout 7 ~ 48�� ĭ
			btnDay.setEnabled(false); // ��Ȱ��ȭ
		}

		// ��ư �̺�Ʈ ó�� (����)
		DayActionHandler dayHanlder = new DayActionHandler(this);
		for (JButton btnDay : btnDays) { // 42
			btnDay.addActionListener(dayHanlder);
				// �ϳ��� ���� actionPerformed() ���
		}
		
		JPanel pnBottom = new JPanel();
		contentPane.add(pnBottom, BorderLayout.SOUTH);

//		JLabel lbStatus = new JLabel("\uC0C1\uD0DC\uBC14:");
		lbStatus = new JLabel("\uC0C1\uD0DC\uBC14:");
		pnBottom.add(lbStatus);
	}

}
