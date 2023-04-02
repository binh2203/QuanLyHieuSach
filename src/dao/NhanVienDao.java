package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.DBConnection;
import entity.NhanVien;

public class NhanVienDao {
	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs;


	public NhanVienDao() {
		DBConnection connection = DBConnection.getInstance();
		con = connection.getConnection();
	}

	public int themNhanvien(NhanVien nv) throws SQLException {
		String insert = "Insert into NhanVien values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nv.getMaNV());

		int day = nv.getNgaySinhNV().getDayOfMonth();
		int month = nv.getNgaySinhNV().getMonthValue();
		int year = nv.getNgaySinhNV().getYear();

		stmt.setString(4, year + "-" + month + "-" + day);
		stmt.setString(2, nv.getHoTenNV());
		stmt.setBoolean(3, nv.isGioiTinh());
		stmt.setString(5, nv.getSoDienThoaiNV());
		stmt.setString(6, nv.getDiaChiNV());
		stmt.setString(7, nv.getEmailNV());
		stmt.executeUpdate();
		return 1;
	}

	public List<NhanVien> getDSNhanVien() throws SQLException {
		List<NhanVien> dsnv = new ArrayList<>();
		String query = "Select * from NhanVien";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			NhanVien nv = new NhanVien(rs.getString("manv"), rs.getString("tenNV"), rs.getBoolean("gioiTinh"),
					rs.getDate("ngaySinh").toLocalDate(), rs.getString("phone"), rs.getString("diaChi"),  rs.getString("email"));
			dsnv.add(nv);
		}
		return dsnv;
	}

	public List<NhanVien> timDanhSachNhanVienTheoMa(String maNV) throws SQLException {
		List<NhanVien> dsnv = new ArrayList<>();
		// System.out.println(maNV);
		String query = "Select * from NhanVien where maNhanVien LIKE CONCAT('%', ?, '%')";
		ps = con.prepareStatement(query);
		ps.setString(1, maNV);
		rs = ps.executeQuery();
		while (rs.next()) {
			NhanVien nv = new NhanVien(rs.getString("manv"), rs.getString("tenNV"), rs.getBoolean("gioiTinh"),
					rs.getDate("ngaySinh").toLocalDate(), rs.getString("phone"), rs.getString("diaChi"),  rs.getString("email"));
			dsnv.add(nv);

		}
		return dsnv;
	}

	public NhanVien timNhanVienTheoMa(String maNV) throws SQLException {
		// System.out.println(maNV);
		String query = "Select * from NhanVien where maNhanVien=?";
		ps = con.prepareStatement(query);
		ps.setString(1, maNV);
		rs = ps.executeQuery();
		while (rs.next()) {
			NhanVien nv = new NhanVien(rs.getString("manv"), rs.getString("tenNV"), rs.getBoolean("gioiTinh"),
					rs.getDate("ngaySinh").toLocalDate(), rs.getString("phone"), rs.getString("diaChi"),  rs.getString("email"));
			return nv;

		}
		return null;
	}

	public List<NhanVien> timDSNhanVienTheoTen(String tenNV) throws SQLException {
		List<NhanVien> dsnv = new ArrayList<>();
		String query = "select * from NhanVien where hoTenNhanVien LIKE CONCAT('%', ?, '%')";
		ps = con.prepareStatement(query);
		ps.setString(1, tenNV);
		rs = ps.executeQuery();
		while (rs.next()) {
			NhanVien nv = new NhanVien(rs.getString("manv"), rs.getString("tenNV"), rs.getBoolean("gioiTinh"),
					rs.getDate("ngaySinh").toLocalDate(), rs.getString("phone"), rs.getString("diaChi"),  rs.getString("email"));
			dsnv.add(nv);
		}
		return dsnv;
	}

	public NhanVien timNhanVienTheoTen(String tenNV) throws SQLException {
		NhanVien nv = new NhanVien();
		String query = "select * from NhanVien where hoTenNhanVien LIKE CONCAT('%', ?, '%')";
		ps = con.prepareStatement(query);
		ps.setString(1, tenNV);
		rs = ps.executeQuery();
		while (rs.next()) {
			nv = new NhanVien(rs.getString("manv"), rs.getString("tenNV"), rs.getBoolean("gioiTinh"),
					rs.getDate("ngaySinh").toLocalDate(), rs.getString("phone"), rs.getString("diaChi"),  rs.getString("email"));
			return nv;
		}
		return null;
	}

	public List<NhanVien> timNhanVienTheoSDT(String sDT) throws SQLException {
		List<NhanVien> dsnv = new ArrayList<>();
		String query = "select * from NhanVien where sdt LIKE CONCAT('%', ?, '%')";
		ps = con.prepareStatement(query);
		ps.setString(1, sDT);
		rs = ps.executeQuery();
		while (rs.next()) {
			NhanVien nv = new NhanVien(rs.getString("manv"), rs.getString("tenNV"), rs.getBoolean("gioiTinh"),
					rs.getDate("ngaySinh").toLocalDate(), rs.getString("phone"), rs.getString("diaChi"),  rs.getString("email"));
			dsnv.add(nv);
		}
		return dsnv;
	}

	public List<NhanVien> getListNhanVienByNameAndSDT(String tenNV, String sdt) {
		List<NhanVien> dsnv = new ArrayList<>();
		try {
			String sql = "select * from NhanVien where hoTenNhanVien LIKE CONCAT('%', ?, '%') or sdt LIKE CONCAT('%', ?, '%')";
			ps = con.prepareStatement(sql);
			ps.setString(1, tenNV);
			ps.setString(2, sdt);
			rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien(rs.getString("manv"), rs.getString("tenNV"), rs.getBoolean("gioiTinh"),
						rs.getDate("ngaySinh").toLocalDate(), rs.getString("phone"), rs.getString("diaChi"),  rs.getString("email"));
				dsnv.add(nv);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dsnv;
	}

	public int xoaNhanVien(String maNV) {
		String query = "delete from NhanVien where maNhanVien = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, maNV);
			// rs = ps.executeQuery();
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 1;
	}

	public int suaNhanVien(NhanVien nv) {
		String sql = "UPDATE NhanVien SET tenNV = ?, gioiTinh =?, ngaySinh = ?, phone = ?,diaChi =?, email = ? WHERE maNhanVien =?";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, nv.getHoTenNV());

			int day = nv.getNgaySinhNV().getDayOfMonth();
			int month = nv.getNgaySinhNV().getMonthValue();
			int year = nv.getNgaySinhNV().getYear();

			ps.setString(4, year + "-" + month + "-" + day);
			ps.setString(2, nv.getHoTenNV());
			ps.setBoolean(3, nv.isGioiTinh());
			ps.setString(5, nv.getSoDienThoaiNV());
			ps.setString(6, nv.getDiaChiNV());
			ps.setString(7, nv.getEmailNV());
			// rs = ps.executeQuery();

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public NhanVien getNhanVienByEmail(String email) {

		try {
			String query = "select *from NhanVien where email =?";

			ps = con.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien(rs.getString("manv"), rs.getString("tenNV"), rs.getBoolean("gioiTinh"),
						rs.getDate("ngaySinh").toLocalDate(), rs.getString("phone"), rs.getString("diaChi"),  rs.getString("email"));
				return nv;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

}
