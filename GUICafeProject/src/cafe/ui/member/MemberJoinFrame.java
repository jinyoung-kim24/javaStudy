package cafe.ui.member;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafe.ui.CafeMainFrame;
import cafe.ui.components.ImagePanel;
import db.data.Member;
import db.mgr.MemberDBMgr;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberJoinFrame extends JFrame {

//	private JPanel contentPane;
	ImagePanel contentPane;
	JButton btnMemberJoin;
	CafeMainFrame frm;
	private JTextField txtMemberName;
	private JTextField txtMemberLogin;
	private JPasswordField pwFirst;
	private JPasswordField pwSecond;
	private final ButtonGroup genderGrp = new ButtonGroup();

	MemberDBMgr mgr;
	JLabel lbNoDup;
	JSpinner spinMemberAge;
	JRadioButton rdFemale, rdMale;
	JLabel lbJoinResult;
	/**
	 * Create the frame.
	 */
	public MemberJoinFrame(CafeMainFrame frm) {
		this.mgr = new MemberDBMgr();
		setTitle("My CAFE :: \uD68C\uC6D0 \uAC00\uC785 \uD3FC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_add.png"));
		setResizable(false);
		this.frm = frm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 447);
		ImageIcon icBg = new ImageIcon(".\\images\\bg\\bg3.jpg");
		Image bgImg = icBg.getImage(); 
//		contentPane = new ImagePanel(bgImg
//				.getScaledInstance(424, 448, Image.SCALE_SMOOTH)
//				, "bg3.jpg");
		contentPane = new ImagePanel(
				bgImg, "bg3.jpg", 424, 448); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // ���뷹�̾ƿ�
		
		JLabel lbTitle = new JLabel("My CAFE");
		lbTitle.setForeground(Color.ORANGE);
		lbTitle.setFont(new Font("Chiller", Font.BOLD, 50));
		lbTitle.setBounds(210, 10, 171, 64);
		contentPane.add(lbTitle);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\images\\logo\\coffee_logo.png"));
		lbLogo.setForeground(Color.ORANGE);
		lbLogo.setBounds(68, 10, 64, 64);
		contentPane.add(lbLogo);
		
		btnMemberJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnMemberJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ȸ�� ���� DB ó��..
				//mgr.insertNewMember(name, login, pw, age, gender)
				String name = txtMemberName.getText(); 
				String login = txtMemberLogin.getText();
				String pw = new String( pwFirst.getPassword() ); 
				int age = (Integer)spinMemberAge.getValue();  
				int gender = rdFemale.isSelected() ? 
					Member.GENDER_FEMALE: Member.GENDER_MALE;
				Member newMB = new Member(name, login, pw, age, gender);
				boolean r = mgr.insertNewMember(newMB);
				if(r) {
					lbJoinResult.setText("ȸ�� ���� ����!!");
				} else {
					lbJoinResult.setText("ȸ�� ���� ����!!");
				}
				
			}
		});
		btnMemberJoin.setEnabled(false);
		btnMemberJoin.setFont(new Font("�޸տ�ü", Font.BOLD, 18));
		btnMemberJoin.setBounds(284, 380, 122, 28);
		contentPane.add(btnMemberJoin);
		
