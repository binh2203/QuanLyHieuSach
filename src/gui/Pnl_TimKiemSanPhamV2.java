package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class Pnl_TimKiemSanPhamV2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Pnl_TimKiemSanPhamV2() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("tim san pham");
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);

	}

}
