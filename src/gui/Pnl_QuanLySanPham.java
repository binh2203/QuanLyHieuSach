package gui;

import javax.swing.JFrame;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.NhanVien;
import entity.Sach;
import entity.SanPham;
import service.SanPhamService;
import service_impl.SanPhamServiceImpl;

public class Pnl_QuanLySanPham extends javax.swing.JPanel {
	private javax.swing.JButton btnCapNhat;
    private javax.swing.ButtonGroup btnGroupLoaiSP;
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
    private javax.swing.JLabel lblTenSanPham;
    private javax.swing.JLabel lblMaSanPham;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenManHinh;
    private javax.swing.JPanel pnlBangDuLieuVaChucNang;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlThongTinSanPham;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JScrollPane sc_tbl_QLSP;
    private javax.swing.JTable tblQuanLySanPham;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtSoDienThoai;
    private DefaultTableModel tableModel_SanPham;
	private List<Sach> listSanPham;
	public Pnl_QuanLySanPham() {
        initComponents();
        btnLamMoi.setIcon(icoLamMoi.toIcon());
        btnThem.setIcon(icoThem.toIcon());
        btnXoa.setIcon(icoXoa.toIcon());
        btnCapNhat.setIcon(icoCapNhat.toIcon());
        btnNhapFile.setIcon(iconNhapFile.toIcon());
        btnXuatFile.setIcon(icoXuatFile.toIcon());

    }
    private void initComponents() {

        icoLamMoi = new javaswingdev.FontAwesomeIcon();
        icoThem = new javaswingdev.FontAwesomeIcon();
        icoXoa = new javaswingdev.FontAwesomeIcon();
        icoCapNhat = new javaswingdev.FontAwesomeIcon();
        iconNhapFile = new javaswingdev.FontAwesomeIcon();
        icoXuatFile = new javaswingdev.FontAwesomeIcon();
        btnGroupLoaiSP = new javax.swing.ButtonGroup();
        pnlHeader = new javax.swing.JPanel();
        lblTenManHinh = new javax.swing.JLabel();
        pnlBangDuLieuVaChucNang = new javax.swing.JPanel();
        sc_tbl_QLSP = new javax.swing.JScrollPane();
        tblQuanLySanPham = new javax.swing.JTable();
        pnlChucNang = new javax.swing.JPanel();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnNhapFile = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        pnlThongTinSanPham = new javax.swing.JPanel();
        lblMaSanPham = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        lblTenSanPham = new javax.swing.JLabel();
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
        lblTenManHinh.setText("QUẢN LÝ SẢN PHẨM");

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

        
        ///
        
        String header_SanPham[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng","Đơn vị", "Giá nhập", "Giá bán", "Nhà cung cấp" ,
				"Tác giả", "Nhà xuất bản"};
        tableModel_SanPham = new DefaultTableModel(header_SanPham, 0);
		tblQuanLySanPham = new JTable(tableModel_SanPham);

		tblQuanLySanPham.getColumnModel().getColumn(0);
		tblQuanLySanPham.getColumnModel().getColumn(1);
		tblQuanLySanPham.getColumnModel().getColumn(2);
		tblQuanLySanPham.getColumnModel().getColumn(3);
		tblQuanLySanPham.getColumnModel().getColumn(4);
		tblQuanLySanPham.getColumnModel().getColumn(5);
		tblQuanLySanPham.getColumnModel().getColumn(6);
		tblQuanLySanPham.getColumnModel().getColumn(7);
//		tblQuanLyNhanVien.getColumnModel().getColumn(8);
//		tblQuanLyNhanVien.getColumnModel().getColumn(9);
//		tblQuanLyNhanVien.getColumnModel().getColumn(10);
		try {
			//DocDuLieuTuArrayListVaoModel();
			loadSanPham();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ////
        sc_tbl_QLSP.setViewportView(tblQuanLySanPham);

        pnlChucNang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnLamMoiActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCapNhat.setText("Cập nhật");

        btnNhapFile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNhapFile.setText("Nhập file");

        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnXuatFileActionPerformed(evt);
            }
        });

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
            .addComponent(sc_tbl_QLSP, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
            .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBangDuLieuVaChucNangLayout.setVerticalGroup(
            pnlBangDuLieuVaChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBangDuLieuVaChucNangLayout.createSequentialGroup()
                .addComponent(sc_tbl_QLSP, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlBangDuLieuVaChucNang, java.awt.BorderLayout.LINE_START);

        pnlThongTinSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMaSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaSanPham.setText("Mã sản phẩm");

        txtMaSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //txtMaSanPhamActionPerformed(evt);
            }
        });

        txtTenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //txtTenSanPhamActionPerformed(evt);
            }
        });

        lblTenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenSanPham.setText("Tên sản phẩm");

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGioiTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioiTinh.setText("Loại Sản Phẩm");

        dcNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgaySinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgaySinh.setText("Ngày nhập hàng");

        lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoDienThoai.setText("Số lượng");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiaChi.setText("Nhà Cung Cấp");

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //txtDiaChiActionPerformed(evt);
            }
        });

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //txtSoDienThoaiActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //txtEmailActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("Nhà Xuất Bản");

        btnGroupLoaiSP.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNam.setText("Sách");
        rdoNam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //rdoNamActionPerformed(evt);
            }
        });

        btnGroupLoaiSP.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNu.setText("VPP");
        rdoNu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //rdoNuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinSanPhamLayout = new javax.swing.GroupLayout(pnlThongTinSanPham);
        pnlThongTinSanPham.setLayout(pnlThongTinSanPhamLayout);
        pnlThongTinSanPhamLayout.setHorizontalGroup(
            pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinSanPhamLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTenSanPham)
                        .addComponent(dcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiaChi)
                        .addComponent(txtSoDienThoai)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinSanPhamLayout.createSequentialGroup()
                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addComponent(lblTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlThongTinSanPhamLayout.setVerticalGroup(
            pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinSanPhamLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblMaSanPham)
                .addGap(12, 12, 12)
                .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblTenSanPham)
                .addGap(12, 12, 12)
                .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblGioiTinh)
                .addGap(20, 20, 20)
                .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        add(pnlThongTinSanPham, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    public void loadSanPham() throws Exception {
    	SanPhamServiceImpl sanPhamService = new SanPhamServiceImpl();
    	listSanPham = sanPhamService.getAllSach();
    	String header_SanPham[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng","Đơn vị", "Giá nhập", "Giá bán", "Nhà cung cấp" ,
				"Tác giả", "Nhà xuất bản"};
    	int i = 0;//Sach(maSanPham, ncc, loaiSP, soLuongTon, donVi, giaNhap,giaBan,tenSach,tacGia,nhaXuatBan,theLoai )
    	for (Sach sp : listSanPham) {
    		Object ob[] = { i++ +"", sp.getMaSanPham(), sp.getTenSach(), sp.getSoLuongTon()+"",sp.getDonVi(), sp.getGiaBan()+"", sp.getGiaNhap()+"", sp.getNhaCungCap().getTenNhaCungCap() ,
    				sp.getTacGia().getTenTacGia(), sp.getNhaXuatBan().getTenNXB()};
    		tableModel_SanPham.addRow(ob);
		}
    }

}
