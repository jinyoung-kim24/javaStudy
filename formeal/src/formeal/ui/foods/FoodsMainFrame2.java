package formeal.ui.foods;

//import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Foods;
import db.mgr.FoodsDBMgr;
import formeal.shop.formealMainFrame;
import formeal.ui.components.ImagePanel;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;

//import cafe.ui.food.CustomFoodCatalogDialog;
//import cafe.ui.food.FoodMenuFrame;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FoodsMainFrame2 extends JFrame {

	// private JPanel contentPane;
	ImagePanel contentPane;
	public ArrayList<Foods> foodsList;
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
					FoodsMainFrame2 frame = new FoodsMainFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public foodsMainFrame2() {
//		
//	}
	/**
	 * Create the frame.
	 */
	//formealMainFrame searchfrm,String foodType,String cookMinute,String eatPerson,String cookGrade
	public FoodsMainFrame2( 
			
			) {
		//this.searchfrm=searchfrm;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_go.png"));
		setTitle("MyCafe :: \uC74C\uC2DD \uBA54\uB274\uD310");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 456);
		
		setBackground(new Color(255, 222, 173));
		Image bg = Toolkit.getDefaultToolkit().
				getImage("./image/formeal로고3.png");
		contentPane = new ImagePanel(
				bg, "bg2.jpg", 526, 456);
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("검색결과");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("한컴 바겐세일 B", Font.BOLD, 32));
		lblNewLabel.setBounds(34, 37, 186, 40);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(131, 113, 335, 294);
		scrollPane.setOpaque(false);// 투명
		scrollPane.setBackground(new Color(0, 255, 0, 255));
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		
		panel.setBorder(new MatteBorder(3, 2, 1, 1, 
				(Color) Color.orange));
		
		panel.setBackground(new Color(0, 255, 0, 255));
		panel.setOpaque(false);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		
		
//		JButton btnBasket = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
//		btnBasket.setBackground(new Color(244, 164, 96));
//		btnBasket.setFont(new Font("한컴 바겐세일 B", Font.PLAIN, 15));
//		btnBasket.setBounds(361, 48, 105, 27);
//		contentPane.add(btnBasket);

		this.mgr = new FoodsDBMgr();
		this.foodsList = mgr.selectAllFoods();
		//foodType,cookMinute,eatPerson,cookGrade

		for (int i = 0; i < foodsList.size(); i++) {
		
			
			Foods foods = foodsList.get(i);
			String text = 
		"<html> <b style='color:blue'>"+ foods.getfoodType() +"</b><br>" 
		+ "<i style='font-size: 10pt;color:orange'> ("
					+ foods.getfoodName() +") </i> <br>" 
		+ "</html>";
			
			ImageIcon icon = new 
				ImageIcon(foods.getImagePath());
				
			JLabel lbFoodMenu = 
				new JLabel(text, icon, JLabel.CENTER);
			JButton btnBasket= new JButton();
			JButton btnRecipe= new JButton();
			
			panel.setToolTipText(foods.getfoodName() + " 주문하기");
			
			lbFoodMenu.setPreferredSize(
					new Dimension(lbFoodMenu.getWidth(),
							140));
			lbFoodMenu.setBackground(
				new Color(128, 128, 128, 128)); 
			lbFoodMenu.setOpaque(false);
			
			panel.add(btnBasket);
			panel.add(btnRecipe);
			panel.add(lbFoodMenu);
			
		}
	
	}
}
