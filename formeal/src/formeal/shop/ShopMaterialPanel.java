package formeal.shop;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import db.data.Food;
import db.mgr.FoodDBMgr;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

public class ShopMaterialPanel extends JPanel {
	ArrayList<Food> foodMenuList;	
	FoodDBMgr mgr;
	/**
	 * Create the panel.
	 */
	public ShopMaterialPanel(String foodname) {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		this.mgr = new FoodDBMgr();
		this.foodMenuList = mgr.selectMembers(foodname);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		for (int i = 0; i < foodMenuList.size(); i++) {
			Food food = foodMenuList.get(i);
			JLabel lbNum2 = new JLabel();
			lbNum2.setText(""+food.getFoodnum());
			lbNum2.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(lbNum2);
			
			JLabel lbNameIcon2 = new JLabel();
			ImageIcon icon2 = new ImageIcon(food.getFoodimage());
			Image img2 = icon2.getImage();
			Image chageImg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			ImageIcon changeIcon2 = new ImageIcon(chageImg2);
			lbNameIcon2.setIcon(changeIcon2);
			lbNameIcon2.setText(food.getFooding());
			lbNameIcon2.setHorizontalAlignment(SwingConstants.LEADING);
			panel.add(lbNameIcon2);
			
		}
	}
	

}
