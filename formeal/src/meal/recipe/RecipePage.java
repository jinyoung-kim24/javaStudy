package meal.recipe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.ValueOutputStream;

import db.mgr.FoodDBMgr;
import db.mgr.FoodsDBMgr;
import db.mgr.RecipeDBMgr;
import formeal.shop.formealMainFrame;
import formeal.ui.components.FoodImagePanel2;
import db.data.Food;
import db.data.Foods;
import db.data.Recipe;
import meal.recipe.material.DishRecipeTxt;
import meal.recipe.material.MaterialPn;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.AbstractListModel;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class RecipePage extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	public ArrayList<Food> foodMenuList;
	Foods food;
	FoodDBMgr mgr;
	FoodsDBMgr smgr;
	RecipePage frm;
	CardLayout cards;
	CookingProcessPicture process;
	RecipeDBMgr recipeDB;
	ArrayList<Recipe> mainDish;
	ArrayList<Recipe> selDishName;
	final String BEGINNER = "초급";
	final String AMATURE = "중급";
	final String MAVEN = "고급";
	final String M15 = "15분 이내";
	final String M30 = "30분 이내";
	final String M60 = "60분 이내";
	final String HUMAN = "1인";
	final String HUMANS = "2인";
	final String PEOPLE = "3인 이상";
	int keyDishNum = 0;
	formealMainFrame fmf;
	String foodname;
	JPanel pnRecipe;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RecipePage frame = new RecipePage(foodname);
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
	public RecipePage(formealMainFrame fmf, String foodname) {
		this.fmf = fmf;
		this.recipeDB = new RecipeDBMgr();
		this.mainDish = recipeDB.selectAllMembers();
		String mainDishPicture[] = new String[recipeDB.selectAllMembers().size()];
		String dishName[] = new String[recipeDB.selectAllMembers().size()];
		int x = recipeDB.selectFoodMember(foodname).size();
		System.out.println("x = "+x);
		String processPicture[] = new String[x];
		String youtube[] = new String[recipeDB.selectAllMembers().size()];
		int dishNum[] = new int[recipeDB.selectAllMembers().size()];
		String servings[] = new String[recipeDB.selectAllMembers().size()];
		String cookTime[] = new String[recipeDB.selectAllMembers().size()];
		String difficul[] = new String[recipeDB.selectAllMembers().size()];

		cards = new CardLayout();
		
		for (int count = 0; count < mainDish.size(); count++) {
			Recipe rp = mainDish.get(count);
			mainDishPicture[count] = rp.getMainDish();
			dishName[count] = rp.getDishName();
			youtube[count] = rp.getYoutubeAddress();
			dishNum[count] = rp.getDishNum();
//			processPicture[count] = rp.getProcessPicture();
			
			servings[count] = rp.getServings();
			cookTime[count] = rp.getCookingTime();
			difficul[count] = rp.getDifficulty();
		}
		
		
		setResizable(false);
		this.frm = this;
		setTitle("ForMeal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 630);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnOtherCooking = new JButton("\uB2E4\uB978 \uC694\uB9AC \uBCF4\uB7EC \uAC00\uAE30!"); // 다른 요리 보러 가기!
		btnOtherCooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formealMainFrame fmf = new formealMainFrame();
				fmf.setVisible(true);
			}
		});
		btnOtherCooking.setBounds(50, 500, 880, 50);
		btnOtherCooking.setFont(new Font("굴림", Font.BOLD, 20));
		btnOtherCooking.setForeground(new Color(255, 255, 255));
		btnOtherCooking.setBackground(new Color(244, 164, 96));
		contentPane.setLayout(null);
		contentPane.add(btnOtherCooking);

		JPanel pnMainFood = new JPanel();
		pnMainFood.setBounds(50, 120, 440, 350);
		contentPane.add(pnMainFood);
		pnMainFood.setLayout(null);

		JLabel lblMainFoodPicture = new JLabel();
		this.smgr = new FoodsDBMgr();
		this.food = smgr.selectFoodforType(foodname);

		System.out.println(food);
		ImageIcon icon = new ImageIcon(food.getImagePath());
		Image img = icon.getImage();
		icon.setImage(img.getScaledInstance(440, 350, Image.SCALE_SMOOTH));

		lblMainFoodPicture.setIcon(icon);

		System.out.println(food.getImagePath());

		lblMainFoodPicture.setBounds(0, 0, 440, 350);
