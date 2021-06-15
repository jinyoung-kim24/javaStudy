package cafe.ui.food;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafe.ui.CafeMainFrame;
import cafe.ui.components.ImagePanel;
import db.data.Food;
import db.mgr.FoodDBMgr;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;
import javax.swing.ScrollPaneConstants;

public class FoodMenuFrame extends JFrame {

	//private JPanel contentPane;
	ImagePanel contentPane;
	public ArrayList<Food> foodMenuList;
	FoodDBMgr mgr; 
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FoodMenuFrame frame = new FoodMenuFrame();
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
	CafeMainFrame frm;
	
	public FoodMenuFrame(CafeMainFrame frm) {
		this.frm = frm;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_go.png"));
		setTitle("MyCafe :: \uC74C\uC2DD \uBA54\uB274\uD310");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 456);
		Image bg = Toolkit.getDefaultToolkit()
				.getImage("./images/bg/bg2.jpg");
		contentPane = new ImagePanel(
				bg, "bg2.jpg", 526, 456);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Foods!");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Brush Script MT", Font.BOLD, 32));
		lblNewLabel.setBounds(34, 37, 186, 40);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(131, 113, 335, 294);
		scrollPane.setOpaque(false);// ����
		scrollPane.setBackground(new Color(0, 255, 0, 255));
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 2, 1, 1, 
				(Color) Color.PINK));
		//panel.setBackground(new Color(0, 255, 0));
		panel.setBackground(new Color(0, 255, 0, 255));
		panel.setOpaque(false);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
//		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		// DB �ε�
		this.mgr = new FoodDBMgr();
		this.foodMenuList = mgr.selectAllFoods();
		
		
		FoodMenuHandler foodHanlder = new FoodMenuHandler(this);
//		for (int i = 0; i < 7; i++) {
		for (int i = 0; i < foodMenuList.size(); i++) {
			//String text = "�޴� "+i;
//			String text = "�޴�: "+ "�Ƹ޸�ī��" +"\n" 
//					+ "("+"Ŀ��"+") " + "\n"
//					+ 1000 + "��";
//			String text = 
//				"<html> <b style='color:blue'>"+ "�Ƹ޸�ī��" +"</b><br>" 
//				+ "<i style='font-size: 10pt;color:orange'> ("
//							+"Ŀ��"+") </i> <br>" 
//				+ "<small><i>" + 1000 + "��" + "</i></small></html>";
			
			Food food = foodMenuList.get(i);
			String text = 
		"<html> <b style='color:blue'>"+ food.getName() +"</b><br>" 
		+ "<i style='font-size: 10pt;color:orange'> ("
					+ food.getCategory() +") </i> <br>" 
		+ "<small><i>" + food.getPrice() + "��" + "</i></small></html>";
			
			ImageIcon icon = new 
				ImageIcon(food.getImagePath());
				//ImageIcon("./images/menu_thumb/�Ƹ޸�ī��.PNG");
			JLabel lbFoodMenu = 
				new JLabel(text, icon, JLabel.CENTER);
			lbFoodMenu.setToolTipText(food.getName() + " Ŭ�� �󼼺���");
			//lbFoodMenu.setToolTipText("�Ƹ޸�ī��" + " Ŭ�� �󼼺���");
			lbFoodMenu.setPreferredSize(
					new Dimension(lbFoodMenu.getWidth(),
							140));
			lbFoodMenu.setBackground(
				new Color(128, 128, 128, 128)); //255));
			lbFoodMenu.setOpaque(false); // ������
			lbFoodMenu.addMouseListener(foodHanlder);// �̺�Ʈ ������ ���
			panel.add(lbFoodMenu);
		}
	}
	
	// Ǫ�θ޴� ���̺� �̺�Ʈ ó�� ����Ŭ���� 
	public class FoodMenuHandler extends MouseAdapter {

		FoodMenuFrame frm;
		
		public FoodMenuHandler(FoodMenuFrame frm) {
			this.frm = frm;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel foodMenu = (JLabel) e.getSource();
//			System.out.println(">> �޴� ����: " 
//					+ foodMenu.getText());
			
			for (int i = 0; i < frm.foodMenuList.size(); i++) {
				Food food = frm.foodMenuList.get(i);
				if( foodMenu.getText()
						.contains(food.getName()) ) {
					System.out.println("���õ� ����: " 
							+ food);
//					���� ��ȣ i
//					db���� ��ȣ food.id
//					���� �̸� food.name
//					FoodCatalogDialog fcDlg
//						= new FoodCatalogDialog(frm, food); // �������� ��ȭâ
						//= new FoodCatalogDialog(frm, i);
						//= new FoodCatalogDialog(frm, food.getId()); //PK
						//= new FoodCatalogDialog(frm, food.getName()); //UQ
					CustomFoodCatalogDialog fcDlg
						= new CustomFoodCatalogDialog(frm, food);
							// ī�巹�̾ƿ��� Ŀ���� ��ȭâ
					Point pt = foodMenu.getLocationOnScreen();
					fcDlg.setLocation(
							(int)(foodMenu.getWidth()*0.8)+pt.x
							, pt.y+60);
					fcDlg.setVisible(true);
				}
			} 
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel foodMenu = (JLabel) e.getSource();
			foodMenu.setOpaque(true);
			foodMenu.setBackground(Color.yellow);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel foodMenu = (JLabel) e.getSource();
			foodMenu.setOpaque(false);
			foodMenu.setBackground(new Color(0, 0, 0, 255));
		}
		
		
	}
}




