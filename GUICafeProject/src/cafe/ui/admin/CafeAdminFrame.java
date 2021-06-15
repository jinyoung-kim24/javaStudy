package cafe.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import cafe.ui.components.FoodCardPanel;
import db.data.Food;
import db.data.Order;
import db.data.stat.FoodStatDBMgr;
import db.mgr.FoodDBMgr;
import db.mgr.OrderDBMgr;
import db.mgr.stat.FoodCategoryStat;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;

public class CafeAdminFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableFoods;
	CafeAdminFrame frm;
	ArrayList<Food> fdList; // 필드화해서 기억해 두자.
	
	CardLayout clyRight;
	// 카드들을 기억하는 해시맵을...
	HashMap<String, JPanel> cards;
	private JTable tableMembers;
	private JTable tableOrders;
	
	// 통계탭
	ChartPanel pnChart1;
	JFreeChart chart1;
	ChartPanel pnChart2;
	JFreeChart chart2;
	JPanel pnStats;
	JLabel lbStatInfo1;
	JPanel pnStatCenter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeAdminFrame frame = new CafeAdminFrame();
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
	public CafeAdminFrame() {
		this.frm = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\cup_error.png"));
		setTitle("MyCafe :: \uAD00\uB9AC\uC790 \uBAA8\uB4DC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = 
				new JTabbedPane(JTabbedPane.BOTTOM);
		splitPane.setLeftComponent(tabbedPane);
		
		JPanel pnLeft = new JPanel(); // pnLeft는 음식메뉴관리탭?
//		splitPane.setLeftComponent(pnLeft);
		tabbedPane.addTab("음식메뉴관리", pnLeft);		
		tabbedPane.setBackgroundAt(0, Color.ORANGE);
		tabbedPane.setIconAt(0, new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\sport_football.png"));
		pnLeft.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		pnLeft.add(toolBar, BorderLayout.NORTH);
		
		JButton btnFoodShow = new JButton("\uC74C\uC2DD \uB9AC\uC2A4\uD2B8\uC870\uD68C");
		btnFoodShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB에서 foods 테이블을 다시 select하여
				// ui의 tableFoods에 다시 반영하라.
				frm.showFoodTableUIFromDB();
			}
		});
		btnFoodShow.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUICafeProject\\icons\\add.png"));
		toolBar.add(btnFoodShow);
		
		JLabel lblNewLabel = new JLabel("   ");
		toolBar.add(lblNewLabel);
		
		JButton btnFoodAdd = new JButton("\uC74C\uC2DD \uCD94\uAC00");
		btnFoodAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFoodMenuAddDialog addDlg
					= new AdminFoodMenuAddDialog(frm);
				Point pt = btnFoodAdd.getLocationOnScreen();
				addDlg.setLocation(pt);
				addDlg.setVisible(true);
			}
		});
		btnFoodAdd.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUICafeProject\\icons\\accept.png"));
		toolBar.add(btnFoodAdd);
		
		JButton btnNewButton_2 = new JButton("\uC74C\uC2DD\uC0AD\uC81C");
		btnNewButton_2.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUICafeProject\\icons\\anchor.png"));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uC74C\uC2DD \uAC80\uC0C9");
		btnNewButton_3.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUICafeProject\\icons\\application.png"));
		toolBar.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		pnLeft.add(scrollPane, BorderLayout.CENTER);
		
		JPanel pnRight = new JPanel(); // 이동
		
		tableFoods = new JTable();
		tableFoods.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				// 행 선택(single 선택 모드) 테이블
				int selRow = tableFoods.getSelectedRow();
				// table에서 선택된 행번호(-1은 선택이 없는 상태; 0 ~ row-1)
//				final String columnNames[] = {
//					"번호", "이름", "카테고리", "이미지경로", 
//					"가격 (원)", "Hot/Ice", "등록날자", "설명문"
//				}; // 8	
				int selFdId = (int) tableFoods
						.getValueAt(selRow, 0);
				String selFdName = (String) tableFoods
						.getValueAt(selRow, 1);
//				System.out.println(
//						">> table 선택된 #"+selFdId 
//						+" 음식명: " + selFdName);
				Food selFd = fdList.get(selRow);// 순서변경이 없었다는 전제 하...
				
				System.out.println(
					">> table 선택된 음식 :" + selFd );
				
				clyRight.show(pnRight, "showFood");