//		lblMainFoodPicture.updateUI();
		lblMainFoodPicture.repaint();

		pnMainFood.add(lblMainFoodPicture);

		JTextPane txtFoodName = new JTextPane();
		txtFoodName.setForeground(new Color(255, 255, 255));
		txtFoodName.setFont(new Font("굴림", Font.BOLD, 15));
		txtFoodName.setOpaque(false);
		txtFoodName.setText(dishName[keyDishNum]);
		txtFoodName.setEditable(false);
		txtFoodName.setBounds(0, 320, 140, 30);
		pnMainFood.add(txtFoodName);
		pnMainFood.add(lblMainFoodPicture);

		JPanel pnCookingProcess = new JPanel();
		pnCookingProcess.setBounds(515, 120, 260, 260);
		contentPane.add(pnCookingProcess);
		pnCookingProcess.setLayout(null);

		JPanel pnExplanation = new JPanel();
		pnExplanation.setBounds(790, 120, 170, 260);
		contentPane.add(pnExplanation);
		pnExplanation.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("굴림", Font.BOLD, 13));
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(0, 0, 170, 260);
		pnExplanation.add(scrollPane);

		txtTitle = new JTextField();
		txtTitle.setForeground(Color.WHITE);
		txtTitle.setDisabledTextColor(Color.LIGHT_GRAY);
		txtTitle.setEditable(false);
		txtTitle.setFont(new Font("굴림", Font.BOLD, 16));
		txtTitle.setText("RECIPE");
		txtTitle.setBackground(new Color(244, 164, 96));
		scrollPane.setColumnHeaderView(txtTitle);
		txtTitle.setColumns(10);

		JLabel lblYoutube = new JLabel("");
		lblYoutube.setIcon(new ImageIcon("./images/tag/youtube.png"));
		lblYoutube.setBounds(515, 390, 30, 30);
		contentPane.add(lblYoutube);

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("./images/logo/ForMealLogo.png"));
		lblLogo.setBounds(260, 20, 455, 80);
		contentPane.add(lblLogo);

		JButton btnMaterial = new JButton("\uC7AC\uB8CC \uBCF4\uAE30!"); // 재료 보기!
		btnMaterial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MaterialPn MatPn = new MaterialPn(frm, foodname);
				Point pt = frm.getLocationOnScreen();
				int dx = pt.x + frm.getWidth() / 2 - MatPn.getWidth() / 2;
				int dy = pt.y + frm.getHeight() / 2 - MatPn.getHeight() / 2;
				MatPn.setLocation(dx, dy);
				MatPn.setVisible(true);
			}
		});

		JLabel lblPast = new JLabel();
		lblPast.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\ForMealProject\\images\\button\\past1.png"));
		lblPast.setBounds(0, 0, 60, 260);
		lblPast.setVisible(false);
		pnCookingProcess.add(lblPast);

		JLabel lblNext = new JLabel();
		lblNext.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\ForMealProject\\images\\button\\next1.png"));
		lblNext.setBounds(200, 0, 60, 260);
		lblNext.setVisible(false);
		pnCookingProcess.add(lblNext);

//		for (int count = 0; count < DishRecipeTxt.soybeanPasteStew.length; count++) {
//			JLabel btnSelectPicture = new JLabel();
//			btnSelectPicture.setHorizontalAlignment(SwingConstants.CENTER);
//			btnSelectPicture.setFocusable(true);
//			btnSelectPicture.setBackground(Color.WHITE);
//			btnSelectPicture.setIcon(new ImageIcon("./images/button/" + ((count == 0) ? "파란 원.png" : "회색 원.png")));
//			btnSelectPicture.setOpaque(false);
//			btnSelectPicture.setSize(25, 25);
//			btnSelectPicture.setLocation(((260 / DishRecipeTxt.soybeanPasteStew.length)
//					+ (count * (130 / DishRecipeTxt.soybeanPasteStew.length))), 230);
//			pnCookingProcess.add(btnSelectPicture, ("" + count));
//		}

		
//		JPanel pnRecipe = new JPanel();
		pnRecipe = new JPanel();
		pnRecipe.setBounds(0, 0, 260, 260);
		pnCookingProcess.add(pnRecipe);
		pnRecipe.setLayout(cards);
		

		pnRecipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPast.setVisible(true);
				lblNext.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPast.setVisible(false);
				lblNext.setVisible(false);
			}
		});

		JList txtBoxRecipe = new JList(DishRecipeTxt.soybeanPasteStew);
		int cnt, one = 0;
		this.recipeDB = new RecipeDBMgr();
