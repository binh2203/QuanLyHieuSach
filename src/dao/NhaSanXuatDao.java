package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.DBConnection;
import entity.NhaSanXuat;

public class NhaSanXuatDao {
	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs;
	private String query;
	private int rsCheck;

	public NhaSanXuatDao() {
		DBConnection connection = DBConnection.getInstance();
		con = connection.getConnection();
	}

	public ArrayList<NhaSanXuat> getListNhaSanXuat() throws Exception {
		ArrayList<NhaSanXuat> list = new ArrayList<>();
		query = "SELECT maNSX, tenNSX\r\n" + "FROM   [dbo].[NhaSanXuat]";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			NhaSanXuat nhaSanXuat = new NhaSanXuat(rs.getString("maNSX"), rs.getString("tenNSX"));
			list.add(nhaSanXuat);
		}
		return list;
	}

	public List<NhaSanXuat> getNhaSanXuat(String maNhaSX) {
		List<NhaSanXuat> dsNSX = new ArrayList<NhaSanXuat>();
		try {
			String query = "Select * from [dbo].[NhaSanXuat] where maNSX = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, maNhaSX);
			rs = ps.executeQuery();
			while (rs.next()) {
				String maNSX = rs.getString("maNSX");
				String tenNSX = rs.getString("tenNSX");
				NhaSanXuat nhaSanXuat = new NhaSanXuat(maNSX, tenNSX);
				dsNSX.add(nhaSanXuat);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNSX;
	}
	
	public boolean themNhaSanXuat(NhaSanXuat x) throws Exception {
		query = "INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX]) VALUES ( ? , N'" + x.getTenNhaSX() + "')";
		ps = con.prepareStatement(query);
		ps.setString(1, x.getMaNhaSX());
		rsCheck = ps.executeUpdate();
		if (rsCheck != 0)
			return true;
		return false;
	}

	public boolean xoaNhaSanXuat(String maXuatXu) {
		return false;
	}

	public NhaSanXuat timNhaSanXuat(String NhaSanXuat) throws SQLException {
		query = "select * from NhaSanXuat where tenNSX = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, NhaSanXuat);
		rs = ps.executeQuery();
		while (rs.next()) {
			return new NhaSanXuat(rs.getString("maNSX"), rs.getString("tenNSX"));
		}
		return null;
	}
	public boolean kiemTraTonTaiNhaSanXuat(String tenNSX) throws SQLException {
		query = "select * from NhaSanXuat where tenNSX = N'"+tenNSX+"'";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;
	}
}
