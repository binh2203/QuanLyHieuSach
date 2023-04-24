
package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatHang;
import entity.Sach;
import entity.SanPham;
import service_impl.KhachHangServiceImpl;
import service_impl.NhanVienServiceImpl;
import service_impl.PhieuDatHangServiceImpl;
import service_impl.SanPhamServiceImpl;

public class Pnl_PhieuDatHang extends javax.swing.JPanel implements ActionListener, MouseListener{
	 @SuppressWarnings("unchecked")
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnInPD;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLapPhieuDat;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton btnTru1;
    private javax.swing.JComboBox<String> cbb_loaiSP;
    private com.toedter.calendar.JDateChooser dcNgayLayHang;
    private javaswingdev.FontAwesomeIcon icoCong;
    private javaswingdev.FontAwesomeIcon icoLamMoi;
    private javaswingdev.FontAwesomeIcon icoLoc;
    private javaswingdev.FontAwesomeIcon icoThem;
    private javaswingdev.FontAwesomeIcon icoTru;
    private javaswingdev.FontAwesomeIcon iconIn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_DSSPDatHang;
    private javax.swing.JTable tbl_DanhSachSanPham;
    private javax.swing.JLabel lblDonVi;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblLapPhieuDatHang;
    private javax.swing.JLabel lblMaPDH;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblNgayLapPhieu;
    private javax.swing.JLabel lblNgayLayHang;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblSoLuong1;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JLabel lblTenSP1;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JPanel pnlButton1;
    private javax.swing.JPanel pnlHeader1;
    private javax.swing.JPanel pnlThongTinSanPham;
    private javax.swing.JPanel pnl_left;
    private javax.swing.JTextField txtDonVi;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaPDH;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayLapPhieu;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuong1;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtThanhTien;
    private SanPhamServiceImpl iSanPham;
    private List<Sach> dsSach;
    private DefaultTableModel tableModel_PDH;
    private DefaultTableModel tableModel_PDH1;
    private PhieuDatHangServiceImpl iPhieuDatHang;
    private List<PhieuDatHang> dsPhieuDatHang;
    private KhachHangServiceImpl iKhachHang;
    private NhanVienServiceImpl iNhanVien;
    private int iPDH;
    private int iSP;
    // End of variables declaration//GEN-END:variables
	
    public Pnl_PhieuDatHang() {
       initComponents();
       Khoatxt();
       
       txtSoLuong.addActionListener(this);
       btnCong.addActionListener(this);
       btnInPD.addActionListener(this);
       btnLamMoi.addActionListener(this);
       btnLapPhieuDat.addActionListener(this);
       btnLoc.addActionListener(this);
       btnThem.addActionListener(this);
       btnTru.addActionListener(this);       
       btnTru1.addActionListener(this);
       btnXoa.addActionListener(this);
       btnTim.addActionListener(this);
       tbl_DanhSachSanPham.addMouseListener(this);
       tbl_DSSPDatHang.addMouseListener(this);
    }	
   
