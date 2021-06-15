package cafe.ui.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.data.Food;
import db.mgr.FoodDBMgr;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFoodMenuAddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JLabel lbMenuImgDetail;
	JComboBox comboCate;
	JLabel lbMenuImgPath;
	JSpinner spinMenuPrice;
	JTextArea taMenuDesc;
	JRadioButton rdFoodHot; // hot select.
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			AdminFoodMenuAddDialog dialog = new AdminFoodMenuAddDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	CafeAdminFrame frm;
	private JTextField txtFoodName;
	private final ButtonGroup grpHotIce = new ButtonGroup();
	AdminFoodMenuAddDialog dlg;
	
	
	public AdminFoodMenuAddDialog(CafeAdminFrame frm) {
		super(frm, true);
		setTitle("\uC2E0\uADDC \uC74C\uC2DD \uBA54\uB274 \uCD94\uAC00");
		this.frm = frm;
		this.dlg = this;
		setBounds(100, 100, 615, 501);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.6);
		splitPane.setOneTouchExpandable(true);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		//getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(6, 2, 0, 0));
		splitPane.setLeftComponent(contentPanel);
		{
			JLabel lblNewLabel = new JLabel("\uBA54\uB274 \uC774\uB984:");
			contentPanel.add(lblNewLabel);
		}
		{
			txtFoodName = new JTextField();
			contentPanel.add(txtFoodName);
			txtFoodName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274 \uCE74\uD14C\uACE0\uB9AC:");
			contentPanel.add(lblNewLabel_1);
		}
		{
			//JComboBox comboCate = new JComboBox();
			comboCate = new JComboBox();
			comboCate.setMaximumRowCount(3);
			comboCate.setModel(new DefaultComboBoxModel(new String[] {"\uC74C\uC2DD", "\uC74C\uB8CC", "\uCEE4\uD53C"}));
			comboCate.setSelectedIndex(0);
			contentPanel.add(comboCate);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\uBA54\uB274 \uC0AC\uC9C4:");
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel pnMenuImage = new JPanel();
			pnMenuImage.setBackground(Color.PINK);
			contentPanel.add(pnMenuImage);
			pnMenuImage.setLayout(new BorderLayout(0, 0));
			
			JLabel lbMenuImg = new JLabel("");
			pnMenuImage.add(lbMenuImg, BorderLayout.CENTER);
			
			{
				//JLabel lbMenuImgPath = new JLabel("no path");
				lbMenuImgPath = new JLabel("no path");
				lbMenuImgPath.setToolTipText("\uD074\uB9AD \uD558\uC5EC \uC774\uBBF8\uC9C0 \uC120\uD0DD\uD558\uAE30...");
				lbMenuImgPath.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// ���� �޴��� ���� �̹��� ���� ��� ������...
						final String currentDirPath
						 = "./images/menu_thumb";
						final String currentDirPathDetail
						 = "./images/menu_detail";
						JFileChooser openDlg // ���� ���ϴ�ȭ����
						 = new JFileChooser(currentDirPath);
//						openDlg.showOpenDialog(parent); // �б� 
//						openDlg.showSaveDialog(parent); // ����					
						if( openDlg.showOpenDialog(dlg) 
								== JFileChooser.APPROVE_OPTION ) {
							File imgFile = openDlg.getSelectedFile();
								// ���õ� ����
							System.out.println("���õ� ���ϸ�: " +  imgFile.getName());
							System.out.println("���õ� ���ϰ�θ�: " +  imgFile.getPath());
							
							String dbImgPath
								= currentDirPath + "/" + imgFile.getName();
							lbMenuImgPath.setText(dbImgPath);
							lbMenuImgPath.setToolTipText("�̹��� ���: " + imgFile.getPath());
							// 42x42 ������
							ImageIcon ic = new ImageIcon(imgFile.getPath());
							Image icImg = ic.getImage()
								.getScaledInstance(42, 42, Image.SCALE_SMOOTH);
							ic.setImage(icImg);
							lbMenuImg.setIcon(ic);
							lbMenuImg.repaint();
							// �������� �� �̹��� detail
							dlg.lbMenuImgDetail.setText("");
							dlg.lbMenuImgDetail.setIcon(
									new ImageIcon(currentDirPathDetail 
											+ "/" + imgFile.getName()));
							dlg.lbMenuImgDetail.repaint();
							
						} else {
							System.out.println("���� ���� ����...����..");
							lbMenuImgPath.setText("no image!!");
							dlg.lbMenuImgDetail.setText("�̹��� ����");
							dlg.lbMenuImgDetail.setIcon(null);// �̹���ǥ��x
							dlg.lbMenuImgDetail.repaint();
						}
					}
				});
				lbMenuImgPath.setForeground(Color.GREEN);
				pnMenuImage.add(lbMenuImgPath, BorderLayout.SOUTH);
			}
