
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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Hashtable;

import connectDB.DBConnection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import entity.KhachHang;
import entity.NhanVien;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;
import service_impl.HoaDonServiceImpl;
import service_impl.KhachHangServiceImpl;
import service_impl.NhanVienServiceImpl;
import service_impl.SanPhamServiceImpl;
import service_impl.CTHDServiceImpl;

public class Pnl_LapHoaDon extends javax.swing.JPanel implements ActionListener, MouseListener{
	 @SuppressWarnings("unchecked")
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLap;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton btnTru1;
    private javax.swing.JComboBox<String> cbb_loaiSP;
    private com.toedter.calendar.JDateChooser dcNgayLapHD;
//    private javaswingdev.FontAwesomeIcon icoCong;
//    private javaswingdev.FontAwesomeIcon icoLamMoi;
//    private javaswingdev.FontAwesomeIcon icoLoc;
//    private javaswingdev.FontAwesomeIcon icoThem;
//    private javaswingdev.FontAwesomeIcon icoTru;
//    private javaswingdev.FontAwesomeIcon iconIn;
//    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_DSSPLHD;
    private javax.swing.JTable tbl_DanhSachSanPham;
    private javax.swing.JLabel lblDonVi;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblLapHoaDon;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblNgayLapHD;
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
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuong1;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtThanhTien;
    private SanPhamServiceImpl iSanPham;
    private List<Sach> dsSach;
    private DefaultTableModel tableModel_HD;
    private DefaultTableModel tableModel_HD1;
    private HoaDonServiceImpl iLapHD;
    private List<HoaDon> dsLapHoaDon;
    private KhachHangServiceImpl iKhachHang;
    private NhanVienServiceImpl iNhanVien;
    private CTHDServiceImpl iCTHD = new CTHDServiceImpl();
    private List<VanPhongPham> dsVPP;
    private int iHD;
    private int iSP;
    // End of variables declaration//GEN-END:variables
	
    public Pnl_LapHoaDon() {
       initComponents();
       Khoatxt();
       
       txtSoLuong.addActionListener(this);
       btnCong.addActionListener(this);
       btnIn.addActionListener(this);
       btnLamMoi.addActionListener(this);
       btnLap.addActionListener(this);
       btnLoc.addActionListener(this);
       btnThem.addActionListener(this);
       btnTru.addActionListener(this);       
       btnTru1.addActionListener(this);
       btnXoa.addActionListener(this);
       btnTim.addActionListener(this);
       tbl_DanhSachSanPham.addMouseListener(this);
       tbl_DSSPLHD.addMouseListener(this);
    }	
   
