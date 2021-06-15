package formealLogin.joinmember;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Member;
import db.mgr.MemberDBMgr;
import formealLogin.formealLogin;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FormealFindPWDialog extends JDialog {
	MemberDBMgr mgr;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtPhoneNumber;
	formealLogin frm;
	FormealFindPWDialog PWlg;
	JLabel lbID;
	JLabel lbPhoneNumber;
	JLabel lbCheckID;
//	FormealFindIDCheckDialog fidc;
	
	/**
	 * Create the dialog.
	 */
//	public FormealFindIDDialog(formealLogin frm, FormealFindIDCheckDialog fidc) {
		public FormealFindPWDialog(formealLogin frm) {
		super(frm, false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 \uD654\uBA74.png"));
		setTitle("ForMeal \uBE44\uBC00\uBC88\uD638\uCC3E\uAE30");
		MemberDBMgr mgr = new MemberDBMgr();
		this.frm = frm;
//		this.fidc = fidc;
		this.PWlg = this;
		setBounds(100, 100, 502, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lbID = new JLabel("\uC544\uC774\uB514");
			lbID.setHorizontalAlignment(SwingConstants.CENTER);
			lbID.setBounds(98, 85, 57, 15);
			contentPanel.add(lbID);
		}
		{
			lbPhoneNumber = new JLabel("\uC804\uD654\uBC88\uD638");
			lbPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
			lbPhoneNumber.setBounds(98, 144, 57, 15);
			contentPanel.add(lbPhoneNumber);
		}
		
		txtID = new JTextField();
		txtID.setBounds(183, 82, 116, 21);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(183, 141, 116, 21);
		contentPanel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JButton btnCheckID = new JButton("\uC870\uD68C");
		btnCheckID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText();
				String phoneNumber = txtPhoneNumber.getText();
				
			Member start = mgr.checkPW(id, phoneNumber);
			if(start != null) {
				lbCheckID.setText("회원님의 비밀번호는"+start.getId());
				System.out.println("조회 성공");
			} else {
				lbCheckID.setText("등록되지 않는 회원이거나 아이디 또는 전화번호가 잘못되었습니다.");
				lbCheckID.setForeground(Color.RED);
				System.out.println("조회 실패");
			}
//			FormealFindIDCheckDialog fidc 
//			= new FormealFindIDCheckDialog(IDlg);
//			fidc.setVisible(true);
			}
		});
		btnCheckID.setBounds(369, 238, 65, 23);
		contentPanel.add(btnCheckID);
		
		lbCheckID = new JLabel();
		lbCheckID.setHorizontalAlignment(SwingConstants.CENTER);
		lbCheckID.setForeground(Color.BLUE);
		lbCheckID.setBounds(12, 242, 345, 15);
		contentPanel.add(lbCheckID);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\6.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(168, 10, 86, 51);
		contentPanel.add(label);
	}
}
