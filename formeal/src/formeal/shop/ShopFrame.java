package formeal.shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Food;
import db.data.Foods;
import db.mgr.FoodDBMgr;
import db.mgr.FoodsDBMgr;
import formeal.shop.ShopPanel.FoodMenuHandler;
import formeal.ui.components.FoodImagePanel2;
import formeal.ui.foods.FoodsMainFrame6;
import meal.foodpackage.bill.BillPage;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class ShopFrame extends JFrame {

		
	private JPanel contentPane;
	public ArrayList<Food> foodMenuList;
	FoodDBMgr mgr;
	private JTextField txtSearch;
	JLabel lbNum;
	JLabel lbNameIcon;
	JLabel lbEA;
	JLabel lbMoney;
	BillPage bill;
	FoodsMainFrame6 frm1;
	ArrayList<Foods> foodsList;
	FoodsDBMgr smgr;
	ShopFrame sfe;
	Foods foods;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShopFrame frame = new ShopFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ShopFrame(FoodsMainFrame6 frm1,String foodname) {
		setTitle("\uC7A5\uBC14\uAD6C\uB2C8 \uD398\uC774\uC9C0");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\JAVA-WS\\formeal\\images\\mainicon.png"));
		this.frm1=frm1;
		setBounds(100, 100, 1190, 828);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnMainIcon = new JPanel();
		pnMainIcon.setBounds(38, 132, 285, 306);
		contentPane.add(pnMainIcon);
		
		JLabel lbMainIcon = new JLabel("");
		pnMainIcon.add(lbMainIcon);
		this.smgr = new FoodsDBMgr();
		this.foods = smgr.selectFoodforType(foodname);
	
		ImageIcon icon = new ImageIcon(foods.getImagePath());
		Image img = icon.getImage();
		Image chageImg = img.getScaledInstance(285, 306, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(chageImg);
		lbMainIcon.setIcon(changeIcon);
	

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(656, 164, 470, 501);
		contentPane.add(scrollPane);
		
		JPanel pnTitle = new JPanel();
		scrollPane.setColumnHeaderView(pnTitle);
		pnTitle.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lbNumber = new JLabel("\uBC88\uD638");
		lbNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbNumber.setFont(new Font("ªı±º∏≤", Font.BOLD, 18));
		pnTitle.add(lbNumber);
		
		JLabel lbMaterial = new JLabel("\uC7AC\uB8CC");
		lbMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lbMaterial.setFont(new Font("ªı±º∏≤", Font.BOLD, 18));
		pnTitle.add(lbMaterial);
		
		JLabel lbQuantity = new JLabel("\uC218\uB7C9");
		lbQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lbQuantity.setFont(new Font("ªı±º∏≤", Font.BOLD, 18));
		pnTitle.add(lbQuantity);
		
		JLabel lbPrice = new JLabel("\uAC00\uACA9");
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrice.setFont(new Font("ªı±º∏≤", Font.BOLD, 18));
		pnTitle.add(lbPrice);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("\uB354 \uD544\uC694\uD55C \uC7AC\uB8CC\uAC00 \uC788\uC73C\uC2E0\uAC00\uC694?");
		lblNewLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 17));
		lblNewLabel.setBounds(38, 484, 250, 49);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(38, 559, 171, 39);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9!");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Color.ORANGE);
		btnSearch.setBounds(221, 567, 69, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 620, 384, 140);
		contentPane.add(scrollPane_1);
		
		JPanel pnDifferentMaterial = new JPanel();
		scrollPane_1.setViewportView(pnDifferentMaterial);
		pnDifferentMaterial.setLayout(new GridLayout(2, 0, 0, 0));
	
		this.mgr = new FoodDBMgr();
		this.foodMenuList = mgr.selectMembers(foodname);
	

			ShopPanel pnshopPanel = new ShopPanel(frm1, foodname);
			panel.add(pnshopPanel);
			
			
			JButton btnOrder = new JButton("\uC8FC\uBB38");
			btnOrder.setBackground(new Color(244,164,96));
			btnOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bill = new BillPage(frm1, foodname, pnshopPanel);
					bill.setVisible(true);
//					sfe.setVisible(false);
//					sfe.dispose();
				}
			});
			btnOrder.setBounds(656, 705, 470, 55);
			contentPane.add(btnOrder);

			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(346, 132, 256, 306);
			contentPane.add(scrollPane_2);
			
			JPanel pnTitle2 = new JPanel();
			scrollPane_2.setColumnHeaderView(pnTitle2);
			pnTitle2.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblNewLabel_1 = new JLabel("\uBC88\uD638");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			pnTitle2.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("\uC7AC\uB8CC");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			pnTitle2.add(lblNewLabel_2);
			
			JPanel panel_2 = new JPanel();
			scrollPane_2.setViewportView(panel_2);
			ShopMaterialPanel smp = new ShopMaterialPanel(foodname);
			panel_2.add(smp);
			
			JLabel lbMainLogo = new JLabel("");
			contentPane.add(lbMainLogo);
			lbMainLogo.setIcon(new ImageIcon("./icons/logo.png"));
			lbMainLogo.setBounds(260, 20, 455, 80);
			
			JLabel lbmainImage = new JLabel("");
			lbmainImage.setBounds(51, 20, 117, 85);
			contentPane.add(lbmainImage);
			ImageIcon icon2 = new ImageIcon("./images/mainlmage.png");
			Image img2 = icon2.getImage();
			Image chageImg2 = img2.getScaledInstance(117, 85, Image.SCALE_SMOOTH);
			ImageIcon changeIcon2 = new ImageIcon(chageImg2);
			lbmainImage.setIcon(changeIcon2);
	}
}
