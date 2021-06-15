package formealLogin.joinmember;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Member;
import meal.foodpackage.bill.confirm.OrderConfirm;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class JoinMemberSucceedDiolog extends JDialog {
	JButton okButton;
	JoinMemberSucceedDiolog dlg;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			JoinMemberSucceedDiolog dialog = new JoinMemberSucceedDiolog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public JoinMemberSucceedDiolog() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the dialog.
	 */
	public JoinMemberSucceedDiolog(formealJoinDialog frms) {
		super(frms,true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uB85C\uACE0.png"));
		setBounds(100, 100, 349, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 222, 173));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785\uC774 \uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
			lblNewLabel.setBounds(92, 23, 255, 75);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 222, 173));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("\uD655\uC778");
				okButton.setBackground(new Color(244, 164, 96));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dlg.dispose();
					}
				});
			}
		}
	}

}
