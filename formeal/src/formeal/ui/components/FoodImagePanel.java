package formeal.ui.components;

import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class FoodImagePanel extends ImagePanel {
	private final JButton button = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");

	/**
	 * Create the panel.
	 */
//	public FoodImagePanel() {
//		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//		setBackground(Color.ORANGE);
//		setLayout(null);
//		
//		JButton btnRecipe = new JButton("\uB808\uC2DC\uD53C \uBCF4\uAE30");
//		btnRecipe.setFont(new Font("±¼¸²", Font.BOLD, 6));
//		btnRecipe.setBounds(92, 121, 72, 23);
//		add(btnRecipe);
//		button.setFont(new Font("±¼¸²", Font.BOLD, 6));
//		button.setBounds(44, 121, 57, 17);
//		add(button);
//
//	}

	public FoodImagePanel(Image bgImg, String imgFilename, int width, int height) {
		super(bgImg, imgFilename, width, height);
		// TODO Auto-generated constructor stub
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setPreferredSize(new Dimension(200,140));
		setBackground(Color.ORANGE);
		setLayout(null);
		
		JButton btnRecipe = new JButton("\uB808\uC2DC\uD53C \uBCF4\uAE30");
		btnRecipe.setFont(new Font("±¼¸²", Font.BOLD, 8));
		btnRecipe.setBounds(10, 120, 80, 24);
		add(btnRecipe);
		button.setFont(new Font("±¼¸²", Font.BOLD, 8));
		button.setBounds(100, 120, 80, 24);
		add(button);
		
		
	}
	

//	public FoodImagePanel(Image bgImg, String imgFilename) {
//		super(bgImg, imgFilename);
//		// TODO Auto-generated constructor stub
//	}
//
//	public FoodImagePanel(Image bgImg) {
//		super(bgImg);
//		// TODO Auto-generated constructor stub
//	}
}
