package ui.calendarMain;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import ui.calendarMain.db.TodoManger;
import ui.calendarMain.db.data.Todo;
import ui.calendarMain.dialog.TodoDialog;

public class DayActionHandler implements ActionListener {
	GuiCalendarFrame frm;
	
	public DayActionHandler(GuiCalendarFrame frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton dayBtn = (JButton) e.getSource();
		// �����-����-���� 
//		String strYear = frm.getTxtYear().getText();
		String strYear = frm.getTxtYearText().trim();
		String strMonth = frm.getTxtMonth().getText().trim();		
		String strDay = dayBtn.getText().trim();
		if(strMonth.length() == 1) strMonth = "0" + strMonth;
		if(strDay.length() == 1) strDay = "0" + strDay;
		String strDate = strYear + "-" 
					+ strMonth + "-" + strDay; 
		
		System.out.println("���� ��ư ������! " + strDate );

		
		TodoManger tdMgr = new TodoManger();
		ArrayList<Todo> todos = tdMgr.selectAllTodos(strDate);
			// Ư�� ���� strDate���� �ش�Ǵ� 
//		for (Todo td : todos) {
////		
//			System.out.println(td.toList());
//		}
		String dbResult = "";
		int nTdSize = 0; //todos.size(); // �ش� ������ todo ����
		if(todos != null && todos.size() > 0) { 
			for (Todo td : todos) {
				dbResult += td.toList() + "\n";
			}
			 nTdSize = todos.size();
		} else {
			dbResult = strDate + " ���ڿ��� Todos ���̺� DB ���ڵ尡 ����";
			
		}
		
		// ���� ���� ���� ��ȭ���ڿ� ����
		TodoDialog tdDlg = new TodoDialog(this.frm, dbResult, strDate, nTdSize);
		
		// �̺�Ʈ�� �߻��� ��ư ��ġ
//		Point btnPos = dayBtn.getLocation(); // ������â�� �»�� �������� �ϴ� ��ư�� �»�� ��ġ
		Point btnPos = dayBtn.getLocationOnScreen();
			// ȭ�� screen �»�� �������� �ϴ� ��ġ.. 
		
		tdDlg.setLocation(btnPos.x + (int)(dayBtn.getWidth()*0.7), btnPos.y + (int)(dayBtn.getHeight()*0.7));
		
		tdDlg.setVisible(true);
			
//		endConnection();
		tdMgr.endConnection();
	}
	

}
