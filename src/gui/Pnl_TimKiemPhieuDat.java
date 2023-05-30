
package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatHang;
import service_impl.PhieuDatHangServiceImpl;


public class Pnl_TimKiemPhieuDat extends javax.swing.JPanel implements ActionListener, MouseListener {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private com.toedter.calendar.JDateChooser dcNgayLapPhieu;
    private com.toedter.calendar.JDateChooser dcNgayLayHang;
//    private javaswingdev.FontAwesomeIcon icoLamMoi;
//    private javaswingdev.FontAwesomeIcon icoTimKiem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaPDH;
    private javax.swing.JLabel lblNgayLapPDH;
    private javax.swing.JLabel lblNgayLayHang;
    private javax.swing.JLabel lblSDTKH;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblTimKiemPDH;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlTablePDH;
    private javax.swing.JTable tblTimKiemPDH;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtMaPDH;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSDT;
    private PhieuDatHangServiceImpl iPhieuDatHang;
    private List<PhieuDatHang> dsPhieuDatHang;
    private DefaultTableModel tableModel_PDH;
    // End of variables declaration//GEN-END:variables
	
	
    public Pnl_TimKiemPhieuDat() {
        initComponents();
//        btnLamMoi.setIcon(icoLamMoi.toIcon());
//        btnTimKiem.setIcon(icoTimKiem.toIcon());
  
        btnLamMoi.addActionListener(this);
        btnTimKiem.addActionListener(this);
        btnXemChiTiet.addActionListener(this);
        
    }

