package formeal.shop;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import db.data.Food;
import db.mgr.FoodDBMgr;
import formeal.ui.foods.FoodsMainFrame6;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class ShopPanel extends JPanel {
	
	ArrayList<Food> foodMenuList;	
	FoodDBMgr mgr;
	public ArrayList<Integer> shops;
	public ShopPanel spl;
	/**
	 * Create the panel.
	 */
	public ShopPanel(FoodsMainFrame6 frm,String foodname) {
		setLayout(new GridLayout(0, 1, 0, 0));
		FoodMenuHandler foodHanlder = new FoodMenuHandler(this);
		
		JPanel panel = new JPanel();
		add(panel);
		this.mgr = new FoodDBMgr();
		this.foodMenuList = mgr.selectMembers(foodname);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel NumPanel = new JPanel();
		panel.add(NumPanel);
		NumPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel NameIconPanel = new JPanel();
		panel.add(NameIconPanel);
		NameIconPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel QuantityPanel = new JPanel();
		panel.add(QuantityPanel);
		QuantityPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel PricePanel = new JPanel();
		panel.add(PricePanel);
		PricePanel.setLayout(new GridLayout(0, 1, 0, 0));
		shops = new ArrayList<Integer>();
		for (int i = 0; i < foodMenuList.size(); i++) {
			shops.add(new Integer(1));
			
		}
//		JLabel qq = new JLabel();
//		NumPanel.add(qq);
		for (int i = 0; i < foodMenuList.size(); i++) {			
			Food food = foodMenuList.get(i);
			JLabel lbNum = new JLabel();
			lbNum.setText(""+food.getFoodnum());
			lbNum.setHorizontalAlignment(SwingConstants.CENTER);
			NumPanel.add(lbNum);
			
//			Dimension dim = new Dimension(50, 50);
			JLabel lbNameIcon = new JLabel();
//			lbNameIcon.setIcon(new ImageIcon("./images/잡채/"+ food.getFooding()+".jpg"));
			ImageIcon icon = new ImageIcon(food.getFoodimage());
			Image img = icon.getImage();
			Image chageImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(chageImg);
			lbNameIcon.setIcon(changeIcon);
//			lbNameIcon.setPreferredSize(dim);
			lbNameIcon.setText(food.getFooding());
			lbNameIcon.setHorizontalAlignment(SwingConstants.LEADING);
			NameIconPanel.add(lbNameIcon);
			
//			ArrayList<Integer> shops = new ArrayList<>();
			
			
//			JLabel lbEA = new JLabel();
			JLabel lbEA = new JLabel();
			lbEA.setText(""+shops.get(i));
			lbEA.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel lbMoney = new JLabel();
			JButton min = new JButton();
			min.setText("-");
			min.setHorizontalAlignment(SwingConstants.LEFT);
			min.setBackground(new Color(244,164,96));
			min.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int count = Integer.parseInt(lbEA.getText());
					int price = food.getFoodprice();
					if(count > 0) {
						count--;
					}
					lbEA.setText(String.valueOf(count));
					lbMoney.setText(""+(price * count));
					int n = foodMenuList.get(0).getFoodnum();
					shops.set(food.getFoodnum()-n, count);
					System.out.println(shops);
					
				}
			});
			
//			JButton plus = new JButton();
			JButton plus = new JButton();
			plus.setText("+");
			plus.setHorizontalAlignment(SwingConstants.RIGHT);
			plus.setBackground(new Color(244,164,96));
			plus.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					int count = Integer.parseInt(lbEA.getText());
					int price = food.getFoodprice();
//					if(e.getSource() == plus && count > 0) {
						count++;
//					}
					lbEA.setText(String.valueOf(count));
					lbMoney.setText(String.valueOf((price * count)));
					System.out.println(""+(price * count));
					int n = foodMenuList.get(0).getFoodnum();
					shops.set(food.getFoodnum()-n, count);
					System.out.println(shops);
				}
			});
			
			
			lbMoney.setText(""+food.getFoodprice());
			lbMoney.setHorizontalAlignment(SwingConstants.CENTER);
			PricePanel.add(lbMoney);
			
			QuantityPanel.add(min);
			QuantityPanel.add(lbEA);
			QuantityPanel.add(plus);
		}
	
			
	}
	
	



	public class FoodMenuHandler extends MouseAdapter {
		ShopPanel frm;
		
		public FoodMenuHandler(ShopPanel frm) {
			this.frm = frm;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel foodShop = (JLabel) e.getSource();
			
			for (int i = 0; i < frm.foodMenuList.size(); i++) {
				Food food = frm.foodMenuList.get(i);
				if(foodShop.getText().contains(food.getFoodname())) {
					System.out.println("선택된 음식 " + food.getFooding());
				}
				
			}
		}
	}
}
	
