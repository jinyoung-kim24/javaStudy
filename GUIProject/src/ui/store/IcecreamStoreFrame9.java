package ui.store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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

import ui.store.event.IceFlavorHandler;

// 	http://www.baskinrobbins.co.kr/menu/list.php?top=A
/*
 		** 아이스크림 스토어 - 11개
 		* 아이스크림 종류는 각각 독립적인 선택이 가능 checkbox
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
 		
 		* 아이스크림들을 담는 그릇(용기) 번들: 
 		* 			오직 한 종류의 것만 선택(배타성) radiobutton 
 		(크기/사이즈)   (맛의 개수)    (가격)   
 		싱글콘		1가지..		3000
 		더블콘		2			4500
 		트리플컵		3			6000
 		쿼터컵		4			10000
 		패미리컵		6			15000
 		해프갤론컵		8			23000
 */

//class BundleSizeHanlder

public class IcecreamStoreFrame9 extends JFrame implements ActionListener, ItemListener {// 인터페이스 다중 구현이 가능함.
	// implements ActionListener {

	public static final Font ftBig = new Font("바탕", Font.BOLD, 48);
	public static final Font ftSmall = new Font("바탕", Font.BOLD, 22);
	public static final Font ftIce = new Font("궁서", Font.BOLD, 24);

	public static final String[] ICE_NAMES = { "러브미", // 0
			"메이플", "블랙소르배", "슈팅스타", "아빠는딸바봉", "아이스홈런볼", "엄마는외계인", "오레오쿠키", "치즈러브", "트리플민초", "해피버스데이" // 10
	};

	public static final String[] ICE_BUNDLE_NAMES = { "싱글콘", "더블콘", // con
			"트리플컵", "쿼터컵", "패미리컵", "해프갤론컵" // cup
	};
	public static final int[] ICE_BUNDLE_LIMITS = { 1, 2, 3, 4, 6, 8 };
	public static final int DEF_BUNDLE = 1; // double cone

	// 필드
	JLabel lbTitle;
	public JLabel lbStatus;

	JButton btnCheckOut; // 주문하기/결제 버튼

	// 아이스크림 11개 체크박스 묶는 배열
	// JCheckBox[] cbIceFlavors; // 아이스크림 맛 체크박스 배열
	public JCheckBox[] cbIceFlavors; // 아이스크림 맛 체크박스 배열
	// 번들 6종 라디오버튼 묶는 배열
	JRadioButton[] rdBundles;
	// 기본 선택된 번들의 순서번호
	int nBundle;
	public ArrayList<Integer> selIcecreamList;
	// 선택된 아이스크림맛의 순서번호들을 기억하는 장바구니(리스트)
	JLabel lbIceBundle; // 필드화....

