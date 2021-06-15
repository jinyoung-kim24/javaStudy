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
		// 년년년년-월월-일일 
//		String strYear = frm.getTxtYear().getText();
		String strYear = frm.getTxtYearText().trim();
		String strMonth = frm.getTxtMonth().getText().trim();		
		String strDay = dayBtn.getText().trim();
		if(strMonth.length() == 1) strMonth = "0" + strMonth;
		if(strDay.length() == 1) strDay = "0" + strDay;
		String strDate = strYear + "-" 
					+ strMonth + "-" + strDay; 
		
		System.out.println("날자 버튼 눌렀음! " + strDate );

		
		TodoManger tdMgr = new TodoManger();
		ArrayList<Todo> todos = tdMgr.selectAllTodos(strDate);
			// 특정 날자 strDate에만 해당되는 
//		for (Todo td : todos) {
////		
//			System.out.println(td.toList());
//		}
		String dbResult = "";
		int nTdSize = 0; //todos.size(); // 해당 날자의 todo 개수
		if(todos != null && todos.size() > 0) { 
			for (Todo td : todos) {
				dbResult += td.toList() + "\n";
			}
			 nTdSize = todos.size();
		} else {
			dbResult = strDate + " 날자에는 Todos 테이블 DB 레코드가 없음";
			
		}
		
		// 별도 날자 전용 대화상자에 띄우기
		TodoDialog tdDlg = new TodoDialog(this.frm, dbResult, strDate, nTdSize);
		
		// 이벤트가 발생한 버튼 위치
//		Point btnPos = dayBtn.getLocation(); // 프레임창의 좌상단 기준으로 하는 버튼의 좌상단 위치
		Point btnPos = dayBtn.getLocationOnScreen();
			// 화면 screen 좌상단 기준으로 하는 위치.. 
		
		tdDlg.setLocation(btnPos.x + (int)(dayBtn.getWidth()*0.7), btnPos.y + (int)(dayBtn.getHeight()*0.7));
		
		tdDlg.setVisible(true);
			
//		endConnection();
		tdMgr.endConnection();
	}
	

}
