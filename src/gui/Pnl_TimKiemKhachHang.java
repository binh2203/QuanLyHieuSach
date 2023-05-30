package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import entity.KhachHang;
import service_impl.KhachHangServiceImpl;


public class Pnl_TimKiemKhachHang extends javax.swing.JPanel implements ActionListener, MouseListener {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private com.toedter.calendar.JDateChooser dcNgaySinh;
//    private javaswingdev.FontAwesomeIcon icoLamMoi;
//    private javaswingdev.FontAwesomeIcon icoTimKiem;
//    private javaswingdev.FontAwesomeIcon icoXuatFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JLabel lblmaKH;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTimKiemKH;
    private javax.swing.JPanel pnlBangDuLieuVaChucNang;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlThongTinKH;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblTimKiemKH;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoDienThoai;
    private KhachHangServiceImpl iKhachHang;
    private List<KhachHang> dsKhachHang;
    private DefaultTableModel tableModel_KhachHang;
    // End of variables declaration//GEN-END:variables
	
    public Pnl_TimKiemKhachHang() {
        initComponents();
//        btnLamMoi.setIcon(icoLamMoi.toIcon());
//        btnTimKiem.setIcon(icoTimKiem.toIcon());
//  
        
        dcNgaySinh.setEnabled(false);
        btnLamMoi.addActionListener(this);
        btnTimKiem.addActionListener(this);
        
    }

    private void initComponents() {

//        icoXuatFile = new javaswingdev.FontAwesomeIcon();
//        icoLamMoi = new javaswingdev.FontAwesomeIcon();
//        icoTimKiem = new javaswingdev.FontAwesomeIcon();
        pnlHeader = new javax.swing.JPanel();
        lblTimKiemKH = new javax.swing.JLabel();
        pnlBangDuLieuVaChucNang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimKiemKH = new javax.swing.JTable();
        pnlChucNang = new javax.swing.JPanel();
        btnLamMoi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        pnlThongTinKH = new javax.swing.JPanel();
        lblmaKH = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
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

//        icoXuatFile.setIcon(javaswingdev.FontAwesome.UPLOAD);
//        icoXuatFile.setSize(18);
//
//        icoLamMoi.setIcon(javaswingdev.FontAwesome.REFRESH);
//        icoLamMoi.setSize(18);
//
//        icoTimKiem.setColor1(java.awt.Color.darkGray);
//        icoTimKiem.setColor2(java.awt.Color.black);
//        icoTimKiem.setIcon(javaswingdev.FontAwesome.SEARCH);
//        icoTimKiem.setSize(18);

        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(java.awt.Color.lightGray);

        lblTimKiemKH.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblTimKiemKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimKiemKH.setText("TÌM KIẾM KHÁCH HÀNG");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTimKiemKH, javax.swing.GroupLayout.DEFAULT_SIZE, 1572, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lblTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlBangDuLieuVaChucNang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        String header_NhanVien[] = { "STT", "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Email" };
		tableModel_KhachHang = new DefaultTableModel(header_NhanVien, 0);
        tblTimKiemKH = new JTable(tableModel_KhachHang);
        jScrollPane1.setViewportView(tblTimKiemKH);
        if (tblTimKiemKH.getColumnModel().getColumnCount() > 0) {
        	tblTimKiemKH.getColumnModel().getColumn(0).setPreferredWidth(10);
    		tblTimKiemKH.getColumnModel().getColumn(1).setPreferredWidth(10);
    		tblTimKiemKH.getColumnModel().getColumn(2).setPreferredWidth(90);
    		tblTimKiemKH.getColumnModel().getColumn(3).setPreferredWidth(20);
    		tblTimKiemKH.getColumnModel().getColumn(4).setPreferredWidth(20);
    		tblTimKiemKH.getColumnModel().getColumn(5).setPreferredWidth(70);
    		tblTimKiemKH.getColumnModel().getColumn(6).setPreferredWidth(70);
    		tblTimKiemKH.getColumnModel().getColumn(7).setPreferredWidth(120);
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


        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");


        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnTimKiem))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBangDuLieuVaChucNangLayout = new javax.swing.GroupLayout(pnlBangDuLieuVaChucNang);
        pnlBangDuLieuVaChucNang.setLayout(pnlBangDuLieuVaChucNangLayout);
        pnlBangDuLieuVaChucNangLayout.setHorizontalGroup(
            pnlBangDuLieuVaChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        pnlBangDuLieuVaChucNangLayout.setVerticalGroup(
            pnlBangDuLieuVaChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBangDuLieuVaChucNangLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlBangDuLieuVaChucNang, java.awt.BorderLayout.LINE_START);

        pnlThongTinKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblmaKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblmaKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmaKH.setText("Mã khách hàng");

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
   

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

        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNam.setText("Nam");
        rdoNam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
 

        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNu.setText("Nữ");
        rdoNu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);


