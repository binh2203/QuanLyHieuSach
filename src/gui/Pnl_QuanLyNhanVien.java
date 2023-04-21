
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import entity.NhanVien;
import service_impl.NhanVienServiceImpl;

public class Pnl_QuanLyNhanVien extends javax.swing.JPanel implements ActionListener, MouseListener{
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.ButtonGroup btnGroupGioiTinh;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNhapFile;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatFile;
    private com.toedter.calendar.JDateChooser dcNgaySinh;
    private javaswingdev.FontAwesomeIcon icoCapNhat;
    private javaswingdev.FontAwesomeIcon icoLamMoi;
    private javaswingdev.FontAwesomeIcon icoThem;
    private javaswingdev.FontAwesomeIcon icoXoa;
    private javaswingdev.FontAwesomeIcon icoXuatFile;
    private javaswingdev.FontAwesomeIcon iconNhapFile;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenManHinh;
    private javax.swing.JPanel pnlBangDuLieuVaChucNang;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlThongTinNhanVien;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JScrollPane sc_tbl_QLNV;
    private javax.swing.JTable tblQuanLyNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSoDienThoai;
    private NhanVienServiceImpl iNhanvien;
    private List<NhanVien> dsNhanVien;
    private DefaultTableModel tableModel_NhanVien;


    public Pnl_QuanLyNhanVien() {
        initComponents();
        btnLamMoi.setIcon(icoLamMoi.toIcon());
        btnThem.setIcon(icoThem.toIcon());
        btnXoa.setIcon(icoXoa.toIcon());
        btnCapNhat.setIcon(icoCapNhat.toIcon());
        btnNhapFile.setIcon(iconNhapFile.toIcon());
        btnXuatFile.setIcon(icoXuatFile.toIcon());


		btnThem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		tblQuanLyNhanVien.addMouseListener(this);
	
    }
        
