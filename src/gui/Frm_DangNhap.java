package gui;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Frm_DangNhap extends JFrame {
	private JButton bttLogon;
	private JButton bttExit;
	private JTextField tfUser;
	private JPasswordField tfPass;
	private JLabel lblBackgorund;
	public Frm_DangNhap() {
		setTitle("Đăng nhập");
		setSize(700, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		buildGUI();
	}

private void buildGUI(){
	JPanel pnlNorth=new JPanel();
	pnlNorth.setBackground(new Color(250, 235, 215));
	pnlNorth.setBounds(0, 0, 684, 53);
	pnlNorth.setBorder(new LineBorder(new Color(192, 192, 192), 0));
	JLabel labelLogon;
	pnlNorth.add(labelLogon=new JLabel("Đăng nhập vào hệ thống"));
	labelLogon.setFont(new Font("Segoe UI", Font.BOLD,30));
	labelLogon.setForeground(new Color(204, 102, 102));
	getContentPane().setLayout(null);
	getContentPane().add(pnlNorth);
	ImageIcon imgThisImg = new ImageIcon("D:\\32_HuynhVoCongLinh_20060611\\images\\pic1.png");
	JPanel pnlSouth=new JPanel();
	pnlSouth.setBackground(new Color(250, 235, 215));
	pnlSouth.setBounds(0, 270, 684, 41);
	pnlSouth.setBorder(new LineBorder(new Color(192, 192, 192), 0));
	
	pnlSouth.add(bttLogon=new JButton("Đăng nhập"));
	bttLogon.setOpaque(true);
	bttLogon.setContentAreaFilled(true);
	bttLogon.setBorderPainted(false);
	bttLogon.setFocusPainted(false);
	bttLogon.setFont(new Font("Segoe UI", Font.BOLD, 15));
	bttLogon.setForeground(new Color(255, 255, 255));
	bttLogon.setBackground(new Color(153, 102, 102));
	
	pnlSouth.add(bttExit=new JButton("Thoát"));
	bttExit.setOpaque(true);
	bttExit.setContentAreaFilled(true);
	bttExit.setBorderPainted(false);
	bttExit.setFocusPainted(false);
	bttExit.setFont(new Font("Segoe UI", Font.BOLD, 15));
	bttExit.setForeground(new Color(255, 255, 255));
	bttExit.setBackground(new Color(153, 102, 102));
	bttExit.setOpaque(true);
	getContentPane().add(pnlSouth);
	JPanel pnlCenter=new JPanel();
	pnlCenter.setBackground(new Color(250, 235, 215));
	pnlCenter.setBounds(0, 53, 684, 223);
	pnlCenter.setBorder(new LineBorder(new Color(192, 192, 192), 0));
	Box b=Box.createVerticalBox();
	b.setBounds(410, 56, 233, 102);
	Box b1=Box.createHorizontalBox();
	Box b2=Box.createHorizontalBox();
	JLabel lblUser,lblPass;
	b1.add(lblUser=new JLabel("Tài khoản:"));
	lblUser.setForeground(new Color(255, 255, 255));
	lblUser.setBackground(new Color(153, 102, 102));
	lblUser.setOpaque(true);
	lblUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
	b1.add(tfUser=new JTextField(20));
	b2.add(lblPass=new JLabel("Mật khẩu:"));
	lblPass.setForeground(new Color(255, 255, 255));
	lblPass.setOpaque(true);
	lblPass.setBackground(new Color(153, 102, 102));
	lblPass.setFont(new Font("Segoe UI", Font.BOLD, 15));
	b2.add(tfPass=new JPasswordField(20));
	lblPass.setPreferredSize(lblUser.getPreferredSize());
	pnlCenter.setLayout(null);
	lblBackgorund = new JLabel("");
	lblBackgorund.setIcon(
			new ImageIcon(new ImageIcon(Frm_DangNhap.class.getResource("/img/trangchu.jpg")).getImage().getScaledInstance(318 , 179, Image.SCALE_DEFAULT)));
	lblBackgorund.setBounds(55, 22, 318, 179);
	pnlCenter.add(lblBackgorund);
	b.add(Box.createVerticalStrut(50));
	b.add(b1);b.add(Box.createVerticalStrut(10));
	b.add(b2);
	pnlCenter.add(b);
	getContentPane().add(pnlCenter);

}

	public static void main(String[] args) {
		new Frm_DangNhap().setVisible(true);
	}

}
