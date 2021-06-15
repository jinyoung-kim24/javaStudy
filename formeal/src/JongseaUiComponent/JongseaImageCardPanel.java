package JongseaUiComponent;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import formeal.FormealMainFrame;
import db.data.Foods;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


	public class JongseaImageCardPanel extends JPanel {
//		public class JongseaImageCardPanel extends ImagePanel {
//			public JongseaImageCardPanel() {
//			}
			Foods fd;
			//
			JLabel lbFoodName;
//			JLabel lbFoodCate;
			JLabel lbFoodImage;
//			JTextArea taFoodDesc;
//			JLabel lbFoodPrice;
//			JLabel lbFoodHotIce;
			CardLayout foodCdlay;
			FormealMainFrame ImageCardPanel;
			
			public  JongseaImageCardPanel(Foods fd) {
				
				setBackground(new Color(255, 222, 173));
				this.fd = fd;
				setLayout(null);
//				
				lbFoodName = new JLabel(fd.getfoodName());
				lbFoodName.setForeground(Color.WHITE);
				lbFoodName.setBackground(new Color(255, 222, 173));
				lbFoodName.setHorizontalAlignment(SwingConstants.CENTER);
				lbFoodName.setFont(new Font("양재깨비체B", Font.PLAIN, 22));
				lbFoodName.setBounds(0, 12, 162, 25);
				
				this.add(lbFoodName);
//			
//				lbFoodCate = new JLabel("\uC885\uB958");
//				lbFoodCate.setHorizontalAlignment(SwingConstants.CENTER);
//				lbFoodCate.setFont(new Font("굴림", Font.BOLD, 18));
//				lbFoodCate.setBounds(287, 0, 102, 26);
//				this.add(lbFoodCate);
				
				lbFoodImage = new JLabel("");
				lbFoodImage.setBorder(new BevelBorder(BevelBorder.RAISED,new Color(255, 222, 173), null, Color.ORANGE, null));
				lbFoodImage.setBounds(0, 0, 372, 277);
				
				this.add(lbFoodImage);
				
//				JButton btnLeft = new JButton("\u25C0");
//				btnLeft.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent arg0) {
//						System.out.println("이전 카드 표시");
//						foodCdlay.previous(ImageCardPanel);
//						
//					}
//				});
//				btnLeft.setBackground(Color.ORANGE);
//				btnLeft.setBounds(45, 281, 105, 27);
//				add(btnLeft);
				
//				JButton btnRight = new JButton("\u25B6");
//				btnRight.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent arg0) {
//						System.out.println("다음  카드 표시");
//						
//						foodCdlay.next(ImageCardPanel);
//						
//
//						
//						foodCdlay.first(pnMenu);
//						foodCdlay.last(pnMenu);
//						foodCdlay.previous(pnMenu);
//						foodCdlay.show(parent, name);
//					}
//				});
//				btnRight.setBackground(new Color(255, 200, 0));
//				btnRight.setBounds(240, 281, 105, 27);
//				add(btnRight);
					
				
				
				
				
					
					
//			
				
//				taFoodDesc = new JTextArea();
//				taFoodDesc.setBounds(234, 32, 188, 182);
//				this.add(taFoodDesc);
				
//				lbFoodPrice = new JLabel("\uAC00\uACA9: 1000\uC6D0");
//				lbFoodPrice.setFont(new Font("굴림", Font.BOLD, 18));
//				lbFoodPrice.setBounds(32, 226, 159, 15);
//				this.add(lbFoodPrice);
				
//				lbFoodHotIce = new JLabel("HOT");
//				lbFoodHotIce.setHorizontalAlignment(SwingConstants.CENTER);
//				lbFoodHotIce.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
//				lbFoodHotIce.setForeground(Color.RED);
//				lbFoodHotIce.setBounds(301, 224, 57, 15);
//				this.add(lbFoodHotIce);

				showFoodDataToUI(fd);
			}

			public  void showFoodDataToUI(Foods fd) {
				this.lbFoodName.setText(fd.getfoodName());
//				this.lbFoodCate.setText(fd.getfoodType());
				
				String filename = fd.getImagePath();
//				String filename = fd.getImagePath()
//						.replace("images");
				ImageIcon ic = new ImageIcon(filename);
				// 이미지를 재스케일링
				Image scaled = ic.getImage()
					.getScaledInstance(lbFoodImage.getWidth(),
							lbFoodImage.getHeight(), 
							Image.SCALE_FAST); 
				ic.setImage(scaled);
				this.lbFoodImage.setIcon(ic);
				this.lbFoodImage.repaint(); // 중요!!
//				
//				this.taFoodDesc.setText(fd.getDescription());
//				this.lbFoodPrice.setText("가격: " +fd.getPrice()+"원");
//				this.lbFoodHotIce.setText( 
//					fd.getHotIce() == Foods.TEMP_HOT ? "HOT": "ICE" );
//				this.lbFoodHotIce.setForeground(
//					fd.getHotIce() == Foods.TEMP_HOT ? 
//							Color.red : Color.blue	);
//			}
//			
			}	
			}
