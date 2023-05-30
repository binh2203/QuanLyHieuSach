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
import entity.PhieuDatHang;

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
		List<HoaDon> dsHD = new ArrayList<>();
		String query = "Select * from HoaDon";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			KhachHangDao kh = new KhachHangDao();
			NhanVienDao nv = new NhanVienDao();
			HoaDon hd = new HoaDon();
			hd.setMaHD(rs.getString("maHD"));
			hd.setNhanVien(nv.timNhanVienTheoMa(rs.getString("maNV")));
			hd.setKhachHang(kh.getKhachHangTheoMa(rs.getString("maKH")));
			hd.setNgayLapHD(rs.getDate("ngayLapHoaDon").toLocalDate());
			hd.setTienKhachDua(rs.getFloat("tienKhachDua"));
			hd.setTrangThai(rs.getBoolean("trangThai"));		
			dsHD.add(hd);
		}
		return dsHD;
	}
    
    public int themHoaDon(HoaDon hd) throws SQLException {
		String sql = "Insert into HoaDon values (?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, hd.getMaHD());
		stmt.setString(2, hd.getNhanVien().getMaNV());
		stmt.setString(3, hd.getKhachHang().getMaKH());
		int day = hd.getNgayLapHD().getDayOfMonth();
		int month = hd.getNgayLapHD().getMonthValue();
		int year = hd.getNgayLapHD().getYear();
		stmt.setString(4, year + "-" + month + "-" + day);
		stmt.setFloat(5, hd.getTienKhachDua());
		stmt.setBoolean(6,hd.isTrangThai());
		stmt.executeUpdate();
		return 1;
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
    
    public List<HoaDon> timDsHoaDon(HoaDon hd) throws SQLException {
		List<HoaDon> dsPDH = new ArrayList<>();
		int tt = 0;
		if(hd.isTrangThai())
			tt = 1;
		String query = "select maHD, NhanVien.tenNV, KhachHang.tenKH, KhachHang.phone, ngayLapHoaDon, tienKhachDua, trangThai\r\n"
				+ "from HoaDon  \r\n"
				+ "	join NhanVien on NhanVien.maNV = HoaDon.maNV\r\n"
				+ "	join KhachHang on KhachHang.maKH = HoaDon.maKH\r\n"
				+ "where  maHD  like concat('%', ? ,'%') \r\n"
				+ "	and NhanVien.tenNV like concat('%', ? ,'%')\r\n"
				+ "	and KhachHang.tenKH like concat('%', ? ,'%') \r\n"
				+ "	and KhachHang.phone like concat('%', ?,'%')\r\n"
				+ "	and ngayLapHoaDon like concat('%', ? ,'%') \r\n"
				+ " and tienKhachDua like concat('%', ? , '%')"
				+ "	and trangThai = ?\r\n"
				+ "group by HoaDon.maHD, NhanVien.tenNV, KhachHang.tenKH, KhachHang.phone, ngayLapHoaDon, tienKhachDua,trangThai\r\n";
		ps = con.prepareStatement(query);
		ps.setString(1, hd.getMaHD());
		ps.setString(2, hd.getNhanVien().getHoTenNV());
		ps.setString(3, hd.getKhachHang().getHoTenKH());
		ps.setString(4, hd.getKhachHang().getSDT());
		if(hd.getNgayLapHD() == null)
			ps.setString(5, null);
		else {
			int day = hd.getNgayLapHD().getDayOfMonth();
			String dayString;
			String monthString;
			if(day < 10) 
				dayString = "0" + day;
			else
				dayString = day + "";
			int month = hd.getNgayLapHD().getMonthValue();
			if(month < 10) 
				monthString = "0" + month;
			else
				monthString = month + "";
			int year = hd.getNgayLapHD().getYear();
			ps.setString(5, year + "-" + monthString + "-" + dayString);
		}
		ps.setFloat(6, hd.getTienKhachDua());
		ps.setString(7, tt + "");
		rs = ps.executeQuery();
		while (rs.next()) {
			HoaDon hd1 = new HoaDon();
			hd1.setMaHD(rs.getString("maHD"));
			hd1.setNhanVien(new NhanVien(null, rs.getString("tenNV")));
			hd1.setKhachHang(new KhachHang(null, rs.getString("tenKH"), rs.getString("phone")));
			hd1.setNgayLapHD(rs.getDate("ngayLapHoaDon").toLocalDate());
			hd1.setTienKhachDua(rs.getFloat("tienKhachDua"));
			hd.setTrangThai(rs.getBoolean("trangThai"));
			dsPDH.add(hd1);
		}
		return dsPDH;
	}
    
    public int TaoHD(HoaDon hd) throws SQLException {
		int trangThai = 0;
		if(hd.isTrangThai()) {
			trangThai = 1;
		}
		String query = "INSERT INTO HoaDon\r\n"
				+ "VALUES ('"+hd.getMaHD()+"','"
				+hd.getNhanVien().getMaNV()+"','"
				+hd.getKhachHang().getMaKH()+"','"
				+hd.getNgayLapHD()+"','"
				+hd.getTienKhachDua()+"',"+ trangThai +  ")";
		ps = con.prepareStatement(query);
		return ps.executeUpdate();
	}
    
}
