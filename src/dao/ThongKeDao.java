package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.taskdefs.Local;

import connectDB.*;
import entity.ChiTietHoaDon;
import entity.HoaDon;

import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class ThongKeDao {

	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs;
	private String query;
	private int rsCheck;
	private List<SanPham> dsSP;
	private List<NhanVien> dsNV;
	private List<KhachHang> dsKH;
	private ArrayList<NhanVien> dsNV1;

	public ThongKeDao() {
		DBConnection connection = DBConnection.getInstance();
		con = connection.getConnection();
	}

	// public List<NhanVi>

	public List<NhanVien> getNhanVienBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		dsNV = new ArrayList<NhanVien>();
		try {
			String query = "SELECT NhanVien.maNV\r\n" + "	FROM     [CT_HoaDon] INNER JOIN\r\n"
					+ "				[HoaDon] ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "				NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
					+ "		WHERE  HoaDon.ngayLapHoaDon between  ? and ?\r\n"
					+ "		GROUP BY NhanVien.maNV\r\n"
					+ "		HAVING count(HoaDon.maHD) >= all(SELECT count(HoaDon.maHD) AS 'Tong so luong hoa don'\r\n"
					+ "			FROM     [CT_HoaDon] INNER JOIN\r\n"
					+ "					HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "					NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
					+ "			WHERE  HoaDon.ngayLapHoaDon between  ? and ?\r\n" + "	GROUP BY NhanVien.maNV)";
			ps = con.prepareStatement(query);
			int dayBD = ngayBatDau.getDayOfMonth();
			int monthBD = ngayBatDau.getMonthValue();
			int yearBD = ngayBatDau.getYear();

			ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

			int dayKT = ngayKetThuc.getDayOfMonth();
			int monthKT = ngayKetThuc.getMonthValue();
			int yearKT = ngayKetThuc.getYear();

			ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
			ps.setString(3, yearBD + "-" + monthBD + "-" + dayBD);
			ps.setString(4, yearKT + "-" + monthKT + "-" + dayKT);
			rs = ps.executeQuery();

			while (rs.next()) {
				String maNV = rs.getString(1);
				NhanVien nhanVien = new NhanVien(maNV);
				dsNV.add(nhanVien);

			}
			return dsNV;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SanPham> getSanPhamBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		dsSP = new ArrayList<SanPham>();
		try {
			String query = "SELECT SanPham.maSP\r\n" + "FROM     [CT_HoaDon] INNER JOIN\r\n"
					+ "HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "					                SanPham ON [CT_HoaDon].maSP = SanPham.maSP\r\n"
					+ "					WHERE  HoaDon.ngayLapHoaDon BETWEEN  ? and ?\r\n"
					+ "					GROUP BY SanPham.maSP\r\n"
					+ "					HAVING SUM([CT_HoaDon].soLuong) >= ALL(SELECT  SUM([CT_HoaDon].soLuong) AS 'TongSoLuongDaBan'\r\n"
					+ "					FROM     [CT_HoaDon] INNER JOIN\r\n"
					+ "			        HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "					                SanPham ON [CT_HoaDon].maSP = SanPham.maSP\r\n"
					+ "					WHERE  HoaDon.ngayLapHoaDon BETWEEN   ? AND ?\r\n"
					+ "					GROUP BY SanPham.maSP)";

			ps = con.prepareStatement(query);
			int dayBD = ngayBatDau.getDayOfMonth();
			int monthBD = ngayBatDau.getMonthValue();
			int yearBD = ngayBatDau.getYear();

			ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

			int dayKT = ngayKetThuc.getDayOfMonth();
			int monthKT = ngayKetThuc.getMonthValue();
			int yearKT = ngayKetThuc.getYear();

			ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
			ps.setString(3, yearBD + "-" + monthBD + "-" + dayBD);
			ps.setString(4, yearKT + "-" + monthKT + "-" + dayKT);

			rs = ps.executeQuery();

			while (rs.next()) {
				String maSanPham = rs.getString(1);
				SanPham sanPham = new SanPham(maSanPham);
				dsSP.add(sanPham);

			}
			return dsSP;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getSoLuongSachTon() throws SQLException {
		int soLuongTon = 0;
		String query = "SELECT SUM(soLuongTon)\r\n" + "  FROM SanPham\r\n" + "  WHERE loaiSP LIKE N'Sách'";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			soLuongTon = rs.getInt("");
			return soLuongTon;
		}
		return 0;
	}

	public int getSoLuongVPPTon() throws SQLException {
		int soLuongTon = 0;
		String query = "SELECT SUM(soLuongTon)\r\n" + "  FROM SanPham\r\n"
				+ "  WHERE loaiSP LIKE N'VPP'";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			soLuongTon = rs.getInt("");
			return soLuongTon;
		}
		return 0;
	}

	public int getSoLuongSachLoi() throws SQLException {
		int soLuongTon = 0;
		String query = "SELECT SUM(soLuongLoi)\r\n" + "  FROM SachLoi\r\n";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			soLuongTon = rs.getInt("");
			return soLuongTon;
		}
		return 0;
	}

	public int getSoLuongHoaDon(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		int soLuongHoaDon = 0;
		String query = "SELECT COUNT(*)\r\n" + "from HoaDon\r\n" + "WHERE  HoaDon.ngayLapHoaDon between ? and ?";
		ps = con.prepareStatement(query);

		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
		rs = ps.executeQuery();
		while (rs.next()) {
			soLuongHoaDon = rs.getInt("");
			return soLuongHoaDon;
		}
		return 0;
	}

	public double getDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		double doanhThu = 0;
		String query = "SELECT SUM([CT_HoaDon].soLuong*SanPham.giaBan )\r\n"
				+ "	from [CT_HoaDon]   INNER JOIN\r\n" + "	HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD\r\n"
				+ "						INNER JOIN SanPham ON [CT_HoaDon].maSP = SanPham.maSP\r\n"
				+ "WHERE  HoaDon.ngayLapHoaDon between  ? and ?";
		ps = con.prepareStatement(query);

		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
		rs = ps.executeQuery();
		while (rs.next()) {
			doanhThu = rs.getDouble("");
			return doanhThu;
		}
		return 0;
	}

	public List<KhachHang> getKhachHangMuaNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		dsKH = new ArrayList<KhachHang>();
		try {
			String query = "SELECT KhachHang.maKH\r\n" + "	FROM     [CT_HoaDon] INNER JOIN\r\n"
					+ "	HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "	KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
					+ "			WHERE  HoaDon.ngayLapHoaDon between ? and ?\r\n"
					+ "	GROUP BY KhachHang.maKH\r\n"
					+ "	HAVING count(HoaDon.maHD) >= all(SELECT count(HoaDon.maHD) AS 'Tong so luong hoa don'\r\n"
					+ "	FROM     [CT_HoaDon] INNER JOIN\r\n"
					+ "			HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "			KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
					+ "	WHERE  HoaDon.ngayLapHoaDon between  ? and ?\r\n" + "	GROUP BY KhachHang.maKH)";

			ps = con.prepareStatement(query);
			int dayBD = ngayBatDau.getDayOfMonth();
			int monthBD = ngayBatDau.getMonthValue();
			int yearBD = ngayBatDau.getYear();

			ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

			int dayKT = ngayKetThuc.getDayOfMonth();
			int monthKT = ngayKetThuc.getMonthValue();
			int yearKT = ngayKetThuc.getYear();

			ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
			ps.setString(3, yearBD + "-" + monthBD + "-" + dayBD);
			ps.setString(4, yearKT + "-" + monthKT + "-" + dayKT);
			rs = ps.executeQuery();

			while (rs.next()) {
				String maKH = rs.getString(1);
				KhachHang khachHang = new KhachHang(maKH);
				dsKH.add(khachHang);

			}
			return dsKH;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getSoLuongBanCuaSanPhamChayNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		int soLuongBan = 0;
		String query = "select top(1) sum([CT_HoaDon].soLuong) AS TotalQuantity\r\n"
				+ "from SanPham inner join [CT_HoaDon] on SanPham.maSP = [CT_HoaDon].maSP inner join HoaDon on HoaDOn.maHD = [CT_HoaDon].maHD\r\n"
				+ "where HoaDon.ngayLapHoaDon between  ? and ?\r\n" + "group by SanPham.maSP ORDER BY TotalQuantity DESC ";

		ps = con.prepareStatement(query);
		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);

		rs = ps.executeQuery();
		while (rs.next()) {
			soLuongBan = rs.getInt("TotalQuantity");
			return soLuongBan;
		}
		return 0;

	}

	public double getTongTienCuaKhachHangTop1(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		double tongTien = 0;
		String query = "SELECT top(1) sum([CT_HoaDon].soLuong*SanPham.giaBan)\r\n"
				+ "	FROM     [CT_HoaDon] INNER JOIN\r\n"
				+ "	HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
				+ "	SanPham ON [CT_HoaDon].maSP = SanPham.maSP INNER JOIN\r\n"
				+ "	KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "			WHERE  HoaDon.ngayLapHoaDon between  ? and ?\r\n" + "	GROUP BY KhachHang.maKH \r\n"
				+ "	order by sum([CT_HoaDon].soLuong*SanPham.giaBan) desc";
		ps = con.prepareStatement(query);
		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);

		rs = ps.executeQuery();
		while (rs.next()) {
			tongTien = rs.getDouble("");
			return tongTien;
		}
		return 0;
	}

	public int getSoLuongHoaDonCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)
			throws SQLException {
		int soLuong;
		String query = "SELECT  count(HoaDon.maHD)\r\n" + "	FROM     HoaDon INNER JOIN\r\n"
				+ "	KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n" + "	\r\n"
				+ "			WHERE  HoaDon.ngayLapHoaDon between  ? and ? and KhachHang.maKH =?\r\n"
				+ "	GROUP BY KhachHang.maKH";
		ps = con.prepareStatement(query);

		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
		ps.setString(3, maKH);
		rs = ps.executeQuery();
		while (rs.next()) {
			soLuong = rs.getInt("");
			return soLuong;
		}
		return 0;
	}

	public double getTongTienCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)
			throws SQLException {
		double tongTien = 0;
		String query = "SELECT  sum([CT_HoaDon].soLuong*SanPham.giaBan)\r\n"
				+ "	FROM     [CT_HoaDon] INNER JOIN\r\n"
				+ "	HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
				+ "	SanPham ON [CT_HoaDon].maSP = SanPham.maSP INNER JOIN\r\n"
				+ "	KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "			WHERE  HoaDon.ngayLapHoaDon between  ? and ? and KhachHang.maKH =?\r\n"
				+ "	GROUP BY KhachHang.maKH ";
		ps = con.prepareStatement(query);
		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
		ps.setString(3, maKH);
		rs = ps.executeQuery();
		while (rs.next()) {
			tongTien = rs.getDouble("");
			return tongTien;
		}
		return 0;
	}



	public double getDoanhThuTheoMaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maNV)
			throws SQLException {
		double tongTien = 0;
		String query = "SELECT SUM([CT_HoaDon].soLuong*SanPham.giaBan)\r\n"
				+ "	from [CT_HoaDon]   INNER JOIN\r\n"
				+ "	SanPham ON [CT_HoaDon].maSP = SanPham.maSP INNER JOIN\r\n" 
				+ "	HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD\r\n"
				+ "WHERE  HoaDon.ngayLapHoaDon between  ? and ? and HoaDon.maNV=?";
		ps = con.prepareStatement(query);
		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
		ps.setString(3, maNV);
		rs = ps.executeQuery();
		while (rs.next()) {
			tongTien = rs.getDouble("");
			return tongTien;
		}
		return 0;
	}

	public int getSoLuongHoaDonTheoMaNV(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maNV) throws SQLException {
		int soLuongHoaDon = 0;
		String query = "SELECT count(DISTINCT HoaDon.maHD)\r\n" + "	from [CT_HoaDon]   INNER JOIN\r\n"
				+ "	HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD\r\n"
				+ "WHERE  HoaDon.ngayLapHoaDon between  ? and ? and HoaDon.maNV=?";
		ps = con.prepareStatement(query);
		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
		ps.setString(3, maNV);
		rs = ps.executeQuery();
		while (rs.next()) {
			soLuongHoaDon = rs.getInt("");
			return soLuongHoaDon;
		}
		return 0;
	}

	public List<NhanVien> getDoanhThuCuaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		dsNV = new ArrayList<NhanVien>();
		try {
			String query = "select NhanVien.maNV \r\n"
					+ "from NhanVien join HoaDon on NhanVien.maNV = HoaDon.maNV";

			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				NhanVien nhanVien = new NhanVien(maNV);
				dsNV.add(nhanVien);
				return dsNV;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<NhanVien> thongKeDoanhThu10NVBanNhieuNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc){
		dsNV1 = new ArrayList<NhanVien>();
		try {
		String query= "SELECT  top(10)      NhanVien.maNV, sum([SanPham].giaBan*[CT_HoaDon].soLuong)\r\n"
				+ "FROM            NhanVien INNER JOIN\r\n"
				+ "                         HoaDon ON NhanVien.maNV = HoaDon.maNV INNER JOIN\r\n"
				+ "                         [CT_HoaDon] ON HoaDon.maHD = [CT_HoaDon].maHD INNER JOIN \r\n"
				+ "							SanPham ON [CT_HoaDon].maSP = SanPham.maSP \r\n"
				+ "WHERE  HoaDon.ngayLapHoaDon BETWEEN ? AND ?\r\n"
				+ "group by NhanVien.maNV\r\n"
				+ "order by sum([SanPham].giaBan*[CT_HoaDon].soLuong) desc";
		
		ps = con.prepareStatement(query);
		int dayBD = ngayBatDau.getDayOfMonth();
		int monthBD = ngayBatDau.getMonthValue();
		int yearBD = ngayBatDau.getYear();

		ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

		int dayKT = ngayKetThuc.getDayOfMonth();
		int monthKT = ngayKetThuc.getMonthValue();
		int yearKT = ngayKetThuc.getYear();

		ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			String maNV = rs.getString(1);
			NhanVien nhanVien = new NhanVien(maNV);
			dsNV1.add(nhanVien);
		}
		return dsNV1;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
	
	
	public List<KhachHang> getTop10KHThanThiet(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		dsKH = new ArrayList<KhachHang>();
		try {
			String query = "SELECT top(10) KhachHang.maKH, sum([CT_HoaDon].soLuong*[SanPham].giaBan)\r\n"
					+ "	FROM     [CT_HoaDon] INNER JOIN\r\n"
					+ "	HoaDon ON [CT_HoaDon].maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "	SanPham ON [CT_HoaDon].maSP = SanPham.maSP INNER JOIN\r\n"
					+ "	KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
					+ "			WHERE  HoaDon.ngayLapHoaDon between  ? and ?\r\n"
					+ "	GROUP BY KhachHang.maKH\r\n"
					+ "	order by sum([CT_HoaDon].soLuong*[SanPham].giaBan) desc";

			ps = con.prepareStatement(query);
			int dayBD = ngayBatDau.getDayOfMonth();
			int monthBD = ngayBatDau.getMonthValue();
			int yearBD = ngayBatDau.getYear();

			ps.setString(1, yearBD + "-" + monthBD + "-" + dayBD);

			int dayKT = ngayKetThuc.getDayOfMonth();
			int monthKT = ngayKetThuc.getMonthValue();
			int yearKT = ngayKetThuc.getYear();

			ps.setString(2, yearKT + "-" + monthKT + "-" + dayKT);
			rs = ps.executeQuery();

			while (rs.next()) {
				String maKH = rs.getString(1);
				System.out.println(maKH);
				KhachHang khachHang = new KhachHang(maKH);
				dsKH.add(khachHang);

			}
			return dsKH;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
