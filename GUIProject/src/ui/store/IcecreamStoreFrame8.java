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
public class IcecreamStoreFrame8 extends JFrame
	implements ActionListener, ItemListener {// 인터페이스 다중 구현이 가능함.	
			//implements ActionListener {

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
		"싱글콘","더블콘",  // con
		"트리플컵","쿼터컵","패미리컵","해프갤론컵" // cup		
	};
	public static final int[] ICE_BUNDLE_LIMITS = {
		1, 2, 3, 4, 6, 8	
	};
	public static final int DEF_BUNDLE = 1; // double cone
	
	
	// 필드
	JLabel lbTitle; 
	public JLabel lbStatus; 
	
	JButton btnCheckOut; // 주문하기/결제 버튼
	
	// 아이스크림 11개 체크박스 묶는 배열
	//JCheckBox[] cbIceFlavors; // 아이스크림 맛 체크박스 배열
	public JCheckBox[] cbIceFlavors; // 아이스크림 맛 체크박스 배열
	// 번들 6종 라디오버튼 묶는 배열 
	JRadioButton[] rdBundles;
	// 기본 선택된 번들의 순서번호 
	int nBundle; 
	public ArrayList<Integer> selIcecreamList; 
		// 선택된 아이스크림맛의 순서번호들을 기억하는 장바구니(리스트) 
	
	public IcecreamStoreFrame8() {
		super("마이 아이스크림 스토어");
		//setBounds(100, 100, 1200, 900); // 안전한...
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
		pnBundles.setBorder(new LineBorder(
				Color.orange, 3, true));
		rdBundles = new JRadioButton[ICE_BUNDLE_NAMES.length];
//		JPanel pnLeft = new JPanel(); // flowlayout
//		JPanel pnRight = new JPanel();
		JPanel pnLeft = new JPanel(new BorderLayout()); 
		JPanel pnRight = new JPanel(new BorderLayout());
//		JPanel pnIces = new JPanel(); // flowlayout
		JPanel pnIces = new JPanel(new GridLayout(2, 3)); // 6개 
		ButtonGroup rdGrp = new ButtonGroup();		
		for (int i = 0; i < ICE_BUNDLE_NAMES.length; i++) {
			JRadioButton bundle = 
					new JRadioButton(ICE_BUNDLE_NAMES[i]);
			bundle.setFont(ftSmall);
			bundle.setToolTipText(
					ICE_BUNDLE_LIMITS[i] +"가지의 맛!");
//			pnBundles.add(bundle); // 패널 표시용 등록
//			pnLeft.add(bundle); // 왼쪽 작은 패널에 등록
			pnIces.add(bundle);
			rdBundles[i] = bundle; // 관리용 배열/리스트 등록
			rdGrp.add(bundle); // 배타성 그룹에 등록
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
		rdBundles[nBundle].setSelected(true);
		// 오른쪽 패널에 번들의 이미지 표시
		JLabel lbSubBundle = new JLabel(":: 번들 종류(맛의 수) ::");
		lbSubBundle.setHorizontalAlignment(JLabel.CENTER);
		lbSubBundle.setFont(ftIce);
		ImageIcon icDouble = 
			new ImageIcon("./store/bundle/double.PNG");
			//new ImageIcon("store\\bundle\\double.PNG");
		JLabel lbIceBundle = new JLabel(
				"double 2가지맛", icDouble, 
				JLabel.CENTER);
//		pnRight.add(lbIceBundle);
		pnRight.add(lbSubBundle, BorderLayout.NORTH);
		pnRight.add(lbIceBundle, BorderLayout.CENTER);
				
		pnBundles.add(pnLeft);
		pnBundles.add(pnRight);
		
		// 아이스크림 체크박스 패널 준비
		JPanel pnIcecreams = new JPanel(
				new GridLayout(4,3, 6,6)); // 4행 3열
		pnIcecreams.setBackground(Color.CYAN);
		pnIcecreams.setBorder(new EtchedBorder());
		cbIceFlavors = new JCheckBox[ICE_NAMES.length];  //[11];
		// 아이스크림 개별 하나마다 JCheckBox로 생성
		for (int i = 0; i < ICE_NAMES.length; i++) {
			JCheckBox iceChk = new JCheckBox(ICE_NAMES[i]);
			iceChk.setFont(ftIce);
			iceChk.setIcon(new ImageIcon(
				"./store/icecreams_sized/"+ICE_NAMES[i]+".png"));
			iceChk.setSelectedIcon(new ImageIcon(
				"./store/icecreams_seljh/"+ICE_NAMES[i]+".png"));
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
		//add(pnIcecreams, BorderLayout.CENTER);
//		add(btnCheckOut, BorderLayout.SOUTH);
		add(lbStatus, BorderLayout.SOUTH); // 상태바 추가
		
		// 장바구니 초기화
		this.selIcecreamList = new ArrayList<>(); // size 0
		lbStatus.setText(">> 선택된 아이스크림 개수: 0개");
		
		// 이벤트 처리 (리스너 등록)
//		IceFlavorHandler ifh = new IceFlavorHandler(this);
//		
		btnCheckOut.addActionListener(this);
		for (int i = 0; i < cbIceFlavors.length; i++) {
			JCheckBox cbIceF = cbIceFlavors[i];
//			cbIceF.addItemListener(this); 기존 프레임 객체
//			cbIceF.addItemListener(ifh); // 새로운 별도 이벤트전용 객체
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		IcecreamStoreFrame8 store = new IcecreamStoreFrame8();
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
		
		// 장바구니 출력 확인
		System.out.println(">> 장바구니 크기: " 
						+ selIcecreamList.size());
		lbStatus.setText(">> 선택된 아이스크림 개수: "
						+selIcecreamList.size()+"개");
		for (int selIceOrder : selIcecreamList) {
			System.out.println(selIceOrder + " : " + 
						ICE_NAMES[selIceOrder]);
		}
	}

	// 아이템의 상태가 변경될 때마다 즉시 실행되는 이벤트 핸들러.
	// 11개의 아이스크림 체크박스가 이 함수 공유
	// 선택된 상태 이벤트라면.. 장바구니 add(),
	// 선택취소하는 상태 이벤트라면.. 장바구니 remove()..
	@Override
	public void itemStateChanged(ItemEvent ie) {
		System.out.println("아이템 상태가 바뀌었습니다! " 
				+ new Date());
		JCheckBox cb = (JCheckBox)ie.getItemSelectable();
//		System.out.println(cb.getText());
		for (int i = 0; i < cbIceFlavors.length; i++) {
			if( cb == cbIceFlavors[i] ) { // 동일성 비교
				System.out.print(i + "번째 아이스크림 체크박스 ");
//				System.out.println(ICE_NAMES[i]);
				if( ie.getStateChange() == ItemEvent.SELECTED ) {
					System.out.println(ICE_NAMES[i] + " 장바구니에 추가됨.");
					selIcecreamList.add(i);
				} else if( ie.getStateChange() == ItemEvent.DESELECTED ) {
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
				lbStatus.setText(">> 선택된 아이스크림 개수: "
						+selIcecreamList.size()+"개");
			}
		}
	}

}

/*
아이템 상태가 바뀌었습니다! Fri May 07 13:14:39 KST 2021
0번째 아이스크림 체크박스 러브미 장바구니에 추가됨.
아이템 상태가 바뀌었습니다! Fri May 07 13:14:40 KST 2021
4번째 아이스크림 체크박스 아빠는딸바봉 장바구니에 추가됨.
아이템 상태가 바뀌었습니다! Fri May 07 13:14:41 KST 2021
8번째 아이스크림 체크박스 치즈러브 장바구니에 추가됨.
아이템 상태가 바뀌었습니다! Fri May 07 13:14:45 KST 2021
10번째 아이스크림 체크박스 해피버스데이 장바구니에 추가됨.
아이템 상태가 바뀌었습니다! Fri May 07 13:14:49 KST 2021
4번째 아이스크림 체크박스 아빠는딸바봉 장바구니에 삭제됨.
>> 장바구니 크기: 3
0 : 러브미
8 : 치즈러브
10 : 해피버스데이
아이템 상태가 바뀌었습니다! Fri May 07 13:15:12 KST 2021
1번째 아이스크림 체크박스 메이플 장바구니에 추가됨.
>> 장바구니 크기: 4
0 : 러브미
8 : 치즈러브
10 : 해피버스데이
1 : 메이플
아이템 상태가 바뀌었습니다! Fri May 07 13:15:55 KST 2021
8번째 아이스크림 체크박스 치즈러브 장바구니에 삭제됨.
>> 장바구니 크기: 3
0 : 러브미
10 : 해피버스데이
1 : 메이플
*/