package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class Pnl_TimKiemSanPham extends javax.swing.JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;

	public Pnl_TimKiemSanPham() {
		setBackground(new Color(255, 128, 128));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBackground(new Color(255, 128, 128));
		panel.add(btnNewButton, BorderLayout.CENTER);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBackground(new Color(255, 128, 128));
		panel.add(btnNewButton_1, BorderLayout.WEST);
		
		lblNewLabel = new JLabel("Tìm Kiếm Sản Phẩm");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		
		lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1, BorderLayout.NORTH);
	}

}
