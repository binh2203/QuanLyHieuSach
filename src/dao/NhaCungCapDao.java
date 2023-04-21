package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.DBConnection;
import entity.NhaCungCap;
public class NhaCungCapDao {
	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs;
	private String query;
	private int rsCheck;
	
	public NhaCungCapDao() {
		// TODO Auto-generated constructor stub
		DBConnection connection = DBConnection.getInstance();
		con = connection.getConnection();
	}
	
	public ArrayList<NhaCungCap> getListNhaCungCap(String loaiSanPham) throws Exception {
		ArrayList<NhaCungCap> list = new ArrayList<>();
		query = "SELECT distinct NhaCungCap.maNCC, NhaCungCap.tenNCC\r\n"
				+ "FROM NhaCungCap INNER JOIN SanPham ON NhaCungCap.maNCC = SanPham.maNCC\r\n"
				+ "where SanPham.loaiSP like ?";
		ps = con.prepareStatement(query);
		ps.setString(1, loaiSanPham);
		rs = ps.executeQuery();
		while (rs.next()) {
			NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("maNCC"), rs.getString("tenNCC"));
			list.add(nhaCungCap);
		}
		return list;
	}
	
	public boolean themNhaCungCap(NhaCungCap t) throws Exception {
		query = "INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [email], [phone]) VALUES (?, ?, ?, ?)";
		ps = con.prepareStatement(query);
		ps.setString(1, t.getMaNhaCungCap());
		ps.setString(2, t.getTenNhaCungCap());
		ps.setString(3, t.getEmail());
		ps.setString(4, t.getSdt());
		rsCheck = ps.executeUpdate();
		if (rsCheck != 0)
			return true;
		return false;
	}
	
	public ArrayList<NhaCungCap> getAllListNhaCungCap() throws Exception {
		ArrayList<NhaCungCap> list = new ArrayList<>();
		query = "select maNCC, tenNCC,  email, phone from NhaCungCap \r\n";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("maNCC"), rs.getString("tenNCC"),
					rs.getString("email"), rs.getString("phone"));
			list.add(nhaCungCap);
		}
		return list;
	}
	
	public NhaCungCap timNhaCungCap(String tenNCC) throws SQLException {
		query = "select * from NhaCungCap where tenNCC = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, tenNCC);
		rs = ps.executeQuery();
		while (rs.next()) {
			return new NhaCungCap(rs.getString("maNCC"), rs.getString("tenNCC"));
		}
		return null;
	}
	
	public boolean kiemTraTonTaiNCC(String tenNCC) throws SQLException {
		query = "select * from NhaCungCap where tenNCC = N'"+tenNCC+"'";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;
	}
	
}
