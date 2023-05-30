package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connectDB.DBConnection;
import entity.ChiTietHoaDon;

public class CTHoaDonDao {
	private Connection con;
	private PreparedStatement ps = null;
	
	public CTHoaDonDao() {
		DBConnection connection = DBConnection.getInstance();
		con = connection.getConnection();
	}

	public int TaoCTHD(ChiTietHoaDon cthd) throws SQLException {
		String query = "INSERT INTO CT_HoaDon\r\n"
				+ "VALUES ('" + cthd.getHoaDon().getMaHD()
				+ "','"+ cthd.getSanPham().getMaSanPham() +"', "+ cthd.getSoLuong() +")";
		ps = con.prepareStatement(query);
		return ps.executeUpdate();
	}
}