    private void initComponents() {

//        icoLamMoi = new javaswingdev.FontAwesomeIcon();
//        icoTimKiem = new javaswingdev.FontAwesomeIcon();
        pnlHeader = new javax.swing.JPanel();
        lblTimKiemPDH = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblMaPDH = new javax.swing.JLabel();
        txtMaPDH = new javax.swing.JTextField();
        txtNhanVien = new javax.swing.JTextField();
        lblTenNV = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblNgayLapPDH = new javax.swing.JLabel();
        lblSDTKH = new javax.swing.JLabel();
        lblNgayLayHang = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        dcNgayLapPhieu = new com.toedter.calendar.JDateChooser();
        dcNgayLayHang = new com.toedter.calendar.JDateChooser();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlTablePDH = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimKiemPDH = new javax.swing.JTable();

//        icoLamMoi.setIcon(javaswingdev.FontAwesome.REFRESH);
//        icoLamMoi.setSize(18);
//
//        icoTimKiem.setColor1(java.awt.Color.darkGray);
//        icoTimKiem.setColor2(java.awt.Color.black);
//        icoTimKiem.setIcon(javaswingdev.FontAwesome.SEARCH);
//        icoTimKiem.setSize(18);

        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(java.awt.Color.lightGray);

        lblTimKiemPDH.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblTimKiemPDH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimKiemPDH.setText("TÌM KIẾM PHIẾU ĐẶT HÀNG");

        lblMaPDH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaPDH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaPDH.setText("Mã phiếu đặt hàng:");

        txtMaPDH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        lblTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenNV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenNV.setText("Nhân viên lập phiếu:");

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenKH.setText("Tên khách hàng:");

        lblNgayLapPDH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgayLapPDH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayLapPDH.setText("Ngày lập phiếu:");
        lblNgayLapPDH.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblSDTKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSDTKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSDTKH.setText("Số điện thoại khách hàng:");

        lblNgayLayHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgayLayHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayLayHang.setText("Ngày lấy hàng:");
        lblNgayLayHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai.setText("Trạng thái:");
        lblTrangThai.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        dcNgayLapPhieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        dcNgayLayHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chưa thanh toán" }));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");


        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXemChiTiet.setText("Xem chi tiết");

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaPDH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSDTKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMaPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblNgayLapPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblNgayLayHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcNgayLayHang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(200, 200, 200)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnXemChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dcNgayLayHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLamMoi)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMaPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNgayLapPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dcNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNgayLayHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXemChiTiet))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTimKiemPDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTimKiemPDH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlTablePDH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        String header_NhanVien[] = { "STT", "Mã PDH", "Nhân viên", "Khách hàng", "Số điện thoại khách hàng", "Ngày lập phiếu", "Ngày lấy hàng", "Thanh toán"};
		tableModel_PDH = new DefaultTableModel(header_NhanVien, 0);
        tblTimKiemPDH = new JTable(tableModel_PDH);
        jScrollPane1.setViewportView(tblTimKiemPDH);
        if (tblTimKiemPDH.getColumnModel().getColumnCount() > 0) {
        	tblTimKiemPDH.getColumnModel().getColumn(0);
    		tblTimKiemPDH.getColumnModel().getColumn(1);
    		tblTimKiemPDH.getColumnModel().getColumn(2);
    		tblTimKiemPDH.getColumnModel().getColumn(3);
    		tblTimKiemPDH.getColumnModel().getColumn(4);
    		tblTimKiemPDH.getColumnModel().getColumn(5);
    		tblTimKiemPDH.getColumnModel().getColumn(6);
    		tblTimKiemPDH.getColumnModel().getColumn(7);
        }
     
        try {
			DocDuLieuTuArrayListVaoModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        javax.swing.GroupLayout pnlTablePDHLayout = new javax.swing.GroupLayout(pnlTablePDH);
        pnlTablePDH.setLayout(pnlTablePDHLayout);
        pnlTablePDHLayout.setHorizontalGroup(
            pnlTablePDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablePDHLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlTablePDHLayout.setVerticalGroup(
            pnlTablePDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablePDHLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 290, Short.MAX_VALUE))
        );

        add(pnlTablePDH, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents





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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object obj = e.getSource();
			if (obj.equals(btnLamMoi)) {
				LamMoi();
			}else if(obj.equals(btnTimKiem)) {
				TimPDH();
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			
		}
	}
	public void LamMoi() {
			txtMaPDH.setText("");
			txtNhanVien.setText("");
			txtKhachHang.setText("");
			txtSDT.setText("");
			dcNgayLapPhieu.setDate(null);
			dcNgayLayHang.setDate(null);
			cbbTrangThai.setSelectedIndex(0);
			tableModel_PDH.setRowCount(0);
			try {
				DocDuLieuTuArrayListVaoModel();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public void DocDuLieuTuArrayListVaoModel() throws Exception {
		iPhieuDatHang = new PhieuDatHangServiceImpl();
		dsPhieuDatHang = iPhieuDatHang.getDSPhieuDatHang();
		int i = 1;
		for (PhieuDatHang pdh : dsPhieuDatHang) {
				Object[] ob = { i++, pdh.getMaPDH(), pdh.getNhanVien().getHoTenNV(), pdh.getKhachHang().getHoTenKH(), 
					pdh.getKhachHang().getSDT(), pdh.getNgayLapPDH(), pdh.getNgayLayHang(), pdh.isTrangThai()== true ? "Đã thanh toán" : "Chưa thanh toán"};
				tableModel_PDH.addRow(ob);
				//System.out.println(nv.isGioiTinh());
		}
	}
	public void TimPDH() throws Exception {
		PhieuDatHang pdh1 = revertPDHFromTextfields();
		iPhieuDatHang = new PhieuDatHangServiceImpl();
		try {
			dsPhieuDatHang = iPhieuDatHang.timDSPhieuDatHang(pdh1);
			tableModel_PDH.setRowCount(0);
			int i = 1;
			for (PhieuDatHang pdh : dsPhieuDatHang) {
				Object[] ob = { i++, pdh.getMaPDH(), pdh.getNhanVien().getHoTenNV(), pdh.getKhachHang().getHoTenKH(), 
					pdh.getKhachHang().getSDT(), pdh.getNgayLapPDH(), pdh.getNgayLayHang(), pdh.isTrangThai()== true ? "Đã thanh toán" : "Chưa thanh toán"};
				tableModel_PDH.addRow(ob);
				//System.out.println(nv.isGioiTinh());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public PhieuDatHang revertPDHFromTextfields() {
    	String maPDH = txtMaPDH.getText();
		String tenNV = txtNhanVien.getText();
		String tenKH = txtKhachHang.getText();
		String sDT = txtSDT.getText();
		LocalDate lcDate = null;
		LocalDate lcDate1 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(dcNgayLapPhieu.getDate() != null) {
			String day = sdf.format(dcNgayLapPhieu.getDate());
			String date[] = day.split("-");
			int nam = Integer.parseInt(date[0]);
			int thang = Integer.parseInt(date[1]);
			int ngay = Integer.parseInt(date[2]);
			lcDate = LocalDate.of(nam, thang, ngay);
		}
		if(dcNgayLayHang.getDate() != null) {
			String day1 = sdf.format(dcNgayLayHang.getDate());
			String date1[] = day1.split("-");
			int nam1 = Integer.parseInt(date1[0]);
			int thang1 = Integer.parseInt(date1[1]);
			int ngay1 = Integer.parseInt(date1[2]);
			lcDate1 = LocalDate.of(nam1, thang1, ngay1);
		}
		KhachHang kh = new KhachHang(null, tenKH, true, null, sDT, null, null);
		int trangThaiInt = cbbTrangThai.getSelectedIndex();
		boolean trangThai;
		if(trangThaiInt == 0)
			trangThai = true;
		else trangThai = false;

		PhieuDatHang pdh = new PhieuDatHang(maPDH, new NhanVien("",tenNV), kh, lcDate, lcDate1, trangThai);
		return pdh;
	}
}