//				FoodCardPanel pnSelFdCard
//					= new FoodCardPanel(selFd); 
				// 신규 생성으로 메모리 낭비?
				FoodCardPanel pnSelFdCard
					= (FoodCardPanel) cards.get("showFood");
				// 기존의 맵에 있던 카드패널을 재사용... 
				// 음식데이터 새로운 것을 교체 표시
				pnSelFdCard.showFoodDataToUI(selFd);				
			}
		});
		tableFoods.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFoods.setModel(new DefaultTableModel(
			new Object[][] {
				{"11", "11111", "aaaa", "elsa", "2902-09-22"},
				{"12", "3333", "ddd", "olaf", "2902-09-22"},
				{"13", "33433", "3e3e33", "anna", null},
			},
			new String[] {
				"\uBC88\uD638", "\uAC00\uACA9", "\uC774\uBBF8\uC9C0", "\uC774\uB984", "\uB0A0\uC790"
			}
		));
		scrollPane.setViewportView(tableFoods);
		
		JPanel pnMembers = new JPanel();
		tabbedPane.addTab("\uD68C\uC6D0\uAD00\uB9AC", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\group.png"), pnMembers, null);
		pnMembers.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_1 = new JToolBar();
		pnMembers.add(toolBar_1, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8 \uC870\uD68C");
		toolBar_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uCD94\uAC00");
		toolBar_1.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("\uD68C\uC6D0 \uAC80\uC0C9");
		toolBar_1.add(btnNewButton_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pnMembers.add(scrollPane_1, BorderLayout.CENTER);
		
		tableMembers = new JTable();
		scrollPane_1.setViewportView(tableMembers);
		
		JPanel pnOrders = new JPanel();
		tabbedPane.addTab("\uC8FC\uBB38\uAD00\uB9AC", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\transmit_go.png"), pnOrders, null);
		pnOrders.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_2 = new JToolBar();
		pnOrders.add(toolBar_2, BorderLayout.NORTH);
		
		JButton btnNewButton_5 = new JButton("\uC8FC\uBB38\uB0B4\uC5ED\uC870\uD68C");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDBMgr odMgr = new OrderDBMgr();
				ArrayList<Order> odList = odMgr.selectAllOrder();
				int odCnt = odList.size();
				final String[] odColumnNames = {
						"id", "orderNum", "memberId", 
						"memberLogin", "foodId", "foodName",
						"orderedAt", "unit", "totalPrice"
				};
				
				Object[][] odData = new Object[odCnt][odColumnNames.length];
//				for (int row = 0; row < odData.length; row++) {
				for (int row = 0; row < odCnt; row++) {
						Order od = odList.get(row);
						odData[row][0] = od.getId();
						odData[row][1] = od.getOrderNum();
						odData[row][2] = od.getMemberId();
						odData[row][3] = od.getMemberLogin();
						odData[row][4] = od.getFoodId();
						odData[row][5] = od.getFoodName();
						odData[row][6] = od.getOrderAt();
						odData[row][7] = od.getUnit() + "개";
						odData[row][8] = od.getTotalPrice() + "원";
						
				}
				
				
				// 주문 내열 조회
				DefaultTableModel dtm = new DefaultTableModel(
												odData, odColumnNames);
				
							
				tableOrders.setModel(dtm);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUICafeProject\\icons\\arrow_in.png"));
		toolBar_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\uC8FC\uBB38 \uAC80\uC0C9");
		toolBar_2.add(btnNewButton_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		pnOrders.add(scrollPane_2, BorderLayout.CENTER);
		
		tableOrders = new JTable();
		scrollPane_2.setViewportView(tableOrders);
		
//		JPanel pnStats = new JPanel();
		pnStats = new JPanel();
		tabbedPane.addTab("\uD1B5\uACC4\uB9AC\uD3EC\uD2B8", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\contrast.png"), pnStats, null);
		pnStats.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_3 = new JToolBar();
		pnStats.add(toolBar_3, BorderLayout.NORTH);
		
		JButton btnNewButton_7 = new JButton("\uC8FC\uBB38\uD1B5\uACC4");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				showDummyChart();
			}
		});
		toolBar_3.add(btnNewButton_7);
		
		JButton btnShowStat = new JButton("\uC88B\uC544\uC694 \uD1B5\uACC4");
		btnShowStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFoodStatChart();
				
			}
		});
		btnShowStat.setIcon(new ImageIcon("C:\\dev2021\\JAVA-WS\\GUICafeProject\\icons\\chart_bar.png"));
		toolBar_3.add(btnShowStat);
		
