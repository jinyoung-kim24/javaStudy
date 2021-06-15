package ui.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AwtGuiMain2 extends Frame implements ActionListener {
	
	// 버튼 클릭 이벤트 처리 함수 (이벤트는 거의 대부분 인터페이스를 구현해야 함.)
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Greet 버튼을 누루셨음!!" + new Date());
			// 버튼클릭.
		
	}

	public static void main(String[] args) {
//		Frame frm1 = new Frame("Java 샘플 GUI창");
		AwtGuiMain2 frm1 = new AwtGuiMain2();
		frm1.setTitle("JAVA 샘플 GUI창 II");
		frm1.setLocation(100, 100);
		frm1.setSize(640, 480);
		frm1.setLayout(new FlowLayout());
		
		final Color crPink = Color.PINK;
		final Color crBlue = Color.BLUE;
		final Color crGreen = Color.GREEN;
		final Color crOrange = Color.ORANGE;
		final Color crRed = new Color(255, 0, 0);
		//
		Font ftNormal = new Font("굴림", Font.ITALIC, 30);
		Font ftBig = new Font("궁서체", Font.BOLD, 60);
		
		Label lbTitle = new Label("*** 인사 하기 ***");
		lbTitle.setFont(ftBig);
		lbTitle.setBackground(crBlue);
		Label lbHello = new Label("Hello GUI!!");
		lbHello.setFont(ftNormal);
		Label lbHello2 = new Label("안녕하세요?");
		lbHello2.setFont(ftNormal);
		
		TextField txtHello = new TextField(20);
		txtHello.setFont(ftNormal);
		TextField txtHuman = new TextField("Mr. Park", 14);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(Color.cyan);
		txtHuman.setBackground(Color.DARK_GRAY);
		
		// button 컴포넌트
		Button btnGreet = new Button("GREET!");
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif", Font.PLAIN, 22));
		
		// 이 버튼에 이벤트핸들러와 이벤트을 연동
		btnGreet.addActionListener(frm1);
		// ActionListener 이벤트 핸들러 함수
		// actionPerformed ()를 구현한 객체를 인자로
		
		frm1.add(lbTitle); // 제목 레이블 객체를 가장 먼저 표시
		frm1.add(lbHello); // flowlayout에서는 add 순서가 중요.
		frm1.add(lbHello2);
		frm1.add(txtHello);
		frm1.add(txtHuman);
		frm1.add(btnGreet);
		frm1.setBackground(crOrange);
		frm1.setVisible(true); // AWT창의 close x버튼 동작 안됨.
		
		
		
	}

	

}
