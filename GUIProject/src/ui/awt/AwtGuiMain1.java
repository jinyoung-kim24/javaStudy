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
		Frame frm1 = new Frame("Java ���� GUIâ");
		frm1.setLocation(100, 100);
		frm1.setSize(640, 480);
		frm1.setLayout(new FlowLayout());
		
		final Color crPink = Color.PINK;
		final Color crBlue = Color.BLUE;
		final Color crGreen = Color.GREEN;
		final Color crOrange = Color.ORANGE;
		final Color crRed = new Color(255, 0, 0);
		//
		Font ftNormal = new Font("����", Font.ITALIC, 30);
		Font ftBig = new Font("�ü�ü", Font.BOLD, 80);
		
		Label lbTitle = new Label("*** �λ� �ϱ� ***");
		lbTitle.setFont(ftBig);
		lbTitle.setBackground(crBlue);
		Label lbHello = new Label("Hello GUI!!");
		lbHello.setFont(ftNormal);
		Label lbHello2 = new Label("�ȳ��ϼ���?");
		lbHello2.setFont(ftNormal);
		
		TextField txtHello = new TextField(20);
		txtHello.setFont(ftNormal);
		TextField txtHuman = new TextField("Mr. Park", 14);
		txtHuman.setFont(ftNormal);
		txtHuman.setForeground(Color.cyan);
		txtHuman.setBackground(Color.DARK_GRAY);
		
		// button ������Ʈ
		Button btnGreet = new Button("GREET!");
		btnGreet.setForeground(crPink);
		btnGreet.setFont(new Font("Serif", Font.PLAIN, 22));
		
		
		frm1.add(lbTitle); // ���� ���̺� ��ü�� ���� ���� ǥ��
		frm1.add(lbHello); // flowlayout������ add ������ �߿�.
		frm1.add(lbHello2);
		
		frm1.add(txtHello);
		frm1.add(txtHuman);
		frm1.add(btnGreet);
		frm1.setBackground(crOrange);
		frm1.setVisible(true); // AWTâ�� close x��ư ���� �ȵ�.
		
		
		
	}

}
