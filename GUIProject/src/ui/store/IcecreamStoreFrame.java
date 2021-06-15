package ui.store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

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
 		
 		(크기/사이즈)   (맛의 개수)    (가격)   
 		싱글콘		1가지..		3000
 		더블콘		2			4500
 		트리플컵		3			6000
 		쿼터컵		4			10000
 		패미리컵		6			15000
 		해프갤론컵		8			23000
 */
public class IcecreamStoreFrame extends JFrame {

	public static final Font ftBig =
			new Font("바탕", Font.BOLD, 48);
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
	
	JLabel lbTitle; 
	JLabel lbStatus; 
	
	JButton btnCheckOut; // 주문하기/결제 버튼
	
	public IcecreamStoreFrame() {
		super("마이 아이스크림 스토어");
		setBounds(100, 100, 800, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		this.setLayout(new BorderLayout());
		
		ImageIcon icLogo = new ImageIcon("./store/logo2.PNG");
		
		this.lbTitle = new JLabel("마이아이스 MyIce");
		lbTitle.setFont(ftBig);
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		lbTitle.setIcon(icLogo);
		
		JPanel pnIcecreams = new JPanel(
				new GridLayout(4,3, 6,6)); // 4행 3열
		pnIcecreams.setBackground(Color.CYAN);
		pnIcecreams.setBorder(new EtchedBorder());
		// 아이스크림 개별 하나마다 JCheckBox로 생성
		for (int i = 0; i < ICE_NAMES.length; i++) {
			JCheckBox iceChk = new JCheckBox(ICE_NAMES[i]);
			iceChk.setFont(ftIce);
			iceChk.setIcon(new ImageIcon(
				"./store/icecreams_sized/"+ICE_NAMES[i]+".png"));
			iceChk.setSelectedIcon(new ImageIcon(
					"./store/icecreams_sel_지혜씨 제공/"+ICE_NAMES[i]+".png"));
			pnIcecreams.add(iceChk);
		}
		
		this.btnCheckOut = new JButton("아이스크림 주문!!");
		
		add(lbTitle, BorderLayout.NORTH);
		add(pnIcecreams, BorderLayout.CENTER);
		add(btnCheckOut, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		IcecreamStoreFrame store = new IcecreamStoreFrame();
	}

}

