package service;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.*;
public interface SanPhamService {
	
	//Sách:
	public ArrayList<Sach> getListSach(String maSach, String tenSP, String maTheLoai, Long giaTu, Long giaDen,
			String maTacGia, String maNXB, String maNCC, boolean hetHang) throws Exception;
	
	public List<Sach> getAllSach() throws Exception;
	public Sach getSachTheoTen(String ten);
	
	public Sach timSanPhamTheoMaSach(String maSach) throws Exception;
	public Sach getSachTheoMaSP(String maSP) throws SQLException;

	//Văn phòng phẩm:
	public List<VanPhongPham> getAllVPP();
	
	public ArrayList<VanPhongPham> getListVanPhongPham(String maVPP, String tenVPP, String theLoaiVPP, Long giaTu,
			Long giaDen, String maChatLieu, String maXuatXu, String maNCC, boolean hetHang) throws Exception;
	public VanPhongPham timSanPhamTheoMaVPP(String maVPP) throws Exception;
	public VanPhongPham getVPPTheoMaSP(String maSP) throws SQLException;

	public SanPham getSanPhamTheoMa(String masp) throws SQLException;
	public SanPham timSanPhamTheoMa(String maSP) throws SQLException;
	public boolean xoaSanPham(String maSP);
	public boolean capNhatSanPham(String maSP, SanPham temp) throws Exception;
	public boolean themSanPham(SanPham sanPham) throws Exception;
	public int getSoLuongSachTon() throws SQLException;
	public SanPham timSanPhamTheoMa1(String maSP);
	public String getMaSPMax() throws SQLException;
	public int capNhatSoLuongSanPham(SanPham sanPham);
	public int CapNhatSLTon(String maSP, int sLTon);

}
