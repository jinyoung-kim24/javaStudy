package formeal.ui.foods;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formeal.shop.formealMainFrame;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;

public class foodsMainFrame_backup1 extends JFrame {
	private formealMainFrame sfrm;
	private foodsMainFrame_backup1 rfrm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					foodsMainFrame_backup1 frame = new foodsMainFrame_backup1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public foodsMainFrame_backup1() {
		this.sfrm=sfrm;
	}
	
	public foodsMainFrame_backup1(formealMainFrame sfrm) {
		this.sfrm=sfrm;
		getContentPane().setBackground(new Color(255, 222, 173));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 686);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 887, 1);
		panel.setBackground(new Color(255, 222, 173));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		btnNewButton.setBounds(0, 612, 887, 27);
		btnNewButton.setBackground(new Color(244, 164, 96));
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("    \uAC80\uC0C9 \uACB0\uACFC");
		lblNewLabel.setFont(new Font("한컴 바겐세일 B", Font.PLAIN, 25));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\formeal\uB85C\uACE02.png"));
		lblNewLabel.setBounds(277, 0, 358, 171);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		lblNewLabel_1.setBounds(59, 229, 160, 90);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uBD84\uC2DD-\uB5A1\uBCF6\uC774(\uC218\uC8158.png"));
		label.setBounds(260, 229, 160, 90);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		label_1.setBounds(460, 229, 160, 90);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		label_2.setBounds(665, 229, 160, 90);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		label_3.setBounds(59, 410, 160, 90);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uBD84\uC2DD-\uB5A1\uBCF6\uC774(\uC218\uC8158.png"));
		label_4.setBounds(260, 410, 160, 90);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uBD84\uC2DD-\uB5A1\uBCF6\uC774(\uC218\uC8158.png"));
		label_5.setBounds(460, 399, 160, 90);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		label_6.setBounds(665, 399, 160, 90);
		getContentPane().add(label_6);
	}
}
/*
 * for (int i = 0; i < 7; i++) {
			//String text = "메뉴 "+i;
//			String text = "메뉴: "+ "아메리카노" +"\n" 
//					+ "("+"커피"+") " + "\n"
//					+ 1000 + "원";
			String text = 
				"<html> <b style='color:blue'>"+ "아메리카노" +"</b><br>" 
				+ "<i style='font-size: 10pt;color:orange'> ("
							+"커피"+") </i> <br>" 
				+ "<small><i>" + 1000 + "원" + "</i></small></html>";
			ImageIcon icon = new 
				ImageIcon("./images/menu_thumb/아메리카노.PNG");
			JLabel lbFoodMenu = 
				new JLabel(text, icon, JLabel.CENTER);
 */

