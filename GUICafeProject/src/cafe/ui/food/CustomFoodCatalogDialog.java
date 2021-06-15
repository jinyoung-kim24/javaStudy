package cafe.ui.food;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafe.ui.CafeMainFrame;
import cafe.ui.components.FoodCardPanel;
import db.data.Food;
import db.data.Member;
import db.data.Order;
import db.mgr.FoodDBMgr;
import db.mgr.MemberDBMgr;
import db.mgr.OrderDBMgr;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CustomFoodCatalogDialog extends JDialog {

//	private final JPanel pnMenu = new JPanel();
	JPanel pnMenu;
	CardLayout cdlay; // ī�� ���̾ƿ�
	JToolBar toolBar;
	Food selFood; // ���� ��ȭâ�� ���õ� ����
	CustomFoodCatalogDialog cdlg;
	JButton btnHeart;
	JLabel lbUnitShow;
	JSlider sliderUnit;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			CustomFoodCatalogDialog dialog = new CustomFoodCatalogDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// Ű �̺�Ʈ ó�� ���� Ŭ����
	class MenuKeyHandler extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			System.out.println("��ȭâ Ű���� �̺�Ʈ! " + code);
			switch (code) {
			case KeyEvent.VK_LEFT:
				 System.out.println("���� Ŀ������ Ű");
				 cdlay.previous(pnMenu); // ����ī��
				break;
			case KeyEvent.VK_RIGHT:
				 System.out.println("������ Ŀ������ Ű");
				 cdlay.next(pnMenu); // ����ī��
				break;			
			case KeyEvent.VK_SPACE:
				 System.out.println("�����̽� Ű");
				 cdlay.first(pnMenu); // ó��ī��?
				break;						
			default:
				break;
			}
		}
		
	}
	
	/**
	 * Create the dialog.
	 */
	public CustomFoodCatalogDialog(FoodMenuFrame frm,
			 Food food) {
		super(frm, false); // modaless
		this.selFood = food; // ���� ���õ� ����
		this.cdlg = this;
		//
		// ��ȭ���� Ű���� �̺�Ʈ
		this.setFocusable(true);// ��ȭâ�� ��Ŀ���� ���� �� �ְ�..
		this.setFocusTraversalKeysEnabled(false);
		//
		this.addKeyListener(new MenuKeyHandler());
				// KeyAdpater ���?
//		this.addKeyListener(new KeyAdapter() {
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				super.keyReleased(e);
//			}
//			
//		});
		
		//
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_go.png"));
		setResizable(false);
		setTitle("\uCEE4\uC2A4\uD140 \uD478\uB4DC\uBA54\uB274 \uCE74\uD0C8\uB85C\uADF8");
		setBounds(100, 100, 484, 385);
		getContentPane().setLayout(new BorderLayout());
		
		pnMenu = new JPanel();
		
		pnMenu.setBackground(Color.PINK);
		pnMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnMenu, BorderLayout.CENTER);
		this.cdlay = new CardLayout(0, 0);// ī�巹�̾ƿ�
		pnMenu.setLayout(cdlay);
		
		// fooddbmgr�� ��ȸ�� ������...
		ArrayList<Food> fdList = frm.foodMenuList;
		// �� �������� ���� ��ŭ�� Ǫ��ī���г��� ī�巹�̾ƿ��� �ϳ��� ���̰�
		// �� �ϳ��� ī�带 �켱 ǥ����.
		for (int i = 0; i < fdList.size(); i++) {
			Food mnfd = fdList.get(i);
			FoodCardPanel fdCard = new FoodCardPanel(mnfd);
			//pnMenu.add(fdCard, i);
			pnMenu.add(fdCard, "card"+mnfd.getId()); //PK
//			pnMenu.add(fdCard, "card"+mnfd.getName()); //UQ
		}
		cdlay.show(pnMenu, "card"+food.getId());
			// "card"+����PK�� Ű�� ���� ī���г��� ǥ��
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPrevCard = new JButton("<<");
				btnPrevCard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("���� ī�� ǥ��");
						cdlay.previous(pnMenu);
						// ��ȭ���ڿ��� ��Ŀ�� �̵�
						cdlg.requestFocus();
					}
				});
				buttonPane.add(btnPrevCard);
			}
			{
				JButton btnNextCard = new JButton(">>");
				btnNextCard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("����  ī�� ǥ��");
						cdlay.next(pnMenu);
//						cdlay.first(pnMenu);
//						cdlay.last(pnMenu);
//						cdlay.previous(pnMenu);
//						cdlay.show(parent, name);
						// ��ȭ���ڿ��� ��Ŀ�� �̵�
						cdlg.requestFocus();
					}
				});
				buttonPane.add(btnNextCard);
			}
			{
				//JSlider sliderUnit = new JSlider();
				sliderUnit = new JSlider();
				lbUnitShow = new JLabel("1\uAC1C");
				// �����̴��� ���� ��ȭ �̺�Ʈ ó��...
				sliderUnit.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						JSlider sl = (JSlider) e.getSource();
						int unit = sl.getValue();
						lbUnitShow.setText(unit+"��");
						System.out.println("�����̴� ���� ��ȭ: " + unit);
					}
				});
				sliderUnit.setPreferredSize(new Dimension(140, 38));
				sliderUnit.setToolTipText("\uC8FC\uBB38\uD560 \uBA54\uB274\uC758 \uAC1C\uC218\uB97C \uC785\uB825!");
				sliderUnit.setMinorTickSpacing(1);
				sliderUnit.setMajorTickSpacing(4);
				sliderUnit.setValue(1);
				sliderUnit.setMaximum(21);
				sliderUnit.setSnapToTicks(true);
				sliderUnit.setPaintLabels(true);
				sliderUnit.setPaintTicks(true);
				sliderUnit.setMinimum(1);
				buttonPane.add(sliderUnit);
			}
			{
				String logged = CafeMainFrame.getLoggedIn(); // ����ƽ���ڿ� �α����� ȸ��������
				MemberDBMgr mbMgr = new MemberDBMgr();
				// �α��� ȸ�� ���������� ����Ͽ� db���� �ٽ� �� ȸ���� pk�� ��ȸ..
				Member logMb = mbMgr.selectOneMemberByLogin(logged);
				int logMbPK = logMb.getId();
				FoodDBMgr fdMgr = new FoodDBMgr();
				//
				//JButton btnHeart = new JButton("0");
				int realLikeCnt = fdMgr
						.selectLikeCountForFood(selFood.getId()); 
				//JButton btnHeart = new JButton(""+realLikeCnt);
				btnHeart = new JButton(""+realLikeCnt);
				
				boolean isAlready = 
				fdMgr.isAlreadyLikeFood(selFood.getId(), logMbPK);
				ImageIcon heartAdd = new ImageIcon(  // ���ƿ� ����
"C:\\dev2021\\java_ws\\GUICafeProject\\icons\\heart_add.png");
				ImageIcon heartDel = new ImageIcon( // ���ƿ� �̹� ����..
"C:\\dev2021\\java_ws\\GUICafeProject\\icons\\heart_delete.png");
				
				btnHeart.setIcon(isAlready ? heartDel: heartAdd);
				btnHeart.setToolTipText(isAlready ? 
						"�̹� ���ƿ� �ϼ̳׿�!!" : "Ŭ���Ͻø� ���ƿ� �߰�!!" );
				//
				btnHeart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// ���� Ȱ��ȭ�� ������ ����ϱ�(���ϱ�, ���ƿ�, ��õ..)
						// Ư�� ���İ� Ư�� ȸ���� ���輺 (���ƿ�� ����)
						// ������ ���� �ڽ��� ���ƿ� �ߴ����� ���!!
						// ȸ�� PK(�α��ε� ����), ��� ���� PK
						int foodPK = selFood.getId();
						String logged2 = CafeMainFrame.getLoggedIn(); // ����ƽ���ڿ� �α����� ȸ��������
//						MemberDBMgr mbMgr = new MemberDBMgr();
						// �α��� ȸ�� ���������� ����Ͽ� db���� �ٽ� �� ȸ���� pk�� ��ȸ..
						Member logMb2 = mbMgr.selectOneMemberByLogin(logged2);
						int logMbPK2 = logMb2.getId();
						// ���ƿ� ��� ����, ���ƿ� ��ü ȸ��
						boolean r = fdMgr.addLikeToFood(foodPK, logMbPK2);
						//foodPK ���ĸ޴��� logMbPKȸ���� ���ƿ� �մϴ�.
						if( r ) {
							int rLk = fdMgr.selectLikeCountForFood(foodPK);
							btnHeart.setText(""+rLk);
							changeHeartIcon();
						} else {
							;
						}
					}
				});
				{
//					JLabel lbUnitShow = new JLabel("1\uAC1C");
					lbUnitShow.setFont(new Font("���� ���", Font.PLAIN, 18));
					buttonPane.add(lbUnitShow);
				}
				//btnHeart.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\heart_delete.png"));
				buttonPane.add(btnHeart);
			}
			{
				JButton btnOrder = new JButton("\uC8FC\uBB38");	
				// �α��� �ȵ� ���´� disabled ��Ȱ��ȭ.. �ֹ���ư
				//if( CafeMainFrame.getLoggedIn() == null )
				if( CafeMainFrame.isWhoLoggedIn() == false ) {
					btnOrder.setEnabled(false);
				}
					
				btnOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// �ֹ��ϱ� orders insert
						// ��� �غ�
						int unit = (int)sliderUnit.getValue();
						int totalPrice = 
								cdlg.selFood.getPrice() * unit;
						MemberDBMgr mbMgr = new MemberDBMgr();
//						Member mb = mbMgr.selectOneMemberByLogin(
//								CafeMainFrame.getLoggedIn());
//						int memberId = mb.getId();						
						int memberId = mbMgr.selectOneMemberByLogin( 
							CafeMainFrame.getLoggedIn()).getId();
						// Order ����
						Order newOd =
								new Order(
							Order.generateOrderNumber(), 
							memberId, CafeMainFrame.getLoggedIn(), 
							cdlg.selFood.getId(),
							cdlg.selFood.getName(), 
							unit, totalPrice);
						// OrderDBMgr insert ������
						OrderDBMgr odMgr = new OrderDBMgr();
						boolean r = odMgr.insertNewOrder(newOd);
						if( r ) System.out.println(newOd.getOrderNum() + " �ֹ� ����!");
						else System.out.println(newOd.getOrderNum() + " �ֹ� ����..");
						// ��ó��..
						cdlg.requestFocus();
					}
				});
				buttonPane.add(btnOrder);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.GREEN);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
