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

public class FormealFindIDDialog extends JDialog {
	MemberDBMgr mgr;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPhoneNumber;
	formealLogin frm;
	FormealFindIDDialog IDlg;
	JLabel lbCheckID;
//	FormealFindIDCheckDialog fidc;
	
	/**
	 * Create the dialog.
	 */
//	public FormealFindIDDialog(formealLogin frm, FormealFindIDCheckDialog fidc) {
		public FormealFindIDDialog(formealLogin frm) {
		super(frm, false); // super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 \uD654\uBA74.png"));
		setTitle("ForMeal \uC544\uC774\uB514\uCC3E\uAE30");
		MemberDBMgr mgr = new MemberDBMgr();
		this.frm = frm;
//		this.fidc = fidc;
		this.IDlg = this;
		setBounds(100, 100, 502, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbName = new JLabel("\uC774\uB984");
			lbName.setHorizontalAlignment(SwingConstants.CENTER);
			lbName.setBounds(133, 85, 57, 15);
			contentPanel.add(lbName);
		}
		{
			JLabel lbPhoneNumber = new JLabel("\uC804\uD654\uBC88\uD638");
			lbPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
			lbPhoneNumber.setBounds(133, 144, 57, 15);
			contentPanel.add(lbPhoneNumber);
		}
		
		txtName = new JTextField();
		txtName.setBounds(241, 82, 116, 21);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(241, 141, 116, 21);
		contentPanel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\6.png"));
		lblNewLabel.setBounds(195, 10, 86, 51);
		contentPanel.add(lblNewLabel);
		
		JButton btnCheckID = new JButton("\uC870\uD68C");
		btnCheckID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String phoneNumber = txtPhoneNumber.getText();
				
//				Member newMB = new Member(name, phoneNumber);
			Member start = mgr.checkID(name, phoneNumber);
			if(start != null) {
				System.out.println("조회 성공");
				lbCheckID.setText("회원 아이디는 "+ start.getId());
			} else {
				lbCheckID.setText("등록되지 않는 회원이거나 이름 또는 전화번호가 잘못되었습니다.");
				lbCheckID.setForeground(Color.RED);
				System.out.println("조회 실패");
			}
//			FormealFindIDCheckDialog fidc 
//			= new FormealFindIDCheckDialog(IDlg);
//			fidc.setVisible(true);
			}
		});
		btnCheckID.setBounds(409, 234, 65, 23);
		contentPanel.add(btnCheckID);
		
		lbCheckID = new JLabel();
		lbCheckID.setHorizontalAlignment(SwingConstants.CENTER);
		lbCheckID.setForeground(Color.BLUE);
		lbCheckID.setBounds(12, 242, 385, 15);
		contentPanel.add(lbCheckID);
	}
}
