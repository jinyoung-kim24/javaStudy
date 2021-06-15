package meal.foodpackage.mypackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import meal.foodpackage.bill.BillPage;
import meal.foodpackage.bill.BillPage.*;
import meal.foodpackage.bill.confirm.OrderConfirm;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

import db.data.Food;
import db.mgr.FoodDBMgr;
import formeal.FormealMainFrame;
import formeal.shop.ShopPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPackage extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup BUTTON_GROUP = new ButtonGroup();
	ArrayList<Food> foodMenuList;	
	FoodDBMgr mgr;
	OrderListItemPanel totalLists[];
	MyPackage mpe;
	public static int myPackCnt = 0;
	ShopPanel spl;

//	private static final int DEF_TOTAL_ORDER_LIST = 0;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BillPage bill = new BillPage();
//					MyPackage frame = new MyPackage(bill);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @param frm
	 */
	public MyPackage(BillPage frm, String FName, ShopPanel spl) {
		this.spl = spl;
		setResizable(false);
		setTitle("ForMeal");
		setBounds(100, 100, 1000, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 222, 173));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setEnabled(true);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\mrhi05-13\\Desktop\\1\uCC28 \uD504\uB85C\uC81D\uD2B8\\logo.png"));
		lblLogo.setBounds(260, 20, 455, 80);
		contentPane.add(lblLogo);

		JButton btnConfirmed = new JButton("\uD655\uC778 \uC644\uB8CC");
		btnConfirmed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				mpe.setVisible(false);
//				mpe.dispose();
				FormealMainFrame fmm = new FormealMainFrame();
				fmm.setVisible(true);
				
			}
		});
		btnConfirmed.setForeground(Color.WHITE);
		btnConfirmed.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnConfirmed.setBounds(165, 530, 650, 45);
		btnConfirmed.setBackground(new Color(244, 164, 96));
		contentPane.add(btnConfirmed);
		

		JButton btnDelete = new JButton("Cancel");
		btnDelete.setFocusable(false);
		btnDelete.setBackground(new Color(255, 99, 71));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnDelete.setBounds(855, 290, 100, 45);
		contentPane.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 110, 780, 395);
		contentPane.add(scrollPane);

		JPanel pnList = new JPanel();
		scrollPane.setViewportView(pnList);
		pnList.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnListTitle = new JPanel();
		pnList.add(pnListTitle);
		pnListTitle.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel lblNumber = new JLabel("No.");
		lblNumber.setForeground(Color.DARK_GRAY);
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		pnListTitle.add(lblNumber);

		JLabel lblOrderList = new JLabel("\uC8FC\uBB38 \uB0B4\uC5ED");
		lblOrderList.setForeground(Color.DARK_GRAY);
		lblOrderList.setHorizontalAlignment(SwingConstants.CENTER);
		pnListTitle.add(lblOrderList);

		JLabel lblOrderDay = new JLabel("\uC8FC\uBB38 \uB0A0\uC9DC");
		lblOrderDay.setForeground(Color.DARK_GRAY);
		lblOrderDay.setHorizontalAlignment(SwingConstants.CENTER);
		pnListTitle.add(lblOrderDay);

		JLabel lblOrderCondition = new JLabel("\uC8FC\uBB38 \uC0C1\uD0DC");
		lblOrderCondition.setForeground(Color.DARK_GRAY);
		lblOrderCondition.setHorizontalAlignment(SwingConstants.CENTER);
		pnListTitle.add(lblOrderCondition);

		int procedure = myPackCnt;
		this.mgr = new FoodDBMgr();
		this.foodMenuList = mgr.selectMembers(FName);
		String[] foodin = new String[foodMenuList.size()];
		String[] foodqu = new String[foodMenuList.size()];
		ArrayList<Integer> j = new ArrayList<>();
		for (int i = 0; i < foodMenuList.size(); i++) {
			j.add(spl.shops.get(i));
			Food food = foodMenuList.get(i);
			foodin[i] = food.getFooding();
			foodqu[i] = ""+(food.getFoodquantity() * j.get(i));
		}
		totalLists = totalList(procedure, orderList(foodin, foodqu), BUTTON_GROUP);
		for (int count = 0; count < procedure; count++) {
			pnList.add(totalLists[count]);
		}

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int count = 1; count <= totalLists.length; count++) {
					if (totalLists[count - 1].chckbx.isSelected()) {
						pnList.remove(totalLists[count - 1]);
						System.out.println("" + count + totalLists[count - 1].chckbx.isSelected());
					}
				}
			}
		});
	}

	private OrderListItemPanel[] totalList(int procedure, String orderList, ButtonGroup buttonGroup) {
		// JPanel totalLists[] = new JPanel[procedure];
		totalLists = new OrderListItemPanel[procedure];
		for (int Cnt = 0; Cnt < totalLists.length; Cnt++) {
			OrderListItemPanel totalList = new OrderListItemPanel(Cnt, orderList, buttonGroup);
//			totalList.setLayout(new GridLayout(0, 5, 0, 0));
//			totalList.setBackground(new Color(249, 193, 116));
//			for (int topCnt = 0; (topCnt + Cnt) < (Cnt + 1); topCnt++) {
//				JLabel lblNumber = new JLabel("" + (Cnt + 1));
//				lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
//				lblNumber.setForeground(Color.white);
//				JLabel lblOrderList = new JLabel(orderList);
//				lblOrderList.setForeground(Color.white);
//				JLabel lblOrderDay = new JLabel("2021 - 05 - 17");
//				lblOrderDay.setForeground(Color.white);
//				lblOrderDay.setHorizontalAlignment(SwingConstants.CENTER);
//				JLabel lblOrderCondition = new JLabel("¹è¼Û ÁØºñ Áß");
//				lblOrderCondition.setForeground(Color.white);
//				lblOrderCondition.setHorizontalAlignment(SwingConstants.CENTER);
//				JCheckBox chckbx = new JCheckBox("");
//				chckbx.setBackground(new Color(249, 193, 116));
//				chckbx.setHorizontalAlignment(SwingConstants.CENTER);
//				buttonGroup.add(chckbx);
//				totalList.add(lblNumber);
//				totalList.add(lblOrderList);
//				totalList.add(lblOrderDay);
//				totalList.add(lblOrderCondition);
//				totalList.add(chckbx);
//			}
			totalLists[Cnt] = totalList;
		}
		return totalLists;
	}

	private static String orderList(String[] materialName, String[] materialCnt) {
		String orderList = "";
		for (int count = 0; count < materialName.length; count++) {
			if (count != (materialName.length - 1) || count != (materialCnt.length - 1)) {
				orderList += materialName[count] + " " + materialCnt[count] + " / ";
			} else {
				orderList += materialName[count] + " " + materialCnt[count];
			}
		}
		return orderList;
	}
}