//		JLabel lbJoinResult = new JLabel("");
		lbJoinResult = new JLabel("");
		lbJoinResult.setBorder(new LineBorder(Color.GREEN, 1, true));
		lbJoinResult.setBackground(Color.GREEN);
		lbJoinResult.setBounds(12, 347, 394, 28);
		contentPane.add(lbJoinResult);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(121, 94, 262, 242);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uC774\uB984:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		txtMemberName = new JTextField();
		txtMemberName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				txtMemberName.setForeground(Color.black);
				txtMemberName.setBackground(Color.yellow);
				if( txtMemberName.getText()
						.equals("�Ǹ��� �Է��ϼ���") )
					txtMemberName.setText(""); // �ȳ� ������ ���� ����.
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				txtMemberName.setForeground(Color.LIGHT_GRAY);
				txtMemberName.setBackground(Color.WHITE);
				if( txtMemberName.getText()
						.isEmpty() ) 
					txtMemberName.setText("�Ǹ��� �Է��ϼ���");
				checkJoinAvailable();				
			}
		});
		txtMemberName.setText("�Ǹ��� �Է��ϼ���");
		txtMemberName.setFont(new Font("����", Font.BOLD, 14));
		txtMemberName.setForeground(Color.LIGHT_GRAY);
		panel.add(txtMemberName);
		txtMemberName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uACC4\uC815\uBA85:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		txtMemberLogin = new JTextField();
		txtMemberLogin.setForeground(Color.LIGHT_GRAY);
		txtMemberLogin.setText("ID�� �Է��ϼ���");
		txtMemberLogin.setFont(new Font("����", Font.BOLD, 14));
		panel.add(txtMemberLogin);
		txtMemberLogin.setColumns(10);
		txtMemberLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focus get");
				txtMemberLogin.setForeground(Color.black);
				txtMemberLogin.setBackground(Color.yellow);
				if( txtMemberLogin.getText()
						.equals("ID�� �Է��ϼ���") )
					txtMemberLogin.setText(""); // �ȳ� ������ ���� ����.
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				txtMemberLogin.setForeground(Color.LIGHT_GRAY);
				txtMemberLogin.setBackground(Color.WHITE);
				if( txtMemberLogin.getText()
						.isEmpty() ) 
					txtMemberLogin.setText("ID�� �Է��ϼ���");
				checkJoinAvailable();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		pwFirst = new JPasswordField();
		pwFirst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwFirst.setBackground(Color.yellow);
			}
			@Override
			public void focusLost(FocusEvent e) {
				pwFirst.setBackground(Color.white);
			}
		});
		pwFirst.setFont(new Font("����", Font.BOLD, 14));
		panel.add(pwFirst);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		pwSecond = new JPasswordField();
		pwSecond.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwSecond.setBackground(Color.yellow);
				String strPw1 = new String(
					pwFirst.getPassword());// ���ڹ迭 => ���ڿ�
				if( strPw1.isEmpty() ) {
					lbJoinResult.setText("ù��° �н����� �Է� �ʿ�!!");
					lbJoinResult.setForeground(Color.RED);
					pwFirst.requestFocusInWindow();
						// ù��° pw�ʵ�� ��Ŀ���� ���� �̵� ��û..  
						// �ڵ����� �ι��� pw�ʵ��� focusLost()�� �Ͼ..
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				pwSecond.setBackground(Color.white);
				String strPw1 = new String(
						pwFirst.getPassword());
				String strPw2 = new String(
						pwSecond.getPassword());
				if( strPw1.length() > 0 && strPw2.isEmpty() ) {
					lbJoinResult.setText("�ι�° �н����� �Է� �ʿ�!!");
					lbJoinResult.setForeground(Color.PINK);
//					pwSecond.requestFocusInWindow();
						// �ι�° pw�ʵ�� ��Ŀ���� ���� �̵� ��û..
				// } else if(���ڼ� �ּ�, �ִ�...) {	
				} else {
					if( strPw1.length() > 0 &&
							strPw2.length() > 0 ) {
						// �ΰ� ��ȣ �ʵ尪�� ���� �� ��ġ/����ġ
						if( strPw2.equals(strPw1) ) {
							System.out.println("��ȣ ��ġ");
							lbJoinResult.setText("��ȣ ��ġ ^^");
							lbJoinResult.setForeground(Color.blue);
							
							// ���Թ�ư Ȱ��ȭ �Ǵ� �Լ�
							checkJoinAvailable();
						} else {
							System.out.println("��ȣ ����ġ");
							lbJoinResult.setText("��ȣ ����ġ !!");
							lbJoinResult.setForeground(Color.red);
							pwFirst.requestFocusInWindow();
						}
					}
				}
			}
		});
		pwSecond.setFont(new Font("����", Font.BOLD, 14));
		panel.add(pwSecond);
		
		JLabel lblNewLabel_4 = new JLabel("\uD68C\uC6D0 \uB098\uC774:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		//JSpinner spinMemberAge = new JSpinner();
		spinMemberAge = new JSpinner();
		spinMemberAge.setModel(new SpinnerNumberModel(18, 18, 60, 1));
		spinMemberAge.setFont(new Font("����", Font.BOLD, 18));
		panel.add(spinMemberAge);
		
		JLabel lblNewLabel_5 = new JLabel("\uD68C\uC6D0 \uC131\uBCC4: ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		JPanel pnGender = new JPanel();
		pnGender.setBackground(Color.WHITE);
		panel.add(pnGender);
		pnGender.setLayout(new GridLayout(0, 2, 0, 0));
		
//		JRadioButton rdFemale = new JRadioButton("\uC5EC\uC131");
		rdFemale = new JRadioButton("\uC5EC\uC131");
		genderGrp.add(rdFemale);
		rdFemale.setSelected(true);
		rdFemale.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 18));
		rdFemale.setHorizontalAlignment(SwingConstants.CENTER);
		pnGender.add(rdFemale);
		
