package ui.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

//public class AwGuiMain2 {
//public class AwGuiMain2 extends Frame {
public class AwtGuiMain4 extends Frame 
					implements ActionListener
{
	// ui 컴포넌트 필드 선언
	TextField txtHello; // 필드화 - 기본값 null !!!!
	TextField txtHuman;  
	Label lbResult; // 버튼 이벤트의 결과를 이 레이블에도 표시
	
	// 생성자 (프레임창 초기화)
	public AwtGuiMain4() {
		this.setTitle("Java 샘플 GUI창 III");
		setLocation(100, 100);
		this.setSize(800, 480);
		
		//setLayout(new FlowLayout()); // 플로우레이아웃
		setLayout(new BorderLayout()); // 보더레이아웃(동서남북)
		
		final Color crPink = Color.PINK;
		final Color crBlue = Color.BLUE;
		final Color crGreen = Color.GREEN;
		final Color crOrangle = Color.orange;
//		final Color crRed = new Color(0xFF, 0, 0);
		final Color crRed = new Color(255, 0, 0);
		//
		final Font ftNormal = new Font("굴림", Font.ITALIC, 30);
		Font ftBig = new Font("궁서체", Font.BOLD, 60);
		
		Label lbTitle = new Label("*** 인사 하기 ***");
		lbTitle.setFont(ftBig);
		lbTitle.setForeground(crBlue); // 전경색
		Label lbHello = new Label("Hello GUI!!");
		lbHello.setFont(ftNormal);
		Label lbHello2 = new Label("안녕하세요?");
		lbHello2.setFont(ftNormal);  //ftBig);
		
		this.lbResult = new Label("결과: ", Label.LEFT);
		lbResult.setFont(new Font("바탕", 
				Font.BOLD | Font.ITALIC, 
				38));
		lbResult.setBackground(Color.YELLOW);
		
//		TextField txtHello = new TextField(20);
		this.txtHello = new TextField(20);
		txtHello.setFont(ftNormal);
		txtHuman = new TextField("Mr. Park", 14);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(Color.CYAN);
		txtHuman.setBackground(Color.DARK_GRAY);
		
		//button 컴포넌트
		Button btnGreet = new Button("GREET!");
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif", Font.PLAIN, 22));
		
		// 이 버튼에 이벤트핸들러와 이벤트을 연동 
		btnGreet.addActionListener(this);//프레임 자식창 자기자신객체
		// ActionListener 이벤트 핸들러 함수  
		// actionPerformed()를 구현한 객체를 인자로...
		
//		this.add(lbTitle); // 제목 레이블 객체를 가장 먼저 표시
//		add(lbHello); // flowlayout에서는 add 순서가 중요.
//		this.add(lbHello2);		
//		this.add(txtHello);
//		add(txtHuman);
//		this.add(btnGreet);
//		add(lbResult);
		// this는 프레임 자식창 자기자신객체
		
		Panel pn = new Panel(); // 패널의 기본배치는 flowLayout 
		pn.add(lbHello); // flowlayout에서는 add 순서가 중요.
		pn.add(lbHello2);		
		pn.add(txtHello);
		pn.add(txtHuman);
		
		add(pn, BorderLayout.CENTER); // 패널을 중앙에 배치
		add(lbTitle, BorderLayout.NORTH);
		add(btnGreet, BorderLayout.EAST);
		add(lbResult, BorderLayout.SOUTH);
		
		this.setBackground(crOrangle); // 배경색
//		this.setVisible(true); // AWT창의 close x버튼 동작 안됨.
	}
	
	// 버튼 클릭 이벤트 처리 함수 (이벤트는 거의 대부문 인터페이스를 구현해야 함.)
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Greet! 버튼을 누루셨음!!" + new Date());
			// 버튼 클릭..	
		String strHello = this.txtHello.getText();
		String strHumanName = this.txtHuman.getText();
		System.out.println(">> 인사하기 " +  strHello 
				+ " " + strHumanName + "~!!!"); // 콘솔창 출력
		this.lbResult.setText(">> 인사하기 " +  strHello 
				+ " " + strHumanName + "~!!!");
	}
	
	public static void main(String[] args) {
		AwtGuiMain4 frm1 = new AwtGuiMain4(); 
		frm1.setVisible(true);
	}



}