	// 내부/내장 클래스 정의 (inner class/ nested class)
	// 내부클래스는 외부클래스의 보호?를 받으며,
	// 자신을 감싼 외부 클래스의 자원들을 제약없이 마음껏 사용이 가능..
//	private class BundleSizeHanlder implements ItemListener {
//	public class BundleSizeHanlder implements ItemListener {
	class BundleSizeHanlder implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
//			selIcecreamList.add(1); // 외부클래스 객체 자원 내꺼..?
//			this. ??
			JRadioButton rd = (JRadioButton) e.getItemSelectable();
//			System.out.println(rd.getText());
//			// 배타성 때문에 2번 이벤트 발생
//			// DESELECT 다음에 연이어 SELECT가 발생됨..
//			if( e.getStateChange() == ItemEvent.SELECTED ) {
//				System.out.println(rd.getText() + " 선택됨!");
//			}
			if (rd.isSelected()) {
				System.out.println(rd.getText() + " 선택됨!!");

				// 번들 아이콘 이미지 교체 표시
				// 번들의 아이스크림 개수 레이블 갱신
				// nBundle 선택번호를 갱신
				changeBundleSize(rd.getText());
			}
		}

	}

	public void changeBundleSize(String bundleName) {
		System.out.println(bundleName);

		// "한글" 키 => "영어" 밸류
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("싱글콘", "single");
		map.put("더블콘", "double");
		map.put("트리플컵", "triple");
		map.put("쿼터컵", "quarter");
		map.put("패미리컵", "family");
		map.put("해프갤론컵", "half-galon");

		String changedBundleName;
		String cntBunlde = "";
		if (map.containsKey(bundleName)) {
			changedBundleName = map.get(bundleName); // 번들 영문이름
			int limit = 0;
			for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
				String name = ICE_BUNDLE_NAMES[i];
				if (name.equals(bundleName)) { // 동등성 내용비교
					this.nBundle = i; // 선택된 번들의 순서번호.
					limit = ICE_BUNDLE_LIMITS[i]; // 아이스크림 개수
					break;
				}
			}
			cntBunlde = " " + limit + "가지 맛!";
		} else {
			System.out.println(">> 없는 번들키: " + bundleName);
			changedBundleName = "double";
			cntBunlde = " 2가지 맛!";
			this.nBundle = DEF_BUNDLE; // 1
		}

		// 번들 아이콘 이미지 교체 표시
		String filename = "./store/bundle/" + changedBundleName + ".PNG";
		ImageIcon icBundle = new ImageIcon(filename);
		lbIceBundle.setIcon(icBundle);
		// 번들의 아이스크림 개수 레이블 갱신
		lbIceBundle.setText(changedBundleName + cntBunlde);
		// nBundle 선택번호를 갱신
	}

	public IcecreamStoreFrame9() {
		super("마이 아이스크림 스토어");
		// setBounds(100, 100, 1200, 900); // 안전한...
		setBounds(100, 100, 1200, 780); // 안전한...
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		this.setLayout(new BorderLayout());

		// 상단 로고 타이블 레이블 준비
		ImageIcon icLogo = new ImageIcon("./store/logo2.PNG");
		this.lbTitle = new JLabel("마이아이스 MyIce");
		lbTitle.setFont(ftBig);
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		lbTitle.setIcon(icLogo);

		// 아이스크림 번들 라디오버튼 패널 준비
//		JPanel pnBundles = new JPanel(new GridLayout(1, 6));
		JPanel pnBundles = new JPanel(new GridLayout(1, 2)); // 2등분
		pnBundles.setBackground(Color.pink);
		pnBundles.setBorder(new LineBorder(Color.orange, 3, true));
		rdBundles = new JRadioButton[ICE_BUNDLE_NAMES.length];
//		JPanel pnLeft = new JPanel(); // flowlayout
//		JPanel pnRight = new JPanel();
		JPanel pnLeft = new JPanel(new BorderLayout());
		JPanel pnRight = new JPanel(new BorderLayout());
//		JPanel pnIces = new JPanel(); // flowlayout
		JPanel pnIces = new JPanel(new GridLayout(2, 3)); // 6개
		ButtonGroup rdGrp = new ButtonGroup();
		BundleSizeHanlder bundleSizeHanlder = new BundleSizeHanlder();
		for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
			JRadioButton bundle = new JRadioButton(ICE_BUNDLE_NAMES[i]);
			bundle.setFont(ftSmall);
			bundle.setToolTipText(ICE_BUNDLE_LIMITS[i] + "가지의 맛!");
//			pnBundles.add(bundle); // 패널 표시용 등록
//			pnLeft.add(bundle); // 왼쪽 작은 패널에 등록
			pnIces.add(bundle);
			rdBundles[i] = bundle; // 관리용 배열/리스트 등록
			rdGrp.add(bundle); // 배타성 그룹에 등록

			// bundle.addItemListener(this);
			// bundle.addItemListener(ifh);
			bundle.addItemListener(bundleSizeHanlder);
		}
		JLabel lbSubTitle = new JLabel(":: 번들 종류 ::");
		lbSubTitle.setFont(ftIce);
		lbSubTitle.setHorizontalAlignment(JLabel.CENTER);
		pnLeft.add(lbSubTitle, BorderLayout.NORTH);
		pnLeft.add(pnIces, BorderLayout.CENTER);
		// 기본 번들 설정 double cone
		this.nBundle = DEF_BUNDLE;