//			{
//				JLabel lbMenuImg = new JLabel("");
//				pnMenuImage.add(lbMenuImg, BorderLayout.CENTER);
//			}
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\uBA54\uB274 \uC124\uBA85:");
			contentPanel.add(lblNewLabel_3);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				//JTextArea taMenuDesc = new JTextArea();
				taMenuDesc = new JTextArea();
				scrollPane.setViewportView(taMenuDesc);
			}
		}
		{
			JLabel lblNewLabel_4 = new JLabel("\uBA54\uB274 \uAC00\uACA9:");
			contentPanel.add(lblNewLabel_4);
		}
		{
			//JSpinner spinMenuPrice = new JSpinner();
			spinMenuPrice = new JSpinner();
			spinMenuPrice.setModel(new SpinnerNumberModel(new Integer(1000), new Integer(100), null, new Integer(100)));
			contentPanel.add(spinMenuPrice);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("\uD56B/\uC544\uC774\uC2A4:");
			contentPanel.add(lblNewLabel_5);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(1, 2, 0, 0));
			{
//				JRadioButton rdFoodHot = new JRadioButton("HOT");
				rdFoodHot = new JRadioButton("HOT");
				rdFoodHot.setSelected(true);
				grpHotIce.add(rdFoodHot);
				rdFoodHot.setHorizontalAlignment(SwingConstants.CENTER);
				rdFoodHot.setForeground(Color.RED);
				panel.add(rdFoodHot);
			}
			{
				JRadioButton rdFoodIce = new JRadioButton("ICE");
				grpHotIce.add(rdFoodIce);
				rdFoodIce.setHorizontalAlignment(SwingConstants.CENTER);
				rdFoodIce.setForeground(Color.BLUE);
				panel.add(rdFoodIce);
			}
		}
		{
			JPanel panel = new JPanel();
			splitPane.setRightComponent(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				//JLabel lbMenuImgDetail = new JLabel("\uC774\uBBF8\uC9C0 \uC5C6\uC74C");
				lbMenuImgDetail = new JLabel("\uC774\uBBF8\uC9C0 \uC5C6\uC74C");
				lbMenuImgDetail.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbMenuImgDetail, BorderLayout.CENTER);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnFoodAdd = new JButton("\uBA54\uB274 \uCD94\uAC00");
				btnFoodAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// food ��� (�Է°���)�� ui���� ��������
						String fdname = dlg.txtFoodName.getText();
						String fdcategory = 
								(String) dlg.comboCate.getSelectedItem();
						String fdimagePath = dlg.lbMenuImgPath.getText();
						int fdprice = (int) dlg.spinMenuPrice.getValue();
						int fdhotIce = dlg.rdFoodHot
								.isSelected() ? Food.TEMP_HOT: Food.TEMP_ICE;
						String fddescription = dlg.taMenuDesc.getText();
						// ������ �߰� �����ڷ� ��� �ϳ��� ������ ��ü�� ����..
						Food fd = new Food(fdname, 
								fdcategory, fdimagePath, 
								fdprice, fdhotIce, fddescription); 
						// db �߰��ڸ� ���� ���� db�� ������ ��ü�� SQL�� ��ȯ�Ͽ� insert �ϱ�
						FoodDBMgr mgr = new FoodDBMgr();
						if( mgr.addNewOneFood(fd) ) {
							System.out.println("�߰� ����! " + fd);
							dlg.setVisible(false);
							frm.showFoodTableUIFromDB();
							// ���� �߰��� ���� ���ڵ� ������ foods ���̺��� ��ȸ�Ͽ� 
							// UI table�� �ٽ� ǥ�����ּ���..
							dlg.dispose();
						} else {
							; // ??
						}
					}
				});
				btnFoodAdd.setActionCommand("OK");
				buttonPane.add(btnFoodAdd);
				getRootPane().setDefaultButton(btnFoodAdd);
			}
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}


/*
���� ���� ����...����..
���õ� ���ϸ�: ����ũƼ.PNG
���õ� ���ϰ�θ�: C:\dev2021\java_ws\GUICafeProject\images\menu_thumb\����ũƼ.PNG
*/