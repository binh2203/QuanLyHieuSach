/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.DBConnection;
import entity.KhachHang;
import entity.KhachHang;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class KhachHangDao {
    private Connection con;
    private PreparedStatement ps=null;
    private ResultSet rs;
    private ArrayList<KhachHang> khachhang = new ArrayList<KhachHang>();

    public KhachHangDao() {
    	DBConnection connection = DBConnection.getInstance();
    	con = connection.getConnection();
    }
    
    public int themKhachHang(KhachHang kh) throws SQLException {
    	String insert = "Insert into KhachHang values (?, ?, ?, ?, ?, ?, ?, ?)";
    	PreparedStatement stmt = con.prepareStatement(insert);
                        
    	stmt.setString(1, kh.getMaKH());
    	stmt.setString(2, kh.getHoTenKH());
    	stmt.setBoolean(3, kh.isGioiTinh());
                
    	int day = kh.getNgaySinh().getDayOfMonth();
    	int month = kh.getNgaySinh().getMonthValue();
    	int year = kh.getNgaySinh().getYear();
                
    	stmt.setString(4, year + "-" + month + "-" + day );
    	stmt.setString(5, kh.getSDT());
    	stmt.setString(6, kh.getDiaChi());
    	stmt.setString(7, kh.getEmail());
    	stmt.setBoolean(8, true);
    	stmt.executeUpdate();
    	return 1;
    }
    
    public List<KhachHang> getDSKhachHang() throws SQLException {
    	List<KhachHang> dskh = new ArrayList<>();
    	String query = "Select * from KhachHang";
    	ps = con.prepareStatement(query);
    	rs = ps.executeQuery();
    	while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("maKH"));
                kh.setHoTenKH(rs.getString("tenKH"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setNgaySinh(rs.getDate("ngaySinh").toLocalDate());
                kh.setSDT(rs.getString("phone"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setEmail(rs.getString("email"));
                kh.setTrangThai(rs.getBoolean("trangThai"));
                dskh.add(kh);
    	}
    	return dskh;
        }
    
    public KhachHang timKhachHangTheoMa(String maKH) throws SQLException {
	KhachHang kh = new KhachHang();
	String query = "Select * from KhachHang where maKH=?";
	ps = con.prepareStatement(query);
	ps.setString(1, maKH);
	rs = ps.executeQuery();
	while (rs.next()) {
            kh = new KhachHang(rs.getString("maKH"));
            return kh;
	}
	return null;
    }
    
    public ArrayList<KhachHang> timKhachHangTheoTen(String tenKH) throws SQLException{
        KhachHang kh = new KhachHang();
        khachhang = new ArrayList<KhachHang>();
        String query = "Select * from KhachHang where tenKH LIKE CONCAT('%', ?, '%')";
	ps = con.prepareStatement(query);
	ps.setString(1, tenKH);
	rs = ps.executeQuery();
        while (rs.next()) {
            kh = new KhachHang(rs.getString("maKH"));
            khachhang.add(kh);
	}
        return khachhang;
    }
    
    public ArrayList<KhachHang> timKhachHangTheoSDT(String sDT) throws SQLException {
	KhachHang kh = new KhachHang();
	String query = "Select * from KhachHang where phone LIKE CONCAT('%', ?, '%')";
	PreparedStatement stmt = con.prepareCall(query);
	stmt.setString(1, sDT);
	ResultSet rs = stmt.executeQuery();
	while (rs.next()) {
            kh = new KhachHang(rs.getString("maKH"));
            khachhang.add(kh);
	}
	return khachhang;
    }
    
    public KhachHang getKhachHangTheoMa(String maKH) throws SQLException {
		String query = "Select * from KhachHang where maKH = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, maKH);
		rs = ps.executeQuery();
		while (rs.next()) {
			KhachHang kh = new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getBoolean("gioiTinh"), 
					rs.getDate("ngaySinh").toLocalDate(),rs.getString("phone"), rs.getString("diaChi"), rs.getString("email"));
			return kh;
		}
		return null;
	}
    
    public int capNhatKhachHang(KhachHang kh) {
	String sql = "UPDATE KhachHang SET tenKH = ?, gioiTinh = ?, ngaySinh = ?, phone = ?, diaChi = ?, email = ? WHERE maKH = ?";
	try {
            ps = con.prepareStatement(sql);
            ps.setString(7, kh.getMaKH());
            ps.setString(1, kh.getHoTenKH());
            ps.setBoolean(2, kh.isGioiTinh());
                
            int day = kh.getNgaySinh().getDayOfMonth();
            int month = kh.getNgaySinh().getMonthValue();
            int year = kh.getNgaySinh().getYear();
                
            ps.setString(3, year + "-" + month + "-" + day );
            ps.setString(4, kh.getSDT());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getEmail());

            return ps.executeUpdate();
	} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
	return 1;
    }
    
    
    public int xoaKhachHang(String maKH) {
	String query = "update KhachHang set trangThai = 0 where maKH = ?";
	try {
            ps = con.prepareStatement(query);
            ps.setString(1, maKH);
            

            return ps.executeUpdate();
	} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
	return 1;		
    }
    
    public KhachHang getKhachHangTheoSDT(String sDT) throws SQLException {
		String query = "Select * from KhachHang where phone = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, sDT);
		rs = ps.executeQuery();
		while (rs.next()) {
			KhachHang kh = new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getBoolean("gioiTinh"), 
					rs.getDate("ngaySinh").toLocalDate(),rs.getString("phone"), rs.getString("diaChi"), rs.getString("email"));
			return kh;
		}
		return null;
	}
   
    
    public List<KhachHang> timDSKH(KhachHang kh) throws SQLException {
		List<KhachHang> dskh = new ArrayList<>();
		int gt = 0;
		if(kh.isGioiTinh())
			gt = 1;
		String query = "select * from KhachHang where maKH LIKE CONCAT('%', ?, '%')"
				+ " and tenKH LIKE CONCAT('%', ?, '%') "
				+ " and gioiTinh = ? "
				+ " and phone LIKE CONCAT('%', ?, '%')"
				+ " and diaChi LIKE CONCAT('%', ?, '%')"
				+ " and email LIKE CONCAT('%', ?, '%')";
		ps = con.prepareStatement(query);
		ps.setString(1, kh.getMaKH());
		ps.setString(2, kh.getHoTenKH());
		ps.setString(3, gt +"");
		ps.setString(4, kh.getSDT());
		ps.setString(5, kh.getDiaChi());
		ps.setString(6, kh.getEmail());
		rs = ps.executeQuery();
		while (rs.next()) {
			KhachHang kh1 = new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getBoolean("gioiTinh"), 
					rs.getDate("ngaySinh").toLocalDate(),rs.getString("phone"), rs.getString("diaChi"), rs.getString("email"));
			dskh.add(kh1);
		}
		return dskh;
	}
}
