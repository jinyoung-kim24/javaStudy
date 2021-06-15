package meal.foodpackage.bill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Food;
import db.mgr.FoodDBMgr;
import formeal.shop.ShopFrame;
import formeal.shop.ShopPanel;
import formeal.ui.foods.FoodsMainFrame6;
import meal.foodpackage.bill.confirm.OrderConfirm;

import meal.recipe.material.MaterialPn;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JScrollPane;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BillPage extends JFrame {

	static final String WON = "\uFFE6";
	static final int DELIVERY_COST = 3000;


	private JPanel contentPane;
	BillPage frm;
	ArrayList<Food> foodMenuList;	
	FoodDBMgr mgr;
	ShopPanel spl;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BillPage frame = new BillPage(foodname);
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
	public BillPage(FoodsMainFrame6 frm1, String foodname, ShopPanel spl) {		
		this.spl = spl;
		setResizable(false);
		this.frm = this;
		setTitle("ForMeal");
		setBounds(100, 100, 1000, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 222, 173));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setIcon(
				new ImageIcon("C:\\Users\\mrhi05-13\\Desktop\\1\uCC28 \uD504\uB85C\uC81D\uD2B8\\logoOnlyText.png"));
		lblLogo.setBounds(260, 20, 455, 80);
		contentPane.add(lblLogo);

		JButton btnOrderConfirm = new JButton("\uC8FC\uBB38!");
		btnOrderConfirm.setForeground(Color.WHITE);
		btnOrderConfirm.setFont(new Font("±¼¸²", Font.BOLD, 18));
		btnOrderConfirm.setBounds(95, 496, 777, 47);
		btnOrderConfirm.setBackground(new Color(244, 164, 96));
		btnOrderConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderConfirm matPn = new OrderConfirm(frm, foodname, spl);
				Point pt = frm.getLocationOnScreen();
				int dx = pt.x + frm.getWidth() / 2 - matPn.getWidth() / 2;
				int dy = pt.y + frm.getHeight() / 2 - matPn.getHeight() / 2;
				matPn.setLocation(dx, dy);
				matPn.setVisible(true);
			}
		});
		contentPane.add(btnOrderConfirm);

		JButton btnOrderChange = new JButton("\uCDE8\uC18C");
		btnOrderChange.setForeground(Color.WHITE);
		btnOrderChange.setFont(new Font("±¼¸²", Font.BOLD, 16));
		btnOrderChange.setBounds(95, 553, 777, 28);
		btnOrderChange.setBackground(new Color(244, 164, 96));
		contentPane.add(btnOrderChange);
		btnOrderChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				ShopFrame orderChange = new ShopFrame(frm1, foodname);
//				orderChange.setVisible(true);
				frm.setVisible(false);
				frm.dispose();
			}
			
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(95, 110, 340, 260);
		contentPane.add(scrollPane);
		JTextArea txtrOrderListTitle = new JTextArea();
		txtrOrderListTitle.setForeground(Color.DARK_GRAY);
		txtrOrderListTitle.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrOrderListTitle.setBackground(new Color(244, 187, 98));
		txtrOrderListTitle.setEditable(false);
		txtrOrderListTitle.setText("\t       Order List");
		scrollPane.setColumnHeaderView(txtrOrderListTitle);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		this.mgr = new FoodDBMgr();
		this.foodMenuList = mgr.selectMembers(foodname);
		for (int i = 0; i < foodMenuList.size(); i++) {
			//ShopPanel spl = new ShopPanel(frm, foodname);
			
			Food food = foodMenuList.get(i);
			JLabel shopNum = new JLabel(""+(i+1));
			panel.add(shopNum);
			JLabel shopName = new JLabel(""+food.getFooding());
			panel.add(shopName);
		}
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setOpaque(false);
		scrollPane_3.setBounds(435, 385, 175, 95);
		contentPane.add(scrollPane_3);
		
		JPanel pnTotalPrice = new JPanel();
		scrollPane_3.setViewportView(pnTotalPrice);
		pnTotalPrice.setLayout(new GridLayout(2, 2, 0, 0));
		int price = 0;
		int TotalPrice = 0;
		
		JLabel deliveryPrice = new JLabel();
		deliveryPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		deliveryPrice.setText("" + 0 + WON);
		pnTotalPrice.add(deliveryPrice);	
		JLabel totalPrice = new JLabel();
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setOpaque(false);
		scrollPane_1.setBounds(435, 110, 175, 260);
		contentPane.add(scrollPane_1);

		JTextArea txtrPriceTitle = new JTextArea();
		txtrPriceTitle.setForeground(Color.DARK_GRAY);
		txtrPriceTitle.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrPriceTitle.setBackground(new Color(244, 187, 98));
		txtrPriceTitle.setEditable(false);
		txtrPriceTitle.setText("         Price");
		scrollPane_1.setColumnHeaderView(txtrPriceTitle);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		ArrayList<Integer> priceArr = new ArrayList<>();
		for (int i = 0; i < foodMenuList.size(); i++) {
			priceArr.add(spl.shops.get(i));
			System.out.println(priceArr);
			Food food = foodMenuList.get(i);
			JLabel shopPrice = new JLabel(""+(food.getFoodprice()*priceArr.get(i)));
			shopPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			panel_1.add(shopPrice);
			price = (food.getFoodprice()*priceArr.get(i));
			TotalPrice += price;
			totalPrice.setText(""+TotalPrice + WON);
			pnTotalPrice.add(totalPrice);
		}

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setOpaque(false);
		scrollPane_2.setBounds(95, 385, 340, 95);
		contentPane.add(scrollPane_2);
		
		JPanel panel_2 = new JPanel();
		scrollPane_2.setViewportView(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uBC30\uC1A1\uBE44");
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561");
		panel_2.add(lblNewLabel);
	}

	

	private static String totalPrice(String[] individualPrice) {
		String[] copyPrice = new String[individualPrice.length];
		for (int count = 0; count < individualPrice.length; count++) {
			for (int secCnt = 0; secCnt < individualPrice[count].length(); secCnt++) {
				copyPrice[count] = individualPrice[count].replace(",", "");
			}
		}
		int[] intPrice = new int[copyPrice.length];
		int totalPrice = 0;
		for (int count = 0; count < copyPrice.length; count++) {
			intPrice[count] = Integer.parseInt(copyPrice[count]);
			totalPrice += intPrice[count];
		}
		int lastTotalPrice = deliveryCost(totalPrice);
		String strTotalPrice = "" + lastTotalPrice;
		String copyTotalPrice = "";
		int leng = 0;
		for (int count = 0; count < strTotalPrice.length(); count++) {
			leng = (count + 1) % 3;
			copyTotalPrice += leng == 0 ? "," + strTotalPrice.charAt(count) : strTotalPrice.charAt(count);
		}
		return copyTotalPrice;
	}
	
	private static String orderList(String material, int matCnt) {
		String orderList = "", tab = "";
		for (int cnt = 0; cnt < material.length(); cnt++) {
			String enter = (cnt == (material.length() - 1)) ? "" : "\r\n";
			tab = material.charAt(cnt) > 2 ? "\t" : "\t\t";
			orderList += (cnt + 1) + ". " + material.charAt(cnt) + tab + material.charAt(cnt) + enter;
		}
		return orderList;
	}

	private static int deliveryCost(int totalPrice) {
		int addDelCstPrice;
		if (totalPrice < 30000) {
			int deliveryCost = 3000;
			addDelCstPrice = totalPrice + deliveryCost;
			return addDelCstPrice;
		} else {
			return totalPrice;
		}
	}
}