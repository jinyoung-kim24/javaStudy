package meal.recipe;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CookingProcessPicture extends JPanel {

	JLabel btnSelectPicture;
	JPanel pnRecipe;
	JPanel pnRecipeOrder;
	JLabel lblCookingPicture;

	/**
	 * Create the panel.
	 */

	public CookingProcessPicture() {
		this(null, 0, "");
	}

	public CookingProcessPicture(CardLayout cards, int CookingProcess, String txtCkPrcs) {
		this.setBounds(515, 120, 260, 260);
		this.setLayout(null);
		pnRecipe = new JPanel();
		pnRecipe.setBounds(0, 0, 260, 260);
		this.add(pnRecipe);
		pnRecipe.setLayout(cards);
		JLabel[] btnSelectPictures = new JLabel[CookingProcess];
		for (int count = 0; count < CookingProcess; count++) {
			btnSelectPicture = new JLabel("");
			btnSelectPicture.setHorizontalAlignment(SwingConstants.CENTER);
			btnSelectPicture.setFocusable(false);
			btnSelectPicture.setBackground(Color.WHITE);
			btnSelectPicture.setIcon(new ImageIcon("./images/button/" + (count == 0 ? "파란 원.png" : "회색 원.png")));
			btnSelectPicture.setOpaque(false);
			btnSelectPicture.setBounds((CookingProcess * 20), 235, 25, 25);
			this.add(btnSelectPicture);
			pnRecipeOrder = new JPanel();
			pnRecipe.add(pnRecipeOrder, "Picture" + count);
			pnRecipeOrder.setLayout(null);
			lblCookingPicture = new JLabel();
			lblCookingPicture.setIcon(new ImageIcon(
					"C:\\Users\\mrhi05-13\\Desktop\\1\uCC28 \uD504\uB85C\uC81D\uD2B8\\\uACFC\uC8151.png"));
			lblCookingPicture.setBounds(0, 0, 260, 260);
			pnRecipeOrder.add(lblCookingPicture);

			btnSelectPictures[count] = btnSelectPicture;
		}
		btnSelectPicture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int count = 0; count < btnSelectPictures.length; count++) {
					cards.show(pnRecipe, "Picture" + count);
					btnSelectPicture
							.setIcon(new ImageIcon("./images/button/" + (count == 0 ? "파란 원.png" : "회색 원.png")));
					btnSelectPicture.setText(txtCkPrcs);
				}
			}
		});

	}
}