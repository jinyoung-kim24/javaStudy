package formeal.ui.components;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;


import db.data.Foods;
import db.data.Recipe;
import db.mgr.FormealManagerFrame;
import formeal.shop.ShopFrame;
import formeal.shop.formealMainFrame;
import formeal.ui.foods.FoodsMainFrame6;
import meal.recipe.RecipePage;
import formeal.shop.ShopFrame;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class FoodImagePanel2 extends ImagePanel 
	implements MouseListener {
	 //JButton button = new JButton("\uC7AC\uB8CC \uC7A5\uBC14\uAD6C\uB2C8");
	private FoodImagePanel2 foodMenu;
	JButton btnRecipe;
	JButton btnBasket;
	private FoodsMainFrame6 frm1;
	formealMainFrame fmf;
	/**
	 * Create the panel.
	 */
//	public FoodImagePanel() {
//		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//		setBackground(Color.ORANGE);
//		setLayout(null);
//		
//		JButton btnRecipe = new JButton("\uB808\uC2DC\uD53C \uBCF4\uAE30");
//		btnRecipe.setFont(new Font("굴림", Font.BOLD, 6));
//		btnRecipe.setBounds(92, 121, 72, 23);
//		add(btnRecipe);
//		button.setFont(new Font("굴림", Font.BOLD, 6));
//		button.setBounds(44, 121, 57, 17);
//		add(button);
//
//	}
public FoodImagePanel2() {
	
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//			System.out.println("djdjd");
//			foodMenu.setOpaque(true);
//			foodMenu.setBackground(Color.ORANGE);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				//super.mouseExited(e);
////				foodMenu.setOpaque(false);
//				foodMenu.setBackground(new Color(0, 0, 0, 255));
//			}
//		});
	
		//this(	new ImageIcon("./image/bunsic_foods/김밥.png").getImage(), "김밥.png", 200,150);
//	ImageIcon icff=	new ImageIcon("./image/bunsic_foods/김밥.png");
//	FoodImagePanel ff=new FoodImagePanel(icff.getImage(), 
//			foods.getImagePath(), 200, 150);
//	ff.setToolTipText(foods.getfoodName()+" 입니다~!!");
}
	public FoodImagePanel2(Image bgImg, String imgFilename, int width, int height, String foodname) {
		super(bgImg, imgFilename, width, height);
		foodMenu = this;
		
		
		// TODO Auto-generated constructor stub
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setPreferredSize(new Dimension(200,140));
		setBackground(Color.ORANGE);
		setLayout(null);
		
		btnRecipe = new JButton("\uB808\uC2DC\uD53C \uBCF4\uAE30");
		
		btnRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("foodname = " + foodname);
				
				RecipePage  recipe = new RecipePage(fmf, foodname);
				recipe.setVisible(true);
			}
		});
		btnRecipe.setFont(new Font("굴림", Font.BOLD, 8));
		btnRecipe.setBackground(Color.ORANGE);
		btnRecipe.setBounds(10, 120, 80, 24);
		
		add(btnRecipe);
		
		btnBasket = new JButton("\uC7AC\uB8CC \uC7A5\uBC14\uAD6C\uB2C8");
		btnBasket.setEnabled(FormealManagerFrame.isWhoLoggedIn());
		btnBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원만 이용가능!");
				
				//선택된 음식의 이름을 진영이 Mgr에 보내줌
				
				String[] slashUnits;
				String[] dotUnits;
				String DfoodName;
					slashUnits =imgFilename.split("/");
					DfoodName = slashUnits[slashUnits.length-1].split("\\.")[0];
					System.out.println(DfoodName);

						
					
					
				
				//System.out.println(imgFilename);
					ShopFrame frm2
				= new ShopFrame(frm1, DfoodName);
				
//				Point fP = frm1.getLocationOnScreen();
//		frm2.setLocation(fP.x+frm1.getWidth()+20,fP.y);
//					// 옆에 나란히 창이 표시
				frm2.setVisible(true);
//				frm1.dispose();
//				foodMenu.setVisible(false);
			}
		});
		btnBasket.setFont(new Font("굴림", Font.BOLD, 8));
		btnBasket.setBackground(Color.ORANGE);
		btnBasket.setBounds(100, 120, 86, 24);
		
		add(btnBasket);
		
		btnBasket.addMouseListener(foodMenu);
		btnRecipe.addMouseListener(foodMenu);
		this.addMouseListener(this);
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		btnBasket.setBackground(Color.ORANGE);
		btnRecipe.setBackground(Color.ORANGE);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("in");
		btnRecipe.setOpaque(true);
		btnRecipe.setBackground(Color.ORANGE);
		btnBasket.setOpaque(true);
		btnBasket.setBackground(Color.ORANGE);		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("out");
		btnRecipe.setOpaque(false);
		btnRecipe.setBackground(Color.LIGHT_GRAY);
		btnBasket.setOpaque(false);
		btnBasket.setBackground(Color.LIGHT_GRAY);
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
		btnBasket.setBackground(Color.ORANGE);
		btnRecipe.setBackground(Color.ORANGE);
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Release");
		
		btnBasket.setBackground(Color.LIGHT_GRAY);
		btnRecipe.setBackground(Color.LIGHT_GRAY);
		
	}
	
	
	
	
	
	
//	@Override
//	protected void processMouseEvent(MouseEvent e) {
//		System.out.println("------------");
//		super.processMouseEvent(e);
//		this.dispatchEvent(e);
//		if( e.getID() == e.MOUSE_ENTERED ){
//			System.out.println("in");
//			if(btnRecipe.equals(e.getID()==e.MOUSE_ENTERED))
//			
//			btnRecipe.setBackground(Color.ORANGE);
//			else if(btnBasket.equals(e.getID()==e.MOUSE_CLICKED));
//			btnBasket.setBackground(Color.ORANGE);
//		}
//		else if(e.getID()==e.MOUSE_EXITED) {
//			
//			System.out.println("out");
////			button.setOpaque(false);
////			button.setBackground(Color.LIGHT_GRAY);
//		}
//		
			}
//	빡에서 만들어 놓은 것을 이미지 패널 처럼 이미지 핸들러 객체의 이미지 카드패널의 주소
//		외부에서 짠 핸들러 코드가 동작코드를 만들어서 유아이에 연결

		
	


//	public FoodImagePanel(Image bgImg, String imgFilename) {
//		super(bgImg, imgFilename);
//		// TODO Auto-generated constructor stub
//	}
//
//	public FoodImagePanel(Image bgImg) {
//		super(bgImg);
//		// TODO Auto-generated constructor stub
//	}

