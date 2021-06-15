package formeal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.mgr.FormealManagerFrame;
import JongseaUiComponent.JongseaImageCardPanel;
import formealLogin.formealLogin;
import formealLogin.joinmember.formealJoinDialog;


import db.data.Foods;
import db.mgr.FoodsDBMgr;
import formeal.shop.formealMainFrame;
import formeal.ui.components.FoodImagePanel;
import formeal.ui.components.FoodImagePanel2;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class FormealMainFrame extends JFrame {
	public JPanel CardPn;
	public JPanel panel_1;
	JPanel pnLogout;
	JPanel pnLogin;
	formealLogin fLfrm;
	FormealMainFrame frm;
	FormealManagerFrame fmgr;
	formealJoinDialog dlg;
	FoodImagePanel2 imgp2;
	private JPanel contentPane;
	JLabel lbJoin;
	public CardLayout cl_CardPn;
	
	
	CardLayout foodCdlay;
	JPanel ImageCardPanel;
	public ArrayList<Foods> foodsList;
	FoodsDBMgr mgr;
	/**
	 * Launch the application.
	 */
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormealMainFrame frame = new FormealMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormealMainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\JAVA-WS\\formeal\\images\\mainicon.png"));
		setTitle("ForMeal \uBA54\uC778\uD504\uB808\uC784\uCC3D");
		this.frm = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 587);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnResapiSearch = new JButton("\uB808\uC2DC\uD53C\uAC80\uC0C9");
		btnResapiSearch.setBackground(new Color(244, 164, 96));
		btnResapiSearch.setForeground(Color.WHITE);
		btnResapiSearch.setBounds(636, 75, 121, 38);
		contentPane.add(btnResapiSearch);
		
		JButton btnFindDishSearch = new JButton("\uC6D0\uD558\uB294\uC694\uB9AC\uCC3E\uAE30");
		btnFindDishSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindDishSearch.setForeground(Color.WHITE);
		btnFindDishSearch.setBackground(new Color(244, 164, 96));
		btnFindDishSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				formealMainFrame searchfrm = new formealMainFrame();
				searchfrm.setVisible(true);
			}
		});
		btnFindDishSearch.setBounds(474, 75, 130, 38);
		contentPane.add(btnFindDishSearch);
		
		ImageCardPanel = new JPanel();
		ImageCardPanel.setBounds(80, 129, 356, 277);
		contentPane.add(ImageCardPanel);
		this.foodCdlay = new CardLayout(0, 0);// 카드레이아웃
		ImageCardPanel.setLayout(foodCdlay);
		
		
		this.mgr = new FoodsDBMgr();
		this.foodsList = mgr.selectAllFoods();
		ArrayList<Foods> fdList = frm.foodsList;
		// 이 사이즈의 개수 만큼의 푸드카드패널을 카드레이아웃에 하나씩 붙이고
		// 단 하나의 카드를 우선 표시함.
		for (int i = 0; i < fdList.size(); i++) {
			Foods mnfd = fdList.get(i);
			System.out.println(mnfd);
			JongseaImageCardPanel fdCard = new JongseaImageCardPanel(mnfd);
			
			
			ImageCardPanel.add(fdCard, "card"+mnfd.getfoodName()); //PK
//			pnMenu.add(fdCard, "card"+mnfd.getName()); //UQ
		}
		foodCdlay.show(ImageCardPanel, "card"+fdList.get(0).getfoodName());
			// "card"+음식PK의 키를 가진 카드패널이 표시
//		System.out.println(foodCdlay);
		
		{
		
		JLabel lbAdd = new JLabel("   Tel : 02-xxx-xxxx / Fax : 02-xxx-xxxx / E-mail : abcd1234@gmail.com / \uCC3E\uC544\uC624\uC2DC\uB294 \uC8FC\uC18C : \uC11C\uC6B8\uD2B9\uBCC4\uC2DC \uC131\uB3D9\uAD6C \uC655\uC2ED\uB9AC\uB85C xx - xx xxx\uD638");
		lbAdd.setBounds(12, 536, 963, 15);
		contentPane.add(lbAdd);
		
		CardPn = new JPanel();
		CardPn.setBounds(543, 157, 130, 200);
		contentPane.add(CardPn);
		this.cl_CardPn = new CardLayout(0, 0);
		CardPn.setLayout(cl_CardPn);
		
		
		
		pnLogout = new JPanel();
		pnLogout.setBackground(new Color(249, 193, 116));
		CardPn.add(pnLogout, "logout");
		pnLogout.setLayout(null);
		
		JButton btnLogin = new JButton("Log-in");
		btnLogin.setBackground(new Color(244, 164, 96));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(32, 30, 77, 23);
		pnLogout.add(btnLogin);
		
		lbJoin = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lbJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lbJoin.setForeground(Color.WHITE);
		lbJoin.setBounds(32, 73, 77, 15);
		pnLogout.add(lbJoin);
		lbJoin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				formealJoinDialog dlg =
						new formealJoinDialog(fLfrm, frm);
				dlg.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbJoin.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbJoin.setForeground(Color.black);
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formealLogin fl =
						new formealLogin(frm);
				
				fl.setVisible(true);
			}
		});
		fmgr = new FormealManagerFrame(fLfrm, frm);
		pnLogin = new JPanel();
		pnLogin.setBackground(new Color(244, 164, 96));
		CardPn.add(pnLogin, "login");
		pnLogin.setLayout(null);
		
		JLabel lbLogout = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lbLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					frm.cl_CardPn.show(CardPn, "logout");
					fmgr.changeLoginState(false, "dummy");
					frm.setVisible(true);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbLogout.setForeground(Color.gray);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbLogout.setForeground(Color.black);
				}
		});
		lbLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogout.setBounds(35, 40, 57, 15);
		pnLogin.add(lbLogout);
		
		this.cl_CardPn.show(CardPn, "logout");
		
	}
		
		JButton btnLeft = new JButton("\u25C0");
		btnLeft.setForeground(Color.WHITE);
		btnLeft.setBackground(new Color(244, 164, 96));
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("이전 카드 표시");
				foodCdlay.previous(ImageCardPanel);
			}
		});
		btnLeft.setBounds(80, 406, 105, 27);
		contentPane.add(btnLeft);
		
		JButton btnNewButton_2 = new JButton("\u25B6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("다음  카드 표시");
				
				foodCdlay.next(ImageCardPanel);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(244, 164, 96));
		btnNewButton_2.setBounds(331, 406, 105, 27);
		contentPane.add(btnNewButton_2);
		
		JLabel lbMainLogo = new JLabel("");
		lbMainLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMainLogo.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 4.png"));
		lbMainLogo.setBounds(187, 0, 140, 140);
		contentPane.add(lbMainLogo);
		ImageIcon icon = new ImageIcon("./images/mainlmage.png");
		Image img = icon.getImage();
		Image chageImg = img.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(chageImg);
		lbMainLogo.setIcon(changeIcon);
}
}
