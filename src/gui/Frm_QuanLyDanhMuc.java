package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import entity.MauSac;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.TacGia;
import entity.TheLoaiSach;
import entity.TheLoaiVanPhongPham;
import entity.NhaSanXuat;

import service_impl.MauSacServiceImpl;
import service_impl.NhaCungCapServiceImpl;
import service_impl.NhaXuatBanServiceImpl;
import service_impl.SanPhamServiceImpl;
import service_impl.TacGiaServiceImpl;
import service_impl.TheLoaiServiceImpl;
import service_impl.NhaSanXuatServiceImpl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Frm_QuanLyDanhMuc extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private DefaultTableModel modelThuocTinh;
	private JTable tableThuocTinh;
	private JScrollPane scrollThuocTinh;
	private JLabel lblMa;
	private JLabel lblTen;
	private JRadioButton radTheLoai;
	private JRadioButton radNXBorNSX;
	private JRadioButton radTacGiaorChatLieu;
	private JRadioButton radNhaCungCap;
	private JRadioButton radMauSac;
	private JButton btnThem;
	private String loaiSanPham;
	
	SanPhamServiceImpl sanPhamServiceImpl = new SanPhamServiceImpl();
	TheLoaiServiceImpl theLoaiServiceImpl = new TheLoaiServiceImpl();
	TacGiaServiceImpl tacGiaServiceImpl = new TacGiaServiceImpl();
	NhaXuatBanServiceImpl nhaXuatBanServiceImpl = new NhaXuatBanServiceImpl();
	NhaCungCapServiceImpl nhaCungCapServiceImpl = new NhaCungCapServiceImpl();
	NhaSanXuatServiceImpl nhaSanXuatServiceImpl = new NhaSanXuatServiceImpl();
	MauSacServiceImpl mauSacServiceImpl = new MauSacServiceImpl();
	private ArrayList<TheLoaiSach> theLoaiSachs;
	private ArrayList<TheLoaiVanPhongPham> theLoaiVanPhongPhams;
	private ArrayList<NhaCungCap> nhaCungCaps;
	private ArrayList<NhaXuatBan> nhaXuatBans;
	private ArrayList<NhaSanXuat> nhaSanXuats;
	private ArrayList<TacGia> tacGias;
	private ArrayList<MauSac> mauSacs;
	private JLabel lblTitle;
	private JButton btnHuy;
	private ButtonGroup group;
	private JTextField txtEmail;
	private JTextField txtSdt;
	private JLabel lblSdt;
	private JLabel lblEmail;
	private JTextField txtDiaChi;
	private JLabel lblDiaChi;
	/**
	 * Create the frame.
	 */
	public Frm_QuanLyDanhMuc(String loai) {
		loaiSanPham = loai;
		setResizable(false);
		setSize(1000, 600);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMa.setBounds(237, 54, 233, 28);
		getContentPane().add(txtMa);
		txtMa.setColumns(10);

		lblTitle = new JLabel("QUẢN LÝ DANH MỤC");
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 966, 28);
		getContentPane().add(lblTitle);

		lblMa = new JLabel("Mã thể loại:");
		lblMa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMa.setBounds(20, 54, 218, 28);
		getContentPane().add(lblMa);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setColumns(10);
		txtTen.setBounds(237, 95, 233, 28);
		getContentPane().add(txtTen);

		lblTen = new JLabel("Tên thể loại:");
		lblTen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTen.setBounds(20, 95, 218, 28);
		getContentPane().add(lblTen);
		String[] cols = { "Mã", "Tên" };
		modelThuocTinh = new DefaultTableModel(cols, 0);
		tableThuocTinh = new JTable(modelThuocTinh);
		tableThuocTinh.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableThuocTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollThuocTinh = new JScrollPane(tableThuocTinh);
		scrollThuocTinh.setBounds(10, 256, 966, 307);

		tableThuocTinh.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableThuocTinh.setAutoCreateRowSorter(true);
		tableThuocTinh.setRowHeight(25);
