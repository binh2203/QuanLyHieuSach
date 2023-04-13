/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.DBConnection;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import java.time.LocalDate;

public class HoaDonDao {
    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs;
    
    private NhanVienDao nhanVienDao = new NhanVienDao();
    private KhachHangDao khachHangDao = new KhachHangDao();
    
    public HoaDonDao(){
        DBConnection connection = DBConnection.getInstance();
        con = connection.getConnection();
    }
    
    public List<HoaDon> getDSHoaDon() throws SQLException {
	List<HoaDon> dshd = new ArrayList<>();
        HoaDon hd = new HoaDon();
	String query = "Select * from HoaDon";
	ps = con.prepareStatement(query);
	rs = ps.executeQuery();
	while (rs.next()) {
            hd = new HoaDon(rs.getString("maHD"));
            dshd.add(hd);
        }
	return dshd;
    }
    
    public int themHoaDon(HoaDon hd) throws SQLException {
	String insert = "Insert into HoaDon values (?,?,?,?,?)";
	PreparedStatement stmt = con.prepareStatement(insert);
        
	stmt.setString(1, hd.getMaHD());
	stmt.setString(2, hd.getNhanVien().getMaNV());
	stmt.setString(3, hd.getKhachHang().getMaKH());
        
	int day = hd.getNgayLapHD().getDayOfMonth();
	int month = hd.getNgayLapHD().getMonthValue();
	int year = hd.getNgayLapHD().getYear();
        
	stmt.setString(4, year + "-" + month + "-" + day);
	stmt.setDouble(5, hd.getTienKhachDua());
	stmt.executeUpdate();
	return 1;
    }
    
    public HoaDon timHoaDonTheoMa(String maHD) throws SQLException {
        HoaDon hd = null;
	String query = "Select * from HoaDon where maHD=?";
	ps = con.prepareStatement(query);
	ps.setString(1, maHD);
	rs = ps.executeQuery();
	while (rs.next()) {
           hd = new HoaDon(rs.getString("maHD"));
	}
	return hd;
    }
    
    public List<HoaDon> timHoaDonTheoTenKH(String tenKH) throws SQLException {
	List<HoaDon> dshd = new ArrayList<HoaDon>();
	String query = "select * from HoaDon \r\n"
                        +"inner join NhanVien \r\n"
			+"on HoaDon.maNV = NhanVien.maNV \r\n"
			+"inner join KhachHang \r\n"
			+"on HoaDon.maKH = KhachHang.maKH \r\n"
			+ "where KhachHang.tenKH like N'%"+ tenKH +"%'";
	ps = con.prepareStatement(query);
	rs = ps.executeQuery();
	while (rs.next()) {
            HoaDon hd = new HoaDon(rs.getString("maHD"));;
            dshd.add(hd);
			
	}
	return dshd;
    }
    
    public int xoaHoaDon(String maHD) {
	String query = "delete from HoaDon where maHD = ?";
	try {
            ps = con.prepareStatement(query);
            ps.setString(1, maHD);
            rs = ps.executeQuery();
            return ps.executeUpdate();
	} catch (SQLException e) {
            e.printStackTrace();
	}
	return 1;		
    }
    
    
}