//		JRadioButton rdMale = new JRadioButton("\uB0A8\uC131");
		rdMale = new JRadioButton("\uB0A8\uC131");
		genderGrp.add(rdMale);
		rdMale.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 18));
		rdMale.setHorizontalAlignment(SwingConstants.CENTER);
		pnGender.add(rdMale);
		
		JButton btnDupCheck = new JButton("");
		btnDupCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inLogin = txtMemberLogin.getText();
				Member mb = mgr.selectOneMemberByLogin(inLogin);
				if( mb == null ) { // ��밡��
					bLoginAvail = true;// �ϴ� ���� �ߺ�x
					lbJoinResult.setText("��밡���� ���̵� ^^");
					lbJoinResult.setForeground(Color.blue);
					lbNoDup.setVisible(true); // available
					checkJoinAvailable();
				} else {
					bLoginAvail = false;
					lbJoinResult.setText("�̹� ������ ���̵� ^^;");
					lbJoinResult.setForeground(Color.red);
					lbNoDup.setVisible(false);
				}
			}
		});
		btnDupCheck.setToolTipText("\uACC4\uC815\uBA85 \uC911\uBCF5\uCCB4\uD06C");
		btnDupCheck.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUICafeProject\\icons\\accept.png"));
		btnDupCheck.setBounds(386, 144, 32, 23);
		contentPane.add(btnDupCheck);
		
		//JLabel lbNoDup = new JLabel("available");
		lbNoDup = new JLabel("available");
		lbNoDup.setForeground(Color.ORANGE);
		lbNoDup.setFont(new Font("����", Font.BOLD, 14));
		lbNoDup.setBounds(33, 152, 76, 15);
		contentPane.add(lbNoDup);
		lbNoDup.setVisible(false);
	}

	private boolean bLoginAvail; // false(�ߺ�)
	
	protected void checkJoinAvailable() {
		// ���� ������ ������ �Էµ��� �غ�Ǿ����� üũ...
		// ����, �ߺ�����, ����, ����.. üũ  => ���� validation (���͸�)
		
		String strPw1 = new String(
				pwFirst.getPassword());
		String strPw2 = new String(
				pwSecond.getPassword());
		if( (strPw1.length() > 0 &&
				strPw2.length() > 0) && bLoginAvail == true
				&& 
				(!txtMemberLogin.getText().isEmpty() 
				 &&	txtMemberLogin.getText()
				 	.equals("ID�� �Է��ϼ���") == false	) 
				&&
				(txtMemberName.getText().isEmpty() == false 
				 && txtMemberName.getText()
				 	.equals("�Ǹ��� �Է��ϼ���") == false)	
				) {
			// �ΰ� ��ȣ �ʵ尪�� ���� �� ��ġ/����ġ
			if( strPw2.equals(strPw1) ) {
				
				btnMemberJoin.setEnabled(true);		
//				lbJoinResult.setText("��ȣ ��ġ ^^");
//				lbJoinResult.setForeground(Color.blue);
			} else {
				btnMemberJoin.setEnabled(false);				
			}
		}
		
		
	}
}
