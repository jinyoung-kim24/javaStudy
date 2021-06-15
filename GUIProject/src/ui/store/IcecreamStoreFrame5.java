package ui.store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

// 	http://www.baskinrobbins.co.kr/menu/list.php?top=A
/*
 		** 아이스크림 스토어 
 		러브미
 		메이플
 		블랙소르배
 		슈팅스타
 		아빠는딸바봉
 		아이스홈런볼
 		엄마는외계인
 		오레오쿠키
 		치즈러브
 		트리플민초
 		해피버스데이
 		
 		* 아이스크림들을 담는 그릇(용기) 번들: 오직 한종류의 것만 선택(배타성) radiobutton
 		(크기/사이즈)   (맛의 개수)    (가격)   
 		싱글콘		1가지..		3000
 		더블콘		2			4500
 		트리플컵		3			6000
 		쿼터컵		4			10000
 		패미리컵		6			15000
 		해프갤론컵		8			23000
 */
public class IcecreamStoreFrame5 extends JFrame implements ActionListener {

	public static final Font ftBig =
			new Font("바탕", Font.BOLD, 48);
	public static final Font ftSmall =
			new Font("바탕", Font.BOLD, 22);
	public static final Font ftIce =
			new Font("궁서", Font.BOLD, 24);
	
	public static final String[] ICE_NAMES = {
			"러브미", // 0
	 		"메이플",
	 		"블랙소르배",
	 		"슈팅스타",
	 		"아빠는딸바봉",
	 		"아이스홈런볼",
	 		"엄마는외계인",
	 		"오레오쿠키",
	 		"치즈러브",
	 		"트리플민초",
	 		"해피버스데이"	// 10
	};
	
	public static final String[] ICE_BUNDLE_NAMES = {
			"싱글콘", "더블콘", // 콘
			"트리플컵", "쿼터컵", "패미리컵", "해프갤론컵" // 컵
	};
	public static final int[] ICE_BUNDLE_LIMITS = {
		1, 2, 3, 4, 6, 8
	};
	public static final int DEF_BUNDLE = 1; // double cone
	
	JLabel lbTitle; 
	JLabel lbStatus; 
	
	JButton btnCheckOut; // 주문하기/결제 버튼
	
