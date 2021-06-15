package db.mgr;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formealLogin.formealLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Point;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import db.data.Member;
import formeal.FormealMainFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FormealManagerFrame extends JFrame {

	private JPanel contentPane;
	formealLogin frm; // 로그인창
	FormealManagerFrame fmgr; // 자기 자신
	private JPanel panel;
	private JTable JoinTable;
	ArrayList<Member> joinList;
	public JLabel lbLogin;
	FormealMainFrame fmain; // 메인창
	public CardLayout CardPn; // 메인창 카드 레이아웃
	
	
	private static String loggedIn = null; 
	public static String getLoggedIn() {
		return loggedIn;
	}
	public static boolean isWhoLoggedIn() {
		return loggedIn != null; // true: false;
	}
	
	public void changeLoginState(boolean bState,
					String login) {
		if(bState == true)  {
			loggedIn = login;
		} else {
			loggedIn = null;
		}
	}
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormealManagerFrame frame = new FormealManagerFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FormealManagerFrame(formealLogin Lfrm, FormealMainFrame frm) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 \uD654\uBA74.png"));
		setTitle("ForMeal \uAD00\uB9AC\uC790 \uCC3D");
		this.frm = Lfrm;
		this.fmain = frm;
		this.fmgr = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 828, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setLayout(null);
		
		
		JButton btnMainHome = new JButton("");
		btnMainHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				FormealMainFrame fmain =
//						new FormealMainFrame(fmgr);
				fmain.cl_CardPn.show(fmain.CardPn, "logout");
				fmgr.setVisible(false);
				fmain.setVisible(true);
				
			}
		});
		btnMainHome.setFocusable(false);
		btnMainHome.setBackground(new Color(255, 228, 196));
		btnMainHome.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\pixlr-bg-result.png"));
		btnMainHome.setBounds(32, 10, 60, 59);
		contentPane.add(btnMainHome);
		
		JLabel lbLogout = new JLabel("Log-out");
		lbLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if( loggedIn != null ) {					
					changeLoginState(false, loggedIn);
					fmgr.setVisible(false);					
					frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					fmain.setVisible(true);
					fmgr.dispose();
				} else {
//					FormealManagerFrame loginfrm 
//					= new FormealManagerFrame(frm);
//					changeLoginState(false, loggedIn);
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbLogout.setForeground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbLogout.setForeground(Color.BLACK);
			}
		});
		lbLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogout.setBounds(692, 50, 57, 15);
		contentPane.add(lbLogout);
		
		panel = new JPanel();
		panel.setBounds(64, 161, 698, 255);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JButton btnCheckList = new JButton("\uD68C\uC6D0 \uC870\uD68C");
		btnCheckList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fmgr.showJoinMemberDB();
			}
		});
		panel_1.add(btnCheckList);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JoinTable = new JTable();
		JoinTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\uC544\uC774\uB514", "\uC774\uB984", "\uB098\uC774", "\uC131\uBCC4", "\uD578\uB4DC\uD3F0 \uBC88\uD638", "\uC774\uBA54\uC77C", "\uC8FC\uC18C", "\uAC00\uC785\uB0A0\uC790"
			}
		));
		scrollPane.setViewportView(JoinTable);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 4.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(213, 21, 388, 100);
		contentPane.add(lblNewLabel);
	}
	
	
	public void showJoinMemberDB() {
		final String columnNames[] = {
			"아이디", "이름", "나이", "성별", 
			"핸드폰번호","이메일", "주소", "가입날자"
		}; // 8		
		
		MemberDBMgr mgr = new MemberDBMgr();
		joinList = mgr.selectAllMembers();
		if( joinList == null || joinList.isEmpty() ) return;
		final int nDBSize = joinList.size();
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			Member fd = joinList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][0] = fd.getId();  
			data[i][1] = fd.getName();
			data[i][2] = fd.getAge();
			data[i][3] = fd.getGender()
					== Member.GENDER_MALE ? "남": "여";
			data[i][4] = fd.getPhoneNumber(); // 핸드폰 번호
			data[i][5] = fd.getEmail(); // 이메일
			data[i][6] = fd.getAddress(); // 주소 
			SimpleDateFormat ckl = 
					new SimpleDateFormat("YYYY-MM-dd"); // 가입 날자
			data[i][7] = ckl.format(fd.getJoinDay());
		}
		
		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		this.JoinTable.setModel(dtm);		
	}
}
