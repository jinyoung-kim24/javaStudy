package cafe.ui.member;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafe.ui.CafeMainFrame;
import db.mgr.MemberDBMgr;
import db.util.OracleDBUtil;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberLoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLogin;
	private JPasswordField pwLogin;
	CafeMainFrame frm;
	MemberLoginDialog dlg;
	/**
	 * Create the dialog.
	 */
	public MemberLoginDialog(CafeMainFrame frm) {
		super(frm, true);
		this.frm = frm;
		this.dlg = this;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			// x��ư���� �̴�ȭ���ڸ� ������ �������..
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_key.png"));
		setTitle("My CAFE :: \uD68C\uC6D0 \uB85C\uADF8\uC778");
		setBounds(100, 100, 293, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 10, 176, 86);
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778\uBA85:");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				System.out.println("focus get");
				dlg.txtLogin.setForeground(Color.BLACK);
				dlg.txtLogin.setBackground(Color.YELLOW);
				if(dlg.txtLogin.getText().equals("������ �Է�"))
				dlg.txtLogin.setText(""); // �ȳ� ������ ���� ����
			}
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focus lost");
				dlg.txtLogin.setForeground(Color.LIGHT_GRAY);
				dlg.txtLogin.setBackground(Color.WHITE);
				if(dlg.txtLogin.getText().isEmpty()) {
					dlg.txtLogin.setText("������ �Է�");
				}
			}
		});
		txtLogin.setForeground(SystemColor.controlHighlight);
		txtLogin.setText("\uACC4\uC815\uBA85 \uC785\uB825");
		txtLogin.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		pwLogin = new JPasswordField();
		pwLogin.setColumns(10);
		pwLogin.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(pwLogin);
		
		JLabel lbLoginResult = new JLabel("");
		lbLoginResult.setFont(new Font("����", Font.BOLD, 16));
		lbLoginResult.setBounds(53, 103, 176, 15);
		contentPanel.add(lbLoginResult);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String login = txtLogin.getText();
						String pw = new String(pwLogin.getPassword());
						
						// db����
						MemberDBMgr mgr = new MemberDBMgr();
						int r = mgr.loginProcess(login, pw);
						switch (r) {
						case MemberDBMgr.LOGIN_SUCCESS:
							lbLoginResult.setForeground(Color.GREEN);
							lbLoginResult.setText("�α��� ����");
							// ����â�� �α��� ���� ����� ����
							frm.changeLoginState(true, login);
								// login �������� ȸ���� ���� true�� �α��ε� ����.
							dlg.setVisible(false);
							dlg.dispose();
							
							break;
						case MemberDBMgr.LOGIN_FAIL_NOT_FOUND:
							lbLoginResult.setForeground(Color.red);
							lbLoginResult.setText("�α��� ȸ�� ������ ����");
							break;
						case MemberDBMgr.LOGIN_FAIL_PW_MISMATCH:
							break;
						case MemberDBMgr.LOGIN_ERROR:
							break;
						default:
							System.out.println("������!!");
							break;
						}
//						OracleDBUtil.endConnection();
					}
				});
				
				btnLogin.setActionCommand("OK");
				buttonPane.add(btnLogin, BorderLayout.EAST);
				getRootPane().setDefaultButton(btnLogin);
			}
			{
				JLabel lbMemberJoin = new JLabel("\uD68C\uC6D0\uAC00\uC785");
				lbMemberJoin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// �α��� ��ȭâ�� �����(����)
						dlg.setVisible(false);
						// ȸ�� ������ ������ â ǥ��
						MemberJoinFrame joinFrm = new MemberJoinFrame(dlg.frm);
						Point fPt = frm.getLocationOnScreen();
						joinFrm.setLocation(fPt.x+frm.getWidth()+20,fPt.y);
							// ���� ������ â�� ǥ�õ�.
						joinFrm.setVisible(true);
						dlg.dispose();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						lbMemberJoin.setForeground(Color.CYAN);
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						lbMemberJoin.setForeground(Color.BLACK);
					}
					
					
				});
				buttonPane.add(lbMemberJoin, BorderLayout.WEST);
			}
		}
	}
//
//	public MemberLoginDialog(CafeMainFrame frm) {
//		
//	}
}
