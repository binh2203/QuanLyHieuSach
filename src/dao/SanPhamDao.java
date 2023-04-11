package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.DBConnection;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.Sach;
import entity.SanPham;
import entity.TacGia;

public class SanPhamDao {
	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs;
	private String query;
	//private int rsCheck;
	private TacGiaDao tacgiaDao;
	public SanPhamDao() {
		DBConnection connection = DBConnection.getInstance();
		con = connection.getConnection();
		
	}
	
	public int themSanPham(SanPham sp) {
		
		return 1;
		
	}
	
	public SanPham timSanPhamTheoMa(String maSP) throws SQLException {
		SanPham sp = new SanPham();
		String query = "Select * from SanPham where maSanPham=?";
		ps = con.prepareStatement(query);
		ps.setString(1, maSP);
		rs = ps.executeQuery();
		while (rs.next()) {

			String maSanPham = rs.getString("maSanPham");
			String loaiSP = rs.getString("loaiSP");
			int soLuongTon = rs.getInt("soLuongTon");
			NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
			long giaNhap = rs.getLong("giaNhap");
			long giaBan = rs.getLong("giaBan");
			String donVi = rs.getString("soLuongTon");
			sp = new SanPham(maSanPham, ncc, loaiSP, soLuongTon, donVi, giaNhap,giaBan);

			return sp;
		}
		return null;
	}
	
	public Sach getSachTheoMaSP(String maSP) throws SQLException {
		Sach s = new Sach();
		String query = "Select * from SanPham where maSanPham=?";
		ps = con.prepareStatement(query);
		ps.setString(1, maSP);
		rs = ps.executeQuery();
		while (rs.next()) {
			String maSanPham = rs.getString("maSanPham");
			String loaiSP = rs.getString("loaiSP");
			int soLuongTon = rs.getInt("soLuongTon");
			NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
			long giaNhap = rs.getLong("giaNhap");
			long giaBan = rs.getLong("giaBan");
			String donVi = rs.getString("soLuongTon");
			String tenSach = rs.getString("tenSach");
			TacGia tacGia = new TacGia(rs.getString("maTacGia"));
			NhaXuatBan nhaXuatBan = new NhaXuatBan(rs.getString("maNXB"));
			String theLoaiSach = rs.getString("theLoai");
			s = new Sach(maSanPham, ncc, loaiSP, soLuongTon, donVi, giaNhap,giaBan,tenSach,tacGia,nhaXuatBan,theLoaiSach );
			return s;
		}
		return null;
	}
	
	public String getLoaiSanPhamTheoMa() throws SQLException {
		String query = "Select loaiSanPham from SanPham where maSanPham = ?";
		ps = con.prepareStatement(query);
		ps.executeQuery();
		return null;
	}
	
	public SanPham getSanPhamTheoMa(String masp) throws SQLException {
		String query = "Select * from SanPham where maSanPham=?";
		ps = con.prepareStatement(query);
		ps.setString(1, masp);
		rs = ps.executeQuery();
		while (rs.next()) {
			SanPham sp = new SanPham(rs.getString("maSanPham"));
			return sp;
		}
		return null;
	}
	
	public ArrayList<Sach> getListSach(String maSach, String tenSP, String maTheLoai, Long giaTu, Long giaDen,
			String maTacGia, String maNXB, String maNCC, boolean hetHang) throws Exception {

		ArrayList<Sach> listSach = new ArrayList<>();
		query = "SELECT SanPham.maSanPham, SanPham.soLuongTon,SanPham.loaiSanPham, NhaCungCap.maNCC, NhaCungCap.tenNCC, SanPham.giaNhap, SanPham.ghiChu, SanPham.trongLuong, SanPham.donViSanPham, SanPham.hinhAnh, SanPham.tenSach, TacGia.maTacGia, \r\n"
				+ "                  TacGia.tenTacGia, NhaXuatBan.maNXB, NhaXuatBan.tenNXB, SanPham.namXB, SanPham.soTrang, TheLoaiSach.maTheLoai, TheLoaiSach.tenTheLoai\r\n"
				+ "FROM     SanPham INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC INNER JOIN\r\n"
				+ "                  NhaXuatBan ON SanPham.maNXB = NhaXuatBan.maNXB INNER JOIN\r\n"
				+ "                  TacGia ON SanPham.maTacGia = TacGia.maTacGia INNER JOIN\r\n"
				+ "                  TheLoaiSach ON SanPham.maTheLoai = TheLoaiSach.maTheLoai"
				+ " where maSanPham like '%" + maSach + "%' and tenSach like N'%" + tenSP
				+ "%' and SanPham.maTheLoai like '%" + maTheLoai + "%' \r\n"
				+ "	and SanPham.giaNhap > ? and SanPham.giaNhap < ? and SanPham.maTacGia like '%" + maTacGia + "%' \r\n"
				+ "	and SanPham.maNXB like '%" + maNXB + "%' and SanPham.maNCC like '%" + maNCC + "%'";
		if (hetHang) {
			query = query + " and soLuongTon = 0";
		}
		ps = con.prepareStatement(query);
		ps.setLong(1, giaTu);
		ps.setLong(2, giaDen);
		rs = ps.executeQuery();
		while (rs.next()) {
			Sach s = new Sach(rs.getString("maSanPham"), new NhaCungCap(rs.getString("maNCC"), rs.getString("tenNCC"),rs.getString("email"),rs.getString("Sdt")), rs.getString("loaiSanPham"), 
					rs.getInt("soLuongTon"),rs.getString("donVi"), rs.getLong("giaNhap"), rs.getLong("giaBan"), 
					rs.getString("tenSach"), new TacGia(rs.getString("maTacGia"), rs.getString("tenTacGia")),
					new NhaXuatBan(rs.getString("maNXB"), rs.getString("tenNXB")), rs.getString("theLoai"));
			listSach.add(s);
		}
		return listSach;
	}

	public List<Sach> getAllSach() throws Exception {
		List<Sach> dsS = new ArrayList<>();
		tacgiaDao = new TacGiaDao();
		try {
			String query = "Select * from SanPham where loaiSP=?";
			ps = con.prepareStatement(query);
			ps.setString(1, "Sách");
			rs = ps.executeQuery();
			while (rs.next()) {

				String maSanPham = rs.getString("maSP");
				int soLuongTon = rs.getInt("soLuongTon");
				String loaiSP = rs.getString("loaiSP");
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
				long giaNhap = rs.getLong("giaNhap");
				long giaBan = rs.getLong("giaBan");
				String donVi = rs.getString("donVi");
				String tenSach = rs.getString("tenSach");
				TacGia tacGia = new TacGia();
				if (rs.getString("maTG") != null) {
					tacGia = tacgiaDao.getTacGia(rs.getString("maTG")).get(0);
					
				} else {
					tacGia = null;
				}
				NhaXuatBan nhaXuatBan = new NhaXuatBan(rs.getString("maNXB"));
				String theLoai =  rs.getString("theLoai");
				Sach s = new Sach(maSanPham, ncc, loaiSP, soLuongTon, donVi, giaNhap,giaBan,tenSach,tacGia,nhaXuatBan,theLoai );
				dsS.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed");//test
		}
		return dsS;
	}
	
}