//		this.mainDish = recipeDB.selectFoodMember(foodname);
		selDishName = recipeDB.selectFoodMember(foodname);
		ArrayList<Recipe> rp = recipeDB.selectFoodMember(foodname);
		
		Map<String,Integer> rCntMap 
			= new HashMap<>();
		rCntMap.put("떡국", 6);
		rCntMap.put("김밥", 9);
		
		
		//for (cnt = 0; cnt < recipeDB.selectFoodMember(foodname).size(); cnt++) {
		Recipe food = selDishName.get(0);
		for (cnt = 0; cnt < rCntMap.get(foodname); cnt++) {
			one = cnt + 1;
//			Recipe food = mainDish.get(cnt);
			JPanel RecipeCards = new JPanel();
			JLabel lblCookProcess = new JLabel();
			pnRecipe.add(RecipeCards, ("" + one));
			RecipeCards.setLayout(null);
			System.out.println(food.getProcessPicture());
			lblCookProcess.setIcon(new ImageIcon(food.getProcessPicture() + (one) + ".jpg"));
			lblCookProcess.setBounds(0, 0, 260, 260);
			RecipeCards.add(lblCookProcess);
//			cards.show(pnRecipe, ("" + one));
			RecipeCards.repaint();
		}
			txtBoxRecipe.setForeground(Color.WHITE);
			txtBoxRecipe.setFont(new Font("Monospaced", Font.BOLD, 12));
			txtBoxRecipe.setBackground(new Color(244, 164, 96));
			txtBoxRecipe.setLayoutOrientation(JList.VERTICAL_WRAP);
			scrollPane.setViewportView(txtBoxRecipe);
		pnRecipe.updateUI();
		cards.show(pnRecipe, ("1"));

		lblPast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cards.previous(pnRecipe);
			}
		});

		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cards.next(pnRecipe);
			}
		});

		JTextPane txtYoutubeTag = new JTextPane();
		txtYoutubeTag.setToolTipText(youtube[keyDishNum]);
		txtYoutubeTag.setFont(new Font("굴림", Font.BOLD, 12));
		txtYoutubeTag.setForeground(Color.BLUE);
		txtYoutubeTag.setText(youtube[keyDishNum]);
		txtYoutubeTag.setEditable(false);
		txtYoutubeTag.setBounds(525, 411, 240, 30);
		txtYoutubeTag.setOpaque(false);
		contentPane.add(txtYoutubeTag);

		JLabel lblPersonnel = new JLabel();
		lblPersonnel.setToolTipText(HUMAN);
		lblPersonnel.setIcon(new ImageIcon(servings[0]));
		lblPersonnel.setBounds(820, 390, 30, 30);
		contentPane.add(lblPersonnel);

		JLabel lblTimer = new JLabel();
		lblTimer.setToolTipText(M15);
		lblTimer.setIcon(new ImageIcon(cookTime[0]));
		lblTimer.setBounds(860, 390, 30, 30);
		contentPane.add(lblTimer);

		JLabel lblDifficulty = new JLabel();
		lblDifficulty.setToolTipText(BEGINNER);
		lblDifficulty.setIcon(new ImageIcon(difficul[0]));
		lblDifficulty.setBounds(900, 390, 30, 30);
		contentPane.add(lblDifficulty);

		btnMaterial.setBackground(new Color(244, 164, 96));
		btnMaterial.setForeground(Color.WHITE);
		btnMaterial.setFont(new Font("굴림", Font.BOLD, 12));
		btnMaterial.setBounds(790, 440, 150, 40);
		contentPane.add(btnMaterial);
		
		JButton btnLeft = new JButton("<<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.previous(pnRecipe);
			}
		});
		btnLeft.setBounds(553, 378, 70, 23);
		contentPane.add(btnLeft);
		
		JButton btnRight = new JButton(">>");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.next(pnRecipe);
			}
		});
		btnRight.setBounds(669, 378, 64, 23);
		contentPane.add(btnRight);
	}
}