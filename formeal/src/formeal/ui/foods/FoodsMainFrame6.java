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
import db.mgr.FoodDBMgr;
import db.mgr.FoodsDBMgr;
import formeal.shop.formealMainFrame;
import formeal.ui.components.FoodImagePanel;
import formeal.ui.components.FoodImagePanel2;

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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FoodsMainFrame6 extends JFrame {
	public ImageIcon icff;
	//private JPanel contentPane;
	ImagePanel contentPane;
	public ArrayList<Foods> foodsList;
	FoodsDBMgr mgr; 
	formealMainFrame searchfrm;
	foodsMainFrame_backup3 resultfrm;
	
	JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodsMainFrame6 frame = new FoodsMainFrame6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FoodsMainFrame6() {
		
	}
	
	
	
	/**
	 * Create the frame.
	 */
	//formealMainFrame searchfrm,String foodType,String cookMinute,String eatPerson,String cookGrade
	public FoodsMainFrame6(formealMainFrame searchfrm,String foodType,String cookMinute,String eatPerson,String cookGrade, String foodname) {
		this.searchfrm=searchfrm;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\JAVA-WS\\formeal\\images\\mainicon.png"));
		setTitle("MyCafe :: \uC74C\uC2DD \uBA54\uB274\uD310");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 456);
		
		setBackground(new Color(255, 222, 173));
		Image bg = Toolkit.getDefaultToolkit().
				getImage("");
		contentPane = new ImagePanel(
				bg,"bg2.jpg", 526, 456);
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("검색결과");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("한컴 바겐세일 B", Font.BOLD, 32));
		lblNewLabel.setBounds(34, 37, 186, 40);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(266, 97, 209, 294);
		//scrollPane.setOpaque(false);// 투명
		scrollPane.setBackground(new Color(255, 222, 173));
		contentPane.add(scrollPane);
		
		
		
//		JPanel panel = new JPanel();
		panel = new JPanel();
//		panel.dispatchEvent(e);
		panel.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
			System.out.println("dhdhdh");
			}
		});
		
//		panel.setBorder(new MatteBorder(3, 2, 1, 1, 
//				(Color) Color.orange));
		panel.setSize(50,50 );
		panel.setBackground(new Color(255, 222, 173));
		panel.setOpaque(false);
		scrollPane.setViewportView(panel);
		
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbMainLogo = new JLabel("");
		lbMainLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMainLogo.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 4.png"));
		lbMainLogo.setBounds(59, 159, 140, 140);
		contentPane.add(lbMainLogo);
		ImageIcon icon = new ImageIcon("./images/mainlmage.png");
		Image img = icon.getImage();
		Image chageImg = img.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(chageImg);
		lbMainLogo.setIcon(changeIcon);

		


		this.mgr = new FoodsDBMgr();
		this.foodsList = mgr.selectFoodforType(foodType, cookMinute, eatPerson, cookGrade);
//		foodType,cookMinute,eatPerson,cookGrade

		for (int i = 0; i < foodsList.size(); i++) {
		
			
			Foods foods = foodsList.get(i);
			
		ImageIcon icff=	new ImageIcon(foods.getImagePath());
		icff = new ImageIcon(foods.getImagePath());
		FoodImagePanel2 ff = new FoodImagePanel2(icff.getImage(),
				foods.getImagePath(), 200, 150, foods.getfoodName());
//				foods.getImagePath(), 200, 150, foodname);
		
		ff.setToolTipText(foods.getfoodName()+" 입니다~!!");
		
		panel.add(ff);
//		
			
		}

		panel.repaint();
	
	}



	@Override
	protected void processMouseEvent(MouseEvent e) {
		System.out.println("ppppppppppppppp");
		super.processMouseEvent(e);
	}
	}
	





