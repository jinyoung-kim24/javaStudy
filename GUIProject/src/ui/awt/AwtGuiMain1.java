package ui.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class AwtGuiMain1 {

	public static void main(String[] args) {
		Frame frm1 = new Frame("Java 샘플 GUI창");
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
		Font ftBig = new Font("궁서체", Font.BOLD, 80);
		
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