    private void initComponents() {

        icoLamMoi = new javaswingdev.FontAwesomeIcon();
        icoThem = new javaswingdev.FontAwesomeIcon();
        icoXoa = new javaswingdev.FontAwesomeIcon();
        icoCapNhat = new javaswingdev.FontAwesomeIcon();
        iconNhapFile = new javaswingdev.FontAwesomeIcon();
        icoXuatFile = new javaswingdev.FontAwesomeIcon();
        btnGroupGioiTinh = new javax.swing.ButtonGroup();
        pnlHeader = new javax.swing.JPanel();
        lblTenManHinh = new javax.swing.JLabel();
        pnlBangDuLieuVaChucNang = new javax.swing.JPanel();
        sc_tbl_QLNV = new javax.swing.JScrollPane();
        tblQuanLyNhanVien = new javax.swing.JTable();
        pnlChucNang = new javax.swing.JPanel();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnNhapFile = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        pnlThongTinNhanVien = new javax.swing.JPanel();
        lblMaNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtHoVaTen = new javax.swing.JTextField();
        lblHoVaTen = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        dcNgaySinh = new com.toedter.calendar.JDateChooser();
        lblNgaySinh = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        
        txtMaNhanVien.setEditable(false);

        icoLamMoi.setIcon(javaswingdev.FontAwesome.REFRESH);
        icoLamMoi.setSize(18);

        icoThem.setColor1(new java.awt.Color(102, 204, 0));
        icoThem.setColor2(new java.awt.Color(102, 204, 0));
        icoThem.setIcon(javaswingdev.FontAwesome.PLUS);
        icoThem.setSize(18);

        icoXoa.setColor1(java.awt.Color.red);
        icoXoa.setColor2(java.awt.Color.red);
        icoXoa.setIcon(javaswingdev.FontAwesome.TIMES);
        icoXoa.setSize(18);

        icoCapNhat.setIcon(javaswingdev.FontAwesome.WRENCH);
        icoCapNhat.setSize(18);

        iconNhapFile.setIcon(javaswingdev.FontAwesome.DOWNLOAD);
        iconNhapFile.setSize(18);

        icoXuatFile.setIcon(javaswingdev.FontAwesome.UPLOAD);
        icoXuatFile.setSize(18);

        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(java.awt.Color.lightGray);

        lblTenManHinh.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblTenManHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenManHinh.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenManHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 1543, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lblTenManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlBangDuLieuVaChucNang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        String header_NhanVien[] = { "STT", "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Email" };
		tableModel_NhanVien = new DefaultTableModel(header_NhanVien, 0);
        tblQuanLyNhanVien = new JTable(tableModel_NhanVien);
        sc_tbl_QLNV.setViewportView(tblQuanLyNhanVien);
        if (tblQuanLyNhanVien.getColumnModel().getColumnCount() > 0) {
        	tblQuanLyNhanVien.getColumnModel().getColumn(0).setPreferredWidth(10);
    		tblQuanLyNhanVien.getColumnModel().getColumn(1).setPreferredWidth(10);
    		tblQuanLyNhanVien.getColumnModel().getColumn(2).setPreferredWidth(90);
    		tblQuanLyNhanVien.getColumnModel().getColumn(3).setPreferredWidth(20);
    		tblQuanLyNhanVien.getColumnModel().getColumn(4).setPreferredWidth(20);
    		tblQuanLyNhanVien.getColumnModel().getColumn(5).setPreferredWidth(70);
    		tblQuanLyNhanVien.getColumnModel().getColumn(6).setPreferredWidth(70);
    		tblQuanLyNhanVien.getColumnModel().getColumn(7).setPreferredWidth(120);
        }
     
        try {
			DocDuLieuTuArrayListVaoModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        pnlChucNang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThem.setText("Thêm");

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCapNhat.setText("Cập nhật");

        btnNhapFile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNhapFile.setText("Nhập file");

        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXuatFile.setText("Xuất file");
    

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnNhapFile, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnCapNhat)
                    .addComponent(btnNhapFile)
                    .addComponent(btnXuatFile))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBangDuLieuVaChucNangLayout = new javax.swing.GroupLayout(pnlBangDuLieuVaChucNang);
        pnlBangDuLieuVaChucNang.setLayout(pnlBangDuLieuVaChucNangLayout);
        pnlBangDuLieuVaChucNangLayout.setHorizontalGroup(
            pnlBangDuLieuVaChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sc_tbl_QLNV, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
            .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBangDuLieuVaChucNangLayout.setVerticalGroup(
            pnlBangDuLieuVaChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBangDuLieuVaChucNangLayout.createSequentialGroup()
                .addComponent(sc_tbl_QLNV, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlBangDuLieuVaChucNang, java.awt.BorderLayout.LINE_START);

        pnlThongTinNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaNhanVien.setText("Mã nhân viên");

        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtHoVaTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        

        lblHoVaTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHoVaTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoVaTen.setText("Họ và tên");

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGioiTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioiTinh.setText("Giới tính");

        dcNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgaySinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgaySinh.setText("Ngày sinh");

        lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoDienThoai.setText("Số điện thoại");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiaChi.setText("Địa chỉ");

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("Email");

        btnGroupGioiTinh.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNam.setText("Nam");
        rdoNam.setSelected(true);
        rdoNam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        

        btnGroupGioiTinh.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNu.setText("Nữ");
        rdoNu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        

        javax.swing.GroupLayout pnlThongTinNhanVienLayout = new javax.swing.GroupLayout(pnlThongTinNhanVien);
        pnlThongTinNhanVien.setLayout(pnlThongTinNhanVienLayout);
        pnlThongTinNhanVienLayout.setHorizontalGroup(
            pnlThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinNhanVienLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHoVaTen)
                        .addComponent(dcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiaChi)
                        .addComponent(txtSoDienThoai)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinNhanVienLayout.createSequentialGroup()
                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addComponent(lblHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlThongTinNhanVienLayout.setVerticalGroup(
            pnlThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinNhanVienLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblMaNhanVien)
                .addGap(12, 12, 12)
                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblHoVaTen)
                .addGap(12, 12, 12)
                .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblGioiTinh)
                .addGap(20, 20, 20)
                .addGroup(pnlThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(22, 22, 22)
                .addComponent(lblNgaySinh)
                .addGap(12, 12, 12)
                .addComponent(dcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblSoDienThoai)
                .addGap(12, 12, 12)
                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblDiaChi)
                .addGap(12, 12, 12)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblEmail)
                .addGap(12, 12, 12)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        add(pnlThongTinNhanVien, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponent

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
	public void mouseClicked(MouseEvent e) {
		int i = tblQuanLyNhanVien.getSelectedRow();
		setValueForm(i);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Object obj = e.getSource();
			if (obj.equals(btnThem)) {
				if(btnThem.getText().equals("Xác nhận")) {
					btnCapNhat.setEnabled(true);
					btnXoa.setEnabled(true);
					if(KiemTraDauVaoKhiThem() == 0) {
						int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm nhân viên này?", "Thêm nhân viên!", JOptionPane.YES_NO_OPTION);
						if(dialogResult == 0) {
							ThemNhanVienVaoDB();
						}
					}

				}else {
					txtMaNhanVien.setText(tangMaNV());
					btnCapNhat.setEnabled(false);
					btnXoa.setEnabled(false);
					btnThem.setText("Xác nhận");
				}
				
			}else if(obj.equals(btnCapNhat)) {
				if (tblQuanLyNhanVien.getSelectedRow() == -1) 
					JOptionPane.showMessageDialog(this, "Phải chọn dòng trước khi cập nhật!");
				else {
					int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn cập nhật nhân viên này?", "Cập nhật nhân viên!", JOptionPane.YES_NO_OPTION);
					if(dialogResult == 0) {
					CapNhatNhanVienVaoDB();
					}
				}								
			}else if(obj.equals(btnXoa)) {
				if (tblQuanLyNhanVien.getSelectedRow() == -1) 
					JOptionPane.showMessageDialog(this, "Phải chọn dòng trước khi xóa");
				else {
					int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?", "Xóa nhân viên!", JOptionPane.YES_NO_OPTION);
					if(dialogResult == 0) {
					  xoaNhanVien();
					}
				}
			}else if(obj.equals(btnLamMoi)) {
			 	clear_formThongTinNhanVien();
	        	xoaHetDuLieu();
	        	DocDuLieuTuArrayListVaoModel();
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
	}
    // End of variables declaration//GEN-END:variables
    public void DocDuLieuTuArrayListVaoModel() throws Exception {
		iNhanvien = new NhanVienServiceImpl();
		dsNhanVien = iNhanvien.getDSNhanVien();
		int i = 1;
		for (NhanVien nv : dsNhanVien) {
			  Object[] ob = { i++, nv.getMaNV(), nv.getHoTenNV(), nv.isGioiTinh() != true ? "Nam" : "Nữ", 
					nv.getNgaySinhNV(), nv.getSoDienThoaiNV(), nv.getDiaChiNV(), nv.getEmailNV() };
			tableModel_NhanVien.addRow(ob);
			//System.out.println(nv.isGioiTinh());
		}
	}
    public int KiemTraDauVaoKhiThem() {
		String tenNV = txtHoVaTen.getText();
		if(tenNV.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên!");
			txtHoVaTen.requestFocus();
			return 1;
		}
		if(dcNgaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày sinh nhân viên!");
			dcNgaySinh.requestFocus();
			return 1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String day = sdf.format(dcNgaySinh.getDate());
		String date[] = day.split("-");
		int nam = Integer.parseInt(date[0]);
		LocalDate date2 = LocalDate.now();
		if(date2.getYear() - nam < 19) {
			JOptionPane.showMessageDialog(null, "Tuổi phải trên 19!");
			return 1;
		}
		String sdt = txtSoDienThoai.getText();
		if(sdt.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại nhân viên!");
			txtSoDienThoai.requestFocus();
			return 1;
		}
		String diaChi = txtDiaChi.getText();
		if(diaChi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ nhân viên!");
			txtDiaChi.requestFocus();
			return 1;
		}
		String email = txtEmail.getText();
		if(email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập email nhân viên!");
			txtEmail.requestFocus();
			return 1;
		}
		
		return 0;
    }
	public NhanVien revertNhanVienFromTextfields() {
		String maNV = txtMaNhanVien.getText();
		String tenNV = txtHoVaTen.getText();
		boolean gioiTinh = rdoNu.isSelected();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String day = sdf.format(dcNgaySinh.getDate());
		String date[] = day.split("-");
		int nam = Integer.parseInt(date[0]);
		int thang = Integer.parseInt(date[1]);
		int ngay = Integer.parseInt(date[2]);
		LocalDate lcDate = LocalDate.of(nam, thang, ngay);
		
		String sdt = txtSoDienThoai.getText();
		String diaChi = txtDiaChi.getText();
		
		String email = txtEmail.getText();
		NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, lcDate, sdt, diaChi, email);
		return nv;
	}
	public void editOnRow() {
		int row = tblQuanLyNhanVien.getSelectedRow();
		NhanVien nv = revertNhanVienFromTextfields();

		tblQuanLyNhanVien.setValueAt(nv.getMaNV(), row, 1);
		tblQuanLyNhanVien.setValueAt(nv.getHoTenNV(), row, 2);
		tblQuanLyNhanVien.setValueAt(nv.isGioiTinh() != true ? "Nam" : "Nữ", row, 3);
		tblQuanLyNhanVien.setValueAt(nv.getNgaySinhNV(), row, 4);
		tblQuanLyNhanVien.setValueAt(nv.getSoDienThoaiNV(), row, 5);
		tblQuanLyNhanVien.setValueAt(nv.getDiaChiNV(), row, 6);
		tblQuanLyNhanVien.setValueAt(nv.getEmailNV(), row, 7);
		System.out.println(row);

	}
	public void ThemNhanVienVaoDB() throws Exception {
		NhanVien nv = revertNhanVienFromTextfields();
		if(nv ==null) {
			return;
		}
			
		try {
			if(iNhanvien.themNhanVien(nv) == 0) {
				JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");
			}
			else {
				JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
				xoaHetDuLieu();
	        	clear_formThongTinNhanVien();
	        	DocDuLieuTuArrayListVaoModel();
	        	btnThem.setText("Thêm");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public void xoaNhanVien() {
		int i = tblQuanLyNhanVien.getSelectedRow();
		String maNV = (String) tblQuanLyNhanVien.getValueAt(i, 1);
		try {
			
			if(iNhanvien.xoaNhanVien(maNV)==0) {
				JOptionPane.showMessageDialog(null, "Xóa thất bại!");
			}else {
				JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công!");
				tableModel_NhanVien.removeRow(i);
				clear_formThongTinNhanVien();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clear_formThongTinNhanVien() {
		txtMaNhanVien.setText("");
		txtHoVaTen.setText("");
		rdoNam.setSelected(false);
		rdoNu.setSelected(false);
		dcNgaySinh.setDate(null);
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
	}
	public void xoaHetDuLieu() {
		DefaultTableModel dtm = (DefaultTableModel) tblQuanLyNhanVien.getModel();
		dtm.getDataVector().removeAllElements();
	}
	public String tangMaNV() {
		int i = tableModel_NhanVien.getRowCount();
		System.out.println(i-1);
		String maNV = (String) tblQuanLyNhanVien.getValueAt(i-1, 1);
		maNV = maNV.split("NV")[1].trim();
		int num = Integer.parseInt(maNV)+ 1;
		if(num < 10) {
			maNV = "NV00"+num;
		}else {
			maNV = "NV0"+num;
		}
		
		return maNV;
	}
	public void setValueForm(int i) {
		String maNV = tblQuanLyNhanVien.getValueAt(i, 1) + "";
		String tenNV = tblQuanLyNhanVien.getValueAt(i, 2) + "";
		String gioiTinh = tblQuanLyNhanVien.getValueAt(i, 3) + "";
		
		txtMaNhanVien.setText(maNV);
		txtHoVaTen.setText(tenNV);
		if (gioiTinh.equals("Nam")) {
			rdoNam.isSelected();
		}
		else rdoNu.isSelected();
		java.util.Date ngaySinh;
		try {
			ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(tblQuanLyNhanVien.getValueAt(i, 4)+"");
			dcNgaySinh.setDate(ngaySinh);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtSoDienThoai.setText(tblQuanLyNhanVien.getValueAt(i, 5)+"");
		txtDiaChi.setText(tblQuanLyNhanVien.getValueAt(i, 6)+"");
		txtEmail.setText(tblQuanLyNhanVien.getValueAt(i, 7)+ "");
	}
	public void CapNhatNhanVienVaoDB() throws Exception {
		NhanVien nv = revertNhanVienFromTextfields();
		if(nv ==null)
			return;
		try {
			if(iNhanvien.capNhatNhanVien(nv) == 0) {
				JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");
			}
			else {
				xoaHetDuLieu();
	        	clear_formThongTinNhanVien();
	        	DocDuLieuTuArrayListVaoModel();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
	}
}