//				JToolBar toolBar = new JToolBar();
				toolBar = new JToolBar();
				panel.add(toolBar);
				//
				ToolBarSelectHandler tbHandler
				 = new ToolBarSelectHandler(frm, this);
				for (int i = 0; i < fdList.size(); i++) {
					Food tbFood = fdList.get(i);					
					JButton tbBtn; // ������ ���ٿ� ����ϳ���					
					ImageIcon tbIc = 
							new ImageIcon(tbFood.getImagePath());
					// ���پ����� 32x32 ��ũ��
					Image tbIcImg = tbIc.getImage()
						.getScaledInstance(32, 32, Image.SCALE_FAST);
					tbIc.setImage(tbIcImg);					
					tbBtn = new JButton(tbIc);
					tbBtn.repaint();
					tbBtn.setToolTipText(tbFood.getName());
					toolBar.add(tbBtn);
					tbBtn.addActionListener(tbHandler);
				}
			}
		}
	}
	
	public void changeHeartIcon() {
		String logged = CafeMainFrame.getLoggedIn(); // ����ƽ���ڿ� �α����� ȸ��������
		MemberDBMgr mbMgr = new MemberDBMgr();
		// �α��� ȸ�� ���������� ����Ͽ� db���� �ٽ� �� ȸ���� pk�� ��ȸ..
		Member logMb = mbMgr.selectOneMemberByLogin(logged);
		int logMbPK = logMb.getId();
		FoodDBMgr fdMgr = new FoodDBMgr();
			
		boolean isAlready = 
		fdMgr.isAlreadyLikeFood(selFood.getId(), logMbPK);
		ImageIcon heartAdd = new ImageIcon(  // ���ƿ� ����
"C:\\dev2021\\java_ws\\GUICafeProject\\icons\\heart_add.png");
		ImageIcon heartDel = new ImageIcon( // ���ƿ� �̹� ����..
"C:\\dev2021\\java_ws\\GUICafeProject\\icons\\heart_delete.png");
		
		btnHeart.setIcon(isAlready ? heartDel: heartAdd);
		btnHeart.setToolTipText(isAlready ? 
				"�̹� ���ƿ� �ϼ̳׿�!!" : "Ŭ���Ͻø� ���ƿ� �߰�!!" );
	}
	
	// ���� �̺�Ʈ ó�� �� �ڵ鷯 Ŭ����
	class ToolBarSelectHandler implements ActionListener {
		FoodMenuFrame frm;
		CustomFoodCatalogDialog dlg;
		public ToolBarSelectHandler(FoodMenuFrame frm, 
				CustomFoodCatalogDialog dlg) {
			this.frm = frm;
			this.dlg = dlg;
		}		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
//			System.out.println(
//				"���� ���� ������ ����!~ " + btn.getToolTipText());
			// btn.getToolTipText() ������ �̸� <<UQ>>
			int selFdPKId = 0;
			for (Food fd : frm.foodMenuList ) {
				if( fd.getName().equals(btn.getToolTipText()) ) {
					System.out.println(
						"���� ���� ����:" + fd);
					selFdPKId = fd.getId(); // <<PK>>
					dlg.selFood = fd; // ���� ���õ� ����
					break;
				}
			} 
			if( selFdPKId != 0 ) {
				dlg.cdlay.show(
					dlg.pnMenu, "card"+selFdPKId);
				// "card"+����PK�� Ű�� ���� ī���г��� ǥ��
				FoodDBMgr fdMgr = new FoodDBMgr();
				// ���ƿ� ���� ���� ǥ��
				dlg.btnHeart.setText(""+fdMgr
				 .selectLikeCountForFood(selFdPKId));
				// ���ƿ� ������/���� ���� ǥ��
				dlg.changeHeartIcon();
			}
			// ��ȭ���ڿ��� ��Ŀ�� �̵�
			dlg.requestFocus();
		}
		
	}

}
