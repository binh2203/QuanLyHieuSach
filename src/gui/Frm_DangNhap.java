package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import dao.TaiKhoanDao;
import entity.TaiKhoan;

public class Frm_DangNhap extends JFrame implements ActionListener, MouseListener{
	private JButton btnDangNhap;
	private JButton bttExit;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	private JLabel lblBackgorund;
	private JButton btnQuenMatKhau;
	private Frm_QuenMatKhau frm_QuenMatKhau = new Frm_QuenMatKhau();
	public static TaiKhoan taiKhoan;
	public Frm_DangNhap() {
		setTitle("Đăng nhập");
		setSize(700, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		buildGUI();
	}

	private void buildGUI(){
	JPanel pnlNorth=new JPanel();
	pnlNorth.setBackground(new Color(240, 255, 240));
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
	pnlSouth.setBackground(new Color(240, 255, 240));
	pnlSouth.setBounds(0, 270, 684, 41);
	pnlSouth.setBorder(new LineBorder(new Color(192, 192, 192), 0));
	
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
	
	btnQuenMatKhau = new JButton("Quên mật khẩu");
	btnQuenMatKhau.addActionListener(this);
	btnQuenMatKhau.setOpaque(true);
	btnQuenMatKhau.setForeground(Color.WHITE);
	btnQuenMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btnQuenMatKhau.setFocusPainted(false);
	btnQuenMatKhau.setContentAreaFilled(true);
	btnQuenMatKhau.setBorderPainted(false);
	btnQuenMatKhau.setBackground(new Color(153, 102, 102));
	pnlSouth.add(btnQuenMatKhau);
	
	pnlSouth.add(btnDangNhap=new JButton("Đăng nhập"));
	btnDangNhap.setOpaque(true);
	btnDangNhap.setContentAreaFilled(true);
	btnDangNhap.setBorderPainted(false);
	btnDangNhap.setFocusPainted(false);
	btnDangNhap.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btnDangNhap.setForeground(new Color(255, 255, 255));
	btnDangNhap.setBackground(new Color(153, 102, 102));
	btnDangNhap.addActionListener(this);
	JPanel pnlCenter=new JPanel();
	pnlCenter.setBackground(new Color(240, 255, 240));
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
	b1.add(txtTenDangNhap=new JTextField(20));
	b2.add(lblPass=new JLabel("Mật khẩu:"));
	lblPass.setForeground(new Color(255, 255, 255));
	lblPass.setOpaque(true);
	lblPass.setBackground(new Color(153, 102, 102));
	lblPass.setFont(new Font("Segoe UI", Font.BOLD, 15));
	b2.add(txtMatKhau=new JPasswordField(20));
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_DangNhap frame = new Frm_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			hoverIn(btnDangNhap);
		}
		if (o.equals(btnQuenMatKhau)) {
			hoverIn(btnQuenMatKhau);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			hoverOut(btnDangNhap);
		}
		if (o.equals(btnQuenMatKhau)) {
			hoverOut(btnQuenMatKhau);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		String strUserName = txtTenDangNhap.getText();
		char[] chPassWord = ((JPasswordField) txtMatKhau).getPassword();
		String strPassword = new String(chPassWord);
		// boolean quyen = comboBox.getSelectedItem().equals("Nhân Viên") ? false :
		// true;
		boolean status = false;
		TaiKhoanDao accControl = new TaiKhoanDao();
		List<TaiKhoan> list = accControl.getList();
		
		if (obj.equals(btnDangNhap)) {
			// System.out.println("ok");
			for (TaiKhoan account : list) {
				if (strUserName.equalsIgnoreCase(account.getTenDangNhap())) {
					if (strPassword.trim().equalsIgnoreCase(account.getMatKhau())) {
						if (account.isQuyen() == true) {
							// System.out.println(account);
							taiKhoan = account;
							this.dispose();
							try {
								new Frm_TrangChuQuanLy().setVisible(true);
							} catch (Exception e1) {
								// TODO Auto-generated catch blockTK
								e1.printStackTrace();
							}
							status = true;
							break;
						}
						if (account.isQuyen() == false) {
							taiKhoan = account;
							this.dispose();
							try {
								new Frm_TrangChuNhanVien().setVisible(true);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							status = true;
							break;
						}
					}
				}
			}
			if (status == false) {
				JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
				txtTenDangNhap.selectAll();
				txtTenDangNhap.requestFocus();
			}
		}
		if (obj.equals(btnQuenMatKhau)) {
			int resq = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn đổi mật khẩu không ?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (resq == JOptionPane.NO_OPTION)
				System.exit(0);
			else {
				//this.setVisible(false);
				frm_QuenMatKhau.setVisible(true);
			}
		}
	}
	
	public TaiKhoan getTaiKhoanDangNhapThanhCong() {
		return taiKhoan;
	}
	private void hoverIn(JButton button) {
		// System.out.println("in ok");
		button.setBackground(new Color(255, 255, 0));
		button.setForeground(new Color(128, 0, 0));
	}

	private void hoverOut(JButton button) {
		// System.out.println("in ok");
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(new Color(255, 255, 0));
	}
	public int GetMaxWidth() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	}

	public int GetMaxHeight() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	}
}
