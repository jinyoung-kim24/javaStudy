package meal.recipe.material;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import meal.recipe.CookingProcessPicture;
import meal.recipe.RecipePage;
import javax.swing.JLabel;

import db.mgr.RecipeDBMgr;
import db.data.Foods;
import db.data.Recipe;

import javax.swing.JList;
import java.awt.Font;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.ComponentOrientation;

public class MaterialPn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	RecipeDBMgr recipeDB;
	ArrayList<Recipe> mainDish;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			RecipePage rep = new RecipePage();
//			MaterialPn dialog = new MaterialPn(rep);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * 
	 * @param rep
	 */
	public MaterialPn(RecipePage rep, String foodName) {
		
		

		
		
		
				
		setResizable(false);
		setBounds(100, 100, 455, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 222, 173));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTitle = new JLabel("    \uC7AC\uB8CC");
			lblTitle.setForeground(Color.GRAY);
			lblTitle.setFont(new Font("±¼¸²", Font.BOLD, 18));
			lblTitle.setBounds(175, 10, 106, 15);
			contentPanel.add(lblTitle);
		}
		
		JTextPane tpList = new JTextPane();
		tpList.setFont(new Font("±¼¸²", Font.BOLD, 12));
		tpList.setForeground(Color.GRAY);
		this.recipeDB = new RecipeDBMgr();
		this.mainDish = recipeDB.selectFoodMember(foodName);	
		for (int i = 0; i < mainDish.size(); i++) {
			Recipe food = mainDish.get(i);
			tpList.setText(food.getMaterial());
		}
		tpList.setEditable(false);
		tpList.setOpaque(false);
		tpList.setBounds(60, 50, 320, 140);
		contentPanel.add(tpList);
	}
}