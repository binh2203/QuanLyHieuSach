
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
import entity.HoaDon;
import service_impl.HoaDonServiceImpl;


public class Pnl_TimKiemHoaDon extends javax.swing.JPanel implements ActionListener, MouseListener {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private com.toedter.calendar.JDateChooser dcNgayLapHD;
//    private javaswingdev.FontAwesomeIcon icoLamMoi;
//    private javaswingdev.FontAwesomeIcon icoTimKiem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblTienKhachDua;
    private javax.swing.JLabel lblSDTKH;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlTableHD;
    private javax.swing.JTable tblTimKiemHD;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTienKhachDua;
    private HoaDonServiceImpl iHoaDon;
    private List<HoaDon> dsHoaDon;
    private DefaultTableModel tablemodel_HoaDon;
    // End of variables declaration//GEN-END:variables
	
	
    public Pnl_TimKiemHoaDon() {
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
        lblTimKiem = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblMaHD = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtNhanVien = new javax.swing.JTextField();
        lblTenNV = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblNgayLap = new javax.swing.JLabel();
        lblSDTKH = new javax.swing.JLabel();
        lblTienKhachDua = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        dcNgayLapHD = new com.toedter.calendar.JDateChooser();
        txtTienKhachDua = new javax.swing.JTextField();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlTableHD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimKiemHD = new javax.swing.JTable();

//        icoLamMoi.setIcon(javaswingdev.FontAwesome.REFRESH);
//        icoLamMoi.setSize(18);
//
//        icoTimKiem.setColor1(java.awt.Color.darkGray);
//        icoTimKiem.setColor2(java.awt.Color.black);
//        icoTimKiem.setIcon(javaswingdev.FontAwesome.SEARCH);
//        icoTimKiem.setSize(18);

        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(java.awt.Color.lightGray);

        lblTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimKiem.setText("TÌM KIẾM HÓA ĐƠN");

        lblMaHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaHD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaHD.setText("Mã hóa đơn:");

        txtMaHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        lblTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenNV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenNV.setText("Nhân viên lập hóa đơn:");

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenKH.setText("Tên khách hàng:");

        lblNgayLap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgayLap.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayLap.setText("Ngày lập: ");
        lblNgayLap.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblSDTKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSDTKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSDTKH.setText("Số điện thoại khách hàng:");

        lblTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTienKhachDua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienKhachDua.setText("Tiền Khách Đưa");
        lblTienKhachDua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai.setText("Trạng thái:");
        lblTrangThai.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        dcNgayLapHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
                    .addComponent(lblMaHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSDTKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcNgayLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLamMoi)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dcNgayLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(lblTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlTableHD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        String header_HD[] = { "STT", "Mã HD", "Nhân viên", "Khách hàng", "Số điện thoại khách hàng", "Ngày lập ", "Thành tiền"};
		tablemodel_HoaDon = new DefaultTableModel(header_HD, 0);
        tblTimKiemHD = new JTable(tablemodel_HoaDon);
        jScrollPane1.setViewportView(tblTimKiemHD);
        if (tblTimKiemHD.getColumnModel().getColumnCount() > 0) {
        	tblTimKiemHD.getColumnModel().getColumn(0);
    		tblTimKiemHD.getColumnModel().getColumn(1);
    		tblTimKiemHD.getColumnModel().getColumn(2);
    		tblTimKiemHD.getColumnModel().getColumn(3);
    		tblTimKiemHD.getColumnModel().getColumn(4);
    		tblTimKiemHD.getColumnModel().getColumn(5);
    		tblTimKiemHD.getColumnModel().getColumn(6);

        }
     
        try {
			DocDuLieuTuArrayListVaoModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        javax.swing.GroupLayout pnlTablePDHLayout = new javax.swing.GroupLayout(pnlTableHD);
        pnlTableHD.setLayout(pnlTablePDHLayout);
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

        add(pnlTableHD, java.awt.BorderLayout.LINE_START);
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
				TimHD();
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			
		}
	}
	public void LamMoi() {
			txtMaHD.setText("");
			txtNhanVien.setText("");
			txtKhachHang.setText("");
			txtSDT.setText("");
			txtTienKhachDua.setText("");
			dcNgayLapHD.setDate(null);
			cbbTrangThai.setSelectedIndex(0);
			tablemodel_HoaDon.setRowCount(0);
			try {
				DocDuLieuTuArrayListVaoModel();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public void DocDuLieuTuArrayListVaoModel() throws Exception {
		iHoaDon = new HoaDonServiceImpl();
		dsHoaDon = iHoaDon.getDSHoaDon();
		int i = 1;
		for (HoaDon hd : dsHoaDon) {
				Object[] ob = { i++, hd.getMaHD(), hd.getNhanVien().getHoTenNV(), hd.getKhachHang().getHoTenKH(), 
					hd.getKhachHang().getSDT(), hd.getNgayLapHD(), hd.getTienKhachDua(), hd.isTrangThai()};
				tablemodel_HoaDon.addRow(ob);
		}
	}
	public void TimHD() throws Exception {
		HoaDon hd = revertHDFromTextFields();
		iHoaDon = new HoaDonServiceImpl();
		try {
			dsHoaDon = iHoaDon.timDsHoaDon(hd);
			tablemodel_HoaDon.setRowCount(0);
			int i = 1;
			for (HoaDon hoadon : dsHoaDon) {
				Object[] ob = { i++, hoadon.getMaHD(), hoadon.getNhanVien().getHoTenNV(), hoadon.getKhachHang().getHoTenKH(), 
						hoadon.getKhachHang().getSDT(), hoadon.getNgayLapHD(), hoadon.getTienKhachDua()};
					tablemodel_HoaDon.addRow(ob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public HoaDon revertHDFromTextFields() {
    	String maHD = txtMaHD.getText();
		String tenNV = txtNhanVien.getText();
		String tenKH = txtKhachHang.getText();
		String sDT = txtSDT.getText();
		
		
		float tienKhachDua = 0;
		if(txtTienKhachDua.getText() == "") {
			tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
		}
		
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
		
		KhachHang kh = new KhachHang(null, tenKH, true, null, sDT, null, null);
		
		int trangThaiInt = cbbTrangThai.getSelectedIndex();
		boolean trangThai;
		if(trangThaiInt == 0)
			trangThai = true;
		else trangThai = false;

		HoaDon hd = new HoaDon(maHD, new NhanVien("",tenNV), kh, lcDate, tienKhachDua, trangThai);
		
		return hd;
	}
}
