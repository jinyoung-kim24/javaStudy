package meal.foodpackage.bill.confirm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formeal.shop.ShopPanel;
import meal.foodpackage.bill.BillPage;
import meal.foodpackage.mypackage.MyPackage;

import java.awt.ComponentOrientation;
import java.awt.Dialog;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;import java.awt.event.MouseListener;

import javax.swing.JLabel;
import java.awt.Color;

public class OrderConfirm extends JDialog {
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			BillPage biil = new BillPage();
//			OrderConfirm dialog = new OrderConfirm(biil);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param frm 
	 */
	public OrderConfirm(BillPage frm, String FName, ShopPanel spl) {
		super(frm, true);
		setResizable(false);
		setBounds(100, 100, 300, 165);
		getContentPane().setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFocusable(false);
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnCancel.setBounds(10, 75, 125, 40);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnCancel);
		
		JButton btnConfirm = new JButton("OK");
		btnConfirm.setFocusable(false);
		btnConfirm.setBackground(new Color(30, 144, 255));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnConfirm.setBounds(150, 75, 125, 40);
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyPackage.myPackCnt++;
				MyPackage myPackPn = new MyPackage(frm, FName, spl);
				frm.dispose();
				myPackPn.setVisible(true);
			}
		});
		getContentPane().add(btnConfirm);
		
		JLabel lblAskOrderConfirm = new JLabel("\uC8FC\uBB38\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		lblAskOrderConfirm.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblAskOrderConfirm.setBounds(80, 20, 135, 15);
		getContentPane().add(lblAskOrderConfirm);
	}
}
