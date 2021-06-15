package ui.calendarMain.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.calendarMain.GuiCalendarFrame;
import ui.calendarMain.db.TodoManger;
import ui.calendarMain.db.data.Member;
import ui.calendarMain.db.data.Todo;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TodoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
//	public TodoDialog() {
//		
//	}
	TodoDialog dlg;
	JComboBox comboTodoType;
	JTextArea taNewTodo;
	GuiCalendarFrame frm;
	JTextArea textArea; // read - only
	
	public TodoDialog(GuiCalendarFrame frm, 
			String dbResult, String strDate, int nTdSize) {
		super(frm, true); // modal mode
		this.frm = frm; // ����� ������������ �ּ�
		this.dlg = this; // ��ȭ���� �ڽ�
		setTitle(strDate + " ���θ���Ʈ: " +  
				 nTdSize + "��"	);
		setBounds(100, 100, 519, 239);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				//JTextArea textArea = new JTextArea();
				textArea = new JTextArea();
				textArea.setBackground(new Color(100, 149, 237));
				textArea.setLineWrap(true); // ���ڵ� �ٹٲ�
				textArea.setEditable(false); // 
				scrollPane.setViewportView(textArea);
				textArea.setText(dbResult);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
//				JTextArea taNewTodo = new JTextArea();
				taNewTodo = new JTextArea();
				taNewTodo.setColumns(26);
				taNewTodo.setRows(2);
				buttonPane.add(taNewTodo);
			}
			{
//				JComboBox comboTodoType = new JComboBox();
				comboTodoType = new 
						JComboBox(
					new DefaultComboBoxModel<>(Todo.MTYPES));				
					// 	�迭��� �� �޺� �ʱ�ȭ
				buttonPane.add(comboTodoType);
				comboTodoType.setSelectedIndex(Todo.MT_PURCHASE);//3
			}
			{
				JButton btnTodoAdd = new JButton("\uD22C\uB450 \uB4F1\uB85D");
				btnTodoAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// �ű� ���� ��� ó��
						String memo = dlg.taNewTodo.getText();
						String userName = Member.loggedIn; // dummy elsa 
						int memoType = 
								dlg.comboTodoType
									.getSelectedIndex(); 
//						String strDate;
						
						TodoManger tdMgr = new TodoManger();
						
						boolean b = tdMgr.insertNewTodoOnDay(memo, userName,
									memoType, strDate);
						
						if( b ) { // insert�� �߰��� todo ���ڵ带 �����ؼ� �ٽ� ��ȸ
							System.out.println("todo �߰�!! success");
							ArrayList<Todo> tdList = tdMgr.selectAllTodos(strDate);
							String temp = "";
							if(tdList != null && tdList.size() > 0) {
								for (Todo td : tdList) {
									temp += td.toList() + "\n";
								}
								int nTempTdSize = tdList.size(); // ++
								dlg.textArea.setText(temp);
								dlg.setTitle(strDate + " ���θ���Ʈ: " +  
										 nTdSize + "��"	);
							}else {
								dlg.textArea.setText(strDate + "���ڿ��� Todos ���̺� DB ���ڵ尡 ����");  
							}
						}else {
							System.out.println("todo �߰�!! fail");
						}
						
						tdMgr.endConnection();
					}
				});
				btnTodoAdd.setFont(new Font("�޸տ�����", Font.BOLD, 14));
				btnTodoAdd.setActionCommand("OK");
				buttonPane.add(btnTodoAdd);
				getRootPane().setDefaultButton(btnTodoAdd);
			}
		}
	}

//	public TodoDialog(GuiCalendarFrame6 frm, 
//			String dbResult, int nTdSize) {
//		// TODO Auto-generated constructor stub
//	}

}
