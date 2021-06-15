package formeal.shop;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class MainImagePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainImagePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
	}

}