        javax.swing.GroupLayout pnlThongTinNhanVienLayout = new javax.swing.GroupLayout(pnlThongTinKH);
        pnlThongTinKH.setLayout(pnlThongTinNhanVienLayout);
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
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinNhanVienLayout.createSequentialGroup()
                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addComponent(lblHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblmaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(lblmaKH)
                .addGap(12, 12, 12)
                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        add(pnlThongTinKH, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void DocDuLieuTuArrayListVaoModel() throws Exception {
	iKhachHang = new KhachHangServiceImpl();
	dsKhachHang = iKhachHang.getDSKhachHang();
	int i = 1;
	for (KhachHang nv : dsKhachHang) {
			Object[] ob = { i++, nv.getMaKH(), nv.getHoTenKH(), nv.isGioiTinh() != true ? "Nam" : "Nữ", 
				nv.getNgaySinh(), nv.getSDT(), nv.getDiaChi(), nv.getEmail()};
		tableModel_KhachHang.addRow(ob);
			//System.out.println(nv.isGioiTinh());
            }
    }
    
    public KhachHang revertKHFromTextfields() {
		String maKH = txtMaKH.getText();
		String tenKH = txtHoVaTen.getText();
		boolean gioiTinh = rdoNu.isSelected();
		String sdt = txtSoDienThoai.getText();
		String diaChi = txtDiaChi.getText();
		String email = txtEmail.getText();
		if(maKH.isEmpty() && tenKH.isEmpty() && rdoNam.isSelected() == false && rdoNu.isSelected() == false && 
				sdt.isEmpty() && diaChi.isEmpty() && email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền ít nhất một thông tin!");
		}
		KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, null, sdt, diaChi, email);
		return kh;
	}
    public void clear_form() {
		txtMaKH.setText("");
		txtHoVaTen.setText("");
		rdoNam.setSelected(true);
		dcNgaySinh.setDate(null);
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
	}
	public void xoaHetDuLieu() {
		DefaultTableModel dtm = (DefaultTableModel) tblTimKiemKH.getModel();
		dtm.getDataVector().removeAllElements();
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnTimKiem)) {
			KhachHang kh = revertKHFromTextfields();
			try {
				dsKhachHang = iKhachHang.timDSKH(kh);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (dsKhachHang.size() != 0) {
				xoaHetDuLieu();
				int i = 1;
				for (KhachHang khachHang : dsKhachHang) {
					tableModel_KhachHang.addRow(new Object[] { i++, khachHang.getMaKH(), khachHang.getHoTenKH()
							, khachHang.isGioiTinh() != true ? "Nam" : "Nữ", khachHang.getNgaySinh(),
							khachHang.getSDT(), khachHang.getDiaChi(), khachHang.getEmail() });
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
			}
		}else if(obj.equals(btnLamMoi)) {
			clear_form();
			xoaHetDuLieu();
			try {
				DocDuLieuTuArrayListVaoModel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
