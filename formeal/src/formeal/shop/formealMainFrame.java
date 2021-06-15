package formeal.shop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import formeal.ui.foods.FoodsMainFrame6;

public class formealMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private formealMainFrame searchfrm;
	JComboBox comboBox ;
	JComboBox comboBox_1;
	JComboBox comboBox_2;
	JComboBox comboBox_3;
	
	//static ArrayList<Foods> newList;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	
	public formealMainFrame() {
//		this.rfrm=rfm;
		this.searchfrm=this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\JAVA-WS\\formeal\\images\\mainicon.png"));
		setBackground(Color.WHITE);
		setBounds(100, 100, 926, 283);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(213, 77, 638, 33);
		panel.setBackground(new Color(255, 222, 173));
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JList list = new JList();
		panel.add(list);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\rbwls\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\formeal\uB85C\uACE02.png"));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("\uC74C\uC2DD\uD0C0\uC785");
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(new Color(244, 164, 96));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uD55C\uC2DD", "\uC911\uC2DD", "\uC591\uC2DD", "\uC77C\uC2DD", "\uBD84\uC2DD"}));
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\uC870\uB9AC\uC2DC\uAC04");
		panel.add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.WHITE);
		comboBox_1.setBackground(new Color(244, 164, 96));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"15", "30", "60"}));
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBA87 \uC778\uBD84");
		panel.add(lblNewLabel_2);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setForeground(Color.WHITE);
		comboBox_2.setBackground(new Color(244, 164, 96));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		panel.add(comboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC694\uB9AC \uB09C\uC774\uB3C4");
		panel.add(lblNewLabel_3);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setForeground(Color.WHITE);
		comboBox_3.setBackground(new Color(244, 164, 96));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\uCD08\uAE09", "\uC911\uAE09", "\uACE0\uAE09"}));
		panel.add(comboBox_3);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//콤보의 재료 를 지역 변수에 넣고
				String foodType=(String)comboBox.getSelectedItem();
				String cookMinute=(String)comboBox_1.getSelectedItem();
				String eatPerson=(String)comboBox_2.getSelectedItem();
				String cookGrade=(String)comboBox_3.getSelectedItem();
				 
				//FoodsDBMgr fbMgr = new FoodsDBMgr();
//				ArrayList<Foods> newList = fbMgr.selectFoodforType(foodType,cookMinute,eatPerson,cookGrade);
				
//				for (Foods mb : newList) {
//					System.out.println(mb);
//				}

				
				
				
				FoodsMainFrame6 resultFrame
				
				= new FoodsMainFrame6(searchfrm,foodType,cookMinute,eatPerson,cookGrade, getName());
				Point fPt = searchfrm.getLocationOnScreen();
		resultFrame.setLocation(fPt.x+searchfrm.getWidth()+20,fPt.y);
			// 옆에 나란히 창이 표시
		resultFrame.setVisible(true);
		searchfrm.dispose();
			}
		});
		panel.add(btnNewButton);
		
		JLabel lbMainLogo = new JLabel("");
		lbMainLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMainLogo.setIcon(new ImageIcon("C:\\Users\\mrhi05-03\\Desktop\\\uB85C\uACE0 \uD3B8\uC9D1\uBAA8\uC74C\\\uB85C\uACE0 4.png"));
		lbMainLogo.setBounds(91, 35, 140, 140);
		contentPane.add(lbMainLogo);
		ImageIcon icon = new ImageIcon("./images/mainlmage.png");
		Image img = icon.getImage();
		Image chageImg = img.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(chageImg);
		lbMainLogo.setIcon(changeIcon);
		
//		textField = new JTextField();
//		panel.add(textField);
//		textField.setColumns(10);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new formealMainFrame();
		
	}
}
