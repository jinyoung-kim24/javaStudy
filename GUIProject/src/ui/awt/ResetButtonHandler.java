package ui.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonHandler implements ActionListener {
	
	AwtGuiMain7 frm;
	
	public ResetButtonHandler(AwtGuiMain7 frm) {
		this.frm = frm; // ������â�� �ּҸ� �ʵ忡 ����Ŵ..
		
	}
	
	// ��ư ���� ��(�̺�Ʈ) ���� �ڵ����� ȣ��Ǵ� �̺�Ʈ ó���Լ�(�ڵ鷯) 
	@Override
	public void actionPerformed(ActionEvent e) {
		String oldHello = frm.txtHello.getText();
		String oldHuman = frm.txtHuman.getText();
		System.out.println(">> ���� ��ư ������!! ��������: " + oldHello + " " + oldHuman);
		
		// �� ���� �ؽ�Ʈ �ʵ带 ����
		frm.txtHello.setText("");
		frm.txtHuman.setText("");
				
	}

}