//		JPanel pnStatCenter = new JPanel();
		pnStatCenter = new JPanel();
		pnStatCenter.setBackground(Color.YELLOW);
		pnStats.add(pnStatCenter, BorderLayout.CENTER);
		pnStatCenter.setLayout(null);
		
//		JLabel lbStatInfo1 = new JLabel("\uC74C\uC2DD \uCE74\uD14C\uACE0\uB9AC \uBCC4 \uC88B\uC544\uC694 \uD1B5\uACC4");
		lbStatInfo1 = new JLabel("\uC74C\uC2DD \uCE74\uD14C\uACE0\uB9AC \uBCC4 \uC88B\uC544\uC694 \uD1B5\uACC4");
		lbStatInfo1.setBounds(25, 10, 479, 15);
		pnStatCenter.add(lbStatInfo1);
		
//		JPanel pnChart1 = new JPanel();
//		pnChart1.setBounds(45, 83, 402, 264);
//		panel.add(pnChart1);
		
		this.cards = new HashMap<>();
		
		//JPanel pnRight = new JPanel();
		pnRight.setBackground(Color.GREEN);
		splitPane.setRightComponent(pnRight);
		this.clyRight = new CardLayout(0, 0);
		pnRight.setLayout(clyRight);
		//pnRight.setLayout(new CardLayout(0, 0));
		//pnRight.getLayout()
		// 더미 패널카드 한장 만들어서 일단 표시
		JPanel dummy = new JPanel();
		dummy.add(new Label("안녕하세요! ^^"));
		pnRight.add(dummy, "start");
		cards.put("start", dummy);
		//
		FoodCardPanel dummyFdCard
			= new FoodCardPanel(
				new Food("더미커피", "커피", 
			"./images/menu_thumb/아메리카노.PNG", 500, 1));
		pnRight.add(dummyFdCard, "showFood");
		cards.put("showFood", dummyFdCard);
		//
//		clyRight.show(pnRight, "start");
		clyRight.first(pnRight);

//		clyRight.show(pnRight, "showFood");
	}

	// DB에서 foods 테이블을 다시 select하여
	// ui의 tableFoods에 다시 반영하라.	
	public void showFoodTableUIFromDB() {
		final String columnNames[] = {
			"번호", "이름", "카테고리", "이미지경로", 
			"가격 (원)", "Hot/Ice", "등록날자", "설명문"
		}; // 8		
		
		//String data[][]= {{}}; // 문자열만되는 2차원 배열 
//		Object data[][]= {{}}; // 모든 받는 2차원 배열
//		Object data[][]= {
//				{1, "핫도그", "음식", "./images/hotdog.png", 
//				 1500, 1, "2020-12-10", "옛날 핫도그"	}
//		}; // 1행 8열의 더미 2차원 데이터 배열
		
		// 실제 DB에서 조회...
		// foods 테이블의 실제 레코드 개수
		FoodDBMgr mgr = new FoodDBMgr();
		//ArrayList<Food> fdList = mgr.selectAllFoods();
		fdList = mgr.selectAllFoods();
		if( fdList == null || fdList.isEmpty() ) return;
		final int nDBSize = fdList.size(); // 레코드 개수 ==> 테이블의 행수
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			Food fd = fdList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][0] = fd.getId();  
			data[i][1] = fd.getName();
			data[i][2] = fd.getCategory();
			data[i][3] = fd.getImagePath();
			data[i][4] = fd.getPrice() + "원";
			data[i][5] = fd.getHotIce()
					== Food.TEMP_HOT ? "hot": "ice";
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyy년 MM월 dd일");
			data[i][6] = sdf.format(fd.getRegDate());
			data[i][7] = fd.getDescription();
		}
		
		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		// 기본테이블 모델 = 데이터(행/열) 2차원배열, 열이름헤더 1차원배열
		this.tableFoods.setModel(dtm);		
	}
	
	// DB 차트 표시
		public void showFoodStatChart() {
			FoodStatDBMgr stMgr = new FoodStatDBMgr();
			
			ArrayList<FoodCategoryStat> stList = stMgr.selectFoodCategoryStat();
			
			// 기준 카테고리 세트 준비
			String categories[] = new String[stList.size()];
			for (int i = 0; i < categories.length; i++) {
				FoodCategoryStat st = stList.get(i);
				categories[i] = st.getCategory();
			}
			
			// 데이터 준비
			int[] data = new int[categories.length];
			for (int i = 0; i < data.length; i++) {
//				data[i] = (int)(Math.random() * 100) + 1;
				FoodCategoryStat st = stList.get(i);
				data[i] = st.getLikeCountSum();
			}
			// 데이터 세트를 준비
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < categories.length; i++) {
				dataset.addValue(data[i], "# of likes", categories[i]);	
			}
			
			// 차트 생성
			String title = "Like Counts per Food(음식별 좋아요 수)";
			
			this.chart2 = ChartFactory.createAreaChart(title, "food 음식", "좋아요 수",// 제목, x축, y축이름
					dataset, PlotOrientation.HORIZONTAL, // 데이터셋, 방향
					true, true, true); // 용례, 툴팁, URL
			// 차트 패널에 붙여서 탭에 또 붙여서 표시
			pnChart2 = new ChartPanel(chart2);
			pnChart2.setBounds(81, 282, 240, 200); // 절대 레이아웃
