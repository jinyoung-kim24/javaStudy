package formealLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.mgr.FormealManagerFrame;
import db.mgr.MemberDBMgr;
import formeal.FormealMainFrame;
import formealLogin.joinmember.FormealFindIDDialog;
import formealLogin.joinmember.FormealFindPWDialog;
import formealLogin.joinmember.formealJoinDialog;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class formealLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField passwordField;
	formealLogin frm; // �α��� ������ â
	FormealMainFrame fmain; // ����â
	formealJoinDialog dlg; // �α��� ȸ������ ���̾�α�
	FormealFindIDDialog IDlg; // ���̵� ã��
	FormealFindPWDialog PWDlg; // ��й�ȣ ã��
	FormealManagerFrame fmgr; // ������ â
	JLabel lbFindPw; // �н����� ã��
	JLabel lbFindId; // id ã��
	JLabel lbLoginResult; //���� ���
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					formealLogin frame = new formealLogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	
	/**
	 * Create the frame.
	 */
	public formealLogin(FormealMainFrame frm2) {
		setTitle("ForMeal \uB85C\uADF8\uC778\uCC3D");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 \uD654\uBA74.png"));
		setResizable(false);
		this.fmain = frm2;
		this.frm = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(203, 88, 157, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 135, 157, 21);
		contentPane.add(passwordField);
		fmgr = new FormealManagerFrame(frm, frm2);
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �α���
				String login = txtID.getText();
				String pw = new String(
						passwordField.getPassword());
				
				// db ����
				MemberDBMgr mgr = new MemberDBMgr();
				int r = mgr.loginProcess(login, pw);
				switch (r) {
				case MemberDBMgr.LOGIN_SUCCESS:
					
					if(login.equals("FORMEAL")) {
						fmgr.setVisible(true);
						fmgr.changeLoginState(true, "FORMEAL");
						frm.setVisible(false);
					} else {
//						FormealMainFrame fmm 
//						 = new FormealMainFrame();
						fmain.cl_CardPn.show(fmain.CardPn, "login");
						fmgr.changeLoginState(true, login);
						frm2.setVisible(true);
						frm.setVisible(false);
					}
					break;
				case MemberDBMgr.LOGIN_FAIL_NOT_FOUND:
					lbLoginResult.setForeground(Color.red);
					lbLoginResult.setText("������ �������� �ʽ��ϴ�");
					break;
				case MemberDBMgr.LOGIN_FAIL_PW_MISMATCH:
					lbLoginResult.setForeground(Color.red);
					lbLoginResult.setText("��ȣ�� ��ġ���� �ʽ��ϴ�");
					break;
				case MemberDBMgr.LOGIN_ERROR:	
					lbLoginResult.setText("�α��� ���� �Է�/DB����");
					break;	
				default:
					System.out.println("����");
					break;
				}
				
//				FormealMainFrame.
			}
		});
		
		btnLogin.setFont(new Font("����", Font.BOLD, 12));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(244, 164, 96));
		btnLogin.setBounds(203, 176, 157, 23);
		btnLogin.setActionCommand("OK"); // �⺻���� ���ͱ���� ������
		contentPane.add(btnLogin);
		getRootPane().setDefaultButton(btnLogin); // ���ͱ��
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 4.png"));
		lblNewLabel.setBounds(153, 0, 253, 80);
		contentPane.add(lblNewLabel);
		
		lbFindId = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		lbFindId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ID ã��
				FormealFindIDDialog FID 
					= new FormealFindIDDialog(frm);
				FID.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbFindId.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbFindId.setForeground(Color.BLACK);
			}
		});
		lbFindId.setHorizontalAlignment(SwingConstants.CENTER);
		lbFindId.setBounds(203, 235, 69, 15);
		contentPane.add(lbFindId);
		
		lbFindPw = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lbFindPw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// PW ã��
				FormealFindPWDialog FPD
					= new FormealFindPWDialog(frm);
				FPD.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbFindPw.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbFindPw.setForeground(Color.BLACK);
			}
		});
		lbFindPw.setHorizontalAlignment(SwingConstants.CENTER);
		lbFindPw.setBounds(276, 235, 84, 15);
		contentPane.add(lbFindPw);
		
		lbLoginResult = new JLabel("");
		lbLoginResult.setBounds(203, 209, 157, 15);
		contentPane.add(lbLoginResult);
	}


}
