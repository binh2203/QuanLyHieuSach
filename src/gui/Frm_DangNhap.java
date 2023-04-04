package gui;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class Frm_DangNhap extends JFrame {
	private JButton bttLogon;
	private JButton bttExit;
	private JTextField tfUser;
	private JPasswordField tfPass;

	public Frm_DangNhap() {
		setTitle("Đăng nhập");
		setSize(700, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		buildGUI();
	}

private void buildGUI(){
	JPanel pnlNorth=new JPanel();
	pnlNorth.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	JLabel labelLogon;
	pnlNorth.add(labelLogon=new JLabel("Đăng nhập vào hệ thống"));
	labelLogon.setFont(new Font("Segoe UI", Font.BOLD,30));
	labelLogon.setForeground(Color.black);
	add(pnlNorth,BorderLayout.NORTH);
	JPanel pnlWest=new JPanel();
	pnlWest.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	ImageIcon myImage=new ImageIcon("D:\\32_HuynhVoCongLinh_20060611\\images\\pic1.png");
	pnlWest.add(new JLabel(myImage));
	add(pnlWest,BorderLayout.WEST);
	JPanel pnlSouth=new JPanel();
	pnlSouth.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	pnlSouth.add(bttLogon=new JButton("Đăng nhập"));
	pnlSouth.add(bttExit=new JButton("Thoát"));
	add(pnlSouth,BorderLayout.SOUTH);
	JPanel pnlCenter=new JPanel();
	pnlCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	Box b=Box.createVerticalBox();
	Box b1=Box.createHorizontalBox();
	Box b2=Box.createHorizontalBox();
	JLabel lblUser,lblPass;
	b1.add(lblUser=new JLabel("Tài khoản:"));
	lblUser.setFont(new Font("Segoe UI",Font.PLAIN,15));
	b1.add(tfUser=new JTextField(20));
	b2.add(lblPass=new JLabel("Mật khẩu:"));
	lblPass.setFont(new Font("Segoe UI",Font.PLAIN,15));
	b2.add(tfPass=new JPasswordField(20));
	lblPass.setPreferredSize(lblUser.getPreferredSize());
	b.add(Box.createVerticalStrut(50));
	b.add(b1);b.add(Box.createVerticalStrut(10));
	b.add(b2);
	pnlCenter.add(b);
	add(pnlCenter,BorderLayout.CENTER);

}

	public static void main(String[] args) {
		new Frm_DangNhap().setVisible(true);
	}

}