    private void initComponents() {

//        icoLamMoi = new javaswingdev.FontAwesomeIcon();
//        icoThem = new javaswingdev.FontAwesomeIcon();
//        iconIn = new javaswingdev.FontAwesomeIcon();
//        icoLoc = new javaswingdev.FontAwesomeIcon();
//        icoTru = new javaswingdev.FontAwesomeIcon();
//        icoCong = new javaswingdev.FontAwesomeIcon();
        pnlHeader1 = new javax.swing.JPanel();
        lblLapHoaDon = new javax.swing.JLabel();
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
        lblDiaChi = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        lblTenKH = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblNgayLapHD = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        dcNgayLapHD = new com.toedter.calendar.JDateChooser();
        txtTenKH = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        lblSoLuong1 = new javax.swing.JLabel();
        txtSoLuong1 = new javax.swing.JTextField();
        btnTru1 = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DSSPLHD = new javax.swing.JTable();
        JPanel jPanel1 = new javax.swing.JPanel();
        lblThanhTien = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        btnLap = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

//        icoLamMoi.setIcon(javaswingdev.FontAwesome.REFRESH);
//        icoLamMoi.setSize(18);
//
//        icoThem.setColor1(new java.awt.Color(102, 204, 0));
//        icoThem.setColor2(new java.awt.Color(102, 204, 0));
//        icoThem.setIcon(javaswingdev.FontAwesome.PLUS);
//        icoThem.setSize(18);
//
//        iconIn.setColor1(java.awt.Color.blue);
//        iconIn.setColor2(java.awt.Color.blue);
//        iconIn.setIcon(javaswingdev.FontAwesome.PRINT);
//        iconIn.setSize(18);
//
//        icoLoc.setColor1(java.awt.Color.black);
//        icoLoc.setColor2(java.awt.Color.black);
//        icoLoc.setIcon(javaswingdev.FontAwesome.FILTER);
//        icoLoc.setSize(18);
//
//        icoTru.setColor1(java.awt.Color.red);
//        icoTru.setColor2(java.awt.Color.red);
//        icoTru.setIcon(javaswingdev.FontAwesome.MINUS);
//
//        icoCong.setColor1(new java.awt.Color(153, 204, 0));
//        icoCong.setColor2(new java.awt.Color(153, 153, 0));
//        icoCong.setIcon(javaswingdev.FontAwesome.PLUS_SQUARE);
//        icoCong.setSize(30);

        setLayout(new java.awt.BorderLayout());

        pnlHeader1.setBackground(java.awt.Color.lightGray);

        lblLapHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblLapHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLapHoaDon.setText("LẬP HÓA ĐƠN");

        javax.swing.GroupLayout pnlHeader1Layout = new javax.swing.GroupLayout(pnlHeader1);
        pnlHeader1.setLayout(pnlHeader1Layout);
        pnlHeader1Layout.setHorizontalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 1550, Short.MAX_VALUE)
        );
        pnlHeader1Layout.setVerticalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeader1Layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lblLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
		tableModel_HD = new DefaultTableModel(header_sp, 0);
        tbl_DanhSachSanPham = new JTable(tableModel_HD);
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
        lblTieuDe.setText("HÓA ĐƠN");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiaChi.setText("Ngày hiện tại:");

        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenKH.setText("Tên khách hàng:");

        lblMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaHD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaHD.setText("Mã HD:");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N


        lblNgayLapHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayLapHD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayLapHD.setText("Ngày lập :");

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNhanVien.setText("Nhân viên:");

        lblSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSDT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSDT.setText("SDT khách hàng:");

        dcNgayLapHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N


        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
                                        .addComponent(lblNgayLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcNgayLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(lblMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(12, 12, 12)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayLapHD))
                        .addComponent(dcNgayLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTru1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSoLuong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

        tbl_DSSPLHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        String header_pdh[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Giá bán", "Số lượng"};
      		tableModel_HD1 = new DefaultTableModel(header_pdh, 0);
              tbl_DSSPLHD = new JTable(tableModel_HD1);
              jScrollPane2.setViewportView(tbl_DSSPLHD);
              if (tbl_DSSPLHD.getColumnModel().getColumnCount() > 0) {
              	tbl_DSSPLHD.getColumnModel().getColumn(0);
          		tbl_DSSPLHD.getColumnModel().getColumn(1);
          		tbl_DSSPLHD.getColumnModel().getColumn(2);
          		tbl_DSSPLHD.getColumnModel().getColumn(3);
          		tbl_DSSPLHD.getColumnModel().getColumn(4);
              }
        

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblThanhTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThanhTien.setText("Thành tiền:");

        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnLap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLap.setText("Lập hóa đơn");


        btnIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnIn.setText("In hóa đơn");


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
                        .addComponent(btnLap, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(167, 167, 167))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThanhTien)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
		else if(obj.equals(tbl_DSSPLHD)) {
			iHD = tbl_DSSPLHD.getSelectedRow();
			txtSoLuong1.setText(tbl_DSSPLHD.getValueAt(iHD, 4) + "");
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
				themSPVaoHD(soLuong);
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
					double giaBan = Double.parseDouble(txtGiaBan.getText());
					int soLuong1 = Integer.parseInt(txtSoLuong1.getText());
					tbl_DSSPLHD.setValueAt(soLuong1, iHD, 4);
					tbl_DSSPLHD.setValueAt(soLuong1*giaBan, iHD, 5);
					CapNhatSLTon(-1);
					CapNhatThanhTien();
				}
					
			}
			else if(obj.equals(btnXoa)) {
				if(tbl_DSSPLHD.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Không có sản phẩm nào có thể xóa, vui lòng thêm sản phẩm!");
					return;
				}
				else if(tbl_DSSPLHD.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn xóa!");
					return;
				}
				tableModel_HD1.removeRow(iHD);
				for(int j = iHD; j < tbl_DSSPLHD.getRowCount() ; j++) {
					tbl_DSSPLHD.setValueAt(j+1, j, 0);
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
			else if(obj.equals(btnLap))
				LapHD();
			else if(obj.equals(txtSoLuong)) {
				KiemTraSoLuong(soLuong);
			}else if(obj.equals(btnIn)) {
				dsLapHoaDon = iLapHD.getDSHoaDon();
				String maHD = dsLapHoaDon.get(dsLapHoaDon.size()).getMaHD();
				InHD(maHD);
			}else if(obj.equals(btnLoc)) {
//				LocSanPham();
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
			SLTon = Integer.parseInt(tableModel_HD.getValueAt(iSP, 5)+ "");
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
//    	btnCong.setIcon(icoCong.toIcon());
//    	btnThem.setIcon(icoThem.toIcon());
//    	
//    	btnTru1.setIcon(icoTru.toIcon());
//    	btnTru.setIcon(icoTru.toIcon());
//    	btnLamMoi.setIcon(icoLamMoi.toIcon());
//    	btnLoc.setIcon(icoLoc.toIcon());
//    	btnInPD.setIcon(iconIn.toIcon());
    	
    	txtSoLuong1.setEditable(false);
    	txtGiaBan.setEditable(false);
    	txtMaHD.setEditable(false);
    	txtNhanVien.setEditable(false);
    	txtNhanVien.setText("Diêm Công Bình");
    	txtTenKH.setEditable(false);
    	txtThanhTien.setEditable(false);
    	txtDonVi.setEditable(false);
    	txtDiaChi.setEditable(true);
    	txtDiaChi.setText(java.time.LocalDate.now() +"");
    	
    	iLapHD = new HoaDonServiceImpl();
    	try {
			dsLapHoaDon = iLapHD.getDSHoaDon();
			String maHD = "HD0" + (dsLapHoaDon.size() + 1);
			txtMaHD.setText(maHD);
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
			tableModel_HD.addRow(ob);
			//System.out.println(nv.isGioiTinh());
		}
	}
    public void themSPVaoHD(int soLuong) throws Exception {
    	if(tbl_DanhSachSanPham.getSelectedRow() == -1) {
    		JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm trước khi thêm!");
    		return;
    	}
    	String maSP = txtMaSP.getText();
    	for (int i = 0; i < tableModel_HD1.getRowCount(); i++) {
    		String maSPcheck = tableModel_HD1.getValueAt(i, 1) + "";
    		if(maSP.equals(maSPcheck)) {
    			tableModel_HD1.setValueAt( Integer.parseInt(tableModel_HD1.getValueAt(i, 4)+ "")+ soLuong,i, 4);
    			return;
    		}
    	}
    	String tenSP = txtTenSP.getText();
    	String giaBan = txtGiaBan.getText();
        Object[] ob = { tableModel_HD1.getRowCount() + 1, maSP, tenSP, giaBan, soLuong};
    	tableModel_HD1.addRow(ob);

    	
    }
    public void CapNhatThanhTien() {
    	double thanhTien = 0;
    	for (int i = 0; i < tableModel_HD1.getRowCount(); i++) {
    		double giaBan = Double.parseDouble(tableModel_HD1.getValueAt(i, 3)+ " ") ;
    		int sL = (int) tableModel_HD1.getValueAt(i, 4);
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
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
    public HoaDon revertHoaDon() throws SQLException {
    	String maHD = txtMaHD.getText();
    	iNhanVien = new NhanVienServiceImpl();
		NhanVien nv = iNhanVien.timNhanVienTheoTen(txtNhanVien.getText());
		iKhachHang = new KhachHangServiceImpl();
		KhachHang kh = iKhachHang.getKhachHangTheoSDT(txtSDT.getText());
		
		LocalDate lcDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(dcNgayLapHD.getDate() != null) {
			String day = sdf.format(dcNgayLapHD.getDate());
			String date[] = day.split("-");
			int nam = Integer.parseInt(date[0]);
			int thang = Integer.parseInt(date[1]);
			int ngay = Integer.parseInt(date[2]);
			lcDate = LocalDate.of(nam, thang, ngay);
		}

		String diaChi = txtDiaChi.getText();
		
		HoaDon hd = new HoaDon(maHD, nv, kh, lcDate, 0, false);
		
		return hd;
		
    }
    
    public void LapHD() throws SQLException{
    	if (tbl_DSSPLHD.getRowCount() == 0) {
    		JOptionPane.showMessageDialog(null, "Chưa có sản phẩm nào, vui lòng chọn thêm sản phẩm!");
    		return;
    	}
    	else {
    		HoaDon hoaDon = revertHoaDon();
    		if(hoaDon == null)
    			return;
    		if(iLapHD.TaoHD(hoaDon) == 1) {
    			String maHD = txtMaHD.getText();
    			for (int i = 0; i < tbl_DSSPLHD.getRowCount(); i++) {
    	    		String maSP = tbl_DSSPLHD.getValueAt(i, 1) + "";
    	    		HoaDon hd = new HoaDon(maHD);
    	    		SanPham s = iSanPham.timSanPhamTheoMa(maSP);
    	    		int soLuong = Integer.parseInt(tbl_DSSPLHD.getValueAt(i, 4) + "");
    	    		ChiTietHoaDon cthd = new ChiTietHoaDon(hd, s, soLuong);
    	    		int SLTon = s.getSoLuongTon();
    	    		iSanPham.CapNhatSLTon(maSP, SLTon - soLuong);
    	    		iCTHD.TaoCTHD(cthd);    			
    	    	}
    			JOptionPane.showMessageDialog(null, "Lập hóa đơnthành công!");
    			txtSDT.setText("");
    			txtTenKH.setText("");
    			dcNgayLapHD.setDate(null);
    			tableModel_HD1.setRowCount(0);
    			txtSoLuong1.setText("");
    			Khoatxt();
    			InHD(maHD);
    		}
    		else return;
    	}
    }
    
    public void LamMoi() {
    	txtMaSP.setText("");
    	txtMaSP.setEditable(true);
    	txtTenSP.setText("");
    	txtTenSP.setEditable(true);
    	txtDonVi.setText("");
    	txtGiaBan.setText("");
    	txtSoLuong.setText("");
    	tableModel_HD.setRowCount(0);
    	try {
			DocDuLieuTuArrayListVaoModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void HienThiLaiSP() {
    	String maSP = tbl_DSSPLHD.getValueAt(iHD, 1) + "";
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

	
	
	public void InHD(String maHD) {
    	try {
			Hashtable map = new Hashtable();
			JasperReport report = JasperCompileManager.compileReport("src/gui/HoaDon.jrxml");
			// System.out.println(report);
			map.put("maHD", maHD);
			JasperPrint p = JasperFillManager.fillReport(report, map, DBConnection.getInstance().getConnection());

			JasperViewer.viewReport(p, false);

		} catch (Exception e) {
			e.printStackTrace();
		}
    }	
	
//	public void LocSanPham() throws Exception {
//    	String maSP = txtMaSP.getText();
//    	String tenSP = txtTenSP.getText();
//    	int loaiSP = cbb_loaiSP.getSelectedIndex();
//    	tableModel_HD.setRowCount(0);
//    	if(loaiSP == 0) {
//    		dsSach = iSanPham.LocSach(maSP, tenSP);
//    		int i = 1;
//    		for (Sach s: dsSach) {
//    			Object[] ob = { i++, s.getMaSanPham(), s.getTenSach(), s.getTheLoaiSach().getTenLoai(), s.getTacGia().getTenTacGia(), s.getSoLuongTon()};
//    			tableModel_HD.addRow(ob);
//    		}
//    	}
//    	else {
//    		dsVPP = iSanPham.LocVanPhongPham(maSP, tenSP);
//    		int i = 1;
//    		for (VanPhongPham v : dsVPP) {
//    			Object[] ob = { i++, v.getMaSanPham(), v.getTenVanPhongPham(),v.getLoaiVanPhongPham().getTenLoai(), v.getMauSac().getTenMau(), v.getSoLuongTon()};
//    			tableModel_HD.addRow(ob);
//    		}
//    	}
//    }

	

}