//		tableThuocTinh.setBackground(Color.decode("#BEFFC0"));
		scrollThuocTinh.getViewport().setBackground(Color.WHITE);
		tableThuocTinh.getTableHeader().setPreferredSize(new Dimension(0, 40));
		getContentPane().add(scrollThuocTinh);

		radTheLoai = new JRadioButton("Thể loại sách");
		radTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radTheLoai.setBounds(510, 57, 211, 21);
		getContentPane().add(radTheLoai);

		radNXBorNSX = new JRadioButton("Nhà xuất bản");
		radNXBorNSX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radNXBorNSX.setBounds(510, 98, 157, 21);
		getContentPane().add(radNXBorNSX);

		radTacGiaorChatLieu = new JRadioButton("Tác giả");
		radTacGiaorChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radTacGiaorChatLieu.setBounds(718, 98, 91, 21);
		getContentPane().add(radTacGiaorChatLieu);

		radNhaCungCap = new JRadioButton("Nhà cung cấp");
		radNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radNhaCungCap.setBounds(718, 57, 141, 21);
		getContentPane().add(radNhaCungCap);

		radMauSac = new JRadioButton("Màu sắc");
		radMauSac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radMauSac.setBounds(871, 57, 91, 21);
		getContentPane().add(radMauSac);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(525, 133, 122, 28);
		getContentPane().add(btnThem);
		txtMa.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		txtTen.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setEditTxt(false);
		radTheLoai.setSelected(true);
		group = new ButtonGroup();
		group.add(radNXBorNSX);
		group.add(radTheLoai);
		group.add(radMauSac);
		group.add(radNhaCungCap);
		group.add(radTacGiaorChatLieu);

		btnHuy = new JButton("Thoát");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setBounds(668, 133, 122, 28);
		getContentPane().add(btnHuy);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		txtEmail.setBounds(237, 171, 233, 28);
		getContentPane().add(txtEmail);

		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(20, 171, 218, 28);
		getContentPane().add(lblEmail);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setEditable(false);
		txtSdt.setColumns(10);
		txtSdt.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		txtSdt.setBounds(237, 133, 233, 28);
		getContentPane().add(txtSdt);

		lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSdt.setBounds(20, 133, 218, 28);
		getContentPane().add(lblSdt);
	
		lblEmail.setVisible(false);
		lblSdt.setVisible(false);
		txtEmail.setVisible(false);
		txtSdt.setVisible(false);
		try {
			if (loaiSanPham.equals("Sách")) {
				loadThuocTinhSach();
				for (TheLoaiSach loaiSach : theLoaiSachs) {
					Object[] o1 = { loaiSach.getMaLoai(), loaiSach.getTenLoai() };
					modelThuocTinh.addRow(o1);
				}

			} else {
				loadThuocTinhVPP();
				for (TheLoaiVanPhongPham loaiVanPhongPham : theLoaiVanPhongPhams) {
					Object[] o1 = { loaiVanPhongPham.getMaLoai(), loaiVanPhongPham.getTenLoai() };
					modelThuocTinh.addRow(o1);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnThem.addActionListener(this);
		btnHuy.addActionListener(this);
		radNXBorNSX.addMouseListener(this);
		radTheLoai.addMouseListener(this);
		radMauSac.addMouseListener(this);
		radNhaCungCap.addMouseListener(this);
		radTacGiaorChatLieu.addMouseListener(this);
		tableThuocTinh.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if (o.equals(radTheLoai)) {
			setlbl("Mã thể loại:", "Tên thể loại:");
			if (loaiSanPham.equals("Sách")) {
				modelThuocTinh.setRowCount(0);
				for (TheLoaiSach loaiSach : theLoaiSachs) {
					Object[] o1 = { loaiSach.getMaLoai(), loaiSach.getTenLoai() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			} else {
				String[] cols = { "Mã thể loại", "Tên thể loại" };
				modelThuocTinh = new DefaultTableModel(cols, 0);
				tableThuocTinh = new JTable(modelThuocTinh);
				modelThuocTinh.setRowCount(0);
				for (TheLoaiVanPhongPham loaiVanPhongPham : theLoaiVanPhongPhams) {
					Object[] o1 = { loaiVanPhongPham.getMaLoai(), loaiVanPhongPham.getTenLoai() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			}
		}
		
		if (o.equals(radNXBorNSX)) {
			if (loaiSanPham.equals("Sách")) {
				setlbl("Mã nhà xuất bản:", "Tên nhà xuất bản:");
				modelThuocTinh.setRowCount(0);
				for (NhaXuatBan nhaXuatBan : nhaXuatBans) {
					Object[] o1 = { nhaXuatBan.getMaNXB(), nhaXuatBan.getTenNXB() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			} else {
				setlbl("Mã nhà sản xuất:", "Tên nhà sản xuất:");
				modelThuocTinh.setRowCount(0);
				for (NhaSanXuat nhaSanXuat : nhaSanXuats) {
					Object[] o1 = { nhaSanXuat.getMaNhaSX(), nhaSanXuat.getTenNhaSX() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			}
		}
		
		if (o.equals(radMauSac)) {
			setlbl("Mã màu:", "Tên màu:");
			modelThuocTinh.setRowCount(0);
			for (MauSac mauSac : mauSacs) {
				Object[] o1 = { mauSac.getMaMau(), mauSac.getTenMau() };
				modelThuocTinh.addRow(o1);
			}
			setTxt("", "");
		}
		
		if (o.equals(radTacGiaorChatLieu)) {
			if (loaiSanPham.equals("Sách")) {
				setlbl("Mã tác giả:", "Tên tác giả:");
				modelThuocTinh.setRowCount(0);
				for (TacGia tacGia : tacGias) {
					Object[] o1 = { tacGia.getMaTacGia(), tacGia.getTenTacGia() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			} else {
				setlbl("Mã chất liệu: ", "Tên chất liệu:");
				modelThuocTinh.setRowCount(0);
//				for (ChatLieu chatLieu : chatLieus) {
//					Object[] o1 = { chatLieu.getMaChatLieu(), chatLieu.getTenChatLieu() };
//					modelThuocTinh.addRow(o1);
//				}
				setTxt("", "");
			}
		}
		
		if (o.equals(radNhaCungCap)) {
			setlbl("Mã nhà cung cấp:", "Tên nhà cung cấp:");
			lblEmail.setVisible(true);
			lblSdt.setVisible(true);
			txtEmail.setVisible(true);
			txtSdt.setVisible(true);
			txtEmail.setText("");
			txtSdt.setText("");
			modelThuocTinh.setRowCount(0);
			for (NhaCungCap nhaCungCap : nhaCungCaps) {
				Object[] o1 = { nhaCungCap.getMaNhaCungCap(), nhaCungCap.getTenNhaCungCap() };
				modelThuocTinh.addRow(o1);
			}
			setTxt("", "");
		} else {
			lblEmail.setVisible(false);
			lblSdt.setVisible(false);
			txtEmail.setVisible(false);
			txtSdt.setVisible(false);
		}
		
		if (o.equals(tableThuocTinh)) {
			int row = tableThuocTinh.getSelectedRow();
			setTxt(modelThuocTinh.getValueAt(row, 0).toString().trim(),
					modelThuocTinh.getValueAt(row, 1).toString().trim());
			if (radNhaCungCap.isSelected()) {
				lblEmail.setVisible(true);
				lblSdt.setVisible(true);
				txtEmail.setVisible(true);
				txtSdt.setVisible(true);
				txtEmail.setText(nhaCungCaps.get(row).getEmail());
				txtSdt.setText(nhaCungCaps.get(row).getSdt());
			}
		}
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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (btnThem.getText().equals("Thêm")) {
				tableThuocTinh.removeMouseListener(this);
				String ma = "";
				setRadEnable(false);
				if (loaiSanPham.equals("Sách")) {
					if (radTheLoai.isSelected())
						ma = tangMa(theLoaiSachs.get(theLoaiSachs.size() - 1).getMaLoai(), 1);
					else if (radNXBorNSX.isSelected())
						ma = tangMa(nhaXuatBans.get(nhaXuatBans.size() - 1).getMaNXB(), 3);
					else if (radTacGiaorChatLieu.isSelected())
						ma = tangMa(tacGias.get(tacGias.size() - 1).getMaTacGia(), 2);
				} else {
					if (radTheLoai.isSelected())
						ma = tangMa(theLoaiVanPhongPhams.get(theLoaiVanPhongPhams.size() - 1).getMaLoai(), 2);
					else if (radNXBorNSX.isSelected())
						ma = tangMa(nhaSanXuats.get(nhaSanXuats.size() - 1).getMaNhaSX(), 3);
//					else if (radTacGiaorChatLieu.isSelected())
//						ma = tangMa(chat.get(chatLieus.size() - 1).getMaChatLieu(), 2);
					else if (radMauSac.isSelected())
						ma = tangMa(mauSacs.get(mauSacs.size() - 1).getMaMau(), 2);
				}
				if (radNhaCungCap.isSelected()) {
					ma = tangMa(nhaCungCaps.get(nhaCungCaps.size() - 1).getMaNhaCungCap(), 3);
					txtEmail.setEditable(true);
					txtSdt.setEditable(true);
				}
				setTxt(ma, "");
				setEditTxt(true);
				txtMa.setEditable(false);
				btnThem.setText("Xác nhận");
				btnHuy.setText("Hủy");

			}else {
				if (JOptionPane.showConfirmDialog(null, "Đồng ý thêm !!", "Xác nhận", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
					if (loaiSanPham.equals("Sách")) {
						if (radTheLoai.isSelected()) {
							try {
								if (!checkDuLieuRong(txtTen, "Tên thể loại sản phẩm không được để trống")) {
									return;
								}
								theLoaiServiceImpl.themTheLoaiSach(
										new TheLoaiSach(txtMa.getText().trim(), txtTen.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else if (radNhaCungCap.isSelected())
							try {
								if (!checkDuLieuRong(txtTen, "Tên thể loại sản phẩm không được để trống")) {
									return;
								}
								if (!txtSdt.getText().trim().matches("(09|07|08|01)[0-9]{8}")) {
									JOptionPane.showMessageDialog(null,
											"Số điện thoại bắt đầu bằng những đầu số: 09, 07, 08, 01\nSố điện thoại phải gồm 10 số",
											"Báo lỗi", JOptionPane.ERROR_MESSAGE);
									txtSdt.requestFocus();
									txtSdt.selectAll();
									return;
								}
								if (!txtEmail.getText().trim().matches(".*@.*$")) {
									JOptionPane.showMessageDialog(null, "Email phải có dạng ncc@gmail.com", "Báo lỗi",
											JOptionPane.ERROR_MESSAGE);
									return;
								}
								nhaCungCapServiceImpl.themNhaCungCap(new NhaCungCap(txtMa.getText().trim(),
										txtTen.getText().trim(), txtEmail.getText().trim(), txtSdt.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						else if (radNXBorNSX.isSelected())
							try {
								if (!checkDuLieuRong(txtTen, "Tên nhà xuất bản không được để trống")) {
									return;
								}
								nhaXuatBanServiceImpl.themNhaXuatBan(
										new NhaXuatBan(txtMa.getText().trim(), txtTen.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						else if (radTacGiaorChatLieu.isSelected())
							try {
								if (!checkDuLieuRong(txtTen, "Tên tác giả không được để trống")) {
									return;
								}
								tacGiaServiceImpl
										.themTacGia(new TacGia(txtMa.getText().trim(), txtTen.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						try {
							loadThuocTinhSach();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						if (radTheLoai.isSelected())
							try {
								if (!checkDuLieuRong(txtTen, "Tên thể loại sản phẩm không được để trống")) {
									return;
								}
								theLoaiServiceImpl.themTheLoaiVanPhongPham(
										new TheLoaiVanPhongPham(txtMa.getText().trim(), txtTen.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						else if (radNhaCungCap.isSelected())
							try {
								if (!checkDuLieuRong(txtTen, "Tên nhà cung cấp không được để trống")) {
									return;
								}
								if (!txtSdt.getText().trim().matches("(09|07|08|01)[0-9]{8}")) {
									JOptionPane.showMessageDialog(null,
											"Số điện thoại bắt đầu bằng những đầu số: 09, 07, 08, 01\nSố điện thoại phải gồm 10 số",
											"Báo lỗi", JOptionPane.ERROR_MESSAGE);
									txtSdt.requestFocus();
									txtSdt.selectAll();
									return;
								}
								if (!txtEmail.getText().trim().matches(".*@.*$")) {
									JOptionPane.showMessageDialog(null, "Email phải có dạng ncc@gmail.com", "Báo lỗi",
											JOptionPane.ERROR_MESSAGE);
									return;
								}
								if (txtDiaChi.getText().trim().equals("")) {
									JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống", "Báo lỗi",
											JOptionPane.ERROR_MESSAGE);
									return;
								}
								nhaCungCapServiceImpl.themNhaCungCap(new NhaCungCap(txtMa.getText().trim(),
										txtTen.getText().trim(), txtEmail.getText().trim(), txtSdt.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						else if (radNXBorNSX.isSelected())
							try {
								if (!checkDuLieuRong(txtTen, "Tên nhà sản xuất không được để trống")) {
									return;
								}
								nhaSanXuatServiceImpl.themNhaSanXuat(new NhaSanXuat(txtMa.getText().trim(), txtTen.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						else if (radTacGiaorChatLieu.isSelected())
							try {
								if (!checkDuLieuRong(txtTen, "Tên chất liệu không được để trống")) {
									return;
								}
//								chatLieuServiceImpl
//										.themChatLieu(new ChatLieu(txtMa.getText().trim(), txtTen.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						else if (radMauSac.isSelected())
							try {
								if (!checkDuLieuRong(txtTen, "Tên màu sản phẩm không được để trống")) {
									return;
								}
								mauSacServiceImpl
										.themMauSac(new MauSac(txtMa.getText().trim(), txtTen.getText().trim()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						try {
							
							loadThuocTinhVPP();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					tableThuocTinh.addMouseListener(this);
					loadDuLieu();
					setRadEnable(true);
					setEditTxt(false);
					txtEmail.setEditable(false);
					txtSdt.setEditable(false);
					txtEmail.setText("");
					txtSdt.setText("");
					btnThem.setText("Thêm");
					btnHuy.setText("Thoát");
					setTxt("", "");
				}
			}
		}
		if (o.equals(btnHuy)) {
			if (btnHuy.getText().equals("Hủy")) {
				tableThuocTinh.addMouseListener(this);
				setRadEnable(true);
				setEditTxt(false);
				setTxt("", "");
				btnHuy.setText("Thoát");
				btnThem.setText("Thêm");
			} else {
				if (JOptionPane.showConfirmDialog(null, "Có chắc bạn muốn thoát", "Cảnh báo", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION)
					this.setVisible(false);
			}
		}
	}
	
	public void loadThuocTinhSach() throws Exception {
		lblTitle.setText("QUẢN LÝ THUỘC TÍNH SÁCH");
		theLoaiSachs = new ArrayList<>();
		theLoaiSachs = theLoaiServiceImpl.getListTheLoaiSach();
		nhaXuatBans = new ArrayList<>();
		nhaXuatBans = nhaXuatBanServiceImpl.getListNhaXuatBan();
		tacGias = new ArrayList<>();
		tacGias = tacGiaServiceImpl.getListTacGia();
		nhaCungCaps = new ArrayList<>();
		nhaCungCaps = nhaCungCapServiceImpl.getAllListNhaCungCap();
		radMauSac.setVisible(false);
		radNXBorNSX.setText("Nhà xuất bản");
		radTacGiaorChatLieu.setText("Tác giả");
		radTheLoai.setText("Thể loại sách");
	}
	
	public void loadThuocTinhVPP() throws Exception {
		lblTitle.setText("QUẢN LÝ THUỘC TÍNH VĂN PHÒNG PHẨM");
		theLoaiVanPhongPhams = new ArrayList<>();
		theLoaiVanPhongPhams = theLoaiServiceImpl.getListTheLoaiVanPhongPham();
		nhaSanXuats = new ArrayList<>();
		nhaSanXuats = nhaSanXuatServiceImpl.getListNhaSanXuat();
		nhaCungCaps = new ArrayList<>();
		nhaCungCaps = nhaCungCapServiceImpl.getAllListNhaCungCap();
		mauSacs = new ArrayList<>();
		mauSacs = mauSacServiceImpl.getListMauSac();
		radMauSac.setVisible(true);
		radNXBorNSX.setText("Xuất xứ");
		radTacGiaorChatLieu.setVisible(false);
		radTheLoai.setText("Thể loại văn phòng phẩm");
	}
	
	public void setTxt(String ma, String ten) {
		txtMa.setText(ma);
		txtTen.setText(ten);
	}

	public void setlbl(String ma, String ten) {
		lblMa.setText(ma);
		lblTen.setText(ten);
	}

	public void setEditTxt(boolean edit) {
		txtMa.setEditable(edit);
		txtTen.setEditable(edit);
	}
	
	public String tangMa(String maHT, int indexLastAlphabet) {
		String s = maHT;
		int n = Integer.parseInt(s.substring(indexLastAlphabet).trim());
		if ((n + 1) % 10 == 0) {
			s = s.replaceAll("0" + n + "", n + 1 + "");
		} else
			s = s.replaceAll(n + "", n + 1 + "");
		return s;
	}
	public String tangMa() throws SQLException {
		String s = sanPhamServiceImpl.getMaSPMax();
		String so = s.substring(2).replaceAll("\\s+", "");
		int n = Integer.parseInt(so);
		if ((n + 1) % 10 == 0) {
			s = s.replaceAll("0" + n + "", n + 1 + "");
		} else
			s = s.replaceAll(n + "", n + 1 + "");
		return s;
	}
	public void setRadEnable(boolean enable) {
		radMauSac.setEnabled(enable);
		radNhaCungCap.setEnabled(enable);
		radNXBorNSX.setEnabled(enable);
		radTacGiaorChatLieu.setEnabled(enable);
		radTheLoai.setEnabled(enable);
		if (enable == true) {
			addMouseRad();
		} else {
			removeMouseRad();
		}
	}
	
	public void removeMouseRad() {
		radMauSac.removeMouseListener(this);
		radNhaCungCap.removeMouseListener(this);
		radNXBorNSX.removeMouseListener(this);
		radTacGiaorChatLieu.removeMouseListener(this);
		radTheLoai.removeMouseListener(this);

	}

	public void addMouseRad() {
		radNXBorNSX.addMouseListener(this);
		radTheLoai.addMouseListener(this);
		radMauSac.addMouseListener(this);
		radNhaCungCap.addMouseListener(this);
		radTacGiaorChatLieu.addMouseListener(this);
	}
	
	public void loadDuLieu() {
		if (radTheLoai.isSelected()) {
			setlbl("Mã thể loại:", "Tên thể loại:");
			if (loaiSanPham.equals("Sách")) {
				modelThuocTinh.setRowCount(0);
				for (TheLoaiSach loaiSach : theLoaiSachs) {
					Object[] o1 = { loaiSach.getMaLoai(), loaiSach.getTenLoai() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			} else {
				modelThuocTinh.setRowCount(0);
				for (TheLoaiVanPhongPham loaiVanPhongPham : theLoaiVanPhongPhams) {
					Object[] o1 = { loaiVanPhongPham.getMaLoai(), loaiVanPhongPham.getTenLoai() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			}

		}
		if (radNXBorNSX.isSelected()) {
			if (loaiSanPham.equals("Sách")) {
				setlbl("Mã nhà xuất bản:", "Tên nhà xuất bản:");
				modelThuocTinh.setRowCount(0);
				for (NhaXuatBan nhaXuatBan : nhaXuatBans) {
					Object[] o1 = { nhaXuatBan.getMaNXB(), nhaXuatBan.getTenNXB() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			} else {
				setlbl("Mã nhà sản xuất:", "Tên nhà sản xuất:");
				modelThuocTinh.setRowCount(0);
				for (NhaSanXuat nhaSanXuat : nhaSanXuats) {
					Object[] o1 = { nhaSanXuat.getMaNhaSX(), nhaSanXuat.getTenNhaSX() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			}

		}
		if (radMauSac.isSelected()) {
			setlbl("Mã màu:", "Tên màu:");
			modelThuocTinh.setRowCount(0);
			for (MauSac mauSac : mauSacs) {
				Object[] o1 = { mauSac.getMaMau(), mauSac.getTenMau() };
				modelThuocTinh.addRow(o1);
			}
			setTxt("", "");
		}
		if (radTacGiaorChatLieu.isSelected()) {
			if (loaiSanPham.equals("Sách")) {
				setlbl("Mã tác giả:", "Tên tác giả:");
				modelThuocTinh.setRowCount(0);
				for (TacGia tacGia : tacGias) {
					Object[] o1 = { tacGia.getMaTacGia(), tacGia.getTenTacGia() };
					modelThuocTinh.addRow(o1);
				}
				setTxt("", "");
			} else {
				setlbl("Mã chất liệu: ", "Tên chất liệu:");
				modelThuocTinh.setRowCount(0);
//				for (ChatLieu chatLieu : chatLieus) {
//					Object[] o1 = { chatLieu.getMaChatLieu(), chatLieu.getTenChatLieu() };
//					modelThuocTinh.addRow(o1);
//				}
				setTxt("", "");
			}

		}
		if (radNhaCungCap.isSelected()) {
			setlbl("Mã nhà cung cấp:", "Tên nhà cung cấp:");
			modelThuocTinh.setRowCount(0);
			for (NhaCungCap nhaCungCap : nhaCungCaps) {
				Object[] o1 = { nhaCungCap.getMaNhaCungCap(), nhaCungCap.getTenNhaCungCap() };
				modelThuocTinh.addRow(o1);
			}
			setTxt("", "");
		}
	}

	public boolean checkDuLieuRong(JTextField j, String noiDungThongBao) {
		if (j.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, noiDungThongBao, "Báo lỗi", JOptionPane.ERROR_MESSAGE);
			j.requestFocus();
			return false;
		}
		return true;
	}
}
