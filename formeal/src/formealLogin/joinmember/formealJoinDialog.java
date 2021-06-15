package formealLogin.joinmember;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Member;
import db.mgr.MemberDBMgr;
import formeal.FormealMainFrame;
import formealLogin.formealLogin;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;

public class formealJoinDialog extends JDialog {
	MemberDBMgr mgr;
	formealLogin frm;
	formealJoinDialog dlg;
	FormealMainFrame fmain;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JPasswordField txtpassword2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPostNum;
	JLabel lbID;
	JLabel lbpassword;
	JLabel lbPwCheck;
	JLabel lbBirthday;
	JComboBox year;
	JComboBox month;
	JComboBox day;
	JRadioButton rdmale,rdfemale;
	JLabel lbGender;
	JLabel lbAge;
	JSpinner spinnerAge;
	JLabel lbDup; // 중복체크 표시
	JLabel lbCheckPassword; // 비밀번호 확인 표시
	private JPasswordField txtpassword;



	/**
	 * Create the dialog.
	 */
	public formealJoinDialog(formealLogin frm, FormealMainFrame frm2) {
		super(frm, false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 \uD654\uBA74.png"));
		setTitle("ForMeal \uD68C\uC6D0\uAC00\uC785\uCC3D");
		this.mgr = new MemberDBMgr();
		this.fmain = frm2;
		this.frm = frm;
		this.dlg = this;
		setBounds(100, 100, 1082, 523);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 222, 173));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 165, 0));
			panel.setBounds(331, 66, 424, 301);
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(11, 2, 0, 0));
			{
				lbID = new JLabel("ID");
				lbID.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbID);
			}
			{
				txtId = new JTextField();
				txtId.setForeground(Color.BLACK);
				panel.add(txtId);
				txtId.setColumns(10);
			}
			{
				lbpassword = new JLabel("password");
				lbpassword.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbpassword);
			}
			{
				txtpassword = new JPasswordField();
				txtpassword.addFocusListener(new FocusAdapter() {
//					@Override
//					public void focusGained(FocusEvent arg0) {
//						txtpassword.setBackground(Color.blue);
//					}
//					@Override
//					public void focusLost(FocusEvent e) {
//						txtpassword.setBackground(Color.white);
//					}
				});
				panel.add(txtpassword);
			}
			{
				lbPwCheck = new JLabel("password \uD655\uC778");
				lbPwCheck.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbPwCheck);
			}
			{
				txtpassword2 = new JPasswordField();
				txtpassword2.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
//						txtpassword2.setBackground(Color.yellow);
//						String strPw1 = new String(txtpassword.getPassword());
//						if(strPw1.isEmpty()) {
//							lbCheckPassword.setText("첫번째 패스워드 입력이 필요합니다");
//							lbCheckPassword.setForeground(Color.RED);
//							txtpassword.requestFocusInWindow();
//						}
					}
					@Override
					public void focusLost(FocusEvent e) {
						String pw1 = new String(txtpassword.getPassword());
						String pw2 = new String(txtpassword2.getPassword());
						if(pw1.length() > 0 && pw2.isEmpty()) {
							lbCheckPassword.setText("비밀번호 재확인이 필요합니다");
							lbCheckPassword.setForeground(Color.RED);
						} else {
							if(pw1.length() > 0 && pw2.length() > 0) {
								if(pw2.equals(pw1)) {
									lbCheckPassword.setText("암호가 일치합니다");
									lbCheckPassword.setForeground(Color.blue);
									checkJoinAvailable();
								} else {
									lbCheckPassword.setText("암호가 일치하지 않습니다");
									lbCheckPassword.setForeground(Color.red);
									lbCheckPassword.requestFocusInWindow();
								}
							}
						}
					}
				});
				panel.add(txtpassword2);
			}
			{
				lbBirthday = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
				lbBirthday.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbBirthday);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				
				year = new JComboBox();
				year.setModel(new DefaultComboBoxModel(new String[] {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"}));
				panel_1.add(year);
				
				month = new JComboBox();
				month.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
				panel_1.add(month);
				
				day = new JComboBox();
				day.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				panel_1.add(day);
			}
			{
				lbGender = new JLabel("\uC131\uBCC4");
				lbGender.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbGender);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					rdmale = new JRadioButton("\uB0A8");
					rdmale.setSelected(true);
					buttonGroup.add(rdmale);
					rdmale.setHorizontalAlignment(SwingConstants.LEFT);
					panel_1.add(rdmale);
				}
				{
					rdfemale = new JRadioButton("\uC5EC");
					buttonGroup.add(rdfemale);
					rdfemale.setHorizontalAlignment(SwingConstants.RIGHT);
					panel_1.add(rdfemale);
				}
			}
			{
				JLabel lbName = new JLabel("\uC774\uB984");
				lbName.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbName);
			}
			{
				txtName = new JTextField();
				txtName.setForeground(Color.BLACK);
				panel.add(txtName);
				txtName.setColumns(10);
			}
			{
				JLabel lbAddress = new JLabel("\uC8FC\uC18C");
				lbAddress.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbAddress);
			}
			{
				txtAddress = new JTextField();
				panel.add(txtAddress);
				txtAddress.setColumns(10);
			}
			{
				JLabel lbPostNum = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
				lbPostNum.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbPostNum);
			}
			{
				txtPostNum = new JTextField();
				panel.add(txtPostNum);
				txtPostNum.setColumns(10);
			}
			{
				JLabel lbEmail = new JLabel("e-mail");
				lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbEmail);
			}
			{
				txtEmail = new JTextField();
				panel.add(txtEmail);
				txtEmail.setColumns(11);
			}
			{
				JLabel lbPhoneNumber = new JLabel("\uC804\uD654\uBC88\uD638");
				lbPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbPhoneNumber);
			}
			{
				txtPhoneNumber = new JTextField();
				panel.add(txtPhoneNumber);
				txtPhoneNumber.setColumns(10);
			}
			{
				lbAge = new JLabel("\uB098\uC774");
				lbAge.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbAge);
			}
			
			spinnerAge = new JSpinner();
			spinnerAge.setModel(new SpinnerNumberModel(17, 17, 65, 1));
			panel.add(spinnerAge);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(31, 66, 288, 146);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollBar scrollBar = new JScrollBar();
			panel.add(scrollBar, BorderLayout.EAST);
			
			JTextPane textPane = new JTextPane();
			textPane.setBackground(new Color(255, 165, 0));
			textPane.setText("\u25A0 \uC81C 1\uC870 (\uBAA9\uC801) \r\n\uC774 \uC57D\uAD00\uC740 \uC804\uAE30\uD1B5\uC2E0 \uC0AC\uC5C5\uBC95 \uBC0F \uB3D9 \uBC95 \uC2DC\uD589\uB839\uC5D0 \uC758\uD558\uC5EC \uC6F9\uC0AC\uC774\uD305(\uC774\uD558 \"\uD68C\uC0AC\" \uB77C \uD569\uB2C8\uB2E4.)\uC774 \uC81C\uACF5\uD558\uB294 \uC778\uD130\uB137 \uD648\uD398\uC774\uC9C0 \uC11C\uBE44\uC2A4 \uD398\uC774\uC9C0\uB514 \uD648\uD398\uC774\uC9C0 \uC81C\uC791 \uC11C\uBE44\uC2A4(\uC774\uD558 \"\uC11C\uBE44\uC2A4\" \uB77C \uD569\uB2C8\uB2E4.)\uC758 \uC774\uC6A9\uC870\uAC74 \uBC0F \uC808\uCC28\uC5D0 \uAD00\uD55C \uC0AC\uD56D, \uD68C\uC0AC\uC640 \uC774\uC6A9\uC790\uC758 \uAD8C\uB9AC\uC640 \uC758\uBB34 \uBC0F \uCC45\uC784\uC0AC\uD56D\uC744 \uADDC\uC815\uD568\uC744 \uBAA9\uC801\uC73C\uB85C \uD569\uB2C8\uB2E4.\r\n \r\n\r\n\u25A0 \uC81C 2\uC870 (\uC57D\uAD00\uC758 \uD6A8\uB825\uACFC \uAC1C\uC815) \r\n1. \uC774 \uC57D\uAD00\uC740 \uC804\uAE30\uD1B5\uC2E0\uC0AC\uC5C5\uBC95 \uC81C 31 \uC870, \uB3D9 ");
			panel.add(textPane, BorderLayout.CENTER);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(31, 251, 288, 146);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollBar scrollBar = new JScrollBar();
			panel.add(scrollBar, BorderLayout.EAST);
			
			JTextArea textArea = new JTextArea();
			textArea.setBackground(new Color(255, 165, 0));
			textArea.setText("\u25A0 \uC81C 1\uC870 (\uBAA9\uC801) \r\n\uC774 \uC57D\uAD00\uC740 \uC804\uAE30\uD1B5\uC2E0 \uC0AC\uC5C5\uBC95 \uBC0F \uB3D9 \uBC95 \uC2DC\uD589\uB839\uC5D0 \uC758\uD558\uC5EC \uC6F9\uC0AC\uC774\uD305(\uC774\uD558 \"\uD68C\uC0AC\" \uB77C \uD569\uB2C8\uB2E4.)\uC774 \uC81C\uACF5\uD558\uB294 \uC778\uD130\uB137 \uD648\uD398\uC774\uC9C0 \uC11C\uBE44\uC2A4 \uD398\uC774\uC9C0\uB514 \uD648\uD398\uC774\uC9C0 \uC81C\uC791 \uC11C\uBE44\uC2A4(\uC774\uD558 \"\uC11C\uBE44\uC2A4\" \uB77C \uD569\uB2C8\uB2E4.)\uC758 \uC774\uC6A9\uC870\uAC74 \uBC0F \uC808\uCC28\uC5D0 \uAD00\uD55C \uC0AC\uD56D, \uD68C\uC0AC\uC640 \uC774\uC6A9\uC790\uC758 \uAD8C\uB9AC\uC640 \uC758\uBB34 \uBC0F \uCC45\uC784\uC0AC\uD56D\uC744 \uADDC\uC815\uD568\uC744 \uBAA9\uC801\uC73C\uB85C \uD569\uB2C8\uB2E4.\r\n \r\n\r\n\u25A0 \uC81C 2\uC870 (\uC57D\uAD00\uC758 \uD6A8\uB825\uACFC \uAC1C\uC815) \r\n1. \uC774 \uC57D\uAD00\uC740 \uC804\uAE30\uD1B5\uC2E0\uC0AC\uC5C5\uBC95 \uC81C 31 \uC870, \uB3D9 \uBC95 \uC2DC\uD589\uADDC\uCE59 \uC81C 21\uC870\uC758 2\uC5D0 \uB530\uB77C \uACF5\uC2DC\uC808\uCC28\uB97C \uAC70\uCE5C \uD6C4 \uD648\uD398\uC774\uC9C0\uB97C \uD1B5\uD558\uC5EC \uC774\uB97C \uACF5\uC9C0\uD558\uAC70\uB098 \uC804\uC790\uC6B0\uD3B8 \uAE30\uD0C0\uC758 \uBC29\uBC95\uC73C\uB85C \uC774\uC6A9\uC790\uC5D0\uAC8C \uD1B5\uC9C0\uD568\uC73C\uB85C\uC368 \uD6A8\uB825\uC744 \uBC1C\uC0DD\uD569\uB2C8\uB2E4.\r\n2. \uD68C\uC0AC\uB294 \uBCF8 \uC57D\uAD00\uC744 \uC0AC\uC804 \uACE0\uC9C0 ");
			panel.add(textArea, BorderLayout.CENTER);
		}
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uB2E4\uC74C\uACFC \uAC19\uC774 \uC57D\uAD00\uC5D0 \uB3D9\uC758\uD569\uB2C8\uB2E4.");
		chckbxNewCheckBox.setBackground(new Color(255, 165, 0));
		chckbxNewCheckBox.setBounds(30, 218, 289, 23);
		contentPanel.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("\uB2E4\uC74C\uACFC \uAC19\uC774 \uC57D\uAD00\uC5D0 \uB3D9\uC758\uD569\uB2C8\uB2E4.");
		checkBox.setBackground(new Color(255, 165, 0));
		checkBox.setBounds(31, 407, 288, 23);
		contentPanel.add(checkBox);
		{
			
			lbDup = new JLabel("");			
			lbDup.setForeground(new Color(255, 222, 173));
			lbDup.setBounds(850, 66, 133, 29);
			contentPanel.add(lbDup);
			JButton btnIdCheck = new JButton("\uC911\uBCF5\uCCB4\uD06C");
			btnIdCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 중복체크
					String login = txtId.getText();
					Member mb = mgr.selectMemberLogin(login);
					if( mb == null ) { // 사용가능
						bLoginAvail = true;// 일단 더미 중복x
						lbDup.setText("사용가능합니다 ");
						lbDup.setForeground(Color.blue);
						lbDup.setVisible(true); // available
						checkJoinAvailable();
					} else {
						bLoginAvail = false;
						lbDup.setText("중복된 아이디 입니다");
						lbDup.setForeground(Color.red);
						lbDup.setVisible(true);
					}
				}
				
			});
			
			lbCheckPassword = new JLabel("");
			lbCheckPassword.setForeground(new Color(255, 228, 181));
			lbCheckPassword.setBackground(new Color(255, 255, 255));
			lbCheckPassword.setBounds(767, 122, 247, 29);
			contentPanel.add(lbCheckPassword);
			
			btnIdCheck.setBounds(758, 66, 88, 35);
			contentPanel.add(btnIdCheck);
		}
			
		}
		private boolean bLoginAvail;
		
		protected void checkJoinAvailable() {
			// 가입 입력
			
			String Pw1 = new String(
					txtpassword.getPassword());
			String Pw2 = new String(
					txtpassword2.getPassword());
			if( (Pw1.length() > 0 &&
					Pw2.length() > 0) && bLoginAvail == true
					&& 
					(!txtId.getText().isEmpty() 
							&&	txtId.getText()
							.equals("ID를 입력하세요") == false	) 
					&&
					(txtName.getText().isEmpty() == false 
					&& txtName.getText()
					.equals("실명을 입력하세요") == false)	
					) {
				// 두개 암호 필드값의 내용 비교 일치/불일치
				if( Pw2.equals(Pw1) ) {
					
//						btnMemberJoin.setEnabled(true);		
//						lbJoinResult.setText("암호 일치 ^^");
//						lbJoinResult.setForeground(Color.blue);
				} else {
//						btnMemberJoin.setEnabled(false);				
				}
			}
			
			
		}
		
		{
			JButton btnJoinButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
			btnJoinButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// 회원가입 버튼
					// 회원가입 데이터베이스 처리..
					String id = txtId.getText();
					String pw = new String(txtpassword.getPassword());
					String sy = (String) year.getSelectedItem();
					String sm = (String) month.getSelectedItem();
					String sdy = (String)day.getSelectedItem();
					String birthday =  sy + sm + sdy;
					int gender = rdmale.isSelected() ?
							Member.GENDER_MALE : Member.GENDER_FEMALE; 
					String name = txtName.getText();
					String address = txtAddress.getText();
					String postNum = txtPostNum.getText();
					String email = txtEmail.getText();
					String phoneNumber = txtPhoneNumber.getText();
					int age = (int)spinnerAge.getValue();
					
					Member newMB = new Member(id, pw, birthday, gender, name, address, postNum, email, phoneNumber, age);
					boolean start = mgr.insertNewMember(newMB);
					if( start ) {
						System.out.println("회원가입 성공");
					} else {
						System.out.println("회원가입 실패");
					}
					JoinMemberSucceedDiolog jmsd = new JoinMemberSucceedDiolog(dlg);
					jmsd.setVisible(true);
				}
			});
			btnJoinButton.setBounds(701, 424, 108, 35);
			contentPanel.add(btnJoinButton);
		}
		
		{
		JLabel lbLogo = new JLabel("\r\n");
		lbLogo.setBackground(Color.WHITE);
		lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogo.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\6.png"));
		lbLogo.setBounds(404, 5, 169, 51);
		contentPanel.add(lbLogo);
	}
}

