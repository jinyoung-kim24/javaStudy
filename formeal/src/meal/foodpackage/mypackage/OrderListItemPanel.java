package meal.foodpackage.mypackage;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderListItemPanel extends JPanel {
	JLabel lblNumber, lblOrderList, lblOrderDay, lblOrderCondition;
	JCheckBox chckbx;
	/**
	 * Create the panel.
	 */
	public OrderListItemPanel() {
		this(0, "", null);
	}
	
	public OrderListItemPanel(int Cnt, String orderList, ButtonGroup buttonGroup) {

		this.setLayout(new GridLayout(0, 5, 0, 0));
		this.setBackground(new Color(249, 193, 116));
		for (int topCnt = 0; (topCnt + Cnt) < (Cnt + 1); topCnt++) {
			lblNumber = new JLabel("" + (Cnt + 1));
			lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumber.setForeground(Color.white);
			lblOrderList = new JLabel(orderList);
			lblOrderList.setForeground(Color.white);
			lblOrderDay = new JLabel(""+new Date());
			lblOrderDay.setForeground(Color.white);
			lblOrderDay.setHorizontalAlignment(SwingConstants.CENTER);
			lblOrderCondition = new JLabel("배송 준비 중");
			lblOrderCondition.setForeground(Color.white);
			lblOrderCondition.setHorizontalAlignment(SwingConstants.CENTER);
			chckbx = new JCheckBox("");
			chckbx.setBackground(new Color(249, 193, 116));
			chckbx.setHorizontalAlignment(SwingConstants.CENTER);
			buttonGroup.add(chckbx);
			this.add(lblNumber);
			this.add(lblOrderList);
			this.add(lblOrderDay);
			this.add(lblOrderCondition);
			this.add(chckbx);
		}
		this.updateUI();
		this.repaint();
	}
}