//		JRadioButton selBundle = rdBundles[nBundle];
//		selBundle.setSelected(true); // 이 라디오버튼(번들)가 선택됨

		ImageIcon icDouble = new ImageIcon("./store/bundle/double.PNG");
		lbIceBundle = new JLabel( // 필드변수
				"double 2가지맛", icDouble, JLabel.CENTER);

		rdBundles[nBundle].setSelected(true); // NULL 위치!!
		// 오른쪽 패널에 번들의 이미지 표시
		JLabel lbSubBundle = new JLabel(":: 번들 종류(맛의 수) ::");
		lbSubBundle.setHorizontalAlignment(JLabel.CENTER);
		lbSubBundle.setFont(ftIce);
//		ImageIcon icDouble = 
//			new ImageIcon("./store/bundle/double.PNG");
		// new ImageIcon("store\\bundle\\double.PNG");
		// JLabel lbIceBundle = new JLabel( // 지역변수
//		lbIceBundle = new JLabel( // 필드변수 ==> 초기화 위치 이동!!!!
//				"double 2가지맛", icDouble, 
//				JLabel.CENTER);
		lbIceBundle.setFont(ftIce);
//		pnRight.add(lbIceBundle);
		pnRight.add(lbSubBundle, BorderLayout.NORTH);
		pnRight.add(lbIceBundle, BorderLayout.CENTER);

		pnBundles.add(pnLeft);
		pnBundles.add(pnRight);

		// 아이스크림 체크박스 패널 준비
		JPanel pnIcecreams = new JPanel(new GridLayout(4, 3, 6, 6)); // 4행 3열
		pnIcecreams.setBackground(Color.CYAN);
		pnIcecreams.setBorder(new EtchedBorder());
		cbIceFlavors = new JCheckBox[ICE_NAMES.length]; // [11];
		// 아이스크림 개별 하나마다 JCheckBox로 생성
		for (int i = 0; i < ICE_NAMES.length; i++) {
			JCheckBox iceChk = new JCheckBox(ICE_NAMES[i]);
			iceChk.setFont(ftIce);
			iceChk.setIcon(new ImageIcon("./store/icecreams_sized/" + ICE_NAMES[i] + ".png"));
			iceChk.setSelectedIcon(new ImageIcon("./store/icecreams_seljh/" + ICE_NAMES[i] + ".png"));
			pnIcecreams.add(iceChk);
			this.cbIceFlavors[i] = iceChk;
		}

		this.lbStatus = new JLabel("상태바 ::");
		this.setFont(new Font("굴림", Font.PLAIN, 22));
		this.btnCheckOut = new JButton("아이스크림 주문!!");

		JPanel pnCenter = new JPanel(new BorderLayout(5, 5));

		pnCenter.add(pnBundles, BorderLayout.NORTH); // 패널안에 패널
		pnCenter.add(pnIcecreams, BorderLayout.CENTER);
		pnCenter.add(btnCheckOut, BorderLayout.SOUTH);
		add(lbTitle, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		// add(pnIcecreams, BorderLayout.CENTER);
//		add(btnCheckOut, BorderLayout.SOUTH);
		add(lbStatus, BorderLayout.SOUTH); // 상태바 추가

		// 장바구니 초기화
		this.selIcecreamList = new ArrayList<>(); // size 0
		lbStatus.setText(">> 선택된 아이스크림 개수: 0개");

		// 이벤트 처리 (리스너 등록)
		IceFlavorHandler ifh = new IceFlavorHandler(this);

		btnCheckOut.addActionListener(this);
		for (int i = 0; i < cbIceFlavors.length; i++) {
			JCheckBox cbIceF = cbIceFlavors[i];
//			cbIceF.addItemListener(this); // 1. 기존 프레임 객체
			cbIceF.addItemListener(ifh); // 2. 새로운 별도 이벤트전용 객체
		}

		setVisible(true);
	}

	public static void main(String[] args) {
		IcecreamStoreFrame9 store = new IcecreamStoreFrame9();
	}

	public static final int BUNDLE_OVER = 1; // 넘침
	public static final int BUNDLE_MATCH = 2; // 일치
	public static final int BUNDLE_UNDER = 3; // 부족

	public int compareBundleSizeForLimit() {
		int bdSize = this.selIcecreamList.size(); // 장바구니 크기
		int bdList = ICE_BUNDLE_LIMITS[nBundle]; // 현재 번들의 최대 아이스크림 개수
		System.out.println("장바구니 " + bdSize + " vs 리미트" + bdList);
		if (bdSize > bdList) {
			System.out.println("장바구니 넘쳐요!!!!!!!!");
			return BUNDLE_OVER;
		} else if (bdSize < bdList) {
			System.out.println("장바구니 모잘라요!!!!!!");
			return BUNDLE_UNDER;
		} else {

			System.out.println("장바구니와 번들제한크기 일치!! => 주문가능!!");
			return BUNDLE_MATCH;
		}
	}

	// checkout 버튼
	@Override
	public void actionPerformed(ActionEvent e) {
		// 장바구니 리스트 "순차적" 구축
//		for (int i = 0; i < cbIceFlavors.length; i++) {
//			JCheckBox cbIce = cbIceFlavors[i];
//			if( cbIce.isSelected() ) { // 선택된 아이스크림맛인가?
////				System.out.println(
////					i +"번째: " +	cbIce.getText());
//				selIcecreamList.add(i); // 담기 size++
//			}
//		}
		int comp = compareBundleSizeForLimit();
		if (comp == BUNDLE_MATCH) {
			// 주문될 장바구니 출력 확인
			System.out.println("-------------------");
			System.out.println(">> 주문번호: " + (long)(Math.random()* 10000000010000L));
			System.out.println(">> 주문일시: " + new Date());
			System.out.println(">> 주문된 장바구니 리스트: " + selIcecreamList.size());
			lbStatus.setText(">> 선택된 아이스크림 개수: " + selIcecreamList.size() + "개");
			for (int selIceOrder : selIcecreamList) {
				System.out.println(selIceOrder + " : " + ICE_NAMES[selIceOrder]);
			}
		}else {
			System.out.println("빨간불!! 크루 연락!!");
		}
	}

	// 아이템의 상태가 변경될 때마다 즉시 실행되는 이벤트 핸들러.
	// 11개의 아이스크림 체크박스가 이 함수 공유
	// 선택된 상태 이벤트라면.. 장바구니 add(),
	// 선택취소하는 상태 이벤트라면.. 장바구니 remove()..
	@Override
	public void itemStateChanged(ItemEvent ie) {
		System.out.println("아이템 상태가 바뀌었습니다! " + new Date());
		JCheckBox cb = (JCheckBox) ie.getItemSelectable();
//		System.out.println(cb.getText());
		for (int i = 0; i < cbIceFlavors.length; i++) {
			if (cb == cbIceFlavors[i]) { // 동일성 비교
				System.out.print(i + "번째 아이스크림 체크박스 ");
//				System.out.println(ICE_NAMES[i]);
				if (ie.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(ICE_NAMES[i] + " 장바구니에 추가됨.");
					selIcecreamList.add(i);
				} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println(ICE_NAMES[i] + " 장바구니에 삭제됨.");
//					selIcecreamList.remove(i); // x 큰일남!! 에러!!
					// i라는 고유체크박스 순서값의 장바구니리스트상의 순서번호 j를 찾아야함.
					int rmPos = -1;
//					for (int j = 0; j < selIcecreamList.size(); j++) {
//						if( selIcecreamList.get(j) == i ) rmPos = j;
//					}
					rmPos = selIcecreamList.indexOf(i);
					selIcecreamList.remove(rmPos);
				} else {
					System.out.println("????");
				}
				lbStatus.setText(">> 선택된 아이스크림 개수: " + selIcecreamList.size() + "개");
			}
		}
	}

}