//			panel.add(pnChart1);
			pnStatCenter.add(pnChart2);
			
			// 한글 적용
			chart2.getTitle().setFont(new Font("굴림", Font.BOLD, 16));
			
			CategoryPlot plot = chart2.getCategoryPlot();
			CategoryAxis xaxis = plot.getDomainAxis(); // x
			xaxis.setLabelFont(new Font("굴림", Font.BOLD, 14));
			xaxis.setTickLabelFont(new Font("굴림", Font.PLAIN, 12));
			plot.getRangeAxis().setLabelFont(new Font("굴림", Font.BOLD, 14));; // y
			plot.getRangeAxis().setTickLabelFont(new Font("굴림", Font.PLAIN, 12));
			
			
			pnStatCenter.updateUI();
			pnStatCenter.repaint();
			int totalLikes = 0;
			for (int i : data) {
				totalLikes += i;
			}
			lbStatInfo1.setText("\uC74C\uC2DD"
					+ " \uCE74\uD14C\uACE0\uB9AC"
					+ " \uBCC4 \uC88B\uC544\uC694"
					+ " \uD1B5\uACC4" + "메뉴수: " +
					categories.length + ", 총 좋아요수: "
					+ totalLikes + "개");
			
		}
	
	// 더미 차트 표시
	public void showDummyChart() {
		// 기준 카테고리 세트 준비
		String categories[] = {
			"apple", "banan", "cherry",
			"grapefruit", "watermelon"
		};
		// 데이터 준비
		int[] data = new int[categories.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int)(Math.random() * 100) + 1;
		}
		// 데이터 세트를 준비
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < categories.length; i++) {
			dataset.addValue(data[i], "# of likes", categories[i]);	
		}
		
		// 차트 생성
		String title = "Like Counts per Food";
		
		this.chart1 = ChartFactory.createAreaChart(title, "food", "# of likes",// 제목, x축, y축이름
				dataset, PlotOrientation.HORIZONTAL, // 데이터셋, 방향
				true, true, true); // 용례, 툴팁, URL
		// 차트 패널에 붙여서 탭에 또 붙여서 표시
		pnChart1 = new ChartPanel(chart1);
		pnChart1.setBounds(81, 282, 240, 200); // 절대 레이아웃
//		panel.add(pnChart1);
		pnStatCenter.add(pnChart1);
		pnStatCenter.updateUI();
		pnStatCenter.repaint();
		int totalLikes = 0;
		for (int i : data) {
			totalLikes += i;
		}
		lbStatInfo1.setText("\uC74C\uC2DD"
				+ " \uCE74\uD14C\uACE0\uB9AC"
				+ " \uBCC4 \uC88B\uC544\uC694"
				+ " \uD1B5\uACC4" + "메뉴수: " +
				categories.length + ", 총 좋아요수: "
				+ totalLikes + "개");
		
	}
}