    private void initComponents() {

        icoLamMoi = new javaswingdev.FontAwesomeIcon();
        icoThem = new javaswingdev.FontAwesomeIcon();
        iconIn = new javaswingdev.FontAwesomeIcon();
        icoLoc = new javaswingdev.FontAwesomeIcon();
        icoTru = new javaswingdev.FontAwesomeIcon();
        icoCong = new javaswingdev.FontAwesomeIcon();
        pnlHeader1 = new javax.swing.JPanel();
        lblLapPhieuDatHang = new javax.swing.JLabel();
        pnl_left = new javax.swing.JPanel();
        pnlThongTinSanPham = new javax.swing.JPanel();
        lblMaSP = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        lblTenSP = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        lblSoLuong = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnCong = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        lblDonVi = new javax.swing.JLabel();
        txtDonVi = new javax.swing.JTextField();
        lblTenSP1 = new javax.swing.JLabel();
        cbb_loaiSP = new javax.swing.JComboBox<>();
        lblGiaBan = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        pnlButton1 = new javax.swing.JPanel();
        btnLoc = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_DanhSachSanPham = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        lblNgayLapPhieu = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        lblTenKH = new javax.swing.JLabel();
        lblMaPDH = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblNgayLayHang = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        dcNgayLayHang = new com.toedter.calendar.JDateChooser();
        txtTenKH = new javax.swing.JTextField();
        txtNgayLapPhieu = new javax.swing.JTextField();
        txtMaPDH = new javax.swing.JTextField();
        lblSoLuong1 = new javax.swing.JLabel();
        txtSoLuong1 = new javax.swing.JTextField();
        btnTru1 = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DSSPDatHang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblThanhTien = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        btnLapPhieuDat = new javax.swing.JButton();
        btnInPD = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        icoLamMoi.setIcon(javaswingdev.FontAwesome.REFRESH);
        icoLamMoi.setSize(18);

        icoThem.setColor1(new java.awt.Color(102, 204, 0));
        icoThem.setColor2(new java.awt.Color(102, 204, 0));
        icoThem.setIcon(javaswingdev.FontAwesome.PLUS);
        icoThem.setSize(18);

        iconIn.setColor1(java.awt.Color.blue);
        iconIn.setColor2(java.awt.Color.blue);
        iconIn.setIcon(javaswingdev.FontAwesome.PRINT);
        iconIn.setSize(18);

        icoLoc.setColor1(java.awt.Color.black);
        icoLoc.setColor2(java.awt.Color.black);
        icoLoc.setIcon(javaswingdev.FontAwesome.FILTER);
        icoLoc.setSize(18);

        icoTru.setColor1(java.awt.Color.red);
        icoTru.setColor2(java.awt.Color.red);
        icoTru.setIcon(javaswingdev.FontAwesome.MINUS);

        icoCong.setColor1(new java.awt.Color(153, 204, 0));
        icoCong.setColor2(new java.awt.Color(153, 153, 0));
        icoCong.setIcon(javaswingdev.FontAwesome.PLUS_SQUARE);
        icoCong.setSize(30);

        setLayout(new java.awt.BorderLayout());

        pnlHeader1.setBackground(java.awt.Color.lightGray);

        lblLapPhieuDatHang.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblLapPhieuDatHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLapPhieuDatHang.setText("LẬP PHIẾU ĐẶT HÀNG");

        javax.swing.GroupLayout pnlHeader1Layout = new javax.swing.GroupLayout(pnlHeader1);
        pnlHeader1.setLayout(pnlHeader1Layout);
        pnlHeader1Layout.setHorizontalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLapPhieuDatHang, javax.swing.GroupLayout.DEFAULT_SIZE, 1550, Short.MAX_VALUE)
        );
        pnlHeader1Layout.setVerticalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeader1Layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lblLapPhieuDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(pnlHeader1, java.awt.BorderLayout.PAGE_START);

        pnlThongTinSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMaSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaSP.setText("Mã SP:");

        txtMaSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblTenSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenSP.setText("Tên SP:");

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoLuong.setText("Số lượng:");

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N




        lblDonVi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDonVi.setText("Đơn vị:");

        txtDonVi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        lblTenSP1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenSP1.setText("Loại SP:");

        cbb_loaiSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbb_loaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Văn phòng phẩm" }));

        lblGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGiaBan.setText("Giá bán:");

        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlThongTinSanPhamLayout = new javax.swing.GroupLayout(pnlThongTinSanPham);
        pnlThongTinSanPham.setLayout(pnlThongTinSanPhamLayout);
        pnlThongTinSanPhamLayout.setHorizontalGroup(
            pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinSanPhamLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMaSP)
                    .addComponent(lblTenSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinSanPhamLayout.createSequentialGroup()
                        .addComponent(cbb_loaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGiaBan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaBan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSoLuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnTru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinSanPhamLayout.createSequentialGroup()
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblTenSP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSP)
                        .addGap(12, 12, 12)
                        .addComponent(lblDonVi)
                        .addGap(18, 18, 18)
                        .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        pnlThongTinSanPhamLayout.setVerticalGroup(
            pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinSanPhamLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSP)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenSP)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDonVi)
                    .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGiaBan)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoLuong)
                        .addComponent(lblTenSP1)
                        .addComponent(cbb_loaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pnlButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnLoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLoc.setText("Lọc");

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThem.setText("Thêm");

        javax.swing.GroupLayout pnlButton1Layout = new javax.swing.GroupLayout(pnlButton1);
        pnlButton1.setLayout(pnlButton1Layout);
        pnlButton1Layout.setHorizontalGroup(
            pnlButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButton1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlButton1Layout.setVerticalGroup(
            pnlButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButton1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        String header_sp[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Thể loại", "Tác giả", "Số lượng tồn"};
		tableModel_PDH = new DefaultTableModel(header_sp, 0);
        tbl_DanhSachSanPham = new JTable(tableModel_PDH);
        jScrollPane3.setViewportView(tbl_DanhSachSanPham);
        if (tbl_DanhSachSanPham.getColumnModel().getColumnCount() > 0) {
        	tbl_DanhSachSanPham.getColumnModel().getColumn(0);
    		tbl_DanhSachSanPham.getColumnModel().getColumn(1);
    		tbl_DanhSachSanPham.getColumnModel().getColumn(2);
    		tbl_DanhSachSanPham.getColumnModel().getColumn(3);
    		tbl_DanhSachSanPham.getColumnModel().getColumn(4);
    		tbl_DanhSachSanPham.getColumnModel().getColumn(5);

        }
     
        try {
			DocDuLieuTuArrayListVaoModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        javax.swing.GroupLayout pnl_leftLayout = new javax.swing.GroupLayout(pnl_left);
        pnl_left.setLayout(pnl_leftLayout);
        pnl_leftLayout.setHorizontalGroup(
            pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlThongTinSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        pnl_leftLayout.setVerticalGroup(
            pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_leftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongTinSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnl_left, java.awt.BorderLayout.LINE_START);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(643, 1080));

        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("PHIẾU ĐẶT HÀNG");

        lblNgayLapPhieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayLapPhieu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayLapPhieu.setText("Ngày lập phiếu:");

        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenKH.setText("Tên khách hàng:");

        lblMaPDH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaPDH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaPDH.setText("Mã PDH:");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N


        lblNgayLayHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayLayHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayLayHang.setText("Ngày lấy hàng:");

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNhanVien.setText("Nhân viên:");

        lblSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSDT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSDT.setText("SDT khách hàng:");

        dcNgayLayHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N


        txtNgayLapPhieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaPDH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblSoLuong1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSoLuong1.setText("Số lượng:");



        txtSoLuong1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
  

        btnTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTim.setText("Tìm");
        
        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblNgayLayHang, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcNgayLayHang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblMaPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10)
                                .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtNhanVien)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSoLuong1)
                            .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnTru1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(lblTieuDe)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaPDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(12, 12, 12)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayLayHang))
                        .addComponent(dcNgayLayHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTru1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSoLuong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

        tbl_DSSPDatHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        String header_pdh[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Giá bán", "Số lượng"};
      		tableModel_PDH1 = new DefaultTableModel(header_pdh, 0);
              tbl_DSSPDatHang = new JTable(tableModel_PDH1);
              jScrollPane2.setViewportView(tbl_DSSPDatHang);
              if (tbl_DSSPDatHang.getColumnModel().getColumnCount() > 0) {
              	tbl_DSSPDatHang.getColumnModel().getColumn(0);
          		tbl_DSSPDatHang.getColumnModel().getColumn(1);
          		tbl_DSSPDatHang.getColumnModel().getColumn(2);
          		tbl_DSSPDatHang.getColumnModel().getColumn(3);
          		tbl_DSSPDatHang.getColumnModel().getColumn(4);
              }
        

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblThanhTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThanhTien.setText("Thành tiền:");

        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnLapPhieuDat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLapPhieuDat.setText("Lập phiếu đặt");


        btnInPD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInPD.setText("In phiếu đặt");


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                        .addComponent(btnLapPhieuDat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInPD, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(167, 167, 167))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThanhTien)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLapPhieuDat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnInPD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 359, Short.MAX_VALUE))
        );

        add(jPanel6, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
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
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(tbl_DanhSachSanPham)) {
			iSP = tbl_DanhSachSanPham.getSelectedRow();
			setValueForm(iSP);
		}
		else if(obj.equals(tbl_DSSPDatHang)) {
			iPDH = tbl_DSSPDatHang.getSelectedRow();
			txtSoLuong1.setText(tbl_DSSPDatHang.getValueAt(iPDH, 4) + "");
			HienThiLaiSP();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int soLuong = SoLuong("");
		try {
			Object obj = e.getSource();
			if (obj.equals(btnCong)) {
				soLuong = SoLuong("+");
				if(KiemTraSoLuong(soLuong)) 
					txtSoLuong.setText(++soLuong + "");
				else 
					return;
					
				
			}	
			else if(obj.equals(btnTru)) {
				soLuong = SoLuong("-");
				if(KiemTraSoLuong(soLuong))
					txtSoLuong.setText(--soLuong + "");
				else
					return;
			}
			else if(obj.equals(btnThem)) {
				ThemSanPhamVaoPDH(soLuong);
				CapNhatSLTon(soLuong);
				CapNhatThanhTien();
			}
			else if(obj.equals(btnTru1)) {
				if(txtSoLuong1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm trước!");
					return;
				}
				int sL = Integer.parseInt(txtSoLuong1.getText());
				if(sL - 1 < 1)
					JOptionPane.showMessageDialog(null, "Số lượng sản phẩm tối thiểu phải là 1, nếu bạn muốn xóa sản phẩm vui lòng chọn 'Xóa'!");
				else {
					txtSoLuong1.setText(--sL + "");
					tbl_DSSPDatHang.setValueAt(Integer.parseInt(txtSoLuong1.getText()), iPDH, 4);
					CapNhatSLTon(-1);
					CapNhatThanhTien();
				}
					
			}
			else if(obj.equals(btnXoa)) {
				if(tbl_DSSPDatHang.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Không có sản phẩm nào có thể xóa, vui lòng thêm sản phẩm!");
					return;
				}
				else if(tbl_DSSPDatHang.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn xóa!");
					return;
				}
				tableModel_PDH1.removeRow(iPDH);
				for(int j = iPDH; j < tbl_DSSPDatHang.getRowCount() ; j++) {
					tbl_DSSPDatHang.setValueAt(j+1, j, 0);
				}
				int sL = Integer.parseInt(txtSoLuong1.getText());
				txtSoLuong1.setText("");
				CapNhatSLTon(-sL);
				CapNhatThanhTien();
			}
			else if(obj.equals(btnTim)) {
				timKH();
			}
			else if(obj.equals(btnLamMoi))
				LamMoi();
			else if(obj.equals(btnLapPhieuDat))
				revertPDH();
			else if(obj.equals(txtSoLuong)) {
				KiemTraSoLuong(soLuong);
			}
		}
		 catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public boolean KiemTraSoLuong(int soLuong) {
		if(soLuong == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm trước!");
			return false;
		}
		else if(soLuong == -2) {
			JOptionPane.showMessageDialog(null, "Số lượng không được để trống!");
			txtSoLuong.setText("1");
			return false; 
		}
			
		else if (soLuong == -3) {
			JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0 và bé hơn hoặc bằng số lượng tồn!");
			txtSoLuong.setText("1");
			return false;
		}
		else if(soLuong == -4) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập vào số!");
			txtSoLuong.setText("1");
			return false;
		}
		return true;
	}
	public void CapNhatSLTon(int soLuong) {
		int SLTon = Integer.parseInt(tbl_DanhSachSanPham.getValueAt(iSP, 5)+ "");
		int SL = SLTon - soLuong;
		if (SL >= 0)
			tbl_DanhSachSanPham.setValueAt(SL, iSP, 5);
		else {
			JOptionPane.showMessageDialog(null, "Số lượng tồn của sản phẩm này không đủ!");
			return;
		}
	}
	public int SoLuong(String pheptoan) {
		int SL;
		int SLTon;
		if(tbl_DanhSachSanPham.getSelectedRow() == -1)
			return -1;
		else
			SLTon = Integer.parseInt(tableModel_PDH.getValueAt(iSP, 5)+ "");
		if(txtSoLuong.getText().isEmpty())
			return -2;
		else {
			try {
				if(pheptoan == "+") 
					SL = Integer.parseInt(txtSoLuong.getText()) + 1;
				else if(pheptoan == "-") 
						SL = Integer.parseInt(txtSoLuong.getText()) - 1;
				else
					SL = Integer.parseInt(txtSoLuong.getText());
				if(SL < 1 || SL  > SLTon )
					return -3;
			} catch (Exception e) {
				// TODO: handle exception
				return -4;
			}
		}
		return Integer.parseInt(txtSoLuong.getText());
	}
    public void Khoatxt() {
    	btnCong.setIcon(icoCong.toIcon());
    	btnThem.setIcon(icoThem.toIcon());
    	
    	btnTru1.setIcon(icoTru.toIcon());
    	btnTru.setIcon(icoTru.toIcon());
    	btnLamMoi.setIcon(icoLamMoi.toIcon());
    	btnLoc.setIcon(icoLoc.toIcon());
    	btnInPD.setIcon(iconIn.toIcon());
    	
    	txtSoLuong1.setEditable(false);
    	txtGiaBan.setEditable(false);
    	txtMaPDH.setEditable(false);
    	txtNhanVien.setEditable(false);
    	txtNhanVien.setText("Diêm Công Bình");
    	txtTenKH.setEditable(false);
    	txtThanhTien.setEditable(false);
    	txtDonVi.setEditable(false);
    	txtNgayLapPhieu.setEditable(false);
    	txtNgayLapPhieu.setText(java.time.LocalDate.now() +"");
    	
    	iPhieuDatHang = new PhieuDatHangServiceImpl();
    	try {
			dsPhieuDatHang = iPhieuDatHang.getDSPhieuDatHang();
			String maPDH = "PDH0" + (dsPhieuDatHang.size() + 1);
			txtMaPDH.setText(maPDH);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void DocDuLieuTuArrayListVaoModel() throws Exception {
		iSanPham = new SanPhamServiceImpl();
		dsSach = iSanPham.getAllSach();
		int i = 1;
		for (Sach s: dsSach) {
			  Object[] ob = { i++, s.getMaSanPham(), s.getTenSach(), s.getTheLoaiSach(), s.getTacGia().getTenTacGia(), s.getSoLuongTon()};
			tableModel_PDH.addRow(ob);
			//System.out.println(nv.isGioiTinh());
		}
	}
    public void ThemSanPhamVaoPDH(int soLuong) throws Exception {
    	if(tbl_DanhSachSanPham.getSelectedRow() == -1) {
    		JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm trước khi thêm!");
    		return;
    	}
    	String maSP = txtMaSP.getText();
    	for (int i = 0; i < tableModel_PDH1.getRowCount(); i++) {
    		String maSPcheck = tableModel_PDH1.getValueAt(i, 1) + "";
    		if(maSP.equals(maSPcheck)) {
    			tableModel_PDH1.setValueAt( Integer.parseInt(tableModel_PDH1.getValueAt(i, 4)+ "")+ soLuong,i, 4);
    			return;
    		}
    	}
    	String tenSP = txtTenSP.getText();
    	String giaBan = txtGiaBan.getText();
        Object[] ob = { tableModel_PDH1.getRowCount() + 1, maSP, tenSP, giaBan, soLuong};
    	tableModel_PDH1.addRow(ob);

    }
    public void CapNhatThanhTien() {
    	double thanhTien = 0;
    	for (int i = 0; i < tableModel_PDH1.getRowCount(); i++) {
    		double giaBan = Double.parseDouble(tableModel_PDH1.getValueAt(i, 3)+"") ;
    		int sL = (int) tableModel_PDH1.getValueAt(i, 4);
    		thanhTien += giaBan*sL;
    	}
    	txtThanhTien.setText(thanhTien + "");
    }
    public void setValueForm(int i) {
    	String maSP = tbl_DanhSachSanPham.getValueAt(i, 1) + "";
    	String tenSP = tbl_DanhSachSanPham.getValueAt(i, 2) + "";
    	int soLuong = 1;
    	iSanPham = new SanPhamServiceImpl();
    	try {
			SanPham s = iSanPham.timSanPhamTheoMa(maSP);
			txtMaSP.setText(s.getMaSanPham());
			txtTenSP.setText(tenSP);
			txtDonVi.setText(s.getDonVi());
			txtGiaBan.setText(s.getGiaBan()+"");
			if(s.getLoaiSanPham().equals("Sách")) {
				cbb_loaiSP.setSelectedIndex(0);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		txtSoLuong.setText(soLuong + "");
    	txtMaSP.setEditable(false);
    	txtTenSP.setEditable(false);

    }
    public void timKH() {
    	String sDTTim = txtSDT.getText();
    	if(sDTTim.isEmpty() || sDTTim.length() != 10) {
    		JOptionPane.showMessageDialog(null, "Số điện thoại phải bao gồm 10 chữ số!");
    		return;
    	}

    		
    	try {
    		iKhachHang = new KhachHangServiceImpl();
			KhachHang kh = iKhachHang.getKhachHangTheoSDT(sDTTim);
			if(kh == null)
				JOptionPane.showMessageDialog(null, "Không tìm thấy, vui lòng thêm khách hàng mới!");
			else {
				txtTenKH.setText(kh.getHoTenKH());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public PhieuDatHang revertPDH() throws SQLException {
    	String maPDH = txtMaPDH.getText();
    	iNhanVien = new NhanVienServiceImpl();
		NhanVien nv = iNhanVien.timNhanVienTheoTen(txtNhanVien.getText());
		iKhachHang = new KhachHangServiceImpl();
		KhachHang kh = iKhachHang.getKhachHangTheoSDT(txtSDT.getText());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String day = sdf.format(dcNgayLayHang.getDate());
		String date[] = day.split("-");
		int nam = Integer.parseInt(date[0]);
		int thang = Integer.parseInt(date[1]);
		int ngay = Integer.parseInt(date[2]);
		
		LocalDate ngayLayHang = LocalDate.of(nam, thang, ngay);
		
		String date1[] = txtNgayLapPhieu.getText().split("-");
		int nam1 = Integer.parseInt(date1[0]);
		int thang1 = Integer.parseInt(date1[1]);
		int ngay1 = Integer.parseInt(date1[2]);
		
		LocalDate ngayLapPhieu= LocalDate.of(nam1, thang1, ngay1);
		
		PhieuDatHang pdh = new PhieuDatHang(maPDH, nv, kh, ngayLapPhieu, ngayLayHang, false);
		return pdh;
		
    }
    public void LapPDH(){
  
//    	try {
//    		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    }
    public void LamMoi() {
    	txtMaSP.setText("");
    	txtMaSP.setEditable(true);
    	txtTenSP.setText("");
    	txtTenSP.setEditable(true);
    	txtDonVi.setText("");
    	txtGiaBan.setText("");
    	txtSoLuong.setText("");
    	tableModel_PDH.setRowCount(0);
    	try {
			DocDuLieuTuArrayListVaoModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void HienThiLaiSP() {
    	String maSP = tbl_DSSPDatHang.getValueAt(iPDH, 1) + "";
    	for (int i = 0; i < tbl_DanhSachSanPham.getRowCount(); i++) {
    		String maSPcheck = tbl_DanhSachSanPham.getValueAt(i, 1) + "";
    		if(maSP.equals(maSPcheck)) {
    			iSP = i;
    			setValueForm(i);
    			tbl_DanhSachSanPham.setRowSelectionInterval(i, i);
    			return;
    		}
    	}
    }

	

	

}