	// 아이스크림 11개 체크박스 묶는 배열
	JCheckBox[] cbIceFlavors; // 아이스크림 맛 체크박스 배열
	// 번들 6종 라디오버튼 묶는 배열
	JRadioButton[] rdBundles;
	// 기본 선택된 번들의 순서번호
	int nBundle;
	ArrayList<Integer> selIcecremList; 
		// 선택된 아이스크림 맛의 순서번호들을 기억하는 장바구니(리스트)
	public IcecreamStoreFrame5() {
		super("마이 아이스크림 스토어");
		setBounds(100, 100, 800, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		this.setLayout(new BorderLayout());
		// 상단로고 타이블 레이블
		ImageIcon icLogo = new ImageIcon("./store/logo2.PNG");
		this.lbTitle = new JLabel("마이아이스 MyIce");
		lbTitle.setFont(ftBig);
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		lbTitle.setIcon(icLogo);
		
		// 아이스크림 번들 라디오버튼 패널 준비
		JPanel pnBundles = new JPanel(new GridLayout(1, 2));
		pnBundles.setBackground(Color.pink);
		pnBundles.setBorder(new LineBorder(Color.orange, 3, true));
		rdBundles = new JRadioButton[ICE_BUNDLE_NAMES.length];
//		JPanel pnLeft = new JPanel();
//		JPanel pnRight = new JPanel();
		JPanel pnLeft = new JPanel(new BorderLayout());
		JPanel pnRight = new JPanel(new BorderLayout());
		JPanel pnIces = new JPanel(new GridLayout(2, 3));
		ButtonGroup rdGrp = new ButtonGroup();
		for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
			JRadioButton bundle = new JRadioButton(ICE_BUNDLE_NAMES[i]);
			bundle.setFont(ftSmall);
			bundle.setToolTipText(ICE_BUNDLE_LIMITS[i] + "가지의 맛!!");
//			pnBundles.add(bundle); // 패널 표시용 등록
//			pnLeft.add(bundle);
			pnIces.add(bundle);
			rdBundles[i] = bundle; // 관리용 배열/리스트 등록
			rdGrp.add(bundle); // 배타성 그룹에 등록
		}
		JLabel lbSubTitle = new JLabel(":: 번들 종류");
		lbSubTitle.setFont(ftIce);
		lbSubTitle.setHorizontalAlignment(JLabel.CENTER);
		pnLeft.add(lbSubTitle, BorderLayout.NORTH);
		pnLeft.add(pnIces, BorderLayout.CENTER);
		// 기본 번들 설정 double cone
		this.nBundle = DEF_BUNDLE;
//		JRadioButton selBundle = rdBundles[nBundle];
//		selBundle.setSelected(true); // 이 라디오버튼(번들)가 선택됨 
		rdBundles[nBundle].setSelected(true);
		// 오른쪽 번들의 이미지 표시
		JLabel lbSubBundle = new JLabel(":: 번들 종류(맛의 수) ::");
		lbSubBundle.setHorizontalAlignment(JLabel.CENTER);
		lbSubBundle.setFont(ftIce);
		ImageIcon icDouble = new ImageIcon("./store/bundle/double.PNG");
		JLabel lbIceBundle = new JLabel("double 2가지맛", icDouble, JLabel.CENTER);
//		pnRight.add(lbIceBundle);
		pnRight.add(lbSubBundle, BorderLayout.NORTH);
		pnRight.add(lbIceBundle, BorderLayout.CENTER);
		pnBundles.add(pnLeft);
		pnBundles.add(pnRight);
		
		// 아이스크림 체크박스 패널준비
		JPanel pnIcecreams = new JPanel(
				new GridLayout(4,3, 6,6)); // 4행 3열
		pnIcecreams.setBackground(Color.CYAN);
		pnIcecreams.setBorder(new EtchedBorder());
		cbIceFlavors = new JCheckBox[ICE_NAMES.length];
		// 아이스크림 개별 하나마다 JCheckBox로 생성
		for (int i = 0; i < ICE_NAMES.length; i++) {
			JCheckBox iceChk = new JCheckBox(ICE_NAMES[i]);
			iceChk.setFont(ftIce);
			iceChk.setIcon(new ImageIcon(
				"./store/icecreams_sized/"+ICE_NAMES[i]+".png"));
			iceChk.setSelectedIcon(new ImageIcon(
					"./store/icecreams_sel_지혜씨 제공/"+ICE_NAMES[i]+".png"));
			pnIcecreams.add(iceChk);
			this.cbIceFlavors[i] = iceChk;
		}
		this.lbStatus = new JLabel("상태바::");
		this.setFont(new Font("굴림", Font.PLAIN, 22));
		this.btnCheckOut = new JButton("아이스크림 주문!!");
		
		JPanel pnCenter = new JPanel(new BorderLayout(5, 5));
		pnCenter.add(pnBundles, BorderLayout.NORTH); // 
		pnCenter.add(pnIcecreams, BorderLayout.CENTER);
		pnCenter.add(btnCheckOut, BorderLayout.SOUTH);
		add(lbTitle, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		// add(pnIcecreams, BorderLayout.CENTER);
//		add(btnCheckOut, BorderLayout.SOUTH);
		
		// 장바구니 초기화
		this.selIcecremList = new ArrayList<>(); // size 0개
		lbStatus.setText(">> 선택된 아이스크림 개수: 0개");
		
		
		// 이벤트 처리(리스너 등록)
		btnCheckOut.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		IcecreamStoreFrame5 store = new IcecreamStoreFrame5();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 장바구니 리스트 구축
		for (int i = 0; i < this.cbIceFlavors.length; i++) {
			JCheckBox cbIce = cbIceFlavors[i];
			if(cbIce.isSelected()) {// 선택된 아이스크림맛인가?
//				System.out.println(i + "번째:" + cbIce.getText());
				selIcecremList.add(i); // 담기
			}
		}
		// 장바구니 출력확인
		System.out.println(">> 장바구니 크기: " + selIcecremList.size());
		lbStatus.setText(">> 선택된 아이스크림 개수: " + selIcecremList.size() + "개");
		for (int selIceOrder : selIcecremList) {
			System.out.println(selIceOrder + " : " + ICE_NAMES[selIceOrder]);
		}
		
		
	}

}

