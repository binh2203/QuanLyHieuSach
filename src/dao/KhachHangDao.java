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
import entity.NhanVien;
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
	String insert = "Insert into KhachHang values (?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement stmt = con.prepareStatement(insert);
                        
	stmt.setString(1, kh.getMaKH());
	stmt.setString(2, kh.getHoTenKH());
	stmt.setBoolean(3, kh.isGioiTinh());
                
        int day = kh.getNgaySinh().getDayOfMonth();
        int month = kh.getNgaySinh().getMonthValue();
	int year = kh.getNgaySinh().getYear();
                
	stmt.setString(4, year + "/" + month + "/" + day );
	stmt.setString(5, kh.getSDT());
        stmt.setString(6, kh.getDiaChi());
        stmt.setString(7, kh.getEmail());
        stmt.executeUpdate();
        return 1;
    }
    
    public List<KhachHang> getDSKhachHang() throws SQLException {
	List<KhachHang> dskh = new ArrayList<>();
	String query = "Select * from KhachHang";
	ps = con.prepareStatement(query);
	rs = ps.executeQuery();
	while (rs.next()) {
            KhachHang kh = new KhachHang(rs.getString("maKH"));
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
    
    public ArrayList<KhachHang> getListKhachHangByNameAndSDT(String tenKH, String sdt) {
	KhachHang kh = new KhachHang();
	try {
            String sql = "select * from KhachHang where tenKH LIKE CONCAT('%', ?, '%') or phone LIKE CONCAT('%', ?, '%')";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, tenKH);
            stmt.setString(2, sdt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
		kh = new KhachHang(rs.getString("maKH"));
		khachhang.add(kh);
            }

	} catch (SQLException ex) {
            ex.printStackTrace();
        }
	return khachhang;
    }
    
    public KhachHang getKhachHangEmail(String email) {
        KhachHang kh = new KhachHang();
	try {
            String query = "select * from KhachHang where email =?";

            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
		kh = new KhachHang(rs.getString("maKH"));
		return kh;
            }
	} catch (SQLException e) {
            System.out.println(e.getMessage());
	}
	return null;
    }
    
    public int capNhatKhachHang(KhachHang kh) {
	String sql = "UPDATE KhachHang SET tenKH = ?, gioiTinh = ?, ngaySinh = ?, phone = ?, diaChi = ?, email = ? WHERE maKH = ?";
	try {
            ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getHoTenKH());
            ps.setBoolean(3, kh.isGioiTinh());
                
            int day = kh.getNgaySinh().getDayOfMonth();
            int month = kh.getNgaySinh().getMonthValue();
            int year = kh.getNgaySinh().getYear();
                
            ps.setString(4, year + "/" + month + "/" + day );
            ps.setString(5, kh.getSDT());
            ps.setString(6, kh.getDiaChi());
            ps.setString(7, kh.getEmail());

            return ps.executeUpdate();
	} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
	return 1;
    }
    
    public int xoaKhachHang(String maKH) {
	String query = "delete from KhachHang where maKH = ?";
	try {
            ps = con.prepareStatement(query);
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            return ps.executeUpdate();
	} catch (SQLException e) {
            e.printStackTrace();
	}
	return 1;		
    }
    
    
    //Bình
	public KhachHang getKhachHangTheoMa(String maKH) throws SQLException {
		// System.out.println(maNV);
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
	public KhachHang getKhachHangTheoSDT(String sDT) throws SQLException {
		// System.out.println(maNV);
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
	//Bình
}
