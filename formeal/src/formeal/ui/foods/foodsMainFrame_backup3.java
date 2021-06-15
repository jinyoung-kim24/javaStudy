package formeal.ui.foods;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Foods;

import db.mgr.FoodsDBMgr;
//import cafe.ui.components.ImagePanel;
//import db.data.Food;
import formeal.shop.formealMainFrame;
import formeal.ui.components.ImagePanel;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;

public class foodsMainFrame_backup3 extends JFrame {
	//ImagePanel contentPane;
	public ArrayList<Foods> sellectFoodsList;
	
	FoodsDBMgr mgr;
	
	private formealMainFrame searchfrm;
	private foodsMainFrame_backup3 resultfrm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					foodsMainFrame_backup3 frame = new foodsMainFrame_backup3();
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
	public foodsMainFrame_backup3() {
		this.searchfrm=searchfrm;
	}
	//
	public foodsMainFrame_backup3(formealMainFrame searchfrm) {
		this.searchfrm=searchfrm;
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
		
		this.mgr = new FoodsDBMgr();
		this.sellectFoodsList = mgr.selectKoreaFood();
		
		for (int i = 0; i < 1; i++) {
			//String text = "메뉴 "+i;
//			String text = "메뉴: "+ "아메리카노" +"\n" 
//					+ "("+"커피"+") " + "\n"
//					+ 1000 + "원";

			Foods foods = sellectFoodsList.get(i);
			String text = 
		"<html> <b style='color:blue'>"+ foods.getfoodType() +"</b><br>" 
		+ "<i style='font-size: 10pt;color:orange'> ("
					+ foods.getfoodName() +") </i> <br>" 
		+ "</i></small></html>";
			
			ImageIcon icon = new 
				ImageIcon(foods.getImagePath());
				//ImageIcon("./images/menu_thumb/아메리카노.PNG");
			JLabel lbfoodImage1 = 
				new JLabel(text, icon, JLabel.CENTER);
		
		
		//JLabel lbfoodImage1 = new JLabel("");
		//lbfoodImage1.setIcon(new ImageIcon("./image/chinafoods/딤섬.PNG"));
		lbfoodImage1.setBounds(59, 229, 160, 90);
		getContentPane().add(lbfoodImage1);
		}
		JLabel lbfoodImage2 = new JLabel("");
		lbfoodImage2.setIcon(new ImageIcon("./image/bunsic_foods/김밥.png"));
		lbfoodImage2.setBounds(260, 229, 160, 90);
		getContentPane().add(lbfoodImage2);
		
		JLabel lbfoodImage3 = new JLabel("");
		lbfoodImage3.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		lbfoodImage3.setBounds(460, 229, 160, 90);
		getContentPane().add(lbfoodImage3);
		
		JLabel lbfoodImage4 = new JLabel("");
		lbfoodImage4.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		lbfoodImage4.setBounds(665, 229, 160, 90);
		getContentPane().add(lbfoodImage4);
		
		JLabel lbfoodImage5 = new JLabel("");
		lbfoodImage5.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		lbfoodImage5.setBounds(59, 410, 160, 90);
		getContentPane().add(lbfoodImage5);
		
		JLabel lbfoodImage6 = new JLabel("");
		lbfoodImage6.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uBD84\uC2DD-\uB5A1\uBCF6\uC774(\uC218\uC8158.png"));
		lbfoodImage6.setBounds(260, 410, 160, 90);
		getContentPane().add(lbfoodImage6);
		
		JLabel lbfoodImage7 = new JLabel("");
		lbfoodImage7.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uBD84\uC2DD-\uB5A1\uBCF6\uC774(\uC218\uC8158.png"));
		lbfoodImage7.setBounds(460, 399, 160, 90);
		getContentPane().add(lbfoodImage7);
		
		JLabel lbfoodImage8 = new JLabel("");
		lbfoodImage8.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\\uAE40\uCE58\uBCF6\uC74C\uBC25.png"));
		lbfoodImage8.setBounds(665, 399, 160, 90);
		getContentPane().add(lbfoodImage8);
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

